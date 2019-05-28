package com.tencent.p177mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.collect.model.voice.b */
public final class C38809b {
    /* renamed from: JN */
    float f16164JN = 1.0f;
    C45819c kDh;
    private C11430a kDi = new C11430a(this, (byte) 0);
    private Thread kDj = null;
    SynthesizerNative kDk = new SynthesizerNative();
    boolean kDl = false;
    int kDm = 256000;
    byte[] kDn = new byte[this.kDm];
    @SuppressLint({"HandlerLeak"})
    Handler mHandler = new C338621();
    private boolean mIsInit = false;
    String mText;
    float mVolume = 1.0f;

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.b$a */
    class C11430a implements Runnable {
        private C11430a() {
        }

        /* synthetic */ C11430a(C38809b c38809b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(41026);
            try {
                C38809b.this.mText = C38809b.this.mText.replaceAll("[^0-9a-zA-Z一-龥.?!,;:。？！，、；：@%&/]+", "");
                C4990ab.m7411d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", C38809b.this.mText, Float.valueOf(C38809b.this.mVolume), Float.valueOf(C38809b.this.f16164JN));
                int readmoney = C38809b.this.kDk.readmoney(C38809b.this.mText.getBytes("UTF-8"), C38809b.this.kDn, C38809b.this.kDm, C38809b.this.mVolume, C38809b.this.f16164JN);
                if (readmoney != -1) {
                    byte[] bArr = new byte[readmoney];
                    System.arraycopy(C38809b.this.kDn, 0, bArr, 0, readmoney);
                    if (!C38809b.this.kDl) {
                        Message obtainMessage = C38809b.this.mHandler.obtainMessage(0);
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("data", bArr);
                        obtainMessage.setData(bundle);
                        C38809b.this.mHandler.sendMessage(obtainMessage);
                    }
                    AppMethodBeat.m2505o(41026);
                    return;
                }
                C38809b.this.mHandler.sendMessage(C38809b.this.mHandler.obtainMessage(-1));
                AppMethodBeat.m2505o(41026);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
                C38809b.this.mHandler.sendMessage(C38809b.this.mHandler.obtainMessage(-1));
                AppMethodBeat.m2505o(41026);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.b$1 */
    class C338621 extends Handler {
        C338621() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(41025);
            if (C38809b.this.kDh != null) {
                switch (message.what) {
                    case -1:
                        C38809b.this.kDh.mo45529l(-203, null);
                        break;
                    case 0:
                        C38809b.this.kDh.mo45529l(0, message.getData().getByteArray("data"));
                        AppMethodBeat.m2505o(41025);
                        return;
                }
            }
            AppMethodBeat.m2505o(41025);
        }
    }

    public C38809b() {
        AppMethodBeat.m2504i(41027);
        AppMethodBeat.m2505o(41027);
    }

    /* renamed from: I */
    public final int mo61680I(String str, String str2, String str3) {
        AppMethodBeat.m2504i(41028);
        if (this.mIsInit) {
            AppMethodBeat.m2505o(41028);
            return 0;
        }
        C4990ab.m7411d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", str + str2 + ".pos", str3);
        if (C5730e.m8628ct(str + str2 + ".pos")) {
            try {
                if (C5046bo.isNullOrNil(str3)) {
                    System.loadLibrary("readMoney");
                } else if (C5730e.m8628ct(str3)) {
                    System.load(str3);
                } else {
                    AppMethodBeat.m2505o(41028);
                    return ZipJNI.UNZ_BADZIPFILE;
                }
                try {
                    if (C5046bo.isNullOrNil(str2)) {
                        str2 = "woman_putonghua";
                    }
                    if (this.kDk.init(str.getBytes(), str2.getBytes()) < 0) {
                        AppMethodBeat.m2505o(41028);
                        return -201;
                    }
                    this.mIsInit = true;
                    AppMethodBeat.m2505o(41028);
                    return 0;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(41028);
                    return -201;
                }
            } catch (Throwable th) {
                C4990ab.m7417i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", th.getClass().getSimpleName(), th.getMessage());
                AppMethodBeat.m2505o(41028);
                return -207;
            }
        }
        AppMethodBeat.m2505o(41028);
        return XWalkUpdater.ERROR_SET_VERNUM;
    }

    public final int start(String str) {
        AppMethodBeat.m2504i(41029);
        if (!this.mIsInit) {
            AppMethodBeat.m2505o(41029);
            return -202;
        } else if (this.kDj != null && this.kDj.isAlive()) {
            AppMethodBeat.m2505o(41029);
            return -202;
        } else if (str == null || str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.m2505o(41029);
            return ZipJNI.UNZ_PARAMERROR;
        } else {
            this.mText = str;
            this.kDl = false;
            this.kDj = new Thread(this.kDi);
            this.kDj.start();
            AppMethodBeat.m2505o(41029);
            return 0;
        }
    }

    public final void destroy() {
        AppMethodBeat.m2504i(41030);
        this.kDl = true;
        if (this.kDj != null) {
            try {
                this.kDj.join();
            } catch (InterruptedException e) {
                C4990ab.m7417i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
            }
        }
        this.kDk.release();
        this.mIsInit = false;
        AppMethodBeat.m2505o(41030);
    }
}
