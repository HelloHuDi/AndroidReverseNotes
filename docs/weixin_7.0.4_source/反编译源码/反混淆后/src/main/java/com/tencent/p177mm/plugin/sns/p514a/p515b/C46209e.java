package com.tencent.p177mm.plugin.sns.p514a.p515b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C15322bq;
import com.tencent.p177mm.protocal.protobuf.C30171br;
import com.tencent.p177mm.protocal.protobuf.axb;
import com.tencent.p177mm.protocal.protobuf.axc;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.a.b.e */
public final class C46209e extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;
    public List<axc> iKa;

    public C46209e(List<axc> list) {
        int i = 0;
        AppMethodBeat.m2504i(35708);
        C1196a c1196a = new C1196a();
        this.iKa = list;
        c1196a.fsJ = new C15322bq();
        c1196a.fsK = new C30171br();
        c1196a.uri = "/cgi-bin/mmux-bin/adlog";
        this.ehh = c1196a.acD();
        C15322bq c15322bq = (C15322bq) this.ehh.fsG.fsP;
        axb axb = new axb();
        axb.vOz = C7243d.vxj;
        axb.vOA = C7243d.vxi;
        axb.vOB = C7243d.vxl;
        axb.vOC = C7243d.vxm;
        axb.vOD = C4988aa.dor();
        axb.wBk = (int) (System.currentTimeMillis() / 1000);
        c15322bq.vDV = axb;
        while (i < list.size()) {
            c15322bq.vDW.add(list.get(i));
            i++;
        }
        C4990ab.m7416i("MicroMsg.NetSceneAdLog", "report count: " + c15322bq.vDW.size());
        AppMethodBeat.m2505o(35708);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(35709);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(35709);
        return a;
    }

    public final int getType() {
        return 1802;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(35710);
        C4990ab.m7410d("MicroMsg.NetSceneAdLog", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            int i4 = ((C30171br) ((C7472b) c1929q).fsH.fsP).vDX;
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(i4));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(35710);
    }
}
