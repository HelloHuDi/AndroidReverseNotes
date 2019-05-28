package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.p731d.C34267bn;
import com.tencent.p177mm.plugin.game.p731d.C7505bo;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.model.ar */
public final class C12160ar extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C12160ar(int i, int i2, int i3) {
        AppMethodBeat.m2504i(111448);
        C4990ab.m7417i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C34267bn();
        c1196a.fsK = new C7505bo();
        c1196a.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        this.lty = c1196a.acD();
        C34267bn c34267bn = (C34267bn) this.lty.fsG.fsP;
        c34267bn.ncn = i;
        c34267bn.nco = 15;
        c34267bn.nbs = C4988aa.dor();
        c34267bn.ncv = i2;
        c34267bn.ncw = i3;
        AppMethodBeat.m2505o(111448);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111449);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111449);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111450);
        C4990ab.m7416i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111450);
    }

    public final int getType() {
        return 1220;
    }
}
