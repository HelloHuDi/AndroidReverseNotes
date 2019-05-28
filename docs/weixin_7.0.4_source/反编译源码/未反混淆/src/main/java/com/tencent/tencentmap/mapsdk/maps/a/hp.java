package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hp extends m {
    public String a = "";
    public int b = 0;
    public String c = "";

    public hp(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public final void writeTo(l lVar) {
        AppMethodBeat.i(99565);
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        if (this.c != null) {
            lVar.a(this.c, 2);
        }
        AppMethodBeat.o(99565);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(99566);
        this.a = kVar.a(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(2, false);
        AppMethodBeat.o(99566);
    }
}
