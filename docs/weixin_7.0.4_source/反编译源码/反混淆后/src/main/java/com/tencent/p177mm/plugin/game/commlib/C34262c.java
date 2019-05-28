package com.tencent.p177mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.commlib.p1403c.C28179a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.game.p731d.C20946ax;
import com.tencent.p177mm.plugin.game.p731d.C39195d;
import com.tencent.p177mm.plugin.game.p731d.C45990ay;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.plugin.game.commlib.c */
public final class C34262c extends C1207m implements C1918k {
    private C1202f ehi;
    private final C7472b lty;

    public C34262c() {
        AppMethodBeat.m2504i(59403);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C20946ax();
        c1196a.fsK = new C45990ay();
        c1196a.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        this.lty = c1196a.acD();
        C20946ax c20946ax = (C20946ax) this.lty.fsG.fsP;
        c20946ax.nbs = C4988aa.dor();
        String bCT = C20928a.bDb().bCT();
        if (C5046bo.isNullOrNil(bCT)) {
            bCT = C5046bo.m7555gQ(C4996ah.getContext());
        }
        c20946ax.guW = bCT;
        c20946ax.nbt = C5059g.cdf;
        c20946ax.nbu = new C39195d();
        c20946ax.nbu.mZp = VERSION.SDK_INT;
        c20946ax.nbu.mZq = YearClass.get(C4996ah.getContext());
        C4990ab.m7417i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", c20946ax.nbs, c20946ax.guW, Integer.valueOf(c20946ax.nbt), Integer.valueOf(c20946ax.nbu.mZp), Integer.valueOf(c20946ax.nbu.mZq));
        AppMethodBeat.m2505o(59403);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(59404);
        C4990ab.m7416i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            C45990ay c45990ay = (C45990ay) ((C7472b) c1929q).fsH.fsP;
            if (c45990ay == null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(59404);
                return;
            }
            C45985a.m85431a(c45990ay);
            C28179a.bny();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(59404);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(59404);
    }

    public final int getType() {
        return 1311;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(59405);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(59405);
        return a;
    }
}
