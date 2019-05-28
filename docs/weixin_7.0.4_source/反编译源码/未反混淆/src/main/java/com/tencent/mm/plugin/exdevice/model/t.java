package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ab;

public final class t extends m implements k {
    private b ehh = null;
    private f ehi = null;

    public t(String str, String str2, String str3) {
        AppMethodBeat.i(19338);
        a aVar = new a();
        aVar.fsJ = new bup();
        aVar.fsK = new buq();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.fsI = 1706;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bup bup = (bup) this.ehh.fsG.fsP;
        bup.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        bup.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        bup.category = str3;
        AppMethodBeat.o(19338);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19339);
        ab.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19339);
    }

    public final int getType() {
        return 1706;
    }

    public final buq boS() {
        return (buq) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19340);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19340);
        return a;
    }
}
