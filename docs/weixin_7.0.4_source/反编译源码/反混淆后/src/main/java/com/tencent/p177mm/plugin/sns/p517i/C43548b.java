package com.tencent.p177mm.plugin.sns.p517i;

import android.os.Process;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.p230g.p231a.C18389rw;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.aao;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sns.i.b */
public final class C43548b {
    C4884c ecA;
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
    public class C38712 implements Runnable {
        final /* synthetic */ int qSO;

        public C38712(int i) {
            this.qSO = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(36845);
            if (C1720g.m3534RN().mo5161QY()) {
                int myTid = Process.myTid();
                C4990ab.m7417i("MicroMsg.SnsBrowseInfoHelper", "summersns report tid[%d] osTid[%d], prior[%d][%d]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(myTid), Integer.valueOf(Thread.currentThread().getPriority()), Integer.valueOf(Process.getThreadPriority(myTid)));
                long currentTimeMillis = System.currentTimeMillis();
                C43548b c43548b = C43548b.this;
                int i = this.qSO;
                if (i != -1) {
                    C46236n CZ = C34955aj.m57387CZ(i);
                    if (CZ != null) {
                        String j = C29036i.m46115j(CZ);
                        c43548b.qRf = j;
                        aao cqL = C13373af.cnJ().mo69179YX("@__weixintimtline").cqL();
                        if (cqL.wfM == 0 || C29036i.m46118jW(cqL.wfM).compareTo(j) <= 0) {
                            c43548b.mo69120kZ(false);
                        } else {
                            c43548b.mo69120kZ(true);
                        }
                    }
                }
                i = C1855t.m3878Zo();
                C32831d c32831d = new C32831d();
                c32831d.mo53400l("20BrowseTime", c43548b.qQQ + ",");
                c32831d.mo53400l("21BrowseFeedCount", c43548b.qQR + ",");
                c32831d.mo53400l("22CommentOrLikeFeedCount", c43548b.qQS + ",");
                c32831d.mo53400l("23ClickFeedCount", c43548b.qQT + ",");
                c32831d.mo53400l("24ClickAlbumCount", c43548b.qQU + ",");
                c32831d.mo53400l("25PostFeedCount", c43548b.qQV + ",");
                c32831d.mo53400l("26ExposeFeedCount", c43548b.qSm.size() + ",");
                c32831d.mo53400l("27FavFeedCount", c43548b.qSn.size() + ",");
                c32831d.mo53400l("28BlackListFriendCount", c43548b.qQY + ",");
                c32831d.mo53400l("29OutsiderFriendCount", c43548b.qQZ + ",");
                c32831d.mo53400l("30BrowseNewFeedCount", c43548b.qRa + ",");
                c32831d.mo53400l("31HasNewSnsMsgWhenEntrance", c43548b.qRb + ",");
                c32831d.mo53400l("32HasNewChatMsgWhenExit", c43548b.qRc + ",");
                c32831d.mo53400l("33StartBrowseSnsObjectId", c43548b.qRd + ",");
                c32831d.mo53400l("34EndBrowseSnsObjectId", c43548b.qRe + ",");
                c32831d.mo53400l("35NextBrowseSnsObjectId", c43548b.qRf + ",");
                c32831d.mo53400l("36HasNewFeedInServer", c43548b.qRg + ",");
                c32831d.mo53400l("37BrowseBrandUrlFeedCount", c43548b.qRh + ",");
                c32831d.mo53400l("38BrowseNotBrandUrlFeedCount", c43548b.qRi + ",");
                c32831d.mo53400l("39BrowseTextFeedCount", c43548b.qRj + ",");
                c32831d.mo53400l("40BrowseImageFeedCount", c43548b.qRk + ",");
                c32831d.mo53400l("41BrowseSightFeedCount", c43548b.qRl + ",");
                c32831d.mo53400l("42BrowseAdFeedCount", c43548b.qRm + ",");
                c32831d.mo53400l("43BrowseMusicFeedCount", c43548b.qRn + ",");
                c32831d.mo53400l("44contactCount", i + ",");
                c32831d.mo53400l("BrowseVideoFeedCount45", c43548b.qRo + ",");
                c32831d.mo53400l("ClickBrandUrlFeedCount46", c43548b.qRp + ",");
                c32831d.mo53400l("ClickNotBrandUrlFeedCount47", c43548b.qRq + ",");
                c32831d.mo53400l("ClickImageFeedCount48", c43548b.qRr + ",");
                c32831d.mo53400l("ClickSightFeedCount49", c43548b.qRs + ",");
                c32831d.mo53400l("ClickMusicFeedCount50", c43548b.qRt + ",");
                c32831d.mo53400l("ClickVideoFeedCount51", c43548b.qRu + ",");
                c32831d.mo53400l("BrowseOtherFeedCount52", c43548b.qRv + ",");
                c32831d.mo53400l("BrowserStreamVideoFeedCount53", c43548b.qRw + ",");
                c32831d.mo53400l("ClickStreamVideoCount54", c43548b.qRx + ",");
                c32831d.mo53400l("ClickAdFeed55", c43548b.qRy + ",");
                c32831d.mo53400l("56BackGroundTime", c43548b.qRz + ",");
                c32831d.mo53400l("57BrowseTimeLineTime", c43548b.qRB + ",");
                c32831d.mo53400l("58BrowseMyAlbumTime", c43548b.qRD + ",");
                c32831d.mo53400l("59BrowseOtherAlbumTime", c43548b.qRF + ",");
                c32831d.mo53400l("60BrowseMessageListTime", c43548b.qRH + ",");
                c32831d.mo53400l("61ClickNewPostTime", c43548b.qRJ + ",");
                c32831d.mo53400l("62BrowseFullScreenImageTime", c43548b.qRL + ",");
                c32831d.mo53400l("63BrowseFullScreenSightTime", c43548b.qRN + ",");
                c32831d.mo53400l("64BrowseMPArticleTime", c43548b.qRP + ",");
                c32831d.mo53400l("65BrowseExternalArticleTime", c43548b.qRR + ",");
                c32831d.mo53400l("66BrowseFullScreenAdImageTime", c43548b.qRT + ",");
                c32831d.mo53400l("67BrowseAdSightTime", "0,");
                c32831d.mo53400l("68BrowseAdDetailTime", c43548b.qRV + ",");
                c32831d.mo53400l("69BrowseFullScreenAdSightTime", c43548b.qRX + ",");
                c32831d.mo53400l("70BrowseFullScreenAdLongVideoTime", c43548b.qRZ + ",");
                c32831d.mo53400l("71BrowseForwardAdLongVideoTime", c43548b.qSb + ",");
                c32831d.mo53400l("72StartBrowseTime", c43548b.qSM + ",");
                c32831d.mo53400l("73ClickFeedIdList", C43548b.m77830f(c43548b.qSl) + ",");
                c32831d.mo53400l("74ExposeFeedIdList", C43548b.m77830f(c43548b.qSm) + ",");
                c32831d.mo53400l("75FavFeedIdList", C43548b.m77830f(c43548b.qSn) + ",");
                c32831d.mo53400l("76ClickAlbumUserList", C43548b.m77830f(c43548b.qSt) + ",");
                c32831d.mo53400l("77ForwardFeedIdList", C43548b.m77830f(c43548b.qSo) + ",");
                c32831d.mo53400l("78ClickAvatarFeedIdList", C43548b.m77830f(c43548b.qSp) + ",");
                c32831d.mo53400l("79ClickNickNameFeedIdList", C43548b.m77830f(c43548b.qSq) + ",");
                c32831d.mo53400l("80ForwardToSingleChatFeedIdList", C43548b.m77830f(c43548b.qSr) + ",");
                c32831d.mo53400l("81ForwardToChatRoomFeedIdList", C43548b.m77830f(c43548b.qSs) + ",");
                c32831d.mo53400l("82FeedUpdateNotification", c43548b.edf + ",");
                c32831d.mo53400l("83abandon", ",");
                c32831d.mo53400l("84abandon", ",");
                c32831d.mo53400l("85LastestUnReadFeedId", c43548b.qSd + ",");
                c32831d.mo53400l("86UnReadMsgCount", c43548b.qSe + ",");
                c32831d.mo53400l("87BrowseAdCanvasPageTime", c43548b.qSg + ",");
                c32831d.mo53400l("88BrowseForwardAdCanvasTime", c43548b.qSi + ",");
                c32831d.mo53400l("90EnterObjectId", c43548b.qSf);
                C4990ab.m7418v("MicroMsg.SnsBrowseInfoHelper", "report logbuffer(12076): " + c32831d.mo53398Fk());
                C7060h.pYm.mo8381e(12076, c32831d);
                C4879a.xxA.mo10053d(c43548b.ecA);
                c43548b.qQQ = 0;
                c43548b.qQR = 0;
                c43548b.qQS = 0;
                c43548b.qQT = 0;
                c43548b.qQU = 0;
                c43548b.qQV = 0;
                c43548b.qQW = 0;
                c43548b.qQX = 0;
                c43548b.qQY = 0;
                c43548b.qQZ = 0;
                c43548b.qRa = 0;
                c43548b.qRb = 0;
                c43548b.qRc = 0;
                c43548b.qRd = "";
                c43548b.qRe = "";
                c43548b.qRf = "";
                c43548b.qRg = 0;
                c43548b.qRh = 0;
                c43548b.qRi = 0;
                c43548b.qRj = 0;
                c43548b.qRk = 0;
                c43548b.qRl = 0;
                c43548b.qRm = 0;
                c43548b.qRn = 0;
                c43548b.jLU = 0;
                c43548b.qRo = 0;
                c43548b.qRp = 0;
                c43548b.qRq = 0;
                c43548b.qRr = 0;
                c43548b.qRs = 0;
                c43548b.qRt = 0;
                c43548b.qRu = 0;
                c43548b.qRv = 0;
                c43548b.qRw = 0;
                c43548b.qRx = 0;
                c43548b.qRy = 0;
                c43548b.qRz = 0;
                c43548b.qRA = 0;
                c43548b.qRB = 0;
                c43548b.qRC = 0;
                c43548b.qRD = 0;
                c43548b.qRE = 0;
                c43548b.qRF = 0;
                c43548b.qRG = 0;
                c43548b.qRH = 0;
                c43548b.qRI = 0;
                c43548b.qRJ = 0;
                c43548b.qRK = 0;
                c43548b.qRL = 0;
                c43548b.qRM = 0;
                c43548b.qRN = 0;
                c43548b.qRO = 0;
                c43548b.qRP = 0;
                c43548b.qRQ = 0;
                c43548b.qRR = 0;
                c43548b.qRS = 0;
                c43548b.qRT = 0;
                c43548b.qRU = 0;
                c43548b.qRV = 0;
                c43548b.qRW = 0;
                c43548b.qRX = 0;
                c43548b.qRY = 0;
                c43548b.qRZ = 0;
                c43548b.qSa = 0;
                c43548b.qSb = 0;
                c43548b.qSc = 0;
                c43548b.qSl.clear();
                c43548b.qSm.clear();
                c43548b.qSn.clear();
                c43548b.qSo.clear();
                c43548b.qSp.clear();
                c43548b.qSq.clear();
                c43548b.qSr.clear();
                c43548b.qSs.clear();
                c43548b.edf = 0;
                c43548b.qSd = "";
                c43548b.qSe = 0;
                C4990ab.m7417i("MicroMsg.SnsBrowseInfoHelper", "summersns report take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(36845);
                return;
            }
            C4990ab.m7420w("MicroMsg.SnsBrowseInfoHelper", "account not init.");
            AppMethodBeat.m2505o(36845);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.i.b$1 */
    class C70931 extends C4884c<C18389rw> {
        C70931() {
            AppMethodBeat.m2504i(36843);
            this.xxI = C18389rw.class.getName().hashCode();
            AppMethodBeat.m2505o(36843);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36844);
            C18389rw c18389rw = (C18389rw) c4883b;
            if (c18389rw instanceof C18389rw) {
                C4990ab.m7416i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + C43548b.this.qQP);
                if (C43548b.this.qQP != -1 && C43548b.this.qQP < 0) {
                    Iterator it = c18389rw.cNP.cNQ.iterator();
                    while (it.hasNext()) {
                        if (((Long) it.next()).longValue() > C43548b.this.qQP) {
                            C43548b c43548b = C43548b.this;
                            c43548b.qRa++;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(36844);
            return false;
        }
    }

    /* renamed from: w */
    public final void mo69121w(C46236n c46236n) {
        AppMethodBeat.m2504i(36846);
        if (c46236n == null) {
            AppMethodBeat.m2505o(36846);
            return;
        }
        this.qSk.add(c46236n.cqU());
        this.qQS = this.qSk.size();
        AppMethodBeat.m2505o(36846);
    }

    /* renamed from: x */
    public final void mo69122x(C46236n c46236n) {
        AppMethodBeat.m2504i(36847);
        if (c46236n == null) {
            AppMethodBeat.m2505o(36847);
            return;
        }
        String cqU = c46236n.cqU();
        String j = C29036i.m46115j(c46236n);
        if (this.qSl.contains(j)) {
            AppMethodBeat.m2505o(36847);
            return;
        }
        C4990ab.m7417i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", cqU, j);
        this.qQT++;
        this.qSl.add(j);
        if (c46236n.mo74253DI(32)) {
            this.qRy++;
        }
        switch (c46236n.field_type) {
            case 1:
                this.qRr++;
                break;
            case 3:
                if (!C5046bo.isNullOrNil(c46236n.cqu().xfJ)) {
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
        if (c46236n.mo74253DI(32)) {
            if (c46236n.cqo() != null && c46236n.cqo().coK()) {
                mo69111kQ(true);
                AppMethodBeat.m2505o(36847);
                return;
            } else if (c46236n.field_type == 1) {
                mo69116kV(true);
                AppMethodBeat.m2505o(36847);
                return;
            } else if (c46236n.field_type == 15) {
                mo69117kW(true);
                AppMethodBeat.m2505o(36847);
                return;
            }
        } else if (c46236n.cqu() == null || C5046bo.isNullOrNil(c46236n.cqu().rCK)) {
            switch (c46236n.field_type) {
                case 1:
                    mo69110kP(true);
                    AppMethodBeat.m2505o(36847);
                    return;
                case 3:
                    if (C5046bo.isNullOrNil(c46236n.cqu().xfJ)) {
                        mo69115kU(true);
                        break;
                    }
                    mo69114kT(true);
                    AppMethodBeat.m2505o(36847);
                    return;
                case 4:
                    mo69115kU(true);
                    AppMethodBeat.m2505o(36847);
                    return;
                case 5:
                    mo69115kU(true);
                    AppMethodBeat.m2505o(36847);
                    return;
                case 15:
                    mo69113kS(true);
                    AppMethodBeat.m2505o(36847);
                    return;
                case 18:
                    mo69119kY(true);
                    AppMethodBeat.m2505o(36847);
                    return;
            }
        } else {
            mo69112kR(true);
            AppMethodBeat.m2505o(36847);
            return;
        }
        AppMethodBeat.m2505o(36847);
    }

    /* renamed from: a */
    public final void mo69103a(C46236n c46236n, boolean z) {
        AppMethodBeat.m2504i(36848);
        if (c46236n == null) {
            AppMethodBeat.m2505o(36848);
            return;
        }
        if (z) {
            this.qSp.add(C29036i.m46115j(c46236n));
        } else {
            this.qSq.add(C29036i.m46115j(c46236n));
        }
        this.qSt.add(c46236n.field_userName);
        this.qQU = this.qSt.size();
        if (C13373af.cnk().equals(c46236n.field_userName)) {
            mo69106kL(true);
            AppMethodBeat.m2505o(36848);
            return;
        }
        mo69107kM(true);
        AppMethodBeat.m2505o(36848);
    }

    /* renamed from: gg */
    public final void mo69104gg(String str, String str2) {
        AppMethodBeat.m2504i(36849);
        this.qSn.add(str2);
        this.qSv.add(str);
        this.qQX = this.qSv.size();
        AppMethodBeat.m2505o(36849);
    }

    /* renamed from: kK */
    public final void mo69105kK(boolean z) {
        AppMethodBeat.m2504i(36850);
        if (z) {
            this.qRC = System.currentTimeMillis();
            AppMethodBeat.m2505o(36850);
            return;
        }
        if (this.qRC > 0) {
            this.qRB += System.currentTimeMillis() - this.qRC;
            this.qRC = 0;
        }
        AppMethodBeat.m2505o(36850);
    }

    /* renamed from: kL */
    public final void mo69106kL(boolean z) {
        AppMethodBeat.m2504i(36851);
        if (z) {
            this.qRE = System.currentTimeMillis();
            AppMethodBeat.m2505o(36851);
            return;
        }
        if (this.qRE > 0) {
            this.qRD += System.currentTimeMillis() - this.qRE;
            this.qRE = 0;
        }
        AppMethodBeat.m2505o(36851);
    }

    /* renamed from: kM */
    public final void mo69107kM(boolean z) {
        AppMethodBeat.m2504i(36852);
        if (z) {
            this.qRG = System.currentTimeMillis();
            AppMethodBeat.m2505o(36852);
            return;
        }
        if (this.qRG > 0) {
            this.qRF += System.currentTimeMillis() - this.qRG;
            this.qRG = 0;
        }
        AppMethodBeat.m2505o(36852);
    }

    /* renamed from: kN */
    public final void mo69108kN(boolean z) {
        AppMethodBeat.m2504i(36853);
        if (z) {
            this.qRI = System.currentTimeMillis();
            AppMethodBeat.m2505o(36853);
            return;
        }
        if (this.qRI > 0) {
            this.qRH += System.currentTimeMillis() - this.qRI;
            this.qRI = 0;
        }
        AppMethodBeat.m2505o(36853);
    }

    /* renamed from: kO */
    public final void mo69109kO(boolean z) {
        AppMethodBeat.m2504i(36854);
        if (z) {
            this.qRK = System.currentTimeMillis();
            AppMethodBeat.m2505o(36854);
            return;
        }
        if (this.qRK > 0) {
            this.qRJ += System.currentTimeMillis() - this.qRK;
            this.qRK = 0;
        }
        AppMethodBeat.m2505o(36854);
    }

    /* renamed from: kP */
    public final void mo69110kP(boolean z) {
        AppMethodBeat.m2504i(36855);
        if (z) {
            this.qRM = System.currentTimeMillis();
            AppMethodBeat.m2505o(36855);
            return;
        }
        if (this.qRM > 0) {
            this.qRL += System.currentTimeMillis() - this.qRM;
            this.qRM = 0;
        }
        AppMethodBeat.m2505o(36855);
    }

    /* renamed from: kQ */
    public final void mo69111kQ(boolean z) {
        AppMethodBeat.m2504i(36856);
        if (z) {
            this.qSh = System.currentTimeMillis();
            AppMethodBeat.m2505o(36856);
            return;
        }
        if (this.qSh > 0) {
            this.qSg += System.currentTimeMillis() - this.qSh;
            this.qSh = 0;
        }
        AppMethodBeat.m2505o(36856);
    }

    /* renamed from: kR */
    public final void mo69112kR(boolean z) {
        AppMethodBeat.m2504i(36857);
        if (z) {
            this.qSj = System.currentTimeMillis();
            AppMethodBeat.m2505o(36857);
            return;
        }
        if (this.qSj > 0) {
            this.qSi += System.currentTimeMillis() - this.qSj;
            this.qSj = 0;
        }
        AppMethodBeat.m2505o(36857);
    }

    /* renamed from: kS */
    public final void mo69113kS(boolean z) {
        AppMethodBeat.m2504i(36858);
        if (z) {
            this.qRO = System.currentTimeMillis();
            AppMethodBeat.m2505o(36858);
            return;
        }
        if (this.qRO > 0) {
            this.qRN += System.currentTimeMillis() - this.qRO;
            this.qRO = 0;
        }
        AppMethodBeat.m2505o(36858);
    }

    /* renamed from: kT */
    public final void mo69114kT(boolean z) {
        AppMethodBeat.m2504i(36859);
        if (z) {
            this.qRQ = System.currentTimeMillis();
            AppMethodBeat.m2505o(36859);
            return;
        }
        if (this.qRQ > 0) {
            this.qRP += System.currentTimeMillis() - this.qRQ;
            this.qRQ = 0;
        }
        AppMethodBeat.m2505o(36859);
    }

    /* renamed from: kU */
    public final void mo69115kU(boolean z) {
        AppMethodBeat.m2504i(36860);
        if (z) {
            this.qRS = System.currentTimeMillis();
            AppMethodBeat.m2505o(36860);
            return;
        }
        if (this.qRS > 0) {
            this.qRR += System.currentTimeMillis() - this.qRS;
            this.qRS = 0;
        }
        AppMethodBeat.m2505o(36860);
    }

    /* renamed from: kV */
    public final void mo69116kV(boolean z) {
        AppMethodBeat.m2504i(36861);
        if (z) {
            this.qRU = System.currentTimeMillis();
            AppMethodBeat.m2505o(36861);
            return;
        }
        if (this.qRU > 0) {
            this.qRT += System.currentTimeMillis() - this.qRU;
            this.qRU = 0;
        }
        AppMethodBeat.m2505o(36861);
    }

    /* renamed from: kW */
    public final void mo69117kW(boolean z) {
        AppMethodBeat.m2504i(36862);
        if (z) {
            this.qRY = System.currentTimeMillis();
            AppMethodBeat.m2505o(36862);
            return;
        }
        if (this.qRY > 0) {
            this.qRX += System.currentTimeMillis() - this.qRY;
            this.qRY = 0;
        }
        AppMethodBeat.m2505o(36862);
    }

    /* renamed from: kX */
    public final void mo69118kX(boolean z) {
        AppMethodBeat.m2504i(36863);
        if (z) {
            this.qSa = System.currentTimeMillis();
            AppMethodBeat.m2505o(36863);
            return;
        }
        if (this.qSa > 0) {
            this.qRZ += System.currentTimeMillis() - this.qSa;
            this.qSa = 0;
        }
        AppMethodBeat.m2505o(36863);
    }

    /* renamed from: kY */
    public final void mo69119kY(boolean z) {
        AppMethodBeat.m2504i(36864);
        if (z) {
            this.qSc = System.currentTimeMillis();
            AppMethodBeat.m2505o(36864);
            return;
        }
        if (this.qSc > 0) {
            this.qSb += System.currentTimeMillis() - this.qSc;
            this.qSc = 0;
        }
        AppMethodBeat.m2505o(36864);
    }

    /* renamed from: kZ */
    public final void mo69120kZ(boolean z) {
        this.qRg = z ? 1 : 0;
    }

    public C43548b() {
        AppMethodBeat.m2504i(36865);
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
        this.ecA = new C70931();
        this.qSM = 0;
        C4879a.xxA.mo10052c(this.ecA);
        AppMethodBeat.m2505o(36865);
    }

    public C43548b(int i, String str, int i2, String str2) {
        this();
        this.edf = i;
        this.qSd = str;
        this.qSe = i2;
        this.qSf = str2;
    }

    /* renamed from: f */
    static String m77830f(HashSet<String> hashSet) {
        String str;
        AppMethodBeat.m2504i(36866);
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
        AppMethodBeat.m2505o(36866);
        return str;
    }
}
