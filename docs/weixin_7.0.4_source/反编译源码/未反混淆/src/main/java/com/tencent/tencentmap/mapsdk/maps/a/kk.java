package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class kk<T, S extends kt> {
    private final kj<T, S> a;
    private final int b;

    kk(kj<T, S> kjVar, int i) {
        this.a = kjVar;
        this.b = i;
    }

    /* Access modifiers changed, original: final */
    public final kj<T, S> a() {
        return this.a;
    }

    /* Access modifiers changed, original: final */
    public final int b() {
        return this.b;
    }

    /* Access modifiers changed, original: final */
    public final kk<T, S> c() {
        AppMethodBeat.i(100235);
        kk kkVar = new kk(this.a, this.b + 1);
        AppMethodBeat.o(100235);
        return kkVar;
    }
}
