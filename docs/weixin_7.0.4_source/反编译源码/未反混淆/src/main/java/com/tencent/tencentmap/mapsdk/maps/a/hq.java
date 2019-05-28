package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hq extends m {
    public String a = "";
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public String e = "";
    public String f = "";
    public int g = 0;

    public final void writeTo(l lVar) {
        AppMethodBeat.i(99567);
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.c, 2);
        lVar.a(this.d, 3);
        if (this.e != null) {
            lVar.a(this.e, 4);
        }
        if (this.f != null) {
            lVar.a(this.f, 5);
        }
        lVar.a(this.g, 6);
        AppMethodBeat.o(99567);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(99568);
        this.a = kVar.a(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(this.c, 2, true);
        this.d = kVar.a(this.d, 3, false);
        this.e = kVar.a(4, false);
        this.f = kVar.a(5, false);
        this.g = kVar.a(this.g, 6, false);
        AppMethodBeat.o(99568);
    }
}
