package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjt;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends com.tencent.mm.ai.m implements k {
    private b ehh = null;
    private f ehi = null;
    public String lvx;
    public String lvy;

    public m(String str, String str2) {
        AppMethodBeat.i(19469);
        this.lvx = str;
        this.lvy = str2;
        a aVar = new a();
        aVar.fsJ = new cjt();
        aVar.fsK = new cju();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.fsI = 1040;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cjt cjt = (cjt) this.ehh.fsG.fsP;
        cjt.wtC = str;
        cjt.lvy = str2;
        AppMethodBeat.o(19469);
    }

    public final int getType() {
        return 1040;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19470);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19470);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19471);
        ab.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19471);
    }
}
