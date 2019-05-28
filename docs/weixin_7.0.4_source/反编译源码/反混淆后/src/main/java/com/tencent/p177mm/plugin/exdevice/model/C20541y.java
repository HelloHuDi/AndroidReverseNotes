package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cjr;
import com.tencent.p177mm.protocal.protobuf.cjs;

/* renamed from: com.tencent.mm.plugin.exdevice.model.y */
public final class C20541y extends C1207m implements C1918k {
    private String ceI;
    private String cws;
    public String dFl;
    private C7472b ehh;
    private C1202f ehi;
    private int ltJ = 0;

    public C20541y(String str, String str2, String str3) {
        this.dFl = str3;
        this.ceI = str;
        this.cws = str2;
    }

    public final int getType() {
        return 1263;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19353);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjr();
        c1196a.fsK = new cjs();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        c1196a.fsI = 1263;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cjr cjr = (cjr) this.ehh.fsG.fsP;
        cjr.dFl = this.dFl;
        cjr.oYp = this.ceI;
        cjr.devicetype = this.cws;
        cjr.xij = this.ltJ;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19353);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19354);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19354);
    }
}
