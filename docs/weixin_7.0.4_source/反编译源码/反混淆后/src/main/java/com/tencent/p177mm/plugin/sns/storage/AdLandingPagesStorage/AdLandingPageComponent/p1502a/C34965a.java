package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p1502a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15374qc;
import com.tencent.p177mm.protocal.protobuf.C7550qb;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a */
public final class C34965a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C34965a(String str, String str2) {
        AppMethodBeat.m2504i(37655);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7550qb();
        c1196a.fsK = new C15374qc();
        c1196a.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        this.ehh = c1196a.acD();
        C7550qb c7550qb = (C7550qb) this.ehh.fsG.fsP;
        c7550qb.vXf = str2;
        c7550qb.vXe = str;
        c7550qb.vXg = C5059g.dnY();
        AppMethodBeat.m2505o(37655);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(37656);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(37656);
    }

    public final int getType() {
        return this.ehh.fsI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(37657);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(37657);
        return a;
    }
}
