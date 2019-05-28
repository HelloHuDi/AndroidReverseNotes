package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac extends ak implements Cloneable {
    public String a = "";
    public String b = "";
    public String c = "";
    public boolean d = true;
    public long e = 0;
    public long f = 0;
    public String g = "";
    public long h = 0;
    private int i = 0;

    public final void a(aj ajVar) {
        AppMethodBeat.i(98408);
        ajVar.a(this.a, 0);
        ajVar.a(this.b, 1);
        ajVar.a(this.c, 2);
        ajVar.a(this.d);
        ajVar.a(this.e, 4);
        ajVar.a(this.f, 5);
        ajVar.a(this.g, 6);
        ajVar.a(this.h, 7);
        ajVar.a(this.i, 8);
        AppMethodBeat.o(98408);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98409);
        this.a = aiVar.a(0, true);
        this.b = aiVar.a(1, true);
        this.c = aiVar.a(2, true);
        this.d = aiVar.a((byte) 0, 3, true) != (byte) 0;
        this.e = aiVar.a(this.e, 4, true);
        this.f = aiVar.a(this.f, 5, true);
        this.g = aiVar.a(6, true);
        this.h = aiVar.a(this.h, 7, true);
        this.i = aiVar.a(this.i, 8, false);
        AppMethodBeat.o(98409);
    }
}
