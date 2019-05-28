package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.agj;
import com.tencent.p177mm.protocal.protobuf.agk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.z */
public final class C27589z extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public CardGiftInfo kdV;

    public C27589z(int i, String str) {
        AppMethodBeat.m2504i(87892);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agj();
        c1196a.fsK = new agk();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        this.ehh = c1196a.acD();
        agj agj = (agj) this.ehh.fsG.fsP;
        agj.vBA = i;
        agj.vBB = str;
        AppMethodBeat.m2505o(87892);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87893);
        C4990ab.m7417i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.kdV = CardGiftInfo.m84651a((agk) this.ehh.fsH.fsP);
            C4990ab.m7411d("MicroMsg.NetSceneGetCardGiftInfo", "%s", this.kdV.toString());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87893);
    }

    public final int getType() {
        return 1165;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87894);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87894);
        return a;
    }
}
