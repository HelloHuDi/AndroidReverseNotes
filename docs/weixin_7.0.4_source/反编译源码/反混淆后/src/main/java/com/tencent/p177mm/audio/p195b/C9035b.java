package com.tencent.p177mm.audio.p195b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C45163c;
import com.tencent.p177mm.audio.p1180d.C45163c.C41767a;
import com.tencent.p177mm.audio.p195b.C1292c.C1293a;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.audio.p195b.C32304g.C32306b;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p202bf.C25858d;
import com.tencent.p177mm.p202bf.C25858d.C17980b;
import com.tencent.p177mm.p202bf.C25858d.C9075a;
import com.tencent.p177mm.p202bf.C37511c;
import com.tencent.p177mm.p202bf.C37511c.C90741;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.mm.audio.b.b */
public final class C9035b {
    private static Object coV = new Object();
    private int coK = 0;
    private String coL = null;
    private int coM;
    private final Object coN = new Object();
    private C45163c coO = null;
    private C9039a coP;
    private C37511c coQ = null;
    private C9075a coR = null;
    private long coS = 0;
    private long coT = 0;
    private int coU = 0;
    private int coW = TXRecordCommon.AUDIO_SAMPLERATE_16000;
    private boolean coX = false;
    public MediaRecorder coY;
    public C1292c coZ = null;
    public C18169a cpa;
    public C9038b cpb;
    private volatile boolean cpc = false;
    private C1446a cpd = new C1446a();
    private int cpe = 0;
    private int cpf = 0;
    private C1293a cpg = new C90362();
    private boolean cph = false;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;

    /* renamed from: com.tencent.mm.audio.b.b$1 */
    class C12901 implements OnErrorListener {
        C12901() {
        }

