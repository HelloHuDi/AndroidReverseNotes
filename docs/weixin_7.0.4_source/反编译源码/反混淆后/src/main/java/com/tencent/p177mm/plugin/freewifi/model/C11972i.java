package com.tencent.p177mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15325cf;
import com.tencent.p177mm.protocal.protobuf.C30173ce;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.freewifi.model.i */
public final class C11972i extends C1207m implements C1918k {
    private String csB;
    private final C7472b ehh;
    private C1202f ehi;

    private C11972i() {
        AppMethodBeat.m2504i(20734);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30173ce();
        c1196a.fsK = new C15325cf();
        c1196a.uri = "/cgi-bin/mmo2o-bin/addcontact";
        c1196a.fsI = 1703;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20734);
    }

    public C11972i(String str, String str2, int i, String str3) {
        this();
        AppMethodBeat.m2504i(20735);
        this.csB = str;
        C30173ce c30173ce = (C30173ce) this.ehh.fsG.fsP;
        c30173ce.vEn = str;
        c30173ce.Url = str2;
        c30173ce.vAM = i;
        c30173ce.vAN = str3;
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", str);
        AppMethodBeat.m2505o(20735);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(20736);
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.csB);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(20736);
    }

    public final int getType() {
        return 1703;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(20737);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(20737);
        return a;
    }
}
