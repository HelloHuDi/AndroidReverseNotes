package com.tencent.p177mm.plugin.webwx.p1071a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30253zp;
import com.tencent.p177mm.protocal.protobuf.C35971zo;

/* renamed from: com.tencent.mm.plugin.webwx.a.e */
public final class C23161e extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b fAT;
    public boolean uLe;

    public C23161e(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(26503);
        this.uLe = z;
        C1196a c1196a = new C1196a();
        C35971zo c35971zo = new C35971zo();
        C30253zp c30253zp = new C30253zp();
        c1196a.fsJ = c35971zo;
        c1196a.fsK = c30253zp;
        c1196a.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        c35971zo.weG = str;
        c35971zo.weR = str2;
        c35971zo.weT = z;
        this.fAT = c1196a.acD();
        AppMethodBeat.m2505o(26503);
    }

    public final int getType() {
        return 972;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26504);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(26504);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26505);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26505);
    }
}
