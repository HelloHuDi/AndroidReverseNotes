package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kf {
    private final int a;
    private final int b;
    private final kq c;
    private final ko d;

    public kf(int i, int i2, ko koVar, kq kqVar) {
        AppMethodBeat.i(100218);
        if (kqVar == null || koVar == null || i2 <= 2 || i <= 0 || i >= i2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(100218);
            throw illegalArgumentException;
        }
        this.d = koVar;
        this.a = i2;
        this.b = i;
        this.c = kqVar;
        AppMethodBeat.o(100218);
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final kq c() {
        return this.c;
    }

    public final ko d() {
        return this.d;
    }
}
