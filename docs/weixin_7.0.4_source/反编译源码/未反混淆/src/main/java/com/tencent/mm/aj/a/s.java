package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.sdk.platformtools.ab;

public final class s extends m implements k {
    public b ehh;
    private f ehi;

    public s(String str) {
        AppMethodBeat.i(11627);
        a aVar = new a();
        aVar.fsJ = new aiv();
        aVar.fsK = new aiw();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
        this.ehh = aVar.acD();
        ((aiv) this.ehh.fsG.fsP).vNb = str;
        AppMethodBeat.o(11627);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11628);
        ab.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11628);
    }

    public final int getType() {
        return 1367;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11629);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11629);
        return a;
    }
}
