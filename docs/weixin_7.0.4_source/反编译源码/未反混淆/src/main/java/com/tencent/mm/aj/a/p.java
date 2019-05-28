package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p extends m implements k {
    public b ehh;
    private f ehi;
    Map<String, String> fyg = new HashMap();

    public p(LinkedList<ke> linkedList) {
        AppMethodBeat.i(11618);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            String str = keVar.vMV;
            String str2 = keVar.vNb;
            if (!(str2 == null || str == null)) {
                this.fyg.put(str, str2);
            }
        }
        a aVar = new a();
        aVar.fsJ = new afl();
        aVar.fsK = new afm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.fsI = 1365;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((afl) this.ehh.fsG.fsP).wmS = linkedList;
        AppMethodBeat.o(11618);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11619);
        ab.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11619);
    }

    public final int getType() {
        return 1365;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11620);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11620);
        return a;
    }
}
