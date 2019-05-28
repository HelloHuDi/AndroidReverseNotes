package com.tencent.mm.audio.b;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.b;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;
import java.util.ArrayList;

public final class c {
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
    public a cpM;
    private f cpN;
    private h cpO;
    b cpP;
    public int cpQ = 2;
    public int cpR = 1;
    public int cpS = 0;
    private com.tencent.mm.audio.b.f.a cpT = new com.tencent.mm.audio.b.f.a() {
        public final void d(int i, byte[] bArr) {
            c cVar;
            int i2;
            int i3;
            AppMethodBeat.i(55731);
            c.this.cpI++;
            if (c.this.cpK && System.currentTimeMillis() - c.this.cpD <= 1000 && ((long) (c.this.cpI - 10)) > (System.currentTimeMillis() - c.this.cpD) / ((long) c.this.cpw)) {
                com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.a(151, 4, 1, false);
                ab.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", Integer.valueOf(c.this.cpI), Long.valueOf((System.currentTimeMillis() - c.this.cpD) / ((long) c.this.cpw)));
                c.this.cpJ = true;
            }
            if (c.this.cpP != null) {
                c.this.cpP.y(bArr, i);
            }
            if (i > 0) {
                cVar = c.this;
                if (!(cVar.cpF && -2 == cVar.cps)) {
                    int i4 = i / cVar.cpE;
                    for (i2 = 5; i2 <= cVar.cpG + i4; i2 += 5) {
                        i3 = ((i2 - cVar.cpG) - 1) * cVar.cpE;
                        int i5 = cVar.cpE + i3;
                        if (i3 < 0 || i5 > i) {
                            ab.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i5));
                            break;
                        }
                        while (i3 < i5) {
                            if (bArr[i3] != (byte) 0) {
                                cVar.cps = -1;
                                cVar.cpF = true;
                                break;
                            }
                            i3++;
                        }
                        cVar.cps++;
                    }
                    cVar.cpG = (cVar.cpG + i4) % 5;
                    if (cVar.cps == 20) {
                        cVar.cpq = 6;
                        ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                        if (cVar.cpr == -1 && cVar.cpt == -1) {
                            cVar.cpq = 11;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar.cpr == -1) {
                            cVar.cpq = 8;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (cVar.cpt == -1) {
                            cVar.cpq = 9;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                        com.tencent.mm.plugin.report.service.h.pYm.a(151, 5, 1, false);
                        cVar.cps = -2;
                        cVar.EN();
                    }
                }
            }
            if (c.this.cpy) {
                if (i > 0) {
                    cVar = c.this;
                    if (cVar.cpr != -1) {
                        i3 = 0;
                        for (i2 = 0; i2 < i / 2; i2++) {
                            short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
                            if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                                i3++;
                            }
                            if (i3 >= 5) {
                                cVar.cpr++;
                                break;
                            }
                        }
                        if (cVar.cpr > 100) {
                            cVar.cpq = 7;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                            if (cVar.cps == -2 && cVar.cpt == -1) {
                                cVar.cpq = 11;
                                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (cVar.cps == -2) {
                                cVar.cpq = 8;
                                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (cVar.cpt == -1) {
                                cVar.cpq = 10;
                                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                            com.tencent.mm.plugin.report.service.h.pYm.a(151, 6, 1, false);
                            cVar.EN();
                            cVar.cpr = -1;
                        }
                    }
                    AppMethodBeat.o(55731);
                    return;
                }
                c cVar2 = c.this;
                if (cVar2.cpt != -1 && i < 0) {
                    cVar2.cpt++;
                    if (cVar2.cpt >= 50) {
                        cVar2.cpq = 5;
                        ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                        if (cVar2.cps == -2 && cVar2.cpr == -1) {
                            cVar2.cpq = 11;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar2.cps == -2) {
                            cVar2.cpq = 9;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        } else if (cVar2.cpr == -1) {
                            cVar2.cpq = 10;
                            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                        com.tencent.mm.plugin.report.service.h.pYm.a(151, 7, 1, false);
                        cVar2.EN();
                        cVar2.cpt = -1;
                    }
                }
            }
            AppMethodBeat.o(55731);
        }
    };
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

    public interface a {
        void bN(int i, int i2);

        void u(byte[] bArr, int i);
    }

    public c(int i, int i2, int i3) {
        AppMethodBeat.i(55732);
        this.cpv = i2;
        this.mSampleRate = i;
        this.cpA = i3;
        if (this.cpv == 2) {
            this.cpQ = 3;
        } else {
            this.cpQ = 2;
        }
        if (this.cpA == 0 && q.etn.erT > 0) {
            this.cpw = q.etn.erT;
        }
        if (q.etn.ese > 0) {
            this.cpQ = q.etn.ese;
        }
        if (q.etn.erO > 0) {
            this.cpz = q.etn.erO;
        }
        if (q.etd.eql) {
            this.cpP = new b(g.cqq, this.cpv, this.mSampleRate);
        }
        this.cpK = 1 == g.x("EnableRecorderCheckUnreasonableData", 1);
        ab.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(this.mSampleRate), Integer.valueOf(this.cpv), Integer.valueOf(this.cpw), Boolean.valueOf(this.cpx), Integer.valueOf(this.cpA));
        AppMethodBeat.o(55732);
    }

    public final void gG(int i) {
        AppMethodBeat.i(55733);
        this.cpw = i;
        ab.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.cpw);
        AppMethodBeat.o(55733);
    }

    public final void bq(boolean z) {
        AppMethodBeat.i(55734);
        this.cpx = z;
        ab.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.cpx);
        AppMethodBeat.o(55734);
    }

