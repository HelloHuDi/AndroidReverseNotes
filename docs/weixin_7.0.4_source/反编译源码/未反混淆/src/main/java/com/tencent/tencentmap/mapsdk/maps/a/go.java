package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewConfiguration;
import com.tencent.map.lib.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class go implements gf {
    private final long a = 250;
    private final long b = 1200;
    private float c = ((float) ViewConfiguration.getMinimumFlingVelocity());
    private float d = ((float) ViewConfiguration.getMaximumFlingVelocity());
    private fn e;
    private boolean f;
    private float g;
    private e h;
    private boolean i = false;
    private final float j;
    private WeakReference<ge> k;

    public go(fn fnVar) {
        AppMethodBeat.i(99392);
        this.e = fnVar;
        this.k = fnVar.b();
        if (!(this.k == null || this.k.get() == null)) {
            ((ge) this.k.get()).a(this);
            Context i = ((ge) this.k.get()).i();
            if (i != null) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(i);
                this.c = (float) viewConfiguration.getScaledMinimumFlingVelocity();
                this.d = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            }
        }
        this.h = new e();
        this.j = fnVar.h() * 2.5f;
        AppMethodBeat.o(99392);
    }

    public void a(e eVar) {
        AppMethodBeat.i(99393);
        this.h = eVar;
        boolean a = eVar.a();
        if (this.k == null || this.k.get() != null) {
            AppMethodBeat.o(99393);
        } else if (a) {
            ((ge) this.k.get()).b(this);
            AppMethodBeat.o(99393);
        } else {
            ((ge) this.k.get()).a(this);
            AppMethodBeat.o(99393);
        }
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(99394);
        if (this.h.f()) {
            final gk a = this.e.a();
            a.a(f, f2, new Runnable() {
                public void run() {
                    AppMethodBeat.i(99387);
                    a.w();
                    AppMethodBeat.o(99387);
                }
            });
        }
        AppMethodBeat.o(99394);
        return false;
    }

    public boolean b(float f, float f2) {
        AppMethodBeat.i(99395);
        if (this.h.g()) {
            boolean m = m(f, f2);
            AppMethodBeat.o(99395);
            return m;
        }
        AppMethodBeat.o(99395);
        return false;
    }

    public void a() {
    }

    public boolean c(float f, float f2) {
        AppMethodBeat.i(99396);
        if (this.h.b() && this.h.c()) {
            l(f, f2);
        }
        AppMethodBeat.o(99396);
        return false;
    }

    public boolean d(float f, float f2) {
        AppMethodBeat.i(99397);
        if (this.h.b()) {
            this.e.a().a(f, f2);
        }
        AppMethodBeat.o(99397);
        return false;
    }

    public boolean e(float f, float f2) {
        return false;
    }

    public boolean f(float f, float f2) {
        AppMethodBeat.i(99398);
        if (this.h.f()) {
            this.g = this.e.a().l();
        }
        AppMethodBeat.o(99398);
        return false;
    }

    public boolean g(float f, float f2) {
        AppMethodBeat.i(99399);
        if (this.h.f()) {
            this.e.a().j((double) (b((1.0f - (f2 / ((float) this.e.g().height()))) * 10.0f) * this.g));
        }
        AppMethodBeat.o(99399);
        return true;
    }

    private static float b(float f) {
        if (f < 5.0f) {
            return 0.2f + ((0.8f * f) / 5.0f);
        }
        return 1.0f + (((f - 5.0f) * 4.0f) / 5.0f);
    }

    public boolean h(float f, float f2) {
        return false;
    }

    public boolean b() {
        AppMethodBeat.i(99400);
        if (this.h.h()) {
            final gk a = this.e.a();
            a.b(new Runnable() {
                public void run() {
                    AppMethodBeat.i(99388);
                    a.w();
                    AppMethodBeat.o(99388);
                }
            });
        }
        AppMethodBeat.o(99400);
        return false;
    }

    public boolean c() {
        AppMethodBeat.i(99401);
        if (this.f) {
            this.e.a().A();
            this.f = false;
        }
        AppMethodBeat.o(99401);
        return false;
    }

    public boolean a(float f) {
        AppMethodBeat.i(99402);
        if (!this.h.d()) {
            AppMethodBeat.o(99402);
            return false;
        } else if (this.e.a().B()) {
            this.e.a().i((double) ((f / 8.0f) * 2.0f));
            AppMethodBeat.o(99402);
            return true;
        } else {
            AppMethodBeat.o(99402);
            return false;
        }
    }

    public boolean d() {
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, float f) {
        AppMethodBeat.i(99403);
        if (this.h.e() && this.e.a().B()) {
            this.e.a().a((double) f, (double) pointF.x, (double) pointF.y, (double) pointF2.x, (double) pointF2.y);
        }
        AppMethodBeat.o(99403);
        return false;
    }

    public boolean a(PointF pointF, PointF pointF2, double d, double d2) {
        AppMethodBeat.i(99404);
        if (this.h.i()) {
            double d3 = d2 / d;
            final gk a = this.e.a();
            a.a(d3, (double) pointF.x, (double) pointF.y, (double) pointF2.x, (double) pointF2.y, new Runnable() {
                public void run() {
                    AppMethodBeat.i(99389);
                    a.w();
                    AppMethodBeat.o(99389);
                }
            });
        }
        AppMethodBeat.o(99404);
        return false;
    }

    public boolean i(float f, float f2) {
        AppMethodBeat.i(99405);
        this.e.a().A();
        AppMethodBeat.o(99405);
        return false;
    }

    public boolean j(float f, float f2) {
        return false;
    }

    public boolean k(float f, float f2) {
        return false;
    }

    private void l(float f, float f2) {
        AppMethodBeat.i(99406);
        this.i = true;
        if (this.f) {
            AppMethodBeat.o(99406);
            return;
        }
        float f3 = f / 64.0f;
        float f4 = f2 / 64.0f;
        if (Math.abs(f3) >= this.j || Math.abs(f4) >= this.j) {
            final long max = ((long) (((Math.max(Math.abs(f), Math.abs(f2)) - this.c) / (this.d - this.c)) * 950.0f)) + 250;
            final PointF pointF = new PointF(f3, f4);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f = true;
            this.e.a().b(new fx(3, new double[]{0.0d, 0.0d}) {
                public void b() {
                    AppMethodBeat.i(99390);
                    go.this.f = false;
                    AppMethodBeat.o(99390);
                }

                public boolean a() {
                    AppMethodBeat.i(99391);
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis > max) {
                        go.this.f = false;
                        AppMethodBeat.o(99391);
                        return true;
                    }
                    if (pointF.x != 0.0f) {
                        this.b[0] = fh.a(currentTimeMillis, pointF.x, -pointF.x, max);
                    }
                    if (pointF.y != 0.0f) {
                        this.b[1] = fh.a(currentTimeMillis, pointF.y, -pointF.y, max);
                    }
                    AppMethodBeat.o(99391);
                    return false;
                }
            });
            AppMethodBeat.o(99406);
            return;
        }
        AppMethodBeat.o(99406);
    }

    private boolean m(float f, float f2) {
        AppMethodBeat.i(99407);
        boolean a = this.e.c().a(this.e.d(), f, f2);
        AppMethodBeat.o(99407);
        return a;
    }
}
