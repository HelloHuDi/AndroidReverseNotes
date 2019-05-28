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
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class an extends m implements k {
    private f ehi;
    public final b lty;

    public an(String str, LinkedList<String> linkedList, n nVar, n nVar2, n nVar3, boolean z) {
        String str2;
        t tVar;
        AppMethodBeat.i(111436);
        ab.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", (String) it.next());
        }
        a aVar = new a();
        aVar.fsJ = new bd();
        aVar.fsK = new be();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4";
        aVar.fsI = 2994;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        bd bdVar = (bd) this.lty.fsG.fsP;
        bdVar.nbs = str;
        bdVar.nbX = linkedList;
        String ef = e.ef(ah.getContext());
        if (bo.isNullOrNil(ef)) {
            ef = bo.gQ(ah.getContext());
        }
        if (bo.isNullOrNil(i.countryCode)) {
            str2 = ef;
        } else {
            str2 = i.countryCode;
        }
        bdVar.guW = str2;
        if (nVar == null) {
            if (nVar2 != null) {
                nVar = nVar2;
            } else if (nVar3 != null) {
                nVar = nVar3;
            } else {
                nVar = null;
            }
        }
        bdVar.nbY = new t();
        if (nVar != null) {
            bdVar.nbY.nam = nVar.mWr.mXl;
            bdVar.nbY.fKh = nVar.field_appId;
            bdVar.nbY.mZo = nVar.mXc;
            if (nVar.field_msgType == 100) {
                bdVar.nbY.nao = nVar.mXb;
            } else {
                bdVar.nbY.nao = nVar.field_msgType;
            }
        }
        if (nVar2 != null) {
            tVar = bdVar.nbY;
            tVar.nan |= 1;
        }
        if (nVar3 != null) {
            tVar = bdVar.nbY;
            tVar.nan |= 2;
        }
        bdVar.nbZ = ((c) g.K(c.class)).bCY().bEw();
        bdVar.nca = z;
        bdVar.nbt = com.tencent.mm.sdk.platformtools.g.dnY() ? 1 : 0;
        ab.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", str2);
        if (!(bo.isNullOrNil(bdVar.guW) || "CN".equalsIgnoreCase(bdVar.guW))) {
            h.pYm.a(860, 7, 1, false);
        }
        AppMethodBeat.o(111436);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111437);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111437);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111438);
        ab.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111438);
    }

    public final int getType() {
        return 2994;
    }
}
