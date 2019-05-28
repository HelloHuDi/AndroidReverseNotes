package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class k extends m implements com.tencent.mm.network.k {
    private b ehh;
    public f ehi;
    private String qIR;
    private cao qIS;
    private int type;

    public k(cao cao, String str, String str2) {
        cdh tK;
        AppMethodBeat.i(36239);
        a aVar = new a();
        aVar.fsJ = new caf();
        aVar.fsK = new cag();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        this.ehh = aVar.acD();
        caf caf = (caf) this.ehh.fsG.fsP;
        caf.wZr = cao;
        this.type = cao.wZN.jCt;
        this.qIS = cao;
        caf.ptv = str;
        this.qIR = str;
        e ku = af.cnI().ku(cao.vQE);
        if (ku != null) {
            TimeLineObject cqu = ku.cqu();
            if (cqu != null) {
                tK = p.tK(cqu.rjC);
            } else {
                ab.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(r2));
                tK = null;
            }
        } else {
            ab.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(r2));
            tK = null;
        }
        if (tK != null) {
            caf.wZs = aa.vy(p.a(tK));
            caf.vFH = tK.cvd;
        }
        caf.wZq = aa.vy(bo.bc(str2, ""));
        ab.i("MicroMsg.NetSceneSnsAdComment", cao.wZN.wPm + " " + cao.wZN.wel + " type " + cao.wZN.jCt + " aduxinfo " + str2 + ", SnsStat=" + caf.wZs + ", source=" + caf.vFH);
        AppMethodBeat.o(36239);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36240);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36240);
        return a;
    }

    public final int getType() {
        return 682;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36241);
        ab.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            af.cnE().e(this.qIS.vQE, this.type, this.qIR);
            can can = this.qIS.wZN;
            if (can.jCt == 1 || can.jCt == 2 || can.jCt == 3 || can.jCt == 5 || can.jCt == 7 || can.jCt == 8 || can.jCt == 16) {
                cat cat = new cat();
                cat.pcX = can.pcX;
                cat.jCt = can.jCt;
                cat.vFH = can.vFH;
                cat.vHl = can.wPm;
                cat.wCW = can.wZD;
                cat.ncM = can.ncM;
                cat.wZL = can.wZL;
                try {
                    Object obj;
                    caf caf = (caf) this.ehh.fsG.fsP;
                    cag cag = (cag) this.ehh.fsH.fsP;
                    if (caf.vFH == 1 || caf.vFH == 2) {
                        cbt cbt = cag.wSf;
                        obj = cbt.wZu;
                        a.a(cbt);
                    } else {
                        cai cai = cag.vEX;
                        obj = cai.wZu;
                        a.a(cai);
                    }
                    ab.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + obj.toString() + " " + obj.xaq.size() + " " + obj.xat.size());
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            af.cnE().cnf();
        } else if (i2 == 4) {
            af.cnE().e(this.qIS.vQE, this.type, this.qIR);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36241);
    }
}
