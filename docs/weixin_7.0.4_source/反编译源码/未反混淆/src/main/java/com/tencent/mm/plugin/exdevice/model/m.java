package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends com.tencent.mm.ai.m implements k {
    private b ehh;
    private f ehi;
    private String ltA;
    private long ltB;
    private String ltC;
    private long ltD;

    public m(long j, String str, String str2, long j2) {
        this.ltB = j;
        this.ltC = str;
        this.ltA = str2;
        this.ltD = j2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19317);
        ab.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            Object obj;
            jt jtVar = (jt) this.ehh.fsH.fsP;
            asq asq = jtVar.vLi;
            String str2 = null;
            String str3 = null;
            if (asq != null) {
                str2 = asq.jBE;
                str3 = asq.vIk;
            }
            ab.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", str2, str3);
            if (ad.boW().dT(str3, str2) != null) {
                ab.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", str3, Boolean.valueOf(ad.boW().dU(str2, str3)));
                if (ad.boW().dU(str2, str3)) {
                    obj = 1;
                } else {
                    obj = null;
                }
            } else {
                obj = 1;
            }
            com.tencent.mm.plugin.exdevice.h.b bVar = new com.tencent.mm.plugin.exdevice.h.b();
            bVar.field_connProto = this.ltA;
            bVar.field_connStrategy = 1;
            bVar.field_closeStrategy = 1;
            bVar.field_url = "";
            f.a(bVar, asq, jtVar.vLj);
            if (bVar.field_mac == 0) {
                ab.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                bVar.field_mac = this.ltB;
            }
            if (obj != null) {
                ad.boW().b((c) bVar);
            } else {
                ad.boW().e(bVar);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19317);
    }

    public final int getType() {
        return 1262;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19318);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new js();
        aVar.fsK = new jt();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        aVar.fsI = 1262;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        js jsVar = (js) this.ehh.fsG.fsP;
        jsVar.mac = com.tencent.mm.plugin.exdevice.j.b.m20if(this.ltB);
        jsVar.vMh = this.ltC;
        jsVar.vMg = this.ltA;
        jsVar.vMi = this.ltD;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19318);
        return a;
    }
}
