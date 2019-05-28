package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    public final b fSY;
    private f psJ;

    public c() {
        AppMethodBeat.i(24076);
        a aVar = new a();
        aVar.fsJ = new ajt();
        aVar.fsK = new aju();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        this.fSY = aVar.acD();
        AppMethodBeat.o(24076);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24077);
        ab.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.psJ.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24077);
    }

    public final int getType() {
        return 630;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24078);
        ab.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.psJ = fVar;
        int a = a(eVar, this.fSY, this);
        AppMethodBeat.o(24078);
        return a;
    }
}
