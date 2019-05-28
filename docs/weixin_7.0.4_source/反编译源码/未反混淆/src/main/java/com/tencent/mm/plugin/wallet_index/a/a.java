package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.wallet_index.c.m;
import java.util.HashMap;

public class a implements at {
    private m tQP = new m();

    public a() {
        AppMethodBeat.i(48162);
        AppMethodBeat.o(48162);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(48163);
        com.tencent.mm.sdk.b.a.xxA.c(this.tQP.tRl);
        com.tencent.mm.sdk.b.a.xxA.c(this.tQP.tRm);
        AppMethodBeat.o(48163);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(48164);
        com.tencent.mm.sdk.b.a.xxA.d(this.tQP.tRl);
        com.tencent.mm.sdk.b.a.xxA.d(this.tQP.tRm);
        AppMethodBeat.o(48164);
    }
}
