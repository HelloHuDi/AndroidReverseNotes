package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.sdk.platformtools.ab;

public final class u extends m implements k {
    public b ehh;
    private f ehi;
    public String fwO;

    public u(String str, String str2) {
        AppMethodBeat.i(11450);
        a aVar = new a();
        aVar.fsJ = new awt();
        aVar.fsK = new awu();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        this.ehh = aVar.acD();
        awt awt = (awt) this.ehh.fsG.fsP;
        awt.wAZ = str;
        awt.wBa = str2;
        this.fwO = str;
        AppMethodBeat.o(11450);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11451);
        ab.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11451);
    }

    public final int getType() {
        return 674;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11452);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11452);
        return a;
    }

    public final awu aeM() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (awu) this.ehh.fsH.fsP;
    }
}
