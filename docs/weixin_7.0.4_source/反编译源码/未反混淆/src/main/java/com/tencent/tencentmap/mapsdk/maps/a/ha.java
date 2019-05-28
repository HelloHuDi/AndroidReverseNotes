package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ha implements fv {
    private gm a = null;
    private gz b = null;
    private hf c = null;

    public ha(gm gmVar, hf hfVar) {
        this.a = gmVar;
        this.c = hfVar;
    }

    public void b() {
        AppMethodBeat.i(99514);
        if (this.a == null) {
            AppMethodBeat.o(99514);
            return;
        }
        this.a.a().a((fv) this);
        if (this.b == null) {
            this.b = new gz(this.a, this.c);
        }
        try {
            this.b.start();
            AppMethodBeat.o(99514);
        } catch (Exception e) {
            AppMethodBeat.o(99514);
        }
    }

    public void c() {
        AppMethodBeat.i(99515);
        if (this.b != null) {
            this.b.a();
        }
        AppMethodBeat.o(99515);
    }

    public void d() {
        AppMethodBeat.i(99516);
        if (this.b != null) {
            this.b.b();
            a();
        }
        AppMethodBeat.o(99516);
    }

    public void e() {
        AppMethodBeat.i(99517);
        if (this.a == null) {
            AppMethodBeat.o(99517);
            return;
        }
        this.a.a().b((fv) this);
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
        AppMethodBeat.o(99517);
    }

    public void a() {
        AppMethodBeat.i(99518);
        if (this.b != null) {
            synchronized (this.b) {
                try {
                    this.b.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99518);
                }
            }
            return;
        }
        AppMethodBeat.o(99518);
    }

    public void f() {
        AppMethodBeat.i(99519);
        e();
        AppMethodBeat.o(99519);
    }
}
