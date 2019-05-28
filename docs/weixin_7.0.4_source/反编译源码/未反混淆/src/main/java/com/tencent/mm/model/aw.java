package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.t;
import com.tencent.mm.aj.o;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.model.b.d;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.m;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.y;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import junit.framework.Assert;

public final class aw {
    private static aw flB = null;
    private static final bw flD = new bw();
    private final am flA;
    private g flC = null;
    private final int flE = 1;
    final com.tencent.mm.model.c.a flF;
    private ca flG = new ca();
    private bs flH = new bs();
    private e flI = new e();
    private cd flJ = new cd();
    private w flK = new w();
    private com.tencent.mm.storage.bd.a flL = new com.tencent.mm.storage.bd.a() {
        public final void a(bd bdVar, ad adVar) {
            AppMethodBeat.i(16279);
            String str = adVar.field_username;
            if (ad.mR(adVar.field_username)) {
                adVar.setUsername(ad.aoC(adVar.field_username));
            }
            if (bo.isNullOrNil(adVar.Ht())) {
                adVar.iC(com.tencent.mm.platformtools.g.vp(adVar.field_nickname));
            }
            if (bo.isNullOrNil(adVar.Hu())) {
                adVar.iD(com.tencent.mm.platformtools.g.vo(adVar.field_nickname));
            }
            if (bo.isNullOrNil(adVar.field_conRemarkPYShort)) {
                adVar.iG(com.tencent.mm.platformtools.g.vp(adVar.field_conRemark));
            }
            if (bo.isNullOrNil(adVar.field_conRemarkPYFull)) {
                adVar.iF(com.tencent.mm.platformtools.g.vo(adVar.field_conRemark));
            }
            if (t.e(adVar)) {
                adVar.hu(43);
                adVar.iC(com.tencent.mm.platformtools.g.vp(adVar.Oi()));
                adVar.iD(com.tencent.mm.platformtools.g.vo(adVar.Oi()));
                adVar.iF(com.tencent.mm.platformtools.g.vo(adVar.Oj()));
                adVar.iG(adVar.Oj());
                AppMethodBeat.o(16279);
                return;
            }
            if (t.nI(str)) {
                ad adVar2;
                adVar.NB();
                adVar.hz(4);
                adVar.hu(33);
                if (adVar == null) {
                    adVar2 = new ad();
                } else {
                    adVar2 = adVar;
                }
                adVar2.setUsername(str);
                adVar2.NB();
                ab.y(adVar2);
                adVar2.NK();
            }
            if (adVar.Oc()) {
                adVar.hu(adVar.Ny());
            }
            if (t.ny(str)) {
                ab.i("MicroMsg.MMCore", "update official account helper showhead %d", Integer.valueOf(31));
                adVar.hu(31);
            }
            if (adVar.Oa()) {
                aw.ZK();
                c.XR().c(new String[]{str}, "@blacklist");
            }
            ab.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", adVar.field_username, adVar.Ht());
            AppMethodBeat.o(16279);
        }
    };
    private com.tencent.mm.storage.be.a flM = new com.tencent.mm.storage.be.a() {
        public final void a(ak akVar, be beVar) {
            AppMethodBeat.i(16280);
            if (akVar == null) {
                AppMethodBeat.o(16280);
            } else if (!ad.aou(akVar.field_username) && !ad.aow(akVar.field_username) && !ad.mR(akVar.field_username) && !t.mZ(akVar.field_username) && !ad.aox(akVar.field_username)) {
                AppMethodBeat.o(16280);
            } else if (ad.mR(akVar.field_username)) {
                int i;
                ak akVar2;
                ak aoZ = beVar.aoZ("floatbottle");
                if (aoZ == null) {
                    i = 1;
                    akVar2 = new ak("floatbottle");
                } else {
                    boolean i2 = false;
                    akVar2 = aoZ;
                }
                akVar2.hN(1);
                akVar2.hM(l.Yv());
                aw.ZK();
                bi Rd = c.XO().Rd(" and not ( type = 10000 and isSend != 2 ) ");
                if (Rd == null || Rd.field_msgId <= 0) {
                    akVar2.dsI();
                } else {
                    akVar2.ap(Rd);
                    akVar2.setContent(ad.aoC(Rd.field_talker) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rd.field_content);
                    akVar2.jg(Integer.toString(Rd.getType()));
                    b Cb = beVar.Cb();
                    if (Cb != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Rd.ju("floatbottle");
                        Rd.setContent(akVar2.field_content);
                        Cb.a(Rd, pString, pString2, pInt, false);
                        akVar2.jh(pString.value);
                        akVar2.ji(pString2.value);
                        akVar2.hP(pInt.value);
                    }
                }
                if (i2 != 0) {
                    beVar.d(akVar2);
                    AppMethodBeat.o(16280);
                    return;
                }
                beVar.a(akVar2, akVar2.field_username);
                AppMethodBeat.o(16280);
            } else if (ad.aou(akVar.field_username) || ad.aow(akVar.field_username)) {
                AppMethodBeat.o(16280);
            } else {
                com.tencent.mm.kernel.g.K(o.class);
                p.b(akVar, beVar);
                if ("@blacklist".equals(akVar.field_parentRef)) {
                    aw.ZK();
                    ad aoO = c.XM().aoO(akVar.field_username);
                    if (!(aoO == null || bo.isNullOrNil(aoO.field_username) || aoO.Oa())) {
                        aw.ZK();
                        c.XR().c(new String[]{akVar.field_username}, "");
                    }
                }
                AppMethodBeat.o(16280);
            }
        }
    };
    private com.tencent.mm.storage.be.a flN = new com.tencent.mm.storage.be.a() {
        public final void a(ak akVar, be beVar) {
            if (akVar == null) {
            }
        }
    };
    private f flO = new f();
    private final c flr;

