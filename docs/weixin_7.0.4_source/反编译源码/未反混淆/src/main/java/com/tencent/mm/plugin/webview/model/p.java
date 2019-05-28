package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends m implements k {
    private f eIc;
    public final b ehh;

    public p(String str, String str2) {
        AppMethodBeat.i(6610);
        a aVar = new a();
        aVar.fsJ = new avl();
        aVar.fsK = new avm();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        this.ehh = aVar.acD();
        avl avl = (avl) this.ehh.fsG.fsP;
        avl.jBB = str2;
        avl.fKh = str;
        AppMethodBeat.o(6610);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6611);
        ab.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6611);
    }

    public final int getType() {
        return 1566;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6612);
        ab.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6612);
        return a;
    }
}
