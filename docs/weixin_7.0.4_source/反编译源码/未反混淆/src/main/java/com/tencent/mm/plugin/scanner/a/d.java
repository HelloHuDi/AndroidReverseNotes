package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class d extends m implements k {
    private String cwg;
    public b ehh;
    private f ehi;
    private String kES;
    private int scene;

    public d(String str, int i, String str2) {
        this.cwg = str;
        this.scene = i;
        this.kES = str2;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(80834);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new kp();
        aVar.fsK = new kq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        kp kpVar = (kp) this.ehh.fsG.fsP;
        kpVar.ProductID = this.cwg;
        kpVar.Scene = this.scene;
        kpVar.vNG = this.kES;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80834);
        return a;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(80835);
        kp kpVar = (kp) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (kpVar.Scene < 0 || kpVar.ProductID == null || kpVar.ProductID.length() <= 0) {
            ab.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(kpVar.Scene));
            bVar = m.b.EFailed;
            AppMethodBeat.o(80835);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(80835);
        return bVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80836);
        ab.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80836);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
    }
}
