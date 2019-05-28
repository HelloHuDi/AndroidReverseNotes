package com.tencent.p177mm.audio.p195b;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C37482b;
import com.tencent.p177mm.audio.p195b.C32303f.C25831a;
import com.tencent.p177mm.compatible.p219b.C18170d;
import com.tencent.p177mm.compatible.p219b.C31266f;
import com.tencent.p177mm.compatible.p219b.C41935h;
import com.tencent.p177mm.compatible.p219b.C41936i;
import com.tencent.p177mm.compatible.p219b.C41937j;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C18327mh;
import com.tencent.p177mm.p230g.p231a.C18330mi;
import com.tencent.p177mm.p230g.p231a.C26177jx;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.audio.b.c */
public final class C1292c {
    private int cpA = -1;
    public int cpB = -123456789;
    private boolean cpC = false;
    long cpD = -1;
    int cpE;
    boolean cpF = false;
    int cpG;
    private boolean cpH = false;
    int cpI = 0;
    boolean cpJ = false;
    boolean cpK = false;
    private AudioRecord cpL;
    public C1293a cpM;
    private C32303f cpN;
    private C41935h cpO;
    C37482b cpP;
    public int cpQ = 2;
    public int cpR = 1;
    public int cpS = 0;
    private C25831a cpT = new C12911();
    public int cpq = 0;
    int cpr = 0;
    int cps = 0;
    int cpt = 0;
    public int cpu = 1;
    private int cpv = 1;
    public int cpw = 120;
    private boolean cpx = false;
    boolean cpy = false;
    public int cpz = 10;
    public int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;

    /* renamed from: com.tencent.mm.audio.b.c$1 */
    class C12911 implements C25831a {
        C12911() {
        }

