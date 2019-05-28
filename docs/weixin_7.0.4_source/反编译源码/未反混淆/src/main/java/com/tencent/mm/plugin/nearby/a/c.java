package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends m implements k {
    private final b ehh;
    private f ehi;

    public c(int i, float f, float f2, int i2, int i3, String str, String str2) {
        AppMethodBeat.i(55363);
        if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
            ab.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(i)));
        }
        a aVar = new a();
        aVar.fsJ = new axz();
        aVar.fsK = new aya();
        aVar.uri = "/cgi-bin/micromsg-bin/lbsfind";
        aVar.fsI = 148;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        axz axz = (axz) this.ehh.fsG.fsP;
        axz.OpCode = i;
        axz.vRp = f;
        axz.vRq = f2;
        axz.wfG = i2;
        axz.wfH = str;
        axz.wfI = str2;
        axz.wfJ = i3;
        axz.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
        ab.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i2 + " gpsSource:" + i3 + " mac" + str + " cell:" + str2 + " ccdLen:" + axz.vIl.getILen());
        o.a(2001, f, f2, i2);
        AppMethodBeat.o(55363);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(55364);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(55364);
        return a;
    }

    public final int getType() {
        return 148;
    }

    public final int Ah() {
        return ((axz) this.ehh.fsG.fsP).OpCode;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(55365);
        ab.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aya aya = (aya) ((b) qVar).fsH.fsP;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= aya.woe.size()) {
                break;
            }
            h hVar = new h();
            hVar.username = ((axv) aya.woe.get(i5)).jBB;
            hVar.dtR = ((axv) aya.woe.get(i5)).vEE;
            hVar.frW = ((axv) aya.woe.get(i5)).vXm;
            hVar.frV = ((axv) aya.woe.get(i5)).vXn;
            hVar.cB(true);
            arrayList.add(hVar);
            i4 = i5 + 1;
        }
        com.tencent.mm.ah.o.act().aa(arrayList);
        if (Ah() == 1 || Ah() == 3 || Ah() == 4) {
            if (i2 == 0 || i3 != -2001) {
                g.RP().Ry().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (aya.wCg * 1000))));
            } else {
                g.RP().Ry().set(8210, Long.valueOf(0));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(55365);
                return;
            }
        } else if (Ah() == 2) {
            g.RP().Ry().set(8210, Long.valueOf(0));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(55365);
    }

    public final boolean bUX() {
        return ((aya) this.ehh.fsH.fsP).wCh == 1;
    }

    public final int bUY() {
        return ((aya) this.ehh.fsH.fsP).wCi;
    }

    public final List<axv> bUZ() {
        AppMethodBeat.i(55366);
        LinkedList<axv> linkedList = ((aya) this.ehh.fsH.fsP).woe;
        if (linkedList != null) {
            g.RN().QU();
            for (axv axv : linkedList) {
                com.tencent.mm.plugin.c.a.ask().Yn().ia(axv.jBB, axv.wlF);
            }
        }
        AppMethodBeat.o(55366);
        return linkedList;
    }
}
