package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private f ehi;
    private final b fAT;
    public Object tag;

    public c(String str) {
        AppMethodBeat.i(62294);
        a aVar = new a();
        aVar.fsJ = new awp();
        aVar.fsK = new awq();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        this.fAT = aVar.acD();
        ((awp) this.fAT.fsG.fsP).Url = str;
        AppMethodBeat.o(62294);
    }

    public final int getType() {
        return 666;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(62295);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(62295);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(62296);
        ab.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(62296);
    }

    public final awq agd() {
        return (awq) this.fAT.fsH.fsP;
    }
}
