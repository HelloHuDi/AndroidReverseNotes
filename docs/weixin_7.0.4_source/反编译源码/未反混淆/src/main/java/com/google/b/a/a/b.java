package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b extends g {
    private final short byo;
    private final short byp;

    b(g gVar, int i, int i2) {
        super(gVar);
        AppMethodBeat.i(57192);
        this.byo = (short) i;
        this.byp = (short) i2;
        AppMethodBeat.o(57192);
    }

    public final void a(a aVar, byte[] bArr) {
        AppMethodBeat.i(57193);
        short s = (short) 0;
        while (s < this.byp) {
            if (s == (short) 0 || (s == (short) 31 && this.byp <= (short) 62)) {
                aVar.bA(31, 5);
                if (this.byp > (short) 62) {
                    aVar.bA(this.byp - 31, 16);
                } else if (s == (short) 0) {
                    aVar.bA(Math.min(this.byp, 31), 5);
                } else {
                    aVar.bA(this.byp - 31, 5);
                }
            }
            aVar.bA(bArr[this.byo + s], 8);
            s++;
        }
        AppMethodBeat.o(57193);
    }

    public final String toString() {
        AppMethodBeat.i(57194);
        String str = "<" + this.byo + "::" + ((this.byo + this.byp) - 1) + '>';
        AppMethodBeat.o(57194);
        return str;
    }
}
