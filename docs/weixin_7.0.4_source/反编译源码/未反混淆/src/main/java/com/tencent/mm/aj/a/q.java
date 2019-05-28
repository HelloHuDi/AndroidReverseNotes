package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends m implements k {
    Object data;
    public b ehh;
    private f ehi;

    public q(String str, Object obj) {
        AppMethodBeat.i(11621);
        a aVar = new a();
        aVar.fsJ = new afp();
        aVar.fsK = new afq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        this.ehh = aVar.acD();
        ((afp) this.ehh.fsG.fsP).vNb = str;
        this.data = obj;
        AppMethodBeat.o(11621);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(11622);
        ab.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11622);
    }

    public final int getType() {
        return 1354;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11623);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11623);
        return a;
    }
}
