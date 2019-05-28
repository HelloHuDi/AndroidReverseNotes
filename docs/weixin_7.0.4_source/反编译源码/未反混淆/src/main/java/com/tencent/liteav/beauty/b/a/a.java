package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends b {
    private int A = 0;
    private float B = 1.0f;
    private final float C = 0.7f;
    private float D = 0.8f;
    private float E = 2.0f;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private c r = null;
    private d s = null;
    private e t = null;
    private h u = null;
    private o v = null;
    private b w = null;
    private String x = "TXCBeauty2Filter";
    private int y = 0;
    private int z = 0;

    public boolean b(int i, int i2) {
        AppMethodBeat.i(66965);
        boolean c = c(i, i2);
        AppMethodBeat.o(66965);
        return c;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66966);
        if (this.e == i && this.f == i2) {
            AppMethodBeat.o(66966);
            return;
        }
        this.e = i;
        this.f = i2;
        c(i, i2);
        AppMethodBeat.o(66966);
    }

    public void c(int i) {
        AppMethodBeat.i(66967);
        if (this.t != null) {
            this.t.a(((float) i) / 10.0f);
        }
        this.y = i;
        g(i);
        AppMethodBeat.o(66967);
    }

    public void d(int i) {
        AppMethodBeat.i(66968);
        if (this.w != null) {
            this.w.a(((float) i) / 10.0f);
        }
        this.z = i;
        AppMethodBeat.o(66968);
    }

    public void e(int i) {
        AppMethodBeat.i(66969);
        if (this.w != null) {
            this.w.b(((float) i) / 10.0f);
        }
        this.A = i;
        AppMethodBeat.o(66969);
    }

    private void g(int i) {
        AppMethodBeat.i(66970);
        this.B = 1.0f - (((float) i) / 50.0f);
        if (this.u != null) {
            this.u.a(this.B);
        }
        AppMethodBeat.o(66970);
    }

    public void f(int i) {
        AppMethodBeat.i(66971);
        this.D = 0.7f + (((float) i) / 12.0f);
        TXCLog.i(this.x, "set mSharpenLevel ".concat(String.valueOf(i)));
        if (this.v != null) {
            this.v.a(this.D);
        }
        AppMethodBeat.o(66971);
    }

    public int b(int i) {
        AppMethodBeat.i(66972);
        if (1.0f != this.E) {
            GLES20.glViewport(0, 0, this.H, this.I);
        }
        int b = this.t.b(this.s.b(i), i);
        if (1.0f != this.E) {
            GLES20.glViewport(0, 0, this.F, this.G);
        }
        if (this.D > 0.7f) {
            b = this.v.b(b);
        }
        b = this.w.b(b, i);
        AppMethodBeat.o(66972);
        return b;
    }

    private boolean c(int i, int i2) {
        AppMethodBeat.i(66973);
        this.F = i;
        this.G = i2;
        this.H = i;
        this.I = i2;
        if (1.0f != this.E) {
            this.H = (int) (((float) this.H) / this.E);
            this.I = (int) (((float) this.I) / this.E);
        }
        TXCLog.i(this.x, "mResampleRatio " + this.E + " mResampleWidth " + this.H + " mResampleHeight " + this.I);
        if (this.w == null) {
            this.w = new b();
            this.w.a(true);
            if (!this.w.a()) {
                TXCLog.e(this.x, "mBeautyBlendFilter init failed!!, break init");
                AppMethodBeat.o(66973);
                return false;
            }
        }
        this.w.a(i, i2);
        if (this.s == null) {
            this.s = new d();
            this.s.a(true);
            if (!this.s.a()) {
                TXCLog.e(this.x, "m_horizontalFilter init failed!!, break init");
                AppMethodBeat.o(66973);
                return false;
            }
        }
        this.s.a(this.H, this.I);
        if (this.t == null) {
            boolean z;
            this.t = new e();
            this.t.a(true);
            if (1.0f == this.E) {
                z = false;
            } else {
                z = true;
            }
            this.t.b(z);
            if (!this.t.a()) {
                TXCLog.e(this.x, "m_verticalFilter init failed!!, break init");
                AppMethodBeat.o(66973);
                return false;
            }
        }
        this.t.a(this.H, this.I);
        if (this.u == null) {
            this.u = new h(1.0f);
            this.u.a(true);
            if (!this.u.a()) {
                TXCLog.e(this.x, "m_gammaFilter init failed!!, break init");
                AppMethodBeat.o(66973);
                return false;
            }
        }
        this.u.a(this.H, this.I);
        if (this.v == null) {
            this.v = new o();
            this.v.a(true);
            if (!this.v.a()) {
                TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
                AppMethodBeat.o(66973);
                return false;
            }
        }
        this.v.a(i, i2);
        AppMethodBeat.o(66973);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void q() {
        AppMethodBeat.i(66974);
        if (this.w != null) {
            this.w.d();
            this.w = null;
        }
        if (this.s != null) {
            this.s.d();
            this.s = null;
        }
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
        if (this.v != null) {
            this.v.d();
            this.v = null;
        }
        AppMethodBeat.o(66974);
    }

    public void e() {
        AppMethodBeat.i(66975);
        super.e();
        q();
        AppMethodBeat.o(66975);
    }
}
