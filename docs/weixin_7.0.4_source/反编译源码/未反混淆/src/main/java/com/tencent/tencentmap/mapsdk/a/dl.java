package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class dl implements cv {
    private dm a = null;
    private String b = "";
    private bc c = null;

    public dl(dm dmVar, bc bcVar, String str) {
        this.b = str;
        this.a = dmVar;
        this.c = bcVar;
    }

    public final void b() {
        AppMethodBeat.i(101059);
        if (this.c == null) {
            AppMethodBeat.o(101059);
            return;
        }
        this.c.a(this.b);
        AppMethodBeat.o(101059);
    }

    public final String c() {
        return this.b;
    }

    public final void a(List<db> list) {
        AppMethodBeat.i(101060);
        this.c.a(this.b, (List) list);
        this.a.a((List) list);
        AppMethodBeat.o(101060);
    }

    public final List<db> d() {
        AppMethodBeat.i(101061);
        List e = this.a.e();
        AppMethodBeat.o(101061);
        return e;
    }

    public final void a(float f) {
        AppMethodBeat.i(101062);
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.c.a(this.b, f);
        this.a.a(f);
        AppMethodBeat.o(101062);
    }

    public final float e() {
        AppMethodBeat.i(101063);
        float f = this.a.f();
        AppMethodBeat.o(101063);
        return f;
    }

    public final void a(int i) {
        AppMethodBeat.i(101064);
        this.c.a(this.b, i);
        this.a.a(i);
        AppMethodBeat.o(101064);
    }

    public final void a(cm cmVar) {
        AppMethodBeat.i(101065);
        this.c.a(this.b, cmVar);
        AppMethodBeat.o(101065);
    }

    public final int f() {
        AppMethodBeat.i(101066);
        int g = this.a.g();
        AppMethodBeat.o(101066);
        return g;
    }

    public final void b(int i) {
        AppMethodBeat.i(101067);
        this.c.b(this.b, (float) Math.max(0, i));
        this.a.d(Math.max(0, i));
        AppMethodBeat.o(101067);
    }

    public final int g() {
        AppMethodBeat.i(101068);
        int i = this.a.i();
        AppMethodBeat.o(101068);
        return i;
    }

    public final void a(boolean z) {
        AppMethodBeat.i(101069);
        this.c.a(this.b, z);
        this.a.a(z);
        AppMethodBeat.o(101069);
    }

    public final boolean h() {
        AppMethodBeat.i(101070);
        boolean k = this.a.k();
        AppMethodBeat.o(101070);
        return k;
    }

    public final List<Integer> i() {
        AppMethodBeat.i(101071);
        List x = this.a.x();
        AppMethodBeat.o(101071);
        return x;
    }

    public final void a(int i, db dbVar) {
        AppMethodBeat.i(101072);
        this.c.a(this.b, i, dbVar);
        AppMethodBeat.o(101072);
    }

    public final void b(boolean z) {
        AppMethodBeat.i(101073);
        this.c.b(this.b, z);
        AppMethodBeat.o(101073);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101074);
        if (obj instanceof dl) {
            boolean equals = this.b.equals(((dl) obj).b);
            AppMethodBeat.o(101074);
            return equals;
        }
        AppMethodBeat.o(101074);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(101075);
        int hashCode = this.b.hashCode();
        AppMethodBeat.o(101075);
        return hashCode;
    }

    public final List<j> a() {
        AppMethodBeat.i(101076);
        List b = this.c.b(this.b);
        AppMethodBeat.o(101076);
        return b;
    }

    public final boolean j() {
        AppMethodBeat.i(101077);
        if (this.a != null) {
            boolean w = this.a.w();
            AppMethodBeat.o(101077);
            return w;
        }
        AppMethodBeat.o(101077);
        return false;
    }

    public final int k() {
        AppMethodBeat.i(101078);
        int t = this.a.t();
        AppMethodBeat.o(101078);
        return t;
    }

    public final void c(int i) {
        AppMethodBeat.i(101079);
        if (i < di.a || i > di.c) {
            AppMethodBeat.o(101079);
            return;
        }
        this.c.b(this.b, i);
        this.a.f(i);
        AppMethodBeat.o(101079);
    }
}
