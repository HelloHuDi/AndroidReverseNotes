package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.m;
import java.util.List;

public final class de implements cv {
    private int a = -1;
    private boolean b = false;
    private df c = null;
    private String d = "";
    private boolean e = false;
    private at f = null;
    private boolean g = false;
    private int h = 0;
    private boolean i = false;
    private m j;
    private Object k;

    public de(df dfVar, at atVar, String str) {
        AppMethodBeat.i(100998);
        this.d = str;
        this.c = dfVar;
        this.f = atVar;
        this.i = dfVar.q();
        this.h = dfVar.p();
        this.k = this.c.u();
        AppMethodBeat.o(100998);
    }

    public final void b() {
        AppMethodBeat.i(100999);
        if (this.f == null) {
            AppMethodBeat.o(100999);
            return;
        }
        this.f.a(this.d);
        AppMethodBeat.o(100999);
    }

    public final String c() {
        return this.d;
    }

    public final void a(db dbVar) {
        AppMethodBeat.i(101000);
        if (this.f == null || dbVar == null) {
            AppMethodBeat.o(101000);
            return;
        }
        this.f.a(this.d, dbVar);
        this.c.a(dbVar);
        AppMethodBeat.o(101000);
    }

    public final boolean d() {
        AppMethodBeat.i(101001);
        boolean j = this.c.j();
        AppMethodBeat.o(101001);
        return j;
    }

    public final db e() {
        AppMethodBeat.i(101002);
        db b = this.f.b(this.d);
        if (b == null) {
            b = this.c.b();
        }
        AppMethodBeat.o(101002);
        return b;
    }

    public final void a(String str) {
        AppMethodBeat.i(101003);
        if (this.f == null) {
            AppMethodBeat.o(101003);
            return;
        }
        this.c.a(str);
        this.f.b(this.d, str);
        AppMethodBeat.o(101003);
    }

    public final String f() {
        AppMethodBeat.i(101004);
        String c = this.c.c();
        AppMethodBeat.o(101004);
        return c;
    }

    public final void b(String str) {
        AppMethodBeat.i(101005);
        if (this.f == null) {
            AppMethodBeat.o(101005);
            return;
        }
        this.c.b(str);
        this.f.a(this.d, str);
        AppMethodBeat.o(101005);
    }

    public final String g() {
        AppMethodBeat.i(101006);
        String d = this.c.d();
        AppMethodBeat.o(101006);
        return d;
    }

    public final float h() {
        AppMethodBeat.i(101007);
        float k = this.c.k();
        AppMethodBeat.o(101007);
        return k;
    }

    public final void a(boolean z) {
        AppMethodBeat.i(101008);
        if (this.f == null) {
            AppMethodBeat.o(101008);
            return;
        }
        this.f.a(this.d, z);
        at atVar = this.f;
        String str = this.d;
        boolean z2 = !z && o();
        atVar.c(str, z2);
        this.c.a(z);
        AppMethodBeat.o(101008);
    }

    public final boolean i() {
        AppMethodBeat.i(101009);
        boolean h = this.c.h();
        AppMethodBeat.o(101009);
        return h;
    }

    public final void j() {
        AppMethodBeat.i(101010);
        if (this.f == null) {
            AppMethodBeat.o(101010);
            return;
        }
        this.f.c(this.d);
        AppMethodBeat.o(101010);
    }

    public final void k() {
        AppMethodBeat.i(101011);
        if (this.f == null) {
            AppMethodBeat.o(101011);
            return;
        }
        this.f.d(this.d);
        AppMethodBeat.o(101011);
    }

    public final boolean l() {
        AppMethodBeat.i(101012);
        if (this.f == null) {
            AppMethodBeat.o(101012);
            return false;
        }
        boolean e = this.f.e(this.d);
        AppMethodBeat.o(101012);
        return e;
    }

    public final void a(float f, float f2) {
        AppMethodBeat.i(101013);
        if (this.f == null) {
            AppMethodBeat.o(101013);
            return;
        }
        this.f.a(this.d, f, f2);
        this.c.a(f, f2);
        AppMethodBeat.o(101013);
    }

    public final void b(boolean z) {
        AppMethodBeat.i(101014);
        if (this.f == null) {
            AppMethodBeat.o(101014);
            return;
        }
        this.f.b(this.d, z);
        this.c.b(z);
        AppMethodBeat.o(101014);
    }

    public final void a(cm cmVar) {
        AppMethodBeat.i(101015);
        if (this.f == null) {
            AppMethodBeat.o(101015);
            return;
        }
        this.f.a(this.d, cmVar);
        this.c.a(cmVar);
        AppMethodBeat.o(101015);
    }

