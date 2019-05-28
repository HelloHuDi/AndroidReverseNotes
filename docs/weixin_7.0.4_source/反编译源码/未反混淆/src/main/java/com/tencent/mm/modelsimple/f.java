package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import junit.framework.Assert;

public final class f extends m implements k {
    public byte[] content;
    private com.tencent.mm.ai.f ehi;
    public String fOt = "";
    private q ftU;

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.p.a fOu = new com.tencent.mm.protocal.p.a();
        private final b fOv = new b();

        public a() {
            AppMethodBeat.i(16567);
            AppMethodBeat.o(16567);
        }

        public final d ZR() {
            return this.fOu;
        }

        public final e ZS() {
            return this.fOv;
        }

        public final int getType() {
            return 10;
        }

        public final String getUri() {
            return null;
        }
    }

    public f(List<String> list, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(16568);
        boolean z2 = list.size() > 0 && bArr != null;
        Assert.assertTrue(z2);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = (String) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + ((String) list.get(i)).trim();
        }
        this.ftU = new a();
        com.tencent.mm.protocal.p.a aVar = (com.tencent.mm.protocal.p.a) this.ftU.acF();
        aVar.cAd = 111;
        aVar.bJt = 0;
        aVar.fQi = currentTimeMillis;
        Assert.assertTrue(str != null);
        aVar.vyw = str;
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        aVar.vyx = bArr;
        ab.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=".concat(String.valueOf(currentTimeMillis)));
        ab.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + o.t(bArr, 0));
        AppMethodBeat.o(16568);
    }

    public f(e eVar) {
        AppMethodBeat.i(16569);
        b bVar = (b) eVar;
        this.fOt = bVar.fOt;
        this.content = bVar.content;
        AppMethodBeat.o(16569);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(16570);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(16570);
        return a;
    }

    public final int getType() {
        return 10;
    }

    public final boolean acI() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16571);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16571);
    }
}