        /* renamed from: d */
        public final void mo4589d(int i, byte[] bArr) {
            C1292c c1292c;
            int i2;
            int i3;
            AppMethodBeat.m2504i(55731);
            C1292c.this.cpI++;
            if (C1292c.this.cpK && System.currentTimeMillis() - C1292c.this.cpD <= 1000 && ((long) (C1292c.this.cpI - 10)) > (System.currentTimeMillis() - C1292c.this.cpD) / ((long) C1292c.this.cpw)) {
                C7060h.pYm.mo8378a(151, 0, 1, false);
                C7060h.pYm.mo8378a(151, 4, 1, false);
                C4990ab.m7413e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", Integer.valueOf(C1292c.this.cpI), Long.valueOf((System.currentTimeMillis() - C1292c.this.cpD) / ((long) C1292c.this.cpw)));
                C1292c.this.cpJ = true;
            }
            if (C1292c.this.cpP != null) {
                C1292c.this.cpP.mo60392y(bArr, i);
            }
            if (i > 0) {
                c1292c = C1292c.this;
                if (!(c1292c.cpF && -2 == c1292c.cps)) {
                    int i4 = i / c1292c.cpE;
                    for (i2 = 5; i2 <= c1292c.cpG + i4; i2 += 5) {
                        i3 = ((i2 - c1292c.cpG) - 1) * c1292c.cpE;
                        int i5 = c1292c.cpE + i3;
                        if (i3 < 0 || i5 > i) {
                            C4990ab.m7413e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i5));
                            break;
                        }
                        while (i3 < i5) {
                            if (bArr[i3] != (byte) 0) {
                                c1292c.cps = -1;
                                c1292c.cpF = true;
                                break;
                            }
                            i3++;
                        }
                        c1292c.cps++;
                    }
                    c1292c.cpG = (c1292c.cpG + i4) % 5;
                    if (c1292c.cps == 20) {
                        c1292c.cpq = 6;
                        C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                        if (c1292c.cpr == -1 && c1292c.cpt == -1) {
                            c1292c.cpq = 11;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (c1292c.cpr == -1) {
                            c1292c.cpq = 8;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (c1292c.cpt == -1) {
                            c1292c.cpq = 9;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        }
                        C7060h.pYm.mo8378a(151, 0, 1, false);
                        C7060h.pYm.mo8378a(151, 5, 1, false);
                        c1292c.cps = -2;
                        c1292c.mo4593EN();
                    }
                }
            }
            if (C1292c.this.cpy) {
                if (i > 0) {
                    c1292c = C1292c.this;
                    if (c1292c.cpr != -1) {
                        i3 = 0;
                        for (i2 = 0; i2 < i / 2; i2++) {
                            short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
                            if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                                i3++;
                            }
                            if (i3 >= 5) {
                                c1292c.cpr++;
                                break;
                            }
                        }
                        if (c1292c.cpr > 100) {
                            c1292c.cpq = 7;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                            if (c1292c.cps == -2 && c1292c.cpt == -1) {
                                c1292c.cpq = 11;
                                C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (c1292c.cps == -2) {
                                c1292c.cpq = 8;
                                C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (c1292c.cpt == -1) {
                                c1292c.cpq = 10;
                                C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                            }
                            C7060h.pYm.mo8378a(151, 0, 1, false);
                            C7060h.pYm.mo8378a(151, 6, 1, false);
                            c1292c.mo4593EN();
                            c1292c.cpr = -1;
                        }
                    }
                    AppMethodBeat.m2505o(55731);
                    return;
                }
                C1292c c1292c2 = C1292c.this;
                if (c1292c2.cpt != -1 && i < 0) {
                    c1292c2.cpt++;
                    if (c1292c2.cpt >= 50) {
                        c1292c2.cpq = 5;
                        C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                        if (c1292c2.cps == -2 && c1292c2.cpr == -1) {
                            c1292c2.cpq = 11;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (c1292c2.cps == -2) {
                            c1292c2.cpq = 9;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        } else if (c1292c2.cpr == -1) {
                            c1292c2.cpq = 10;
                            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        C7060h.pYm.mo8378a(151, 0, 1, false);
                        C7060h.pYm.mo8378a(151, 7, 1, false);
                        c1292c2.mo4593EN();
                        c1292c2.cpt = -1;
                    }
                }
            }
            AppMethodBeat.m2505o(55731);
        }
    }

    /* renamed from: com.tencent.mm.audio.b.c$a */
    public interface C1293a {
        /* renamed from: bN */
        void mo4600bN(int i, int i2);

        /* renamed from: u */
        void mo4601u(byte[] bArr, int i);
    }

    public C1292c(int i, int i2, int i3) {
        AppMethodBeat.m2504i(55732);
        this.cpv = i2;
        this.mSampleRate = i;
        this.cpA = i3;
        if (this.cpv == 2) {
            this.cpQ = 3;
        } else {
            this.cpQ = 2;
        }
        if (this.cpA == 0 && C1427q.etn.erT > 0) {
            this.cpw = C1427q.etn.erT;
        }
        if (C1427q.etn.ese > 0) {
            this.cpQ = C1427q.etn.ese;
        }
        if (C1427q.etn.erO > 0) {
            this.cpz = C1427q.etn.erO;
        }
        if (C1427q.etd.eql) {
            this.cpP = new C37482b(C32304g.cqq, this.cpv, this.mSampleRate);
        }
        this.cpK = 1 == C32304g.m52780x("EnableRecorderCheckUnreasonableData", 1);
        C4990ab.m7417i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(this.mSampleRate), Integer.valueOf(this.cpv), Integer.valueOf(this.cpw), Boolean.valueOf(this.cpx), Integer.valueOf(this.cpA));
        AppMethodBeat.m2505o(55732);
    }

    /* renamed from: gG */
    public final void mo4598gG(int i) {
        AppMethodBeat.m2504i(55733);
        this.cpw = i;
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.cpw);
        AppMethodBeat.m2505o(55733);
    }

    /* renamed from: bq */
    public final void mo4595bq(boolean z) {
        AppMethodBeat.m2504i(55734);
        this.cpx = z;
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.cpx);
        AppMethodBeat.m2505o(55734);
    }

