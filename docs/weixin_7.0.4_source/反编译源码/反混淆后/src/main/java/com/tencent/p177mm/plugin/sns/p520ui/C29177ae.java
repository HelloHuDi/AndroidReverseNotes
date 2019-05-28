package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.p878a.C9794f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34957aq;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sns.ui.ae */
public final class C29177ae {
    private bau cNr;
    private String cwT;
    long egA;
    private int fDG;
    String fUL;
    String fUM;
    int fUO = 0;
    int fUP = 0;
    C9794f fUQ;
    int fUR;
    int fUS;
    boolean fUU;
    int fUV = 0;
    private int fUW;
    boolean fUX = false;
    boolean fUY = false;
    int progress;
    HashMap<String, Integer> rlC = null;
    C29179a rlD;
    int rlE;
    private int rlF = 0;
    long rlG;
    private long rlH;
    private long rlI;
    private int rlJ;
    private C29178b rlK;
    int total;

    /* renamed from: com.tencent.mm.plugin.sns.ui.ae$2 */
    class C136232 implements Runnable {
        C136232() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38450);
            if (C29177ae.this.rlD != null) {
                C29177ae.this.rlD.mo47342bq(C29177ae.this.fUM, false);
            }
            AppMethodBeat.m2505o(38450);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ae$b */
    static class C29178b {
        int fVf;
        int fVg;
        int rlM;

        private C29178b() {
        }

        /* synthetic */ C29178b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ae$a */
    public interface C29179a {
        void akX();

        /* renamed from: bq */
        void mo47342bq(String str, boolean z);

        boolean csf();

        int getPlayErrorCode();

        int getPlayVideoDuration();

        int getUiStayTime();

        /* renamed from: yI */
        void mo47347yI(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.ae$1 */
    class C291801 implements Runnable {
        C291801() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38449);
            if (C29177ae.this.rlD != null && C29177ae.this.mo47340mm(0)) {
                C29177ae.this.cso();
                C29177ae.this.rlD.mo47342bq(C29177ae.this.fUM, true);
                C29177ae.this.fUX = true;
            }
            AppMethodBeat.m2505o(38449);
        }
    }

    public C29177ae(C29179a c29179a) {
        AppMethodBeat.m2504i(38451);
        this.rlD = c29179a;
        this.fUQ = new C9794f();
        this.rlC = new HashMap();
        this.rlK = new C29178b();
        this.rlK.fVf = C26373g.m41964Nu().getInt("SnsVideoPreloadSec", 5);
        this.rlK.fVg = C26373g.m41964Nu().getInt("SnsVideoDownloadSec", 1);
        this.rlK.rlM = C26373g.m41964Nu().getInt("SnsVideoFullDownloadPercent", 101);
        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", Integer.valueOf(this.rlK.fVf), Integer.valueOf(this.rlK.fVg), Integer.valueOf(this.rlK.rlM));
        reset();
        AppMethodBeat.m2505o(38451);
    }

    public final void clear() {
        AppMethodBeat.m2504i(38452);
        C4990ab.m7416i("MicroMsg.OnlineVideoViewHelper", "clear");
        reset();
        this.rlD = null;
        this.fUQ = null;
        AppMethodBeat.m2505o(38452);
    }

    private void reset() {
        AppMethodBeat.m2504i(38453);
        this.fUL = "";
        this.fUS = -1;
        this.fUV = 0;
        this.fUR = 0;
        this.rlF = 0;
        this.fUP = 0;
        this.fUO = 0;
        this.fUU = false;
        this.fUX = false;
        this.fUY = false;
        this.rlC.clear();
        this.cNr = null;
        this.fDG = 0;
        this.cwT = null;
        if (this.rlK != null) {
            this.fUW = this.rlK.fVf;
        }
        this.rlG = 0;
        this.egA = 0;
        this.rlJ = 0;
        this.rlI = 0;
        this.rlH = 0;
        AppMethodBeat.m2505o(38453);
    }

