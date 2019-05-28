package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.af;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c extends m implements k {
    private final b ehh;
    private f ehi;

    public c() {
        AppMethodBeat.i(22527);
        a aVar = new a();
        aVar.fsJ = new ahr();
        aVar.fsK = new ahs();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        this.ehh = aVar.acD();
        AppMethodBeat.o(22527);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4 = 0;
        AppMethodBeat.i(22528);
        ab.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(209408, Long.valueOf(System.currentTimeMillis()));
            ahs ahs = (ahs) this.ehh.fsH.fsP;
            if (!(ahs == null || ahs.vEm == null)) {
                LinkedList linkedList = ahs.vEm;
                ArrayList arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    axj axj = (axj) linkedList.get(i4);
                    af afVar = new af();
                    afVar.field_labelID = axj.wBr;
                    afVar.field_labelName = axj.wBq;
                    afVar.field_labelPYFull = g.vo(axj.wBq);
                    afVar.field_labelPYShort = g.vp(axj.wBq);
                    arrayList.add(afVar);
                    i4++;
                }
                e.bIZ().er(arrayList);
                e.bIZ().es(e.bIZ().et(arrayList));
            }
        } else {
            ab.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22528);
    }

    public final int getType() {
        return 639;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(22529);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(22529);
        return a;
    }
}
