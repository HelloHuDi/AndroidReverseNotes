package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.protocal.protobuf.bmc;

public final class e extends a implements h.a {
    private h nzq = null;

    public final int[] bHC() {
        return new int[0];
    }

    public final int getServiceType() {
        return 8;
    }

    public final void wO() {
        AppMethodBeat.i(21905);
        this.nzq = new h();
        this.nzq.nvS = this;
        com.tencent.mm.sdk.b.a.xxA.c(this.nzq);
        AppMethodBeat.o(21905);
    }

    public final void onDestroy() {
        AppMethodBeat.i(21906);
        com.tencent.mm.sdk.b.a.xxA.d(this.nzq);
        AppMethodBeat.o(21906);
    }

    public final void b(c cVar) {
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    public final void a(bmc bmc) {
        AppMethodBeat.i(21907);
        this.nwr.a(8, bmc, 0, 0);
        AppMethodBeat.o(21907);
    }
}