    public final void a(float f) {
        AppMethodBeat.i(101016);
        if (this.f == null) {
            AppMethodBeat.o(101016);
            return;
        }
        this.f.a(this.d, f);
        this.c.a(f);
        AppMethodBeat.o(101016);
    }

    public final float m() {
        AppMethodBeat.i(101017);
        if (this.f == null) {
            AppMethodBeat.o(101017);
            return 0.0f;
        }
        float f = this.f.f(this.d);
        AppMethodBeat.o(101017);
        return f;
    }

    public final boolean n() {
        AppMethodBeat.i(101018);
        if (this.f == null) {
            AppMethodBeat.o(101018);
            return false;
        }
        boolean i = this.c.i();
        AppMethodBeat.o(101018);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101019);
        if (obj instanceof de) {
            boolean equals = this.d.equals(((de) obj).d);
            AppMethodBeat.o(101019);
            return equals;
        }
        AppMethodBeat.o(101019);
        return false;
    }

    public final void b(float f) {
        AppMethodBeat.i(101020);
        if (this.f == null) {
            AppMethodBeat.o(101020);
            return;
        }
        this.f.b(this.d, f);
        this.c.b(f);
        AppMethodBeat.o(101020);
    }

    /* Access modifiers changed, original: final */
    public final boolean o() {
        AppMethodBeat.i(101021);
        boolean g = this.f.g(this.d);
        AppMethodBeat.o(101021);
        return g;
    }

    public final void a(int i, int i2) {
        AppMethodBeat.i(101022);
        this.f.a(this.d, i, i2);
        this.f.a(this.d, false);
        this.c.a(false);
        AppMethodBeat.o(101022);
    }

    public final void c(float f) {
        AppMethodBeat.i(101023);
        this.f.c(this.d, f);
        this.c.c(f);
        AppMethodBeat.o(101023);
    }

    public final float p() {
        AppMethodBeat.i(101024);
        if (this.c != null) {
            float l = this.c.l();
            AppMethodBeat.o(101024);
            return l;
        }
        AppMethodBeat.o(101024);
        return 0.0f;
    }

    public final int a(Context context) {
        AppMethodBeat.i(101025);
        cm e = this.c.e();
        if (e == null) {
            AppMethodBeat.o(101025);
            return 0;
        }
        Bitmap a = e.a().a(context);
        if (a == null) {
            AppMethodBeat.o(101025);
            return 0;
        }
        int width = a.getWidth();
        AppMethodBeat.o(101025);
        return width;
    }

    public final int b(Context context) {
        AppMethodBeat.i(101026);
        cm e = this.c.e();
        if (e == null) {
            AppMethodBeat.o(101026);
            return 0;
        }
        Bitmap a = e.a().a(context);
        if (a == null) {
            AppMethodBeat.o(101026);
            return 0;
        }
        int height = a.getHeight();
        AppMethodBeat.o(101026);
        return height;
    }

    public final float q() {
        AppMethodBeat.i(101027);
        float f = this.c.f();
        AppMethodBeat.o(101027);
        return f;
    }

    public final float r() {
        AppMethodBeat.i(101028);
        float g = this.c.g();
        AppMethodBeat.o(101028);
        return g;
    }

    public final m s() {
        return this.j;
    }

    public final int hashCode() {
        AppMethodBeat.i(101029);
        int hashCode = this.d.hashCode();
        AppMethodBeat.o(101029);
        return hashCode;
    }

    public final List<j> a() {
        AppMethodBeat.i(101030);
        List h = this.f.h(this.d);
        AppMethodBeat.o(101030);
        return h;
    }

    public final void a(Object obj) {
        this.k = obj;
    }

    public final Object t() {
        return this.k;
    }

    public final void c(String str) {
        AppMethodBeat.i(101031);
        if (this.c != null) {
            this.c.c(str);
        }
        AppMethodBeat.o(101031);
    }

    public final String u() {
        AppMethodBeat.i(101032);
        if (this.c != null) {
            String w = this.c.w();
            AppMethodBeat.o(101032);
            return w;
        }
        AppMethodBeat.o(101032);
        return null;
    }

    public final int v() {
        AppMethodBeat.i(101033);
        int x = this.c.x();
        AppMethodBeat.o(101033);
        return x;
    }

    public final void a(int i) {
        AppMethodBeat.i(101034);
        if (i < di.a || i > di.c) {
            AppMethodBeat.o(101034);
            return;
        }
        this.f.a(this.d, i);
        this.c.a(i);
        AppMethodBeat.o(101034);
    }
}
