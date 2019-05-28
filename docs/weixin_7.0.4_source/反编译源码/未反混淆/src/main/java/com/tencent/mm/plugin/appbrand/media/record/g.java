package com.tencent.mm.plugin.appbrand.media.record;

import android.media.AudioRecord;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.media.record.a.c;
import com.tencent.mm.plugin.appbrand.media.record.a.e;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;

public final class g {
    private static Object cli = new Object();
    private static g ilA;
    private ap ikY = null;
    private e ilB = new e() {
        public final void aIh() {
            AppMethodBeat.i(105605);
            if (g.this.ilx) {
                ab.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
                AppMethodBeat.o(105605);
                return;
            }
            g.this.aIr();
            AppMethodBeat.o(105605);
        }

        public final void aIi() {
            AppMethodBeat.i(105606);
            if (g.this.ilx) {
                g gVar = g.this;
                gVar.ilx = false;
                ab.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
                b mbVar = new mb();
                mbVar.cHS.action = 7;
                mbVar.cHS.state = "interruptionEnd";
                if (gVar.ilo != null) {
                    mbVar.cHS.appId = gVar.ilo.appId;
                }
                com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
                AppMethodBeat.o(105606);
                return;
            }
            ab.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
            AppMethodBeat.o(105606);
        }
    };
    public com.tencent.mm.plugin.appbrand.media.record.record_imp.a ilm = null;
    private Object iln = new Object();
    public RecordParam ilo;
    a ilp = a.INITIALIZING;
    private c ilq = null;
    private boolean ilr = false;
    private int ils = 0;
    private long ilt = 0;
    private int ilu = 0;
    private ak ilv;
    boolean ilw = false;
    boolean ilx = false;
    private com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a ily = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a() {
        public final void u(byte[] bArr, int i) {
            AppMethodBeat.i(105601);
            if (!(g.this.ilq == null || g.this.ilm == null)) {
                int i2;
                g gVar = g.this;
                int c = g.this.ils;
                com.tencent.mm.plugin.appbrand.media.record.record_imp.a b = g.this.ilm;
                if (b.coZ != null) {
                    i2 = b.coZ.cpw;
                } else {
                    i2 = 20;
                }
                gVar.ils = i2 + c;
                try {
                    if (!g.this.ilq.a(g.this.ilr, bArr, i)) {
                        ab.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
                    }
                    AppMethodBeat.o(105601);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "onRecPcmDataReady", new Object[0]);
                    if (g.this.ilo != null && "mp3".equalsIgnoreCase(g.this.ilo.hAQ)) {
                        j.pk(19);
                        AppMethodBeat.o(105601);
                        return;
                    } else if (g.this.ilo != null && "aac".equalsIgnoreCase(g.this.ilo.hAQ)) {
                        j.pk(23);
                    }
                }
            }
            AppMethodBeat.o(105601);
        }

