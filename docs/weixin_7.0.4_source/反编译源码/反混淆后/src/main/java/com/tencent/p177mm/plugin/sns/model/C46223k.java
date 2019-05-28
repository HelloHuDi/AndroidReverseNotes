package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelstat.C26485p;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.caf;
import com.tencent.p177mm.protocal.protobuf.cag;
import com.tencent.p177mm.protocal.protobuf.cai;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbt;
import com.tencent.p177mm.protocal.protobuf.cdh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.model.k */
public final class C46223k extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;
    private String qIR;
    private cao qIS;
    private int type;

    public C46223k(cao cao, String str, String str2) {
        cdh tK;
        AppMethodBeat.m2504i(36239);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new caf();
        c1196a.fsK = new cag();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        this.ehh = c1196a.acD();
        caf caf = (caf) this.ehh.fsG.fsP;
        caf.wZr = cao;
        this.type = cao.wZN.jCt;
        this.qIS = cao;
        caf.ptv = str;
        this.qIR = str;
        C43570e ku = C13373af.cnI().mo69174ku(cao.vQE);
        if (ku != null) {
            TimeLineObject cqu = ku.cqu();
            if (cqu != null) {
                tK = C26485p.m42205tK(cqu.rjC);
            } else {
                C4990ab.m7419v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(r2));
                tK = null;
            }
        } else {
            C4990ab.m7419v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", Long.valueOf(r2));
            tK = null;
        }
        if (tK != null) {
            caf.wZs = C1946aa.m4154vy(C26485p.m42200a(tK));
            caf.vFH = tK.cvd;
        }
        caf.wZq = C1946aa.m4154vy(C5046bo.m7532bc(str2, ""));
        C4990ab.m7416i("MicroMsg.NetSceneSnsAdComment", cao.wZN.wPm + " " + cao.wZN.wel + " type " + cao.wZN.jCt + " aduxinfo " + str2 + ", SnsStat=" + caf.wZs + ", source=" + caf.vFH);
        AppMethodBeat.m2505o(36239);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36240);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36240);
        return a;
    }

    public final int getType() {
        return 682;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36241);
        C4990ab.m7410d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            C13373af.cnE().mo37406e(this.qIS.vQE, this.type, this.qIR);
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
                        C43555a.m77868a(cbt);
                    } else {
                        cai cai = cag.vEX;
                        obj = cai.wZu;
                        C43555a.m77866a(cai);
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + obj.toString() + " " + obj.xaq.size() + " " + obj.xat.size());
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            C13373af.cnE().cnf();
        } else if (i2 == 4) {
            C13373af.cnE().mo37406e(this.qIS.vQE, this.type, this.qIR);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36241);
    }
}
