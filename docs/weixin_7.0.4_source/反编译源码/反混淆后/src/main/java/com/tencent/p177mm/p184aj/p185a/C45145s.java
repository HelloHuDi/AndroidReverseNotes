package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aiv;
import com.tencent.p177mm.protocal.protobuf.aiw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.s */
public final class C45145s extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C45145s(String str) {
        AppMethodBeat.m2504i(11627);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aiv();
        c1196a.fsK = new aiw();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
        this.ehh = c1196a.acD();
        ((aiv) this.ehh.fsG.fsP).vNb = str;
        AppMethodBeat.m2505o(11627);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11628);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11628);
    }

    public final int getType() {
        return 1367;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11629);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11629);
        return a;
    }
}
