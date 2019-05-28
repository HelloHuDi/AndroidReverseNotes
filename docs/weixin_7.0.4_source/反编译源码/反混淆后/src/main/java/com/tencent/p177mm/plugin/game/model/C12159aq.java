package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.p731d.C39190bm;
import com.tencent.p177mm.plugin.game.p731d.C45991bl;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.aq */
public final class C12159aq extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C12159aq(int i, LinkedList<String> linkedList, int i2, boolean z) {
        AppMethodBeat.m2504i(111445);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C45991bl();
        c1196a.fsK = new C39190bm();
        c1196a.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        this.lty = c1196a.acD();
        C45991bl c45991bl = (C45991bl) this.lty.fsG.fsP;
        c45991bl.ncn = i;
        c45991bl.nco = 15;
        c45991bl.nbs = C4988aa.dor();
        c45991bl.guW = C5046bo.m7555gQ(C4996ah.getContext());
        c45991bl.ncp = i2;
        c45991bl.nbX = linkedList;
        c45991bl.ncq = z;
        AppMethodBeat.m2505o(111445);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111446);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111446);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111447);
        C4990ab.m7416i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111447);
    }

    public final int getType() {
        return 1218;
    }
}
