package com.tencent.p177mm.plugin.appbrand.media.record;

import android.media.AudioRecord;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C1292c;
import com.tencent.p177mm.p230g.p231a.C37761mb;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.plugin.appbrand.media.record.p1230a.C19603c;
import com.tencent.p177mm.plugin.appbrand.media.record.p1230a.C19603c.C19604a;
import com.tencent.p177mm.plugin.appbrand.media.record.p1230a.C19605d;
import com.tencent.p177mm.plugin.appbrand.media.record.p1230a.C19606e;
import com.tencent.p177mm.plugin.appbrand.media.record.p1230a.C42629a;
import com.tencent.p177mm.plugin.appbrand.media.record.record_imp.C10637a;
import com.tencent.p177mm.plugin.appbrand.media.record.record_imp.C10637a.C2393a;
import com.tencent.p177mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.g */
public final class C10626g {
    private static Object cli = new Object();
    private static C10626g ilA;
    private C7564ap ikY = null;
    private C38445e ilB = new C106324();
    public C10637a ilm = null;
    private Object iln = new Object();
    public RecordParam ilo;
    C10636a ilp = C10636a.INITIALIZING;
    private C19603c ilq = null;
    private boolean ilr = false;
    private int ils = 0;
    private long ilt = 0;
    private int ilu = 0;
    private C7306ak ilv;
    boolean ilw = false;
    boolean ilx = false;
    private C2393a ily = new C106311();
    private C19604a ilz = new C106335();
    private long mDuration = 0;
    private String mFilePath;
    public boolean mIsRecording = false;
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$3 */
    class C23913 implements Runnable {
        C23913() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105604);
            C10626g.m18326k(C10626g.this);
            AppMethodBeat.m2505o(105604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$8 */
    public class C23928 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(105610);
            synchronized (C10626g.this.iln) {
                try {
                    C10626g.m18323h(C10626g.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(105610);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$2 */
    class C106252 implements Runnable {
        C106252() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105603);
            C10626g.m18326k(C10626g.this);
            AppMethodBeat.m2505o(105603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$10 */
    class C1062710 implements Runnable {
        C1062710() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105612);
            synchronized (C10626g.this.iln) {
                try {
                    C10626g.m18324i(C10626g.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(105612);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$9 */
    public class C106289 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(105611);
            synchronized (C10626g.this.iln) {
                try {
                    C10626g.this.aIo();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(105611);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$11 */
    class C1062911 implements Runnable {
        C1062911() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105613);
            C10626g.m18316a(C10626g.this, C10626g.this.ilt);
            AppMethodBeat.m2505o(105613);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$12 */
    class C1063012 implements Runnable {
        C1063012() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105614);
            C10626g.m18316a(C10626g.this, C10626g.this.ilt);
            AppMethodBeat.m2505o(105614);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$1 */
    class C106311 implements C2393a {
        C106311() {
        }

        /* renamed from: u */
        public final void mo6299u(byte[] bArr, int i) {
            AppMethodBeat.m2504i(105601);
            if (!(C10626g.this.ilq == null || C10626g.this.ilm == null)) {
                int i2;
                C10626g c10626g = C10626g.this;
                int c = C10626g.this.ils;
                C10637a b = C10626g.this.ilm;
                if (b.coZ != null) {
                    i2 = b.coZ.cpw;
                } else {
                    i2 = 20;
                }
                c10626g.ils = i2 + c;
                try {
                    if (!C10626g.this.ilq.mo34811a(C10626g.this.ilr, bArr, i)) {
                        C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
                    }
                    AppMethodBeat.m2505o(105601);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "onRecPcmDataReady", new Object[0]);
                    if (C10626g.this.ilo != null && "mp3".equalsIgnoreCase(C10626g.this.ilo.hAQ)) {
                        C27203j.m43227pk(19);
                        AppMethodBeat.m2505o(105601);
                        return;
                    } else if (C10626g.this.ilo != null && "aac".equalsIgnoreCase(C10626g.this.ilo.hAQ)) {
                        C27203j.m43227pk(23);
                    }
                }
            }
            AppMethodBeat.m2505o(105601);
        }

        /* renamed from: bN */
        public final void mo6298bN(int i, int i2) {
            AppMethodBeat.m2504i(105602);
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C10626g.this.onError(1);
            AppMethodBeat.m2505o(105602);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$4 */
    class C106324 implements C38445e {
        C106324() {
        }

        public final void aIh() {
            AppMethodBeat.m2504i(105605);
            if (C10626g.this.ilx) {
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
                AppMethodBeat.m2505o(105605);
                return;
            }
            C10626g.this.aIr();
            AppMethodBeat.m2505o(105605);
        }

        public final void aIi() {
            AppMethodBeat.m2504i(105606);
            if (C10626g.this.ilx) {
                C10626g c10626g = C10626g.this;
                c10626g.ilx = false;
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
                C4883b c37761mb = new C37761mb();
                c37761mb.cHS.action = 7;
                c37761mb.cHS.state = "interruptionEnd";
                if (c10626g.ilo != null) {
                    c37761mb.cHS.appId = c10626g.ilo.appId;
                }
                C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
                AppMethodBeat.m2505o(105606);
                return;
            }
            C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
            AppMethodBeat.m2505o(105606);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$5 */
    class C106335 implements C19604a {
        C106335() {
        }

        /* renamed from: d */
        public final void mo22161d(byte[] bArr, int i, boolean z) {
            AppMethodBeat.m2504i(105607);
            C10626g c10626g = C10626g.this;
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", Integer.valueOf(i), Boolean.valueOf(z));
            C4883b c37761mb = new C37761mb();
            c37761mb.cHS.state = "frameRecorded";
            if (c10626g.ilo != null) {
                c37761mb.cHS.appId = c10626g.ilo.appId;
            }
            c37761mb.cHS.action = 5;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            c37761mb.cHS.frameBuffer = bArr2;
            c37761mb.cHS.cHT = z;
            C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
            AppMethodBeat.m2505o(105607);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$6 */
    class C106346 implements C5015a {
        C106346() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(105608);
            C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "timer, onTimerExpired to stop record");
            C10626g.this.mo22151EB();
            AppMethodBeat.m2505o(105608);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$7 */
    public class C106357 implements Runnable {
        final /* synthetic */ RecordParam ilD;

        public C106357(RecordParam recordParam) {
            this.ilD = recordParam;
        }

        public final void run() {
            AppMethodBeat.m2504i(105609);
            synchronized (C10626g.this.iln) {
                try {
                    C10626g.this.ilo = this.ilD;
                    C10626g.m18322g(C10626g.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(105609);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.g$a */
    public enum C10636a {
        INITIALIZING,
        START,
        RESUME,
        PAUSE,
        STOP,
        ERROR;

        static {
            AppMethodBeat.m2505o(105617);
        }
    }

    /* renamed from: i */
    static /* synthetic */ void m18324i(C10626g c10626g) {
        AppMethodBeat.m2504i(105631);
        c10626g.aIp();
        AppMethodBeat.m2505o(105631);
    }

    /* renamed from: k */
    static /* synthetic */ void m18326k(C10626g c10626g) {
        AppMethodBeat.m2504i(105633);
        c10626g.stopTimer();
        AppMethodBeat.m2505o(105633);
    }

    private void stopTimer() {
        AppMethodBeat.m2504i(105618);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
        if (this.ikY != null) {
            this.ikY.stopTimer();
        }
        this.ikY = null;
        AppMethodBeat.m2505o(105618);
    }

    static {
        AppMethodBeat.m2504i(105634);
        AppMethodBeat.m2505o(105634);
    }

    private C10626g() {
        AppMethodBeat.m2504i(105619);
        AppMethodBeat.m2505o(105619);
    }

    public static C10626g aIm() {
        C10626g c10626g;
        AppMethodBeat.m2504i(105620);
        synchronized (cli) {
            try {
                if (ilA == null) {
                    ilA = new C10626g();
                }
                c10626g = ilA;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(105620);
            }
        }
        return c10626g;
    }

    /* renamed from: DA */
    public final boolean mo22149DA() {
        return this.ilp == C10636a.PAUSE;
    }

    /* renamed from: DB */
    public final boolean mo22150DB() {
        return this.ilp == C10636a.STOP;
    }

    /* renamed from: EB */
    public final boolean mo22151EB() {
        AppMethodBeat.m2504i(105621);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", JsApiStopRecordVoice.NAME);
        if (this.ilm == null && this.ilq == null) {
            C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            AppMethodBeat.m2505o(105621);
            return false;
        }
        C7305d.post(new C1062710(), "app_brand_stop_record");
        AppMethodBeat.m2505o(105621);
        return true;
    }

    /* renamed from: EM */
    private boolean m18312EM() {
        boolean z;
        AppMethodBeat.m2504i(105622);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
        if (this.ilm != null) {
            this.ilm.mo22163EB();
            this.ilm = null;
            C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.ilm == null) {
            this.ilm = new C10637a(this.ilo);
            this.ilm.imh = this.ily;
        }
        C10637a c10637a = this.ilm;
        C4990ab.m7416i("MicroMsg.Record.AppBrandRecorder", JsApiStartRecordVoice.NAME);
        if (c10637a.coZ != null) {
            c10637a.coZ.mo4590EB();
            c10637a.coZ = null;
        }
        c10637a.img = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", Long.valueOf(c10637a.img));
        c10637a.coZ = new C1292c(c10637a.sampleRate, c10637a.aOn, c10637a.cpA);
        if ("mp3".equalsIgnoreCase(c10637a.imf.hAQ)) {
            c10637a.coZ.mo4598gG(40);
        } else {
            c10637a.coZ.mo4598gG(20);
        }
        c10637a.coZ.mo4595bq(false);
        c10637a.coZ.cpM = c10637a.imi;
        C1292c c1292c = c10637a.coZ;
        int i = c10637a.imf.imn.ilf;
        c1292c.cpu = i;
        C4990ab.m7416i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(i)));
        if (c10637a.coZ.mo4592EL()) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "record start:%b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(105622);
        return z;
    }

    private boolean aIn() {
        C19603c c19603c = null;
        AppMethodBeat.m2504i(105623);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "initEncode");
        if (this.ilq != null) {
            this.ilq.close();
            this.ilq = null;
        }
        this.mFilePath = C27202h.m43225cE(this.ilo.hAQ, this.ilo.euD);
        C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", this.mFilePath);
        String str = this.ilo.hAQ;
        C4990ab.m7417i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", str);
        if (C27202h.m43223Cz(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                c19603c = new C42629a();
            } else if ("mp3".equalsIgnoreCase(str)) {
                c19603c = new C19605d();
            } else if ("wav".equalsIgnoreCase(str)) {
                c19603c = new C19606e();
            }
        }
        this.ilq = c19603c;
        if (this.ilq != null) {
            boolean CA = C27202h.m43220CA(this.mFilePath);
            if (CA) {
                try {
                    CA = this.ilq.mo34814h(this.mFilePath, this.ilo.sampleRate, this.ilo.imk, this.ilo.iml);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "init encoder fail", new Object[0]);
                    CA = false;
                }
                this.ilq.mo34810a(this.ilz);
                AppMethodBeat.m2505o(105623);
                return CA;
            }
            C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
            AppMethodBeat.m2505o(105623);
            return CA;
        }
        AppMethodBeat.m2505o(105623);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void aIo() {
        AppMethodBeat.m2504i(105624);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
        boolean EB;
        try {
            if (mo22149DA()) {
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
                AppMethodBeat.m2505o(105624);
                return;
            }
            if (this.ilm != null) {
                EB = this.ilm.mo22163EB();
                this.ilm = null;
            } else {
                EB = false;
            }
            if (!(this.ilo == null || this.ilo.imo == null)) {
                C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", Boolean.valueOf(this.ilx), Boolean.valueOf(this.ilo.imo.aIj()));
                if (this.ilo.imo.aIj() && !this.ilx) {
                    aIr();
                }
            }
            aIq().post(new C106252());
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.ilu));
            this.ilu = (int) (((long) this.ilu) + r4);
            this.ilt = this.mDuration - ((long) this.ilu);
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.ilt), Integer.valueOf(this.ilu));
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(EB));
            if (EB) {
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "onPause");
                this.ilp = C10636a.PAUSE;
                this.mIsRecording = false;
                C4883b c37761mb = new C37761mb();
                c37761mb.cHS.action = 3;
                c37761mb.cHS.state = "pause";
                if (this.ilo != null) {
                    c37761mb.cHS.appId = this.ilo.appId;
                }
                C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "pause record success");
                AppMethodBeat.m2505o(105624);
                return;
            }
            onError(8);
            C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
            AppMethodBeat.m2505o(105624);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_pause", new Object[0]);
            EB = false;
        }
    }

    private void aIp() {
        AppMethodBeat.m2504i(105625);
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
        boolean EB;
        try {
            if (mo22150DB()) {
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
                AppMethodBeat.m2505o(105625);
                return;
            }
            if (this.ilm != null) {
                EB = this.ilm.mo22163EB();
                this.ilm = null;
            } else {
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
                EB = true;
            }
            this.ilr = true;
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", Integer.valueOf(this.ils));
            if (this.ilq != null) {
                this.ilq.flush();
                this.ilq.close();
                this.ilq = null;
            }
            aIq().post(new C23913());
            if (mo22149DA()) {
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.ilu));
                this.ilu = (int) (((long) this.ilu) + r6);
                this.ilt = this.mDuration - ((long) this.ilu);
                C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.ilt), Integer.valueOf(this.ilu));
            }
            C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(EB));
            if (EB) {
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "onStop");
                this.ilp = C10636a.STOP;
                this.mIsRecording = false;
                C4883b c37761mb = new C37761mb();
                c37761mb.cHS.action = 2;
                c37761mb.cHS.state = "stop";
                if (this.ilo != null) {
                    c37761mb.cHS.appId = this.ilo.appId;
                }
                C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", Integer.valueOf(this.ils), Integer.valueOf(this.ilu));
                c37761mb.cHS.duration = Math.min(this.ils, this.ilu);
                c37761mb.cHS.filePath = this.mFilePath;
                c37761mb.cHS.fileSize = (int) C27202h.m43221CB(this.mFilePath);
                C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "stop record success");
            } else {
                onError(9);
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
            }
            this.ilo = null;
            C42630d.aIg();
            AppMethodBeat.m2505o(105625);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_stop", new Object[0]);
            EB = false;
        }
    }

    private C7306ak aIq() {
        AppMethodBeat.m2504i(105626);
        if (this.ilv == null) {
            this.ilv = new C7306ak(Looper.getMainLooper());
        }
        C7306ak c7306ak = this.ilv;
        AppMethodBeat.m2505o(105626);
        return c7306ak;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onError(int i) {
        AppMethodBeat.m2504i(105627);
        C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", Integer.valueOf(i));
        if (this.ilp != C10636a.ERROR) {
            C27203j.m43226pj(i);
        }
        this.ilp = C10636a.ERROR;
        this.mIsRecording = false;
        C4883b c37761mb = new C37761mb();
        c37761mb.cHS.action = 4;
        c37761mb.cHS.state = "error";
        if (this.ilo != null) {
            c37761mb.cHS.appId = this.ilo.appId;
        }
        c37761mb.cHS.errCode = i;
        c37761mb.cHS.aIm = C19607i.m30402ph(i);
        C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
        AppMethodBeat.m2505o(105627);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aIr() {
        AppMethodBeat.m2504i(105628);
        this.ilx = true;
        C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
        C4883b c37761mb = new C37761mb();
        c37761mb.cHS.action = 6;
        c37761mb.cHS.state = "interruptionBegin";
        if (this.ilo != null) {
            c37761mb.cHS.appId = this.ilo.appId;
        }
        C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
        AppMethodBeat.m2505o(105628);
    }

    /* renamed from: g */
    static /* synthetic */ void m18322g(C10626g c10626g) {
        AppMethodBeat.m2504i(105629);
        try {
            C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "_start in runnable");
            if (c10626g.aIn()) {
                c10626g.ilr = false;
                c10626g.ils = 0;
                if (!c10626g.ilw) {
                    c10626g.ilw = true;
                    if (!(c10626g.ilo == null || c10626g.ilo.imo == null)) {
                        c10626g.ilo.imo.mo73433a(c10626g.ilB);
                        c10626g.ilo.imo.aIk();
                    }
                }
                if (c10626g.m18312EM()) {
                    int i;
                    C19603c c19603c = c10626g.ilq;
                    C10637a c10637a = c10626g.ilm;
                    if (c10637a.coZ != null) {
                        C1292c c1292c = c10637a.coZ;
                        if (c1292c.cpS > 0) {
                            i = c1292c.cpS;
                        } else {
                            int minBufferSize = AudioRecord.getMinBufferSize(c1292c.mSampleRate, c1292c.cpQ, 2);
                            C4990ab.m7417i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", Integer.valueOf(minBufferSize));
                            if (minBufferSize == -2 || minBufferSize == -1) {
                                i = 0;
                            } else {
                                c1292c.cpS = minBufferSize * c1292c.cpz;
                                i = c1292c.cpS;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    c19603c.mo34815pl(i);
                    c10626g.ilq.mo34816t(c10626g.ilo.imm);
                    c10626g.ilu = 0;
                    c10626g.mDuration = (long) c10626g.ilo.duration;
                    c10626g.mStartTime = System.currentTimeMillis();
                    c10626g.ilt = c10626g.mDuration;
                    C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", Long.valueOf(c10626g.mDuration), Long.valueOf(c10626g.mStartTime));
                    c10626g.aIq().post(new C1062911());
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "onStart");
                    c10626g.ilp = C10636a.START;
                    c10626g.mIsRecording = true;
                    C4883b c37761mb = new C37761mb();
                    c37761mb.cHS.action = 0;
                    c37761mb.cHS.state = "start";
                    if (c10626g.ilo != null) {
                        c37761mb.cHS.appId = c10626g.ilo.appId;
                    }
                    C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "start record success");
                    AppMethodBeat.m2505o(105629);
                    return;
                }
                c10626g.onError(6);
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "start record fail");
                AppMethodBeat.m2505o(105629);
                return;
            }
            c10626g.onError(2);
            C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "init encoder fail");
            AppMethodBeat.m2505o(105629);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_start", new Object[0]);
            c10626g.onError(4);
            AppMethodBeat.m2505o(105629);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m18323h(C10626g c10626g) {
        AppMethodBeat.m2504i(105630);
        try {
            C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "_resume in runnable");
            if (c10626g.ilq == null) {
                c10626g.onError(3);
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                AppMethodBeat.m2505o(105630);
            } else if (c10626g.ilt <= 0) {
                c10626g.aIp();
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
                AppMethodBeat.m2505o(105630);
            } else if (c10626g.m18312EM()) {
                c10626g.mStartTime = System.currentTimeMillis();
                C4990ab.m7417i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", Long.valueOf(c10626g.ilt), Long.valueOf(c10626g.mStartTime));
                c10626g.aIq().post(new C1063012());
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "onResume");
                c10626g.ilp = C10636a.RESUME;
                c10626g.mIsRecording = true;
                C4883b c37761mb = new C37761mb();
                c37761mb.cHS.action = 1;
                c37761mb.cHS.state = "resume";
                if (c10626g.ilo != null) {
                    c37761mb.cHS.appId = c10626g.ilo.appId;
                }
                C4879a.xxA.mo10048a(c37761mb, Looper.getMainLooper());
                C4990ab.m7416i("MicroMsg.Record.AudioRecordMgr", "resume record success");
                AppMethodBeat.m2505o(105630);
            } else {
                c10626g.onError(7);
                C4990ab.m7412e("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                AppMethodBeat.m2505o(105630);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", e, "_resume", new Object[0]);
            c10626g.onError(5);
            AppMethodBeat.m2505o(105630);
        }
    }
}
