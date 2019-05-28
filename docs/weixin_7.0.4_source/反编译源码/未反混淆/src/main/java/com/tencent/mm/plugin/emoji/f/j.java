package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private f eIc;
    public final b ehh;
    public String kWN;
    private String kWO;

    public j(String str, String str2) {
        AppMethodBeat.i(53120);
        a aVar = new a();
        aVar.fsJ = new aih();
        aVar.fsK = new aii();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
        this.ehh = aVar.acD();
        this.kWN = str;
        this.kWO = str2;
        AppMethodBeat.o(53120);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53121);
        this.eIc = fVar;
        aih aih = (aih) this.ehh.fsG.fsP;
        aih.wot = this.kWN;
        aih.Md5 = this.kWO;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(53121);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53122);
        ab.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53122);
    }

    public final int getType() {
        return 368;
    }
}
