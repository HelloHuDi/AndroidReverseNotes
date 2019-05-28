package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class dj implements cv {
    private dk a = null;
    private String b = "";
    private ba c = null;

    public dj(dk dkVar, ba baVar, String str) {
        this.b = str;
        this.a = dkVar;
        this.c = baVar;
    }

    public final void b() {
        AppMethodBeat.i(101037);
        if (this.c == null) {
            AppMethodBeat.o(101037);
            return;
        }
        this.c.a(this.b);
        AppMethodBeat.o(101037);
    }

    public final String c() {
        return this.b;
    }

    public final void a(List<db> list) {
        AppMethodBeat.i(101038);
        if (this.c == null) {
            AppMethodBeat.o(101038);
            return;
        }
        this.c.a(this.b, (List) list);
        this.a.a((Iterable) list);
        AppMethodBeat.o(101038);
    }

    public final List<db> d() {
        AppMethodBeat.i(101039);
        List a = this.a.a();
        AppMethodBeat.o(101039);
        return a;
    }

    public final void a(float f) {
        AppMethodBeat.i(101040);
        this.c.a(this.b, f);
        this.a.a(f);
        AppMethodBeat.o(101040);
    }

    public final float e() {
        AppMethodBeat.i(101041);
        float b = this.a.b();
        AppMethodBeat.o(101041);
        return b;
    }

    public final void a(int i) {
        AppMethodBeat.i(101042);
        this.c.b(this.b, i);
        this.a.a(i);
        AppMethodBeat.o(101042);
    }

    public final int f() {
        AppMethodBeat.i(101043);
        int c = this.a.c();
        AppMethodBeat.o(101043);
        return c;
    }

    public final void b(int i) {
        AppMethodBeat.i(101044);
        this.c.a(this.b, i);
        this.a.b(i);
        AppMethodBeat.o(101044);
    }

    public final int g() {
        AppMethodBeat.i(101045);
        int d = this.a.d();
        AppMethodBeat.o(101045);
        return d;
    }

    public final void c(int i) {
        AppMethodBeat.i(101046);
        this.c.b(this.b, (float) i);
        this.a.c(i);
        AppMethodBeat.o(101046);
    }

    public final float h() {
        AppMethodBeat.i(101047);
        float e = this.a.e();
        AppMethodBeat.o(101047);
        return e;
    }

    public final void a(boolean z) {
        AppMethodBeat.i(101048);
        this.c.a(this.b, z);
        this.a.a(z);
        AppMethodBeat.o(101048);
    }

    public final boolean i() {
        AppMethodBeat.i(101049);
        boolean f = this.a.f();
        AppMethodBeat.o(101049);
        return f;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101050);
        if (obj instanceof dj) {
            boolean equals = this.b.equals(((dj) obj).b);
            AppMethodBeat.o(101050);
            return equals;
        }
        AppMethodBeat.o(101050);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(101051);
        int hashCode = this.b.hashCode();
        AppMethodBeat.o(101051);
        return hashCode;
    }

    public final boolean a(db dbVar) {
        AppMethodBeat.i(101052);
        List d = d();
        if (d == null || d.size() < 3 || dbVar == null) {
            AppMethodBeat.o(101052);
            return false;
        }
        int size = d.size() - 1;
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= d.size()) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 < d.size()) {
                        if (((((db) d.get(i2)).a < dbVar.a && ((db) d.get(size)).a >= dbVar.a) || (((db) d.get(size)).a < dbVar.a && ((db) d.get(i2)).a >= dbVar.a)) && (((db) d.get(i2)).b <= dbVar.b || ((db) d.get(size)).b <= dbVar.b)) {
                            if (((db) d.get(i2)).b + (((dbVar.a - ((db) d.get(i2)).a) / (((db) d.get(size)).a - ((db) d.get(i2)).a)) * (((db) d.get(size)).b - ((db) d.get(i2)).b)) <= dbVar.b) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            z ^= i;
                        }
                        i = i2 + 1;
                        size = i2;
                    } else {
                        AppMethodBeat.o(101052);
                        return z;
                    }
                }
            } else if (((db) d.get(i2)).equals(dbVar)) {
                AppMethodBeat.o(101052);
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    public final List<j> a() {
        AppMethodBeat.i(101053);
        if (this.c != null) {
            List b = this.c.b(this.b);
            AppMethodBeat.o(101053);
            return b;
        }
        AppMethodBeat.o(101053);
        return null;
    }

    public final int j() {
        AppMethodBeat.i(101054);
        int h = this.a.h();
        AppMethodBeat.o(101054);
        return h;
    }

    public final void d(int i) {
        AppMethodBeat.i(101055);
        if (i < di.a || i > di.c) {
            AppMethodBeat.o(101055);
            return;
        }
        this.c.c(this.b, i);
        this.a.d(i);
        AppMethodBeat.o(101055);
    }
}
