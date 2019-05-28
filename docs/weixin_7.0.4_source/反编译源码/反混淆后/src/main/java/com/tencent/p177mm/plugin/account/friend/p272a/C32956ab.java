package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p711c.C6562ap;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.akp;
import com.tencent.p177mm.protocal.protobuf.akq;
import com.tencent.p177mm.protocal.protobuf.azc;
import com.tencent.p177mm.protocal.protobuf.azd;
import com.tencent.p177mm.protocal.protobuf.bbl;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ab */
public final class C32956ab extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi = null;
    private List<String> gsD;
    private List<String> gwb;

    public C32956ab() {
        AppMethodBeat.m2504i(108444);
        aqf();
        akp akp = (akp) this.ehh.fsG.fsP;
        akp.wdO = "";
        akp.wqj = null;
        akp.wqi = 0;
        akp.wqh = null;
        akp.wqg = 0;
        akp.nbk = 0;
        akp.Scene = 1;
        AppMethodBeat.m2505o(108444);
    }

    public C32956ab(List<String> list, List<String> list2) {
        AppMethodBeat.m2504i(108445);
        aqf();
        if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
            AppMethodBeat.m2505o(108445);
            return;
        }
        this.gsD = list;
        this.gwb = list2;
        akp akp = (akp) this.ehh.fsG.fsP;
        akp.wdO = "";
        akp.nbk = 2;
        akp.Scene = 1;
        AppMethodBeat.m2505o(108445);
    }

    private void aqf() {
        AppMethodBeat.m2504i(108446);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akp();
        c1196a.fsK = new akq();
        c1196a.uri = "/cgi-bin/micromsg-bin/getmfriend";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_3;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(108446);
    }

    public final void aqg() {
        AppMethodBeat.m2504i(108447);
        akp akp = (akp) this.ehh.fsG.fsP;
        akp.wdO = (String) C1720g.m3536RP().mo5239Ry().get(65828, null);
        akp.nbk = 1;
        AppMethodBeat.m2505o(108447);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108448);
        this.ehi = c1202f;
        akp akp = (akp) this.ehh.fsG.fsP;
        if (akp.nbk == 2) {
            if ((this.gsD == null || this.gsD.size() == 0) && (this.gwb == null || this.gwb.size() == 0)) {
                C4990ab.m7412e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                AppMethodBeat.m2505o(108448);
                return -1;
            }
            LinkedList linkedList;
            if (this.gsD != null && this.gsD.size() > 0) {
                C4990ab.m7411d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.gsD.size()));
                linkedList = new LinkedList();
                for (String str : this.gsD) {
                    bbl bbl = new bbl();
                    bbl.f2977v = str;
                    linkedList.add(bbl);
                }
                akp.wqh = linkedList;
                akp.wqg = linkedList.size();
            }
            if (this.gwb != null && this.gwb.size() > 0) {
                C4990ab.m7411d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.gwb.size()));
                linkedList = new LinkedList();
                for (String str2 : this.gwb) {
                    azc azc = new azc();
                    azc.f4412v = str2;
                    linkedList.add(azc);
                }
                akp.wqj = linkedList;
                akp.wqi = linkedList.size();
            }
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108448);
        return a;
    }

    public final int getType() {
        return 32;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108449);
        akq akq = (akq) this.ehh.fsH.fsP;
        akp akp = (akp) this.ehh.fsG.fsP;
        if (i2 == 4 && i3 == -68) {
            this.ehi.onSceneEnd(i2, i3, akq.getBaseResponse().ErrMsg.wVI, this);
            AppMethodBeat.m2505o(108449);
        } else if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65828, null));
            if (!(akp.nbk != 1 || C5046bo.isNullOrNil(akq.wdO) || akq.wdO.equals(nullAsNil))) {
                C1720g.m3536RP().mo5239Ry().set(65828, akq.wdO);
                ((C18820h) ((C7599a) C1720g.m3530M(C7599a.class)).getFacebookFrdStg()).apM();
            }
            if (akq.ndm == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                AppMethodBeat.m2505o(108449);
                return;
            }
            C4990ab.m7417i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(akq.ndm.size()));
            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < akq.ndm.size()) {
                    azd azd = (azd) akq.ndm.get(i5);
                    if (azd == null) {
                        C4990ab.m7412e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                    } else {
                        C18817a vW = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34092vW(azd.guM);
                        if (vW != null || akp.nbk == 1) {
                            C20118a.ask().mo35364Yn().mo56747ia(azd.vHl, azd.wlF);
                            C45497g c45497g = new C45497g();
                            if (akp.nbk == 1) {
                                if (azd.wCX == null) {
                                    C4990ab.m7412e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                                } else {
                                    c45497g.dtU = azd.wCX.lhy;
                                    c45497g.gvh = azd.wCX.wfb;
                                    C41730b.m73499pR(azd.wCX.lhy);
                                    c45497g.gvg = azd.wCX.Name;
                                    c45497g.dFl = azd.guS;
                                    c45497g.dud = azd.guP;
                                    c45497g.duc = azd.guO;
                                    c45497g.signature = azd.guQ;
                                    c45497g.dub = azd.guR;
                                    c45497g.dtS = azd.guN;
                                    c45497g.bCu = azd.wCW;
                                    c45497g.guG = C9790g.m17433vp(azd.wCX.Name);
                                    c45497g.guH = C9790g.m17432vo(azd.wCX.Name);
                                    c45497g.username = azd.vHl;
                                }
                            } else if (C5046bo.isNullOrNil(azd.vHl)) {
                                C4990ab.m7420w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                            }
                            C9879j c9879j = new C9879j();
                            c9879j.username = azd.vHl;
                            c9879j.duc = azd.guO;
                            c9879j.dud = azd.guP;
                            c9879j.signature = azd.guQ;
                            c9879j.dtS = azd.guN;
                            c9879j.dub = azd.guR;
                            C6562ap c6562ap = null;
                            if (!C5046bo.isNullOrNil(azd.vHl)) {
                                C6562ap aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(azd.vHl);
                                if (aoO == null || !azd.vHl.equals(aoO.field_username)) {
                                    c6562ap = null;
                                } else if (C5046bo.isNullOrNil(azd.guS) || azd.guS.equals(aoO.mo14673Hq())) {
                                    c6562ap = aoO;
                                } else {
                                    aoO.mo14728iy(azd.guS);
                                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(aoO.field_username, (C7616ad) aoO);
                                    c6562ap = aoO;
                                }
                            }
                            if (C5046bo.isNullOrNil(azd.vHl)) {
                                boolean z;
                                String str2 = "mobile friend never go here";
                                if (akp.nbk == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                Assert.assertTrue(str2, z);
                                c45497g.status = 102;
                            } else if (c6562ap == null || !C7486a.m12942jh(c6562ap.field_type)) {
                                c45497g.status = 100;
                                if (vW != null) {
                                    vW.status = 1;
                                    vW.username = azd.vHl;
                                    vW.bCu = azd.wCW;
                                    vW.guG = C9790g.m17433vp(azd.wCX.Name);
                                    vW.guH = C9790g.m17432vo(azd.wCX.Name);
                                    vW.guL = vW.mo34069Ny();
                                    C32956ab.m53880a(vW, azd);
                                    vW.bJt = -1;
                                    ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34084a(vW.mo34067Aq(), vW);
                                    C17880h c17880h = new C17880h();
                                    c17880h.username = azd.vHl;
                                    c17880h.frW = azd.vXm;
                                    c17880h.frV = azd.vXn;
                                    c17880h.mo33385cB(true);
                                    c17880h.dtR = 3;
                                    C17884o.act().mo33391b(c17880h);
                                }
                            } else {
                                c45497g.status = 101;
                                if (vW != null) {
                                    vW.status = 2;
                                    vW.username = azd.vHl;
                                    vW.bCu = azd.wCW;
                                    vW.guL = vW.mo34069Ny();
                                    C32956ab.m53880a(vW, azd);
                                    vW.bJt = -1;
                                    ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34084a(vW.mo34067Aq(), vW);
                                    C41730b.m73489U(azd.vHl, 3);
                                }
                            }
                            if (akp.nbk == 1) {
                                ((C18820h) ((C7599a) C1720g.m3530M(C7599a.class)).getFacebookFrdStg()).mo34096a(c45497g);
                            }
                            ((C26586k) ((C7599a) C1720g.m3530M(C7599a.class)).getFrdExtStg()).mo44367a(c9879j);
                        } else {
                            C4990ab.m7413e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", azd.guM);
                        }
                    }
                    i4 = i5 + 1;
                } else {
                    C1720g.m3536RP().eJN.mo15640mB(iV);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(108449);
                    return;
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108449);
        }
    }

    /* renamed from: a */
    private static void m53880a(C18817a c18817a, azd azd) {
        c18817a.guM = azd.guM;
        c18817a.guN = azd.guN;
        c18817a.guO = azd.guO;
        c18817a.guP = azd.guP;
        c18817a.guQ = azd.guQ;
        c18817a.guR = azd.guR;
        c18817a.guS = azd.guS;
        c18817a.guT = azd.guT;
        c18817a.guV = azd.guV;
        c18817a.guU = azd.guU;
        c18817a.guW = azd.guW;
        c18817a.guX = azd.guX;
        ccl ccl = azd.wBZ;
        if (ccl != null) {
            c18817a.guY = ccl.guY;
            c18817a.guZ = ccl.guZ;
            c18817a.gva = ccl.gva;
        }
        C7285uy c7285uy = azd.wCa;
        if (c7285uy != null) {
            c18817a.gvb = c7285uy.gvb;
            c18817a.gvc = c7285uy.gvc;
            c18817a.gvd = c7285uy.gvd;
            c18817a.gve = c7285uy.gve;
        }
    }
}
