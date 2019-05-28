package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15316an;
import com.tencent.p177mm.protocal.protobuf.C15317ao;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.q */
public final class C27588q extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public CardGiftInfo kdV;

    public C27588q(int i, String str, String str2, Boolean bool) {
        AppMethodBeat.m2504i(87863);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15316an();
        c1196a.fsK = new C15317ao();
        c1196a.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        this.ehh = c1196a.acD();
        C15316an c15316an = (C15316an) this.ehh.fsG.fsP;
        c15316an.vBA = i;
        c15316an.vBB = str;
        c15316an.vBC = str2;
        c15316an.vBD = bool.booleanValue();
        AppMethodBeat.m2505o(87863);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87864);
        C4990ab.m7417i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.kdV = CardGiftInfo.m84652a((C15317ao) this.ehh.fsH.fsP);
            C4990ab.m7411d("MicroMsg.NetSceneAcceptGiftCard", "%s", this.kdV.toString());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87864);
    }

    public final int getType() {
        return 1136;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87865);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87865);
        return a;
    }
}
