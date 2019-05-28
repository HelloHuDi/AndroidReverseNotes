package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bco;
import com.tencent.p177mm.protocal.protobuf.bcp;

/* renamed from: com.tencent.mm.plugin.setting.model.h */
public final class C28931h extends C1207m implements C1918k {
    private final String csB;
    private C1202f ehi;
    public final String qjG;
    public final int qjH;
    private final int scene;

    public C28931h(String str, String str2, int i, int i2) {
        this.csB = str;
        this.qjG = str2;
        this.qjH = i;
        this.scene = i2;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126854);
        bcp bcp = (bcp) ((C7472b) c1929q).fsH.fsP;
        this.ehi.onSceneEnd(i2, bcp.wcK.cyE, bcp.wcK.cyF, this);
        AppMethodBeat.m2505o(126854);
    }

    public final int getType() {
        return 1144;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126855);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        bco bco = new bco();
        bco.csB = this.csB;
        bco.wGP = this.qjG;
        bco.wGQ = this.qjH;
        c1196a.fsJ = bco;
        c1196a.uri = "/cgi-bin/mmbiz-bin/moduserauth";
        c1196a.fsK = new bcp();
        c1196a.fsI = 1144;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(126855);
        return a;
    }
}
