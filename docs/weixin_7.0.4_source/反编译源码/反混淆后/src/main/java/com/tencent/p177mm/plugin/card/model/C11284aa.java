package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.agl;
import com.tencent.p177mm.protocal.protobuf.agm;
import com.tencent.p177mm.protocal.protobuf.cdc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.aa */
public final class C11284aa extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;

    public C11284aa(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, cdc cdc) {
        AppMethodBeat.m2504i(87895);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agl();
        c1196a.fsK = new agm();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        this.ehh = c1196a.acD();
        agl agl = (agl) this.ehh.fsG.fsP;
        agl.cMC = str;
        agl.cME = i;
        agl.kde = str2;
        agl.cMD = str3;
        agl.vBv = str4;
        agl.vBu = str5;
        agl.vBw = i2;
        agl.wni = str6;
        agl.vBy = cdc;
        AppMethodBeat.m2505o(87895);
    }

    public final int getType() {
        return 645;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87896);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87896);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87897);
        C4990ab.m7417i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.kdS = ((agm) this.ehh.fsH.fsP).kdS;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87897);
    }
}
