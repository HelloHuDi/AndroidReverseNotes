package com.tencent.p177mm.plugin.account.security.p880a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cjz;
import com.tencent.p177mm.protocal.protobuf.cka;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.security.a.c */
public final class C18847c extends C1207m implements C1918k {
    public String ceI;
    public String cws;
    public String deviceName;
    private C7472b ehh;
    private C1202f ehi;

    public C18847c(String str, String str2, String str3) {
        AppMethodBeat.m2504i(69831);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjz();
        c1196a.fsK = new cka();
        c1196a.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        this.ehh = c1196a.acD();
        this.ceI = str;
        this.deviceName = str2;
        this.cws = str3;
        cjz cjz = (cjz) this.ehh.fsG.fsP;
        cjz.wcI = str;
        cjz.Name = str2;
        cjz.vIk = str3;
        AppMethodBeat.m2505o(69831);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(69832);
        C4990ab.m7416i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(69832);
    }

    public final int getType() {
        return 361;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(69833);
        if (C5046bo.isNullOrNil(this.ceI) || C5046bo.isNullOrNil(this.deviceName) || C5046bo.isNullOrNil(this.cws)) {
            C4990ab.m7412e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            AppMethodBeat.m2505o(69833);
            return -1;
        }
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(69833);
        return a;
    }
}
