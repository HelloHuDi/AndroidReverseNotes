package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap extends m implements k {
    private f ehi;
    public final b lty;

    public ap(String str, LinkedList<String> linkedList, n nVar, n nVar2, n nVar3, boolean z) {
        String str2;
        t tVar;
        AppMethodBeat.i(111442);
        ab.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", (String) it.next());
        }
        bj bjVar = new bj();
        bjVar.nbs = str;
        bjVar.nbX = linkedList;
        String ef = e.ef(ah.getContext());
        if (bo.isNullOrNil(ef)) {
            ef = bo.gQ(ah.getContext());
        }
        if (bo.isNullOrNil(i.countryCode)) {
            str2 = ef;
        } else {
            str2 = i.countryCode;
        }
        bjVar.guW = str2;
        if (nVar == null) {
            if (nVar2 != null) {
                nVar = nVar2;
            } else if (nVar3 != null) {
                nVar = nVar3;
            } else {
                nVar = null;
            }
        }
        bjVar.nbY = new t();
        if (nVar != null) {
            bjVar.nbY.nam = nVar.mWr.mXl;
            bjVar.nbY.fKh = nVar.field_appId;
            bjVar.nbY.mZo = nVar.mXc;
            if (nVar.field_msgType == 100) {
                bjVar.nbY.nao = nVar.mXb;
            } else {
                bjVar.nbY.nao = nVar.field_msgType;
            }
        }
        if (nVar2 != null) {
            tVar = bjVar.nbY;
            tVar.nan |= 1;
        }
        if (nVar3 != null) {
            tVar = bjVar.nbY;
            tVar.nan |= 2;
        }
        bjVar.nbZ = ((c) g.K(c.class)).bCY().bEw();
        bjVar.nca = z;
        bjVar.nbt = com.tencent.mm.sdk.platformtools.g.dnY() ? 1 : 0;
        ab.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", str2);
        if (!bo.isNullOrNil(bjVar.guW) && "CN".equalsIgnoreCase(bjVar.guW)) {
            h.pYm.a(860, 8, 1, false);
        }
        a aVar = new a();
        aVar.fsJ = bjVar;
        aVar.fsK = new bk();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
        aVar.fsI = 2855;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        AppMethodBeat.o(111442);
    }

    public final int getType() {
        return 2855;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111443);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111443);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111444);
        ab.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111444);
    }
}
