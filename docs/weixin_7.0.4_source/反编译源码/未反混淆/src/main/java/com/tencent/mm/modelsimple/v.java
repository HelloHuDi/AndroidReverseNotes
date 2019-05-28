package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class v extends m implements k {
    private f ehi;
    private final q ftU;

    public v(int i, String str) {
        this(i, str, "");
    }

    public v(int i, String str, String str2) {
        AppMethodBeat.i(78596);
        this.ftU = new b();
        a aVar = (a) this.ftU.acF();
        aVar.vyK.jBB = r.Yz();
        bwd bwd = aVar.vyK;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            i = 64;
        }
        stringBuilder = stringBuilder.append(i).append(";");
        if (str == null) {
            str = "";
        }
        bwd.ncM = stringBuilder.append(str).toString();
        ab.d("MicroMsg.NetSceneSendCard", "content:" + aVar.vyK.ncM);
        Assert.assertTrue("empty sendcard", true);
        aVar.vyK.wIi = 64;
        if (str2 != null && str2.length() > 0) {
            aVar.vyK.wWU = str2;
        }
        AppMethodBeat.o(78596);
    }

    public v(String str) {
        AppMethodBeat.i(78597);
        this.ftU = new b();
        a aVar = (a) this.ftU.acF();
        aVar.vyK.jBB = r.Yz();
        aVar.vyK.ncM = str;
        ab.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(str)));
        aVar.vyK.wrF = bo.h((Integer) g.RP().Ry().get(66561, null));
        Assert.assertTrue("empty sendcard", true);
        aVar.vyK.wIi = 128;
        AppMethodBeat.o(78597);
    }

    public v(String str, boolean z, boolean z2) {
        int i;
        AppMethodBeat.i(78598);
        this.ftU = new b();
        a aVar = (a) this.ftU.acF();
        aVar.vyK.jBB = r.Yz();
        aVar.vyK.ncM = str;
        ab.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(str)));
        aVar.vyK.wrF = bo.h((Integer) g.RP().Ry().get(66561, null));
        int i2 = ((z ? 1 : 0) | 0) | 0;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        i = (i | i2) | 8;
        Assert.assertTrue("empty sendcard", true);
        aVar.vyK.wIi = i;
        AppMethodBeat.o(78598);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78599);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(78599);
        return a;
    }

    public final int getType() {
        return 26;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78600);
        this.ehi.onSceneEnd(i2, i3, qVar.ZS().vyn, this);
        AppMethodBeat.o(78600);
    }
}
