package com.tencent.p177mm.plugin.qqmail.p486b;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.qqmail.b.t */
public final class C28744t extends C1207m implements C1918k {
    public final boolean cPT;
    private C7472b ehh;
    private C1202f ehi;
    private String puC = "";

    public C28744t(boolean z, String str) {
        AppMethodBeat.m2504i(67985);
        this.cPT = z;
        this.puC = C5046bo.nullAsNil(str);
        AppMethodBeat.m2505o(67985);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(67986);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C34747ad();
        c1196a.fsK = new C39535ae();
        c1196a.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        c1196a.fsI = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C34747ad c34747ad = (C34747ad) this.ehh.fsG.fsP;
        c34747ad.pvD = this.cPT ? 1 : 2;
        c34747ad.pvE = this.puC;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(67986);
        return a;
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(67987);
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(17, Integer.valueOf(((C39535ae) this.ehh.fsH.fsP).pvD));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(67987);
    }
}
