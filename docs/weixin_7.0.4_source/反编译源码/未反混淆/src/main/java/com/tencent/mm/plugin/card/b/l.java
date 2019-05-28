package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class l implements f {
    public float ecs = -85.0f;
    public float ect = -1000.0f;
    private long updateTime = 0;

    public final void O(float f, float f2) {
        AppMethodBeat.i(87756);
        this.ecs = f;
        this.ect = f2;
        this.updateTime = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(87756);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87758);
        ab.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        g.RO().eJo.b(1253, (f) this);
        AppMethodBeat.o(87758);
    }

    public final void s(String str, String str2, int i) {
        AppMethodBeat.i(87757);
        if ((System.currentTimeMillis() / 1000) - this.updateTime > 1800) {
            this.ecs = -85.0f;
            this.ect = -1000.0f;
            ab.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.ecs == -85.0f) {
            ab.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.ect == -1000.0f) {
            ab.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        g.RO().eJo.a(1253, (f) this);
        g.RO().eJo.a(new u(this.ecs, this.ect, str, str2, i), 0);
        AppMethodBeat.o(87757);
    }
}
