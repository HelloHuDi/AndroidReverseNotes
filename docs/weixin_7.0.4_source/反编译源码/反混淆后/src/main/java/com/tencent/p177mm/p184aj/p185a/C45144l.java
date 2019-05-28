package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23408ki;
import com.tencent.p177mm.protocal.protobuf.C44134kj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.l */
public final class C45144l extends C1207m implements C1918k {
    private Object data;
    public C7472b ehh;
    private C1202f ehi;

    public C45144l(String str, String str2, int i) {
        AppMethodBeat.m2504i(11606);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23408ki();
        c1196a.fsK = new C44134kj();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        this.ehh = c1196a.acD();
        C23408ki c23408ki = (C23408ki) this.ehh.fsG.fsP;
        c23408ki.vNb = str;
        c23408ki.ctj = str2;
        c23408ki.offset = i;
        this.data = null;
        AppMethodBeat.m2505o(11606);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11607);
        C4990ab.m7411d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11607);
    }

    public final int getType() {
        return 1364;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11608);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11608);
        return a;
    }
}