    class a implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, c, e, com.tencent.mm.kernel.c.a {
        a() {
        }

        public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
            AppMethodBeat.i(16281);
            if (cVar.eKe) {
                com.tencent.mm.x.c.PK().x(262145, false);
            }
            h.pYm.a(598, 13, 1, false);
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", Long.valueOf(Thread.currentThread().getId()));
            c a = aw.this.flr;
            com.tencent.mm.cd.h hVar = com.tencent.mm.kernel.g.RP().eJN;
            com.tencent.mm.kernel.g.RP();
            com.tencent.mm.plugin.messenger.foundation.a.a.h bOr = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr();
            bOr.a(new au(bOr));
            com.tencent.mm.storage.e hVar2 = new com.tencent.mm.storage.h(bOr);
            a.fkf = hVar2;
            bOr.a(hVar2);
            a.fkd = new br(hVar, ((j) com.tencent.mm.kernel.g.K(j.class)).XR());
            a.fke = new bq(hVar, ((j) com.tencent.mm.kernel.g.K(j.class)).XM());
            a.fkg = new com.tencent.mm.model.b.c();
            a.fkh = new d();
            a.fkl = new com.tencent.mm.model.b.b();
            a.fki = new com.tencent.mm.storage.j(hVar);
            a.fkj = new n(hVar);
            a.fkk = new l(hVar);
            h.pYm.a(598, 14, 1, false);
            ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            com.tencent.mm.model.c.a aVar = aw.this.flF;
            aw.this.flr;
            aVar.cx(cVar.eKe);
            h.pYm.a(598, 15, 1, false);
            ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            f.Mn();
            h.pYm.a(598, 16, 1, false);
            ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(16281);
        }

        public void onAccountRelease() {
        }

