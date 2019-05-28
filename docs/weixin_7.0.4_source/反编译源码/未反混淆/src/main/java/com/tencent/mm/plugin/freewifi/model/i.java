package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    private String csB;
    private final b ehh;
    private f ehi;

    private i() {
        AppMethodBeat.i(20734);
        a aVar = new a();
        aVar.fsJ = new ce();
        aVar.fsK = new cf();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.fsI = 1703;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20734);
    }

    public i(String str, String str2, int i, String str3) {
        this();
        AppMethodBeat.i(20735);
        this.csB = str;
        ce ceVar = (ce) this.ehh.fsG.fsP;
        ceVar.vEn = str;
        ceVar.Url = str2;
        ceVar.vAM = i;
        ceVar.vAN = str3;
        ab.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", str);
        AppMethodBeat.o(20735);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(20736);
        ab.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.csB);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(20736);
    }

    public final int getType() {
        return 1703;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(20737);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(20737);
        return a;
    }
}
