package com.tencent.p177mm.audio.p195b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C32304g.C32306b;
import com.tencent.p177mm.compatible.p1189h.C18174a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.p219b.C18168c;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelvoice.C18719u;
import com.tencent.p177mm.modelvoice.C1885t;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.p183ai.C41737j;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.p183ai.C41737j.C41738b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.audio.b.h */
public class C32307h implements C41737j, C1406a {
    private static boolean cph = false;
    private boolean cqA = false;
    private boolean cqB = false;
    private long cqC;
    public int cqD = 0;
    private boolean cqE = false;
    private boolean cqF = false;
    private int cqG = 0;
    private C18169a cqH = C18169a.UNKNOWN;
    protected C41738b cqI;
    protected C37445a cqJ = null;
    private boolean cqK = false;
    private C7564ap cqL = new C7564ap(new C258321(), true);
    private Runnable cqM;
    private C45162a cqw = null;
    private C45293b cqx;
    private C32309a cqy = null;
    private String cqz;
    private String mFileName = "";
    private long mRecordStartTime = 0;

    /* renamed from: com.tencent.mm.audio.b.h$2 */
    class C90472 implements Runnable {
        C90472() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116496);
            if (C32307h.this.cqE) {
                C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "mHasBeginRec is true");
                AppMethodBeat.m2505o(116496);
                return;
            }
            C4990ab.m7410d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
            C32307h.m52800l(C32307h.this);
            AppMethodBeat.m2505o(116496);
        }
    }

    /* renamed from: com.tencent.mm.audio.b.h$1 */
    class C258321 implements C5015a {
        C258321() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116495);
            C32850q.m53715a(C32307h.this.mFileName, C32307h.this);
            C26500m.amc().run();
            C4990ab.m7410d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + C32307h.this.mFileName);
            AppMethodBeat.m2505o(116495);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.audio.b.h$4 */
    class C323084 implements Runnable {
        C323084() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116498);
            C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "start record timeout");
            C7060h.pYm.mo8378a(357, 51, 1, true);
            if (!C32307h.cph) {
                if (C7243d.vxr) {
                    C7060h.pYm.mo8382g("Record", "start record timeout", null);
                }
                C7060h.pYm.mo8378a(357, 52, 1, true);
            }
            C32307h.cph = true;
            AppMethodBeat.m2505o(116498);
        }
    }

    /* renamed from: com.tencent.mm.audio.b.h$a */
    final class C32309a implements Runnable {
        C7306ak handler;

        public C32309a() {
            AppMethodBeat.m2504i(116500);
            this.handler = new C7306ak(C32307h.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.m2504i(116499);
                    if (C32307h.this.cqG <= 0) {
                        AppMethodBeat.m2505o(116499);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.SceneVoice.Recorder", "On Part :" + (C32307h.this.cqI == null));
                    C32307h.this.cqG = 2;
                    if (C32307h.this.cqI != null) {
                        C32307h.this.cqI.acE();
                    }
                    AppMethodBeat.m2505o(116499);
                }
            };
            AppMethodBeat.m2505o(116500);
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(116501);
            C5004al.m7439af(C32307h.this.cqM);
            C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", Long.valueOf(Thread.currentThread().getId()));
            synchronized (C32307h.this) {
                try {
                    C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", Long.valueOf(Thread.currentThread().getId()), C32307h.this);
                    if (C32307h.this.cqw == null) {
                        C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                    } else {
                        String a = C32307h.this.mFileName;
                        if (C32307h.this.cqF) {
                            z = false;
                        }
                        C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", C32850q.m53707U(a, z), Boolean.valueOf(C32307h.this.cqF));
                        if (C32307h.this.cqw.mo5467el(C32850q.m53707U(a, z))) {
                            C32307h.this.cqx.requestFocus();
                        } else {
                            C32850q.m53732uS(C32307h.this.mFileName);
                            C32307h.this.mFileName = null;
                            C32307h.this.cqw = null;
                            C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + C32307h.this.mFileName + "]");
                        }
                        C32307h.this.mRecordStartTime = C5046bo.m7588yz();
                        C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + C32307h.this.mFileName + "] time:" + C5046bo.m7525az(C32307h.this.cqC));
                        this.handler.sendEmptyMessageDelayed(0, 1);
                        AppMethodBeat.m2505o(116501);
                    }
                } finally {
                    AppMethodBeat.m2505o(116501);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.audio.b.h$3 */
    class C323103 implements C37445a {
        C323103() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(116497);
            C32307h.this.cqx.mo73178Mm();
            C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + C32307h.this.mFileName);
            C32850q.m53732uS(C32307h.this.mFileName);
            if (C32307h.this.cqJ != null) {
                C32307h.this.cqJ.onError();
            }
            AppMethodBeat.m2505o(116497);
        }
    }

    /* renamed from: l */
    static /* synthetic */ void m52800l(C32307h c32307h) {
        AppMethodBeat.m2504i(116515);
        c32307h.m52784EW();
        AppMethodBeat.m2505o(116515);
    }

    public C32307h(Context context, boolean z) {
        AppMethodBeat.m2504i(116502);
        this.cqx = new C45293b(context);
        this.cqF = z;
        C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(116502);
    }

    public final void reset() {
        AppMethodBeat.m2504i(116503);
        if (this.cqw != null) {
            this.cqw.mo5464EB();
            this.cqx.mo73178Mm();
            C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.cqC = 0;
        this.cqy = null;
        this.cqH = C18169a.UNKNOWN;
        this.cqG = 0;
        this.mRecordStartTime = 0;
        AppMethodBeat.m2505o(116503);
    }

    /* renamed from: ET */
    public final int mo47618ET() {
        return this.cqD;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean isRecording() {
        AppMethodBeat.m2504i(116504);
        if (this.cqw == null) {
            AppMethodBeat.m2505o(116504);
            return false;
        } else if (this.cqw.getStatus() == 1) {
            AppMethodBeat.m2505o(116504);
            return true;
        } else {
            AppMethodBeat.m2505o(116504);
            return false;
        }
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.m2504i(116505);
        if (this.cqw == null) {
            AppMethodBeat.m2505o(116505);
            return 0;
        }
        int maxAmplitude = this.cqw.getMaxAmplitude();
        AppMethodBeat.m2505o(116505);
        return maxAmplitude;
    }

    /* renamed from: em */
    public final boolean mo47624em(String str) {
        AppMethodBeat.m2504i(116506);
        C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(str)));
        reset();
        this.cqz = str;
        this.cqC = C5046bo.m7588yz();
        if (str == null) {
            C4990ab.m7412e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            AppMethodBeat.m2505o(116506);
            return false;
        }
        this.cqA = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((C1853r.m3822YD() & 16384) == 0) {
                this.cqB = true;
            } else {
                this.cqB = false;
            }
        }
        if (!this.cqF) {
            if (this.cqA) {
                this.mFileName = C18719u.m29275uY(C1853r.m3846Yz());
            } else if (this.cqB) {
                this.mFileName = C18719u.m29275uY("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                C4990ab.m7413e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                AppMethodBeat.m2505o(116506);
                return false;
            }
            C1407g.m2946KK().mo4828a((C1406a) this);
            this.cqE = false;
            this.cqK = false;
            if (!C1407g.m2950KS() || C1407g.m2946KK().eoY.isBluetoothScoOn()) {
                m52784EW();
            } else {
                this.cqK = true;
                C1407g.m2946KK().mo4817KM();
                C5004al.m7442n(new C90472(), 1000);
            }
            AppMethodBeat.m2505o(116506);
            return true;
        }
        this.mFileName = C32850q.m53729uP(str);
        if (this.mFileName != null) {
        }
        C4990ab.m7413e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        AppMethodBeat.m2505o(116506);
        return false;
    }

    public final boolean cancel() {
        AppMethodBeat.m2504i(116507);
        C4990ab.m7410d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            try {
                C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.cqw != null) {
                    this.cqw.mo5464EB();
                    this.cqx.mo73178Mm();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(116507);
                }
            }
        }
        C1407g.m2946KK().mo4829b((C1406a) this);
        if (this.cqK) {
            C1407g.m2946KK().mo4818KN();
            this.cqK = false;
        }
        C32850q.m53730uQ(this.mFileName);
        C26500m.amc().run();
        if (!(this.cqw == null || C5046bo.isNullOrNil(this.mFileName) || this.cqF)) {
            C18174a c18174a = new C18174a();
            c18174a.euD = this.mFileName;
            c18174a.euE = mo47619EV();
            c18174a.euF = 1;
            c18174a.cvG = this.cqw.mo5465EC();
            C7060h.pYm.mo8374X(10513, c18174a.mo33663Mk());
        }
        this.mFileName = "";
        AppMethodBeat.m2505o(116507);
        return true;
    }

    /* renamed from: EH */
    public boolean mo24432EH() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(116508);
        if (this.cqL != null) {
            this.cqL.stopTimer();
            this.cqL.removeCallbacksAndMessages(null);
        }
        C1407g.m2946KK().mo4829b((C1406a) this);
        if (this.cqK) {
            C1407g.m2946KK().mo4818KN();
            this.cqK = false;
        }
        this.cqD = (int) mo47619EV();
        C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.cqD));
        if (!(this.cqw == null || C5046bo.isNullOrNil(this.mFileName) || this.cqF)) {
            C18174a c18174a = new C18174a();
            c18174a.euD = this.mFileName;
            c18174a.euE = (long) this.cqD;
            c18174a.euF = 2;
            c18174a.cvG = this.cqw.mo5465EC();
            C7060h.pYm.mo8374X(10513, c18174a.mo33663Mk());
        }
        synchronized (this) {
            try {
                C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", this.mFileName, this.cqw, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.cqw != null) {
                    this.cqw.mo5464EB();
                    this.cqx.mo73178Mm();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(116508);
                }
            }
        }
        if (this.cqG != 2) {
            C32850q.m53732uS(this.mFileName);
            this.mFileName = null;
            C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + C5046bo.m7525az(this.cqC));
        } else {
            if (((long) this.cqD) < 800 || (this.cqA && ((long) this.cqD) < 1000)) {
                C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.cqD);
                C32850q.m53732uS(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                C32850q.m53717ah(this.mFileName, this.cqD);
                C26500m.amc().run();
                C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.cqG = -1;
        AppMethodBeat.m2505o(116508);
        return z2;
    }

    /* renamed from: EU */
    private void m52783EU() {
        AppMethodBeat.m2504i(116509);
        C323103 c323103 = new C323103();
        if (this.cqw != null) {
            this.cqw.mo5466a(c323103);
        }
        AppMethodBeat.m2505o(116509);
    }

    /* renamed from: EV */
    public final long mo47619EV() {
        AppMethodBeat.m2504i(116510);
        if (this.mRecordStartTime == 0) {
            AppMethodBeat.m2505o(116510);
            return 0;
        }
        long az = C5046bo.m7525az(this.mRecordStartTime);
        AppMethodBeat.m2505o(116510);
        return az;
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(116511);
        C4990ab.m7410d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(i)));
        if (i == 1) {
            m52784EW();
        }
        AppMethodBeat.m2505o(116511);
    }

    /* renamed from: EW */
    private void m52784EW() {
        AppMethodBeat.m2504i(116512);
        if (this.cqE) {
            C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] return mHasBeginRec is true!");
            AppMethodBeat.m2505o(116512);
            return;
        }
        this.cqE = true;
        if (this.cqF) {
            this.cqH = C18169a.SPEEX;
            this.cqw = new C9742k();
        } else {
            m52786EZ();
            this.cqw = new C1885t(this.cqH);
        }
        m52783EU();
        m52785EX();
        this.cqy = new C32309a();
        C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] mRecordStartRunnable has post! threadPool:%s", C7305d.xDG.dqb());
        C7305d.post(this.cqy, "SceneVoiceRecorder_record");
        this.cqG = 1;
        this.cqL.mo16770ae(3000, 3000);
        C4990ab.m7410d("MicroMsg.SceneVoice.Recorder", "start end time:" + C5046bo.m7525az(this.cqC));
        AppMethodBeat.m2505o(116512);
    }

    /* renamed from: EX */
    private void m52785EX() {
        AppMethodBeat.m2504i(116513);
        C323084 c323084 = new C323084();
        this.cqM = c323084;
        C5004al.m7442n(c323084, 600);
        AppMethodBeat.m2505o(116513);
    }

    /* renamed from: a */
    public final void mo47621a(C37445a c37445a) {
        this.cqJ = c37445a;
    }

    /* renamed from: a */
    public final void mo47622a(C41738b c41738b) {
        this.cqI = c41738b;
    }

    /* renamed from: EY */
    public final int mo47620EY() {
        if (this.cqF) {
            return 1;
        }
        if (this.cqH == C18169a.PCM || this.cqH == C18169a.AMR) {
            return 0;
        }
        if (this.cqH == C18169a.SILK) {
            return 2;
        }
        return -1;
    }

    /* renamed from: EZ */
    private void m52786EZ() {
        AppMethodBeat.m2504i(116514);
        this.cqH = C18168c.m28610KI();
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("VoiceFormat");
        String value2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("VoiceFormatToQQ");
        if (this.cqH == C18169a.PCM) {
            if (4 == C5046bo.getInt(value, 4) && C32306b.m52782ES()) {
                this.cqH = C18169a.SILK;
            }
            if (this.cqz != null && this.cqz.endsWith("@qqim")) {
                this.cqH = C18169a.AMR;
            }
        }
        if (this.cqH == C18169a.PCM) {
            C4990ab.m7416i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
            this.cqH = C18169a.AMR;
        }
        C4990ab.m7417i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, this.cqH, Boolean.valueOf(C32306b.m52782ES()));
        AppMethodBeat.m2505o(116514);
    }
}
