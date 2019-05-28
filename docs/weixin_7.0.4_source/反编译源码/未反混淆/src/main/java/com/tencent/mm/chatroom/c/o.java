package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.utils.TbsLog;

public final class o extends m implements k {
    private final b ehh;
    private f ehi;

    public o(String str, String str2) {
        AppMethodBeat.i(103947);
        a aVar = new a();
        bxt bxt = new bxt();
        bxt.vEf = str;
        bxt.wny = str2;
        aVar.fsJ = bxt;
        aVar.fsK = new bxu();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.fsI = TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
        this.ehh = aVar.acD();
        AppMethodBeat.o(103947);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103948);
        ab.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103948);
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103949);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103949);
        return a;
    }
}
