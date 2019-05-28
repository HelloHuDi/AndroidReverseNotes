package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.bvr;
import com.tencent.p177mm.protocal.protobuf.bvs;

/* renamed from: com.tencent.mm.plugin.setting.model.i */
public final class C21739i extends C1207m implements C1918k {
    private String ctj;
    private C1202f ehi;
    public byte[] qjF;
    public bvs qjI;

    public C21739i(String str) {
        this.ctj = str;
    }

    public C21739i(byte[] bArr) {
        this.qjF = bArr;
    }

    public final int getType() {
        return 1169;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126856);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        bvr bvr = new bvr();
        bvr.ctj = this.ctj;
        if (this.qjF != null) {
            bvr.wtt = C1946aa.m4152ad(this.qjF).getBuffer();
        }
        c1196a.fsJ = bvr;
        c1196a.fsK = new bvs();
        c1196a.fsI = 1169;
        c1196a.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(126856);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126857);
        this.qjI = (bvs) ((C7472b) c1929q).fsH.fsP;
        if (this.qjI.wcK != null) {
            i3 = this.qjI.wcK.cyE;
            str = this.qjI.wcK.cyF;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126857);
    }
}
