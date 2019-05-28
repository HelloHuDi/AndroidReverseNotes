package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends m implements com.tencent.mm.network.k {
    private f eIc = null;
    private b lty = null;
    private String[] ltz;

    public k(String[] strArr, String str) {
        AppMethodBeat.i(19311);
        this.ltz = strArr;
        ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", str, Integer.valueOf(1));
        a aVar = new a();
        aVar.fsJ = new io();
        aVar.fsK = new ip();
        aVar.fsI = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        io ioVar = (io) this.lty.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                in inVar = new in();
                inVar.vKF = str2;
                linkedList.add(inVar);
                ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", str2);
            }
        }
        ioVar.vKG = linkedList;
        if (!bo.isNullOrNil(str)) {
            im imVar = new im();
            imVar.vKE = str;
            ioVar.vKH = imVar;
        }
        ioVar.vKI = 3;
        AppMethodBeat.o(19311);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19312);
        ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ltz != null && this.ltz.length == 1) {
            ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", this.ltz[0]);
        }
        if (qVar == null) {
            ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
            AppMethodBeat.o(19312);
        } else if (this.lty.fsI != qVar.getType()) {
            ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", Integer.valueOf(this.lty.fsI), Integer.valueOf(qVar.getType()));
            AppMethodBeat.o(19312);
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = boO().vKJ.iterator();
                while (it.hasNext()) {
                    iq iqVar = (iq) it.next();
                    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", Integer.valueOf(iqVar.Ret), iqVar.vKK, iqVar.vKF, iqVar.jBF);
                    if (iqVar.vKL == null) {
                        ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        bbv bbv = iqVar.vKL;
                        if (bbv == null) {
                            ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = aa.a(bbv.wcB);
                            String nullAsNil = bo.nullAsNil(bbv.wGl);
                            if (bo.isNullOrNil(a) && bo.isNullOrNil(nullAsNil)) {
                                ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", a, nullAsNil);
                            } else {
                                ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", a);
                                aw.ZK();
                                ad aoO = c.XM().aoO(a);
                                if (aoO == null || !a.equals(aoO.field_encryptUsername)) {
                                    ad adVar = new ad(a);
                                    adVar.iy(bbv.guS);
                                    adVar.setType(bbv.wbu & bbv.wbv);
                                    if (!bo.isNullOrNil(nullAsNil)) {
                                        adVar.iH(nullAsNil);
                                    } else if (aoO != null && ((int) aoO.ewQ) > 0) {
                                        adVar.iH(aoO.field_encryptUsername);
                                    }
                                    adVar.ewQ = aoO == null ? 0 : (long) ((int) aoO.ewQ);
                                    adVar.iB(aa.a(bbv.wyX));
                                    adVar.iC(aa.a(bbv.wce));
                                    adVar.iD(aa.a(bbv.wcf));
                                    adVar.hA(bbv.guN);
                                    adVar.hD(bbv.wbA);
                                    adVar.iA(aa.a(bbv.wGf));
                                    adVar.hE(bbv.wbE);
                                    adVar.hF(bbv.guR);
                                    adVar.iW(RegionCodeDecoder.aC(bbv.guW, bbv.guO, bbv.guP));
                                    adVar.iQ(bbv.guQ);
                                    adVar.hw(bbv.wBT);
                                    adVar.iV(bbv.wBU);
                                    adVar.setSource(bbv.vFH);
                                    adVar.hv(bbv.wBX);
                                    adVar.iE(bbv.wBW);
                                    if (t.nO(bbv.wBV)) {
                                        adVar.iU(bbv.wBV);
                                    }
                                    adVar.hH((int) bo.anT());
                                    adVar.iz(aa.a(bbv.wFK));
                                    adVar.iF(aa.a(bbv.wFM));
                                    adVar.iG(aa.a(bbv.wFL));
                                    adVar.iX(bbv.vEA);
                                    adVar.iY(bbv.wGv);
                                    if (!(aoO == null || bo.nullAsNil(aoO.dum).equals(bo.nullAsNil(bbv.wGv)))) {
                                        com.tencent.mm.bc.c.aiB();
                                        com.tencent.mm.bc.c.sY(a);
                                    }
                                    aw.ZK();
                                    c.XM().aoT(a);
                                    if (bo.isNullOrNil(adVar.field_username)) {
                                        ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = adVar.field_username;
                                        o.act().b(com.tencent.mm.ah.b.a(str2, bbv));
                                        ccl ccl = bbv.wBZ;
                                        if (!(adVar.field_username.endsWith("@chatroom") || ccl == null)) {
                                            ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ccl.guY + " " + bbv.wcB);
                                            ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ccl.guZ);
                                            ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ccl.gva);
                                            ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ccl.xbQ);
                                            if (n.qFy != null) {
                                                n.qFy.a(adVar.field_username, ccl);
                                            }
                                        }
                                        String Yz = r.Yz();
                                        if (!(Yz == null || Yz.equals(str2))) {
                                            d qP = z.aeR().qP(str2);
                                            qP.field_username = str2;
                                            qP.field_brandList = bbv.guX;
                                            uy uyVar = bbv.wCa;
                                            if (uyVar != null) {
                                                qP.field_brandFlag = uyVar.gvb;
                                                qP.field_brandInfo = uyVar.gvd;
                                                qP.field_brandIconURL = uyVar.gve;
                                                qP.field_extInfo = uyVar.gvc;
                                                qP.field_attrSyncVersion = null;
                                                qP.field_incrementUpdateTime = 0;
                                            }
                                            if (!z.aeR().e(qP)) {
                                                z.aeR().d(qP);
                                            }
                                            adVar.hI(qP.field_type);
                                        }
                                    }
                                    adVar.hy(bbv.wGu);
                                    if (!(bbv.wGq == null || bbv.wGq.vEU == null)) {
                                        adVar.iZ(bbv.wGq.vEU.vLl);
                                        adVar.ja(bbv.wGq.vEU.vLm);
                                        adVar.jb(bbv.wGq.vEU.vLn);
                                    }
                                    if (t.nI(a)) {
                                        adVar.NK();
                                    }
                                    if (adVar.dsf()) {
                                        adVar.NN();
                                    }
                                    if (bo.isNullOrNil(nullAsNil)) {
                                        aw.ZK();
                                        c.XM().Y(adVar);
                                    } else {
                                        aw.ZK();
                                        c.XM().c(nullAsNil, adVar);
                                    }
                                    if (!(aoO == null || (aoO.field_type & 2048) == (adVar.field_type & 2048))) {
                                        if ((adVar.field_type & 2048) != 0) {
                                            aw.ZK();
                                            c.XR().apf(adVar.field_username);
                                        } else {
                                            aw.ZK();
                                            c.XR().apg(adVar.field_username);
                                        }
                                    }
                                } else {
                                    ab.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.eIc.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(19312);
        }
    }

    public final int getType() {
        return 542;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19313);
        this.eIc = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(19313);
        return a;
    }

    public final ip boO() {
        if (this.lty == null || this.lty.fsH.fsP == null) {
            return null;
        }
        return (ip) this.lty.fsH.fsP;
    }
}
