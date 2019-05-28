package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e extends g {
    private final short byx;
    private final short value;

    e(g gVar, int i, int i2) {
        super(gVar);
        AppMethodBeat.i(57137);
        this.value = (short) i;
        this.byx = (short) i2;
        AppMethodBeat.o(57137);
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar, byte[] bArr) {
        AppMethodBeat.i(57138);
        aVar.bA(this.value, this.byx);
        AppMethodBeat.o(57138);
    }

    public final String toString() {
        AppMethodBeat.i(57139);
        String str = "<" + Integer.toBinaryString(((this.value & ((1 << this.byx) - 1)) | (1 << this.byx)) | (1 << this.byx)).substring(1) + '>';
        AppMethodBeat.o(57139);
        return str;
    }
}
