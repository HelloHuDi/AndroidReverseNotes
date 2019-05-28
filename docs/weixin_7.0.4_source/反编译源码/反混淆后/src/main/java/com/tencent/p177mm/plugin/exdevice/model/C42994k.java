package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p1185bc.C17974c;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.C15349ip;
import com.tencent.p177mm.protocal.protobuf.C15350iq;
import com.tencent.p177mm.protocal.protobuf.C35925io;
import com.tencent.p177mm.protocal.protobuf.C40529in;
import com.tencent.p177mm.protocal.protobuf.C46552im;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.exdevice.model.k */
public final class C42994k extends C1207m implements C1918k {
    private C1202f eIc = null;
    private C7472b lty = null;
    private String[] ltz;

    public C42994k(String[] strArr, String str) {
        AppMethodBeat.m2504i(19311);
        this.ltz = strArr;
        C4990ab.m7417i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", str, Integer.valueOf(1));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35925io();
        c1196a.fsK = new C15349ip();
        c1196a.fsI = 542;
        c1196a.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.lty = c1196a.acD();
        C35925io c35925io = (C35925io) this.lty.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                C40529in c40529in = new C40529in();
                c40529in.vKF = str2;
                linkedList.add(c40529in);
                C4990ab.m7417i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", str2);
            }
        }
        c35925io.vKG = linkedList;
        if (!C5046bo.isNullOrNil(str)) {
            C46552im c46552im = new C46552im();
            c46552im.vKE = str;
            c35925io.vKH = c46552im;
        }
        c35925io.vKI = 3;
        AppMethodBeat.m2505o(19311);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19312);
        C4990ab.m7417i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ltz != null && this.ltz.length == 1) {
            C4990ab.m7417i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", this.ltz[0]);
        }
        if (c1929q == null) {
            C4990ab.m7412e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
            AppMethodBeat.m2505o(19312);
        } else if (this.lty.fsI != c1929q.getType()) {
            C4990ab.m7413e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", Integer.valueOf(this.lty.fsI), Integer.valueOf(c1929q.getType()));
            AppMethodBeat.m2505o(19312);
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = boO().vKJ.iterator();
                while (it.hasNext()) {
                    C15350iq c15350iq = (C15350iq) it.next();
                    C4990ab.m7417i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", Integer.valueOf(c15350iq.Ret), c15350iq.vKK, c15350iq.vKF, c15350iq.jBF);
                    if (c15350iq.vKL == null) {
                        C4990ab.m7412e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        bbv bbv = c15350iq.vKL;
                        if (bbv == null) {
                            C4990ab.m7412e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = C1946aa.m4148a(bbv.wcB);
                            String nullAsNil = C5046bo.nullAsNil(bbv.wGl);
                            if (C5046bo.isNullOrNil(a) && C5046bo.isNullOrNil(nullAsNil)) {
                                C4990ab.m7413e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", a, nullAsNil);
                            } else {
                                C4990ab.m7417i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", a);
                                C9638aw.m17190ZK();
                                C7616ad aoO = C18628c.m29078XM().aoO(a);
                                if (aoO == null || !a.equals(aoO.field_encryptUsername)) {
                                    C7616ad c7616ad = new C7616ad(a);
                                    c7616ad.mo14728iy(bbv.guS);
                                    c7616ad.setType(bbv.wbu & bbv.wbv);
                                    if (!C5046bo.isNullOrNil(nullAsNil)) {
                                        c7616ad.mo14709iH(nullAsNil);
                                    } else if (aoO != null && ((int) aoO.ewQ) > 0) {
                                        c7616ad.mo14709iH(aoO.field_encryptUsername);
                                    }
                                    c7616ad.ewQ = aoO == null ? 0 : (long) ((int) aoO.ewQ);
                                    c7616ad.mo14703iB(C1946aa.m4148a(bbv.wyX));
                                    c7616ad.mo14704iC(C1946aa.m4148a(bbv.wce));
                                    c7616ad.mo14705iD(C1946aa.m4148a(bbv.wcf));
                                    c7616ad.mo14685hA(bbv.guN);
                                    c7616ad.mo14688hD(bbv.wbA);
                                    c7616ad.mo14702iA(C1946aa.m4148a(bbv.wGf));
                                    c7616ad.mo14689hE(bbv.wbE);
                                    c7616ad.mo14690hF(bbv.guR);
                                    c7616ad.mo14724iW(RegionCodeDecoder.m7796aC(bbv.guW, bbv.guO, bbv.guP));
                                    c7616ad.mo14718iQ(bbv.guQ);
                                    c7616ad.mo14698hw(bbv.wBT);
                                    c7616ad.mo14723iV(bbv.wBU);
                                    c7616ad.setSource(bbv.vFH);
                                    c7616ad.mo14697hv(bbv.wBX);
                                    c7616ad.mo14706iE(bbv.wBW);
                                    if (C1855t.m3929nO(bbv.wBV)) {
                                        c7616ad.mo14722iU(bbv.wBV);
                                    }
                                    c7616ad.mo14692hH((int) C5046bo.anT());
                                    c7616ad.mo14729iz(C1946aa.m4148a(bbv.wFK));
                                    c7616ad.mo14707iF(C1946aa.m4148a(bbv.wFM));
                                    c7616ad.mo14708iG(C1946aa.m4148a(bbv.wFL));
                                    c7616ad.mo14725iX(bbv.vEA);
                                    c7616ad.mo14726iY(bbv.wGv);
                                    if (!(aoO == null || C5046bo.nullAsNil(aoO.dum).equals(C5046bo.nullAsNil(bbv.wGv)))) {
                                        C17974c.aiB();
                                        C17974c.m28284sY(a);
                                    }
                                    C9638aw.m17190ZK();
                                    C18628c.m29078XM().aoT(a);
                                    if (C5046bo.isNullOrNil(c7616ad.field_username)) {
                                        C4990ab.m7412e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = c7616ad.field_username;
                                        C17884o.act().mo33391b(C41730b.m73491a(str2, bbv));
                                        ccl ccl = bbv.wBZ;
                                        if (!(c7616ad.field_username.endsWith("@chatroom") || ccl == null)) {
                                            C4990ab.m7416i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ccl.guY + " " + bbv.wcB);
                                            C4990ab.m7416i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ccl.guZ);
                                            C4990ab.m7416i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ccl.gva);
                                            C4990ab.m7416i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ccl.xbQ);
                                            if (C21877n.qFy != null) {
                                                C21877n.qFy.mo47112a(c7616ad.field_username, ccl);
                                            }
                                        }
                                        String Yz = C1853r.m3846Yz();
                                        if (!(Yz == null || Yz.equals(str2))) {
                                            C16527d qP = C41747z.aeR().mo43729qP(str2);
                                            qP.field_username = str2;
                                            qP.field_brandList = bbv.guX;
                                            C7285uy c7285uy = bbv.wCa;
                                            if (c7285uy != null) {
                                                qP.field_brandFlag = c7285uy.gvb;
                                                qP.field_brandInfo = c7285uy.gvd;
                                                qP.field_brandIconURL = c7285uy.gve;
                                                qP.field_extInfo = c7285uy.gvc;
                                                qP.field_attrSyncVersion = null;
                                                qP.field_incrementUpdateTime = 0;
                                            }
                                            if (!C41747z.aeR().mo43726e(qP)) {
                                                C41747z.aeR().mo43724d(qP);
                                            }
                                            c7616ad.mo14693hI(qP.field_type);
                                        }
                                    }
                                    c7616ad.mo14700hy(bbv.wGu);
                                    if (!(bbv.wGq == null || bbv.wGq.vEU == null)) {
                                        c7616ad.mo14727iZ(bbv.wGq.vEU.vLl);
                                        c7616ad.mo14730ja(bbv.wGq.vEU.vLm);
                                        c7616ad.mo14731jb(bbv.wGq.vEU.vLn);
                                    }
                                    if (C1855t.m3923nI(a)) {
                                        c7616ad.mo16685NK();
                                    }
                                    if (c7616ad.dsf()) {
                                        c7616ad.mo16688NN();
                                    }
                                    if (C5046bo.isNullOrNil(nullAsNil)) {
                                        C9638aw.m17190ZK();
                                        C18628c.m29078XM().mo15701Y(c7616ad);
                                    } else {
                                        C9638aw.m17190ZK();
                                        C18628c.m29078XM().mo15732c(nullAsNil, c7616ad);
                                    }
                                    if (!(aoO == null || (aoO.field_type & 2048) == (c7616ad.field_type & 2048))) {
                                        if ((c7616ad.field_type & 2048) != 0) {
                                            C9638aw.m17190ZK();
                                            C18628c.m29083XR().apf(c7616ad.field_username);
                                        } else {
                                            C9638aw.m17190ZK();
                                            C18628c.m29083XR().apg(c7616ad.field_username);
                                        }
                                    }
                                } else {
                                    C4990ab.m7420w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(19312);
        }
    }

    public final int getType() {
        return 542;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19313);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(19313);
        return a;
    }

    public final C15349ip boO() {
        if (this.lty == null || this.lty.fsH.fsP == null) {
            return null;
        }
        return (C15349ip) this.lty.fsH.fsP;
    }
}
