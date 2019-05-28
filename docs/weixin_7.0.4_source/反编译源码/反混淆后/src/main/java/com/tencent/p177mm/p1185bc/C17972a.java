package com.tencent.p177mm.p1185bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40584wk;
import com.tencent.p177mm.protocal.protobuf.C44187wj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.bc.a */
public final class C17972a extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C17972a(String str) {
        AppMethodBeat.m2504i(136855);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44187wj();
        c1196a.fsK = new C40584wk();
        c1196a.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        this.ehh = c1196a.acD();
        ((C44187wj) this.ehh.fsG.fsP).wcP = str;
        AppMethodBeat.m2505o(136855);
    }

    public final int getType() {
        return 576;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(136856);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(136856);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(136857);
        C4990ab.m7411d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(136857);
    }
}
