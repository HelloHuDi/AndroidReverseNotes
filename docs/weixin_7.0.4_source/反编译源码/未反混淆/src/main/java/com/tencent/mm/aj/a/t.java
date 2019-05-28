package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class t extends m implements k {
    Object data;
    public b ehh;
    private f ehi;
    public String fye;

    public t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        AppMethodBeat.i(11630);
        a aVar = new a();
        aVar.fsJ = new aup();
        aVar.fsK = new auq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        this.ehh = aVar.acD();
        aup aup = (aup) this.ehh.fsG.fsP;
        aup.wbO = str;
        if (str2 == null) {
            str2 = "";
        }
        aup.wyL = str2;
        aup.wyM = linkedList;
        this.data = obj;
        AppMethodBeat.o(11630);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11631);
        ab.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11631);
    }

    public final int getType() {
        return 1389;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11632);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11632);
        return a;
    }

    public final auq afo() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (auq) this.ehh.fsH.fsP;
    }
}