    /* renamed from: EJ */
    public final void mo4591EJ() {
        AppMethodBeat.m2504i(55735);
        this.cpy = true;
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.cpy);
        AppMethodBeat.m2505o(55735);
    }

    /* renamed from: v */
    public final void mo4599v(int i, boolean z) {
        AppMethodBeat.m2504i(55736);
        if (10 == this.cpz || z) {
            this.cpz = i;
            C4990ab.m7416i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.cpz);
        }
        AppMethodBeat.m2505o(55736);
    }

    /* renamed from: br */
    public final void mo4596br(boolean z) {
        AppMethodBeat.m2504i(55737);
        this.cpC = z;
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.cpC);
        AppMethodBeat.m2505o(55737);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x017c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: EK */
    private boolean m2756EK() {
        Object obj;
        AppMethodBeat.m2504i(55738);
        this.cpR = 1;
        boolean z = C1427q.etn.erP != 2;
        int Lw = C45290m.m83509Lw();
        int i = C1427q.etd.eqy;
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            C4990ab.m7416i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        C4990ab.m7410d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.cpQ, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.cpR = 3;
            this.cpq = 1;
            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(minBufferSize)));
            mo4593EN();
            AppMethodBeat.m2505o(55738);
            return false;
        }
        int i2;
        C4990ab.m7411d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", Integer.valueOf(minBufferSize));
        this.cpE = (((this.mSampleRate * 20) * this.cpv) * 2) / 1000;
        int i3 = ((this.mSampleRate * this.cpw) * this.cpv) / 1000;
        int i4 = i3 * 2;
        C4990ab.m7417i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", Integer.valueOf(minBufferSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.cpz), Boolean.valueOf(z));
        Lw = this.cpA;
        i = this.cpu;
        if (1 == Lw || 6 == Lw || 7 == Lw) {
            if (VERSION.SDK_INT < 11) {
                i = 1;
            } else {
                i = 7;
            }
            if (C1427q.etd.epG) {
                i = 1;
            }
            if (C1427q.etd.eqf >= 0) {
                i = C1427q.etd.eqf;
            }
            if (6 == Lw && C1427q.etd.eqI >= 0) {
                i2 = C1427q.etd.eqI;
                C4990ab.m7417i("MicroMsg.MMPcmRecorder", "init audio source: %s", Integer.valueOf(i2));
                this.cpL = new C18170d(i2, this.mSampleRate, this.cpQ, this.cpz * minBufferSize);
                if (this.cpL.getState() == 0) {
                    C7060h.pYm.mo8378a(151, 0, 1, false);
                    C7060h.pYm.mo8378a(151, 2, 1, false);
                    this.cpL.release();
                    this.cpq = 2;
                    C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                    if (7 == i2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.cpL = new C18170d(i, this.mSampleRate, this.cpQ, this.cpz * minBufferSize);
                }
                if (this.cpL.getState() != 0) {
                    C7060h.pYm.mo8378a(151, 0, 1, false);
                    C7060h.pYm.mo8378a(151, 2, 1, false);
                    this.cpL.release();
                    this.cpL = null;
                    this.cpR = 2;
                    this.cpq = 3;
                    C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                    mo4593EN();
                    AppMethodBeat.m2505o(55738);
                    return false;
                }
                AudioRecord audioRecord;
                if (z) {
                    audioRecord = this.cpL;
                    boolean z2 = this.cpx;
                    C1293a c1293a = this.cpM;
                    boolean z3 = (this.cpA == 1 || this.cpA == 6) && obj != null;
                    this.cpN = new C9044e(audioRecord, z2, i4, c1293a, z3);
                } else {
                    this.cpN = new C9040d(this.cpL, this.cpM, this.cpx, i3, i4);
                }
                this.cpN.mo53012a(this.cpT);
                if (-123456789 != this.cpB) {
                    this.cpN.mo53013gH(this.cpB);
                }
                if (this.cpC) {
                    this.cpO = new C41935h();
                    C41935h c41935h = this.cpO;
                    audioRecord = this.cpL;
                    Lw = this.cpA;
                    C4990ab.m7410d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (!C1443d.m3067fP(16)) {
                        if (audioRecord == null) {
                            C4990ab.m7410d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 == Lw) {
                            if (C1427q.etn.esl != 1) {
                                C4990ab.m7410d("MicroMsg.MMAudioPreProcess", "disable by config");
                            } else {
                                if (C1427q.etn.esm != 2) {
                                    c41935h.epw = new C41937j(audioRecord);
                                    if (c41935h.epw != null && c41935h.epw.isAvailable()) {
                                        c41935h.epw.mo43920KJ();
                                    }
                                }
                                if (C1427q.etn.esn != 2) {
                                    c41935h.epx = new C31266f(audioRecord);
                                    if (c41935h.epx != null && c41935h.epx.isAvailable()) {
                                        c41935h.epx.mo43920KJ();
                                    }
                                }
                                if (C1427q.etn.eso != 2) {
                                    c41935h.epy = new C41936i(audioRecord);
                                    if (c41935h.epy != null && c41935h.epy.isAvailable()) {
                                        c41935h.epy.mo43920KJ();
                                    }
                                }
                            }
                        } else if (C1427q.etn.erS != 1) {
                            C4990ab.m7410d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            c41935h.epw = new C41937j(audioRecord);
                            if (c41935h.epw != null && c41935h.epw.isAvailable()) {
                                c41935h.epw.mo43920KJ();
                            }
                            c41935h.epx = new C31266f(audioRecord);
                            if (c41935h.epx != null && c41935h.epx.isAvailable()) {
                                c41935h.epx.mo43920KJ();
                            }
                            c41935h.epy = new C41936i(audioRecord);
                            if (c41935h.epy != null && c41935h.epy.isAvailable()) {
                                c41935h.epy.mo43920KJ();
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(55738);
                return true;
            }
        }
        i2 = i;
        C4990ab.m7417i("MicroMsg.MMPcmRecorder", "init audio source: %s", Integer.valueOf(i2));
        try {
            this.cpL = new C18170d(i2, this.mSampleRate, this.cpQ, this.cpz * minBufferSize);
            if (this.cpL.getState() == 0) {
            }
            if (this.cpL.getState() != 0) {
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.cpq = 12;
            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            C7060h.pYm.mo8378a(151, 0, 1, false);
            C7060h.pYm.mo8378a(151, 1, 1, false);
            AppMethodBeat.m2505o(55738);
            return false;
        }
    }

    /* renamed from: bs */
    public final void mo4597bs(boolean z) {
        AppMethodBeat.m2504i(55739);
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(z)));
        if (this.cpN != null) {
            this.cpN.mo20482bs(z);
        }
        AppMethodBeat.m2505o(55739);
    }

    /* renamed from: EL */
    public final boolean mo4592EL() {
        boolean z = false;
        AppMethodBeat.m2504i(55740);
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", JsApiStartRecordVoice.NAME);
        C18327mh c18327mh = new C18327mh();
        c18327mh.cIh.type = 1;
        c18327mh.cIh.cIj = true;
        C4879a.xxA.mo10055m(c18327mh);
        this.cpD = System.currentTimeMillis();
        this.cpF = false;
        if (c18327mh.cIi.cIl) {
            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.cpq = 13;
            AppMethodBeat.m2505o(55740);
        } else {
            AudioManager audioManager = (AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null || !audioManager.isMicrophoneMute()) {
                this.cpH = false;
                z = m2757EM();
                if (!z) {
                    mo4590EB();
                    C18330mi c18330mi = new C18330mi();
                    c18330mi.cIm.type = 1;
                    C4879a.xxA.mo10055m(c18330mi);
                }
                AppMethodBeat.m2505o(55740);
            } else {
                C4990ab.m7412e("MicroMsg.MMPcmRecorder", "microphone is mute");
                this.cpq = 14;
                C4879a.xxA.mo10055m(new C26177jx());
                C7060h.pYm.mo8378a(151, 0, 1, false);
                C7060h.pYm.mo8378a(151, 8, 1, false);
                AppMethodBeat.m2505o(55740);
            }
        }
        return z;
    }

    /* renamed from: EM */
    private boolean m2757EM() {
        AppMethodBeat.m2504i(55741);
        C1446a c1446a = new C1446a();
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.cpL != null) {
            C4990ab.m7412e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
            AppMethodBeat.m2505o(55741);
            return false;
        }
        c1446a.evE = SystemClock.elapsedRealtime();
        C4990ab.m7410d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
        if (m2756EK()) {
            C4990ab.m7416i("MicroMsg.MMPcmRecorder", "init cost: " + c1446a.mo4908Mr() + "ms");
            c1446a.evE = SystemClock.elapsedRealtime();
            this.cpL.startRecording();
            C4990ab.m7416i("MicroMsg.MMPcmRecorder", "startRecording cost: " + c1446a.mo4908Mr());
            if (this.cpL.getRecordingState() != 3) {
                C7060h.pYm.mo8378a(151, 0, 1, false);
                C7060h.pYm.mo8378a(151, 3, 1, false);
                this.cpR = 2;
                this.cpq = 4;
                C4990ab.m7412e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                mo4593EN();
                AppMethodBeat.m2505o(55741);
                return false;
            } else if (this.cpN != null) {
                boolean EL = this.cpN.mo20481EL();
                AppMethodBeat.m2505o(55741);
                return EL;
            } else {
                C4990ab.m7412e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                AppMethodBeat.m2505o(55741);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.MMPcmRecorder", "startRecord init error");
        AppMethodBeat.m2505o(55741);
        return false;
    }

    /* renamed from: EB */
    public final synchronized boolean mo4590EB() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(55742);
            if (true == this.cpH) {
                C4990ab.m7416i("MicroMsg.MMPcmRecorder", "already have stopped");
                AppMethodBeat.m2505o(55742);
            } else {
                boolean z2;
                this.cpH = true;
                C1446a c1446a = new C1446a();
                if (this.cpP != null) {
                    this.cpP.mo60391Fg();
                    this.cpP = null;
                }
                c1446a.evE = SystemClock.elapsedRealtime();
                if (this.cpN != null) {
                    this.cpN.stopRecord();
                    this.cpN = null;
                }
                C4990ab.m7416i("MicroMsg.MMPcmRecorder", "cost " + c1446a.mo4908Mr() + "ms to call stopRecord");
                C4990ab.m7416i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.cpL == null) {
                    C4990ab.m7412e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.cpL.getState() != 1) {
                    C4990ab.m7412e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.cpL.getState());
                    z2 = false;
                } else {
                    c1446a.evE = SystemClock.elapsedRealtime();
                    this.cpL.stop();
                    this.cpL.release();
                    this.cpL = null;
                    C4990ab.m7416i("MicroMsg.MMPcmRecorder", "cost " + c1446a.mo4908Mr() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.cpF || -1 == this.cpD || System.currentTimeMillis() - this.cpD < FaceGestureDetGLThread.BRIGHTNESS_DURATION) || this.cpJ) {
                    C4990ab.m7416i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    C18330mi c18330mi = new C18330mi();
                    c18330mi.cIm.type = 1;
                    C4879a.xxA.mo10055m(c18330mi);
                    z = false;
                }
                C18327mh c18327mh = new C18327mh();
                c18327mh.cIh.type = 1;
                c18327mh.cIh.cIj = false;
                c18327mh.cIh.cIk = z;
                C4879a.xxA.mo10055m(c18327mh);
                C4990ab.m7417i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", Integer.valueOf(this.cpq));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.cpq != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.cpq) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                C4990ab.m7417i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", Integer.valueOf(arrayList.size()));
                C7060h.pYm.mo8379b(arrayList, false);
                AppMethodBeat.m2505o(55742);
                z = z2;
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: EN */
    public final void mo4593EN() {
        AppMethodBeat.m2504i(55743);
        if (this.cpM != null) {
            this.cpM.mo4600bN(this.cpR, this.cpq);
        }
        AppMethodBeat.m2505o(55743);
    }

    /* renamed from: EO */
    public final int mo4594EO() {
        AppMethodBeat.m2504i(55744);
        if (this.cpN != null) {
            int EO = this.cpN.mo53011EO();
            AppMethodBeat.m2505o(55744);
            return EO;
        }
        AppMethodBeat.m2505o(55744);
        return -1;
    }
}
