package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r extends m implements k {
    Object data;
    public b ehh;
    private f ehi;
    Map<String, String> fyh = new HashMap();

    public r(LinkedList<lj> linkedList, Object obj) {
        AppMethodBeat.i(11624);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            lj ljVar = (lj) it.next();
            LinkedList linkedList2 = ljVar.vOW;
            String str = ljVar.vNb;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.fyh.put((String) it2.next(), str);
                }
            }
        }
        a aVar = new a();
        aVar.fsJ = new afr();
        aVar.fsK = new afs();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.fsI = 1353;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((afr) this.ehh.fsG.fsP).wmU = linkedList;
        this.data = obj;
        AppMethodBeat.o(11624);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11625);
        ab.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11625);
    }

    public final int getType() {
        return 1353;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11626);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11626);
        return a;
    }
}
