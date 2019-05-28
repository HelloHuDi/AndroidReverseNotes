package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    private final b ehh;
    private f ehi;
    private final String geY;

    public g(String str) {
        AppMethodBeat.i(78852);
        a aVar = new a();
        aVar.fsJ = new ali();
        aVar.fsK = new alj();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
        this.ehh = aVar.acD();
        this.geY = str;
        ((ali) this.ehh.fsG.fsP).gfa = str;
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", str);
        AppMethodBeat.o(78852);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78853);
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78853);
    }

    public final int getType() {
        return 890;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78854);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78854);
        return a;
    }
}
