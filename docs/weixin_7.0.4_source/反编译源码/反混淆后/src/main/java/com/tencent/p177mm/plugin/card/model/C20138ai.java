package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.brz;
import com.tencent.p177mm.protocal.protobuf.bsa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.ai */
public final class C20138ai extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C20138ai(String str, byte[] bArr, float f, float f2, float f3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(87919);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new brz();
        c1196a.fsK = new bsa();
        c1196a.uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
        this.ehh = c1196a.acD();
        brz brz = (brz) this.ehh.fsG.fsP;
        brz.cMC = str;
        brz.wUb = C1332b.m2847bI(bArr);
        brz.cGm = f;
        brz.cEB = f2;
        brz.wUa = f3;
        brz.wUc = z;
        brz.wUd = z2;
        AppMethodBeat.m2505o(87919);
    }

    public final int getType() {
        return 2574;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87920);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87920);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87921);
        C4990ab.m7416i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87921);
    }
}
