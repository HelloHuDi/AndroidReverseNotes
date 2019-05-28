package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bhl;
import com.tencent.p177mm.protocal.protobuf.brs;
import com.tencent.p177mm.protocal.protobuf.brt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.ah */
public final class C20137ah extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C20137ah(LinkedList<bhl> linkedList) {
        AppMethodBeat.m2504i(87916);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new brs();
        c1196a.fsK = new brt();
        c1196a.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        this.ehh = c1196a.acD();
        ((brs) this.ehh.fsG.fsP).wTU = linkedList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bhl bhl = (bhl) it.next();
                C4990ab.m7411d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", bhl.cMC, bhl.kdG, Integer.valueOf(bhl.wKK), Integer.valueOf(bhl.wKL));
            }
        }
        AppMethodBeat.m2505o(87916);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87917);
        C4990ab.m7417i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87917);
    }

    public final int getType() {
        return 1275;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87918);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87918);
        return a;
    }
}
