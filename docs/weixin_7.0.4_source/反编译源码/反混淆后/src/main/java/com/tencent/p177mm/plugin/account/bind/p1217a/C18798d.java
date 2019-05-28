package com.tencent.p177mm.plugin.account.bind.p1217a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cja;
import com.tencent.p177mm.protocal.protobuf.cjb;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.account.bind.a.d */
public final class C18798d extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C18798d(String str) {
        AppMethodBeat.m2504i(13327);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cja();
        c1196a.fsK = new cjb();
        c1196a.uri = "/cgi-bin/micromsg-bin/unbindqq";
        c1196a.fsI = C31128d.MIC_PTU_ZIPAI_OKINAWA;
        this.ehh = c1196a.acD();
        ((cja) this.ehh.fsG.fsP).wdB = str;
        AppMethodBeat.m2505o(13327);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13328);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13328);
        return a;
    }

    public final int getType() {
        return C31128d.MIC_PTU_ZIPAI_OKINAWA;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13329);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13329);
    }
}
