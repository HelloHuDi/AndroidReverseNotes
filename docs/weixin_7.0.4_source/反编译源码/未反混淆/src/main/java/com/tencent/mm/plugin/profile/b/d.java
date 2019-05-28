package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    public b ehh;
    private f ehi;

    public d(String str, boolean z) {
        AppMethodBeat.i(14672);
        a aVar = new a();
        aVar.fsJ = new cfr();
        aVar.fsK = new cfs();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        this.ehh = aVar.acD();
        cfr cfr = (cfr) this.ehh.fsG.fsP;
        cfr.vNb = str;
        cfr.xeS = z;
        AppMethodBeat.o(14672);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(14673);
        ab.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(14673);
    }

    public final int getType() {
        return 1394;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(14674);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(14674);
        return a;
    }

    public final cfs cay() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (cfs) this.ehh.fsH.fsP;
    }

    public final cfr caz() {
        if (this.ehh == null || this.ehh.fsG.fsP == null) {
            return null;
        }
        return (cfr) this.ehh.fsG.fsP;
    }
}
