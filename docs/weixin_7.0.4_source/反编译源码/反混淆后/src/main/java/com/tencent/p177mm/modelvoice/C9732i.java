package com.tencent.p177mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C37482b;
import com.tencent.p177mm.audio.p1457c.C32313a;
import com.tencent.p177mm.audio.p195b.C32304g;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.compatible.util.C45293b.C32474a;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelvoice.C26498d.C18718a;
import com.tencent.p177mm.modelvoice.C26498d.C26499b;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.modelvoice.i */
public final class C9732i implements C26498d {
    private static int fZD = 100;
    private static Object fZv = new Object();
    private static int fZw = -1;
    private static int fZx;
    public int cpQ;
    private C37482b fZA;
    private int fZB;
    private boolean fZC;
    private OnCompletionListener fZE;
    private OnErrorListener fZF;
    private C9734a fZn;
    private C45293b fZo;
    private C18718a fZp;
    private C26499b fZq;
    private int fZr;
    private volatile boolean fZs;
    private String fZt;
    private String fZu;
    private int fZy;
    private int fZz;
    private AudioTrack mAudioTrack;
    private String mFileName;
    public int mSampleRate;
    private volatile int mStatus;

    /* renamed from: com.tencent.mm.modelvoice.i$2 */
    class C97332 implements OnErrorListener {
        C97332() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(55794);
            C4990ab.m7416i("MicroMsg.SilkPlayer", "onError");
            if (C9732i.this.fZo != null && C9732i.this.fZC) {
                C9732i.this.fZo.mo73178Mm();
            }
            if (C9732i.this.fZq != null) {
                C9732i.this.fZq.onError();
            }
            try {
                C9732i.this.mStatus = -1;
                if (C9732i.this.mAudioTrack != null) {
                    C4990ab.m7416i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                    C9732i.this.mAudioTrack.stop();
                    C9732i.this.mAudioTrack.release();
                    C9732i.this.mAudioTrack = null;
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SilkPlayer", "setErrorListener File[" + C9732i.this.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
            }
            AppMethodBeat.m2505o(55794);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.i$a */
    class C9734a implements Runnable {

        /* renamed from: com.tencent.mm.modelvoice.i$a$1 */
        class C97351 implements Runnable {
            C97351() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55795);
                Toast.makeText(C4996ah.getContext(), "Save to: " + C9732i.this.fZA.mFilePath, 1).show();
                AppMethodBeat.m2505o(55795);
            }
        }

        private C9734a() {
        }

        /* synthetic */ C9734a(C9732i c9732i, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(55796);
            Process.setThreadPriority(-16);
            byte[] bArr = new byte[(AudioTrack.getMinBufferSize(C9732i.this.mSampleRate, 2, 2) * 2)];
            short g = (short) ((C9732i.this.mSampleRate * 20) / 1000);
            C4990ab.m7411d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", Short.valueOf(g), Integer.valueOf(AudioTrack.getMinBufferSize(C9732i.this.mSampleRate, 2, 2) * 2));
            C4990ab.m7416i("MicroMsg.SilkPlayer", "Thread start");
            while (true) {
                if (C9732i.this.mStatus != 1 && C9732i.this.mStatus != 2) {
                    break;
                }
                synchronized (C9732i.fZv) {
                    try {
                        if (C9732i.fZx != C9732i.this.fZy) {
                            C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", Integer.valueOf(C9732i.this.fZy), Integer.valueOf(C9732i.fZx));
                            C9732i.this.fZr = C9732i.this.fZr + 1;
                            if (C9732i.this.fZr > 3) {
                                C7060h.pYm.mo8378a(161, 17, 1, false);
                            }
                            C9732i.m17324a(C9732i.this, C9732i.this.mFileName);
                        }
                    } catch (Exception e) {
                        C7060h.pYm.mo8378a(161, 0, 1, false);
                        C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                        if (C9732i.this.fZF != null) {
                            C9732i.this.fZF.onError(null, 0, 0);
                        }
                        C9732i.this.mStatus = 0;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(55796);
                            throw th;
                        }
                    }
                }
                while (C9732i.this.fZs) {
                    C4990ab.m7410d("MicroMsg.SilkPlayer", "waitting for switching complete");
                    Thread.sleep(20);
                }
                int SilkDoDec = MediaRecorder.SilkDoDec(bArr, g);
                if (SilkDoDec < 0) {
                    C9732i.this.mStatus = 0;
                    C7060h.pYm.mo8378a(161, 0, 1, false);
                    C7060h.pYm.mo8378a(161, 4, 1, false);
                    C4990ab.m7413e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed: %d", Integer.valueOf(C9732i.this.fZy), Integer.valueOf(SilkDoDec));
                    if (C9732i.this.fZA != null && C1947ae.gjd) {
                        C9732i.this.fZA.mo60391Fg();
                    }
                } else {
                    if (C1947ae.gjd && C9732i.this.fZA != null) {
                        C9732i.this.fZA.mo60392y(bArr, g * 2);
                    }
                    try {
                        C9732i.this.mAudioTrack.write(bArr, 0, g * 2);
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.SilkPlayer", "write audio track failed: %s", e2.getMessage());
                        C7060h.pYm.mo8378a(161, 0, 1, false);
                        C7060h.pYm.mo8378a(161, 5, 1, false);
                    }
                    C9732i.this.fZz = C9732i.this.fZz + 1;
                    if (SilkDoDec == 0) {
                        C9732i.this.mStatus = 0;
                        C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] play completed", Integer.valueOf(C9732i.this.fZy));
                        if (C9732i.this.fZA != null && C1947ae.gjd) {
                            C9732i.this.fZA.mo60391Fg();
                            C5004al.m7441d(new C97351());
                        }
                    } else if (C9732i.this.mStatus == 2) {
                        synchronized (C9732i.this.fZu) {
                            try {
                                C4990ab.m7418v("MicroMsg.SilkPlayer", "before mOk.notify");
                                C9732i.this.fZu.notify();
                                C4990ab.m7418v("MicroMsg.SilkPlayer", "after mOk.notify");
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e22));
                            } catch (Throwable th2) {
                                AppMethodBeat.m2505o(55796);
                                throw th2;
                            }
                        }
                        synchronized (C9732i.this.fZt) {
                            try {
                                C4990ab.m7418v("MicroMsg.SilkPlayer", "before mpause.wait");
                                C9732i.this.fZt.wait();
                                C4990ab.m7418v("MicroMsg.SilkPlayer", "after mpause.wait");
                            } catch (Exception e222) {
                                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e222));
                            }
                        }
                    } else {
                        synchronized (C9732i.this.fZu) {
                            try {
                                C9732i.this.fZu.notify();
                            } catch (Exception e2222) {
                                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e2222));
                            }
                        }
                    }
                }
            }
            if (C9732i.this.mStatus != 3) {
                Thread.sleep(1000);
            }
            synchronized (C9732i.fZv) {
                try {
                    if (C9732i.fZx == C9732i.this.fZy) {
                        MediaRecorder.SilkDecUnInit();
                        C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", Integer.valueOf(C9732i.this.fZy));
                        C9732i.fZx = -1;
                        C9732i.this.fZr = 0;
                    }
                } catch (Throwable th22) {
                    while (true) {
                        AppMethodBeat.m2505o(55796);
                        throw th22;
                    }
                }
            }
            if (C9732i.this.mStatus != 3) {
                if (C9732i.this.fZp != null) {
                    C9732i.this.fZp.mo33981EA();
                }
                if (C9732i.this.fZE != null) {
                    C9732i.this.fZE.onCompletion(null);
                    AppMethodBeat.m2505o(55796);
                    return;
                }
            } else if (C9732i.this.mAudioTrack != null) {
                C4990ab.m7416i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                C9732i.this.mAudioTrack.stop();
                C9732i.this.mAudioTrack.release();
                C9732i.this.mAudioTrack = null;
            }
            AppMethodBeat.m2505o(55796);
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.i$1 */
    class C97361 implements OnCompletionListener {
        C97361() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(55793);
            if (C9732i.this.fZo != null && C9732i.this.fZC) {
                C4990ab.m7416i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
                C9732i.this.fZo.mo73178Mm();
            }
            try {
                C9732i.this.mStatus = 0;
                if (C9732i.this.mAudioTrack != null) {
                    C4990ab.m7416i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                    C9732i.this.mAudioTrack.stop();
                    C9732i.this.mAudioTrack.release();
                    C9732i.this.mAudioTrack = null;
                }
                AppMethodBeat.m2505o(55793);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                C4990ab.m7412e("MicroMsg.SilkPlayer", "setCompletion File[" + C9732i.this.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                AppMethodBeat.m2505o(55793);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(55815);
        AppMethodBeat.m2505o(55815);
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public C9732i() {
        AppMethodBeat.m2504i(55797);
        this.fZp = null;
        this.fZq = null;
        this.cpQ = 2;
        this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.fZr = 0;
        this.fZs = false;
        this.fZt = "";
        this.fZu = "";
        this.fZz = 0;
        this.fZA = null;
        this.fZB = 8;
        this.fZC = true;
        this.fZE = new C97361();
        this.fZF = new C97332();
        fZw++;
        this.fZy = fZw;
        C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] new Instance", Integer.valueOf(this.fZy));
        AppMethodBeat.m2505o(55797);
    }

    public C9732i(Context context) {
        this();
        AppMethodBeat.m2504i(55798);
        this.fZo = new C45293b(context);
        AppMethodBeat.m2505o(55798);
    }

    /* renamed from: a */
    public final void mo21076a(C18718a c18718a) {
        this.fZp = c18718a;
    }

    /* renamed from: a */
    public final void mo21077a(C26499b c26499b) {
        this.fZq = c26499b;
    }

    /* renamed from: bo */
    public final void mo21082bo(boolean z) {
        AppMethodBeat.m2504i(55799);
        C4990ab.m7411d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", Boolean.valueOf(z));
        this.fZs = true;
        this.cpQ = 2;
        m17327cZ(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e) {
            C7060h.pYm.mo8378a(161, 0, 1, false);
            C7060h.pYm.mo8378a(161, 3, 1, false);
            C4990ab.m7413e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
        }
        this.fZs = false;
        AppMethodBeat.m2505o(55799);
    }

    /* renamed from: cZ */
    private void m17327cZ(boolean z) {
        AppMethodBeat.m2504i(55800);
        if (this.mAudioTrack != null) {
            C4990ab.m7416i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e.getMessage());
            }
            this.mAudioTrack = null;
        }
        this.mAudioTrack = C32313a.m52809a(z, this.mSampleRate, this.cpQ, this.fZB);
        if (this.mAudioTrack == null || this.mAudioTrack.getState() == 0) {
            C7060h.pYm.mo8378a(161, 0, 1, false);
            C7060h.pYm.mo8378a(161, 2, 1, false);
            try {
                if (this.mAudioTrack != null) {
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
                AppMethodBeat.m2505o(55800);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(55800);
    }

    /* renamed from: S */
    public final boolean mo21075S(String str, boolean z) {
        AppMethodBeat.m2504i(55801);
        boolean T = m17321T(str, z);
        AppMethodBeat.m2505o(55801);
        return T;
    }

    /* renamed from: c */
    public final boolean mo21083c(String str, boolean z, int i) {
        AppMethodBeat.m2504i(55802);
        boolean T = m17321T(str, z);
        AppMethodBeat.m2505o(55802);
        return T;
    }

    /* renamed from: T */
    private boolean m17321T(String str, boolean z) {
        int i = 2;
        AppMethodBeat.m2504i(55803);
        if (this.mStatus != 0) {
            C4990ab.m7412e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            AppMethodBeat.m2505o(55803);
            return false;
        }
        boolean da;
        if (C1947ae.gjd) {
            mo21078aX(str, C32304g.cqr);
        }
        C4990ab.m7416i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (fZv) {
            try {
                m17346uH(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55803);
                }
            }
        }
        if (C1947ae.gjd) {
            int i2;
            String str2 = C32304g.cqq;
            if (this.cpQ == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.fZA = new C37482b(str2, i2, this.mSampleRate);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.cpQ == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        C4990ab.m7411d(str3, str4, objArr);
        try {
            da = m17329da(z);
        } catch (Exception e) {
            try {
                da = m17329da(true);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                this.mStatus = -1;
                AppMethodBeat.m2505o(55803);
                return false;
            }
        }
        AppMethodBeat.m2505o(55803);
        return da;
    }

    /* renamed from: uH */
    private void m17346uH(String str) {
        int available;
        AppMethodBeat.m2504i(55804);
        fZx = this.fZy;
        C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", Integer.valueOf(this.fZy));
        try {
            InputStream openRead = C5730e.openRead(str);
            available = openRead.available();
            C4990ab.m7411d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", Integer.valueOf(available));
            int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2;
            if (!C1407g.m2946KK().mo4819KP() || available >= minBufferSize) {
                this.fZB = 8;
            } else {
                this.fZB = 1;
            }
            byte[] bArr = new byte[available];
            openRead.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            C4990ab.m7416i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit())));
            MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
            available = -1;
            C5141c ll = C18624c.abi().mo17131ll("100268");
            if (ll.isValid()) {
                available = C5046bo.getInt((String) ll.dru().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == available || available == 0) {
                MediaRecorder.SetVoiceSilkDecControl(fZD, new byte[]{(byte) available}, 1);
            }
            openRead.close();
        } catch (Exception e) {
            C7060h.pYm.mo8378a(161, 0, 1, false);
            C7060h.pYm.mo8378a(161, 1, 1, false);
            C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
        }
        C4990ab.m7411d("MicroMsg.SilkPlayer", "[%d] skip %d frames", Integer.valueOf(this.fZy), Integer.valueOf(this.fZz));
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (available = 0; available < this.fZz; available++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                C4990ab.m7413e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", Integer.valueOf(this.fZy), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s)));
                AppMethodBeat.m2505o(55804);
                return;
            }
        }
        AppMethodBeat.m2505o(55804);
    }

    /* renamed from: da */
    private boolean m17329da(boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(55805);
        if (C5730e.m8628ct(this.mFileName)) {
            try {
                m17327cZ(z);
                if (this.mAudioTrack != null) {
                    if (this.fZo != null && this.fZC) {
                        this.fZo.requestFocus();
                    }
                    z2 = alT();
                    AppMethodBeat.m2505o(55805);
                }
            } catch (Exception e) {
                if (this.fZo != null && this.fZC) {
                    this.fZo.mo73178Mm();
                }
                C4990ab.m7412e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e.getMessage());
                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
            }
            AppMethodBeat.m2505o(55805);
        } else {
            AppMethodBeat.m2505o(55805);
        }
        return z2;
    }

    private boolean alT() {
        AppMethodBeat.m2504i(55806);
        if (this.mAudioTrack != null) {
            try {
                C4990ab.m7416i("MicroMsg.SilkPlayer", "play");
                this.mAudioTrack.play();
                this.fZn = new C9734a(this, (byte) 0);
                C7305d.m12298f(this.fZn, "SilkPlayer_play_" + this.fZy);
                AppMethodBeat.m2505o(55806);
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
                C7060h.pYm.mo8378a(161, 0, 1, false);
                C7060h.pYm.mo8378a(161, 3, 1, false);
                AppMethodBeat.m2505o(55806);
                return false;
            }
        }
        AppMethodBeat.m2505o(55806);
        return false;
    }

    /* renamed from: bn */
    public final boolean mo21081bn(boolean z) {
        AppMethodBeat.m2504i(55807);
        if (this.mStatus != 1) {
            AppMethodBeat.m2505o(55807);
            return false;
        }
        this.mStatus = 2;
        synchronized (this.fZu) {
            try {
                C4990ab.m7418v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.fZu.wait();
                C4990ab.m7418v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(55807);
                return false;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55807);
                    throw th;
                }
            }
        }
        if (this.fZo != null && z) {
            this.fZo.mo73178Mm();
        }
        AppMethodBeat.m2505o(55807);
        return true;
    }

    /* renamed from: Ew */
    public final boolean mo21073Ew() {
        AppMethodBeat.m2504i(55808);
        if (this.mStatus != 2) {
            AppMethodBeat.m2505o(55808);
            return false;
        }
        this.mStatus = 1;
        synchronized (this.fZt) {
            try {
                C4990ab.m7418v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.fZt.notify();
                C4990ab.m7418v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(55808);
                return false;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55808);
                    throw th;
                }
            }
        }
        if (this.fZo != null && this.fZC) {
            this.fZo.requestFocus();
        }
        AppMethodBeat.m2505o(55808);
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    /* renamed from: EH */
    public final boolean mo21072EH() {
        AppMethodBeat.m2504i(55809);
        C4990ab.m7416i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.fZt) {
                try {
                    this.fZt.notify();
                    if (this.fZo != null && this.fZC) {
                        this.fZo.mo73178Mm();
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                    if (this.fZo != null && this.fZC) {
                        this.fZo.mo73178Mm();
                    }
                    AppMethodBeat.m2505o(55809);
                    return false;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(55809);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(55809);
            return true;
        }
        C4990ab.m7412e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        AppMethodBeat.m2505o(55809);
        return false;
    }

    /* renamed from: Ez */
    public final double mo21074Ez() {
        return 0.0d;
    }

    /* renamed from: b */
    public final void mo21080b(C32474a c32474a) {
        AppMethodBeat.m2504i(55810);
        if (!(c32474a == null || this.fZo == null)) {
            this.fZo.mo73179a(c32474a);
        }
        AppMethodBeat.m2505o(55810);
    }

    public final void alP() {
        this.fZC = false;
    }

    /* renamed from: aX */
    public final String mo21078aX(String str, String str2) {
        Exception e;
        String str3 = null;
        AppMethodBeat.m2504i(55811);
        if (this.mStatus != 0) {
            C4990ab.m7412e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            AppMethodBeat.m2505o(55811);
        } else {
            this.mStatus = 1;
            this.mFileName = str;
            InputStream openRead;
            try {
                openRead = C5730e.openRead(str);
                try {
                    int available = openRead.available();
                    byte[] bArr = new byte[available];
                    openRead.read(bArr, 0, available);
                    this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                    MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
                    C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", Integer.valueOf(this.fZy));
                    openRead.close();
                    str3 = m17347uI(str2);
                    AppMethodBeat.m2505o(55811);
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.m7413e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e.getMessage());
                    C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                    this.mStatus = -1;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(55811);
                    return str3;
                }
            } catch (Exception e4) {
                e = e4;
                openRead = str3;
            }
        }
        return str3;
    }

    /* renamed from: uI */
    private String m17347uI(String str) {
        OutputStream L;
        Exception e;
        AppMethodBeat.m2504i(55812);
        C4990ab.m7410d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl()");
        if (C5730e.m8628ct(this.mFileName)) {
            try {
                C4990ab.m7410d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread start");
                Process.setThreadPriority(-16);
                byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) << 1)];
                short s = (short) ((this.mSampleRate * 20) / 1000);
                C9732i.m17348uJ(str);
                L = C5730e.m8617L(str, false);
                while (true) {
                    if (this.mStatus != 1 && this.mStatus != 2) {
                        break;
                    }
                    int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                    if (SilkDoDec < 0) {
                        this.mStatus = 0;
                    } else {
                        while (this.fZs) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    C4990ab.m7412e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread exception: " + e.getMessage());
                                    C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e));
                                    this.mStatus = 0;
                                    if (L != null) {
                                        try {
                                            L.close();
                                        } catch (IOException e3) {
                                            C4990ab.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                                        }
                                    }
                                    AppMethodBeat.m2505o(55812);
                                    return null;
                                } catch (Exception e4) {
                                    C4990ab.m7412e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl exception: " + e4.getMessage());
                                    C4990ab.m7413e("MicroMsg.SilkPlayer", "exception:%s", C5046bo.m7574l(e4));
                                    AppMethodBeat.m2505o(55812);
                                    return null;
                                }
                            }
                        }
                        L.write(bArr, 0, s * 2);
                        L.flush();
                        if (SilkDoDec == 0) {
                            this.mStatus = 0;
                        }
                    }
                }
                C4990ab.m7410d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread end");
                L.close();
                int SilkDecUnInit = MediaRecorder.SilkDecUnInit();
                C4990ab.m7417i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit in silkToPcmImpl", Integer.valueOf(this.fZy));
                if (SilkDecUnInit != 0) {
                    C4990ab.m7412e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl res: ".concat(String.valueOf(SilkDecUnInit)));
                }
                AppMethodBeat.m2505o(55812);
                return str;
            } catch (Exception e5) {
                e4 = e5;
                L = null;
            }
        } else {
            C4990ab.m7413e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl(), file not exist, fileName = %s", this.mFileName);
            AppMethodBeat.m2505o(55812);
            return null;
        }
    }

    /* renamed from: uJ */
    private static boolean m17348uJ(String str) {
        AppMethodBeat.m2504i(55813);
        if (str == null) {
            AppMethodBeat.m2505o(55813);
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                C4990ab.m7420w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                AppMethodBeat.m2505o(55813);
                return false;
            }
            C5728b c5728b = new C5728b(str.substring(0, lastIndexOf + 1));
            if (!c5728b.exists()) {
                boolean z = c5728b.mkdirs() || c5728b.isDirectory();
                C4990ab.m7417i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", r3, Boolean.valueOf(z));
            }
            AppMethodBeat.m2505o(55813);
            return true;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", e.getMessage());
            AppMethodBeat.m2505o(55813);
            return false;
        }
    }
}
