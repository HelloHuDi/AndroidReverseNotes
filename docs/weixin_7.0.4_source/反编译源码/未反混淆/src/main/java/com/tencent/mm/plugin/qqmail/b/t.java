package com.tencent.mm.plugin.qqmail.b;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bo;

public final class t extends m implements k {
    public final boolean cPT;
    private b ehh;
    private f ehi;
    private String puC = "";

    public t(boolean z, String str) {
        AppMethodBeat.i(67985);
        this.cPT = z;
        this.puC = bo.nullAsNil(str);
        AppMethodBeat.o(67985);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(67986);
        a aVar = new a();
        aVar.fsJ = new ad();
        aVar.fsK = new ae();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.fsI = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ad adVar = (ad) this.ehh.fsG.fsP;
        adVar.pvD = this.cPT ? 1 : 2;
        adVar.pvE = this.puC;
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(67986);
        return a;
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(67987);
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(17, Integer.valueOf(((ae) this.ehh.fsH.fsP).pvD));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(67987);
    }
}
