package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private final b ehh;
    private f ehi;

    public a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(13317);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new jm();
        aVar.fsK = new jn();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        aVar.fsI = JsApiChooseMultiMedia.CTRL_INDEX;
        this.ehh = aVar.acD();
        jm jmVar = (jm) this.ehh.fsG.fsP;
        jmVar.vIJ = 1;
        jmVar.vLk = i;
        jmVar.vLl = str;
        jmVar.vLm = str2;
        jmVar.vLn = str3;
        jmVar.vLo = str4;
        jmVar.vLp = str5;
        jmVar.vLq = str6;
        jmVar.vLr = str7;
        AppMethodBeat.o(13317);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13318);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13318);
        return a;
    }

    public final int getType() {
        return JsApiChooseMultiMedia.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13319);
        ab.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        jm jmVar = (jm) this.ehh.fsG.fsP;
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(286722, jmVar.vLm);
            g.RP().Ry().set(286721, jmVar.vLl);
            g.RP().Ry().set(286723, jmVar.vLn);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13319);
    }
}
