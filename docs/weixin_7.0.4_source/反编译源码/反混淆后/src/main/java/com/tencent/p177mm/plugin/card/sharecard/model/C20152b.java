package com.tencent.p177mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.agt;
import com.tencent.p177mm.protocal.protobuf.agu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.b */
public final class C20152b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;
    public String kfA = "";

    public C20152b(double d, double d2, String str) {
        AppMethodBeat.m2504i(88018);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agt();
        c1196a.fsK = new agu();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        c1196a.fsI = 1164;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        agt agt = (agt) this.ehh.fsG.fsP;
        agt.latitude = d;
        agt.longitude = d2;
        agt.kfA = str;
        agt.wnm = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, (Object) "");
        C4990ab.m7410d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + agt.wnm);
        AppMethodBeat.m2505o(88018);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88019);
        C4990ab.m7417i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            agu agu = (agu) this.ehh.fsH.fsP;
            C4990ab.m7418v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + agu.kdS);
            this.kdS = agu.kdS;
            this.kfA = agu.kfA;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88019);
    }

    public final int getType() {
        return 1164;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88020);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88020);
        return a;
    }
}
