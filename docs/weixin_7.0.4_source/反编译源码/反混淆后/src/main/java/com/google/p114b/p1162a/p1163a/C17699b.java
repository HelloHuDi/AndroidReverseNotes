package com.google.p114b.p1162a.p1163a;

import com.google.p114b.p801b.C8727a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.a.a.b */
final class C17699b extends C45059g {
    private final short byo;
    private final short byp;

    C17699b(C45059g c45059g, int i, int i2) {
        super(c45059g);
        AppMethodBeat.m2504i(57192);
        this.byo = (short) i;
        this.byp = (short) i2;
        AppMethodBeat.m2505o(57192);
    }

    /* renamed from: a */
    public final void mo32775a(C8727a c8727a, byte[] bArr) {
        AppMethodBeat.m2504i(57193);
        short s = (short) 0;
        while (s < this.byp) {
            if (s == (short) 0 || (s == (short) 31 && this.byp <= (short) 62)) {
                c8727a.mo19742bA(31, 5);
                if (this.byp > (short) 62) {
                    c8727a.mo19742bA(this.byp - 31, 16);
                } else if (s == (short) 0) {
                    c8727a.mo19742bA(Math.min(this.byp, 31), 5);
                } else {
                    c8727a.mo19742bA(this.byp - 31, 5);
                }
            }
            c8727a.mo19742bA(bArr[this.byo + s], 8);
            s++;
        }
        AppMethodBeat.m2505o(57193);
    }

    public final String toString() {
        AppMethodBeat.m2504i(57194);
        String str = "<" + this.byo + "::" + ((this.byo + this.byp) - 1) + '>';
        AppMethodBeat.m2505o(57194);
        return str;
    }
}
