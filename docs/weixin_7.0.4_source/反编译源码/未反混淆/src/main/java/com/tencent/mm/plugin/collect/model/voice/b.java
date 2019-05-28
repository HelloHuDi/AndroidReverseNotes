package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import org.xwalk.core.XWalkUpdater;

public final class b {
    float JN = 1.0f;
    c kDh;
    private a kDi = new a(this, (byte) 0);
    private Thread kDj = null;
    SynthesizerNative kDk = new SynthesizerNative();
    boolean kDl = false;
    int kDm = 256000;
    byte[] kDn = new byte[this.kDm];
    @SuppressLint({"HandlerLeak"})
    Handler mHandler = new Handler() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(41025);
            if (b.this.kDh != null) {
                switch (message.what) {
                    case -1:
                        b.this.kDh.l(-203, null);
                        break;
                    case 0:
                        b.this.kDh.l(0, message.getData().getByteArray("data"));
                        AppMethodBeat.o(41025);
                        return;
                }
            }
            AppMethodBeat.o(41025);
        }
    };
    private boolean mIsInit = false;
    String mText;
    float mVolume = 1.0f;

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(41026);
            try {
                b.this.mText = b.this.mText.replaceAll("[^0-9a-zA-Z一-龥.?!,;:。？！，、；：@%&/]+", "");
                ab.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.JN));
                int readmoney = b.this.kDk.readmoney(b.this.mText.getBytes("UTF-8"), b.this.kDn, b.this.kDm, b.this.mVolume, b.this.JN);
                if (readmoney != -1) {
                    byte[] bArr = new byte[readmoney];
                    System.arraycopy(b.this.kDn, 0, bArr, 0, readmoney);
                    if (!b.this.kDl) {
                        Message obtainMessage = b.this.mHandler.obtainMessage(0);
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("data", bArr);
                        obtainMessage.setData(bundle);
                        b.this.mHandler.sendMessage(obtainMessage);
                    }
                    AppMethodBeat.o(41026);
                    return;
                }
                b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
                AppMethodBeat.o(41026);
            } catch (Exception e) {
                ab.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
                b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
                AppMethodBeat.o(41026);
            }
        }
    }

    public b() {
        AppMethodBeat.i(41027);
        AppMethodBeat.o(41027);
    }

    public final int I(String str, String str2, String str3) {
        AppMethodBeat.i(41028);
        if (this.mIsInit) {
            AppMethodBeat.o(41028);
            return 0;
        }
        ab.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", str + str2 + ".pos", str3);
        if (e.ct(str + str2 + ".pos")) {
            try {
                if (bo.isNullOrNil(str3)) {
                    System.loadLibrary("readMoney");
                } else if (e.ct(str3)) {
                    System.load(str3);
                } else {
                    AppMethodBeat.o(41028);
                    return ZipJNI.UNZ_BADZIPFILE;
                }
                try {
                    if (bo.isNullOrNil(str2)) {
                        str2 = "woman_putonghua";
                    }
                    if (this.kDk.init(str.getBytes(), str2.getBytes()) < 0) {
                        AppMethodBeat.o(41028);
                        return -201;
                    }
                    this.mIsInit = true;
                    AppMethodBeat.o(41028);
                    return 0;
                } catch (Exception e) {
                    AppMethodBeat.o(41028);
                    return -201;
                }
            } catch (Throwable th) {
                ab.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", th.getClass().getSimpleName(), th.getMessage());
                AppMethodBeat.o(41028);
                return -207;
            }
        }
        AppMethodBeat.o(41028);
        return XWalkUpdater.ERROR_SET_VERNUM;
    }

    public final int start(String str) {
        AppMethodBeat.i(41029);
        if (!this.mIsInit) {
            AppMethodBeat.o(41029);
            return -202;
        } else if (this.kDj != null && this.kDj.isAlive()) {
            AppMethodBeat.o(41029);
            return -202;
        } else if (str == null || str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            AppMethodBeat.o(41029);
            return ZipJNI.UNZ_PARAMERROR;
        } else {
            this.mText = str;
            this.kDl = false;
            this.kDj = new Thread(this.kDi);
            this.kDj.start();
            AppMethodBeat.o(41029);
            return 0;
        }
    }

    public final void destroy() {
        AppMethodBeat.i(41030);
        this.kDl = true;
        if (this.kDj != null) {
            try {
                this.kDj.join();
            } catch (InterruptedException e) {
                ab.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
            }
        }
        this.kDk.release();
        this.mIsInit = false;
        AppMethodBeat.o(41030);
    }
}
