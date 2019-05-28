package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class em implements dq, ek {
    private static em a = new em();
    private ek b;
    private dq c;
    private boolean d = false;

    static {
        AppMethodBeat.i(98797);
        AppMethodBeat.o(98797);
    }

    private em() {
    }

    public static em d() {
        return a;
    }

    public final void a() {
        AppMethodBeat.i(98791);
        this.b.a();
        AppMethodBeat.o(98791);
    }

    public final void a(int i) {
        AppMethodBeat.i(98793);
        this.b.a(i);
        AppMethodBeat.o(98793);
    }

    public final void a(dq dqVar) {
        this.c = dqVar;
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(98796);
        this.c.a(str, str2);
        AppMethodBeat.o(98796);
    }

    public final void a(String str, byte[] bArr, String str2) {
        AppMethodBeat.i(98795);
        this.c.a(str, bArr, str2);
        AppMethodBeat.o(98795);
    }

    public final void b() {
        AppMethodBeat.i(98792);
        this.b.b();
        AppMethodBeat.o(98792);
    }

    public final void c() {
        AppMethodBeat.i(98794);
        this.c.c();
        AppMethodBeat.o(98794);
    }

    public final synchronized void e() {
        AppMethodBeat.i(98790);
        if (this.d) {
            AppMethodBeat.o(98790);
        } else {
            this.b = ec.c();
            if (this.b != null) {
                this.b.a(this);
                this.b.e();
            }
            this.d = true;
            AppMethodBeat.o(98790);
        }
    }
}
