package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.m.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class m {
    String cHr;
    long egA;
    int fUO = 0;
    int fUP = 0;
    f fUQ;
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
    j yXX;
    a yXY;

    static class a {
        int fVf;
        int fVg;
        int rlM;
        int yYa;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m(j jVar) {
        int i;
        AppMethodBeat.i(32454);
        this.yXX = jVar;
        reset();
        this.fUQ = new f();
        this.yXY = new a();
        String value = g.Nu().getValue("AndroidOnlineVideoArgs");
        if (!bo.isNullOrNil(value)) {
            ab.i("MicroMsg.OnlineVideoUIHelper", "online video config : ".concat(String.valueOf(value)));
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.yXY.fVf = bo.getInt(split[0], 5);
                this.yXY.fVg = bo.getInt(split[1], 1);
                this.yXY.rlM = bo.getInt(split[2], 75);
                this.yXY.yYa = bo.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.yXY.fVf = 5;
                    this.yXY.fVg = 1;
                    this.yXY.rlM = 75;
                    this.yXY.yYa = 1048576;
                }
                ab.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.yXY.fVf), Integer.valueOf(this.yXY.fVg), Integer.valueOf(this.yXY.rlM), Integer.valueOf(this.yXY.yYa));
                this.fUW = this.yXY.fVf;
                AppMethodBeat.o(32454);
            }
        }
        i = 0;
        if (i == 0) {
        }
        ab.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.yXY.fVf), Integer.valueOf(this.yXY.fVg), Integer.valueOf(this.yXY.rlM), Integer.valueOf(this.yXY.yYa));
        this.fUW = this.yXY.fVf;
        AppMethodBeat.o(32454);
    }

    public final void reset() {
        AppMethodBeat.i(32455);
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
        AppMethodBeat.o(32455);
    }

    public final void dGK() {
        AppMethodBeat.i(32457);
        ab.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        int i = this.fUO == 3 ? 1 : 0;
        this.fUO = 0;
        if (!bo.isNullOrNil(this.cHr)) {
            if (i != 0) {
                dGM();
            } else if (this.rlE >= this.yXY.rlM) {
                ab.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", Integer.valueOf(this.rlE), Integer.valueOf(this.yXY.rlM));
                u.af(this.filename, 2);
                dGP();
            }
            o.alm().m(this.cHr, csp());
            dGO();
        }
        AppMethodBeat.o(32457);
    }

    public final boolean isStreaming() {
        AppMethodBeat.i(32458);
        if (bo.isNullOrNil(this.cHr) || !(this.fUO == 1 || this.fUO == 3)) {
            AppMethodBeat.o(32458);
            return false;
        }
        AppMethodBeat.o(32458);
        return true;
    }

    public final boolean ZA(String str) {
        AppMethodBeat.i(32459);
        boolean isEqual = bo.isEqual(str, this.cHr);
        AppMethodBeat.o(32459);
        return isEqual;
    }

    /* Access modifiers changed, original: final */
    public final void csl() {
        AppMethodBeat.i(32460);
        ab.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", this.filename);
        cso();
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(32453);
                if (m.this.yXX != null) {
                    m.this.yXX.bq(m.this.filename, false);
                }
                AppMethodBeat.o(32453);
            }
        });
        AppMethodBeat.o(32460);
    }

    public final boolean aG(int i, boolean z) {
        boolean z2;
        AppMethodBeat.i(32461);
        switch (this.fUO) {
            case 1:
                this.fUP = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!i(pInt.value, pInt2.value, true)) {
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
        this.yXX.ae(i, z);
        z2 = true;
        ab.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", Integer.valueOf(i), Integer.valueOf(this.fUO), Integer.valueOf(this.fUP));
        h.pYm.a(354, 4, 1, false);
        AppMethodBeat.o(32461);
        return z2;
    }

    public final boolean mm(int i) {
        int i2;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(32462);
        if (this.fUS != -1) {
            i2 = this.fUS;
        } else {
            i2 = i;
        }
        ab.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV), Integer.valueOf(this.fUR), Integer.valueOf(this.fUO), Long.valueOf(this.rlH - this.egA), Boolean.valueOf(this.fUX));
        switch (this.fUO) {
            case 1:
                boolean z3;
                if (mn(i2)) {
                    if (this.rlF == 0 && this.rlH == 0) {
                        cso();
                    }
                    if (this.fUX) {
                        m mVar;
                        int i3;
                        this.yXX.arz(this.filename);
                        if (this.fUU) {
                            if (this.rlF == 0 && this.rlH == 0) {
                                cso();
                            } else if (this.rlI > 0) {
                                this.rlJ = (int) (((long) this.rlJ) + bo.gb(this.rlI));
                            }
                            ab.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", Integer.valueOf(this.rlF), Integer.valueOf(this.rlJ));
                            if (this.fUS != -1) {
                                this.yXX.ae(this.fUS, true);
                                this.fUS = -1;
                                z3 = false;
                                mVar = this;
                            } else if (this.yXX.csf()) {
                                z3 = false;
                                mVar = this;
                            } else {
                                z3 = true;
                                mVar = this;
                            }
                            mVar.fUU = z3;
                            i3 = 3;
                            mVar = this;
                        } else {
                            if (this.fUP != 3) {
                                ab.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", Integer.valueOf(this.fUP));
                                if (this.yXX.csf()) {
                                    i3 = 3;
                                    mVar = this;
                                } else {
                                    i3 = this.fUP;
                                    mVar = this;
                                }
                            }
                            z3 = true;
                        }
                        mVar.fUP = i3;
                        z3 = true;
                    } else {
                        ab.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", this.filename);
                        this.yXX.bq(this.filename, true);
                        this.fUX = true;
                        z3 = true;
                    }
                } else {
                    this.fUU = true;
                    if (this.fUV > 0) {
                        ab.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.rlF + " playStatus : " + this.fUP);
                        this.rlI = bo.anU();
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
                this.yXX.Pg(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (a(i2, pInt, pInt2)) {
                    if (i(pInt.value, pInt2.value, false)) {
                        this.fUV = Math.max(this.fUV, pInt2.value);
                        break;
                    }
                }
                ab.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                z2 = z3;
                break;
            case 3:
                cso();
                if (!this.fUX) {
                    this.yXX.bq(this.filename, false);
                    this.fUX = true;
                    break;
                }
                if (this.fUU) {
                    m mVar2;
                    if (this.fUS != -1) {
                        this.yXX.ae(this.fUS, true);
                        this.fUS = -1;
                        mVar2 = this;
                    } else if (this.yXX.csf()) {
                        mVar2 = this;
                    } else {
                        z = true;
                        mVar2 = this;
                    }
                    mVar2.fUU = z;
                }
                this.yXX.Pg(i2);
                break;
        }
        AppMethodBeat.o(32462);
        return z2;
    }

    public final boolean mn(int i) {
        Throwable e;
        AppMethodBeat.i(32463);
        if (this.fUO == 3) {
            AppMethodBeat.o(32463);
            return true;
        } else if (this.fUV - i > 2 || this.fUV >= this.fUR) {
            boolean isVideoDataAvailable;
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.fUQ.a(i, i + 2, pInt, pInt2)) {
                    isVideoDataAvailable = o.alm().isVideoDataAvailable(this.cHr, pInt.value, pInt2.value);
                    if (!isVideoDataAvailable) {
                        try {
                            this.fUV = i;
                        } catch (Exception e2) {
                            e = e2;
                            ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                            ab.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                            AppMethodBeat.o(32463);
                            return isVideoDataAvailable;
                        }
                    }
                }
                isVideoDataAvailable = false;
            } catch (Exception e3) {
                e = e3;
                isVideoDataAvailable = false;
                ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                ab.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                AppMethodBeat.o(32463);
                return isVideoDataAvailable;
            }
            AppMethodBeat.o(32463);
            return isVideoDataAvailable;
        } else {
            AppMethodBeat.o(32463);
            return false;
        }
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(32464);
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
            AppMethodBeat.o(32464);
            return false;
        }
        ab.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW));
        AppMethodBeat.o(32464);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean i(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        AppMethodBeat.i(32465);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.fUQ.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = o.alm().isVideoDataAvailable(this.cHr, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    ab.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
                } else if (!this.rlC.containsKey(this.cHr + 0 + "_-1")) {
                    String str = this.cHr + pInt.value + "_" + pInt2.value;
                    ab.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.fUY), Boolean.valueOf(z));
                    if (this.rlC.containsKey(str) || (this.fUY && !z)) {
                        ab.i("MicroMsg.OnlineVideoUIHelper", "already request video : ".concat(String.valueOf(str)));
                    } else {
                        this.fUY = true;
                        o.alm();
                        e.k(this.cHr, pInt.value, pInt2.value);
                        this.rlC.put(str, Integer.valueOf(i2));
                    }
                }
                AppMethodBeat.o(32465);
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            ab.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
        }
        AppMethodBeat.o(32465);
        return isVideoDataAvailable;
    }

    public final void dGL() {
        AppMethodBeat.i(32466);
        String str = this.cHr + 0 + "_-1";
        if (!this.rlC.containsKey(str)) {
            ab.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", this.cHr);
            o.alm();
            e.k(this.cHr, 0, -1);
            this.rlC.put(str, Integer.valueOf(0));
            dGR();
        }
        this.fUP = 5;
        AppMethodBeat.o(32466);
    }

    /* Access modifiers changed, original: final */
    public final void dGM() {
        AppMethodBeat.i(32467);
        o.all();
        if (r.uc(t.uh(this.filename))) {
            ab.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", this.filename);
            if (u.uy(this.filename)) {
                dGS();
            }
        }
        AppMethodBeat.o(32467);
    }

    /* Access modifiers changed, original: final */
    public final void cso() {
        AppMethodBeat.i(32468);
        if (this.rlH == 0) {
            this.rlH = bo.anU();
        }
        AppMethodBeat.o(32468);
    }

    /* Access modifiers changed, original: final */
    public final Object[] csp() {
        AppMethodBeat.i(32469);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.yXX.getPlayVideoDuration());
        if (this.rlH <= 0) {
            this.rlH = bo.anU();
        }
        int i = (int) (this.rlH - this.egA);
        if (i <= 0) {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        if (this.rlG <= 0) {
            this.rlG = bo.anU();
        }
        i = (int) (this.rlG - this.egA);
        if (i <= 0) {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(this.rlF);
        if (this.rlF > 0) {
            if (this.rlJ == 0) {
                this.rlJ = (int) (((long) this.rlJ) + bo.gb(this.rlI));
            }
            objArr[4] = Integer.valueOf(this.rlJ / this.rlF);
        } else {
            objArr[4] = Integer.valueOf(0);
        }
        objArr[5] = Integer.valueOf(this.yXX.getUiStayTime());
        objArr[6] = Integer.valueOf(this.yXX.mqi);
        AppMethodBeat.o(32469);
        return objArr;
    }

    private static void dGN() {
        AppMethodBeat.i(32470);
        h.pYm.a(354, 1, 1, false);
        AppMethodBeat.o(32470);
    }

    private static void dGO() {
        AppMethodBeat.i(32471);
        h.pYm.a(354, 2, 1, false);
        AppMethodBeat.o(32471);
    }

    private static void dGP() {
        AppMethodBeat.i(32472);
        h.pYm.a(354, 10, 1, false);
        AppMethodBeat.o(32472);
    }

    private static void dGQ() {
        AppMethodBeat.i(32473);
        h.pYm.a(354, 17, 1, false);
        AppMethodBeat.o(32473);
    }

    private void dGR() {
        AppMethodBeat.i(32474);
        h.pYm.a(354, 24, 1, false);
        ab.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", Integer.valueOf(hashCode()), this.filename);
        h.pYm.e(13836, Integer.valueOf(303), Long.valueOf(bo.anT()), "");
        AppMethodBeat.o(32474);
    }

    private static void dGS() {
        AppMethodBeat.i(32475);
        h.pYm.a(354, 134, 1, false);
        AppMethodBeat.o(32475);
    }

    public final boolean arA(String str) {
        AppMethodBeat.i(32456);
        d.afF();
        if (d.afM()) {
            reset();
            s ut = u.ut(str);
            if (ut == null || ut.frO >= this.yXY.yYa) {
                u.ag(str, 1);
                n.alj();
                o.alm();
                com.tencent.mm.i.h rQ = e.rQ(str);
                if (rQ == null) {
                    AppMethodBeat.o(32456);
                    return false;
                }
                this.cHr = rQ.field_mediaId;
                this.gUm = rQ.egC;
                this.filename = str;
                this.fUO = 1;
                this.fUR = 0;
                o.alm().a(rQ, o.alq().alG());
                this.egA = bo.anU();
                dGN();
                ab.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", this.cHr, str, Long.valueOf(this.egA));
                AppMethodBeat.o(32456);
                return true;
            }
            ab.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", Integer.valueOf(ut.frO), Integer.valueOf(this.yXY.yYa));
            u.b(ut, 9);
            dGQ();
            AppMethodBeat.o(32456);
            return false;
        }
        AppMethodBeat.o(32456);
        return false;
    }
}
