package com.tencent.mm.audio.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.c;
import com.tencent.mm.bf.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;

public final class b {
    private static Object coV = new Object();
    private int coK = 0;
    private String coL = null;
    private int coM;
    private final Object coN = new Object();
    private c coO = null;
    private a coP;
    private com.tencent.mm.bf.c coQ = null;
    private com.tencent.mm.bf.d.a coR = null;
    private long coS = 0;
    private long coT = 0;
    private int coU = 0;
    private int coW = TXRecordCommon.AUDIO_SAMPLERATE_16000;
    private boolean coX = false;
    public MediaRecorder coY;
    public c coZ = null;
    public com.tencent.mm.compatible.b.c.a cpa;
    public b cpb;
    private volatile boolean cpc = false;
    private com.tencent.mm.compatible.util.g.a cpd = new com.tencent.mm.compatible.util.g.a();
    private int cpe = 0;
    private int cpf = 0;
    private com.tencent.mm.audio.b.c.a cpg = new com.tencent.mm.audio.b.c.a() {
        /* JADX WARNING: Missing block: B:100:0x02ff, code skipped:
            if (com.tencent.mm.audio.b.b.q(r11.cpi) != com.tencent.ugc.TXRecordCommon.AUDIO_SAMPLERATE_16000) goto L_0x0306;
     */
        /* JADX WARNING: Missing block: B:101:0x0301, code skipped:
            r12 = com.tencent.mm.audio.b.b.AnonymousClass2.v(r12, r13);
            r13 = r12.length;
     */
        /* JADX WARNING: Missing block: B:102:0x0306, code skipped:
            w(r12, r13);
            com.tencent.matrix.trace.core.AppMethodBeat.o(116476);
     */
        /* JADX WARNING: Missing block: B:111:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void u(byte[] bArr, int i) {
            int i2 = -1;
            boolean z = false;
            AppMethodBeat.i(116476);
            ab.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", Boolean.valueOf(b.this.cpc));
            if (b.this.cpb != b.STOPPED || b.this.cpc) {
                boolean z2;
                synchronized (b.coV) {
                    try {
                        if (b.this.cpc) {
                            if (b.this.coZ != null) {
                                ab.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", bArr, Integer.valueOf(i));
                                b.this.coZ.EB();
                                b.this.coZ.cpM = null;
                                b.this.coZ = null;
                                z = true;
                            } else {
                                ab.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
                            }
                            b.this.cpc = false;
                        }
                        z2 = z;
                    } catch (Throwable th) {
                        AppMethodBeat.o(116476);
                        throw th;
                    }
                }
                long gb = bo.gb(b.this.coT);
                if (b.this.coS <= 0 || gb <= b.this.coS) {
                    ab.d("MicroMsg.MMAudioRecorder", "read :" + i + " time: " + b.this.cpd.Mr() + " dataReadedCnt: " + b.this.coU);
                    if (i >= 0) {
                        b.this.coU = b.this.coU + i;
                        synchronized (b.this.coN) {
                            try {
                                com.tencent.mm.bf.c m;
                                if (b.this.coQ == null && ((b.this.cpa == com.tencent.mm.compatible.b.c.a.PCM || b.this.cpa == com.tencent.mm.compatible.b.c.a.SILK) && b.this.coR != null && b.this.coX)) {
                                    b.this.coQ = new com.tencent.mm.bf.c();
                                    m = b.this.coQ;
                                    int q = b.this.mSampleRate;
                                    ab.i("MicroMsg.SpeexEncoderWorker", "init ");
                                    m.fQA.clear();
                                    com.tencent.mm.bf.d.b bVar = new com.tencent.mm.bf.d.b();
                                    bVar.fNY = d.getPrefix();
                                    bVar.sampleRate = q;
                                    bVar.fQw = 1;
                                    bVar.aTg = 16;
                                    m.mFileName = String.format("%s%d_%d_%d_%d", new Object[]{bVar.fNY, Integer.valueOf(bVar.sampleRate), Integer.valueOf(bVar.fQw), Integer.valueOf(bVar.aTg), Long.valueOf(System.currentTimeMillis())});
                                }
                                if (b.this.coQ != null) {
                                    m = b.this.coQ;
                                    ab.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + m.fQA.size());
                                    if (bArr != null && bArr.length > 0) {
                                        m.fQA.add(new com.tencent.mm.audio.b.g.a(bArr, bArr.length));
                                    }
                                }
                                if (b.this.cpa == com.tencent.mm.compatible.b.c.a.SILK) {
                                    int i3;
                                    if (b.this.coO == null) {
                                        b.this.coO = new c(b.this.mSampleRate, b.this.coW);
                                        b.this.coO.eo(b.this.coL);
                                    }
                                    w(bArr, i);
                                    c r = b.this.coO;
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
                                    ab.d(str, str2, objArr);
                                    if (i > 0) {
                                        synchronized (r) {
                                            if (r.cro) {
                                                ab.e("MicroMsg.SilkWriter", "already stop");
                                            } else {
                                                if (r.cru == null) {
                                                    r.cru = new com.tencent.mm.audio.d.c.a(r, (byte) 0);
                                                    com.tencent.mm.sdk.g.d.post(r.cru, "SilkWriter_run");
                                                }
                                                if (r.crn != null) {
                                                    r.crn.add(new com.tencent.mm.audio.b.g.a(bArr, i, z2));
                                                }
                                            }
                                        }
                                    }
                                    AppMethodBeat.o(116476);
                                    return;
                                }
                            } catch (Throwable th2) {
                                AppMethodBeat.o(116476);
                                throw th2;
                            }
                        }
                    } else if (b.this.cpb == b.STOPPED) {
                        ab.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
                        AppMethodBeat.o(116476);
                        return;
                    } else {
                        new ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(116475);
                                b.this.EH();
                                if (b.this.coP != null) {
                                    b.this.coP.onError();
                                }
                                AppMethodBeat.o(116475);
                            }
                        });
                        AppMethodBeat.o(116476);
                        return;
                    }
                }
                ab.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:".concat(String.valueOf(gb)));
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(116474);
                        b.this.EH();
                        if (b.this.coP != null) {
                            b.this.coP.onError();
                        }
                        AppMethodBeat.o(116474);
                    }
                });
                AppMethodBeat.o(116476);
                return;
            }
            ab.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
            AppMethodBeat.o(116476);
        }

        private static byte[] v(byte[] bArr, int i) {
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

        private void w(byte[] bArr, int i) {
            AppMethodBeat.i(116477);
            for (int i2 = 0; i2 < i / 2; i2++) {
                short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                if (s > b.this.coK) {
                    b.this.coK = s;
                }
            }
            AppMethodBeat.o(116477);
        }

        public final void bN(int i, int i2) {
        }
    };
    private boolean cph = false;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;

    public enum b {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED;

        static {
            AppMethodBeat.o(116480);
        }
    }

    public interface a {
        void onError();
    }

    static {
        AppMethodBeat.i(116494);
        AppMethodBeat.o(116494);
    }

    public b(com.tencent.mm.compatible.b.c.a aVar) {
        AppMethodBeat.i(116481);
        ab.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: ".concat(String.valueOf(aVar)));
        this.cpa = aVar;
        if (!com.tencent.mm.audio.b.g.b.ES()) {
            ab.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.cpa = com.tencent.mm.compatible.b.c.a.AMR;
        }
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            this.coM = 7;
            this.coY = new MediaRecorder();
        } else {
            EG();
            this.coM = 1;
        }
        this.cpc = false;
        AppMethodBeat.o(116481);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(116482);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY == null) {
                AppMethodBeat.o(116482);
                return;
            }
            this.coP = aVar;
            this.coY.setOnErrorListener(new OnErrorListener() {
                public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                    AppMethodBeat.i(116473);
                    if (b.this.coP != null) {
                        b.this.coP.onError();
                    }
                    try {
                        b.this.coY.release();
                    } catch (Exception e) {
                        ab.e("MicroMsg.MMAudioRecorder", e.getMessage());
                    }
                    b.this.cpb = b.ERROR;
                    AppMethodBeat.o(116473);
                }
            });
            AppMethodBeat.o(116482);
        } else if (this.cpb == b.INITIALIZING) {
            this.coP = aVar;
            AppMethodBeat.o(116482);
        } else {
            ab.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
            AppMethodBeat.o(116482);
        }
    }

    public final void setOutputFile(String str) {
        AppMethodBeat.i(116483);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY == null) {
                AppMethodBeat.o(116483);
                return;
            }
            this.coY.setOutputFile(str);
            this.coL = str;
            AppMethodBeat.o(116483);
        } else if (this.cpb == b.INITIALIZING) {
            this.coL = str;
            AppMethodBeat.o(116483);
        } else {
            ab.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.cpb = b.ERROR;
            AppMethodBeat.o(116483);
        }
    }

    public final void setMaxDuration(int i) {
        AppMethodBeat.i(116484);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY != null) {
                this.coY.setMaxDuration(i);
            }
            AppMethodBeat.o(116484);
            return;
        }
        this.coS = (long) i;
        AppMethodBeat.o(116484);
    }

    public final void ED() {
        AppMethodBeat.i(116485);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY != null) {
                this.coY.setAudioEncoder(1);
            }
            AppMethodBeat.o(116485);
            return;
        }
        AppMethodBeat.o(116485);
    }

    public final void EE() {
        AppMethodBeat.i(116486);
        if (this.cpa != com.tencent.mm.compatible.b.c.a.AMR) {
            AppMethodBeat.o(116486);
        } else if (this.coY == null) {
            AppMethodBeat.o(116486);
        } else {
            this.coY.setAudioSource(1);
            AppMethodBeat.o(116486);
        }
    }

    public final void EF() {
        AppMethodBeat.i(116487);
        if (this.cpa != com.tencent.mm.compatible.b.c.a.AMR) {
            AppMethodBeat.o(116487);
        } else if (this.coY == null) {
            AppMethodBeat.o(116487);
        } else {
            this.coY.setOutputFormat(3);
            AppMethodBeat.o(116487);
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.i(116488);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY == null) {
                AppMethodBeat.o(116488);
                return 0;
            }
            int maxAmplitude = this.coY.getMaxAmplitude();
            AppMethodBeat.o(116488);
            return maxAmplitude;
        } else if (this.cpb == b.RECORDING) {
            int i = this.coK;
            this.coK = 0;
            AppMethodBeat.o(116488);
            return i;
        } else {
            AppMethodBeat.o(116488);
            return 0;
        }
    }

    public final void EG() {
        AppMethodBeat.i(116489);
        this.coR = com.tencent.mm.bf.d.a.ajX();
        if (this.coR != null) {
            this.coX = this.coR.ajW();
        }
        if (this.cpa == com.tencent.mm.compatible.b.c.a.SILK) {
            this.mSampleRate = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("VoiceSamplingRate"), TXRecordCommon.AUDIO_SAMPLERATE_16000);
            this.coW = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("VoiceRate"), TXRecordCommon.AUDIO_SAMPLERATE_16000);
            ab.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", r1, Integer.valueOf(this.mSampleRate), r0, Integer.valueOf(this.coW));
        } else {
            if (this.coX) {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
            } else {
                this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
            }
            g.RQ();
            int a = bo.a((Integer) g.RP().eJH.get(27), 0);
            ab.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + a);
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
                AppMethodBeat.o(116489);
            }
        }
        this.coU = 0;
        try {
            synchronized (coV) {
                this.coZ = new c(this.mSampleRate, 1, 0);
                this.coZ.bq(true);
                this.coZ.gG(120);
                this.coZ.cpM = this.cpg;
            }
            this.cpb = b.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                ab.e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                ab.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.cpb = b.ERROR;
            AppMethodBeat.o(116489);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(116489);
            }
        }
    }

    public final void start() {
        AppMethodBeat.i(116490);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY != null) {
                this.coY.start();
            }
            AppMethodBeat.o(116490);
            return;
        }
        ab.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.cpb + " recMode: " + this.cpa);
        if (this.cpb == b.READY) {
            this.coT = System.currentTimeMillis();
            this.coU = 0;
            this.cpb = b.RECORDING;
            synchronized (coV) {
                try {
                    this.coZ.EL();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(116490);
                    }
                }
            }
        } else {
            g.RQ();
            g.RP().eJH.set(27, Integer.valueOf(1));
            ab.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
            this.cpb = b.ERROR;
        }
        this.cpc = false;
        AppMethodBeat.o(116490);
    }

    public final void prepare() {
        AppMethodBeat.i(116491);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY != null) {
                this.coY.prepare();
            }
            AppMethodBeat.o(116491);
        } else if (this.cpb != b.INITIALIZING || this.coL == null) {
            this.cpb = b.ERROR;
            release();
            AppMethodBeat.o(116491);
        } else {
            this.cpb = b.READY;
            AppMethodBeat.o(116491);
        }
    }

    public final void release() {
        AppMethodBeat.i(116492);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            if (this.coY != null) {
                this.coY.release();
            }
            AppMethodBeat.o(116492);
            return;
        }
        if (this.cpb == b.RECORDING) {
            EH();
        } else {
            b bVar = b.READY;
        }
        synchronized (coV) {
            try {
                if (this.coZ != null) {
                    this.coZ.EB();
                    this.coZ.cpM = null;
                    this.coZ = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(116492);
            }
        }
    }

    public final boolean EH() {
        AppMethodBeat.i(116493);
        if (this.cpa == com.tencent.mm.compatible.b.c.a.AMR) {
            ab.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", this.coY);
            if (this.coY != null) {
                this.coY.stop();
                this.coY.release();
                this.coY = null;
            }
            AppMethodBeat.o(116493);
            return true;
        }
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        ab.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.cpb);
        if (this.cpb == b.INITIALIZING) {
            h.pYm.a(357, 53, 1, true);
            if (!this.cph) {
                h.pYm.a(357, 54, 1, true);
            }
            this.cph = true;
        }
        if (this.cpb != b.RECORDING) {
            ab.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.cpb = b.ERROR;
            AppMethodBeat.o(116493);
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
                AppMethodBeat.o(116493);
            }
        }
        long Mr = aVar.Mr();
        this.cpb = b.STOPPED;
        long Mr2 = aVar.Mr();
        if (this.cpc) {
            ab.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", Boolean.valueOf(this.cpc));
            int i = 0;
            while (this.cpc) {
                i++;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                }
                if (i >= 25) {
                    synchronized (coV) {
                        try {
                            ab.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", this.coZ);
                            if (this.coZ != null) {
                                this.coZ.EB();
                                this.coZ.cpM = null;
                                this.coZ = null;
                            }
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                        } catch (Throwable th2) {
                            AppMethodBeat.o(116493);
                        }
                    }
                    ab.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.cpc), Integer.valueOf(i));
                }
            }
            ab.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.cpc), Integer.valueOf(i));
        }
        synchronized (this.coN) {
            try {
                if (this.coO != null) {
                    this.coO.Fe();
                }
                if (this.coQ != null) {
                    com.tencent.mm.bf.c cVar = this.coQ;
                    ab.i("MicroMsg.SpeexEncoderWorker", "stop ");
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(116540);
                            Looper.myQueue().addIdleHandler(new IdleHandler() {
                                public final boolean queueIdle() {
                                    AppMethodBeat.i(116539);
                                    ab.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
                                    e.ajY().b(c.this);
                                    AppMethodBeat.o(116539);
                                    return false;
                                }
                            });
                            AppMethodBeat.o(116540);
                        }
                    });
                }
            } catch (Throwable th3) {
                while (true) {
                    AppMethodBeat.o(116493);
                }
            }
        }
        long gb = bo.gb(this.coT);
        ab.i("MicroMsg.MMAudioRecorder", "toNow " + gb + " startTickCnt: " + this.coT + " pcmDataReadedCnt: " + this.coU);
        if (gb > FaceGestureDetGLThread.BRIGHTNESS_DURATION && this.coU == 0) {
            g.RQ();
            g.RP().eJH.set(27, Integer.valueOf(1));
            ab.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        ab.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + Mr + " Read:" + Mr2 + " Thr:" + aVar.Mr());
        AppMethodBeat.o(116493);
        return false;
    }
}
