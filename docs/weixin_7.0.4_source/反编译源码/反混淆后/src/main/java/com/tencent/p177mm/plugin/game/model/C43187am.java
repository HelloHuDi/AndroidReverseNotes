package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.p731d.C34266ba;
import com.tencent.p177mm.plugin.game.p731d.C43159az;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.model.am */
public final class C43187am extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C43187am(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(111433);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C43159az();
        c1196a.fsK = new C34266ba();
        c1196a.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        this.lty = c1196a.acD();
        C43159az c43159az = (C43159az) this.lty.fsG.fsP;
        c43159az.nbs = str;
        c43159az.mZr = str2;
        c43159az.nbG = z;
        c43159az.nbI = true;
        AppMethodBeat.m2505o(111433);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111434);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111434);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111435);
        C4990ab.m7416i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111435);
    }

    public final int getType() {
        return 1217;
    }
}
