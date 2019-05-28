package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends m implements k {
    private f ehi = null;
    private b fAT;

    public a(List<aax> list) {
        AppMethodBeat.i(5321);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new qx();
        aVar.fsK = new qy();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.fsI = 405;
        aVar.fsL = 196;
        aVar.fsM = 1000000196;
        this.fAT = aVar.acD();
        qx qxVar = (qx) this.fAT.fsG.fsP;
        qxVar.vYb = new LinkedList();
        qxVar.vYb.addAll(list);
        qxVar.Scene = 1;
        ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", Integer.valueOf(list.size()));
        AppMethodBeat.o(5321);
    }

    public a(abi abi) {
        AppMethodBeat.i(5322);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new qx();
        aVar.fsK = new qy();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.fsI = 405;
        aVar.fsL = 196;
        aVar.fsM = 1000000196;
        this.fAT = aVar.acD();
        qx qxVar = (qx) this.fAT.fsG.fsP;
        qxVar.vYc = abi;
        qxVar.Scene = 2;
        ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", Integer.valueOf(abi.vEp));
        AppMethodBeat.o(5322);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(5323);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(5323);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(5324);
        ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        qy qyVar = (qy) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            Iterator it = qyVar.vYd.iterator();
            while (it.hasNext()) {
                qz qzVar = (qz) it.next();
                ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", Integer.valueOf(qzVar.vEp), Integer.valueOf(qzVar.Ret));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(5324);
            return;
        }
        ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", Integer.valueOf(i3), Integer.valueOf(i2));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(5324);
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 405;
    }
}
