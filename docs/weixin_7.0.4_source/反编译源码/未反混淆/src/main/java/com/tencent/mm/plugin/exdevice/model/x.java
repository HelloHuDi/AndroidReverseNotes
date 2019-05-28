package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.platformtools.ab;

public final class x extends m implements k {
    private b ehh;
    private f ehi;
    public asq ltI;

    public x(asq asq, int i) {
        AppMethodBeat.i(19350);
        this.ltI = asq;
        a aVar = new a();
        aVar.fsJ = new cjc();
        aVar.fsK = new cjd();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cjc cjc = (cjc) this.ehh.fsG.fsP;
        cjc.vLi = asq;
        cjc.vEq = i;
        AppMethodBeat.o(19350);
    }

    public final int getType() {
        return 537;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19351);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19351);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        cjd cjd;
        AppMethodBeat.i(19352);
        ab.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        i iVar = i.lto;
        i.hN(0);
        com.tencent.mm.plugin.exdevice.h.b Kv = ad.boW().Kv(this.ltI.jBE);
        if (Kv != null) {
            if (!(u.bpy().lqX == null || u.bpy().lqX.hZ(Kv.field_mac))) {
                ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ad.boW().dU(this.ltI.jBE, this.ltI.vIk)) {
                ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", this.ltI.jBE);
        }
        if (!(i2 == 0 && i3 == 0)) {
            ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", Integer.valueOf(537));
        }
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            cjd = null;
        } else {
            cjd = (cjd) this.ehh.fsH.fsP;
        }
        if (cjd == null) {
            ab.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19352);
    }
}
