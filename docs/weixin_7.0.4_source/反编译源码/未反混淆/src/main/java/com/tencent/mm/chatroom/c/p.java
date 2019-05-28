package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends m implements k {
    private final b ehh;
    private f ehi;
    public String username;

    public p(String str, String str2) {
        AppMethodBeat.i(103950);
        a aVar = new a();
        this.username = str2;
        cik cik = new cik();
        cik.vEf = str;
        cik.xhr = str2;
        aVar.fsJ = cik;
        aVar.fsK = new cil();
        aVar.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
        this.ehh = aVar.acD();
        AppMethodBeat.o(103950);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103951);
        ab.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103951);
    }

    public final int getType() {
        return 990;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103952);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103952);
        return a;
    }
}
