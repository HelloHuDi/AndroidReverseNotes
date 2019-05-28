package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.bvt;
import com.tencent.p177mm.protocal.protobuf.bvu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.v */
public final class C20538v extends C1207m implements C1918k {
    public C7472b ehh = null;
    private C1202f ehi = null;

    public C20538v(String str, String str2, String str3) {
        AppMethodBeat.m2504i(19344);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bvt();
        c1196a.fsK = new bvu();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        c1196a.fsI = 1270;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bvt bvt = (bvt) this.ehh.fsG.fsP;
        bvt.vLi = new asq();
        bvt.vLi.vIk = str;
        bvt.vLi.jBE = str2;
        bvt.wWE = str3;
        AppMethodBeat.m2505o(19344);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19345);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19345);
    }

    public final int getType() {
        return 1270;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19346);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19346);
        return a;
    }
}
