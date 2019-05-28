package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewConfiguration;
import com.tencent.map.lib.C1016e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.go */
public class C41055go implements C44513gf {
    /* renamed from: a */
    private final long f16484a = 250;
    /* renamed from: b */
    private final long f16485b = 1200;
    /* renamed from: c */
    private float f16486c = ((float) ViewConfiguration.getMinimumFlingVelocity());
    /* renamed from: d */
    private float f16487d = ((float) ViewConfiguration.getMaximumFlingVelocity());
    /* renamed from: e */
    private C5876fn f16488e;
    /* renamed from: f */
    private boolean f16489f;
    /* renamed from: g */
    private float f16490g;
    /* renamed from: h */
    private C1016e f16491h;
    /* renamed from: i */
    private boolean f16492i = false;
    /* renamed from: j */
    private final float f16493j;
    /* renamed from: k */
    private WeakReference<C41052ge> f16494k;

    public C41055go(C5876fn c5876fn) {
        AppMethodBeat.m2504i(99392);
        this.f16488e = c5876fn;
        this.f16494k = c5876fn.mo12441b();
        if (!(this.f16494k == null || this.f16494k.get() == null)) {
            ((C41052ge) this.f16494k.get()).mo65136a(this);
            Context i = ((C41052ge) this.f16494k.get()).mo65138i();
            if (i != null) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(i);
                this.f16486c = (float) viewConfiguration.getScaledMinimumFlingVelocity();
                this.f16487d = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            }
        }
        this.f16491h = new C1016e();
        this.f16493j = c5876fn.mo12447h() * 2.5f;
        AppMethodBeat.m2505o(99392);
    }

    /* renamed from: a */
    public void mo65147a(C1016e c1016e) {
        AppMethodBeat.m2504i(99393);
        this.f16491h = c1016e;
        boolean a = c1016e.mo4026a();
        if (this.f16494k == null || this.f16494k.get() != null) {
            AppMethodBeat.m2505o(99393);
        } else if (a) {
            ((C41052ge) this.f16494k.get()).mo65137b(this);
            AppMethodBeat.m2505o(99393);
        } else {
            ((C41052ge) this.f16494k.get()).mo65136a(this);
            AppMethodBeat.m2505o(99393);
        }
    }

    /* renamed from: a */
    public boolean mo12458a(float f, float f2) {
        AppMethodBeat.m2504i(99394);
        if (this.f16491h.mo4031f()) {
            final C36894gk a = this.f16488e.mo12440a();
            a.mo58791a(f, f2, new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(99387);
                    a.mo58859w();
                    AppMethodBeat.m2505o(99387);
                }
            });
        }
        AppMethodBeat.m2505o(99394);
        return false;
    }

    /* renamed from: b */
    public boolean mo12463b(float f, float f2) {
        AppMethodBeat.m2504i(99395);
        if (this.f16491h.mo4032g()) {
            boolean m = m71398m(f, f2);
            AppMethodBeat.m2505o(99395);
            return m;
        }
        AppMethodBeat.m2505o(99395);
        return false;
    }

    /* renamed from: a */
    public void mo12455a() {
    }

    /* renamed from: c */
    public boolean mo12465c(float f, float f2) {
        AppMethodBeat.m2504i(99396);
        if (this.f16491h.mo4027b() && this.f16491h.mo4028c()) {
            m71397l(f, f2);
        }
        AppMethodBeat.m2505o(99396);
        return false;
    }

    /* renamed from: d */
    public boolean mo12467d(float f, float f2) {
        AppMethodBeat.m2504i(99397);
        if (this.f16491h.mo4027b()) {
            this.f16488e.mo12440a().mo58789a(f, f2);
        }
        AppMethodBeat.m2505o(99397);
        return false;
    }

    /* renamed from: e */
    public boolean mo12468e(float f, float f2) {
        return false;
    }

    /* renamed from: f */
    public boolean mo12469f(float f, float f2) {
        AppMethodBeat.m2504i(99398);
        if (this.f16491h.mo4031f()) {
            this.f16490g = this.f16488e.mo12440a().mo58848l();
        }
        AppMethodBeat.m2505o(99398);
        return false;
    }

    /* renamed from: g */
    public boolean mo12470g(float f, float f2) {
        AppMethodBeat.m2504i(99399);
        if (this.f16491h.mo4031f()) {
            this.f16488e.mo12440a().mo58846j((double) (C41055go.m71396b((1.0f - (f2 / ((float) this.f16488e.mo12446g().height()))) * 10.0f) * this.f16490g));
        }
        AppMethodBeat.m2505o(99399);
        return true;
    }

    /* renamed from: b */
    private static float m71396b(float f) {
        if (f < 5.0f) {
            return 0.2f + ((0.8f * f) / 5.0f);
        }
        return 1.0f + (((f - 5.0f) * 4.0f) / 5.0f);
    }

    /* renamed from: h */
    public boolean mo12471h(float f, float f2) {
        return false;
    }

    /* renamed from: b */
    public boolean mo12462b() {
        AppMethodBeat.m2504i(99400);
        if (this.f16491h.mo4033h()) {
            final C36894gk a = this.f16488e.mo12440a();
            a.mo58826b(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(99388);
                    a.mo58859w();
                    AppMethodBeat.m2505o(99388);
                }
            });
        }
        AppMethodBeat.m2505o(99400);
        return false;
    }

    /* renamed from: c */
    public boolean mo12464c() {
        AppMethodBeat.m2504i(99401);
        if (this.f16489f) {
            this.f16488e.mo12440a().mo58778A();
            this.f16489f = false;
        }
        AppMethodBeat.m2505o(99401);
        return false;
    }

    /* renamed from: a */
    public boolean mo12457a(float f) {
        AppMethodBeat.m2504i(99402);
        if (!this.f16491h.mo4029d()) {
            AppMethodBeat.m2505o(99402);
            return false;
        } else if (this.f16488e.mo12440a().mo58779B()) {
            this.f16488e.mo12440a().mo58844i((double) ((f / 8.0f) * 2.0f));
            AppMethodBeat.m2505o(99402);
            return true;
        } else {
            AppMethodBeat.m2505o(99402);
            return false;
        }
    }

    /* renamed from: d */
    public boolean mo12466d() {
        return false;
    }

    /* renamed from: a */
    public boolean mo12460a(PointF pointF, PointF pointF2, float f) {
        AppMethodBeat.m2504i(99403);
        if (this.f16491h.mo4030e() && this.f16488e.mo12440a().mo58779B()) {
            this.f16488e.mo12440a().mo58786a((double) f, (double) pointF.x, (double) pointF.y, (double) pointF2.x, (double) pointF2.y);
        }
        AppMethodBeat.m2505o(99403);
        return false;
    }

    /* renamed from: a */
    public boolean mo12459a(PointF pointF, PointF pointF2, double d, double d2) {
        AppMethodBeat.m2504i(99404);
        if (this.f16491h.mo4034i()) {
            double d3 = d2 / d;
            final C36894gk a = this.f16488e.mo12440a();
            a.mo58787a(d3, (double) pointF.x, (double) pointF.y, (double) pointF2.x, (double) pointF2.y, new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(99389);
                    a.mo58859w();
                    AppMethodBeat.m2505o(99389);
                }
            });
        }
        AppMethodBeat.m2505o(99404);
        return false;
    }

    /* renamed from: i */
    public boolean mo12472i(float f, float f2) {
        AppMethodBeat.m2504i(99405);
        this.f16488e.mo12440a().mo58778A();
        AppMethodBeat.m2505o(99405);
        return false;
    }

    /* renamed from: j */
    public boolean mo12473j(float f, float f2) {
        return false;
    }

    /* renamed from: k */
    public boolean mo12474k(float f, float f2) {
        return false;
    }

    /* renamed from: l */
    private void m71397l(float f, float f2) {
        AppMethodBeat.m2504i(99406);
        this.f16492i = true;
        if (this.f16489f) {
            AppMethodBeat.m2505o(99406);
            return;
        }
        float f3 = f / 64.0f;
        float f4 = f2 / 64.0f;
        if (Math.abs(f3) >= this.f16493j || Math.abs(f4) >= this.f16493j) {
            final long max = ((long) (((Math.max(Math.abs(f), Math.abs(f2)) - this.f16486c) / (this.f16487d - this.f16486c)) * 950.0f)) + 250;
            final PointF pointF = new PointF(f3, f4);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f16489f = true;
            this.f16488e.mo12440a().mo58825b(new C31045fx(3, new double[]{0.0d, 0.0d}) {
                /* renamed from: b */
                public void mo29422b() {
                    AppMethodBeat.m2504i(99390);
                    C41055go.this.f16489f = false;
                    AppMethodBeat.m2505o(99390);
                }

                /* renamed from: a */
                public boolean mo29421a() {
                    AppMethodBeat.m2504i(99391);
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis > max) {
                        C41055go.this.f16489f = false;
                        AppMethodBeat.m2505o(99391);
                        return true;
                    }
                    if (pointF.x != 0.0f) {
                        this.f14125b[0] = C36502fh.m60384a(currentTimeMillis, pointF.x, -pointF.x, max);
                    }
                    if (pointF.y != 0.0f) {
                        this.f14125b[1] = C36502fh.m60384a(currentTimeMillis, pointF.y, -pointF.y, max);
                    }
                    AppMethodBeat.m2505o(99391);
                    return false;
                }
            });
            AppMethodBeat.m2505o(99406);
            return;
        }
        AppMethodBeat.m2505o(99406);
    }

    /* renamed from: m */
    private boolean m71398m(float f, float f2) {
        AppMethodBeat.m2504i(99407);
        boolean a = this.f16488e.mo12442c().mo65143a(this.f16488e.mo12443d(), f, f2);
        AppMethodBeat.m2505o(99407);
        return a;
    }
}
