package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements at {
    private c egQ = new c<ss>() {
        {
            AppMethodBeat.i(55385);
            this.xxI = ss.class.getName().hashCode();
            AppMethodBeat.o(55385);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(55386);
            ss ssVar = (ss) bVar;
            if (ssVar.cOR.cOS.equals(kn.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    f.this.oPB.dgW();
                } else {
                    f.this.oPB.bIW();
                }
            } else if (ssVar.cOR.cOS.equals(ko.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    f.this.oPC.dgW();
                } else {
                    f.this.oPC.bIW();
                }
            } else if (ssVar.cOR.cOS.equals(jb.class.getName())) {
                if (ssVar.cOR.czE == 1) {
                    f.this.oPD.axy();
                } else {
                    f.this.oPD.unregister();
                }
            }
            AppMethodBeat.o(55386);
            return false;
        }
    };
    private c oPA = new c<jg>() {
        {
            AppMethodBeat.i(55377);
            this.xxI = jg.class.getName().hashCode();
            AppMethodBeat.o(55377);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(55378);
            jg jgVar = (jg) bVar;
            switch (jgVar.cEu.czE) {
                case 1:
                    b.cK(jgVar.cEu.cEw, jgVar.cEu.cEx);
                    break;
                case 2:
                    b.zY(jgVar.cEu.cEx);
                    break;
                case 3:
                    jgVar.cEv.cvi = b.bUU();
                    break;
                case 4:
                    b.bUV();
                    break;
                case 5:
                    b.bUW();
                    break;
                case 6:
                    b.TA(jgVar.cEu.cEw);
                    break;
                case 7:
                    boolean z;
                    jg.b bVar2 = jgVar.cEv;
                    Long l = (Long) g.RP().Ry().get(8210, null);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null) {
                        z = true;
                    } else if (currentTimeMillis > l.longValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar2.cvi = z;
                    break;
                default:
                    ab.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            AppMethodBeat.o(55378);
            return false;
        }
    };
    com.tencent.mm.pluginsdk.c.c<kn> oPB = new com.tencent.mm.pluginsdk.c.c<kn>() {
        public final /* synthetic */ b a(int i, m mVar, b bVar) {
            AppMethodBeat.i(55380);
            kn knVar = (kn) bVar;
            c cVar = (c) mVar;
            knVar.cGl.cGr = cVar.bUX();
            knVar.cGl.cGt = cVar.bUY();
            knVar.cGl.cGs = cVar.bUZ();
            knVar.cGl.czE = knVar.cGk.czE;
            AppMethodBeat.o(55380);
            return knVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(55381);
            kn knVar = (kn) bVar;
            if (knVar.cGk.cFT) {
                com.tencent.mm.pluginsdk.c.c.k(knVar);
                AppMethodBeat.o(55381);
            } else {
                l(knVar);
                AppMethodBeat.o(55381);
            }
            return false;
        }

        public final /* synthetic */ m b(b bVar) {
            AppMethodBeat.i(55379);
            kn knVar = (kn) bVar;
            c cVar = new c(knVar.cGk.czE, knVar.cGk.cGm, knVar.cGk.cEB, knVar.cGk.cGn, knVar.cGk.cGo, knVar.cGk.cGp, knVar.cGk.cGq);
            AppMethodBeat.o(55379);
            return cVar;
        }

        public final int Jy() {
            return 148;
        }
    };
    com.tencent.mm.pluginsdk.c.c<ko> oPC = new com.tencent.mm.pluginsdk.c.c<ko>() {
        public final /* synthetic */ b a(int i, m mVar, b bVar) {
            AppMethodBeat.i(55383);
            ko koVar = (ko) bVar;
            e eVar = (e) mVar;
            koVar.cGv.cEX = ((ayd) eVar.ehh.fsH.fsP).ehB;
            ko.b bVar2 = koVar.cGv;
            LinkedList linkedList = ((ayd) eVar.ehh.fsH.fsP).vEh;
            if (linkedList != null) {
                g.RN().QU();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ayb ayb = (ayb) it.next();
                    a.ask().Yn().ia(ayb.jBB, ayb.wlF);
                }
            }
            bVar2.cGh = linkedList;
            AppMethodBeat.o(55383);
            return koVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(55384);
            ko koVar = (ko) bVar;
            if (koVar.cGu.cFT) {
                com.tencent.mm.pluginsdk.c.c.k(koVar);
                AppMethodBeat.o(55384);
            } else {
                l(koVar);
                AppMethodBeat.o(55384);
            }
            return false;
        }

        public final /* synthetic */ m b(b bVar) {
            AppMethodBeat.i(55382);
            e eVar = new e(((ko) bVar).cGu.cEw);
            AppMethodBeat.o(55382);
            return eVar;
        }

        public final int Jy() {
            return 377;
        }
    };
    d oPD = new d() {
        public final b NJ(String str) {
            AppMethodBeat.i(55387);
            jb jbVar = new jb();
            jbVar.cEi.ctq = str;
            AppMethodBeat.o(55387);
            return jbVar;
        }

        public final k bCU() {
            AppMethodBeat.i(55388);
            g.RN().QU();
            k kVar = (k) ((j) g.K(j.class)).bOo();
            AppMethodBeat.o(55388);
            return kVar;
        }
    };
    private bd.a oPE = new bd.a() {
        public final void a(bd bdVar, ad adVar) {
            AppMethodBeat.i(55389);
            if (!(bdVar == null || adVar == null || !adVar.Oa())) {
                g.RN().QU();
                ((j) g.K(j.class)).bOo().QU(adVar.field_username);
            }
            AppMethodBeat.o(55389);
        }
    };
    private c<mp> oPF = new c<mp>() {
        {
            AppMethodBeat.i(55390);
            this.xxI = mp.class.getName().hashCode();
            AppMethodBeat.o(55390);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(55392);
            boolean aiv = AnonymousClass8.aiv();
            AppMethodBeat.o(55392);
            return aiv;
        }

        private static boolean aiv() {
            AppMethodBeat.i(55391);
            f.bVa();
            AppMethodBeat.o(55391);
            return false;
        }
    };
    private c<kf> oPG = new c<kf>() {
        {
            AppMethodBeat.i(55393);
            this.xxI = kf.class.getName().hashCode();
            AppMethodBeat.o(55393);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(55395);
            boolean bVb = AnonymousClass9.bVb();
            AppMethodBeat.o(55395);
            return bVb;
        }

        private static boolean bVb() {
            AppMethodBeat.i(55394);
            f.bVa();
            AppMethodBeat.o(55394);
            return false;
        }
    };
    private c oPz = new c<jf>() {
        {
            AppMethodBeat.i(55374);
            this.xxI = jf.class.getName().hashCode();
            AppMethodBeat.o(55374);
        }

        private static boolean a(jf jfVar) {
            int i = 3;
            AppMethodBeat.i(55375);
            bf.b bVar = jfVar.cEs.cEt;
            bi biVar = jfVar.cEs.csG;
            if (bVar.fmx != null && bVar.scene == 1) {
                g.RP().Ry().set(73729, Integer.valueOf(1));
                com.tencent.mm.storage.bf bfVar = new com.tencent.mm.storage.bf();
                bfVar.field_content = biVar.field_content;
                bfVar.field_createtime = bo.anT();
                bfVar.field_imgpath = "";
                bfVar.field_sayhicontent = ah.getContext().getString(R.string.d5f);
                bfVar.field_sayhiuser = biVar.field_talker;
                bfVar.field_scene = 18;
                if (biVar.field_status > 3) {
                    i = biVar.field_status;
                }
                bfVar.field_status = i;
                bfVar.field_svrid = biVar.field_msgSvrId;
                bfVar.field_talker = biVar.field_talker;
                bfVar.field_type = 34;
                bfVar.field_isSend = 0;
                bfVar.field_sayhiencryptuser = biVar.field_talker;
                bfVar.field_ticket = bVar.fmx;
                g.RN().QU();
                ((bg) ((j) g.K(j.class)).bOo()).a(bfVar);
                je jeVar = new je();
                jeVar.cEq.cEr = biVar.field_talker;
                com.tencent.mm.sdk.b.a.xxA.m(jeVar);
            }
            AppMethodBeat.o(55375);
            return false;
        }
    };

    public f() {
        AppMethodBeat.i(55396);
        AppMethodBeat.o(55396);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(55397);
        ((j) g.K(j.class)).XM().b(this.oPE);
        this.oPG.dnU();
        this.oPF.dead();
        com.tencent.mm.sdk.b.a.xxA.d(this.oPA);
        com.tencent.mm.sdk.b.a.xxA.d(this.egQ);
        com.tencent.mm.sdk.b.a.xxA.d(this.oPB);
        com.tencent.mm.sdk.b.a.xxA.d(this.oPC);
        this.oPz.dead();
        AppMethodBeat.o(55397);
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(55398);
        ((j) g.K(j.class)).XM().a(this.oPE);
        this.oPG.dnU();
        this.oPF.dnU();
        com.tencent.mm.sdk.b.a.xxA.c(this.egQ);
        com.tencent.mm.sdk.b.a.xxA.c(this.oPA);
        com.tencent.mm.sdk.b.a.xxA.c(this.oPB);
        com.tencent.mm.sdk.b.a.xxA.c(this.oPC);
        this.oPz.dnU();
        AppMethodBeat.o(55398);
    }

    public final void bA(boolean z) {
    }

    static /* synthetic */ void bVa() {
        AppMethodBeat.i(55399);
        if (((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).xj("labs_nearbylife")) {
            int i = com.tencent.mm.m.g.Nu().getInt("LifeAppLatestVersionValue", 0);
            ab.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload lifeAroundLatestVersion %d lastRequestLifeAroundVersion %d", Integer.valueOf(i), Integer.valueOf(g.RP().Ry().getInt(ac.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, 0)));
            if (i > g.RP().Ry().getInt(ac.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, 0)) {
                int i2 = com.tencent.mm.m.g.Nu().getInt("LifeAppPrefetchTimeThreshold", 259200);
                ab.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload lastRequestLifeAroundTime %d lifeAroundPreloadInterval %d", Long.valueOf(g.RP().Ry().a(ac.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, 0)), Integer.valueOf(i2));
                if (System.currentTimeMillis() - g.RP().Ry().a(ac.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, 0) > ((long) i2) * 1000) {
                    try {
                        ab.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload");
                        g.RP().Ry().set(ac.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, Integer.valueOf(i));
                        g.RP().Ry().set(ac.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        ((com.tencent.mm.plugin.appbrand.service.h) g.K(com.tencent.mm.plugin.appbrand.service.h.class)).xO(((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).agP("labs_nearbylife"));
                        e.pXa.a(863, 30, 1, false);
                        AppMethodBeat.o(55399);
                        return;
                    } catch (Exception e) {
                    }
                }
            }
            AppMethodBeat.o(55399);
            return;
        }
        ab.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload welab not open");
        AppMethodBeat.o(55399);
    }
}
