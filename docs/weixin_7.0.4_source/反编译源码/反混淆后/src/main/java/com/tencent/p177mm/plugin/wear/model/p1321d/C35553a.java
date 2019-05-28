package com.tencent.p177mm.plugin.wear.model.p1321d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.asv;
import com.tencent.p177mm.protocal.protobuf.asw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.wear.model.d.a */
public final class C35553a extends C1207m implements C1918k {
    public String ceI;
    public String cws;
    private C1202f ehi;
    private C7472b fAT;

    public C35553a(String str, String str2) {
        AppMethodBeat.m2504i(26372);
        this.ceI = str;
        this.cws = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA;
        c1196a.uri = "/cgi-bin/mmbiz-bin/device/register";
        c1196a.fsJ = new asv();
        c1196a.fsK = new asw();
        this.fAT = c1196a.acD();
        asv asv = (asv) this.fAT.fsG.fsP;
        asv.vKc = new C1332b(str.getBytes());
        asv.vKe = new C1332b(str2.getBytes());
        asv.wwF = new C1332b("5".getBytes());
        AppMethodBeat.m2505o(26372);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_NAICHA;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26373);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(26373);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26374);
        C4990ab.m7416i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26374);
    }
}
