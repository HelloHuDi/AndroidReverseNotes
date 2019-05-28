package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class b extends m implements k {
    private f ehi;
    private List<String> lQs;

    public b(List<String> list) {
        this.lQs = list;
    }

    public final int getType() {
        return 583;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(126841);
        this.ehi = fVar;
        a aVar = new a();
        cu cuVar = new cu();
        ArrayList arrayList = new ArrayList();
        if (this.lQs != null) {
            for (int i = 0; i < this.lQs.size(); i++) {
                ciu ciu = new ciu();
                ciu.jBB = (String) this.lQs.get(i);
                arrayList.add(ciu);
            }
        }
        cuVar.vET.addAll(arrayList);
        aVar.fsJ = cuVar;
        aVar.fsK = new cv();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.fsI = 583;
        aVar.fsL = 0;
        aVar.fsL = 0;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(126841);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126840);
        this.fth = i;
        if (!(i2 == 0 && i3 == 0)) {
            ab.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126840);
    }
}