        public final void bN(int i, int i2) {
            AppMethodBeat.i(105602);
            ab.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", Integer.valueOf(i), Integer.valueOf(i2));
            g.this.onError(1);
            AppMethodBeat.o(105602);
        }
    };
    private com.tencent.mm.plugin.appbrand.media.record.a.c.a ilz = new com.tencent.mm.plugin.appbrand.media.record.a.c.a() {
        public final void d(byte[] bArr, int i, boolean z) {
            AppMethodBeat.i(105607);
            g gVar = g.this;
            ab.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", Integer.valueOf(i), Boolean.valueOf(z));
            b mbVar = new mb();
            mbVar.cHS.state = "frameRecorded";
            if (gVar.ilo != null) {
                mbVar.cHS.appId = gVar.ilo.appId;
            }
            mbVar.cHS.action = 5;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            mbVar.cHS.frameBuffer = bArr2;
            mbVar.cHS.cHT = z;
            com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
            AppMethodBeat.o(105607);
        }
    };
    private long mDuration = 0;
    private String mFilePath;
    public boolean mIsRecording = false;
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$7 */
    public class AnonymousClass7 implements Runnable {
        final /* synthetic */ RecordParam ilD;

        public AnonymousClass7(RecordParam recordParam) {
            this.ilD = recordParam;
        }

        public final void run() {
            AppMethodBeat.i(105609);
            synchronized (g.this.iln) {
                try {
                    g.this.ilo = this.ilD;
                    g.g(g.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(105609);
                }
            }
        }
    }

    public enum a {
        INITIALIZING,
        START,
        RESUME,
        PAUSE,
        STOP,
        ERROR;

        static {
            AppMethodBeat.o(105617);
        }
    }

    static /* synthetic */ void i(g gVar) {
        AppMethodBeat.i(105631);
        gVar.aIp();
        AppMethodBeat.o(105631);
    }

    static /* synthetic */ void k(g gVar) {
        AppMethodBeat.i(105633);
        gVar.stopTimer();
        AppMethodBeat.o(105633);
    }

    private void stopTimer() {
        AppMethodBeat.i(105618);
        ab.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
        if (this.ikY != null) {
            this.ikY.stopTimer();
        }
        this.ikY = null;
        AppMethodBeat.o(105618);
    }

    static {
        AppMethodBeat.i(105634);
        AppMethodBeat.o(105634);
    }

    private g() {
        AppMethodBeat.i(105619);
        AppMethodBeat.o(105619);
    }

    public static g aIm() {
        g gVar;
        AppMethodBeat.i(105620);
        synchronized (cli) {
            try {
                if (ilA == null) {
                    ilA = new g();
                }
                gVar = ilA;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(105620);
            }
        }
        return gVar;
    }

    public final boolean DA() {
        return this.ilp == a.PAUSE;
    }

    public final boolean DB() {
        return this.ilp == a.STOP;
    }

    public final boolean EB() {
        AppMethodBeat.i(105621);
        ab.i("MicroMsg.Record.AudioRecordMgr", JsApiStopRecordVoice.NAME);
        if (this.ilm == null && this.ilq == null) {
            ab.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            AppMethodBeat.o(105621);
            return false;
        }
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(105612);
                synchronized (g.this.iln) {
                    try {
                        g.i(g.this);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(105612);
                    }
                }
            }
        }, "app_brand_stop_record");
        AppMethodBeat.o(105621);
        return true;
    }

    private boolean EM() {
        boolean z;
        AppMethodBeat.i(105622);
        ab.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
        if (this.ilm != null) {
            this.ilm.EB();
            this.ilm = null;
            ab.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.ilm == null) {
            this.ilm = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.ilo);
            this.ilm.imh = this.ily;
        }
        com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = this.ilm;
        ab.i("MicroMsg.Record.AppBrandRecorder", JsApiStartRecordVoice.NAME);
        if (aVar.coZ != null) {
            aVar.coZ.EB();
            aVar.coZ = null;
        }
        aVar.img = System.currentTimeMillis();
        ab.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", Long.valueOf(aVar.img));
        aVar.coZ = new com.tencent.mm.audio.b.c(aVar.sampleRate, aVar.aOn, aVar.cpA);
        if ("mp3".equalsIgnoreCase(aVar.imf.hAQ)) {
            aVar.coZ.gG(40);
        } else {
            aVar.coZ.gG(20);
        }
        aVar.coZ.bq(false);
        aVar.coZ.cpM = aVar.imi;
        com.tencent.mm.audio.b.c cVar = aVar.coZ;
        int i = aVar.imf.imn.ilf;
        cVar.cpu = i;
        ab.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(i)));
        if (aVar.coZ.EL()) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", Boolean.valueOf(z));
        AppMethodBeat.o(105622);
        return z;
    }

    private boolean aIn() {
        c cVar = null;
        AppMethodBeat.i(105623);
        ab.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
        if (this.ilq != null) {
            this.ilq.close();
            this.ilq = null;
        }
        this.mFilePath = h.cE(this.ilo.hAQ, this.ilo.euD);
        ab.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", this.mFilePath);
        String str = this.ilo.hAQ;
        ab.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", str);
        if (h.Cz(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                cVar = new com.tencent.mm.plugin.appbrand.media.record.a.a();
            } else if ("mp3".equalsIgnoreCase(str)) {
                cVar = new com.tencent.mm.plugin.appbrand.media.record.a.d();
            } else if ("wav".equalsIgnoreCase(str)) {
                cVar = new e();
            }
        }
        this.ilq = cVar;
        if (this.ilq != null) {
            boolean CA = h.CA(this.mFilePath);
            if (CA) {
                try {
                    CA = this.ilq.h(this.mFilePath, this.ilo.sampleRate, this.ilo.imk, this.ilo.iml);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "init encoder fail", new Object[0]);
                    CA = false;
                }
                this.ilq.a(this.ilz);
                AppMethodBeat.o(105623);
                return CA;
            }
            ab.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
            AppMethodBeat.o(105623);
            return CA;
        }
        AppMethodBeat.o(105623);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void aIo() {
        AppMethodBeat.i(105624);
        ab.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
        boolean EB;
        try {
            if (DA()) {
                ab.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                AppMethodBeat.o(105624);
                return;
            }
            if (this.ilm != null) {
                EB = this.ilm.EB();
                this.ilm = null;
            } else {
                EB = false;
            }
            if (!(this.ilo == null || this.ilo.imo == null)) {
                ab.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", Boolean.valueOf(this.ilx), Boolean.valueOf(this.ilo.imo.aIj()));
                if (this.ilo.imo.aIj() && !this.ilx) {
                    aIr();
                }
            }
            aIq().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(105603);
                    g.k(g.this);
                    AppMethodBeat.o(105603);
                }
            });
            ab.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.ilu));
            this.ilu = (int) (((long) this.ilu) + r4);
            this.ilt = this.mDuration - ((long) this.ilu);
            ab.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.ilt), Integer.valueOf(this.ilu));
            ab.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(EB));
            if (EB) {
                ab.i("MicroMsg.Record.AudioRecordMgr", "onPause");
                this.ilp = a.PAUSE;
                this.mIsRecording = false;
                b mbVar = new mb();
                mbVar.cHS.action = 3;
                mbVar.cHS.state = "pause";
                if (this.ilo != null) {
                    mbVar.cHS.appId = this.ilo.appId;
                }
                com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
                ab.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
                AppMethodBeat.o(105624);
                return;
            }
            onError(8);
            ab.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
            AppMethodBeat.o(105624);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_pause", new Object[0]);
            EB = false;
        }
    }

    private void aIp() {
        AppMethodBeat.i(105625);
        ab.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
        boolean EB;
        try {
            if (DB()) {
                ab.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
                AppMethodBeat.o(105625);
                return;
            }
            if (this.ilm != null) {
                EB = this.ilm.EB();
                this.ilm = null;
            } else {
                ab.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
                EB = true;
            }
            this.ilr = true;
            ab.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", Integer.valueOf(this.ils));
            if (this.ilq != null) {
                this.ilq.flush();
                this.ilq.close();
                this.ilq = null;
            }
            aIq().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(105604);
                    g.k(g.this);
                    AppMethodBeat.o(105604);
                }
            });
            if (DA()) {
                ab.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                ab.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.ilu));
                this.ilu = (int) (((long) this.ilu) + r6);
                this.ilt = this.mDuration - ((long) this.ilu);
                ab.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.ilt), Integer.valueOf(this.ilu));
            }
            ab.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(EB));
            if (EB) {
                ab.i("MicroMsg.Record.AudioRecordMgr", "onStop");
                this.ilp = a.STOP;
                this.mIsRecording = false;
                b mbVar = new mb();
                mbVar.cHS.action = 2;
                mbVar.cHS.state = "stop";
                if (this.ilo != null) {
                    mbVar.cHS.appId = this.ilo.appId;
                }
                ab.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", Integer.valueOf(this.ils), Integer.valueOf(this.ilu));
                mbVar.cHS.duration = Math.min(this.ils, this.ilu);
                mbVar.cHS.filePath = this.mFilePath;
                mbVar.cHS.fileSize = (int) h.CB(this.mFilePath);
                com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
                ab.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
            } else {
                onError(9);
                ab.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
            }
            this.ilo = null;
            d.aIg();
            AppMethodBeat.o(105625);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_stop", new Object[0]);
            EB = false;
        }
    }

    private ak aIq() {
        AppMethodBeat.i(105626);
        if (this.ilv == null) {
            this.ilv = new ak(Looper.getMainLooper());
        }
        ak akVar = this.ilv;
        AppMethodBeat.o(105626);
        return akVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onError(int i) {
        AppMethodBeat.i(105627);
        ab.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", Integer.valueOf(i));
        if (this.ilp != a.ERROR) {
            j.pj(i);
        }
        this.ilp = a.ERROR;
        this.mIsRecording = false;
        b mbVar = new mb();
        mbVar.cHS.action = 4;
        mbVar.cHS.state = "error";
        if (this.ilo != null) {
            mbVar.cHS.appId = this.ilo.appId;
        }
        mbVar.cHS.errCode = i;
        mbVar.cHS.aIm = i.ph(i);
        com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
        AppMethodBeat.o(105627);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aIr() {
        AppMethodBeat.i(105628);
        this.ilx = true;
        ab.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
        b mbVar = new mb();
        mbVar.cHS.action = 6;
        mbVar.cHS.state = "interruptionBegin";
        if (this.ilo != null) {
            mbVar.cHS.appId = this.ilo.appId;
        }
        com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
        AppMethodBeat.o(105628);
    }

    static /* synthetic */ void g(g gVar) {
        AppMethodBeat.i(105629);
        try {
            ab.i("MicroMsg.Record.AudioRecordMgr", "_start in runnable");
            if (gVar.aIn()) {
                gVar.ilr = false;
                gVar.ils = 0;
                if (!gVar.ilw) {
                    gVar.ilw = true;
                    if (!(gVar.ilo == null || gVar.ilo.imo == null)) {
                        gVar.ilo.imo.a(gVar.ilB);
                        gVar.ilo.imo.aIk();
                    }
                }
                if (gVar.EM()) {
                    int i;
                    c cVar = gVar.ilq;
                    com.tencent.mm.plugin.appbrand.media.record.record_imp.a aVar = gVar.ilm;
                    if (aVar.coZ != null) {
                        com.tencent.mm.audio.b.c cVar2 = aVar.coZ;
                        if (cVar2.cpS > 0) {
                            i = cVar2.cpS;
                        } else {
                            int minBufferSize = AudioRecord.getMinBufferSize(cVar2.mSampleRate, cVar2.cpQ, 2);
                            ab.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", Integer.valueOf(minBufferSize));
                            if (minBufferSize == -2 || minBufferSize == -1) {
                                i = 0;
                            } else {
                                cVar2.cpS = minBufferSize * cVar2.cpz;
                                i = cVar2.cpS;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    cVar.pl(i);
                    gVar.ilq.t(gVar.ilo.imm);
                    gVar.ilu = 0;
                    gVar.mDuration = (long) gVar.ilo.duration;
                    gVar.mStartTime = System.currentTimeMillis();
                    gVar.ilt = gVar.mDuration;
                    ab.i("MicroMsg.Record.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", Long.valueOf(gVar.mDuration), Long.valueOf(gVar.mStartTime));
                    gVar.aIq().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(105613);
                            g.a(g.this, g.this.ilt);
                            AppMethodBeat.o(105613);
                        }
                    });
                    ab.i("MicroMsg.Record.AudioRecordMgr", "onStart");
                    gVar.ilp = a.START;
                    gVar.mIsRecording = true;
                    b mbVar = new mb();
                    mbVar.cHS.action = 0;
                    mbVar.cHS.state = "start";
                    if (gVar.ilo != null) {
                        mbVar.cHS.appId = gVar.ilo.appId;
                    }
                    com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
                    ab.i("MicroMsg.Record.AudioRecordMgr", "start record success");
                    AppMethodBeat.o(105629);
                    return;
                }
                gVar.onError(6);
                ab.e("MicroMsg.Record.AudioRecordMgr", "start record fail");
                AppMethodBeat.o(105629);
                return;
            }
            gVar.onError(2);
            ab.e("MicroMsg.Record.AudioRecordMgr", "init encoder fail");
            AppMethodBeat.o(105629);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_start", new Object[0]);
            gVar.onError(4);
            AppMethodBeat.o(105629);
        }
    }

    static /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(105630);
        try {
            ab.i("MicroMsg.Record.AudioRecordMgr", "_resume in runnable");
            if (gVar.ilq == null) {
                gVar.onError(3);
                ab.e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                AppMethodBeat.o(105630);
            } else if (gVar.ilt <= 0) {
                gVar.aIp();
                ab.e("MicroMsg.Record.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
                AppMethodBeat.o(105630);
            } else if (gVar.EM()) {
                gVar.mStartTime = System.currentTimeMillis();
                ab.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", Long.valueOf(gVar.ilt), Long.valueOf(gVar.mStartTime));
                gVar.aIq().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(105614);
                        g.a(g.this, g.this.ilt);
                        AppMethodBeat.o(105614);
                    }
                });
                ab.i("MicroMsg.Record.AudioRecordMgr", "onResume");
                gVar.ilp = a.RESUME;
                gVar.mIsRecording = true;
                b mbVar = new mb();
                mbVar.cHS.action = 1;
                mbVar.cHS.state = "resume";
                if (gVar.ilo != null) {
                    mbVar.cHS.appId = gVar.ilo.appId;
                }
                com.tencent.mm.sdk.b.a.xxA.a(mbVar, Looper.getMainLooper());
                ab.i("MicroMsg.Record.AudioRecordMgr", "resume record success");
                AppMethodBeat.o(105630);
            } else {
                gVar.onError(7);
                ab.e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                AppMethodBeat.o(105630);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_resume", new Object[0]);
            gVar.onError(5);
            AppMethodBeat.o(105630);
        }
    }
}
