package com.tencent.liteav.beauty.b.b;

import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends b {
    private b r = null;
    private p s = null;
    private String t = "TXCBeauty3Filter";
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;

    public boolean b(int i, int i2) {
        AppMethodBeat.i(67016);
        boolean c = c(i, i2);
        AppMethodBeat.o(67016);
        return c;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67017);
        if (this.e == i && this.f == i2) {
            AppMethodBeat.o(67017);
            return;
        }
        this.e = i;
        this.f = i2;
        c(i, i2);
        AppMethodBeat.o(67017);
    }

    private boolean c(int i, int i2) {
        AppMethodBeat.i(67018);
        if (this.r == null) {
            this.r = new b();
            this.r.a(true);
            if (!this.r.a()) {
                AppMethodBeat.o(67018);
                return false;
            }
        }
        this.r.a(i, i2);
        if (this.s == null) {
            this.s = new p();
            this.s.a(true);
            if (!this.s.a()) {
                AppMethodBeat.o(67018);
                return false;
            }
        }
        this.s.a(i, i2);
        AppMethodBeat.o(67018);
        return true;
    }

    public int b(int i) {
        AppMethodBeat.i(67019);
        if (this.u > 0.0f || this.v > 0.0f || this.w > 0.0f) {
            i = this.r.b(i);
        }
        if (this.x > 0.0f) {
            i = this.s.b(i);
        }
        AppMethodBeat.o(67019);
        return i;
    }

    public void c(int i) {
        AppMethodBeat.i(67020);
        this.u = ((float) i) / 10.0f;
        if (this.r != null) {
            this.r.a(this.u);
        }
        AppMethodBeat.o(67020);
    }

    public void d(int i) {
        AppMethodBeat.i(67021);
        this.v = ((float) i) / 10.0f;
        if (this.r != null) {
            this.r.b(this.v);
        }
        AppMethodBeat.o(67021);
    }

    public void e(int i) {
        AppMethodBeat.i(67022);
        this.w = ((float) i) / 10.0f;
        if (this.r != null) {
            this.r.c(this.w);
        }
        AppMethodBeat.o(67022);
    }

    public void f(int i) {
        AppMethodBeat.i(67023);
        this.x = ((float) i) / 20.0f;
        if (this.s != null) {
            this.s.a(this.x);
        }
        AppMethodBeat.o(67023);
    }

    /* Access modifiers changed, original: 0000 */
    public void q() {
        AppMethodBeat.i(67024);
        if (this.r != null) {
            this.r.e();
            this.r = null;
        }
        if (this.s != null) {
            this.s.e();
            this.s = null;
        }
        AppMethodBeat.o(67024);
    }

    public void e() {
        AppMethodBeat.i(67025);
        super.e();
        q();
        AppMethodBeat.o(67025);
    }
}
