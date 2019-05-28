package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.p731d.C12120df;
import com.tencent.p177mm.plugin.game.p731d.C28192de;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.model.av */
public final class C39212av extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C39212av(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(111460);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C28192de();
        c1196a.fsK = new C12120df();
        c1196a.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        this.lty = c1196a.acD();
        C28192de c28192de = (C28192de) this.lty.fsG.fsP;
        c28192de.mZr = str;
        c28192de.nbs = str2;
        c28192de.mZo = str3;
        c28192de.mZD = z;
        AppMethodBeat.m2505o(111460);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111461);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111461);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111462);
        C4990ab.m7416i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111462);
    }

    public final int getType() {
        return 1219;
    }
}
