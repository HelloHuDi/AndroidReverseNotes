package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    private b ehh;
    private f ehi;

    public n(String str, String str2) {
        AppMethodBeat.i(103944);
        a aVar = new a();
        aVar.fsJ = new btg();
        aVar.fsK = new bth();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        this.ehh = aVar.acD();
        btg btg = (btg) this.ehh.fsG.fsP;
        btg.wVm = str;
        btg.wVn = str2;
        AppMethodBeat.o(103944);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103945);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103945);
        return a;
    }

    public final int getType() {
        return 700;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103946);
        ab.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103946);
    }
}