        public void parallelsDependency() {
            AppMethodBeat.i(16282);
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class));
            AppMethodBeat.o(16282);
        }

        public void onDataBaseOpened(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
            AppMethodBeat.i(16283);
            aw.this.flr;
            AppMethodBeat.o(16283);
        }

        public void onDataBaseClosed(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
        }

        public HashMap<Integer, com.tencent.mm.cd.h.d> collectDatabaseFactory() {
            AppMethodBeat.i(16284);
            ab.i("MicroMsg.MMCore", "collectDatabaseFactory ");
            HashMap hashMap = new HashMap();
            hashMap.putAll(c.eaA);
            AppMethodBeat.o(16284);
            return hashMap;
        }
    }

    static /* synthetic */ aw ZO() {
        AppMethodBeat.i(16313);
        aw ZH = ZH();
        AppMethodBeat.o(16313);
        return ZH;
    }

    static {
        AppMethodBeat.i(16314);
        AppMethodBeat.o(16314);
    }

    public static boolean ZD() {
        return flB == null;
    }

    public static void a(com.tencent.mm.network.n nVar) {
        AppMethodBeat.i(16285);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().a(nVar);
        AppMethodBeat.o(16285);
    }

    public static void b(com.tencent.mm.network.n nVar) {
        AppMethodBeat.i(16286);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().b(nVar);
        AppMethodBeat.o(16286);
    }

    public static void a(al alVar) {
        AppMethodBeat.i(16287);
        com.tencent.mm.kernel.b.a(alVar);
        AppMethodBeat.o(16287);
    }

    public static void lE(String str) {
        AppMethodBeat.i(16288);
        com.tencent.mm.kernel.a.lE(str);
        AppMethodBeat.o(16288);
    }

    public static bw ZE() {
        AppMethodBeat.i(16289);
        ZH();
        bw bwVar = flD;
        AppMethodBeat.o(16289);
        return bwVar;
    }

    public static boolean ZF() {
        AppMethodBeat.i(16290);
        boolean QS = com.tencent.mm.kernel.a.QS();
        AppMethodBeat.o(16290);
        return QS;
    }

    public static void ZG() {
        AppMethodBeat.i(16291);
        com.tencent.mm.kernel.a.cm(false);
        AppMethodBeat.o(16291);
    }

    public static void a(am amVar, com.tencent.mm.ai.p.a aVar) {
        AppMethodBeat.i(16292);
        flB = new aw(amVar, aVar);
        com.tencent.mm.modelstat.o.ce(ah.getContext());
        AppMethodBeat.o(16292);
    }

    public static an getNotification() {
        AppMethodBeat.i(16293);
        an notification = ZH().flA.getNotification();
        AppMethodBeat.o(16293);
        return notification;
    }

    public static ae Cc() {
        AppMethodBeat.i(16294);
        ae Cc = ZH().flA.Cc();
        AppMethodBeat.o(16294);
        return Cc;
    }

    private aw(am amVar, com.tencent.mm.ai.p.a aVar) {
        AppMethodBeat.i(16295);
        this.flA = amVar;
        this.flF = new com.tencent.mm.model.c.a() {
            public final void cx(boolean z) {
                ad aoO;
                AppMethodBeat.i(16276);
                ab.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", Long.valueOf(Thread.currentThread().getId()), bo.dpG());
                aw.b(aw.this);
                long currentTimeMillis = System.currentTimeMillis();
                aw.ZK();
                long iV = c.Ru().iV(Thread.currentThread().getId());
                aw.this.flr;
                if (z) {
                    ab.i("MicroMsg.MMCore", "[doAccountPostReset] updated is true");
                    c.XM().aoU("readerapp");
                    c.Ry().set(256, Boolean.TRUE);
                    ab.i("MicroMsg.MMCore", "[doAccountPostReset] begin to updated HardCodeUpdate");
                    ab.i("MicroMsg.HardCodeUpdateTask", "[updateHelperIndexFor50] size:%s", Integer.valueOf(t.Zm().size()));
                    for (ad aoO2 : r0) {
                        if (!(aoO2 == null || ((int) aoO2.ewQ) == 0 || aoO2.field_showHead != 32)) {
                            aoO2.hu(aoO2.Ny());
                            ab.d("MicroMsg.HardCodeUpdateTask", "contact to updatefavour " + aoO2.field_username);
                            aw.ZK();
                            c.XM().b(aoO2.field_username, aoO2);
                        }
                    }
                    for (String str : t.fkY) {
                        ad aoO3 = c.XM().aoO(str);
                        if (aoO3 != null && (((int) aoO3.ewQ) != 0 || com.tencent.mm.n.a.jh(aoO3.field_type))) {
                            aoO3.NK();
                            c.XM().b(str, aoO3);
                        }
                    }
                    ac.Zr();
                    bh.oG("ver" + com.tencent.mm.protocal.d.vxo);
                }
                ab abVar = new ab(aw.this.flr);
                if (z) {
                    ad aoO4;
                    ab.x(c.XM().aoO("filehelper"));
                    String Yz = r.Yz();
                    if (!bo.isNullOrNil(Yz)) {
                        aoO4 = c.XM().aoO(Yz);
                        if (((int) aoO4.ewQ) == 0) {
                            aoO4.setUsername(Yz);
                            aoO4.NB();
                            aw.ZK();
                            c.XM().Z(aoO4);
                        } else if (!com.tencent.mm.n.a.jh(aoO4.field_type)) {
                            aoO4.NB();
                            aw.ZK();
                            c.XM().b(Yz, aoO4);
                        }
                    }
                    ab.a(z, "qqmail", false);
                    ab.a(z, "floatbottle", false);
                    ab.a(z, "shakeapp", false);
                    ab.a(z, "lbsapp", false);
                    ab.a(z, "medianote", false);
                    ab.a(z, "newsapp", true);
                    c.XR().aoX("blogapp");
                    c.XO().Rh("blogapp");
                    c.XM().aoU("blogapp");
                    ab.a(z, "facebookapp", true);
                    ab.a(z, "qqfriend", false);
                    ab.a(z, "masssendapp", true);
                    ab.a(z, "feedsapp", true);
                    c.XR().aoX("tmessage");
                    c.XM().aoU("tmessage");
                    aoO4 = c.XM().aoO("voip");
                    aoO2 = c.XM().aoO("voipapp");
                    if (aoO2 == null) {
                        aoO2 = new ad();
                    }
                    if (!(aoO4 == null || ((int) aoO4.ewQ) == 0)) {
                        c.XM().aoU("voip");
                    }
                    if (((int) aoO2.ewQ) == 0) {
                        aoO2.setUsername("voipapp");
                        aoO2.NB();
                        ab.y(aoO2);
                        aoO2.hz(4);
                        aoO2.NK();
                        c.XM().aa(aoO2);
                    } else if (z) {
                        aoO2.NK();
                        c.XM().b("voipapp", aoO2);
                    }
                    aoO2 = c.XM().aoO("officialaccounts");
                    if (aoO2 == null) {
                        aoO2 = new ad();
                    }
                    ab.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) aoO2.ewQ));
                    if (((int) aoO2.ewQ) == 0) {
                        aoO2.setUsername("officialaccounts");
                        aoO2.NC();
                        ab.y(aoO2);
                        aoO2.hz(3);
                        c.XM().aa(aoO2);
                    } else if (z) {
                        ab.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        aoO2.NC();
                        c.XM().b("officialaccounts", aoO2);
                    }
                    aoO4 = c.XM().aoO("voipaudio");
                    aoO2 = c.XM().aoO("voicevoipapp");
                    if (aoO2 == null) {
                        aoO2 = new ad();
                    }
                    if (!(aoO4 == null || ((int) aoO4.ewQ) == 0)) {
                        c.XM().aoU("voipaudio");
                    }
                    if (((int) aoO2.ewQ) == 0) {
                        aoO2.setUsername("voicevoipapp");
                        aoO2.NB();
                        ab.y(aoO2);
                        aoO2.hz(4);
                        aoO2.NK();
                        c.XM().aa(aoO2);
                    } else if (z) {
                        aoO2.NK();
                        c.XM().b("voicevoipapp", aoO2);
                    }
                    ab.a(z, "voiceinputapp", false);
                    ab.a(z, "linkedinplugin", false);
                    aoO2 = c.XM().aoO("notifymessage");
                    if (aoO2 == null) {
                        aoO2 = new ad();
                    }
                    ab.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) aoO2.ewQ));
                    if (((int) aoO2.ewQ) == 0) {
                        aoO2.setUsername("notifymessage");
                        aoO2.NC();
                        ab.y(aoO2);
                        aoO2.hz(3);
                        c.XM().aa(aoO2);
                    } else if (z) {
                        ab.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        aoO2.NC();
                        c.XM().b("notifymessage", aoO2);
                    }
                    aoO2 = c.XM().aoO("appbrandcustomerservicemsg");
                    if (aoO2 == null) {
                        aoO2 = new ad();
                    }
                    ab.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", Boolean.valueOf(z), Integer.valueOf((int) aoO2.ewQ));
                    if (((int) aoO2.ewQ) == 0) {
                        aoO2.setUsername("appbrandcustomerservicemsg");
                        aoO2.NC();
                        ab.y(aoO2);
                        aoO2.setType(0);
                        aoO2.hz(3);
                        c.XM().aa(aoO2);
                    } else if (z) {
                        ab.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        aoO2.NC();
                        c.XM().b("appbrandcustomerservicemsg", aoO2);
                    }
                    ab.a(z, "downloaderapp", true);
                    if (z) {
                        aw.ZK();
                        c.XR().aoX("Weixin");
                        aw.ZK();
                        c.XM().aoU("Weixin");
                    }
                }
                aw.ZK();
                c.Ru().mB(iV);
                ab.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bo.dpG());
                aw.this.flr;
                c.XR().a(aw.ZO().flA.Cb());
                AppMethodBeat.o(16276);
            }
        };
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.a(a.class, new a());
        com.tencent.mm.kernel.g.RQ().eKp.aD(aVar);
        this.flr = new c();
        h.pYm.a(99, 142, 1, false);
        t.a(new com.tencent.mm.plugin.zero.a.e() {
            public final byte[] a(com.tencent.mm.protocal.l.d dVar, int i) {
                AppMethodBeat.i(16277);
                byte[] toByteArray;
                switch (i) {
                    case 107:
                        toByteArray = ((com.tencent.mm.plugin.account.friend.a.u.a) dVar).gvK.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 145:
                        toByteArray = ((com.tencent.mm.protocal.n.a) dVar).vyq.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case v2helper.EMethodSetIosMicAbCheckOff /*429*/:
                        toByteArray = ((com.tencent.mm.plugin.account.friend.a.t.a) dVar).gvI.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case m.CTRL_INDEX /*481*/:
                        toByteArray = ((com.tencent.mm.plugin.account.friend.a.r.a) dVar).gvF.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case com.tencent.mm.plugin.appbrand.jsapi.storage.j.CTRL_INDEX /*499*/:
                        toByteArray = ((com.tencent.mm.plugin.report.b.c.a) dVar).pXm.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 572:
                        toByteArray = ((com.tencent.mm.plugin.account.friend.a.s.a) dVar).gvH.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case com.tencent.mm.plugin.appbrand.jsapi.bd.CTRL_INDEX /*616*/:
                        toByteArray = ((com.tencent.mm.model.ba.a) dVar).flW.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case com.tencent.mm.plugin.appbrand.jsapi.be.CTRL_INDEX /*617*/:
                        toByteArray = ((com.tencent.mm.model.bc.a) dVar).fma.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case bb.CTRL_INDEX /*618*/:
                        toByteArray = ((com.tencent.mm.model.bb.a) dVar).flY.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 694:
                        toByteArray = ((com.tencent.mm.plugin.report.b.b.a) dVar).pXm.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 722:
                        toByteArray = ((com.tencent.mm.protocal.q.a) dVar).vyy.wej.vLz.getBuffer().toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 987:
                    case TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR /*997*/:
                        toByteArray = ((sk) ((com.tencent.mm.ai.b.b) dVar).fsP).vZK.toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 989:
                        toByteArray = ((ahi) ((com.tencent.mm.ai.b.b) dVar).fsP).vZK.toByteArray();
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    case 1000:
                        toByteArray = ((com.tencent.mm.protocal.k.a) dVar).vxZ;
                        AppMethodBeat.o(16277);
                        return toByteArray;
                    default:
                        AppMethodBeat.o(16277);
                        return null;
                }
            }
        });
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        RO.eJn.aD(new com.tencent.mm.kernel.api.d() {
            public final void b(com.tencent.mm.network.e eVar) {
                AppMethodBeat.i(16278);
                q.e(eVar);
                q.f(eVar);
                AppMethodBeat.o(16278);
            }
        });
        AppMethodBeat.o(16295);
    }

    private static aw ZH() {
        AppMethodBeat.i(16296);
        Assert.assertNotNull("MMCore not initialized by MMApplication", flB);
        aw awVar = flB;
        AppMethodBeat.o(16296);
        return awVar;
    }

    public static y ZI() {
        AppMethodBeat.i(16297);
        com.tencent.mm.kernel.g.RQ();
        y yVar = com.tencent.mm.kernel.g.RP().eJH;
        AppMethodBeat.o(16297);
        return yVar;
    }

    @Deprecated
    public static al RS() {
        AppMethodBeat.i(16298);
        al RS = com.tencent.mm.kernel.g.RS();
        AppMethodBeat.o(16298);
        return RS;
    }

    public static bz getSysCmdMsgExtension() {
        AppMethodBeat.i(16299);
        bz sysCmdMsgExtension = ((com.tencent.mm.plugin.messenger.foundation.a.p) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension();
        AppMethodBeat.o(16299);
        return sysCmdMsgExtension;
    }

    public static String Rb() {
        AppMethodBeat.i(16300);
        String Rb = com.tencent.mm.kernel.a.Rb();
        AppMethodBeat.o(16300);
        return Rb;
    }

    public static void ZJ() {
        AppMethodBeat.i(16301);
        com.tencent.mm.sdk.b.a.xxA.m(new aa());
        AppMethodBeat.o(16301);
    }

    public static c ZK() {
        AppMethodBeat.i(16302);
        c cVar = ZH().flr;
        Assert.assertTrue("MMCore has not been initialize ?", cVar != null);
        AppMethodBeat.o(16302);
        return cVar;
    }

    public static com.tencent.mm.ai.p Rg() {
        AppMethodBeat.i(16303);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.ai.p pVar = com.tencent.mm.kernel.g.RO().eJo;
        AppMethodBeat.o(16303);
        return pVar;
    }

    public static g ZL() {
        AppMethodBeat.i(16304);
        g KK = g.KK();
        AppMethodBeat.o(16304);
        return KK;
    }

    public static boolean ZM() {
        AppMethodBeat.i(16305);
        com.tencent.mm.kernel.g.RN();
        boolean QX = com.tencent.mm.kernel.a.QX();
        AppMethodBeat.o(16305);
        return QX;
    }

    public static boolean RK() {
        AppMethodBeat.i(16306);
        if (ah.bqo()) {
            boolean RK = com.tencent.mm.kernel.g.RK();
            AppMethodBeat.o(16306);
            return RK;
        }
        AppMethodBeat.o(16306);
        return false;
    }

    public static boolean QT() {
        AppMethodBeat.i(16307);
        boolean QT = com.tencent.mm.kernel.a.QT();
        AppMethodBeat.o(16307);
        return QT;
    }

    public static void hold() {
        AppMethodBeat.i(16308);
        com.tencent.mm.kernel.a.hold();
        AppMethodBeat.o(16308);
    }

    public static void unhold() {
        AppMethodBeat.i(16309);
        com.tencent.mm.kernel.a.unhold();
        AppMethodBeat.o(16309);
    }

    public static String QH() {
        AppMethodBeat.i(16310);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RN();
        String QH = com.tencent.mm.kernel.a.QH();
        AppMethodBeat.o(16310);
        return QH;
    }

    public static f ZN() {
        AppMethodBeat.i(16311);
        f fVar = ZH().flO;
        AppMethodBeat.o(16311);
        return fVar;
    }
}
