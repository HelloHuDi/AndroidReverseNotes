package com.tencent.p177mm.plugin.emoji.p726f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aih;
import com.tencent.p177mm.protocal.protobuf.aii;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.f.j */
public final class C45856j extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;
    public String kWN;
    private String kWO;

    public C45856j(String str, String str2) {
        AppMethodBeat.m2504i(53120);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aih();
        c1196a.fsK = new aii();
        c1196a.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
        this.ehh = c1196a.acD();
        this.kWN = str;
        this.kWO = str2;
        AppMethodBeat.m2505o(53120);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53121);
        this.eIc = c1202f;
        aih aih = (aih) this.ehh.fsG.fsP;
        aih.wot = this.kWN;
        aih.Md5 = this.kWO;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(53121);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53122);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53122);
    }

    public final int getType() {
        return 368;
    }
}
