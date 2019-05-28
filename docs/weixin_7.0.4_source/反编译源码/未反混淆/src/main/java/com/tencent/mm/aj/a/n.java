package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    Object data;
    public b ehh;
    private f ehi;

    public n(String str, acr acr, Object obj) {
        AppMethodBeat.i(11612);
        a aVar = new a();
        aVar.fsJ = new un();
        aVar.fsK = new uo();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        this.ehh = aVar.acD();
        un unVar = (un) this.ehh.fsG.fsP;
        unVar.vNb = str;
        unVar.wcb = acr;
        this.data = obj;
        AppMethodBeat.o(11612);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11613);
        ab.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11613);
    }

    public final int getType() {
        return 1355;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11614);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11614);
        return a;
    }

    public final uo afm() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (uo) this.ehh.fsH.fsP;
    }

    public final un afn() {
        if (this.ehh == null || this.ehh.fsG.fsP == null) {
            return null;
        }
        return (un) this.ehh.fsG.fsP;
    }
}
