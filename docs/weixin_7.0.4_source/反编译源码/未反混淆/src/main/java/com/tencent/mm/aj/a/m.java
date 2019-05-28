package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends com.tencent.mm.ai.m implements k {
    Object data;
    public b ehh;
    private f ehi;
    public String fye;

    public m(String str, String str2, String str3, Object obj) {
        AppMethodBeat.i(11609);
        a aVar = new a();
        aVar.fsJ = new ug();
        aVar.fsK = new uh();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        this.ehh = aVar.acD();
        ug ugVar = (ug) this.ehh.fsG.fsP;
        ugVar.wbO = str;
        ugVar.wbQ = str2;
        ugVar.wbP = str3;
        this.data = obj;
        AppMethodBeat.o(11609);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11610);
        ab.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11610);
    }

    public final int getType() {
        return 1315;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11611);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11611);
        return a;
    }

    public final uh afl() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (uh) this.ehh.fsH.fsP;
    }
}