        public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
            AppMethodBeat.m2504i(116473);
            if (C9035b.this.coP != null) {
                C9035b.this.coP.onError();
            }
            try {
                C9035b.this.coY.release();
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MMAudioRecorder", e.getMessage());
            }
            C9035b.this.cpb = C9038b.ERROR;
            AppMethodBeat.m2505o(116473);
        }
    }

    /* renamed from: com.tencent.mm.audio.b.b$2 */
    class C90362 implements C1293a {

        /* renamed from: com.tencent.mm.audio.b.b$2$1 */
        class C90341 implements Runnable {
            C90341() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116474);
                C9035b.this.mo20472EH();
                if (C9035b.this.coP != null) {
                    C9035b.this.coP.onError();
                }
                AppMethodBeat.m2505o(116474);
            }
        }

        /* renamed from: com.tencent.mm.audio.b.b$2$2 */
        class C90372 implements Runnable {
            C90372() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116475);
                C9035b.this.mo20472EH();
                if (C9035b.this.coP != null) {
                    C9035b.this.coP.onError();
                }
                AppMethodBeat.m2505o(116475);
            }
        }

        C90362() {
        }

        /* JADX WARNING: Missing block: B:100:0x02ff, code skipped:
            if (com.tencent.p177mm.audio.p195b.C9035b.m16371q(r11.cpi) != com.tencent.ugc.TXRecordCommon.AUDIO_SAMPLERATE_16000) goto L_0x0306;
     */
        /* JADX WARNING: Missing block: B:101:0x0301, code skipped:
            r12 = com.tencent.p177mm.audio.p195b.C9035b.C90362.m16382v(r12, r13);
            r13 = r12.length;
     */
        /* JADX WARNING: Missing block: B:102:0x0306, code skipped:
            m16383w(r12, r13);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(116476);
     */
        /* JADX WARNING: Missing block: B:111:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: u */
        public final void mo4601u(byte[] bArr, int i) {
            int i2 = -1;
            boolean z = false;
            AppMethodBeat.m2504i(116476);
            C4990ab.m7417i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", Boolean.valueOf(C9035b.this.cpc));
            if (C9035b.this.cpb != C9038b.STOPPED || C9035b.this.cpc) {
                boolean z2;
                synchronized (C9035b.coV) {
                    try {
                        if (C9035b.this.cpc) {
                            if (C9035b.this.coZ != null) {
                                C4990ab.m7417i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", bArr, Integer.valueOf(i));
                                C9035b.this.coZ.mo4590EB();
                                C9035b.this.coZ.cpM = null;
                                C9035b.this.coZ = null;
                                z = true;
                            } else {
                                C4990ab.m7416i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
                            }
                            C9035b.this.cpc = false;
                        }
                        z2 = z;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(116476);
                        throw th;
                    }
                }
                long gb = C5046bo.m7566gb(C9035b.this.coT);
                if (C9035b.this.coS <= 0 || gb <= C9035b.this.coS) {
                    C4990ab.m7410d("MicroMsg.MMAudioRecorder", "read :" + i + " time: " + C9035b.this.cpd.mo4908Mr() + " dataReadedCnt: " + C9035b.this.coU);
                    if (i >= 0) {
                        C9035b.this.coU = C9035b.this.coU + i;
                        synchronized (C9035b.this.coN) {
                            try {
                                C37511c m;
                                if (C9035b.this.coQ == null && ((C9035b.this.cpa == C18169a.PCM || C9035b.this.cpa == C18169a.SILK) && C9035b.this.coR != null && C9035b.this.coX)) {
                                    C9035b.this.coQ = new C37511c();
                                    m = C9035b.this.coQ;
                                    int q = C9035b.this.mSampleRate;
                                    C4990ab.m7416i("MicroMsg.SpeexEncoderWorker", "init ");
                                    m.fQA.clear();
                                    C17980b c17980b = new C17980b();
                                    c17980b.fNY = C25858d.getPrefix();
                                    c17980b.sampleRate = q;
                                    c17980b.fQw = 1;
                                    c17980b.aTg = 16;
                                    m.mFileName = String.format("%s%d_%d_%d_%d", new Object[]{c17980b.fNY, Integer.valueOf(c17980b.sampleRate), Integer.valueOf(c17980b.fQw), Integer.valueOf(c17980b.aTg), Long.valueOf(System.currentTimeMillis())});
                                }
                                if (C9035b.this.coQ != null) {
                                    m = C9035b.this.coQ;
                                    C4990ab.m7410d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + m.fQA.size());
                                    if (bArr != null && bArr.length > 0) {
                                        m.fQA.add(new C32305a(bArr, bArr.length));
                                    }
                                }
                                if (C9035b.this.cpa == C18169a.SILK) {
                                    int i3;
                                    if (C9035b.this.coO == null) {
                                        C9035b.this.coO = new C45163c(C9035b.this.mSampleRate, C9035b.this.coW);
                                        C9035b.this.coO.mo43824eo(C9035b.this.coL);
                                    }
                                    m16383w(bArr, i);
                                    C45163c r = C9035b.this.coO;
                                    String str = "MicroMsg.SilkWriter";
                                    String str2 = "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s";
                                    Object[] objArr = new Object[4];
                                    if (r.crn == null) {
                                        i3 = -1;
                                    } else {
                                        i3 = r.crn.size();
                                    }
                                    objArr[0] = Integer.valueOf(i3);
                                    if (bArr != null) {
                                        i2 = bArr.length;
                                    }
                                    objArr[1] = Integer.valueOf(i2);
                                    objArr[2] = Integer.valueOf(i);
                                    objArr[3] = Boolean.valueOf(z2);
                                    C4990ab.m7411d(str, str2, objArr);
                                    if (i > 0) {
                                        synchronized (r) {
                                            if (r.cro) {
                                                C4990ab.m7412e("MicroMsg.SilkWriter", "already stop");
                                            } else {
                                                if (r.cru == null) {
                                                    r.cru = new C41767a(r, (byte) 0);
                                                    C7305d.post(r.cru, "SilkWriter_run");
                                                }
                                                if (r.crn != null) {
                                                    r.crn.add(new C32305a(bArr, i, z2));
                                                }
                                            }
                                        }
                                    }
                                    AppMethodBeat.m2505o(116476);
                                    return;
                                }
                            } catch (Throwable th2) {
                                AppMethodBeat.m2505o(116476);
                                throw th2;
                            }
                        }
                    } else if (C9035b.this.cpb == C9038b.STOPPED) {
                        C4990ab.m7420w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
                        AppMethodBeat.m2505o(116476);
                        return;
                    } else {
                        new C7306ak(Looper.getMainLooper()).post(new C90372());
                        AppMethodBeat.m2505o(116476);
                        return;
                    }
                }
                C4990ab.m7420w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:".concat(String.valueOf(gb)));
                new C7306ak(Looper.getMainLooper()).post(new C90341());
                AppMethodBeat.m2505o(116476);
                return;
            }
            C4990ab.m7420w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
            AppMethodBeat.m2505o(116476);
        }

        /* renamed from: v */
        private static byte[] m16382v(byte[] bArr, int i) {
            int i2 = i % 4;
            if (i2 != 0) {
                i -= i2;
            }
            if (i <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2 += 2) {
                bArr2[i2] = bArr[i2 * 2];
                bArr2[i2 + 1] = bArr[(i2 * 2) + 1];
            }
            return bArr2;
        }

        /* renamed from: w */
        private void m16383w(byte[] bArr, int i) {
            AppMethodBeat.m2504i(116477);
            for (int i2 = 0; i2 < i / 2; i2++) {
                short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                if (s > C9035b.this.coK) {
                    C9035b.this.coK = s;
                }
            }
            AppMethodBeat.m2505o(116477);
        }

        /* renamed from: bN */
        public final void mo4600bN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.audio.b.b$b */
    public enum C9038b {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        static {
            AppMethodBeat.m2505o(116480);
        }
    }

    /* renamed from: com.tencent.mm.audio.b.b$a */
    public interface C9039a {
        void onError();
    }

    static {
        AppMethodBeat.m2504i(116494);
        AppMethodBeat.m2505o(116494);
    }

    public C9035b(C18169a c18169a) {
        AppMethodBeat.m2504i(116481);
        C4990ab.m7416i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: ".concat(String.valueOf(c18169a)));
        this.cpa = c18169a;
        if (!C32306b.m52782ES()) {
            C4990ab.m7416i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.cpa = C18169a.AMR;
        }
        if (this.cpa == C18169a.AMR) {
            this.coM = 7;
            this.coY = new MediaRecorder();
        } else {
            mo20471EG();
            this.coM = 1;
        }
        this.cpc = false;
        AppMethodBeat.m2505o(116481);
    }

    /* renamed from: a */
    public final void mo20473a(C9039a c9039a) {
        AppMethodBeat.m2504i(116482);
        if (this.cpa == C18169a.AMR) {
            if (this.coY == null) {
                AppMethodBeat.m2505o(116482);
                return;
            }
            this.coP = c9039a;
            this.coY.setOnErrorListener(new C12901());
            AppMethodBeat.m2505o(116482);
        } else if (this.cpb == C9038b.INITIALIZING) {
            this.coP = c9039a;
            AppMethodBeat.m2505o(116482);
        } else {
            C4990ab.m7412e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
            AppMethodBeat.m2505o(116482);
        }
    }

    public final void setOutputFile(String str) {
        AppMethodBeat.m2504i(116483);
        if (this.cpa == C18169a.AMR) {
            if (this.coY == null) {
                AppMethodBeat.m2505o(116483);
                return;
            }
            this.coY.setOutputFile(str);
            this.coL = str;
            AppMethodBeat.m2505o(116483);
        } else if (this.cpb == C9038b.INITIALIZING) {
            this.coL = str;
            AppMethodBeat.m2505o(116483);
        } else {
            C4990ab.m7412e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.cpb = C9038b.ERROR;
            AppMethodBeat.m2505o(116483);
        }
    }

    public final void setMaxDuration(int i) {
        AppMethodBeat.m2504i(116484);
        if (this.cpa == C18169a.AMR) {
            if (this.coY != null) {
                this.coY.setMaxDuration(i);
            }
            AppMethodBeat.m2505o(116484);
            return;
        }
        this.coS = (long) i;
        AppMethodBeat.m2505o(116484);
    }

    /* renamed from: ED */
    public final void mo20468ED() {
        AppMethodBeat.m2504i(116485);
        if (this.cpa == C18169a.AMR) {
            if (this.coY != null) {
                this.coY.setAudioEncoder(1);
            }
            AppMethodBeat.m2505o(116485);
            return;
        }
        AppMethodBeat.m2505o(116485);
    }

    /* renamed from: EE */
    public final void mo20469EE() {
        AppMethodBeat.m2504i(116486);
        if (this.cpa != C18169a.AMR) {
            AppMethodBeat.m2505o(116486);
        } else if (this.coY == null) {
            AppMethodBeat.m2505o(116486);
        } else {
            this.coY.setAudioSource(1);
            AppMethodBeat.m2505o(116486);
        }
    }

    /* renamed from: EF */
    public final void mo20470EF() {
        AppMethodBeat.m2504i(116487);
        if (this.cpa != C18169a.AMR) {
            AppMethodBeat.m2505o(116487);
        } else if (this.coY == null) {
            AppMethodBeat.m2505o(116487);
        } else {
            this.coY.setOutputFormat(3);
            AppMethodBeat.m2505o(116487);
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.m2504i(116488);
        if (this.cpa == C18169a.AMR) {
            if (this.coY == null) {
                AppMethodBeat.m2505o(116488);
                return 0;
            }
            int maxAmplitude = this.coY.getMaxAmplitude();
            AppMethodBeat.m2505o(116488);
            return maxAmplitude;
        } else if (this.cpb == C9038b.RECORDING) {
            int i = this.coK;
            this.coK = 0;
            AppMethodBeat.m2505o(116488);
            return i;
        } else {
            AppMethodBeat.m2505o(116488);
            return 0;
        }
    }

    /* renamed from: EG */
    public final void mo20471EG() {
        AppMethodBeat.m2504i(116489);
        this.coR = C9075a.ajX();
        if (this.coR != null) {
            this.coX = this.coR.ajW();
        }
        if (this.cpa == C18169a.SILK) {
            this.mSampleRate = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("VoiceSamplingRate"), TXRecordCommon.AUDIO_SAMPLERATE_16000);
            this.coW = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("VoiceRate"), TXRecordCommon.AUDIO_SAMPLERATE_16000);
            C4990ab.m7417i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", r1, Integer.valueOf(this.mSampleRate), r0, Integer.valueOf(this.coW));
        } else {
            if (this.coX) {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
            } else {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            }
            C1720g.m3537RQ();
            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().eJH.get(27), 0);
            C4990ab.m7416i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + a);
            if (a == 1) {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            }
        }
        this.coK = 0;
        this.coL = null;
        synchronized (this.coN) {
            try {
                this.coQ = null;
                this.coO = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(116489);
            }
        }
        this.coU = 0;
        try {
            synchronized (coV) {
                this.coZ = new C1292c(this.mSampleRate, 1, 0);
                this.coZ.mo4595bq(true);
                this.coZ.mo4598gG(120);
                this.coZ.cpM = this.cpg;
            }
            this.cpb = C9038b.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                C4990ab.m7412e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                C4990ab.m7412e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.cpb = C9038b.ERROR;
            AppMethodBeat.m2505o(116489);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(116489);
            }
        }
    }

    public final void start() {
        AppMethodBeat.m2504i(116490);
        if (this.cpa == C18169a.AMR) {
            if (this.coY != null) {
                this.coY.start();
            }
            AppMethodBeat.m2505o(116490);
            return;
        }
        C4990ab.m7416i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.cpb + " recMode: " + this.cpa);
        if (this.cpb == C9038b.READY) {
            this.coT = System.currentTimeMillis();
            this.coU = 0;
            this.cpb = C9038b.RECORDING;
            synchronized (coV) {
                try {
                    this.coZ.mo4592EL();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(116490);
                    }
                }
            }
        } else {
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(27, Integer.valueOf(1));
            C4990ab.m7412e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
            this.cpb = C9038b.ERROR;
        }
        this.cpc = false;
        AppMethodBeat.m2505o(116490);
    }

    public final void prepare() {
        AppMethodBeat.m2504i(116491);
        if (this.cpa == C18169a.AMR) {
            if (this.coY != null) {
                this.coY.prepare();
            }
            AppMethodBeat.m2505o(116491);
        } else if (this.cpb != C9038b.INITIALIZING || this.coL == null) {
            this.cpb = C9038b.ERROR;
            release();
            AppMethodBeat.m2505o(116491);
        } else {
            this.cpb = C9038b.READY;
            AppMethodBeat.m2505o(116491);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(116492);
        if (this.cpa == C18169a.AMR) {
            if (this.coY != null) {
                this.coY.release();
            }
            AppMethodBeat.m2505o(116492);
            return;
        }
        if (this.cpb == C9038b.RECORDING) {
            mo20472EH();
        } else {
            C9038b c9038b = C9038b.READY;
        }
        synchronized (coV) {
            try {
                if (this.coZ != null) {
                    this.coZ.mo4590EB();
                    this.coZ.cpM = null;
                    this.coZ = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(116492);
            }
        }
    }

    /* renamed from: EH */
    public final boolean mo20472EH() {
        AppMethodBeat.m2504i(116493);
        if (this.cpa == C18169a.AMR) {
            C4990ab.m7417i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", this.coY);
            if (this.coY != null) {
                this.coY.stop();
                this.coY.release();
                this.coY = null;
            }
            AppMethodBeat.m2505o(116493);
            return true;
        }
        C1446a c1446a = new C1446a();
        C4990ab.m7416i("MicroMsg.MMAudioRecorder", "stop now state: " + this.cpb);
        if (this.cpb == C9038b.INITIALIZING) {
            C7060h.pYm.mo8378a(357, 53, 1, true);
            if (!this.cph) {
                C7060h.pYm.mo8378a(357, 54, 1, true);
            }
            this.cph = true;
        }
        if (this.cpb != C9038b.RECORDING) {
            C4990ab.m7412e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.cpb = C9038b.ERROR;
            AppMethodBeat.m2505o(116493);
            return true;
        }
        synchronized (coV) {
            try {
                if (this.coZ != null) {
                    this.cpc = true;
                } else {
                    this.cpc = false;
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(116493);
            }
        }
        long Mr = c1446a.mo4908Mr();
        this.cpb = C9038b.STOPPED;
        long Mr2 = c1446a.mo4908Mr();
        if (this.cpc) {
            C4990ab.m7417i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", Boolean.valueOf(this.cpc));
            int i = 0;
            while (this.cpc) {
                i++;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                }
                if (i >= 25) {
                    synchronized (coV) {
                        try {
                            C4990ab.m7417i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", this.coZ);
                            if (this.coZ != null) {
                                this.coZ.mo4590EB();
                                this.coZ.cpM = null;
                                this.coZ = null;
                            }
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                        } catch (Throwable th2) {
                            AppMethodBeat.m2505o(116493);
                        }
                    }
                    C4990ab.m7417i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.cpc), Integer.valueOf(i));
                }
            }
            C4990ab.m7417i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.cpc), Integer.valueOf(i));
        }
        synchronized (this.coN) {
            try {
                if (this.coO != null) {
                    this.coO.mo43820Fe();
                }
                if (this.coQ != null) {
                    C37511c c37511c = this.coQ;
                    C4990ab.m7416i("MicroMsg.SpeexEncoderWorker", "stop ");
                    new C7306ak(Looper.getMainLooper()).post(new C90741());
                }
            } catch (Throwable th3) {
                while (true) {
                    AppMethodBeat.m2505o(116493);
                }
            }
        }
        long gb = C5046bo.m7566gb(this.coT);
        C4990ab.m7416i("MicroMsg.MMAudioRecorder", "toNow " + gb + " startTickCnt: " + this.coT + " pcmDataReadedCnt: " + this.coU);
        if (gb > FaceGestureDetGLThread.BRIGHTNESS_DURATION && this.coU == 0) {
            C1720g.m3537RQ();
            C1720g.m3536RP().eJH.set(27, Integer.valueOf(1));
            C4990ab.m7416i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        C4990ab.m7416i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + Mr + " Read:" + Mr2 + " Thr:" + c1446a.mo4908Mr());
        AppMethodBeat.m2505o(116493);
        return false;
    }
}