    /* renamed from: a */
    public final boolean mo47335a(bau bau, int i, String str, boolean z, int i2) {
        AppMethodBeat.m2504i(38454);
        this.cNr = bau;
        this.fDG = i;
        this.cwT = str;
        this.fUM = C34957aq.m57411D(bau);
        this.fUL = C34957aq.m57416be(i, bau.Url);
        if (C5046bo.isNullOrNil(this.fUM) || C5046bo.isNullOrNil(this.fUL)) {
            AppMethodBeat.m2505o(38454);
            return false;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", this.fUL, Boolean.valueOf(z));
        C13373af.cnD().mo62851a(bau, i, str, z, true, i2);
        this.fUO = 1;
        this.egA = C5046bo.anU();
        C29177ae.m46348le(z);
        AppMethodBeat.m2505o(38454);
        return true;
    }

    public final boolean csk() {
        AppMethodBeat.m2504i(38455);
        if (!C5046bo.isNullOrNil(this.fUL)) {
            C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", this.fUL, Boolean.valueOf(this.fUO == 3), Integer.valueOf(this.rlE));
            C13373af.cnD().mo62856s(this.fUL, csp());
            if (this.rlE >= this.rlK.rlM && !r0) {
                C13373af.cnD().mo62851a(this.cNr, this.fDG, this.cwT, false, false, 36);
            }
            C29177ae.csq();
        }
        AppMethodBeat.m2505o(38455);
        return true;
    }

    /* renamed from: ZA */
    public final boolean mo47334ZA(String str) {
        AppMethodBeat.m2504i(38456);
        boolean isEqual = C5046bo.isEqual(this.fUL, str);
        AppMethodBeat.m2505o(38456);
        return isEqual;
    }

    /* renamed from: mm */
    public final boolean mo47340mm(int i) {
        int i2;
        AppMethodBeat.m2504i(38457);
        if (this.fUS != -1) {
            i2 = this.fUS;
        } else {
            i2 = i;
        }
        boolean z = true;
        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV), Integer.valueOf(this.fUR), Integer.valueOf(this.fUP), Integer.valueOf(this.fUO), this.fUL, Long.valueOf(this.rlH - this.egA), Boolean.valueOf(this.fUX));
        switch (this.fUO) {
            case 1:
                if (m46349mn(i2)) {
                    cso();
                    if (this.fUX) {
                        csn();
                    } else {
                        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", this.fUL);
                        if (this.fUP == 5) {
                            this.fUP = 1;
                        }
                        this.rlD.mo47342bq(this.fUM, true);
                        this.fUX = true;
                    }
                } else {
                    csm();
                    z = false;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (m46346a(i2, pInt, pInt2)) {
                    if (m46347ft(pInt.value, pInt2.value)) {
                        this.fUV = Math.max(this.fUV, pInt2.value);
                        z = true;
                        break;
                    }
                }
                C4990ab.m7410d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                C37961o.alm();
                C45150e.m83031k(this.fUL, 0, -1);
                break;
                break;
            case 2:
                C4990ab.m7420w("MicroMsg.OnlineVideoViewHelper", "download error.");
                break;
            case 3:
                cso();
                if (!this.fUX) {
                    if (this.fUP == 5) {
                        this.fUP = 1;
                    }
                    this.rlD.mo47342bq(this.fUM, false);
                    this.fUX = true;
                    break;
                }
                if (this.fUU) {
                    boolean z2;
                    C29177ae c29177ae;
                    if (this.fUS != -1) {
                        this.rlD.mo47347yI(this.fUS);
                        this.fUS = -1;
                        z2 = false;
                        c29177ae = this;
                    } else if (this.rlD.csf()) {
                        z2 = false;
                        c29177ae = this;
                    } else {
                        z2 = true;
                        c29177ae = this;
                    }
                    c29177ae.fUU = z2;
                }
                this.fUP = 3;
                break;
            default:
                C4990ab.m7420w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                break;
        }
        AppMethodBeat.m2505o(38457);
        return z;
    }

