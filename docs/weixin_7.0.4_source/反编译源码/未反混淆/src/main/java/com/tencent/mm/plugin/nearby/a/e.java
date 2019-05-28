package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;

public final class e extends m implements k {
    final b ehh;
    private f ehi;

    public e(String str) {
        AppMethodBeat.i(55371);
        a aVar = new a();
        aVar.fsJ = new ayc();
        aVar.fsK = new ayd();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        aVar.fsL = FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE;
        aVar.fsM = 1000000184;
        this.ehh = aVar.acD();
        ((ayc) this.ehh.fsG.fsP).fLc = str;
        ab.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(str)));
        AppMethodBeat.o(55371);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(55372);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(55372);
        return a;
    }

    public final int getType() {
        return 377;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(55373);
        ab.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ayd ayd = (ayd) this.ehh.fsH.fsP;
        if (i2 != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(55373);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < ayd.vEh.size()) {
                h hVar = new h();
                hVar.username = ((ayb) ayd.vEh.get(i5)).jBB;
                hVar.frW = ((ayb) ayd.vEh.get(i5)).vXm;
                hVar.frV = ((ayb) ayd.vEh.get(i5)).vXn;
                hVar.cB(true);
                arrayList.add(hVar);
                i4 = i5 + 1;
            } else {
                o.act().aa(arrayList);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(55373);
                return;
            }
        }
    }
}
