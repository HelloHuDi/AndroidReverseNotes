package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private b ehh = null;
    private com.tencent.mm.ai.f ehi = null;
    private cku rPv;

    public f(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        AppMethodBeat.i(93663);
        ab.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a aVar = new a();
        aVar.fsJ = new cku();
        aVar.fsK = new ckv();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.fsI = 1261;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.rPv = (cku) this.ehh.fsG.fsP;
        this.rPv.ceI = str;
        this.rPv.cws = str2;
        this.rPv.xiu = i;
        this.rPv.xiv = i2;
        this.rPv.bIb = i3;
        this.rPv.xiw = String.valueOf(n.cwD());
        this.rPv.xiy = str3;
        this.rPv.xiB = i4;
        AppMethodBeat.o(93663);
    }

    public final int getType() {
        return 1261;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(93664);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(93664);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93665);
        ab.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(93665);
    }
}
