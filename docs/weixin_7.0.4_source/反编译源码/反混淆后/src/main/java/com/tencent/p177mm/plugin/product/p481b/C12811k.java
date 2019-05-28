package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.p177mm.protocal.protobuf.cad;
import com.tencent.p177mm.protocal.protobuf.cfl;
import com.tencent.p177mm.protocal.protobuf.cfm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.product.b.k */
public final class C12811k extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String phn;

    public C12811k(cad cad) {
        AppMethodBeat.m2504i(43997);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cfl();
        c1196a.fsK = new cfm();
        c1196a.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        c1196a.fsI = JsApiGetLabInfo.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((cfl) this.ehh.fsG.fsP).xeP = cad;
        AppMethodBeat.m2505o(43997);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43998);
        cfm cfm = (cfm) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + cfm.xeQ);
            this.phn = cfm.xeQ;
        }
        C4990ab.m7410d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(43998);
    }

    public final int getType() {
        return JsApiGetLabInfo.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43999);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43999);
        return a;
    }
}
