package com.tencent.p177mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C18171e;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.compatible.util.C45293b.C32474a;
import com.tencent.p177mm.modelvoice.C26498d.C18718a;
import com.tencent.p177mm.modelvoice.C26498d.C26499b;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.qqpinyin.voicerecoapi.C16134b;
import com.tencent.qqpinyin.voicerecoapi.C36413a;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.io.InputStream;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.modelvoice.j */
public final class C9738j implements C26498d {
    AudioTrack aQf;
    private int cIb;
    C45293b cop;
    boolean fZC;
    OnCompletionListener fZE;
    OnErrorListener fZF;
    C18718a fZI;
    C26499b fZJ;
    private int fZK;
    private int fZL;
    private Runnable fZM;
    C36413a fZN;
    private int fZO;
    int fZP;
    boolean fZQ;
    byte[] fZR;
    int fZS;
    InputStream fZT;
    int fZU;
    String fZt;
    String fZu;
    String fileName;
    private int nSamplerate;
    volatile int status;

    /* renamed from: com.tencent.mm.modelvoice.j$1 */
    class C97371 implements OnCompletionListener {
        C97371() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(55816);
            if (C9738j.this.cop != null && C9738j.this.fZC) {
                C9738j.this.cop.mo73178Mm();
            }
            try {
                C9738j.this.status = 0;
                C9738j.this.alX();
                try {
                    C9738j.m17361a(C9738j.this);
                    AppMethodBeat.m2505o(55816);
                } catch (InterruptedException e) {
                    C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(55816);
                }
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e2));
                C4990ab.m7412e("MicroMsg.SpeexPlayer", "setCompletion File[" + C9738j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                AppMethodBeat.m2505o(55816);
            }
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.j$2 */
    class C97392 implements OnErrorListener {
        C97392() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(55817);
            C4990ab.m7410d("MicroMsg.SpeexPlayer", "onError");
            if (C9738j.this.cop != null && C9738j.this.fZC) {
                C9738j.this.cop.mo73178Mm();
            }
            if (C9738j.this.fZJ != null) {
                C9738j.this.fZJ.onError();
            }
            try {
                C9738j.this.status = -1;
                C9738j.this.alX();
                try {
                    C9738j.m17361a(C9738j.this);
                } catch (InterruptedException e) {
                    C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                }
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.SpeexPlayer", "setErrorListener File[" + C9738j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
            }
            AppMethodBeat.m2505o(55817);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.j$3 */
    class C97403 implements Runnable {
        C97403() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0241  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x024f A:{SYNTHETIC, Splitter:B:132:0x024f} */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00be  */
        /* JADX WARNING: Missing block: B:127:0x0224, code skipped:
            if (r12.fZV.status == 3) goto L_0x0081;
     */
        /* JADX WARNING: Missing block: B:128:0x0226, code skipped:
            java.lang.Thread.sleep(1000);
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            int i;
            AppMethodBeat.m2504i(55818);
            try {
                C16134b c16134b;
                Process.setThreadPriority(-16);
                C9738j.this.fZT = C5730e.openRead(C9738j.this.fileName);
                while (true) {
                    if (C9738j.this.status != 1 && C9738j.this.status != 2) {
                        break;
                    }
                    C9738j.this.fZS = C9738j.this.fZT.read(C9738j.this.fZR);
                    if (C9738j.this.fZS != -1) {
                        C36413a c36413a = C9738j.this.fZN;
                        byte[] bArr = C9738j.this.fZR;
                        int i2 = C9738j.this.fZS;
                        if (c36413a.AqB != 0) {
                            if (bArr == null) {
                                break;
                            } else if (bArr.length == 0) {
                                break;
                            } else {
                                int nativeTRSpeexDecode = c36413a.AqC.nativeTRSpeexDecode(c36413a.AqB, bArr, 0, i2, c36413a.Aqz);
                                if (nativeTRSpeexDecode < 0) {
                                    c16134b = new C16134b(nativeTRSpeexDecode);
                                    AppMethodBeat.m2505o(55818);
                                    throw c16134b;
                                }
                                if (nativeTRSpeexDecode == 0) {
                                    bArr = null;
                                } else {
                                    byte[] bArr2 = new byte[nativeTRSpeexDecode];
                                    System.arraycopy(c36413a.Aqz, 0, bArr2, 0, nativeTRSpeexDecode);
                                    bArr = bArr2;
                                }
                                if (bArr == null || nativeTRSpeexDecode == 0) {
                                    C9738j.this.status = 0;
                                } else {
                                    nativeTRSpeexDecode = bArr.length;
                                    i = 0;
                                    while (nativeTRSpeexDecode >= C9738j.this.fZU && C9738j.this.status == 1) {
                                        if (C9738j.this.fZQ) {
                                            Thread.sleep(20);
                                        } else if (!(C9738j.this.aQf == null || C9738j.this.fZQ)) {
                                            C9738j.this.aQf.write(bArr, i, C9738j.this.fZU);
                                            i += C9738j.this.fZU;
                                            nativeTRSpeexDecode -= C9738j.this.fZU;
                                        }
                                    }
                                    if (nativeTRSpeexDecode < C9738j.this.fZU && nativeTRSpeexDecode > 0 && C9738j.this.aQf != null) {
                                        C9738j.this.aQf.write(bArr, i, nativeTRSpeexDecode);
                                    }
                                }
                            }
                        } else {
                            c16134b = new C16134b(ZipJNI.UNZ_PARAMERROR);
                            AppMethodBeat.m2505o(55818);
                            throw c16134b;
                        }
                    }
                    C9738j.this.status = 0;
                    if (C9738j.this.status == 2) {
                        synchronized (C9738j.this.fZu) {
                            try {
                                C4990ab.m7418v("MicroMsg.SpeexPlayer", "before mOk.notify");
                                C9738j.this.fZu.notify();
                                C4990ab.m7418v("MicroMsg.SpeexPlayer", "after mOk.notify");
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(55818);
                            }
                        }
                        synchronized (C9738j.this.fZt) {
                            try {
                                C4990ab.m7418v("MicroMsg.SpeexPlayer", "before mpause.wait");
                                C9738j.this.fZt.wait();
                                C4990ab.m7418v("MicroMsg.SpeexPlayer", "after mpause.wait");
                            } catch (Exception e2) {
                                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e2));
                            }
                        }
                    } else {
                        synchronized (C9738j.this.fZu) {
                            try {
                                C9738j.this.fZu.notify();
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e22));
                            }
                        }
                    }
                }
                c16134b = new C16134b(ZipJNI.UNZ_INTERNALERROR);
                AppMethodBeat.m2505o(55818);
                throw c16134b;
            } catch (Exception e222) {
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e222));
                if (C9738j.this.fZF != null) {
                    C9738j.this.fZF.onError(null, 0, 0);
                }
                C9738j.this.status = 0;
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(55818);
            }
            C36413a c36413a2;
            if (C9738j.this.fZT != null) {
                try {
                    C9738j.this.fZT.close();
                } catch (IOException e3) {
                    C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e3));
                }
                C9738j.this.fZT = null;
            }
            c36413a2 = C9738j.this.fZN;
            if (c36413a2.AqB != 0) {
                i = ZipJNI.UNZ_PARAMERROR;
            } else {
                c36413a2.Aqz = null;
                i = c36413a2.AqC.nativeTRSpeexDecodeRelease(c36413a2.AqB);
                c36413a2.AqB = 0;
            }
            if (C9738j.this.status == 3) {
                if (C9738j.this.fZI != null) {
                    C9738j.this.fZI.mo33981EA();
                }
                if (C9738j.this.fZE != null) {
                    C9738j.this.fZE.onCompletion(null);
                }
            } else {
                try {
                    C9738j.this.alX();
                } catch (Exception e4) {
                }
            }
            if (i != 0) {
                C4990ab.m7412e("MicroMsg.SpeexPlayer", "res: ".concat(String.valueOf(i)));
            }
            AppMethodBeat.m2505o(55818);
            if (i != 0) {
            }
            AppMethodBeat.m2505o(55818);
            C9738j.this.fZT = null;
            c36413a2 = C9738j.this.fZN;
            if (c36413a2.AqB != 0) {
            }
            if (C9738j.this.status == 3) {
            }
            if (i != 0) {
            }
            AppMethodBeat.m2505o(55818);
        }
    }

    public final int getStatus() {
        return this.status;
    }

    public C9738j() {
        int i = 0;
        AppMethodBeat.m2504i(55819);
        this.fileName = "";
        this.fZI = null;
        this.fZJ = null;
        this.status = 0;
        this.fZK = 2;
        this.nSamplerate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
        this.cIb = 1;
        this.fZL = 20;
        this.fZN = null;
        this.fZP = 0;
        this.fZQ = false;
        this.fZt = "";
        this.fZu = "";
        this.fZC = true;
        this.fZR = new byte[C36413a.MAX_FRAME_SIZE];
        this.fZS = 0;
        this.fZT = null;
        this.fZU = 314;
        this.fZE = new C97371();
        this.fZF = new C97392();
        this.fZN = new C36413a();
        C36413a c36413a = this.fZN;
        if (c36413a.AqB != 0) {
            i = ZipJNI.UNZ_BADZIPFILE;
        } else {
            int nativeTRSpeexDecodeInit = c36413a.AqC.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == XWalkUpdater.ERROR_SET_VERNUM || nativeTRSpeexDecodeInit == ZipJNI.UNZ_PARAMERROR) {
                i = nativeTRSpeexDecodeInit;
            } else {
                c36413a.AqB = nativeTRSpeexDecodeInit;
                c36413a.Aqz = new byte[(C36413a.MAX_FRAME_SIZE * 15)];
            }
        }
        if (i != 0) {
            C4990ab.m7412e("speex", "res: ".concat(String.valueOf(i)));
        }
        AppMethodBeat.m2505o(55819);
    }

    public C9738j(Context context) {
        this();
        AppMethodBeat.m2504i(55820);
        this.cop = new C45293b(context);
        AppMethodBeat.m2505o(55820);
    }

    /* renamed from: a */
    public final void mo21076a(C18718a c18718a) {
        this.fZI = c18718a;
    }

    /* renamed from: a */
    public final void mo21077a(C26499b c26499b) {
        this.fZJ = c26499b;
    }

    /* Access modifiers changed, original: final */
    public final void alX() {
        AppMethodBeat.m2504i(55821);
        if (this.aQf != null) {
            this.aQf.stop();
            this.aQf.release();
            this.aQf = null;
        }
        AppMethodBeat.m2505o(55821);
    }

    /* renamed from: bo */
    public final void mo21082bo(boolean z) {
        int i;
        AppMethodBeat.m2504i(55822);
        this.fZQ = true;
        if (this.cIb == 2) {
            this.fZK = 3;
        } else {
            this.fZK = 2;
        }
        this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
        if (this.aQf != null) {
            try {
                this.aQf.stop();
                this.aQf.release();
                this.aQf = null;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SpeexPlayer", e.getMessage());
                this.aQf = null;
            } catch (Throwable th) {
                this.aQf = null;
                AppMethodBeat.m2505o(55822);
            }
        }
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        if (C1427q.etd.epG) {
            C1427q.etd.dump();
            if (C1427q.etd.epN == 1) {
                i = 3;
            }
        }
        this.aQf = new C18171e(i, this.nSamplerate, this.fZK, this.fZO * 8);
        try {
            this.aQf.play();
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.SpeexPlayer", "audioTrack error:%s", e2.getMessage());
        }
        this.fZQ = false;
        AppMethodBeat.m2505o(55822);
    }

    /* renamed from: S */
    public final boolean mo21075S(String str, boolean z) {
        AppMethodBeat.m2504i(55823);
        boolean T = m17360T(str, z);
        AppMethodBeat.m2505o(55823);
        return T;
    }

    /* renamed from: c */
    public final boolean mo21083c(String str, boolean z, int i) {
        AppMethodBeat.m2504i(55824);
        boolean T = m17360T(str, z);
        AppMethodBeat.m2505o(55824);
        return T;
    }

    /* renamed from: T */
    private boolean m17360T(String str, boolean z) {
        AppMethodBeat.m2504i(55825);
        if (this.status != 0) {
            C4990ab.m7412e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            AppMethodBeat.m2505o(55825);
            return false;
        }
        C4990ab.m7416i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fileName = str;
        try {
            m17362db(z);
        } catch (Exception e) {
            try {
                m17362db(true);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                this.status = -1;
                AppMethodBeat.m2505o(55825);
                return false;
            }
        }
        AppMethodBeat.m2505o(55825);
        return true;
    }

    /* JADX WARNING: Missing block: B:9:0x0027, code skipped:
            if (com.tencent.p177mm.compatible.p221e.C1427q.etd.epN == 1) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: db */
    private void m17362db(boolean z) {
        int i = 3;
        AppMethodBeat.m2504i(55826);
        if (C5730e.m8628ct(this.fileName)) {
            int i2 = z ? 3 : 0;
            try {
                if (C1427q.etd.epG) {
                    C1427q.etd.dump();
                }
                i = i2;
                this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
                alX();
                this.aQf = new C18171e(i, this.nSamplerate, this.fZK, this.fZO * 8);
                this.fZU = (((this.nSamplerate / 1000) * this.cIb) * this.fZL) * 2;
                if (this.cop != null && this.fZC) {
                    this.cop.requestFocus();
                }
                alY();
                AppMethodBeat.m2505o(55826);
                return;
            } catch (Exception e) {
                if (this.cop != null && this.fZC) {
                    this.cop.mo73178Mm();
                }
                alX();
                C4990ab.m7412e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + e.getMessage());
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(55826);
                return;
            }
        }
        AppMethodBeat.m2505o(55826);
    }

    private void alY() {
        AppMethodBeat.m2504i(55827);
        if (this.aQf != null) {
            try {
                this.aQf.play();
                this.fZM = new C97403();
                C7305d.post(this.fZM, "SpeexPlayer_play");
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "audioTrack error:%s", e.getMessage());
                AppMethodBeat.m2505o(55827);
                return;
            }
        }
        AppMethodBeat.m2505o(55827);
    }

