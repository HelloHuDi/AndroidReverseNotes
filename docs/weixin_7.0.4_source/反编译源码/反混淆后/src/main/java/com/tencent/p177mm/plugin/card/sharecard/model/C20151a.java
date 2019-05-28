package com.tencent.p177mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.protocal.protobuf.C44184wb;
import com.tencent.p177mm.protocal.protobuf.C44185wc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.a */
public final class C20151a extends C1207m implements C1918k {
    private String cMC = "";
    private final C7472b ehh;
    private C1202f ehi;
    public int kdT;

    public C20151a(String str) {
        AppMethodBeat.m2504i(88015);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44184wb();
        c1196a.fsK = new C44185wc();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        c1196a.fsI = 1163;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C44184wb) this.ehh.fsG.fsP).cMC = str;
        this.cMC = str;
        AppMethodBeat.m2505o(88015);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88016);
        C4990ab.m7417i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            C44185wc c44185wc = (C44185wc) this.ehh.fsH.fsP;
            C4990ab.m7416i("MicroMsg.NetSceneDelShareCard", "ret_code:" + c44185wc.kdT);
            this.kdT = c44185wc.kdT;
            if (this.kdT == 0) {
                C42852am.bbe().mo35396GJ(this.cMC);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88016);
    }

    public final int getType() {
        return 1163;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88017);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88017);
        return a;
    }
}
