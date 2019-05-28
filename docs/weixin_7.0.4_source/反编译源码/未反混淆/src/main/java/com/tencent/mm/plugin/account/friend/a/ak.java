package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ak extends m implements k {
    private final b ehh;
    private f ehi;

    public ak(String str) {
        AppMethodBeat.i(108484);
        a aVar = new a();
        aVar.fsJ = new bxv();
        aVar.fsK = new bxw();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        this.ehh = aVar.acD();
        ((bxv) this.ehh.fsG.fsP).vLJ = bo.and(str);
        ab.d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(str)));
        AppMethodBeat.o(108484);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108485);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108485);
        return a;
    }

    public final int getType() {
        return 382;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108486);
        ab.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108486);
    }
}
