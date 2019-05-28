package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.g;

public final class a extends m implements k {
    private b ehh;
    private f ehi;

    public a(String str, String str2) {
        AppMethodBeat.i(37655);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new qb();
        aVar.fsK = new qc();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        this.ehh = aVar.acD();
        qb qbVar = (qb) this.ehh.fsG.fsP;
        qbVar.vXf = str2;
        qbVar.vXe = str;
        qbVar.vXg = g.dnY();
        AppMethodBeat.o(37655);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(37656);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(37656);
    }

    public final int getType() {
        return this.ehh.fsI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(37657);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(37657);
        return a;
    }
}
