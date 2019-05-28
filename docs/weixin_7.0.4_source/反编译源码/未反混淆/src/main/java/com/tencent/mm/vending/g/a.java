package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements b {
    public final void cR(Object obj) {
        AppMethodBeat.i(126009);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario interrupt()", new Object[0]);
        AppMethodBeat.o(126009);
    }

    public final void dMi() {
        AppMethodBeat.i(126010);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario pending()", new Object[0]);
        AppMethodBeat.o(126010);
    }

    public final void B(Object... objArr) {
        AppMethodBeat.i(126011);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario wormhole()", new Object[0]);
        AppMethodBeat.o(126011);
    }

    public final void resume() {
        AppMethodBeat.i(126012);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario resume()", new Object[0]);
        AppMethodBeat.o(126012);
    }
}
