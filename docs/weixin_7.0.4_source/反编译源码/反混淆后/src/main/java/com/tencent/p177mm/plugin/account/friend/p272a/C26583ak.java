package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bxv;
import com.tencent.p177mm.protocal.protobuf.bxw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ak */
public final class C26583ak extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C26583ak(String str) {
        AppMethodBeat.m2504i(108484);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxv();
        c1196a.fsK = new bxw();
        c1196a.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        this.ehh = c1196a.acD();
        ((bxv) this.ehh.fsG.fsP).vLJ = C5046bo.and(str);
        C4990ab.m7410d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(108484);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108485);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108485);
        return a;
    }

    public final int getType() {
        return 382;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108486);
        C4990ab.m7410d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108486);
    }
}
