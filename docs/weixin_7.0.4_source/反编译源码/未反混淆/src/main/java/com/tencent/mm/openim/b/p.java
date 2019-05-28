package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends m implements k {
    private final b ehh;
    private f ehi;
    public String username;

    public p(String str, String str2) {
        AppMethodBeat.i(78878);
        a aVar = new a();
        this.username = str2;
        bcg bcg = new bcg();
        bcg.gfa = str;
        bcg.wGM = new bgc();
        bcg.wGM.userName = str2;
        aVar.fsJ = bcg;
        aVar.fsK = new bch();
        aVar.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
        this.ehh = aVar.acD();
        AppMethodBeat.o(78878);
    }

    public final int getType() {
        return 811;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78879);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78879);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78880);
        ab.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78880);
    }
}
