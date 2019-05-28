package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.cin;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    public String ceI = null;
    b ehh = null;
    private f ehi = null;
    public int ltE = 0;

    public n(atr atr, String str, String str2, int i) {
        AppMethodBeat.i(19319);
        a aVar = new a();
        aVar.fsJ = new cim();
        aVar.fsK = new cin();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/transfermsgtodevice";
        aVar.fsI = 1717;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cim cim = (cim) this.ehh.fsG.fsP;
        cim.vIk = str;
        cim.wbq = str2;
        cim.xhs = atr;
        cim.xht = i;
        this.ceI = str2;
        this.ltE = i;
        AppMethodBeat.o(19319);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19320);
        ab.i("MicroMsg.exdevice.NetSceneGetAppMsgInfo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19320);
    }

    public final int getType() {
        return 1717;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19321);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19321);
        return a;
    }
}
