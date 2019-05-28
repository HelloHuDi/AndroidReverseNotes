package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p731d.C28185bj;
import com.tencent.p177mm.plugin.game.p731d.C39189bk;
import com.tencent.p177mm.plugin.game.p731d.C39203t;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.ap */
public final class C34296ap extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C34296ap(String str, LinkedList<String> linkedList, C28229n c28229n, C28229n c28229n2, C28229n c28229n3, boolean z) {
        String str2;
        C39203t c39203t;
        AppMethodBeat.m2504i(111442);
        C4990ab.m7416i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C4990ab.m7417i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", (String) it.next());
        }
        C28185bj c28185bj = new C28185bj();
        c28185bj.nbs = str;
        c28185bj.nbX = linkedList;
        String ef = C20993e.m32279ef(C4996ah.getContext());
        if (C5046bo.isNullOrNil(ef)) {
            ef = C5046bo.m7555gQ(C4996ah.getContext());
        }
        if (C5046bo.isNullOrNil(C43191i.countryCode)) {
            str2 = ef;
        } else {
            str2 = C43191i.countryCode;
        }
        c28185bj.guW = str2;
        if (c28229n == null) {
            if (c28229n2 != null) {
                c28229n = c28229n2;
            } else if (c28229n3 != null) {
                c28229n = c28229n3;
            } else {
                c28229n = null;
            }
        }
        c28185bj.nbY = new C39203t();
        if (c28229n != null) {
            c28185bj.nbY.nam = c28229n.mWr.mXl;
            c28185bj.nbY.fKh = c28229n.field_appId;
            c28185bj.nbY.mZo = c28229n.mXc;
            if (c28229n.field_msgType == 100) {
                c28185bj.nbY.nao = c28229n.mXb;
            } else {
                c28185bj.nbY.nao = c28229n.field_msgType;
            }
        }
        if (c28229n2 != null) {
            c39203t = c28185bj.nbY;
            c39203t.nan |= 1;
        }
        if (c28229n3 != null) {
            c39203t = c28185bj.nbY;
            c39203t.nan |= 2;
        }
        c28185bj.nbZ = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEw();
        c28185bj.nca = z;
        c28185bj.nbt = C5059g.dnY() ? 1 : 0;
        C4990ab.m7417i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", str2);
        if (!C5046bo.isNullOrNil(c28185bj.guW) && "CN".equalsIgnoreCase(c28185bj.guW)) {
            C7060h.pYm.mo8378a(860, 8, 1, false);
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c28185bj;
        c1196a.fsK = new C39189bk();
        c1196a.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
        c1196a.fsI = 2855;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.lty = c1196a.acD();
        AppMethodBeat.m2505o(111442);
    }

    public final int getType() {
        return 2855;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111443);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(111443);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111444);
        C4990ab.m7416i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111444);
    }
}