    /* renamed from: a */
    private boolean m46346a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(38458);
        pInt.value = Math.max(i, this.fUV);
        if (this.fUP == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.fUW;
        }
        if (this.fUP == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.fUW) + 8;
        }
        if (this.fUP == 3 || this.fUP == 4) {
            pInt.value = this.fUV;
            pInt2.value = ((this.fUW + i) + 1) + this.rlK.fVg;
        }
        if (pInt2.value >= this.fUR + 1) {
            pInt2.value = this.fUR + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.rlK.fVg;
            AppMethodBeat.m2505o(38458);
            return false;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW));
        AppMethodBeat.m2505o(38458);
        return true;
    }

    /* renamed from: mn */
    private boolean m46349mn(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(38459);
        if (this.fUO == 3) {
            AppMethodBeat.m2505o(38459);
            return true;
        } else if (this.fUV - i > 1 || this.fUV >= this.fUR) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.fUQ.mo21144a(i, i + 1, pInt, pInt2)) {
                    z = C37961o.alm().isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                    if (!z) {
                        this.fUV = i;
                    }
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            }
            AppMethodBeat.m2505o(38459);
            return z;
        } else {
            AppMethodBeat.m2505o(38459);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: ft */
    private boolean m46347ft(int i, int i2) {
        boolean isVideoDataAvailable;
        AppMethodBeat.m2504i(38460);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.fUQ.mo21144a(i, i2, pInt, pInt2)) {
                pInt2.value += 81920;
                isVideoDataAvailable = C37961o.alm().isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    C4990ab.m7416i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
                } else if (!this.rlC.containsKey(this.fUL + 0 + "_-1")) {
                    String str = this.fUL + pInt.value + "_" + pInt2.value;
                    C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.fUY), Boolean.FALSE);
                    if (this.rlC.containsKey(str) || this.fUY) {
                        C4990ab.m7416i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(str)));
                    } else {
                        this.fUY = true;
                        C37961o.alm();
                        C45150e.m83031k(this.fUL, pInt.value, pInt2.value);
                        this.rlC.put(str, Integer.valueOf(i2));
                    }
                }
                AppMethodBeat.m2505o(38460);
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
        }
        AppMethodBeat.m2505o(38460);
        return isVideoDataAvailable;
    }

    /* Access modifiers changed, original: final */
    public final void csl() {
        AppMethodBeat.m2504i(38461);
        C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", this.fUL);
        cso();
        C5004al.m7441d(new C136232());
        AppMethodBeat.m2505o(38461);
    }

    private void csm() {
        AppMethodBeat.m2504i(38462);
        this.fUU = true;
        if (this.fUV > 0) {
            C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", this.fUL, Integer.valueOf(this.rlF), Integer.valueOf(this.fUP));
            this.rlI = C5046bo.anU();
            if (!(this.fUP == 2 || this.fUP == 4)) {
                this.fUW += this.rlK.fVf;
                this.fUW = Math.min(this.fUW, 60);
                this.rlF++;
                this.fUP = 4;
            }
            this.rlD.akX();
            AppMethodBeat.m2505o(38462);
        } else if (this.fUS == -1) {
            this.fUP = 1;
            AppMethodBeat.m2505o(38462);
        } else {
            this.fUP = 2;
            AppMethodBeat.m2505o(38462);
        }
    }

    private void csn() {
        boolean z = false;
        AppMethodBeat.m2504i(38463);
        if (this.fUU) {
            if (this.rlF == 0 && this.rlH == 0) {
                cso();
            } else if (this.rlI > 0) {
                this.rlJ = (int) (((long) this.rlJ) + C5046bo.m7566gb(this.rlI));
            }
            C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", Integer.valueOf(this.rlF), Integer.valueOf(this.rlJ), this.fUL);
            this.fUP = 3;
            if (this.fUS != -1) {
                this.rlD.mo47347yI(this.fUS);
                this.fUS = -1;
                this.fUU = false;
                AppMethodBeat.m2505o(38463);
                return;
            }
            if (!this.rlD.csf()) {
                z = true;
            }
            this.fUU = z;
            AppMethodBeat.m2505o(38463);
            return;
        }
        if (this.fUP != 3) {
            C4990ab.m7417i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", Integer.valueOf(this.fUP));
            this.fUP = this.rlD.csf() ? 3 : this.fUP;
        }
        AppMethodBeat.m2505o(38463);
    }

    /* Access modifiers changed, original: final */
    public final void cso() {
        AppMethodBeat.m2504i(38464);
        if (this.rlH == 0) {
            this.rlH = C5046bo.anU();
        }
        AppMethodBeat.m2505o(38464);
    }

    private Object[] csp() {
        AppMethodBeat.m2504i(38465);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.rlD.getPlayVideoDuration());
        if (this.rlH <= 0) {
            this.rlH = C5046bo.anU();
        }
        int i = (int) (this.rlH - this.egA);
        if (i <= 0) {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        if (this.rlG <= 0) {
            this.rlG = C5046bo.anU();
        }
        i = (int) (this.rlG - this.egA);
        if (i <= 0) {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(this.rlF);
        if (this.rlF > 0) {
            if (this.rlJ == 0) {
                this.rlJ = (int) (((long) this.rlJ) + C5046bo.m7566gb(this.rlI));
            }
            objArr[4] = Integer.valueOf(this.rlJ / this.rlF);
        } else {
            objArr[4] = Integer.valueOf(0);
        }
        objArr[5] = Integer.valueOf(this.rlD.getUiStayTime());
        objArr[6] = Integer.valueOf(this.rlD.getPlayErrorCode());
        AppMethodBeat.m2505o(38465);
        return objArr;
    }

    /* renamed from: le */
    private static void m46348le(boolean z) {
        AppMethodBeat.m2504i(38466);
        if (z) {
            C7060h.pYm.mo8378a(354, 201, 1, false);
            AppMethodBeat.m2505o(38466);
            return;
        }
        C7060h.pYm.mo8378a(354, 202, 1, false);
        AppMethodBeat.m2505o(38466);
    }

    private static void csq() {
        AppMethodBeat.m2504i(38467);
        C7060h.pYm.mo8378a(354, 203, 1, false);
        AppMethodBeat.m2505o(38467);
    }
}
