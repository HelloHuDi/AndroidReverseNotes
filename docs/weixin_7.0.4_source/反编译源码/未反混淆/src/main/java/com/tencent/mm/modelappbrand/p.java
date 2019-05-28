package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends m implements k {
    private f eIc;
    public final b fpJ;

    public p(int i) {
        AppMethodBeat.i(93733);
        a aVar = new a();
        aVar.fsJ = new any();
        aVar.fsK = new anz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        this.fpJ = aVar.acD();
        ((any) this.fpJ.fsG.fsP).wsv = i;
        AppMethodBeat.o(93733);
    }

    public final anz abG() {
        return (anz) this.fpJ.fsH.fsP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93734);
        ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(93734);
    }

    public final int getType() {
        return 1145;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(93735);
        ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.fpJ, this);
        AppMethodBeat.o(93735);
        return a;
    }
}
