package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends com.tencent.mm.ai.m implements k {
    private final b ehh;
    private f ehi;
    private final String geY;

    public m(String str, String str2) {
        AppMethodBeat.i(78868);
        a aVar = new a();
        aVar.fsJ = new btk();
        aVar.fsK = new btl();
        aVar.uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
        this.ehh = aVar.acD();
        this.geY = str;
        btk btk = (btk) this.ehh.fsG.fsP;
        btk.geY = str;
        btk.cGA = str2;
        ab.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", str, str2);
        AppMethodBeat.o(78868);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78869);
        ab.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.geY);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78869);
    }

    public final int getType() {
        return 772;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78870);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78870);
        return a;
    }
}
