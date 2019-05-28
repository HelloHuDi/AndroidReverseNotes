package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40501ai;
import com.tencent.p177mm.protocal.protobuf.C46521aj;
import com.tencent.p177mm.protocal.protobuf.cdc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.o */
public final class C33772o extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public C33772o(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, cdc cdc) {
        AppMethodBeat.m2504i(87857);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40501ai();
        c1196a.fsK = new C46521aj();
        c1196a.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        this.ehh = c1196a.acD();
        C40501ai c40501ai = (C40501ai) this.ehh.fsG.fsP;
        c40501ai.cMC = str;
        c40501ai.kde = str2;
        c40501ai.cME = i;
        c40501ai.cMD = str3;
        c40501ai.vBv = str4;
        c40501ai.vBu = str5;
        c40501ai.vBw = i2;
        c40501ai.vBx = i3;
        c40501ai.vBy = cdc;
        AppMethodBeat.m2505o(87857);
    }

    public final int getType() {
        return 651;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87858);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87858);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87859);
        C4990ab.m7416i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        C46521aj c46521aj;
        if (i2 == 0 && i3 == 0) {
            c46521aj = (C46521aj) this.ehh.fsH.fsP;
            if (c46521aj != null) {
                this.kdS = c46521aj.kdS;
                this.kdT = c46521aj.kdT;
                this.kdU = c46521aj.kdU;
            }
        } else {
            c46521aj = (C46521aj) this.ehh.fsH.fsP;
            if (c46521aj != null) {
                this.kdS = c46521aj.kdS;
                this.kdT = c46521aj.kdT;
                this.kdU = c46521aj.kdU;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87859);
    }
}
