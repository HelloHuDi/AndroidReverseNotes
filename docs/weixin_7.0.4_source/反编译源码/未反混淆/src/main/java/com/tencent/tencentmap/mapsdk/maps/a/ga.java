package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ga implements gc {
    private gc a;

    public ga(gm gmVar, hf hfVar) {
        AppMethodBeat.i(98964);
        if (gmVar == null || hfVar == null) {
            AppMethodBeat.o(98964);
            return;
        }
        this.a = new gb(gmVar, hfVar);
        AppMethodBeat.o(98964);
    }

    public void a(boolean z) {
        AppMethodBeat.i(98965);
        if (this.a == null) {
            AppMethodBeat.o(98965);
            return;
        }
        this.a.a(z);
        AppMethodBeat.o(98965);
    }

    public boolean a() {
        AppMethodBeat.i(98966);
        if (this.a == null) {
            AppMethodBeat.o(98966);
            return false;
        }
        boolean a = this.a.a();
        AppMethodBeat.o(98966);
        return a;
    }

    public void b() {
        AppMethodBeat.i(98967);
        if (this.a == null) {
            AppMethodBeat.o(98967);
            return;
        }
        this.a.b();
        AppMethodBeat.o(98967);
    }

    public void c() {
        AppMethodBeat.i(98968);
        if (this.a == null) {
            AppMethodBeat.o(98968);
            return;
        }
        this.a.c();
        AppMethodBeat.o(98968);
    }

    public void d() {
        AppMethodBeat.i(98969);
        if (this.a == null) {
            AppMethodBeat.o(98969);
            return;
        }
        this.a.d();
        AppMethodBeat.o(98969);
    }

    public void e() {
        AppMethodBeat.i(98970);
        if (this.a == null) {
            AppMethodBeat.o(98970);
            return;
        }
        this.a.e();
        this.a = null;
        AppMethodBeat.o(98970);
    }
}
