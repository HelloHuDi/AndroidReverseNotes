package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import junit.framework.Assert;

public final class b extends m implements k {
    private f ehi;
    private Set<String> psI;

    public b(Set<String> set) {
        AppMethodBeat.i(24072);
        Assert.assertTrue(true);
        this.psI = set;
        AppMethodBeat.o(24072);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24073);
        this.ehi = fVar;
        LinkedList<String> linkedList = new LinkedList();
        for (String add : this.psI) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            ab.e("MicroMsg.NetSceneBatchGetContactProfile", g.Mq() + "doScene reqSize ==0");
            AppMethodBeat.o(24073);
            return -1;
        }
        a aVar = new a();
        aVar.fsJ = new ie();
        aVar.fsK = new if();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.fsI = 140;
        aVar.fsL = 28;
        aVar.fsM = 1000000028;
        com.tencent.mm.ai.b acD = aVar.acD();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(aa.vy(add2));
        }
        ((ie) acD.fsG.fsP).vEg = linkedList2;
        ((ie) acD.fsG.fsP).vKz = 1;
        ((ie) acD.fsG.fsP).jBv = linkedList2.size();
        int a = a(eVar, acD, this);
        AppMethodBeat.o(24073);
        return a;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    public final int getType() {
        return 140;
    }

    public final int acn() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24074);
        if (i2 == 0 && i3 == 0) {
            if (h(qVar) && this.psI.size() > 0) {
                a(this.ftf, this.ehi);
            }
            ab.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.psI.size());
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(24074);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24074);
    }

    private boolean h(q qVar) {
        AppMethodBeat.i(24075);
        if ifVar = (if) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        if (ifVar == null) {
            ab.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            AppMethodBeat.o(24075);
            return false;
        } else if (qVar.ZS().vyl == 1) {
            ab.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            AppMethodBeat.o(24075);
            return false;
        } else if (qVar.ZS().vyl == -1) {
            ab.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            AppMethodBeat.o(24075);
            return true;
        } else {
            LinkedList linkedList = ifVar.vKA;
            if (linkedList == null) {
                AppMethodBeat.o(24075);
                return false;
            }
            int i = 0;
            while (i < linkedList.size()) {
                ud udVar;
                boolean z;
                try {
                    udVar = (ud) new ud().parseFrom(aa.a((SKBuiltinBuffer_t) linkedList.get(i)));
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    ab.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    udVar = null;
                }
                if (udVar == null || udVar.jBB == null) {
                    ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.psI.contains(udVar.jBB)) {
                    this.psI.remove(udVar.jBB);
                    aw.ZK();
                    ad aoO = c.XM().aoO(udVar.jBB);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        aoO.setUsername(udVar.jBB);
                        aoO.iy(udVar.guS);
                        aoO.setType(udVar.wbu & udVar.wbv);
                        aoO.iB(udVar.jCH);
                        aoO.iC(udVar.wbs);
                        aoO.iD(udVar.wbt);
                        aoO.hA(udVar.guN);
                        aoO.iz(udVar.wbw);
                        aoO.iF(udVar.wbz);
                        aoO.iG(udVar.wby);
                        aoO.hD(udVar.wbA);
                        aoO.iA(udVar.wbD);
                        aoO.hE(udVar.wbE);
                        aw.ZK();
                        if (c.XM().b(aoO.field_username, aoO) == -1) {
                            ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (ad.aow(udVar.jBB)) {
                            d Vb = g.cca().Vb(udVar.jBB);
                            if (Vb == null || bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                                ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                Vb.extInfo = udVar.ndT;
                                Vb.psL = (long) udVar.wbG;
                                Vb.psM = (long) udVar.wbH;
                                Vb.bJt = 52;
                                if (!g.cca().a(udVar.jBB, Vb)) {
                                    ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (ad.aou(udVar.jBB)) {
                            sw swVar = new sw();
                            swVar.cOY.opType = 0;
                            swVar.cOY.cIS = udVar.jBB;
                            swVar.cOY.cIT = udVar.wbG;
                            swVar.cOY.cIU = udVar.wbx;
                            com.tencent.mm.sdk.b.a.xxA.m(swVar);
                        }
                        z = true;
                    }
                } else {
                    ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (z) {
                    i++;
                } else {
                    AppMethodBeat.o(24075);
                    return false;
                }
            }
            AppMethodBeat.o(24075);
            return true;
        }
    }
}
