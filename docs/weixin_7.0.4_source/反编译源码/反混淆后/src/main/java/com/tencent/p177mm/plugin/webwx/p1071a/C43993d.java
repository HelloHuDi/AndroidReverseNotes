package com.tencent.p177mm.plugin.webwx.p1071a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35970zn;
import com.tencent.p177mm.protocal.protobuf.C46605zm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webwx.a.d */
public final class C43993d extends C1207m implements C1918k {
    private C1202f ehi;
    final C7472b fAT;

    public C43993d(String str) {
        AppMethodBeat.m2504i(26500);
        C1196a c1196a = new C1196a();
        C46605zm c46605zm = new C46605zm();
        C35970zn c35970zn = new C35970zn();
        c1196a.fsJ = c46605zm;
        c1196a.fsK = c35970zn;
        c1196a.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        this.fAT = c1196a.acD();
        c46605zm.weG = str;
        C4990ab.m7411d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", str);
        AppMethodBeat.m2505o(26500);
    }

    public final int getType() {
        return 971;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26501);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(26501);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26502);
        C4990ab.m7410d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26502);
    }
}
