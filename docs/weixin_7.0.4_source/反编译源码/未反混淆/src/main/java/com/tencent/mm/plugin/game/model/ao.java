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
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao extends m implements k {
    private f ehi;
    public final b lty;

    public ao(String str, LinkedList<String> linkedList, n nVar, n nVar2, n nVar3, boolean z) {
        String str2;
        t tVar;
        AppMethodBeat.i(111439);
        ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", (String) it.next());
        }
        bh bhVar = new bh();
        bhVar.nbs = str;
        bhVar.nbX = linkedList;
        String ef = e.ef(ah.getContext());
        if (bo.isNullOrNil(ef)) {
            ef = bo.gQ(ah.getContext());
        }
        if (bo.isNullOrNil(i.countryCode)) {
            str2 = ef;
        } else {
            str2 = i.countryCode;
        }
        bhVar.guW = str2;
        if (nVar == null) {
            if (nVar2 != null) {
                nVar = nVar2;
            } else if (nVar3 != null) {
                nVar = nVar3;
            } else {
                nVar = null;
            }
        }
        bhVar.nbY = new t();
        if (nVar != null) {
            bhVar.nbY.nam = nVar.mWr.mXl;
            bhVar.nbY.fKh = nVar.field_appId;
            bhVar.nbY.mZo = nVar.mXc;
            if (nVar.field_msgType == 100) {
                bhVar.nbY.nao = nVar.mXb;
            } else {
                bhVar.nbY.nao = nVar.field_msgType;
            }
        }
        if (nVar2 != null) {
            tVar = bhVar.nbY;
            tVar.nan |= 1;
        }
        if (nVar3 != null) {
            tVar = bhVar.nbY;
            tVar.nan |= 2;
        }
        bhVar.nbZ = ((c) g.K(c.class)).bCY().bEw();
        bhVar.nca = z;
        bhVar.nbt = com.tencent.mm.sdk.platformtools.g.dnY() ? 1 : 0;
        ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", str2);
        a aVar = new a();
        aVar.fsJ = bhVar;
        aVar.fsK = new bi();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
        aVar.fsI = 2586;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.lty = aVar.acD();
        AppMethodBeat.o(111439);
    }

    public final int getType() {
        return 2586;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111440);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111440);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111441);
        ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111441);
    }
}
