package com.tencent.p177mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aog;
import com.tencent.p177mm.protocal.protobuf.aoh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.c */
public final class C27591c extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;

    public C27591c(String str) {
        AppMethodBeat.m2504i(88021);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aog();
        c1196a.fsK = new aoh();
        c1196a.uri = "/cgi-bin/micromsg-bin/getsharecard";
        this.ehh = c1196a.acD();
        ((aog) this.ehh.fsG.fsP).cMC = str;
        AppMethodBeat.m2505o(88021);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(88022);
        C4990ab.m7417i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(904), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aoh aoh = (aoh) this.ehh.fsH.fsP;
            C4990ab.m7418v("MicroMsg.NetSceneGetShareCard", "json:" + aoh.kdS);
            this.kdS = aoh.kdS;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(88022);
    }

    public final int getType() {
        return 904;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(88023);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(88023);
        return a;
    }
}
