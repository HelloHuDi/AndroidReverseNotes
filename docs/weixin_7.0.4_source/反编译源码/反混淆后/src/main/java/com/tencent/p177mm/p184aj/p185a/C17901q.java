package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.afp;
import com.tencent.p177mm.protocal.protobuf.afq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.q */
public final class C17901q extends C1207m implements C1918k {
    Object data;
    public C7472b ehh;
    private C1202f ehi;

    public C17901q(String str, Object obj) {
        AppMethodBeat.m2504i(11621);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afp();
        c1196a.fsK = new afq();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        this.ehh = c1196a.acD();
        ((afp) this.ehh.fsG.fsP).vNb = str;
        this.data = obj;
        AppMethodBeat.m2505o(11621);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11622);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11622);
    }

    public final int getType() {
        return 1354;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11623);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11623);
        return a;
    }
}
