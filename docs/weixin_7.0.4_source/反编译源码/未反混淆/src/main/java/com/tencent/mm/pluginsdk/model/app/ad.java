package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public final class ad extends m implements k {
    public b ehh;
    private f ehi;

    public ad(int i, String str) {
        AppMethodBeat.i(79381);
        a aVar = new a();
        aVar.fsJ = new aze();
        aVar.fsK = new azf();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        this.ehh = aVar.acD();
        aze aze = (aze) this.ehh.fsG.fsP;
        aze.offset = i;
        aze.limit = 20;
        aze.lang = str;
        g.RQ();
        aze.wCY = String.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue());
        AppMethodBeat.o(79381);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79382);
        ab.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(79382);
    }

    public final int getType() {
        return 1060;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(79383);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(79383);
        return a;
    }
}
