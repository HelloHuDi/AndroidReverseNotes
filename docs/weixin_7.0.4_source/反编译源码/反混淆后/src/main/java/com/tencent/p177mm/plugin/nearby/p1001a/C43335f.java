package com.tencent.p177mm.plugin.nearby.p1001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26242ss;
import com.tencent.p177mm.p230g.p231a.C32578jb;
import com.tencent.p177mm.p230g.p231a.C32588kn;
import com.tencent.p177mm.p230g.p231a.C32589ko;
import com.tencent.p177mm.p230g.p231a.C32589ko.C32591b;
import com.tencent.p177mm.p230g.p231a.C45338kf;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.p230g.p231a.C6499jg;
import com.tencent.p177mm.p230g.p231a.C6499jg.C6501b;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p230g.p231a.C9388jf;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.appbrand.service.C19732h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.pluginsdk.p1077c.C35783d;
import com.tencent.p177mm.pluginsdk.p1077c.C40419c;
import com.tencent.p177mm.protocal.protobuf.ayb;
import com.tencent.p177mm.protocal.protobuf.ayd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C35998bg;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7309bd.C5131a;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.nearby.a.f */
public final class C43335f implements C1816at {
    private C4884c egQ = new C346055();
    private C4884c oPA = new C285902();
    C40419c<C32588kn> oPB = new C126973();
    C40419c<C32589ko> oPC = new C126984();
    C35783d oPD = new C367936();
    private C5131a oPE = new C433367();
    private C4884c<C6523mp> oPF = new C394558();
    private C4884c<C45338kf> oPG = new C433379();
    private C4884c oPz = new C213531();

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$3 */
    class C126973 extends C40419c<C32588kn> {
        C126973() {
        }

        /* renamed from: a */
        public final /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            AppMethodBeat.m2504i(55380);
            C32588kn c32588kn = (C32588kn) c4883b;
            C46109c c46109c = (C46109c) c1207m;
            c32588kn.cGl.cGr = c46109c.bUX();
            c32588kn.cGl.cGt = c46109c.bUY();
            c32588kn.cGl.cGs = c46109c.bUZ();
            c32588kn.cGl.czE = c32588kn.cGk.czE;
            AppMethodBeat.m2505o(55380);
            return c32588kn;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55381);
            C32588kn c32588kn = (C32588kn) c4883b;
            if (c32588kn.cGk.cFT) {
                C40419c.m69325k(c32588kn);
                AppMethodBeat.m2505o(55381);
            } else {
                mo63831l(c32588kn);
                AppMethodBeat.m2505o(55381);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(55379);
            C32588kn c32588kn = (C32588kn) c4883b;
            C46109c c46109c = new C46109c(c32588kn.cGk.czE, c32588kn.cGk.cGm, c32588kn.cGk.cEB, c32588kn.cGk.cGn, c32588kn.cGk.cGo, c32588kn.cGk.cGp, c32588kn.cGk.cGq);
            AppMethodBeat.m2505o(55379);
            return c46109c;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return 148;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$4 */
    class C126984 extends C40419c<C32589ko> {
        C126984() {
        }

        /* renamed from: a */
        public final /* synthetic */ C4883b mo24700a(int i, C1207m c1207m, C4883b c4883b) {
            AppMethodBeat.m2504i(55383);
            C32589ko c32589ko = (C32589ko) c4883b;
            C43334e c43334e = (C43334e) c1207m;
            c32589ko.cGv.cEX = ((ayd) c43334e.ehh.fsH.fsP).ehB;
            C32591b c32591b = c32589ko.cGv;
            LinkedList linkedList = ((ayd) c43334e.ehh.fsH.fsP).vEh;
            if (linkedList != null) {
                C1720g.m3534RN().mo5159QU();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ayb ayb = (ayb) it.next();
                    C20118a.ask().mo35364Yn().mo56747ia(ayb.jBB, ayb.wlF);
                }
            }
            c32591b.cGh = linkedList;
            AppMethodBeat.m2505o(55383);
            return c32589ko;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55384);
            C32589ko c32589ko = (C32589ko) c4883b;
            if (c32589ko.cGu.cFT) {
                C40419c.m69325k(c32589ko);
                AppMethodBeat.m2505o(55384);
            } else {
                mo63831l(c32589ko);
                AppMethodBeat.m2505o(55384);
            }
            return false;
        }

        /* renamed from: b */
        public final /* synthetic */ C1207m mo24701b(C4883b c4883b) {
            AppMethodBeat.m2504i(55382);
            C43334e c43334e = new C43334e(((C32589ko) c4883b).cGu.cEw);
            AppMethodBeat.m2505o(55382);
            return c43334e;
        }

