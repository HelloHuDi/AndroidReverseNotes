package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.any;
import com.tencent.p177mm.protocal.protobuf.anz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelappbrand.p */
public final class C32812p extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b fpJ;

    public C32812p(int i) {
        AppMethodBeat.m2504i(93733);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new any();
        c1196a.fsK = new anz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        this.fpJ = c1196a.acD();
        ((any) this.fpJ.fsG.fsP).wsv = i;
        AppMethodBeat.m2505o(93733);
    }

    public final anz abG() {
        return (anz) this.fpJ.fsH.fsP;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93734);
        C4990ab.m7417i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(93734);
    }

    public final int getType() {
        return 1145;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93735);
        C4990ab.m7416i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fpJ, this);
        AppMethodBeat.m2505o(93735);
        return a;
    }
}
