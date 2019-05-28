package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.azp;
import com.tencent.p177mm.protocal.protobuf.azq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.brandservice.b.d */
public final class C42793d extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C42793d(String str) {
        AppMethodBeat.m2504i(13833);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new azp();
        c1196a.fsK = new azq();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        this.ehh = c1196a.acD();
        ((azp) this.ehh.fsG.fsP).wxX = str;
        AppMethodBeat.m2505o(13833);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13834);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(13834);
    }

    public final int getType() {
        return 1031;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13835);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13835);
        return a;
    }
}
