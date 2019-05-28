package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;

public final class o extends m implements k {
    private b ehh;
    public f ehi;
    private String qIR;
    private cao qIS;
    private int type;

    public o(cao cao, String str) {
        AppMethodBeat.i(36261);
        a aVar = new a();
        aVar.fsJ = new cau();
        aVar.fsK = new cav();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        this.ehh = aVar.acD();
        cau cau = (cau) this.ehh.fsG.fsP;
        cau.wZr = cao;
        this.type = cao.wZN.jCt;
        this.qIS = cao;
        cau.ptv = str;
        this.qIR = str;
        ab.d("MicroMsg.NetSceneSnsComment", cao.wZN.wPm + " " + cao.wZN.wel);
        AppMethodBeat.o(36261);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36262);
        n kD = af.cnF().kD(this.qIS.vQE);
        if (kD == null) {
            com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(this.qIS.vQE);
            if (ku != null) {
                kD = ku.cqB();
            }
        }
        if (kD != null) {
            try {
                cbf cbf = (cbf) new cbf().parseFrom(kD.field_attrBuf);
                if (cbf.xaD != null && cbf.xaD.hasBuffer()) {
                    cbn cbn = (cbn) new cbn().parseFrom(cbf.xaD.getBufferToBytes());
                    cau cau = (cau) this.ehh.fsG.fsP;
                    if (cbn.xaS != null) {
                        ab.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(cbn.xaS.wcL), Integer.valueOf(cbn.xaS.wcM)}));
                        cau.wZs = new bts().alV(r0);
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36262);
        return a;
    }

    public final int getType() {
        return 213;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36263);
        ab.d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            af.cnE().e(this.qIS.vQE, this.type, this.qIR);
            can can = this.qIS.wZN;
            if (can.jCt == 1 || can.jCt == 2 || can.jCt == 3 || can.jCt == 5) {
                cat cat = new cat();
                cat.pcX = can.pcX;
                cat.jCt = can.jCt;
                cat.vFH = can.vFH;
                cat.vHl = can.wPm;
                cat.wCW = can.wZD;
                cat.ncM = can.ncM;
                cat.wZL = can.wZL;
                try {
                    cbf cbf = ((cav) this.ehh.fsH.fsP).wZu;
                    if (can.jCt == 1 || can.jCt == 5) {
                        ab.i("MicroMsg.NetSceneSnsComment", "snsComment:" + cbf.vQE + " " + aa.b(cbf.xam) + " " + cbf.xaq.size() + " " + cbf.xat.size());
                    } else {
                        ab.i("MicroMsg.NetSceneSnsComment", "snsComment:" + cbf.vQE + " " + cbf.xaq.size() + " " + cbf.xat.size());
                    }
                    aj.d(cbf);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            af.cnE().cnf();
        } else if (i2 == 4) {
            af.cnE().e(this.qIS.vQE, this.type, this.qIR);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36263);
    }
}
