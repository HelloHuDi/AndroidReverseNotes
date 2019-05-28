package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab extends ak {
    private static byte[] j;
    public byte a = (byte) 0;
    public int b = 0;
    public byte[] c = null;
    public String d = "";
    public long e = 0;
    private byte f = (byte) 0;
    private byte g = (byte) 0;
    private String h = "";
    private String i = "";

    public final void a(aj ajVar) {
        AppMethodBeat.i(98406);
        ajVar.a(this.a, 0);
        ajVar.a(this.b, 1);
        ajVar.a(this.c, 2);
        ajVar.a(this.d, 3);
        ajVar.a(this.f, 4);
        ajVar.a(this.g, 5);
        ajVar.a(this.e, 6);
        if (this.h != null) {
            ajVar.a(this.h, 7);
        }
        if (this.i != null) {
            ajVar.a(this.i, 8);
        }
        AppMethodBeat.o(98406);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98407);
        this.a = aiVar.a(this.a, 0, true);
        this.b = aiVar.a(this.b, 1, true);
        if (j == null) {
            byte[] bArr = new byte[1];
            j = bArr;
            bArr[0] = (byte) 0;
        }
        this.c = aiVar.b(2, true);
        this.d = aiVar.a(3, true);
        this.f = aiVar.a(this.f, 4, true);
        this.g = aiVar.a(this.g, 5, true);
        this.e = aiVar.a(this.e, 6, true);
        this.h = aiVar.a(7, false);
        this.i = aiVar.a(8, false);
        AppMethodBeat.o(98407);
    }
}
