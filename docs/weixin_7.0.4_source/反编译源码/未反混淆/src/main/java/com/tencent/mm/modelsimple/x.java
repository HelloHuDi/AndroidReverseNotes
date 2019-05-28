package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class x extends m implements k {
    public final b ehh;
    private f ehi;

    public x(String str, String str2, int i, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(123477);
        a aVar = new a();
        aVar.fsJ = new byf();
        aVar.fsK = new byg();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        this.ehh = aVar.acD();
        byf byf = (byf) this.ehh.fsG.fsP;
        byf.luH = bo.and(str);
        byf.wdB = str2;
        byf.wXE = i;
        byf.vHH = sKBuiltinBuffer_t;
        ab.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", str, str2, Integer.valueOf(i), bo.ca(aa.a(sKBuiltinBuffer_t)));
        AppMethodBeat.o(123477);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(123478);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(123478);
        return a;
    }

    public final int getType() {
        return 383;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(123479);
        ab.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(123479);
    }
}
