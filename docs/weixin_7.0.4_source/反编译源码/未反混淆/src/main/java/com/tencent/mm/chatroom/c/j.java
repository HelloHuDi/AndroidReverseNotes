package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.j.g;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    public String chatroomName;
    private final b ehh;
    private f ehi = null;
    public String ehr;
    public int ehs;
    public int eht;
    public int status;

    public j(String str) {
        AppMethodBeat.i(103928);
        a aVar = new a();
        aVar.fsJ = new ahe();
        aVar.fsK = new ahf();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.fsI = g.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.chatroomName = str;
        ((ahe) this.ehh.fsG.fsP).vEf = str;
        AppMethodBeat.o(103928);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103929);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103929);
        return a;
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103930);
        ahf ahf = (ahf) this.ehh.fsH.fsP;
        ab.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.status = ahf.jBT;
        this.ehr = ahf.wnK;
        this.eht = ahf.wnL;
        this.ehr = ahf.wnK;
        this.ehs = ahf.wnJ;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103930);
    }
}
