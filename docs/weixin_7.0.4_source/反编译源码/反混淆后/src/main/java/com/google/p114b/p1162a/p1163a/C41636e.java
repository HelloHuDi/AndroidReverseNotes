package com.google.p114b.p1162a.p1163a;

import com.google.p114b.p801b.C8727a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.a.a.e */
final class C41636e extends C45059g {
    private final short byx;
    private final short value;

    C41636e(C45059g c45059g, int i, int i2) {
        super(c45059g);
        AppMethodBeat.m2504i(57137);
        this.value = (short) i;
        this.byx = (short) i2;
        AppMethodBeat.m2505o(57137);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo32775a(C8727a c8727a, byte[] bArr) {
        AppMethodBeat.m2504i(57138);
        c8727a.mo19742bA(this.value, this.byx);
        AppMethodBeat.m2505o(57138);
    }

    public final String toString() {
        AppMethodBeat.m2504i(57139);
        String str = "<" + Integer.toBinaryString(((this.value & ((1 << this.byx) - 1)) | (1 << this.byx)) | (1 << this.byx)).substring(1) + '>';
        AppMethodBeat.m2505o(57139);
        return str;
    }
}
