package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.g;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.i;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.m.a;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.e;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map;

public class z implements at {
    private static HashMap<Integer, d> eaA;
    private static long fwQ = 0;
    private e flI = new e();
    private e fwR;
    private a fwS = null;
    private k fwT = null;
    private i fwU;
    private h fwV = null;
    private com.tencent.mm.aj.a.d fwW = null;
    private b fwX = null;
    private k fwY = null;
    private g fwZ = null;
    private i fxa = null;
    private h fxb = null;
    private c fxc = null;
    private r fxd = null;
    private t fxe = null;
    private a fxf;
    private bz.a fxg = new bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(11465);
            cm cmVar = aVar.eAB;
            if (cmVar == null) {
                ab.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
                AppMethodBeat.o(11465);
                return;
            }
            String a = aa.a(cmVar.vED);
            if (bo.isNullOrNil(a)) {
                ab.e("MicroMsg.SubCoreBiz", "msg content is null");
                AppMethodBeat.o(11465);
                return;
            }
            Map z = br.z(a, "sysmsg");
            if (z == null || z.size() <= 0) {
                ab.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
                AppMethodBeat.o(11465);
                return;
            }
            if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
                ab.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", Integer.valueOf(bo.getInt((String) z.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0)));
                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, Integer.valueOf(r0));
                com.tencent.mm.kernel.g.RP().Ry().dsb();
                AppMethodBeat.o(11465);
                return;
            }
            ab.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
            AppMethodBeat.o(11465);
        }
    };
    private be.a fxh = new be.a() {
        public final void a(ak akVar, be beVar) {
            AppMethodBeat.i(11466);
            if (!(akVar == null || bo.isNullOrNil(akVar.field_username))) {
                String str = akVar.field_username;
                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(str);
                if (aoO == null) {
                    AppMethodBeat.o(11466);
                    return;
                } else if (aoO.dsf() && !com.tencent.mm.model.t.nl(str)) {
                    d qP = z.aeR().qP(str);
                    if (qP.xDa == -1) {
                        ab.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                        AppMethodBeat.o(11466);
                        return;
                    } else if (qP.adQ()) {
                        if (qP.cJ(false) == null) {
                            akVar.jj(null);
                            ab.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            AppMethodBeat.o(11466);
                            return;
                        } else if (qP.cJ(false).aer() == null) {
                            akVar.jj(null);
                            ab.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            AppMethodBeat.o(11466);
                            return;
                        } else {
                            if (qP.adR()) {
                                akVar.jj(null);
                            } else {
                                akVar.jj(bo.nullAsNil(qP.adX()));
                                if (bo.isNullOrNil(qP.adX())) {
                                    ab.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", akVar.field_username);
                                    AppMethodBeat.o(11466);
                                    return;
                                }
                            }
                            AppMethodBeat.o(11466);
                            return;
                        }
                    } else if (qP.adM() || qP.adP() || com.tencent.mm.model.t.nG(str)) {
                        akVar.jj(null);
                        AppMethodBeat.o(11466);
                        return;
                    } else {
                        akVar.jj("officialaccounts");
                    }
                }
            }
            AppMethodBeat.o(11466);
        }
    };
    private e.a fxi = new e.a() {
        public final void a(e.a.b bVar) {
            AppMethodBeat.i(11464);
            if (bVar.fwk == e.a.a.INSTERT || bVar.fwk == e.a.a.UPDATE) {
                if (bVar.fwl == null) {
                    AppMethodBeat.o(11464);
                    return;
                }
                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(bVar.fuO);
                if (aoO == null) {
                    AppMethodBeat.o(11464);
                    return;
                } else if (!aoO.dsf()) {
                    z.j(bVar.fwl);
                    AppMethodBeat.o(11464);
                    return;
                } else if (com.tencent.mm.model.t.nl(aoO.field_username)) {
                    AppMethodBeat.o(11464);
                    return;
                } else {
                    ak aoZ = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoZ(bVar.fuO);
                    ab.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", bVar.fuO);
                    if (!(!bVar.fwl.adQ() || bVar.fwl.cJ(false) == null || bVar.fwl.cJ(false).aer() == null || bo.isNullOrNil(bVar.fwl.adX()) || !bo.isNullOrNil(bVar.fwl.field_enterpriseFather))) {
                        bVar.fwl.field_enterpriseFather = bVar.fwl.adX();
                        z.aeR().e(bVar.fwl);
                        ab.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", bVar.fuO, bVar.fwl.field_enterpriseFather);
                    }
                    if (aoZ == null) {
                        AppMethodBeat.o(11464);
                        return;
                    }
                    int i;
                    if (bVar.fwl.adQ()) {
                        if (bVar.fwl.cJ(false) == null) {
                            ab.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            AppMethodBeat.o(11464);
                            return;
                        } else if (bVar.fwl.cJ(false).aer() == null) {
                            ab.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            AppMethodBeat.o(11464);
                            return;
                        } else {
                            String str = aoZ.field_parentRef;
                            if (bVar.fwl.adR()) {
                                aoZ.jj(null);
                            } else {
                                ab.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bVar.fwl.adX(), bVar.fuO);
                                aoZ.jj(bo.nullAsNil(bVar.fwl.adX()));
                            }
                            if (str != null && aoZ.field_parentRef != null && !str.equals(aoZ.field_parentRef)) {
                                i = 1;
                            } else if (str == null && aoZ.field_parentRef != null) {
                                i = 1;
                            } else if (str == null || aoZ.field_parentRef != null) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            ab.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", bVar.fuO, aoZ.field_parentRef);
                        }
                    } else if (bVar.fwl.adP()) {
                        ab.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", bVar.fuO);
                        i = 1;
                    } else if (!bVar.fwl.adM() && !com.tencent.mm.model.t.nG(aoO.field_username) && !"officialaccounts".equals(aoZ.field_parentRef)) {
                        aoZ.jj("officialaccounts");
                        i = 1;
                    } else if (!bVar.fwl.adM() || aoZ.field_parentRef == null) {
                        i = 0;
                    } else {
                        aoZ.jj(null);
                        i = 1;
                    }
                    if (i != 0) {
                        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().a(aoZ, aoZ.field_username);
                        String dsR;
                        bi Rb;
                        if (bo.isNullOrNil(aoZ.field_parentRef)) {
                            AppMethodBeat.o(11464);
                            return;
                        } else if ("officialaccounts".equals(aoZ.field_parentRef)) {
                            com.tencent.mm.g.c.at aoZ2 = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoZ("officialaccounts");
                            if (aoZ2 == null) {
                                com.tencent.mm.g.c.at akVar = new ak("officialaccounts");
                                akVar.dsI();
                                ((j) com.tencent.mm.kernel.g.K(j.class)).XR().d((ak) akVar);
                                aoZ2 = akVar;
                            }
                            if (bo.isNullOrNil(aoZ2.field_content)) {
                                ab.i("MicroMsg.SubCoreBiz", "conv content is null");
                                dsR = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().dsR();
                                if (bo.isNullOrNil(dsR)) {
                                    ab.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                    AppMethodBeat.o(11464);
                                    return;
                                }
                                Rb = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Rb(dsR);
                                if (Rb == null || Rb.field_msgId == 0) {
                                    ab.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                    AppMethodBeat.o(11464);
                                    return;
                                }
                                ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(Rb.field_msgId, Rb);
                            }
                            AppMethodBeat.o(11464);
                            return;
                        } else {
                            ab.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", bVar.fuO, aoZ.field_parentRef);
                            ak aoZ3 = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoZ(aoZ.field_parentRef);
                            if (aoZ3 == null) {
                                AppMethodBeat.o(11464);
                                return;
                            } else if (bo.isNullOrNil(aoZ3.field_content)) {
                                ab.i("MicroMsg.SubCoreBiz", "conv content is null");
                                dsR = ((j) com.tencent.mm.kernel.g.K(j.class)).XR().apm(aoZ.field_parentRef);
                                if (bo.isNullOrNil(dsR)) {
                                    ab.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                    AppMethodBeat.o(11464);
                                    return;
                                }
                                Rb = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Rb(dsR);
                                if (Rb == null || Rb.field_msgId == 0) {
                                    ab.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                    AppMethodBeat.o(11464);
                                    return;
                                }
                                ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().a(Rb.field_msgId, Rb);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(11464);
        }
    };

    static {
        AppMethodBeat.i(11488);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        eaA.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return i.fnj;
            }
        });
        eaA.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.aj.a.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return k.fnj;
            }
        });
        eaA.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        eaA.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        eaA.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return c.fnj;
            }
        });
        AppMethodBeat.o(11488);
    }

    public z() {
        AppMethodBeat.i(11467);
        AppMethodBeat.o(11467);
    }

    private static synchronized z aeP() {
        z zVar;
        synchronized (z.class) {
            AppMethodBeat.i(11468);
            zVar = (z) q.Y(z.class);
            AppMethodBeat.o(11468);
        }
        return zVar;
    }

    public static i aeQ() {
        AppMethodBeat.i(11469);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwU == null) {
            aeP().fwU = new i(com.tencent.mm.kernel.g.RP().eJN);
        }
        i iVar = aeP().fwU;
        AppMethodBeat.o(11469);
        return iVar;
    }

    public static e aeR() {
        AppMethodBeat.i(11470);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwR == null) {
            aeP().fwR = new e(com.tencent.mm.kernel.g.RP().eJN);
        }
        e eVar = aeP().fwR;
        AppMethodBeat.o(11470);
        return eVar;
    }

    public static h aeS() {
        AppMethodBeat.i(11471);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwV == null) {
            aeP().fwV = new h();
            f fVar = aeP().fwV;
            com.tencent.mm.kernel.g.RO().eJo.a(675, fVar);
            com.tencent.mm.kernel.g.RO().eJo.a(672, fVar);
            com.tencent.mm.kernel.g.RO().eJo.a(674, fVar);
            synchronized (fVar.cli) {
                try {
                    fVar.fwn.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(11471);
                    }
                }
            }
        }
        h hVar = aeP().fwV;
        AppMethodBeat.o(11471);
        return hVar;
    }

    public static com.tencent.mm.aj.a.d aeT() {
        AppMethodBeat.i(11472);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwW == null) {
            aeP().fwW = new com.tencent.mm.aj.a.d(com.tencent.mm.kernel.g.RP().eJN);
        }
        com.tencent.mm.aj.a.d dVar = aeP().fwW;
        AppMethodBeat.o(11472);
        return dVar;
    }

    public static b aeU() {
        AppMethodBeat.i(11473);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwX == null) {
            aeP().fwX = new b(com.tencent.mm.kernel.g.RP().eJN);
        }
        b bVar = aeP().fwX;
        AppMethodBeat.o(11473);
        return bVar;
    }

    public static k aeV() {
        AppMethodBeat.i(11474);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwY == null) {
            aeP().fwY = new k(com.tencent.mm.kernel.g.RP().eJN);
        }
        k kVar = aeP().fwY;
        AppMethodBeat.o(11474);
        return kVar;
    }

    public static g aeW() {
        AppMethodBeat.i(11475);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwZ == null) {
            aeP().fwZ = new g(com.tencent.mm.kernel.g.RP().eJN);
        }
        g gVar = aeP().fwZ;
        AppMethodBeat.o(11475);
        return gVar;
    }

    public static r aeX() {
        AppMethodBeat.i(11476);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fxd == null) {
            aeP().fxd = new r(com.tencent.mm.kernel.g.RP().eJN);
        }
        r rVar = aeP().fxd;
        AppMethodBeat.o(11476);
        return rVar;
    }

    public static t aeY() {
        AppMethodBeat.i(11477);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fxe == null) {
            aeP().fxe = new t(com.tencent.mm.kernel.g.RP().eJN);
        }
        t tVar = aeP().fxe;
        AppMethodBeat.o(11477);
        return tVar;
    }

    public static h aeZ() {
        AppMethodBeat.i(11478);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fxb == null) {
            aeP().fxb = new h();
        }
        h hVar = aeP().fxb;
        AppMethodBeat.o(11478);
        return hVar;
    }

    public static c afa() {
        AppMethodBeat.i(11479);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fxc == null) {
            aeP().fxc = new c(com.tencent.mm.kernel.g.RP().eJN);
        }
        c cVar = aeP().fxc;
        AppMethodBeat.o(11479);
        return cVar;
    }

    public static a afb() {
        AppMethodBeat.i(11480);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwS == null) {
            aeP().fwS = new a();
        }
        a aVar = aeP().fwS;
        AppMethodBeat.o(11480);
        return aVar;
    }

    public static k afc() {
        AppMethodBeat.i(11481);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fwT == null) {
            aeP().fwT = new k();
        }
        k kVar = aeP().fwT;
        AppMethodBeat.o(11481);
        return kVar;
    }

    public static a afd() {
        AppMethodBeat.i(11482);
        if (aeP().fxf == null) {
            aeP().fxf = new a();
        }
        a aVar = aeP().fxf;
        AppMethodBeat.o(11482);
        return aVar;
    }

    public static i afe() {
        AppMethodBeat.i(11483);
        com.tencent.mm.kernel.g.RN().QU();
        if (aeP().fxa == null) {
            aeP().fxa = new i();
        }
        i iVar = aeP().fxa;
        AppMethodBeat.o(11483);
        return iVar;
    }

    public static long aff() {
        AppMethodBeat.i(11484);
        if (fwQ == 0) {
            Object obj = com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, null);
            if (obj != null && (obj instanceof Long)) {
                fwQ = ((Long) obj).longValue();
                ab.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(fwQ));
            }
        }
        if (fwQ == 0) {
            fwQ = System.currentTimeMillis();
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(fwQ));
            ab.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(fwQ));
        }
        long j = fwQ;
        AppMethodBeat.o(11484);
        return j;
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(11485);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(55), this.flI);
        com.tencent.mm.ai.e.d.a(Integer.valueOf(57), this.flI);
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().c(this.fxh);
        aeR().a(this.fxi, null);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.fxg, true);
        AppMethodBeat.o(11485);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(11486);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(55), this.flI);
        com.tencent.mm.ai.e.d.b(Integer.valueOf(57), this.flI);
        if (aeP().fwV != null) {
            f fVar = aeP().fwV;
            com.tencent.mm.kernel.g.RO().eJo.b(675, fVar);
            com.tencent.mm.kernel.g.RO().eJo.b(672, fVar);
            com.tencent.mm.kernel.g.RO().eJo.b(674, fVar);
            synchronized (fVar.cli) {
                try {
                    fVar.fwn.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(11486);
                    }
                }
            }
            fVar.fwm.clear();
        }
        if (com.tencent.mm.kernel.g.RN().QY()) {
            ((j) com.tencent.mm.kernel.g.K(j.class)).XR().d(this.fxh);
            aeR().a(this.fxi);
        }
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.fxg, true);
        AppMethodBeat.o(11486);
    }

    public final void bA(boolean z) {
    }

    static /* synthetic */ void j(d dVar) {
        AppMethodBeat.i(11487);
        if (!(!dVar.adQ() || dVar.adR() || dVar.cJ(false) == null || dVar.cJ(false).aer() == null || bo.isNullOrNil(dVar.adX()))) {
            if (((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoZ(dVar.adX()) == null) {
                ab.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoZ(dVar.field_username) == null) {
                ab.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", dVar.field_username);
                ak akVar = new ak(dVar.field_username);
                if (!dVar.adR()) {
                    ab.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", dVar.adX(), dVar.field_username);
                    akVar.jj(bo.nullAsNil(dVar.adX()));
                    akVar.dsI();
                    ((j) com.tencent.mm.kernel.g.K(j.class)).XR().d(akVar);
                }
            }
        }
        AppMethodBeat.o(11487);
    }
}
