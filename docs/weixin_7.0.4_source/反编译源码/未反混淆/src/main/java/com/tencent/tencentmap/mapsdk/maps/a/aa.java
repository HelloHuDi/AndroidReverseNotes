package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa extends ak {
    private static byte[] m;
    public byte a = (byte) 0;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public int f = 0;
    public byte[] g = null;
    public byte h = (byte) 0;
    public byte i = (byte) 0;
    public String j = "";
    public String k = "";
    public String l = "";

    public final void a(aj ajVar) {
        AppMethodBeat.i(98404);
        ajVar.a(this.a, 0);
        ajVar.a(this.b, 1);
        ajVar.a(this.c, 2);
        ajVar.a(this.d, 3);
        ajVar.a(this.e, 4);
        ajVar.a(this.f, 5);
        ajVar.a(this.g, 6);
        ajVar.a(this.h, 7);
        ajVar.a(this.i, 8);
        if (this.j != null) {
            ajVar.a(this.j, 9);
        }
        if (this.k != null) {
            ajVar.a(this.k, 10);
        }
        if (this.l != null) {
            ajVar.a(this.l, 11);
        }
        AppMethodBeat.o(98404);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98405);
        this.a = aiVar.a(this.a, 0, true);
        this.b = aiVar.a(1, true);
        this.c = aiVar.a(2, true);
        this.d = aiVar.a(3, true);
        this.e = aiVar.a(4, true);
        this.f = aiVar.a(this.f, 5, true);
        if (m == null) {
            byte[] bArr = new byte[1];
            m = bArr;
            bArr[0] = (byte) 0;
        }
        this.g = aiVar.b(6, true);
        this.h = aiVar.a(this.h, 7, true);
        this.i = aiVar.a(this.i, 8, true);
        this.j = aiVar.a(9, false);
        this.k = aiVar.a(10, false);
        this.l = aiVar.a(11, false);
        AppMethodBeat.o(98405);
    }
}
