package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b implements at {
    private a jqB = new a();

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public b() {
        AppMethodBeat.i(17106);
        AppMethodBeat.o(17106);
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(17107);
        ab.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        a.xxA.c(this.jqB.jqz);
        AppMethodBeat.o(17107);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(17108);
        ab.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        a.xxA.d(this.jqB.jqz);
        AppMethodBeat.o(17108);
    }
}
