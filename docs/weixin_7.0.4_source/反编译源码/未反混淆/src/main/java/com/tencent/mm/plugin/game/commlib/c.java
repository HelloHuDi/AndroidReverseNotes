package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class c extends m implements k {
    private f ehi;
    private final b lty;

    public c() {
        AppMethodBeat.i(59403);
        a aVar = new a();
        aVar.fsJ = new ax();
        aVar.fsK = new ay();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        this.lty = aVar.acD();
        ax axVar = (ax) this.lty.fsG.fsP;
        axVar.nbs = aa.dor();
        String bCT = com.tencent.mm.plugin.game.a.a.a.bDb().bCT();
        if (bo.isNullOrNil(bCT)) {
            bCT = bo.gQ(ah.getContext());
        }
        axVar.guW = bCT;
        axVar.nbt = g.cdf;
        axVar.nbu = new d();
        axVar.nbu.mZp = VERSION.SDK_INT;
        axVar.nbu.mZq = YearClass.get(ah.getContext());
        ab.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", axVar.nbs, axVar.guW, Integer.valueOf(axVar.nbt), Integer.valueOf(axVar.nbu.mZp), Integer.valueOf(axVar.nbu.mZq));
        AppMethodBeat.o(59403);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(59404);
        ab.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            ay ayVar = (ay) ((b) qVar).fsH.fsP;
            if (ayVar == null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(59404);
                return;
            }
            a.a(ayVar);
            com.tencent.mm.plugin.game.commlib.c.a.bny();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(59404);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(59404);
    }

    public final int getType() {
        return 1311;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(59405);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(59405);
        return a;
    }
}
