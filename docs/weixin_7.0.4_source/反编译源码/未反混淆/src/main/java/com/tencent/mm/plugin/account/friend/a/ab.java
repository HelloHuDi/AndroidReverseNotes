package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab extends m implements k {
    public b ehh;
    private f ehi = null;
    private List<String> gsD;
    private List<String> gwb;

    public ab() {
        AppMethodBeat.i(108444);
        aqf();
        akp akp = (akp) this.ehh.fsG.fsP;
        akp.wdO = "";
        akp.wqj = null;
        akp.wqi = 0;
        akp.wqh = null;
        akp.wqg = 0;
        akp.nbk = 0;
        akp.Scene = 1;
        AppMethodBeat.o(108444);
    }

    public ab(List<String> list, List<String> list2) {
        AppMethodBeat.i(108445);
        aqf();
        if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
            AppMethodBeat.o(108445);
            return;
        }
        this.gsD = list;
        this.gwb = list2;
        akp akp = (akp) this.ehh.fsG.fsP;
        akp.wdO = "";
        akp.nbk = 2;
        akp.Scene = 1;
        AppMethodBeat.o(108445);
    }

    private void aqf() {
        AppMethodBeat.i(108446);
        a aVar = new a();
        aVar.fsJ = new akp();
        aVar.fsK = new akq();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_3;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(108446);
    }

    public final void aqg() {
        AppMethodBeat.i(108447);
        akp akp = (akp) this.ehh.fsG.fsP;
        akp.wdO = (String) g.RP().Ry().get(65828, null);
        akp.nbk = 1;
        AppMethodBeat.o(108447);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108448);
        this.ehi = fVar;
        akp akp = (akp) this.ehh.fsG.fsP;
        if (akp.nbk == 2) {
            if ((this.gsD == null || this.gsD.size() == 0) && (this.gwb == null || this.gwb.size() == 0)) {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                AppMethodBeat.o(108448);
                return -1;
            }
            LinkedList linkedList;
            if (this.gsD != null && this.gsD.size() > 0) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.gsD.size()));
                linkedList = new LinkedList();
                for (String str : this.gsD) {
                    bbl bbl = new bbl();
                    bbl.v = str;
                    linkedList.add(bbl);
                }
                akp.wqh = linkedList;
                akp.wqg = linkedList.size();
            }
            if (this.gwb != null && this.gwb.size() > 0) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.gwb.size()));
                linkedList = new LinkedList();
                for (String str2 : this.gwb) {
                    azc azc = new azc();
                    azc.v = str2;
                    linkedList.add(azc);
                }
                akp.wqj = linkedList;
                akp.wqi = linkedList.size();
            }
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108448);
        return a;
    }

    public final int getType() {
        return 32;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108449);
        akq akq = (akq) this.ehh.fsH.fsP;
        akp akp = (akp) this.ehh.fsG.fsP;
        if (i2 == 4 && i3 == -68) {
            this.ehi.onSceneEnd(i2, i3, akq.getBaseResponse().ErrMsg.wVI, this);
            AppMethodBeat.o(108449);
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(65828, null));
            if (!(akp.nbk != 1 || bo.isNullOrNil(akq.wdO) || akq.wdO.equals(nullAsNil))) {
                g.RP().Ry().set(65828, akq.wdO);
                ((h) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).apM();
            }
            if (akq.ndm == null) {
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                AppMethodBeat.o(108449);
                return;
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(akq.ndm.size()));
            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < akq.ndm.size()) {
                    azd azd = (azd) akq.ndm.get(i5);
                    if (azd == null) {
                        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                    } else {
                        a vW = ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vW(azd.guM);
                        if (vW != null || akp.nbk == 1) {
                            com.tencent.mm.plugin.c.a.ask().Yn().ia(azd.vHl, azd.wlF);
                            g gVar = new g();
                            if (akp.nbk == 1) {
                                if (azd.wCX == null) {
                                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                                } else {
                                    gVar.dtU = azd.wCX.lhy;
                                    gVar.gvh = azd.wCX.wfb;
                                    com.tencent.mm.ah.b.pR(azd.wCX.lhy);
                                    gVar.gvg = azd.wCX.Name;
                                    gVar.dFl = azd.guS;
                                    gVar.dud = azd.guP;
                                    gVar.duc = azd.guO;
                                    gVar.signature = azd.guQ;
                                    gVar.dub = azd.guR;
                                    gVar.dtS = azd.guN;
                                    gVar.bCu = azd.wCW;
                                    gVar.guG = com.tencent.mm.platformtools.g.vp(azd.wCX.Name);
                                    gVar.guH = com.tencent.mm.platformtools.g.vo(azd.wCX.Name);
                                    gVar.username = azd.vHl;
                                }
                            } else if (bo.isNullOrNil(azd.vHl)) {
                                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                            }
                            j jVar = new j();
                            jVar.username = azd.vHl;
                            jVar.duc = azd.guO;
                            jVar.dud = azd.guP;
                            jVar.signature = azd.guQ;
                            jVar.dtS = azd.guN;
                            jVar.dub = azd.guR;
                            ap apVar = null;
                            if (!bo.isNullOrNil(azd.vHl)) {
                                ap aoO = ((j) g.K(j.class)).XM().aoO(azd.vHl);
                                if (aoO == null || !azd.vHl.equals(aoO.field_username)) {
                                    apVar = null;
                                } else if (bo.isNullOrNil(azd.guS) || azd.guS.equals(aoO.Hq())) {
                                    apVar = aoO;
                                } else {
                                    aoO.iy(azd.guS);
                                    ((j) g.K(j.class)).XM().b(aoO.field_username, (ad) aoO);
                                    apVar = aoO;
                                }
                            }
                            if (bo.isNullOrNil(azd.vHl)) {
                                boolean z;
                                String str2 = "mobile friend never go here";
                                if (akp.nbk == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                Assert.assertTrue(str2, z);
                                gVar.status = 102;
                            } else if (apVar == null || !com.tencent.mm.n.a.jh(apVar.field_type)) {
                                gVar.status = 100;
                                if (vW != null) {
                                    vW.status = 1;
                                    vW.username = azd.vHl;
                                    vW.bCu = azd.wCW;
                                    vW.guG = com.tencent.mm.platformtools.g.vp(azd.wCX.Name);
                                    vW.guH = com.tencent.mm.platformtools.g.vo(azd.wCX.Name);
                                    vW.guL = vW.Ny();
                                    a(vW, azd);
                                    vW.bJt = -1;
                                    ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(vW.Aq(), vW);
                                    h hVar = new h();
                                    hVar.username = azd.vHl;
                                    hVar.frW = azd.vXm;
                                    hVar.frV = azd.vXn;
                                    hVar.cB(true);
                                    hVar.dtR = 3;
                                    o.act().b(hVar);
                                }
                            } else {
                                gVar.status = 101;
                                if (vW != null) {
                                    vW.status = 2;
                                    vW.username = azd.vHl;
                                    vW.bCu = azd.wCW;
                                    vW.guL = vW.Ny();
                                    a(vW, azd);
                                    vW.bJt = -1;
                                    ((b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(vW.Aq(), vW);
                                    com.tencent.mm.ah.b.U(azd.vHl, 3);
                                }
                            }
                            if (akp.nbk == 1) {
                                ((h) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(gVar);
                            }
                            ((k) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(jVar);
                        } else {
                            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", azd.guM);
                        }
                    }
                    i4 = i5 + 1;
                } else {
                    g.RP().eJN.mB(iV);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(108449);
                    return;
                }
            }
        } else {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108449);
        }
    }

    private static void a(a aVar, azd azd) {
        aVar.guM = azd.guM;
        aVar.guN = azd.guN;
        aVar.guO = azd.guO;
        aVar.guP = azd.guP;
        aVar.guQ = azd.guQ;
        aVar.guR = azd.guR;
        aVar.guS = azd.guS;
        aVar.guT = azd.guT;
        aVar.guV = azd.guV;
        aVar.guU = azd.guU;
        aVar.guW = azd.guW;
        aVar.guX = azd.guX;
        ccl ccl = azd.wBZ;
        if (ccl != null) {
            aVar.guY = ccl.guY;
            aVar.guZ = ccl.guZ;
            aVar.gva = ccl.gva;
        }
        uy uyVar = azd.wCa;
        if (uyVar != null) {
            aVar.gvb = uyVar.gvb;
            aVar.gvc = uyVar.gvc;
            aVar.gvd = uyVar.gvd;
            aVar.gve = uyVar.gve;
        }
    }
}
