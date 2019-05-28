package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23407kg;
import com.tencent.p177mm.protocal.protobuf.cjl;
import com.tencent.p177mm.protocal.protobuf.cjm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.x */
public final class C25763x extends C1207m implements C1918k {
    Object data;
    public C7472b ehh;
    private C1202f ehi;

    public C25763x(String str, String str2, C23407kg c23407kg, C23407kg c23407kg2, Object obj) {
        AppMethodBeat.m2504i(11642);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjl();
        c1196a.fsK = new cjm();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        this.ehh = c1196a.acD();
        cjl cjl = (cjl) this.ehh.fsG.fsP;
        cjl.vNb = str;
        cjl.vMV = str2;
        cjl.xig = c23407kg;
        cjl.xih = c23407kg2;
        this.data = obj;
        AppMethodBeat.m2505o(11642);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11643);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11643);
    }

    public final int getType() {
        return 1357;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11644);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11644);
        return a;
    }
}
