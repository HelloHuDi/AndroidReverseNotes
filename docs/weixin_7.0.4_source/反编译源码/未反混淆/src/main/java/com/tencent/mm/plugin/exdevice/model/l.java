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
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l extends m implements k {
    private b ehh = null;
    private f ehi = null;

    public l(String str, int i) {
        AppMethodBeat.i(19314);
        a aVar = new a();
        aVar.fsJ = new jk();
        aVar.fsK = new jl();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.fsI = 536;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        jk jkVar = (jk) this.ehh.fsG.fsP;
        jkVar.vKK = bo.nullAsNil(str);
        jkVar.vLh = bo.h(Integer.valueOf(i));
        AppMethodBeat.o(19314);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19315);
        ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            jl boP = boP();
            ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", boP.vLi.jBE, boP.vLi.vIk);
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = boP.vLj.vHO;
            objArr[1] = boP.vLj.wwm;
            objArr[2] = boP.vLj.vKF;
            objArr[3] = boP.vLj.wwn;
            objArr[4] = Integer.valueOf(boP.vLj.wwo);
            objArr[5] = boP.vEq == 0 ? "sync" : "async";
            ab.i(str2, str3, objArr);
            Object obj = null;
            if (ad.boW().dT(boP.vLj.wwm, boP.vLi.jBE) != null) {
                ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", boP.vLj.wwm, Boolean.valueOf(ad.boW().dU(boP.vLi.jBE, boP.vLj.wwm)));
                if (ad.boW().dU(boP.vLi.jBE, boP.vLj.wwm)) {
                    obj = 1;
                }
            } else {
                obj = 1;
            }
            com.tencent.mm.plugin.exdevice.h.b bVar = new com.tencent.mm.plugin.exdevice.h.b();
            f.a(bVar, boP.vLi, boP.vLj);
            bVar.field_url = "";
            com.tencent.mm.plugin.exdevice.service.f.a hT = u.bpx().hT(bVar.field_mac);
            if (hT != null && hT.cxs == 2) {
                ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ad.bpd();
                d.hH(bVar.field_mac);
                com.tencent.mm.plugin.exdevice.service.f bpx = u.bpx();
                long j = bVar.field_mac;
                if (bpx.lwJ.containsKey(Long.valueOf(j))) {
                    bpx.lwJ.remove(Long.valueOf(j));
                    ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", Long.valueOf(j));
                } else {
                    ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", Long.valueOf(j));
                }
            }
            if (obj != null) {
                ad.boW().b((c) bVar);
            } else {
                ad.boW().e(bVar);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19315);
    }

    public final int getType() {
        return 536;
    }

    public final jl boP() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (jl) this.ehh.fsH.fsP;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19316);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19316);
        return a;
    }
}
