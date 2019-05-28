package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends m implements k {
    private final b ehh;
    private f ehi = null;

    public final int getType() {
        return 339;
    }

    public l(String str) {
        AppMethodBeat.i(103937);
        a aVar = new a();
        aVar.fsJ = new arw();
        aVar.fsK = new arx();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.fsI = 339;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((arw) this.ehh.fsG.fsP).ndF = str;
        ab.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(str)));
        AppMethodBeat.o(103937);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(103938);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(103938);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103939);
        ab.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            int intValue = ((Integer) g.RP().Ry().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                g.RP().Ry().set(135176, Integer.valueOf(intValue - 1));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(103939);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103939);
    }
}
