package com.tencent.p177mm.plugin.label.p1277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23453vm;
import com.tencent.p177mm.protocal.protobuf.C46593vn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.label.b.b */
public final class C43235b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String nHx = null;

    public C43235b(String str) {
        AppMethodBeat.m2504i(22524);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23453vm();
        c1196a.fsK = new C46593vn();
        c1196a.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        c1196a.fsI = 636;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nHx = str;
        AppMethodBeat.m2505o(22524);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22525);
        C4990ab.m7411d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22525);
    }

    public final int getType() {
        return 636;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22526);
        this.ehi = c1202f;
        C23453vm c23453vm = (C23453vm) this.ehh.fsG.fsP;
        c23453vm.wcD = this.nHx;
        if (this.nHx == null || C5046bo.isNullOrNil(this.nHx)) {
            C4990ab.m7412e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            c1202f.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
            AppMethodBeat.m2505o(22526);
            return 0;
        }
        c23453vm.wcD = this.nHx;
        c23453vm.wcD = this.nHx;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(22526);
        return a;
    }
}
