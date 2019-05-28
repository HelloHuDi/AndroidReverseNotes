package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class g extends m implements k {
    public int cvn;
    public int cvo;
    private b ehh;
    private f ehi;
    public boolean pZG = false;

    public g(int i, String str, int i2, int i3) {
        AppMethodBeat.i(80843);
        a aVar = new a();
        aVar.fsJ = new kw();
        aVar.fsK = new kx();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_QINSHUI;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        kw kwVar = (kw) this.ehh.fsG.fsP;
        kwVar.jCt = i;
        kwVar.vOm = str;
        kwVar.Scene = 1;
        this.cvn = i2;
        this.cvo = i3;
        ab.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(80843);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(80844);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(80844);
        return a;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(80845);
        kw kwVar = (kw) ((b) qVar).fsG.fsP;
        m.b bVar;
        if (kwVar.jCt < 0 || kwVar.vOm == null || kwVar.vOm.length() <= 0) {
            ab.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + kwVar.jCt + ", Barcode = %s" + kwVar.vOm);
            bVar = m.b.EFailed;
            AppMethodBeat.o(80845);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(80845);
        return bVar;
    }

    public final kx cgG() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (kx) this.ehh.fsH.fsP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(80846);
        ab.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(80846);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_QINSHUI;
    }
}
