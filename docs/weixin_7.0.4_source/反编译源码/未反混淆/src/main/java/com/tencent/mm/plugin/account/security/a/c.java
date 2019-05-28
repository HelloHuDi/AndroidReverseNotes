package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends m implements k {
    public String ceI;
    public String cws;
    public String deviceName;
    private b ehh;
    private f ehi;

    public c(String str, String str2, String str3) {
        AppMethodBeat.i(69831);
        a aVar = new a();
        aVar.fsJ = new cjz();
        aVar.fsK = new cka();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        this.ehh = aVar.acD();
        this.ceI = str;
        this.deviceName = str2;
        this.cws = str3;
        cjz cjz = (cjz) this.ehh.fsG.fsP;
        cjz.wcI = str;
        cjz.Name = str2;
        cjz.vIk = str3;
        AppMethodBeat.o(69831);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(69832);
        ab.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(69832);
    }

    public final int getType() {
        return 361;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(69833);
        if (bo.isNullOrNil(this.ceI) || bo.isNullOrNil(this.deviceName) || bo.isNullOrNil(this.cws)) {
            ab.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            AppMethodBeat.o(69833);
            return -1;
        }
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(69833);
        return a;
    }
}