    public final void EJ() {
        AppMethodBeat.i(55735);
        this.cpy = true;
        ab.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.cpy);
        AppMethodBeat.o(55735);
    }

    public final void v(int i, boolean z) {
        AppMethodBeat.i(55736);
        if (10 == this.cpz || z) {
            this.cpz = i;
            ab.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.cpz);
        }
        AppMethodBeat.o(55736);
    }

    public final void br(boolean z) {
        AppMethodBeat.i(55737);
        this.cpC = z;
        ab.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.cpC);
        AppMethodBeat.o(55737);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x017c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean EK() {
        Object obj;
        AppMethodBeat.i(55738);
        this.cpR = 1;
        boolean z = q.etn.erP != 2;
        int Lw = m.Lw();
        int i = q.etd.eqy;
        if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            ab.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: ".concat(String.valueOf(i)));
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        ab.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.cpQ, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.cpR = 3;
            this.cpq = 1;
            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR ".concat(String.valueOf(minBufferSize)));
            EN();
            AppMethodBeat.o(55738);
            return false;
        }
        int i2;
        ab.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", Integer.valueOf(minBufferSize));
        this.cpE = (((this.mSampleRate * 20) * this.cpv) * 2) / 1000;
        int i3 = ((this.mSampleRate * this.cpw) * this.cpv) / 1000;
        int i4 = i3 * 2;
        ab.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", Integer.valueOf(minBufferSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.cpz), Boolean.valueOf(z));
        Lw = this.cpA;
        i = this.cpu;
        if (1 == Lw || 6 == Lw || 7 == Lw) {
            if (VERSION.SDK_INT < 11) {
                i = 1;
            } else {
                i = 7;
            }
            if (q.etd.epG) {
                i = 1;
            }
            if (q.etd.eqf >= 0) {
                i = q.etd.eqf;
            }
            if (6 == Lw && q.etd.eqI >= 0) {
                i2 = q.etd.eqI;
                ab.i("MicroMsg.MMPcmRecorder", "init audio source: %s", Integer.valueOf(i2));
                this.cpL = new d(i2, this.mSampleRate, this.cpQ, this.cpz * minBufferSize);
                if (this.cpL.getState() == 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(151, 2, 1, false);
                    this.cpL.release();
                    this.cpq = 2;
                    ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                    if (7 == i2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.cpL = new d(i, this.mSampleRate, this.cpQ, this.cpz * minBufferSize);
                }
                if (this.cpL.getState() != 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.a(151, 2, 1, false);
                    this.cpL.release();
                    this.cpL = null;
                    this.cpR = 2;
                    this.cpq = 3;
                    ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                    EN();
                    AppMethodBeat.o(55738);
                    return false;
                }
                AudioRecord audioRecord;
                if (z) {
                    audioRecord = this.cpL;
                    boolean z2 = this.cpx;
                    a aVar = this.cpM;
                    boolean z3 = (this.cpA == 1 || this.cpA == 6) && obj != null;
                    this.cpN = new e(audioRecord, z2, i4, aVar, z3);
                } else {
                    this.cpN = new d(this.cpL, this.cpM, this.cpx, i3, i4);
                }
                this.cpN.a(this.cpT);
                if (-123456789 != this.cpB) {
                    this.cpN.gH(this.cpB);
                }
                if (this.cpC) {
                    this.cpO = new h();
                    h hVar = this.cpO;
                    audioRecord = this.cpL;
                    Lw = this.cpA;
                    ab.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (!com.tencent.mm.compatible.util.d.fP(16)) {
                        if (audioRecord == null) {
                            ab.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 == Lw) {
                            if (q.etn.esl != 1) {
                                ab.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            } else {
                                if (q.etn.esm != 2) {
                                    hVar.epw = new j(audioRecord);
                                    if (hVar.epw != null && hVar.epw.isAvailable()) {
                                        hVar.epw.KJ();
                                    }
                                }
                                if (q.etn.esn != 2) {
                                    hVar.epx = new f(audioRecord);
                                    if (hVar.epx != null && hVar.epx.isAvailable()) {
                                        hVar.epx.KJ();
                                    }
                                }
                                if (q.etn.eso != 2) {
                                    hVar.epy = new i(audioRecord);
                                    if (hVar.epy != null && hVar.epy.isAvailable()) {
                                        hVar.epy.KJ();
                                    }
                                }
                            }
                        } else if (q.etn.erS != 1) {
                            ab.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            hVar.epw = new j(audioRecord);
                            if (hVar.epw != null && hVar.epw.isAvailable()) {
                                hVar.epw.KJ();
                            }
                            hVar.epx = new f(audioRecord);
                            if (hVar.epx != null && hVar.epx.isAvailable()) {
                                hVar.epx.KJ();
                            }
                            hVar.epy = new i(audioRecord);
                            if (hVar.epy != null && hVar.epy.isAvailable()) {
                                hVar.epy.KJ();
                            }
                        }
                    }
                }
                AppMethodBeat.o(55738);
                return true;
            }
        }
        i2 = i;
        ab.i("MicroMsg.MMPcmRecorder", "init audio source: %s", Integer.valueOf(i2));
        try {
            this.cpL = new d(i2, this.mSampleRate, this.cpQ, this.cpz * minBufferSize);
            if (this.cpL.getState() == 0) {
            }
            if (this.cpL.getState() != 0) {
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.cpq = 12;
            ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
            com.tencent.mm.plugin.report.service.h.pYm.a(151, 1, 1, false);
            AppMethodBeat.o(55738);
            return false;
        }
    }

    public final void bs(boolean z) {
        AppMethodBeat.i(55739);
        ab.i("MicroMsg.MMPcmRecorder", "switchMute mute:".concat(String.valueOf(z)));
        if (this.cpN != null) {
            this.cpN.bs(z);
        }
        AppMethodBeat.o(55739);
    }

    public final boolean EL() {
        boolean z = false;
        AppMethodBeat.i(55740);
        ab.i("MicroMsg.MMPcmRecorder", JsApiStartRecordVoice.NAME);
        mh mhVar = new mh();
        mhVar.cIh.type = 1;
        mhVar.cIh.cIj = true;
        com.tencent.mm.sdk.b.a.xxA.m(mhVar);
        this.cpD = System.currentTimeMillis();
        this.cpF = false;
        if (mhVar.cIi.cIl) {
            ab.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.cpq = 13;
            AppMethodBeat.o(55740);
        } else {
            AudioManager audioManager = (AudioManager) ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null || !audioManager.isMicrophoneMute()) {
                this.cpH = false;
                z = EM();
                if (!z) {
                    EB();
                    mi miVar = new mi();
                    miVar.cIm.type = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(miVar);
                }
                AppMethodBeat.o(55740);
            } else {
                ab.e("MicroMsg.MMPcmRecorder", "microphone is mute");
                this.cpq = 14;
                com.tencent.mm.sdk.b.a.xxA.m(new jx());
                com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.a(151, 8, 1, false);
                AppMethodBeat.o(55740);
            }
        }
        return z;
    }

    private boolean EM() {
        AppMethodBeat.i(55741);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        ab.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.cpL != null) {
            ab.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
            AppMethodBeat.o(55741);
            return false;
        }
        aVar.evE = SystemClock.elapsedRealtime();
        ab.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
        if (EK()) {
            ab.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.Mr() + "ms");
            aVar.evE = SystemClock.elapsedRealtime();
            this.cpL.startRecording();
            ab.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.Mr());
            if (this.cpL.getRecordingState() != 3) {
                com.tencent.mm.plugin.report.service.h.pYm.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.a(151, 3, 1, false);
                this.cpR = 2;
                this.cpq = 4;
                ab.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                EN();
                AppMethodBeat.o(55741);
                return false;
            } else if (this.cpN != null) {
                boolean EL = this.cpN.EL();
                AppMethodBeat.o(55741);
                return EL;
            } else {
                ab.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                AppMethodBeat.o(55741);
                return false;
            }
        }
        ab.e("MicroMsg.MMPcmRecorder", "startRecord init error");
        AppMethodBeat.o(55741);
        return false;
    }

    public final synchronized boolean EB() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(55742);
            if (true == this.cpH) {
                ab.i("MicroMsg.MMPcmRecorder", "already have stopped");
                AppMethodBeat.o(55742);
            } else {
                boolean z2;
                this.cpH = true;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                if (this.cpP != null) {
                    this.cpP.Fg();
                    this.cpP = null;
                }
                aVar.evE = SystemClock.elapsedRealtime();
                if (this.cpN != null) {
                    this.cpN.stopRecord();
                    this.cpN = null;
                }
                ab.i("MicroMsg.MMPcmRecorder", "cost " + aVar.Mr() + "ms to call stopRecord");
                ab.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.cpL == null) {
                    ab.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.cpL.getState() != 1) {
                    ab.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.cpL.getState());
                    z2 = false;
                } else {
                    aVar.evE = SystemClock.elapsedRealtime();
                    this.cpL.stop();
                    this.cpL.release();
                    this.cpL = null;
                    ab.i("MicroMsg.MMPcmRecorder", "cost " + aVar.Mr() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.cpF || -1 == this.cpD || System.currentTimeMillis() - this.cpD < FaceGestureDetGLThread.BRIGHTNESS_DURATION) || this.cpJ) {
                    ab.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    mi miVar = new mi();
                    miVar.cIm.type = 1;
                    com.tencent.mm.sdk.b.a.xxA.m(miVar);
                    z = false;
                }
                mh mhVar = new mh();
                mhVar.cIh.type = 1;
                mhVar.cIh.cIj = false;
                mhVar.cIh.cIk = z;
                com.tencent.mm.sdk.b.a.xxA.m(mhVar);
                ab.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", Integer.valueOf(this.cpq));
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
                ab.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", Integer.valueOf(arrayList.size()));
                com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, false);
                AppMethodBeat.o(55742);
                z = z2;
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void EN() {
        AppMethodBeat.i(55743);
        if (this.cpM != null) {
            this.cpM.bN(this.cpR, this.cpq);
        }
        AppMethodBeat.o(55743);
    }

    public final int EO() {
        AppMethodBeat.i(55744);
        if (this.cpN != null) {
            int EO = this.cpN.EO();
            AppMethodBeat.o(55744);
            return EO;
        }
        AppMethodBeat.o(55744);
        return -1;
    }
}
