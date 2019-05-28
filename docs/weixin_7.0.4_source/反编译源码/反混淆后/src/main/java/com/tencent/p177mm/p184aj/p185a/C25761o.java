package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.afn;
import com.tencent.p177mm.protocal.protobuf.afo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.o */
public final class C25761o extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    boolean fyf = false;

    public C25761o(String str, String str2) {
        AppMethodBeat.m2504i(11615);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afn();
        c1196a.fsK = new afo();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        c1196a.fsI = 1352;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        afn afn = (afn) this.ehh.fsG.fsP;
        afn.vMV = str;
        afn.vNb = str2;
        this.fyf = true;
        AppMethodBeat.m2505o(11615);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11616);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11616);
    }

    public final int getType() {
        return 1352;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11617);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11617);
        return a;
    }
}
