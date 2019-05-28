package com.tencent.mm.plugin.sns.i;

import android.os.Process;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    c ecA;
    int edf;
    public int jLU;
    public boolean qQO;
    public long qQP;
    public long qQQ;
    public int qQR;
    int qQS;
    int qQT;
    int qQU;
    public int qQV;
    public int qQW;
    int qQX;
    public int qQY;
    public int qQZ;
    public long qRA;
    long qRB;
    long qRC;
    long qRD;
    long qRE;
    long qRF;
    long qRG;
    long qRH;
    long qRI;
    long qRJ;
    long qRK;
    long qRL;
    long qRM;
    long qRN;
    long qRO;
    long qRP;
    long qRQ;
    long qRR;
    long qRS;
    long qRT;
    long qRU;
    long qRV;
    long qRW;
    long qRX;
    long qRY;
    long qRZ;
    int qRa;
    public int qRb;
    public int qRc;
    public String qRd;
    public String qRe;
    String qRf;
    int qRg;
    public int qRh;
    public int qRi;
    public int qRj;
    public int qRk;
    public int qRl;
    public int qRm;
    public int qRn;
    public int qRo;
    int qRp;
    int qRq;
    int qRr;
    int qRs;
    int qRt;
    int qRu;
    public int qRv;
    public int qRw;
    int qRx;
    int qRy;
    public long qRz;
    public HashSet<String> qSA;
    public HashSet<String> qSB;
    public HashSet<String> qSC;
    public HashSet<String> qSD;
    public HashSet<String> qSE;
    public HashSet<String> qSF;
    public HashSet<String> qSG;
    public HashSet<String> qSH;
    public HashSet<String> qSI;
    public HashSet<String> qSJ;
    public HashSet<String> qSK;
    public HashSet<String> qSL;
    public long qSM;
    long qSa;
    long qSb;
    long qSc;
    String qSd;
    int qSe;
    String qSf;
    long qSg;
    private long qSh;
    long qSi;
    private long qSj;
    private HashSet<String> qSk;
    HashSet<String> qSl;
    public HashSet<String> qSm;
    HashSet<String> qSn;
    public HashSet<String> qSo;
    HashSet<String> qSp;
    HashSet<String> qSq;
    public HashSet<String> qSr;
    public HashSet<String> qSs;
    HashSet<String> qSt;
    public HashSet<String> qSu;
    private HashSet<String> qSv;
    public HashSet<String> qSw;
    public HashSet<String> qSx;
    public int qSy;
    public int qSz;

    /* renamed from: com.tencent.mm.plugin.sns.i.b$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ int qSO;

        public AnonymousClass2(int i) {
            this.qSO = i;
        }

        public final void run() {
            AppMethodBeat.i(36845);
            if (g.RN().QY()) {
                int myTid = Process.myTid();
                ab.i("MicroMsg.SnsBrowseInfoHelper", "summersns report tid[%d] osTid[%d], prior[%d][%d]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(myTid), Integer.valueOf(Thread.currentThread().getPriority()), Integer.valueOf(Process.getThreadPriority(myTid)));
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = b.this;
                int i = this.qSO;
                if (i != -1) {
                    n CZ = aj.CZ(i);
                    if (CZ != null) {
                        String j = i.j(CZ);
                        bVar.qRf = j;
                        aao cqL = af.cnJ().YX("@__weixintimtline").cqL();
                        if (cqL.wfM == 0 || i.jW(cqL.wfM).compareTo(j) <= 0) {
                            bVar.kZ(false);
                        } else {
                            bVar.kZ(true);
                        }
                    }
                }
                i = t.Zo();
                d dVar = new d();
                dVar.l("20BrowseTime", bVar.qQQ + ",");
                dVar.l("21BrowseFeedCount", bVar.qQR + ",");
                dVar.l("22CommentOrLikeFeedCount", bVar.qQS + ",");
                dVar.l("23ClickFeedCount", bVar.qQT + ",");
                dVar.l("24ClickAlbumCount", bVar.qQU + ",");
                dVar.l("25PostFeedCount", bVar.qQV + ",");
                dVar.l("26ExposeFeedCount", bVar.qSm.size() + ",");
                dVar.l("27FavFeedCount", bVar.qSn.size() + ",");
                dVar.l("28BlackListFriendCount", bVar.qQY + ",");
                dVar.l("29OutsiderFriendCount", bVar.qQZ + ",");
                dVar.l("30BrowseNewFeedCount", bVar.qRa + ",");
                dVar.l("31HasNewSnsMsgWhenEntrance", bVar.qRb + ",");
                dVar.l("32HasNewChatMsgWhenExit", bVar.qRc + ",");
                dVar.l("33StartBrowseSnsObjectId", bVar.qRd + ",");
                dVar.l("34EndBrowseSnsObjectId", bVar.qRe + ",");
                dVar.l("35NextBrowseSnsObjectId", bVar.qRf + ",");
                dVar.l("36HasNewFeedInServer", bVar.qRg + ",");
                dVar.l("37BrowseBrandUrlFeedCount", bVar.qRh + ",");
                dVar.l("38BrowseNotBrandUrlFeedCount", bVar.qRi + ",");
                dVar.l("39BrowseTextFeedCount", bVar.qRj + ",");
                dVar.l("40BrowseImageFeedCount", bVar.qRk + ",");
                dVar.l("41BrowseSightFeedCount", bVar.qRl + ",");
                dVar.l("42BrowseAdFeedCount", bVar.qRm + ",");
                dVar.l("43BrowseMusicFeedCount", bVar.qRn + ",");
                dVar.l("44contactCount", i + ",");
                dVar.l("BrowseVideoFeedCount45", bVar.qRo + ",");
                dVar.l("ClickBrandUrlFeedCount46", bVar.qRp + ",");
                dVar.l("ClickNotBrandUrlFeedCount47", bVar.qRq + ",");
                dVar.l("ClickImageFeedCount48", bVar.qRr + ",");
                dVar.l("ClickSightFeedCount49", bVar.qRs + ",");
                dVar.l("ClickMusicFeedCount50", bVar.qRt + ",");
                dVar.l("ClickVideoFeedCount51", bVar.qRu + ",");
                dVar.l("BrowseOtherFeedCount52", bVar.qRv + ",");
                dVar.l("BrowserStreamVideoFeedCount53", bVar.qRw + ",");
                dVar.l("ClickStreamVideoCount54", bVar.qRx + ",");
                dVar.l("ClickAdFeed55", bVar.qRy + ",");
                dVar.l("56BackGroundTime", bVar.qRz + ",");
                dVar.l("57BrowseTimeLineTime", bVar.qRB + ",");
                dVar.l("58BrowseMyAlbumTime", bVar.qRD + ",");
                dVar.l("59BrowseOtherAlbumTime", bVar.qRF + ",");
                dVar.l("60BrowseMessageListTime", bVar.qRH + ",");
                dVar.l("61ClickNewPostTime", bVar.qRJ + ",");
                dVar.l("62BrowseFullScreenImageTime", bVar.qRL + ",");
                dVar.l("63BrowseFullScreenSightTime", bVar.qRN + ",");
                dVar.l("64BrowseMPArticleTime", bVar.qRP + ",");
                dVar.l("65BrowseExternalArticleTime", bVar.qRR + ",");
                dVar.l("66BrowseFullScreenAdImageTime", bVar.qRT + ",");
                dVar.l("67BrowseAdSightTime", "0,");
                dVar.l("68BrowseAdDetailTime", bVar.qRV + ",");
                dVar.l("69BrowseFullScreenAdSightTime", bVar.qRX + ",");
                dVar.l("70BrowseFullScreenAdLongVideoTime", bVar.qRZ + ",");
                dVar.l("71BrowseForwardAdLongVideoTime", bVar.qSb + ",");
                dVar.l("72StartBrowseTime", bVar.qSM + ",");
                dVar.l("73ClickFeedIdList", b.f(bVar.qSl) + ",");
                dVar.l("74ExposeFeedIdList", b.f(bVar.qSm) + ",");
                dVar.l("75FavFeedIdList", b.f(bVar.qSn) + ",");
                dVar.l("76ClickAlbumUserList", b.f(bVar.qSt) + ",");
                dVar.l("77ForwardFeedIdList", b.f(bVar.qSo) + ",");
                dVar.l("78ClickAvatarFeedIdList", b.f(bVar.qSp) + ",");
                dVar.l("79ClickNickNameFeedIdList", b.f(bVar.qSq) + ",");
                dVar.l("80ForwardToSingleChatFeedIdList", b.f(bVar.qSr) + ",");
                dVar.l("81ForwardToChatRoomFeedIdList", b.f(bVar.qSs) + ",");
                dVar.l("82FeedUpdateNotification", bVar.edf + ",");
                dVar.l("83abandon", ",");
                dVar.l("84abandon", ",");
                dVar.l("85LastestUnReadFeedId", bVar.qSd + ",");
                dVar.l("86UnReadMsgCount", bVar.qSe + ",");
                dVar.l("87BrowseAdCanvasPageTime", bVar.qSg + ",");
                dVar.l("88BrowseForwardAdCanvasTime", bVar.qSi + ",");
                dVar.l("90EnterObjectId", bVar.qSf);
                ab.v("MicroMsg.SnsBrowseInfoHelper", "report logbuffer(12076): " + dVar.Fk());
                h.pYm.e(12076, dVar);
                a.xxA.d(bVar.ecA);
                bVar.qQQ = 0;
                bVar.qQR = 0;
                bVar.qQS = 0;
                bVar.qQT = 0;
                bVar.qQU = 0;
                bVar.qQV = 0;
                bVar.qQW = 0;
                bVar.qQX = 0;
                bVar.qQY = 0;
                bVar.qQZ = 0;
                bVar.qRa = 0;
                bVar.qRb = 0;
                bVar.qRc = 0;
                bVar.qRd = "";
                bVar.qRe = "";
                bVar.qRf = "";
                bVar.qRg = 0;
                bVar.qRh = 0;
                bVar.qRi = 0;
                bVar.qRj = 0;
                bVar.qRk = 0;
                bVar.qRl = 0;
                bVar.qRm = 0;
                bVar.qRn = 0;
                bVar.jLU = 0;
                bVar.qRo = 0;
                bVar.qRp = 0;
                bVar.qRq = 0;
                bVar.qRr = 0;
                bVar.qRs = 0;
                bVar.qRt = 0;
                bVar.qRu = 0;
                bVar.qRv = 0;
                bVar.qRw = 0;
                bVar.qRx = 0;
                bVar.qRy = 0;
                bVar.qRz = 0;
                bVar.qRA = 0;
                bVar.qRB = 0;
                bVar.qRC = 0;
                bVar.qRD = 0;
                bVar.qRE = 0;
                bVar.qRF = 0;
                bVar.qRG = 0;
                bVar.qRH = 0;
                bVar.qRI = 0;
                bVar.qRJ = 0;
                bVar.qRK = 0;
                bVar.qRL = 0;
                bVar.qRM = 0;
                bVar.qRN = 0;
                bVar.qRO = 0;
                bVar.qRP = 0;
                bVar.qRQ = 0;
                bVar.qRR = 0;
                bVar.qRS = 0;
                bVar.qRT = 0;
                bVar.qRU = 0;
                bVar.qRV = 0;
                bVar.qRW = 0;
                bVar.qRX = 0;
                bVar.qRY = 0;
                bVar.qRZ = 0;
                bVar.qSa = 0;
                bVar.qSb = 0;
                bVar.qSc = 0;
                bVar.qSl.clear();
                bVar.qSm.clear();
                bVar.qSn.clear();
                bVar.qSo.clear();
                bVar.qSp.clear();
                bVar.qSq.clear();
                bVar.qSr.clear();
                bVar.qSs.clear();
                bVar.edf = 0;
                bVar.qSd = "";
                bVar.qSe = 0;
                ab.i("MicroMsg.SnsBrowseInfoHelper", "summersns report take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(36845);
                return;
            }
            ab.w("MicroMsg.SnsBrowseInfoHelper", "account not init.");
            AppMethodBeat.o(36845);
        }
    }

    public final void w(n nVar) {
        AppMethodBeat.i(36846);
        if (nVar == null) {
            AppMethodBeat.o(36846);
            return;
        }
        this.qSk.add(nVar.cqU());
        this.qQS = this.qSk.size();
        AppMethodBeat.o(36846);
    }

    public final void x(n nVar) {
        AppMethodBeat.i(36847);
        if (nVar == null) {
            AppMethodBeat.o(36847);
            return;
        }
        String cqU = nVar.cqU();
        String j = i.j(nVar);
        if (this.qSl.contains(j)) {
            AppMethodBeat.o(36847);
            return;
        }
        ab.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", cqU, j);
        this.qQT++;
        this.qSl.add(j);
        if (nVar.DI(32)) {
            this.qRy++;
        }
        switch (nVar.field_type) {
            case 1:
                this.qRr++;
                break;
            case 3:
                if (!bo.isNullOrNil(nVar.cqu().xfJ)) {
                    this.qRp++;
                    break;
                } else {
                    this.qRq++;
                    break;
                }
            case 4:
                this.qRt++;
                break;
            case 5:
                this.qRu++;
                break;
            case 15:
                this.qRs++;
                break;
            case 18:
                this.qRx++;
                break;
        }
        if (nVar.DI(32)) {
            if (nVar.cqo() != null && nVar.cqo().coK()) {
                kQ(true);
                AppMethodBeat.o(36847);
                return;
            } else if (nVar.field_type == 1) {
                kV(true);
                AppMethodBeat.o(36847);
                return;
            } else if (nVar.field_type == 15) {
                kW(true);
                AppMethodBeat.o(36847);
                return;
            }
        } else if (nVar.cqu() == null || bo.isNullOrNil(nVar.cqu().rCK)) {
            switch (nVar.field_type) {
                case 1:
                    kP(true);
                    AppMethodBeat.o(36847);
                    return;
                case 3:
                    if (bo.isNullOrNil(nVar.cqu().xfJ)) {
                        kU(true);
                        break;
                    }
                    kT(true);
                    AppMethodBeat.o(36847);
                    return;
                case 4:
                    kU(true);
                    AppMethodBeat.o(36847);
                    return;
                case 5:
                    kU(true);
                    AppMethodBeat.o(36847);
                    return;
                case 15:
                    kS(true);
                    AppMethodBeat.o(36847);
                    return;
                case 18:
                    kY(true);
                    AppMethodBeat.o(36847);
                    return;
            }
        } else {
            kR(true);
            AppMethodBeat.o(36847);
            return;
        }
        AppMethodBeat.o(36847);
    }

    public final void a(n nVar, boolean z) {
        AppMethodBeat.i(36848);
        if (nVar == null) {
            AppMethodBeat.o(36848);
            return;
        }
        if (z) {
            this.qSp.add(i.j(nVar));
        } else {
            this.qSq.add(i.j(nVar));
        }
        this.qSt.add(nVar.field_userName);
        this.qQU = this.qSt.size();
        if (af.cnk().equals(nVar.field_userName)) {
            kL(true);
            AppMethodBeat.o(36848);
            return;
        }
        kM(true);
        AppMethodBeat.o(36848);
    }

    public final void gg(String str, String str2) {
        AppMethodBeat.i(36849);
        this.qSn.add(str2);
        this.qSv.add(str);
        this.qQX = this.qSv.size();
        AppMethodBeat.o(36849);
    }

    public final void kK(boolean z) {
        AppMethodBeat.i(36850);
        if (z) {
            this.qRC = System.currentTimeMillis();
            AppMethodBeat.o(36850);
            return;
        }
        if (this.qRC > 0) {
            this.qRB += System.currentTimeMillis() - this.qRC;
            this.qRC = 0;
        }
        AppMethodBeat.o(36850);
    }

    public final void kL(boolean z) {
        AppMethodBeat.i(36851);
        if (z) {
            this.qRE = System.currentTimeMillis();
            AppMethodBeat.o(36851);
            return;
        }
        if (this.qRE > 0) {
            this.qRD += System.currentTimeMillis() - this.qRE;
            this.qRE = 0;
        }
        AppMethodBeat.o(36851);
    }

    public final void kM(boolean z) {
        AppMethodBeat.i(36852);
        if (z) {
            this.qRG = System.currentTimeMillis();
            AppMethodBeat.o(36852);
            return;
        }
        if (this.qRG > 0) {
            this.qRF += System.currentTimeMillis() - this.qRG;
            this.qRG = 0;
        }
        AppMethodBeat.o(36852);
    }

    public final void kN(boolean z) {
        AppMethodBeat.i(36853);
        if (z) {
            this.qRI = System.currentTimeMillis();
            AppMethodBeat.o(36853);
            return;
        }
        if (this.qRI > 0) {
            this.qRH += System.currentTimeMillis() - this.qRI;
            this.qRI = 0;
        }
        AppMethodBeat.o(36853);
    }

    public final void kO(boolean z) {
        AppMethodBeat.i(36854);
        if (z) {
            this.qRK = System.currentTimeMillis();
            AppMethodBeat.o(36854);
            return;
        }
        if (this.qRK > 0) {
            this.qRJ += System.currentTimeMillis() - this.qRK;
            this.qRK = 0;
        }
        AppMethodBeat.o(36854);
    }

    public final void kP(boolean z) {
        AppMethodBeat.i(36855);
        if (z) {
            this.qRM = System.currentTimeMillis();
            AppMethodBeat.o(36855);
            return;
        }
        if (this.qRM > 0) {
            this.qRL += System.currentTimeMillis() - this.qRM;
            this.qRM = 0;
        }
        AppMethodBeat.o(36855);
    }

    public final void kQ(boolean z) {
        AppMethodBeat.i(36856);
        if (z) {
            this.qSh = System.currentTimeMillis();
            AppMethodBeat.o(36856);
            return;
        }
        if (this.qSh > 0) {
            this.qSg += System.currentTimeMillis() - this.qSh;
            this.qSh = 0;
        }
        AppMethodBeat.o(36856);
    }

    public final void kR(boolean z) {
        AppMethodBeat.i(36857);
        if (z) {
            this.qSj = System.currentTimeMillis();
            AppMethodBeat.o(36857);
            return;
        }
        if (this.qSj > 0) {
            this.qSi += System.currentTimeMillis() - this.qSj;
            this.qSj = 0;
        }
        AppMethodBeat.o(36857);
    }

    public final void kS(boolean z) {
        AppMethodBeat.i(36858);
        if (z) {
            this.qRO = System.currentTimeMillis();
            AppMethodBeat.o(36858);
            return;
        }
        if (this.qRO > 0) {
            this.qRN += System.currentTimeMillis() - this.qRO;
            this.qRO = 0;
        }
        AppMethodBeat.o(36858);
    }

    public final void kT(boolean z) {
        AppMethodBeat.i(36859);
        if (z) {
            this.qRQ = System.currentTimeMillis();
            AppMethodBeat.o(36859);
            return;
        }
        if (this.qRQ > 0) {
            this.qRP += System.currentTimeMillis() - this.qRQ;
            this.qRQ = 0;
        }
        AppMethodBeat.o(36859);
    }

    public final void kU(boolean z) {
        AppMethodBeat.i(36860);
        if (z) {
            this.qRS = System.currentTimeMillis();
            AppMethodBeat.o(36860);
            return;
        }
        if (this.qRS > 0) {
            this.qRR += System.currentTimeMillis() - this.qRS;
            this.qRS = 0;
        }
        AppMethodBeat.o(36860);
    }

    public final void kV(boolean z) {
        AppMethodBeat.i(36861);
        if (z) {
            this.qRU = System.currentTimeMillis();
            AppMethodBeat.o(36861);
            return;
        }
        if (this.qRU > 0) {
            this.qRT += System.currentTimeMillis() - this.qRU;
            this.qRU = 0;
        }
        AppMethodBeat.o(36861);
    }

    public final void kW(boolean z) {
        AppMethodBeat.i(36862);
        if (z) {
            this.qRY = System.currentTimeMillis();
            AppMethodBeat.o(36862);
            return;
        }
        if (this.qRY > 0) {
            this.qRX += System.currentTimeMillis() - this.qRY;
            this.qRY = 0;
        }
        AppMethodBeat.o(36862);
    }

    public final void kX(boolean z) {
        AppMethodBeat.i(36863);
        if (z) {
            this.qSa = System.currentTimeMillis();
            AppMethodBeat.o(36863);
            return;
        }
        if (this.qSa > 0) {
            this.qRZ += System.currentTimeMillis() - this.qSa;
            this.qSa = 0;
        }
        AppMethodBeat.o(36863);
    }

    public final void kY(boolean z) {
        AppMethodBeat.i(36864);
        if (z) {
            this.qSc = System.currentTimeMillis();
            AppMethodBeat.o(36864);
            return;
        }
        if (this.qSc > 0) {
            this.qSb += System.currentTimeMillis() - this.qSc;
            this.qSc = 0;
        }
        AppMethodBeat.o(36864);
    }

    public final void kZ(boolean z) {
        this.qRg = z ? 1 : 0;
    }

    public b() {
        AppMethodBeat.i(36865);
        this.qQO = false;
        this.qQP = -1;
        this.qQQ = 0;
        this.qQR = 0;
        this.qQS = 0;
        this.qQT = 0;
        this.qQU = 0;
        this.qQV = 0;
        this.qQW = 0;
        this.qQX = 0;
        this.qQY = 0;
        this.qQZ = 0;
        this.qRa = 0;
        this.qRb = 0;
        this.qRc = 0;
        this.qRd = "";
        this.qRe = "";
        this.qRf = "";
        this.qRh = 0;
        this.qRi = 0;
        this.qRj = 0;
        this.qRk = 0;
        this.qRl = 0;
        this.qRm = 0;
        this.qRn = 0;
        this.jLU = 0;
        this.qRo = 0;
        this.qRp = 0;
        this.qRq = 0;
        this.qRr = 0;
        this.qRs = 0;
        this.qRt = 0;
        this.qRu = 0;
        this.qRv = 0;
        this.qRw = 0;
        this.qRx = 0;
        this.qRy = 0;
        this.qRz = 0;
        this.qRA = 0;
        this.qRB = 0;
        this.qRC = 0;
        this.qRD = 0;
        this.qRE = 0;
        this.qRF = 0;
        this.qRG = 0;
        this.qRH = 0;
        this.qRI = 0;
        this.qRJ = 0;
        this.qRK = 0;
        this.qRL = 0;
        this.qRM = 0;
        this.qRN = 0;
        this.qRO = 0;
        this.qRP = 0;
        this.qRQ = 0;
        this.qRR = 0;
        this.qRS = 0;
        this.qRT = 0;
        this.qRU = 0;
        this.qRV = 0;
        this.qRW = 0;
        this.qRX = 0;
        this.qRY = 0;
        this.qRZ = 0;
        this.qSa = 0;
        this.qSb = 0;
        this.qSc = 0;
        this.qSg = 0;
        this.qSh = 0;
        this.qSi = 0;
        this.qSj = 0;
        this.qSk = new HashSet();
        this.qSl = new HashSet();
        this.qSm = new HashSet();
        this.qSn = new HashSet();
        this.qSo = new HashSet();
        this.qSp = new HashSet();
        this.qSq = new HashSet();
        this.qSr = new HashSet();
        this.qSs = new HashSet();
        this.qSt = new HashSet();
        this.qSu = new HashSet();
        this.qSv = new HashSet();
        this.qSw = new HashSet();
        this.qSx = new HashSet();
        this.qSy = BaseClientBuilder.API_PRIORITY_OTHER;
        this.qSz = 0;
        this.qSA = new HashSet();
        this.qSB = new HashSet();
        this.qSC = new HashSet();
        this.qSD = new HashSet();
        this.qSE = new HashSet();
        this.qSF = new HashSet();
        this.qSG = new HashSet();
        this.qSH = new HashSet();
        this.qSI = new HashSet();
        this.qSJ = new HashSet();
        this.qSK = new HashSet();
        this.qSL = new HashSet();
        this.ecA = new c<rw>() {
            {
                AppMethodBeat.i(36843);
                this.xxI = rw.class.getName().hashCode();
                AppMethodBeat.o(36843);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(36844);
                rw rwVar = (rw) bVar;
                if (rwVar instanceof rw) {
                    ab.i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + b.this.qQP);
                    if (b.this.qQP != -1 && b.this.qQP < 0) {
                        Iterator it = rwVar.cNP.cNQ.iterator();
                        while (it.hasNext()) {
                            if (((Long) it.next()).longValue() > b.this.qQP) {
                                b bVar2 = b.this;
                                bVar2.qRa++;
                            }
                        }
                    }
                }
                AppMethodBeat.o(36844);
                return false;
            }
        };
        this.qSM = 0;
        a.xxA.c(this.ecA);
        AppMethodBeat.o(36865);
    }

    public b(int i, String str, int i2, String str2) {
        this();
        this.edf = i;
        this.qSd = str;
        this.qSe = i2;
        this.qSf = str2;
    }

    static String f(HashSet<String> hashSet) {
        String str;
        AppMethodBeat.i(36866);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashSet.iterator();
        Object obj = 1;
        while (it.hasNext()) {
            str = (String) it.next();
            if (obj != null) {
                stringBuffer.append(str);
                obj = null;
            } else {
                stringBuffer.append("|".concat(String.valueOf(str)));
            }
        }
        str = stringBuffer.toString();
        AppMethodBeat.o(36866);
        return str;
    }
}
