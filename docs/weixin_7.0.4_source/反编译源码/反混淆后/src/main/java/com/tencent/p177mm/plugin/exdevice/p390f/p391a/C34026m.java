package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cjt;
import com.tencent.p177mm.protocal.protobuf.cju;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.m */
public final class C34026m extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public String lvx;
    public String lvy;

    public C34026m(String str, String str2) {
        AppMethodBeat.m2504i(19469);
        this.lvx = str;
        this.lvy = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjt();
        c1196a.fsK = new cju();
        c1196a.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        c1196a.fsI = 1040;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cjt cjt = (cjt) this.ehh.fsG.fsP;
        cjt.wtC = str;
        cjt.lvy = str2;
        AppMethodBeat.m2505o(19469);
    }

    public final int getType() {
        return 1040;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19470);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19470);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19471);
        C4990ab.m7411d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19471);
    }
}
