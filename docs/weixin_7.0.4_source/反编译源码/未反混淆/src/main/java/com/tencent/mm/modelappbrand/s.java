package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.sdk.platformtools.ab;

public final class s extends m implements k {
    private f eIc;
    private final b fpJ;

    public s(String str) {
        AppMethodBeat.i(93743);
        a aVar = new a();
        aVar.fsJ = new cxz();
        aVar.fsK = new cya();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        this.fpJ = aVar.acD();
        ((cxz) this.fpJ.fsG.fsP).xtu = str;
        AppMethodBeat.o(93743);
    }

    public final cya abK() {
        if (this.fpJ != null) {
            return (cya) this.fpJ.fsH.fsP;
        }
        return null;
    }

    public final int getType() {
        return 1198;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93744);
        ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(93744);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(93745);
        ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.fpJ, this);
        AppMethodBeat.o(93745);
        return a;
    }
}
