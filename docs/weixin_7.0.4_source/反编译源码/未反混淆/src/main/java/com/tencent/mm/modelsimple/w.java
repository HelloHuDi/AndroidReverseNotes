package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.sdk.platformtools.ab;

public final class w extends m implements k {
    private f ehi;
    public final b fAT;

    public w(int i, bre bre) {
        AppMethodBeat.i(16603);
        ab.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", Integer.valueOf(i), bre.wTy, Integer.valueOf(bre.lvf), Integer.valueOf(bre.jCt), Integer.valueOf(bre.wOI));
        a aVar = new a();
        aVar.fsJ = new bxz();
        aVar.fsK = new bya();
        aVar.uri = "/cgi-bin/micromsg-bin/setmsgremind";
        aVar.fsI = i.CTRL_INDEX;
        this.fAT = aVar.acD();
        bxz bxz = (bxz) this.fAT.fsG.fsP;
        if (i == 0) {
            i = 1;
        }
        bxz.nbk = i;
        bxz.wXC = bre;
        AppMethodBeat.o(16603);
    }

    public final int getType() {
        return i.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16604);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(16604);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16605);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", ((bya) this.fAT.fsH.fsP).wTy);
        } else {
            ab.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16605);
    }
}
