package com.tencent.p177mm.p612ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p187al.C45150e;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.p878a.C9794f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.gallery.m */
public final class C46653m {
    String cHr;
    long egA;
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
    String filename;
    int gUm;
    HashMap<String, Integer> rlC = new HashMap();
    int rlE;
    int rlF = 0;
    long rlG;
    long rlH;
    private long rlI;
    private int rlJ;
    C15663j yXX;
    C46652a yXY;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.m$1 */
    class C53411 implements Runnable {
        C53411() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32452);
            if (C46653m.this.yXX != null) {
                if (C46653m.this.mo74905mm(C26494u.m42237A(C46653m.this.fUR, C46653m.this.filename))) {
                    if (C46653m.this.rlF == 0 && C46653m.this.rlH == 0) {
                        C46653m.this.cso();
                    }
                    C46653m.this.yXX.mo27902bq(C46653m.this.filename, true);
                    C46653m.this.fUX = true;
                }
            }
            AppMethodBeat.m2505o(32452);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.m$2 */
    class C53422 implements Runnable {
        C53422() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32453);
            if (C46653m.this.yXX != null) {
                C46653m.this.yXX.mo27902bq(C46653m.this.filename, false);
            }
            AppMethodBeat.m2505o(32453);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.m$a */
    static class C46652a {
        int fVf;
        int fVg;
        int rlM;
        int yYa;

        private C46652a() {
        }

