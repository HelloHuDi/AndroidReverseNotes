package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends m implements k {
    private Object data;
    public b ehh;
    private f ehi;

    public l(String str, String str2, int i) {
        AppMethodBeat.i(11606);
        a aVar = new a();
        aVar.fsJ = new ki();
        aVar.fsK = new kj();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        this.ehh = aVar.acD();
        ki kiVar = (ki) this.ehh.fsG.fsP;
        kiVar.vNb = str;
        kiVar.ctj = str2;
        kiVar.offset = i;
        this.data = null;
        AppMethodBeat.o(11606);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11607);
        ab.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11607);
    }

    public final int getType() {
        return 1364;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11608);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11608);
        return a;
    }
}
