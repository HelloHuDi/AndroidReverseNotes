package com.tencent.p177mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35911dd;
import com.tencent.p177mm.protocal.protobuf.C35912de;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fcm.b */
public final class C34177b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C34177b(String str) {
        AppMethodBeat.m2504i(56435);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35911dd();
        c1196a.fsK = new C35912de();
        c1196a.uri = "/cgi-bin/micromsg-bin/androidfcmreg";
        this.ehh = c1196a.acD();
        ((C35911dd) this.ehh.fsG.fsP).vAK = str;
        AppMethodBeat.m2505o(56435);
    }

    public final int getType() {
        return 216;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(56436);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(56436);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(56437);
        C4990ab.m7416i("MicroMsg.FCM.NetSceneFcmReg", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(56437);
    }
}
