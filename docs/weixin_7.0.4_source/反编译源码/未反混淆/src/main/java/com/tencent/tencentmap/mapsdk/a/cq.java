package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.id;
import java.util.List;

public final class cq implements cv {
    private cr a = null;
    private String b = "";
    private bp c = null;

    public cq(cr crVar, bp bpVar, String str) {
        this.b = str;
        this.a = crVar;
        this.c = bpVar;
    }

    public final boolean a(db dbVar) {
        AppMethodBeat.i(100955);
        if (id.a(d(), dbVar) < e()) {
            AppMethodBeat.o(100955);
            return true;
        }
        AppMethodBeat.o(100955);
        return false;
    }

    public final void b() {
        AppMethodBeat.i(100956);
        if (this.c == null) {
            AppMethodBeat.o(100956);
            return;
        }
        this.c.a(this.b);
        AppMethodBeat.o(100956);
    }

    public final String c() {
        return this.b;
    }

    public final void b(db dbVar) {
        AppMethodBeat.i(100957);
        if (this.c == null) {
            AppMethodBeat.o(100957);
            return;
        }
        this.c.a(this.b, dbVar);
        this.a.a(dbVar);
        AppMethodBeat.o(100957);
    }

    public final db d() {
        AppMethodBeat.i(100958);
        db dbVar = new db(this.a.a().a, this.a.a().b);
        AppMethodBeat.o(100958);
        return dbVar;
    }

    public final void a(double d) {
        AppMethodBeat.i(100959);
        if (d < 0.0d) {
            AppMethodBeat.o(100959);
        } else if (this.c == null) {
            AppMethodBeat.o(100959);
        } else {
            this.c.a(this.b, d);
            this.a.a(d);
            AppMethodBeat.o(100959);
        }
    }

    public final double e() {
        AppMethodBeat.i(100960);
        double b = this.a.b();
        AppMethodBeat.o(100960);
        return b;
    }

    public final void a(float f) {
        AppMethodBeat.i(100961);
        if (f < 0.0f) {
            AppMethodBeat.o(100961);
            return;
        }
        this.c.a(this.b, f);
        this.a.a(f);
        AppMethodBeat.o(100961);
    }

    public final float f() {
        AppMethodBeat.i(100962);
        float c = this.a.c();
        AppMethodBeat.o(100962);
        return c;
    }

    public final void a(int i) {
        AppMethodBeat.i(100963);
        this.c.b(this.b, i);
        this.a.a(i);
        AppMethodBeat.o(100963);
    }

    public final int g() {
        AppMethodBeat.i(100964);
        int d = this.a.d();
        AppMethodBeat.o(100964);
        return d;
    }

    public final void b(int i) {
        AppMethodBeat.i(100965);
        this.c.a(this.b, i);
        this.a.b(i);
        AppMethodBeat.o(100965);
    }

    public final int h() {
        AppMethodBeat.i(100966);
        int e = this.a.e();
        AppMethodBeat.o(100966);
        return e;
    }

    public final void c(int i) {
        AppMethodBeat.i(100967);
        this.c.b(this.b, (float) i);
        this.a.c(i);
        AppMethodBeat.o(100967);
    }

    public final float i() {
        AppMethodBeat.i(100968);
        float f = (float) this.a.f();
        AppMethodBeat.o(100968);
        return f;
    }

    public final void a(boolean z) {
        AppMethodBeat.i(100969);
        this.c.a(this.b, z);
        this.a.a(z);
        AppMethodBeat.o(100969);
    }

    public final boolean j() {
        AppMethodBeat.i(100970);
        boolean g = this.a.g();
        AppMethodBeat.o(100970);
        return g;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100971);
        if (obj instanceof cq) {
            boolean equals = this.b.equals(((cq) obj).b);
            AppMethodBeat.o(100971);
            return equals;
        }
        AppMethodBeat.o(100971);
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final List<j> a() {
        AppMethodBeat.i(100972);
        if (this.c != null) {
            List b = this.c.b(this.b);
            AppMethodBeat.o(100972);
            return b;
        }
        AppMethodBeat.o(100972);
        return null;
    }

    public final int k() {
        AppMethodBeat.i(100973);
        int h = this.a.h();
        AppMethodBeat.o(100973);
        return h;
    }

    public final void d(int i) {
        AppMethodBeat.i(100974);
        if (i < di.a || i > di.c) {
            AppMethodBeat.o(100974);
            return;
        }
        this.c.c(this.b, i);
        this.a.d(i);
        AppMethodBeat.o(100974);
    }
}
