package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.m.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class ae {
    private bau cNr;
    private String cwT;
    long egA;
    private int fDG;
    String fUL;
    String fUM;
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
    int progress;
    HashMap<String, Integer> rlC = null;
    a rlD;
    int rlE;
    private int rlF = 0;
    long rlG;
    private long rlH;
    private long rlI;
    private int rlJ;
    private b rlK;
    int total;

    static class b {
        int fVf;
        int fVg;
        int rlM;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public interface a {
        void akX();

        void bq(String str, boolean z);

        boolean csf();

        int getPlayErrorCode();

        int getPlayVideoDuration();

        int getUiStayTime();

        void yI(int i);
    }

    public ae(a aVar) {
        AppMethodBeat.i(38451);
        this.rlD = aVar;
        this.fUQ = new f();
        this.rlC = new HashMap();
        this.rlK = new b();
        this.rlK.fVf = g.Nu().getInt("SnsVideoPreloadSec", 5);
        this.rlK.fVg = g.Nu().getInt("SnsVideoDownloadSec", 1);
        this.rlK.rlM = g.Nu().getInt("SnsVideoFullDownloadPercent", 101);
        ab.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", Integer.valueOf(this.rlK.fVf), Integer.valueOf(this.rlK.fVg), Integer.valueOf(this.rlK.rlM));
        reset();
        AppMethodBeat.o(38451);
    }

    public final void clear() {
        AppMethodBeat.i(38452);
        ab.i("MicroMsg.OnlineVideoViewHelper", "clear");
        reset();
        this.rlD = null;
        this.fUQ = null;
        AppMethodBeat.o(38452);
    }

    private void reset() {
        AppMethodBeat.i(38453);
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
        AppMethodBeat.o(38453);
    }

    public final boolean a(bau bau, int i, String str, boolean z, int i2) {
        AppMethodBeat.i(38454);
        this.cNr = bau;
        this.fDG = i;
        this.cwT = str;
        this.fUM = aq.D(bau);
        this.fUL = aq.be(i, bau.Url);
        if (bo.isNullOrNil(this.fUM) || bo.isNullOrNil(this.fUL)) {
            AppMethodBeat.o(38454);
            return false;
        }
        ab.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", this.fUL, Boolean.valueOf(z));
        af.cnD().a(bau, i, str, z, true, i2);
        this.fUO = 1;
        this.egA = bo.anU();
        le(z);
        AppMethodBeat.o(38454);
        return true;
    }

    public final boolean csk() {
        AppMethodBeat.i(38455);
        if (!bo.isNullOrNil(this.fUL)) {
            ab.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", this.fUL, Boolean.valueOf(this.fUO == 3), Integer.valueOf(this.rlE));
            af.cnD().s(this.fUL, csp());
            if (this.rlE >= this.rlK.rlM && !r0) {
                af.cnD().a(this.cNr, this.fDG, this.cwT, false, false, 36);
            }
            csq();
        }
        AppMethodBeat.o(38455);
        return true;
    }

    public final boolean ZA(String str) {
        AppMethodBeat.i(38456);
        boolean isEqual = bo.isEqual(this.fUL, str);
        AppMethodBeat.o(38456);
        return isEqual;
    }

    public final boolean mm(int i) {
        int i2;
        AppMethodBeat.i(38457);
        if (this.fUS != -1) {
            i2 = this.fUS;
        } else {
            i2 = i;
        }
        boolean z = true;
        ab.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.fUV), Integer.valueOf(this.fUR), Integer.valueOf(this.fUP), Integer.valueOf(this.fUO), this.fUL, Long.valueOf(this.rlH - this.egA), Boolean.valueOf(this.fUX));
        switch (this.fUO) {
            case 1:
                if (mn(i2)) {
                    cso();
                    if (this.fUX) {
                        csn();
                    } else {
                        ab.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", this.fUL);
                        if (this.fUP == 5) {
                            this.fUP = 1;
                        }
                        this.rlD.bq(this.fUM, true);
                        this.fUX = true;
                    }
                } else {
                    csm();
                    z = false;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (a(i2, pInt, pInt2)) {
                    if (ft(pInt.value, pInt2.value)) {
                        this.fUV = Math.max(this.fUV, pInt2.value);
                        z = true;
                        break;
                    }
                }
                ab.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                o.alm();
                e.k(this.fUL, 0, -1);
                break;
                break;
            case 2:
                ab.w("MicroMsg.OnlineVideoViewHelper", "download error.");
                break;
            case 3:
                cso();
                if (!this.fUX) {
                    if (this.fUP == 5) {
                        this.fUP = 1;
                    }
                    this.rlD.bq(this.fUM, false);
                    this.fUX = true;
                    break;
                }
                if (this.fUU) {
                    boolean z2;
                    ae aeVar;
                    if (this.fUS != -1) {
                        this.rlD.yI(this.fUS);
                        this.fUS = -1;
                        z2 = false;
                        aeVar = this;
                    } else if (this.rlD.csf()) {
                        z2 = false;
                        aeVar = this;
                    } else {
                        z2 = true;
                        aeVar = this;
                    }
                    aeVar.fUU = z2;
                }
                this.fUP = 3;
                break;
            default:
                ab.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                break;
        }
        AppMethodBeat.o(38457);
        return z;
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(38458);
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
            AppMethodBeat.o(38458);
            return false;
        }
        ab.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.fUP), Integer.valueOf(this.fUV), Integer.valueOf(this.fUW));
        AppMethodBeat.o(38458);
        return true;
    }

    private boolean mn(int i) {
        boolean z = false;
        AppMethodBeat.i(38459);
        if (this.fUO == 3) {
            AppMethodBeat.o(38459);
            return true;
        } else if (this.fUV - i > 1 || this.fUV >= this.fUR) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.fUQ.a(i, i + 1, pInt, pInt2)) {
                    z = o.alm().isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                    if (!z) {
                        this.fUV = i;
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            }
            AppMethodBeat.o(38459);
            return z;
        } else {
            AppMethodBeat.o(38459);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ft(int i, int i2) {
        boolean isVideoDataAvailable;
        AppMethodBeat.i(38460);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.fUQ.a(i, i2, pInt, pInt2)) {
                pInt2.value += 81920;
                isVideoDataAvailable = o.alm().isVideoDataAvailable(this.fUL, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    ab.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
                } else if (!this.rlC.containsKey(this.fUL + 0 + "_-1")) {
                    String str = this.fUL + pInt.value + "_" + pInt2.value;
                    ab.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.fUY), Boolean.FALSE);
                    if (this.rlC.containsKey(str) || this.fUY) {
                        ab.i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(str)));
                    } else {
                        this.fUY = true;
                        o.alm();
                        e.k(this.fUL, pInt.value, pInt2.value);
                        this.rlC.put(str, Integer.valueOf(i2));
                    }
                }
                AppMethodBeat.o(38460);
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
        }
        AppMethodBeat.o(38460);
        return isVideoDataAvailable;
    }

    /* Access modifiers changed, original: final */
    public final void csl() {
        AppMethodBeat.i(38461);
        ab.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", this.fUL);
        cso();
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38450);
                if (ae.this.rlD != null) {
                    ae.this.rlD.bq(ae.this.fUM, false);
                }
                AppMethodBeat.o(38450);
            }
        });
        AppMethodBeat.o(38461);
    }

    private void csm() {
        AppMethodBeat.i(38462);
        this.fUU = true;
        if (this.fUV > 0) {
            ab.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", this.fUL, Integer.valueOf(this.rlF), Integer.valueOf(this.fUP));
            this.rlI = bo.anU();
            if (!(this.fUP == 2 || this.fUP == 4)) {
                this.fUW += this.rlK.fVf;
                this.fUW = Math.min(this.fUW, 60);
                this.rlF++;
                this.fUP = 4;
            }
            this.rlD.akX();
            AppMethodBeat.o(38462);
        } else if (this.fUS == -1) {
            this.fUP = 1;
            AppMethodBeat.o(38462);
        } else {
            this.fUP = 2;
            AppMethodBeat.o(38462);
        }
    }

    private void csn() {
        boolean z = false;
        AppMethodBeat.i(38463);
        if (this.fUU) {
            if (this.rlF == 0 && this.rlH == 0) {
                cso();
            } else if (this.rlI > 0) {
                this.rlJ = (int) (((long) this.rlJ) + bo.gb(this.rlI));
            }
            ab.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", Integer.valueOf(this.rlF), Integer.valueOf(this.rlJ), this.fUL);
            this.fUP = 3;
            if (this.fUS != -1) {
                this.rlD.yI(this.fUS);
                this.fUS = -1;
                this.fUU = false;
                AppMethodBeat.o(38463);
                return;
            }
            if (!this.rlD.csf()) {
                z = true;
            }
            this.fUU = z;
            AppMethodBeat.o(38463);
            return;
        }
        if (this.fUP != 3) {
            ab.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", Integer.valueOf(this.fUP));
            this.fUP = this.rlD.csf() ? 3 : this.fUP;
        }
        AppMethodBeat.o(38463);
    }

    /* Access modifiers changed, original: final */
    public final void cso() {
        AppMethodBeat.i(38464);
        if (this.rlH == 0) {
            this.rlH = bo.anU();
        }
        AppMethodBeat.o(38464);
    }

    private Object[] csp() {
        AppMethodBeat.i(38465);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.rlD.getPlayVideoDuration());
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
        objArr[5] = Integer.valueOf(this.rlD.getUiStayTime());
        objArr[6] = Integer.valueOf(this.rlD.getPlayErrorCode());
        AppMethodBeat.o(38465);
        return objArr;
    }

    private static void le(boolean z) {
        AppMethodBeat.i(38466);
        if (z) {
            h.pYm.a(354, 201, 1, false);
            AppMethodBeat.o(38466);
            return;
        }
        h.pYm.a(354, 202, 1, false);
        AppMethodBeat.o(38466);
    }

    private static void csq() {
        AppMethodBeat.i(38467);
        h.pYm.a(354, 203, 1, false);
        AppMethodBeat.o(38467);
    }
}
