package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C16666c;
import com.tencent.p177mm.protocal.protobuf.cfv;
import com.tencent.p177mm.protocal.protobuf.cfw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.i */
public final class C43718i extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public int mStatus;
    public int sLm;

    public C43718i(int i) {
        AppMethodBeat.m2504i(26101);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cfv();
        c1196a.fsK = new cfw();
        c1196a.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        c1196a.fsI = C16666c.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((cfv) this.ehh.fsG.fsP).cAd = i;
        AppMethodBeat.m2505o(26101);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26102);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(26102);
        return a;
    }

    public final int getType() {
        return C16666c.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26103);
        C4990ab.m7410d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        cfw cfw = (cfw) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = cfw.wPr;
            this.sLm = cfw.xeV;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26103);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26103);
    }
}
