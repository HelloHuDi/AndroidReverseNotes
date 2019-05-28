package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cxz;
import com.tencent.p177mm.protocal.protobuf.cya;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelappbrand.s */
public final class C37935s extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b fpJ;

    public C37935s(String str) {
        AppMethodBeat.m2504i(93743);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cxz();
        c1196a.fsK = new cya();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        this.fpJ = c1196a.acD();
        ((cxz) this.fpJ.fsG.fsP).xtu = str;
        AppMethodBeat.m2505o(93743);
    }

    public final cya abK() {
        if (this.fpJ != null) {
            return (cya) this.fpJ.fsH.fsP;
        }
        return null;
    }

    public final int getType() {
        return 1198;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93744);
        C4990ab.m7417i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(93744);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93745);
        C4990ab.m7416i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fpJ, this);
        AppMethodBeat.m2505o(93745);
        return a;
    }
}