        /* synthetic */ C46652a(byte b) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C46653m(C15663j c15663j) {
        int i;
        AppMethodBeat.m2504i(32454);
        this.yXX = c15663j;
        reset();
        this.fUQ = new C9794f();
        this.yXY = new C46652a();
        String value = C26373g.m41964Nu().getValue("AndroidOnlineVideoArgs");
        if (!C5046bo.isNullOrNil(value)) {
            C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(value)));
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.yXY.fVf = C5046bo.getInt(split[0], 5);
                this.yXY.fVg = C5046bo.getInt(split[1], 1);
                this.yXY.rlM = C5046bo.getInt(split[2], 75);
                this.yXY.yYa = C5046bo.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.yXY.fVf = 5;
                    this.yXY.fVg = 1;
                    this.yXY.rlM = 75;
                    this.yXY.yYa = 1048576;
                }
                C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.yXY.fVf), Integer.valueOf(this.yXY.fVg), Integer.valueOf(this.yXY.rlM), Integer.valueOf(this.yXY.yYa));
                this.fUW = this.yXY.fVf;
                AppMethodBeat.m2505o(32454);
            }
        }
        i = 0;
        if (i == 0) {
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.yXY.fVf), Integer.valueOf(this.yXY.fVg), Integer.valueOf(this.yXY.rlM), Integer.valueOf(this.yXY.yYa));
        this.fUW = this.yXY.fVf;
        AppMethodBeat.m2505o(32454);
    }

    public final void reset() {
        AppMethodBeat.m2504i(32455);
        String str = "";
        this.cHr = str;
        this.filename = str;
        this.fUS = -1;
        this.rlE = 0;
        this.gUm = 0;
        this.fUV = 0;
        this.fUR = 0;
        this.rlF = 0;
        this.fUP = 0;
        this.fUO = 0;
        this.fUU = false;
        this.fUX = false;
        this.fUY = false;
        this.rlC.clear();
        if (this.yXY != null) {
            this.fUW = this.yXY.fVf;
        }
        this.rlG = 0;
        this.egA = 0;
        this.rlJ = 0;
        this.rlI = 0;
        this.rlH = 0;
        AppMethodBeat.m2505o(32455);
    }

    public final void dGK() {
        AppMethodBeat.m2504i(32457);
        C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        int i = this.fUO == 3 ? 1 : 0;
        this.fUO = 0;
        if (!C5046bo.isNullOrNil(this.cHr)) {
            if (i != 0) {
                dGM();
            } else if (this.rlE >= this.yXY.rlM) {
                C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", Integer.valueOf(this.rlE), Integer.valueOf(this.yXY.rlM));
                C26494u.m42243af(this.filename, 2);
                C46653m.dGP();
            }
            C37961o.alm().mo73064m(this.cHr, csp());
            C46653m.dGO();
        }
        AppMethodBeat.m2505o(32457);
    }

    public final boolean isStreaming() {
        AppMethodBeat.m2504i(32458);
        if (C5046bo.isNullOrNil(this.cHr) || !(this.fUO == 1 || this.fUO == 3)) {
            AppMethodBeat.m2505o(32458);
            return false;
        }
        AppMethodBeat.m2505o(32458);
        return true;
    }

    /* renamed from: ZA */
    public final boolean mo74895ZA(String str) {
        AppMethodBeat.m2504i(32459);
        boolean isEqual = C5046bo.isEqual(str, this.cHr);
        AppMethodBeat.m2505o(32459);
        return isEqual;
    }

    /* Access modifiers changed, original: final */
    public final void csl() {
        AppMethodBeat.m2504i(32460);
        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", this.filename);
        cso();
        C5004al.m7441d(new C53422());
        AppMethodBeat.m2505o(32460);
    }

    /* renamed from: aG */
    public final boolean mo74896aG(int i, boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(32461);
        switch (this.fUO) {
            case 1:
                this.fUP = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                m88337a(i, pInt, pInt2);
                if (!m88338i(pInt.value, pInt2.value, true)) {
                    this.fUS = i;
                    this.fUU = true;
                    this.yXX.akX();
                    z2 = false;
                    break;
                }
                this.fUS = -1;
                this.fUU = false;
                this.fUV = pInt2.value;
                this.fUP = 3;
                break;
            case 3:
                break;
        }
        this.yXX.mo27899ae(i, z);
        z2 = true;
        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", Integer.valueOf(i), Integer.valueOf(this.fUO), Integer.valueOf(this.fUP));
        C7060h.pYm.mo8378a(354, 4, 1, false);
        AppMethodBeat.m2505o(32461);
        return z2;
    }

    /* renamed from: mm */
    public final boolean mo74905mm(int i) {
        int i2;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(32462);
        if (this.fUS != -1) {
            i2 = this.fUS;
        } else {
            i2 = i;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV), Integer.valueOf(this.fUR), Integer.valueOf(this.fUO), Long.valueOf(this.rlH - this.egA), Boolean.valueOf(this.fUX));
        switch (this.fUO) {
            case 1:
                boolean z3;
                if (mo74906mn(i2)) {
                    if (this.rlF == 0 && this.rlH == 0) {
                        cso();
                    }
                    if (this.fUX) {
                        C46653m c46653m;
                        int i3;
                        this.yXX.arz(this.filename);
                        if (this.fUU) {
                            if (this.rlF == 0 && this.rlH == 0) {
                                cso();
                            } else if (this.rlI > 0) {
                                this.rlJ = (int) (((long) this.rlJ) + C5046bo.m7566gb(this.rlI));
                            }
                            C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", Integer.valueOf(this.rlF), Integer.valueOf(this.rlJ));
                            if (this.fUS != -1) {
                                this.yXX.mo27899ae(this.fUS, true);
                                this.fUS = -1;
                                z3 = false;
                                c46653m = this;
                            } else if (this.yXX.csf()) {
                                z3 = false;
                                c46653m = this;
                            } else {
                                z3 = true;
                                c46653m = this;
                            }
                            c46653m.fUU = z3;
                            i3 = 3;
                            c46653m = this;
                        } else {
                            if (this.fUP != 3) {
                                C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", Integer.valueOf(this.fUP));
                                if (this.yXX.csf()) {
                                    i3 = 3;
                                    c46653m = this;
                                } else {
                                    i3 = this.fUP;
                                    c46653m = this;
                                }
                            }
                            z3 = true;
                        }
                        c46653m.fUP = i3;
                        z3 = true;
                    } else {
                        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", this.filename);
                        this.yXX.mo27902bq(this.filename, true);
                        this.fUX = true;
                        z3 = true;
                    }
                } else {
                    this.fUU = true;
                    if (this.fUV > 0) {
                        C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.rlF + " playStatus : " + this.fUP);
                        this.rlI = C5046bo.anU();
                        if (!(this.fUP == 2 || this.fUP == 4)) {
                            this.fUW += this.yXY.fVf;
                            this.fUW = Math.min(this.fUW, 60);
                            this.rlF++;
                            this.fUP = 4;
                        }
                        this.yXX.akX();
                    } else if (this.fUS == -1) {
                        this.fUP = 1;
                    } else {
                        this.fUP = 2;
                    }
                    z3 = false;
                }
                this.yXX.mo27897Pg(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (m88337a(i2, pInt, pInt2)) {
                    if (m88338i(pInt.value, pInt2.value, false)) {
                        this.fUV = Math.max(this.fUV, pInt2.value);
                        break;
                    }
                }
                C4990ab.m7410d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                z2 = z3;
                break;
            case 3:
                cso();
                if (!this.fUX) {
                    this.yXX.mo27902bq(this.filename, false);
                    this.fUX = true;
                    break;
                }
                if (this.fUU) {
                    C46653m c46653m2;
                    if (this.fUS != -1) {
                        this.yXX.mo27899ae(this.fUS, true);
                        this.fUS = -1;
                        c46653m2 = this;
                    } else if (this.yXX.csf()) {
                        c46653m2 = this;
                    } else {
                        z = true;
                        c46653m2 = this;
                    }
                    c46653m2.fUU = z;
                }
                this.yXX.mo27897Pg(i2);
                break;
        }
        AppMethodBeat.m2505o(32462);
        return z2;
    }

    /* renamed from: mn */
    public final boolean mo74906mn(int i) {
        Throwable e;
        AppMethodBeat.m2504i(32463);
        if (this.fUO == 3) {
            AppMethodBeat.m2505o(32463);
            return true;
        } else if (this.fUV - i > 2 || this.fUV >= this.fUR) {
            boolean isVideoDataAvailable;
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.fUQ.mo21144a(i, i + 2, pInt, pInt2)) {
                    isVideoDataAvailable = C37961o.alm().isVideoDataAvailable(this.cHr, pInt.value, pInt2.value);
                    if (!isVideoDataAvailable) {
                        try {
                            this.fUV = i;
                        } catch (Exception e2) {
                            e = e2;
                            C4990ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                            C4990ab.m7412e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                            AppMethodBeat.m2505o(32463);
                            return isVideoDataAvailable;
                        }
                    }
                }
                isVideoDataAvailable = false;
            } catch (Exception e3) {
                e = e3;
                isVideoDataAvailable = false;
                C4990ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                AppMethodBeat.m2505o(32463);
                return isVideoDataAvailable;
            }
            AppMethodBeat.m2505o(32463);
            return isVideoDataAvailable;
        } else {
            AppMethodBeat.m2505o(32463);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m88337a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.m2504i(32464);
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
            pInt2.value = ((this.fUW + i) + 2) + this.yXY.fVg;
        }
        if (pInt2.value >= this.fUR + 1) {
            pInt2.value = this.fUR + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.yXY.fVg;
            AppMethodBeat.m2505o(32464);
            return false;
        }
        C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW));
        AppMethodBeat.m2505o(32464);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private boolean m88338i(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        AppMethodBeat.m2504i(32465);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.fUQ.mo21144a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = C37961o.alm().isVideoDataAvailable(this.cHr, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
                } else if (!this.rlC.containsKey(this.cHr + 0 + "_-1")) {
                    String str = this.cHr + pInt.value + "_" + pInt2.value;
                    C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.fUY), Boolean.valueOf(z));
                    if (this.rlC.containsKey(str) || (this.fUY && !z)) {
                        C4990ab.m7416i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(str)));
                    } else {
                        this.fUY = true;
                        C37961o.alm();
                        C45150e.m83031k(this.cHr, pInt.value, pInt2.value);
                        this.rlC.put(str, Integer.valueOf(i2));
                    }
                }
                AppMethodBeat.m2505o(32465);
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
        }
        AppMethodBeat.m2505o(32465);
        return isVideoDataAvailable;
    }

    public final void dGL() {
        AppMethodBeat.m2504i(32466);
        String str = this.cHr + 0 + "_-1";
        if (!this.rlC.containsKey(str)) {
            C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", this.cHr);
            C37961o.alm();
            C45150e.m83031k(this.cHr, 0, -1);
            this.rlC.put(str, Integer.valueOf(0));
            dGR();
        }
        this.fUP = 5;
        AppMethodBeat.m2505o(32466);
    }

    /* Access modifiers changed, original: final */
    public final void dGM() {
        AppMethodBeat.m2504i(32467);
        C37961o.all();
        if (C26492r.m42230uc(C9720t.m17303uh(this.filename))) {
            C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", this.filename);
            if (C26494u.m42273uy(this.filename)) {
                C46653m.dGS();
            }
        }
        AppMethodBeat.m2505o(32467);
    }

    /* Access modifiers changed, original: final */
    public final void cso() {
        AppMethodBeat.m2504i(32468);
        if (this.rlH == 0) {
            this.rlH = C5046bo.anU();
        }
        AppMethodBeat.m2505o(32468);
    }

    /* Access modifiers changed, original: final */
    public final Object[] csp() {
        AppMethodBeat.m2504i(32469);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.yXX.getPlayVideoDuration());
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
        objArr[5] = Integer.valueOf(this.yXX.getUiStayTime());
        objArr[6] = Integer.valueOf(this.yXX.mqi);
        AppMethodBeat.m2505o(32469);
        return objArr;
    }

    private static void dGN() {
        AppMethodBeat.m2504i(32470);
        C7060h.pYm.mo8378a(354, 1, 1, false);
        AppMethodBeat.m2505o(32470);
    }

    private static void dGO() {
        AppMethodBeat.m2504i(32471);
        C7060h.pYm.mo8378a(354, 2, 1, false);
        AppMethodBeat.m2505o(32471);
    }

    private static void dGP() {
        AppMethodBeat.m2504i(32472);
        C7060h.pYm.mo8378a(354, 10, 1, false);
        AppMethodBeat.m2505o(32472);
    }

    private static void dGQ() {
        AppMethodBeat.m2504i(32473);
        C7060h.pYm.mo8378a(354, 17, 1, false);
        AppMethodBeat.m2505o(32473);
    }

    private void dGR() {
        AppMethodBeat.m2504i(32474);
        C7060h.pYm.mo8378a(354, 24, 1, false);
        C4990ab.m7421w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", Integer.valueOf(hashCode()), this.filename);
        C7060h.pYm.mo8381e(13836, Integer.valueOf(303), Long.valueOf(C5046bo.anT()), "");
        AppMethodBeat.m2505o(32474);
    }

    private static void dGS() {
        AppMethodBeat.m2504i(32475);
        C7060h.pYm.mo8378a(354, 134, 1, false);
        AppMethodBeat.m2505o(32475);
    }

    public final boolean arA(String str) {
        AppMethodBeat.m2504i(32456);
        C42204d.afF();
        if (C42204d.afM()) {
            reset();
            C26493s ut = C26494u.m42268ut(str);
            if (ut == null || ut.frO >= this.yXY.yYa) {
                C26494u.m42244ag(str, 1);
                C45459n.alj();
                C37961o.alm();
                C44686h rQ = C45150e.m83032rQ(str);
                if (rQ == null) {
                    AppMethodBeat.m2505o(32456);
                    return false;
                }
                this.cHr = rQ.field_mediaId;
                this.gUm = rQ.egC;
                this.filename = str;
                this.fUO = 1;
                this.fUR = 0;
                C37961o.alm().mo73060a(rQ, C37961o.alq().alG());
                this.egA = C5046bo.anU();
                C46653m.dGN();
                C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", this.cHr, str, Long.valueOf(this.egA));
                AppMethodBeat.m2505o(32456);
                return true;
            }
            C4990ab.m7417i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", Integer.valueOf(ut.frO), Integer.valueOf(this.yXY.yYa));
            C26494u.m42245b(ut, 9);
            C46653m.dGQ();
            AppMethodBeat.m2505o(32456);
            return false;
        }
        AppMethodBeat.m2505o(32456);
        return false;
    }
}