        /* renamed from: Jy */
        public final int mo24699Jy() {
            return 377;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$1 */
    class C213531 extends C4884c<C9388jf> {
        C213531() {
            AppMethodBeat.m2504i(55374);
            this.xxI = C9388jf.class.getName().hashCode();
            AppMethodBeat.m2505o(55374);
        }

        /* renamed from: a */
        private static boolean m32757a(C9388jf c9388jf) {
            int i = 3;
            AppMethodBeat.m2504i(55375);
            C1828b c1828b = c9388jf.cEs.cEt;
            C7620bi c7620bi = c9388jf.cEs.csG;
            if (c1828b.fmx != null && c1828b.scene == 1) {
                C1720g.m3536RP().mo5239Ry().set(73729, Integer.valueOf(1));
                C7570bf c7570bf = new C7570bf();
                c7570bf.field_content = c7620bi.field_content;
                c7570bf.field_createtime = C5046bo.anT();
                c7570bf.field_imgpath = "";
                c7570bf.field_sayhicontent = C4996ah.getContext().getString(C25738R.string.d5f);
                c7570bf.field_sayhiuser = c7620bi.field_talker;
                c7570bf.field_scene = 18;
                if (c7620bi.field_status > 3) {
                    i = c7620bi.field_status;
                }
                c7570bf.field_status = i;
                c7570bf.field_svrid = c7620bi.field_msgSvrId;
                c7570bf.field_talker = c7620bi.field_talker;
                c7570bf.field_type = 34;
                c7570bf.field_isSend = 0;
                c7570bf.field_sayhiencryptuser = c7620bi.field_talker;
                c7570bf.field_ticket = c1828b.fmx;
                C1720g.m3534RN().mo5159QU();
                ((C35998bg) ((C6982j) C1720g.m3528K(C6982j.class)).bOo()).mo56738a(c7570bf);
                C6497je c6497je = new C6497je();
                c6497je.cEq.cEr = c7620bi.field_talker;
                C4879a.xxA.mo10055m(c6497je);
            }
            AppMethodBeat.m2505o(55375);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$2 */
    class C285902 extends C4884c<C6499jg> {
        C285902() {
            AppMethodBeat.m2504i(55377);
            this.xxI = C6499jg.class.getName().hashCode();
            AppMethodBeat.m2505o(55377);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55378);
            C6499jg c6499jg = (C6499jg) c4883b;
            switch (c6499jg.cEu.czE) {
                case 1:
                    C43333b.m77312cK(c6499jg.cEu.cEw, c6499jg.cEu.cEx);
                    break;
                case 2:
                    C43333b.m77314zY(c6499jg.cEu.cEx);
                    break;
                case 3:
                    c6499jg.cEv.cvi = C43333b.bUU();
                    break;
                case 4:
                    C43333b.bUV();
                    break;
                case 5:
                    C43333b.bUW();
                    break;
                case 6:
                    C43333b.m77311TA(c6499jg.cEu.cEw);
                    break;
                case 7:
                    boolean z;
                    C6501b c6501b = c6499jg.cEv;
                    Long l = (Long) C1720g.m3536RP().mo5239Ry().get(8210, null);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null) {
                        z = true;
                    } else if (currentTimeMillis > l.longValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c6501b.cvi = z;
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            AppMethodBeat.m2505o(55378);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$5 */
    class C346055 extends C4884c<C26242ss> {
        C346055() {
            AppMethodBeat.m2504i(55385);
            this.xxI = C26242ss.class.getName().hashCode();
            AppMethodBeat.m2505o(55385);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55386);
            C26242ss c26242ss = (C26242ss) c4883b;
            if (c26242ss.cOR.cOS.equals(C32588kn.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C43335f.this.oPB.dgW();
                } else {
                    C43335f.this.oPB.bIW();
                }
            } else if (c26242ss.cOR.cOS.equals(C32589ko.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C43335f.this.oPC.dgW();
                } else {
                    C43335f.this.oPC.bIW();
                }
            } else if (c26242ss.cOR.cOS.equals(C32578jb.class.getName())) {
                if (c26242ss.cOR.czE == 1) {
                    C43335f.this.oPD.axy();
                } else {
                    C43335f.this.oPD.unregister();
                }
            }
            AppMethodBeat.m2505o(55386);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$6 */
    class C367936 extends C35783d {
        C367936() {
        }

        /* renamed from: NJ */
        public final C4883b mo36283NJ(String str) {
            AppMethodBeat.m2504i(55387);
            C32578jb c32578jb = new C32578jb();
            c32578jb.cEi.ctq = str;
            AppMethodBeat.m2505o(55387);
            return c32578jb;
        }

        public final C7296k bCU() {
            AppMethodBeat.m2504i(55388);
            C1720g.m3534RN().mo5159QU();
            C7296k c7296k = (C7296k) ((C6982j) C1720g.m3528K(C6982j.class)).bOo();
            AppMethodBeat.m2505o(55388);
            return c7296k;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$8 */
    class C394558 extends C4884c<C6523mp> {
        C394558() {
            AppMethodBeat.m2504i(55390);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(55390);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55392);
            boolean aiv = C394558.aiv();
            AppMethodBeat.m2505o(55392);
            return aiv;
        }

        private static boolean aiv() {
            AppMethodBeat.m2504i(55391);
            C43335f.bVa();
            AppMethodBeat.m2505o(55391);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$7 */
    class C433367 implements C5131a {
        C433367() {
        }

        /* renamed from: a */
        public final void mo10530a(C7309bd c7309bd, C7616ad c7616ad) {
            AppMethodBeat.m2504i(55389);
            if (!(c7309bd == null || c7616ad == null || !c7616ad.mo16698Oa())) {
                C1720g.m3534RN().mo5159QU();
                ((C6982j) C1720g.m3528K(C6982j.class)).bOo().mo15230QU(c7616ad.field_username);
            }
            AppMethodBeat.m2505o(55389);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.a.f$9 */
    class C433379 extends C4884c<C45338kf> {
        C433379() {
            AppMethodBeat.m2504i(55393);
            this.xxI = C45338kf.class.getName().hashCode();
            AppMethodBeat.m2505o(55393);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(55395);
            boolean bVb = C433379.bVb();
            AppMethodBeat.m2505o(55395);
            return bVb;
        }

        private static boolean bVb() {
            AppMethodBeat.m2504i(55394);
            C43335f.bVa();
            AppMethodBeat.m2505o(55394);
            return false;
        }
    }

    public C43335f() {
        AppMethodBeat.m2504i(55396);
        AppMethodBeat.m2505o(55396);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(55397);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15729b(this.oPE);
        this.oPG.dnU();
        this.oPF.dead();
        C4879a.xxA.mo10053d(this.oPA);
        C4879a.xxA.mo10053d(this.egQ);
        C4879a.xxA.mo10053d(this.oPB);
        C4879a.xxA.mo10053d(this.oPC);
        this.oPz.dead();
        AppMethodBeat.m2505o(55397);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(55398);
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15707a(this.oPE);
        this.oPG.dnU();
        this.oPF.dnU();
        C4879a.xxA.mo10052c(this.egQ);
        C4879a.xxA.mo10052c(this.oPA);
        C4879a.xxA.mo10052c(this.oPB);
        C4879a.xxA.mo10052c(this.oPC);
        this.oPz.dnU();
        AppMethodBeat.m2505o(55398);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    static /* synthetic */ void bVa() {
        AppMethodBeat.m2504i(55399);
        if (((C23167a) C1720g.m3528K(C23167a.class)).mo38786xj("labs_nearbylife")) {
            int i = C26373g.m41964Nu().getInt("LifeAppLatestVersionValue", 0);
            C4990ab.m7417i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload lifeAroundLatestVersion %d lastRequestLifeAroundVersion %d", Integer.valueOf(i), Integer.valueOf(C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, 0)));
            if (i > C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, 0)) {
                int i2 = C26373g.m41964Nu().getInt("LifeAppPrefetchTimeThreshold", 259200);
                C4990ab.m7417i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload lastRequestLifeAroundTime %d lifeAroundPreloadInterval %d", Long.valueOf(C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, 0)), Integer.valueOf(i2));
                if (System.currentTimeMillis() - C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, 0) > ((long) i2) * 1000) {
                    try {
                        C4990ab.m7416i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload");
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, Integer.valueOf(i));
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        ((C19732h) C1720g.m3528K(C19732h.class)).mo34966xO(((C23167a) C1720g.m3528K(C23167a.class)).agP("labs_nearbylife"));
                        C7053e.pXa.mo8378a(863, 30, 1, false);
                        AppMethodBeat.m2505o(55399);
                        return;
                    } catch (Exception e) {
                    }
                }
            }
            AppMethodBeat.m2505o(55399);
            return;
        }
        C4990ab.m7416i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload welab not open");
        AppMethodBeat.m2505o(55399);
    }
}
