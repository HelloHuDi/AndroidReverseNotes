package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.p731d.C12113av;
import com.tencent.p177mm.plugin.game.p731d.C28182au;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.model.at */
public final class C12161at extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b lty;

    public C12161at(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.m2504i(111454);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C28182au();
        c1196a.fsK = new C12113av();
        c1196a.uri = "/cgi-bin/mmgame-bin/gamereport";
        this.lty = c1196a.acD();
        C28182au c28182au = (C28182au) this.lty.fsG.fsP;
        c28182au.mZr = str;
        c28182au.nbk = i;
        c28182au.nbl = i2;
        c28182au.nbm = str2;
        c28182au.nbn = str3;
        c28182au.nbj = (int) (System.currentTimeMillis() / 1000);
        AppMethodBeat.m2505o(111454);
    }

    public final int getType() {
        return 1223;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111455);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111455);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111456);
        C4990ab.m7416i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111456);
    }
}
