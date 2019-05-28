package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cau;
import com.tencent.p177mm.protocal.protobuf.cav;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.sns.model.o */
public final class C13430o extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;
    private String qIR;
    private cao qIS;
    private int type;

    public C13430o(cao cao, String str) {
        AppMethodBeat.m2504i(36261);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cau();
        c1196a.fsK = new cav();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        this.ehh = c1196a.acD();
        cau cau = (cau) this.ehh.fsG.fsP;
        cau.wZr = cao;
        this.type = cao.wZN.jCt;
        this.qIS = cao;
        cau.ptv = str;
        this.qIR = str;
        C4990ab.m7410d("MicroMsg.NetSceneSnsComment", cao.wZN.wPm + " " + cao.wZN.wel);
        AppMethodBeat.m2505o(36261);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36262);
        C46236n kD = C13373af.cnF().mo62941kD(this.qIS.vQE);
        if (kD == null) {
            C43570e ku = C13373af.cnI().mo69174ku(this.qIS.vQE);
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
                        C4990ab.m7417i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(cbn.xaS.wcL), Integer.valueOf(cbn.xaS.wcM)}));
                        cau.wZs = new bts().alV(r0);
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36262);
        return a;
    }

    public final int getType() {
        return 213;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36263);
        C4990ab.m7410d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            C13373af.cnE().mo37406e(this.qIS.vQE, this.type, this.qIR);
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
                        C4990ab.m7416i("MicroMsg.NetSceneSnsComment", "snsComment:" + cbf.vQE + " " + C1946aa.m4153b(cbf.xam) + " " + cbf.xaq.size() + " " + cbf.xat.size());
                    } else {
                        C4990ab.m7416i("MicroMsg.NetSceneSnsComment", "snsComment:" + cbf.vQE + " " + cbf.xaq.size() + " " + cbf.xat.size());
                    }
                    C34955aj.m57404d(cbf);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            C13373af.cnE().cnf();
        } else if (i2 == 4) {
            C13373af.cnE().mo37406e(this.qIS.vQE, this.type, this.qIR);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36263);
    }
}