    /* renamed from: bn */
    public final boolean mo21081bn(boolean z) {
        AppMethodBeat.m2504i(55828);
        if (this.status != 1) {
            AppMethodBeat.m2505o(55828);
            return false;
        }
        this.status = 2;
        synchronized (this.fZu) {
            try {
                C4990ab.m7418v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.fZu.wait();
                C4990ab.m7418v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.cop != null && z && this.fZC) {
                    this.cop.mo73178Mm();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                if (this.cop != null && z && this.fZC) {
                    this.cop.mo73178Mm();
                }
                AppMethodBeat.m2505o(55828);
                return false;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(55828);
                throw th;
            }
        }
        AppMethodBeat.m2505o(55828);
        return true;
    }

    /* renamed from: Ew */
    public final boolean mo21073Ew() {
        AppMethodBeat.m2504i(55829);
        if (this.status != 2) {
            AppMethodBeat.m2505o(55829);
            return false;
        }
        this.status = 1;
        synchronized (this.fZt) {
            try {
                C4990ab.m7418v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.fZt.notify();
                C4990ab.m7418v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.cop != null && this.fZC) {
                    this.cop.requestFocus();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                if (this.cop != null && this.fZC) {
                    this.cop.requestFocus();
                }
                AppMethodBeat.m2505o(55829);
                return false;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(55829);
                throw th;
            }
        }
        AppMethodBeat.m2505o(55829);
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    /* renamed from: EH */
    public final boolean mo21072EH() {
        AppMethodBeat.m2504i(55830);
        C4990ab.m7412e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.fZt) {
                try {
                    this.fZt.notify();
                    if (this.cop != null && this.fZC) {
                        this.cop.mo73178Mm();
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SpeexPlayer", "exception:%s", C5046bo.m7574l(e));
                    alX();
                    if (this.cop != null && this.fZC) {
                        this.cop.mo73178Mm();
                    }
                    AppMethodBeat.m2505o(55830);
                    return false;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(55830);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(55830);
            return true;
        }
        C4990ab.m7412e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        try {
            synchronized (this.fZt) {
                this.fZt.notify();
            }
            synchronized (this.fZu) {
                this.fZu.notify();
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            while (true) {
                AppMethodBeat.m2505o(55830);
                throw th2;
            }
        }
        this.status = 3;
        AppMethodBeat.m2505o(55830);
        return false;
    }

    /* renamed from: Ez */
    public final double mo21074Ez() {
        return 0.0d;
    }

    /* renamed from: b */
    public final void mo21080b(C32474a c32474a) {
        AppMethodBeat.m2504i(55831);
        if (!(c32474a == null || this.cop == null)) {
            this.cop.mo73179a(c32474a);
        }
        AppMethodBeat.m2505o(55831);
    }

    public final void alP() {
        this.fZC = false;
    }
}
