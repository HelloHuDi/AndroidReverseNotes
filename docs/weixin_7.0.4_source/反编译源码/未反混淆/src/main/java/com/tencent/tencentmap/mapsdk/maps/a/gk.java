package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.e;
import com.tencent.map.lib.gl.JNICallback.g;
import com.tencent.map.lib.gl.d;
import com.tencent.map.lib.thread.AsyncTask;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gs.b;
import com.tencent.tencentmap.mapsdk.maps.a.gs.c;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class gk implements g, ex, fv, com.tencent.tencentmap.mapsdk.maps.a.fz.a, gu {
    private static int c = 116307503;
    private static int d = 39984186;
    private float A = 0.5f;
    private boolean B = true;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private Runnable G;
    private boolean H = false;
    public fz a;
    public go b;
    private List<fq> e;
    private List<fm> f;
    private List<d> g;
    private List<fo> h;
    private List<ft> i;
    private List<fs> j;
    private List<fv> k;
    private List<gt> l;
    private List<gr> m;
    private List<fr> n;
    private List<fu> o;
    private boolean p = true;
    private Stack<gs> q = new Stack();
    private WeakReference<ge> r;
    private fn s;
    private gs t;
    private fp u;
    private Rect v;
    private Rect w;
    private Handler x = null;
    private a y = null;
    private float z = 0.5f;

    public interface a {
        void a(fx fxVar);
    }

    public gk(fn fnVar) {
        AppMethodBeat.i(99182);
        this.s = fnVar;
        this.r = fnVar.b();
        this.t = fnVar.e();
        this.u = (fp) fnVar.d();
        this.v = fnVar.g();
        this.a = new fz(this);
        this.a.a((fv) this);
        a(this.a);
        this.b = new go(fnVar);
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        a(gi.a(1));
        this.x = new Handler();
        AppMethodBeat.o(99182);
    }

    public int a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(99183);
        this.C = i;
        this.D = i2;
        this.E = i3;
        this.F = i4;
        if (this.v == null || this.v.width() <= 0 || this.v.height() <= 0) {
            a(new d() {
                public void a() {
                    AppMethodBeat.i(99179);
                    final PointF a = gk.a(gk.this);
                    new AsyncTask<Void, Void, Void>() {
                        public /* synthetic */ Object doInBackground(Object[] objArr) {
                            AppMethodBeat.i(99178);
                            Void a = a((Void[]) objArr);
                            AppMethodBeat.o(99178);
                            return a;
                        }

                        /* Access modifiers changed, original: protected|varargs */
                        public Void a(Void... voidArr) {
                            AppMethodBeat.i(99177);
                            gk.this.a(a.x, a.y, false);
                            AppMethodBeat.o(99177);
                            return null;
                        }
                    }.execute((Object[]) new Void[0]);
                    gk.this.b((d) this);
                    AppMethodBeat.o(99179);
                }
            });
            if (this.s instanceof gm) {
                Context k = ((gm) this.s).k();
                if (i + i3 > SystemUtil.getWindowWidth(k) || i2 + i4 > SystemUtil.getWindowHeight(k)) {
                    AppMethodBeat.o(99183);
                    return -1;
                }
                AppMethodBeat.o(99183);
                return 0;
            }
            AppMethodBeat.o(99183);
            return -2;
        } else if (i + i3 > this.v.width() || i2 + i4 > this.v.height()) {
            AppMethodBeat.o(99183);
            return -1;
        } else {
            PointF E = E();
            a(E.x, E.y, false);
            AppMethodBeat.o(99183);
            return 0;
        }
    }

    private PointF E() {
        int width;
        int height;
        int i;
        AppMethodBeat.i(99184);
        if (this.v != null) {
            width = this.v.width();
            height = this.v.height();
            i = width;
        } else {
            height = 0;
            i = 0;
        }
        width = this.C;
        int i2 = (((i - width) - this.E) / 2) + width;
        width = this.D;
        int i3 = (((height - width) - this.F) / 2) + width;
        if (i == 0 || height == 0) {
            PointF pointF = new PointF(0.5f, 0.5f);
            AppMethodBeat.o(99184);
            return pointF;
        }
        PointF pointF2 = new PointF((((float) i2) * 1.0f) / ((float) i), (((float) i3) * 1.0f) / ((float) height));
        AppMethodBeat.o(99184);
        return pointF2;
    }

    public Rect b() {
        AppMethodBeat.i(99185);
        Rect rect = new Rect(this.C, this.D, this.E, this.F);
        AppMethodBeat.o(99185);
        return rect;
    }

    private boolean F() {
        AppMethodBeat.i(99186);
        if (this.v == null || this.v.width() <= 0 || this.v.height() <= 0) {
            AppMethodBeat.o(99186);
            return false;
        }
        AppMethodBeat.o(99186);
        return true;
    }

    public fz c() {
        AppMethodBeat.i(99187);
        this.a.a();
        fz fzVar = this.a;
        AppMethodBeat.o(99187);
        return fzVar;
    }

    public void d() {
        AppMethodBeat.i(99188);
        if (this.a != null) {
            this.a.d();
        }
        AppMethodBeat.o(99188);
    }

    public void e() {
        AppMethodBeat.i(99189);
        if (this.a != null) {
            this.a.c();
        }
        AppMethodBeat.o(99189);
    }

    public void f() {
        AppMethodBeat.i(99190);
        if (this.a != null) {
            this.a.b();
        }
        AppMethodBeat.o(99190);
    }

    public fz g() {
        return this.a;
    }

    public void a(gt gtVar) {
        AppMethodBeat.i(99191);
        if (gtVar == null) {
            AppMethodBeat.o(99191);
            return;
        }
        if (this.l == null) {
            this.l = new CopyOnWriteArrayList();
        }
        synchronized (this.l) {
            try {
                if (!this.l.contains(gtVar)) {
                    this.l.add(gtVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99191);
            }
        }
    }

    private void G() {
        AppMethodBeat.i(99192);
        if (this.l == null) {
            AppMethodBeat.o(99192);
            return;
        }
        for (gt gtVar : this.l) {
            if (gtVar != null) {
                try {
                    gtVar.a(this.t);
                } catch (Exception e) {
                }
            }
        }
        z();
        AppMethodBeat.o(99192);
    }

    public void h() {
        AppMethodBeat.i(99193);
        try {
            gs gsVar = (gs) this.t.clone();
            com.tencent.map.lib.d.a("mapParam stack saveMapParam:" + gsVar.toString());
            this.q.push(gsVar);
            AppMethodBeat.o(99193);
        } catch (CloneNotSupportedException e) {
            AppMethodBeat.o(99193);
        }
    }

    public void i() {
        AppMethodBeat.i(99194);
        try {
            gs gsVar = (gs) this.q.pop();
            if (gsVar.j() != this.t.j()) {
                a(c.SCALE_LEVEL_CHANGED);
            } else if (gsVar.i() != this.t.i()) {
                a(c.SCALE_CHANGED);
            }
            if (gsVar.c() != this.t.c()) {
                a((double) gsVar.c());
            }
            if (gsVar.d() != this.t.d()) {
                b((double) gsVar.d());
            }
            this.t.a(gsVar);
            G();
            AppMethodBeat.o(99194);
        } catch (Exception e) {
            AppMethodBeat.o(99194);
        }
    }

    public void a(boolean z) {
        AppMethodBeat.i(99195);
        this.B = z;
        L();
        AppMethodBeat.o(99195);
    }

    public void a(Rect rect) {
        AppMethodBeat.i(99196);
        if (F()) {
            float a = a(rect, this.v);
            this.t.a(rect);
            this.t.e(a);
            AppMethodBeat.o(99196);
            return;
        }
        AppMethodBeat.o(99196);
    }

    public gs j() {
        AppMethodBeat.i(99197);
        try {
            gs gsVar = (gs) this.t.clone();
            AppMethodBeat.o(99197);
            return gsVar;
        } catch (CloneNotSupportedException e) {
            AppMethodBeat.o(99197);
            return null;
        }
    }

    public void a(fr frVar) {
        AppMethodBeat.i(99198);
        if (frVar == null) {
            AppMethodBeat.o(99198);
            return;
        }
        synchronized (this.n) {
            try {
                if (!this.n.contains(frVar)) {
                    this.n.add(frVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99198);
            }
        }
    }

    public void a(double d) {
        AppMethodBeat.i(99199);
        L();
        for (fr frVar : this.n) {
            if (frVar != null) {
                try {
                    frVar.a(d);
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(99199);
    }

    public void a(fu fuVar) {
        AppMethodBeat.i(99200);
        if (fuVar == null) {
            AppMethodBeat.o(99200);
            return;
        }
        synchronized (this.o) {
            try {
                com.tencent.map.lib.d.a("skew addSkewListener");
                if (!this.o.contains(fuVar)) {
                    this.o.add(fuVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99200);
            }
        }
    }

    public void b(fu fuVar) {
        AppMethodBeat.i(99201);
        synchronized (this.o) {
            try {
                com.tencent.map.lib.d.a("skew addSkewListener");
                this.o.remove(fuVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99201);
            }
        }
    }

    public void b(double d) {
        AppMethodBeat.i(99202);
        L();
        com.tencent.map.lib.d.a("skew notifySkew");
        for (fu fuVar : this.o) {
            if (fuVar != null) {
                try {
                    fuVar.a(d);
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(99202);
    }

    public void a(e eVar) {
        AppMethodBeat.i(99203);
        this.b.a(eVar);
        AppMethodBeat.o(99203);
    }

    public void k() {
        AppMethodBeat.i(99204);
        GeoPoint geoPoint = new GeoPoint(d, c);
        this.t.a(this.s.g(), geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 13);
        G();
        L();
        AppMethodBeat.o(99204);
    }

    public void a(int i) {
        AppMethodBeat.i(99205);
        if (this.t.b(i)) {
            a(c.SCALE_LEVEL_CHANGED);
        }
        AppMethodBeat.o(99205);
    }

    public float l() {
        AppMethodBeat.i(99206);
        float i = this.t.i();
        AppMethodBeat.o(99206);
        return i;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(99207);
        a(i, i2, 1);
        AppMethodBeat.o(99207);
    }

    public void a(int i, int i2, int i3) {
        AppMethodBeat.i(99208);
        this.t.a(i, i2, false);
        if (i3 == 1) {
            c(i3);
            G();
        }
        AppMethodBeat.o(99208);
    }

    public void a(float f, float f2) {
        AppMethodBeat.i(99209);
        if (this.s != null) {
            gh f3 = this.s.f();
            if (f3 != null) {
                f3.a(f, f2, false);
                G();
            }
        }
        AppMethodBeat.o(99209);
    }

    public float a(Rect rect, Rect rect2) {
        AppMethodBeat.i(99210);
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
        Rect rect3 = new Rect();
        rect3.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        rect3.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        float a = (float) this.s.f().a(rect3, rect2);
        AppMethodBeat.o(99210);
        return a;
    }

    public void a(Rect rect, Rect rect2, boolean z) {
        AppMethodBeat.i(99211);
        if (F()) {
            Rect rect3 = new Rect(this.v);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
            GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
            Rect rect4 = new Rect();
            rect4.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            rect4.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            this.s.f().a(rect4, rect3, z);
            z();
            AppMethodBeat.o(99211);
            return;
        }
        AppMethodBeat.o(99211);
    }

    public void a(float f) {
        AppMethodBeat.i(99212);
        a(this.t.c(f));
        AppMethodBeat.o(99212);
    }

    public int m() {
        AppMethodBeat.i(99213);
        int j = this.t.j();
        AppMethodBeat.o(99213);
        return j;
    }

    public GeoPoint n() {
        AppMethodBeat.i(99214);
        GeoPoint p = this.t.p();
        AppMethodBeat.o(99214);
        return p;
    }

    public void b(float f) {
        AppMethodBeat.i(99215);
        f((double) f);
        AppMethodBeat.o(99215);
    }

    public float o() {
        AppMethodBeat.i(99216);
        float c = this.t.c();
        AppMethodBeat.o(99216);
        return c;
    }

    public void c(float f) {
        AppMethodBeat.i(99217);
        d((double) f);
        AppMethodBeat.o(99217);
    }

    public float p() {
        AppMethodBeat.i(99218);
        float d = this.t.d();
        AppMethodBeat.o(99218);
        return d;
    }

    public float q() {
        AppMethodBeat.i(99219);
        float k = this.t.k();
        AppMethodBeat.o(99219);
        return k;
    }

    public void a(double d, double d2) {
        AppMethodBeat.i(99220);
        this.s.f().a((float) d, (float) d2, false);
        c(1);
        G();
        AppMethodBeat.o(99220);
    }

    public void c(double d) {
        AppMethodBeat.i(99221);
        if (d == 0.0d) {
            AppMethodBeat.o(99221);
            return;
        }
        float b = this.t.b(this.t.d() + ((float) d));
        G();
        b((double) b);
        AppMethodBeat.o(99221);
    }

    public void d(double d) {
        AppMethodBeat.i(99222);
        if (d == ((double) this.t.d())) {
            AppMethodBeat.o(99222);
            return;
        }
        float b = this.t.b((float) d);
        G();
        b((double) b);
        AppMethodBeat.o(99222);
    }

    public void e(double d) {
        AppMethodBeat.i(99223);
        if (d == 0.0d) {
            AppMethodBeat.o(99223);
            return;
        }
        float a = this.t.a(this.t.c() + ((float) d));
        G();
        a((double) a);
        AppMethodBeat.o(99223);
    }

    public void f(double d) {
        AppMethodBeat.i(99224);
        if (MathUtil.calShortestAngleDistance(d - ((double) this.t.c())) == 0.0d) {
            AppMethodBeat.o(99224);
            return;
        }
        float a = this.t.a((float) d);
        G();
        a((double) a);
        AppMethodBeat.o(99224);
    }

    public void g(double d) {
        AppMethodBeat.i(99225);
        h((double) (this.t.i() * ((float) d)));
        AppMethodBeat.o(99225);
    }

    public void h(double d) {
        AppMethodBeat.i(99226);
        a((float) d);
        AppMethodBeat.o(99226);
    }

    private void H() {
        AppMethodBeat.i(99227);
        this.t.a(0.0f);
        this.t.b(0.0f);
        a(0.0d);
        b(0.0d);
        G();
        AppMethodBeat.o(99227);
    }

    public void b(fx fxVar) {
        AppMethodBeat.i(99228);
        this.a.j();
        c(fxVar);
        AppMethodBeat.o(99228);
    }

    public void i(double d) {
        AppMethodBeat.i(99229);
        this.a.j();
        c(new fx(102, new double[]{0.0d, d}));
        AppMethodBeat.o(99229);
    }

    public void j(double d) {
        AppMethodBeat.i(99230);
        this.a.j();
        c(new fx(108, new double[]{d}));
        AppMethodBeat.o(99230);
    }

    public void a(double d, double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(99231);
        if (t()) {
            this.a.j();
            c(new fx(103, new double[]{d, d2, d3, d4, d5}));
            AppMethodBeat.o(99231);
            return;
        }
        AppMethodBeat.o(99231);
    }

    public void a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        AppMethodBeat.i(99232);
        this.a.j();
        float width = ((float) this.s.g().width()) / 2.0f;
        float height = ((float) this.s.g().height()) / 2.0f;
        b q = D().q();
        if (this.H) {
            double a;
            double b;
            if (q != null) {
                a = (double) (width + ((q.a() * width) * 2.0f));
                b = (double) (((q.b() * height) * 2.0f) + height);
            } else {
                a = (double) width;
                b = (double) height;
            }
            d5 = b;
            d4 = a;
            d3 = b;
            d2 = a;
        }
        c(new fx(101, new double[]{d, d2, d3, d4, d5}));
        fx fxVar = new fx(runnable);
        fxVar.e = false;
        fxVar.c = 0;
        c(fxVar);
        AppMethodBeat.o(99232);
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(99233);
        a(runnable, null);
        AppMethodBeat.o(99233);
    }

    public void a(Runnable runnable, fy fyVar) {
        AppMethodBeat.i(99234);
        if (I()) {
            this.s.f().b(((float) this.s.g().width()) / 2.0f, ((float) this.s.g().height()) / 2.0f);
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.o(99234);
            return;
        }
        AppMethodBeat.o(99234);
    }

    public void a(float f, float f2, Runnable runnable) {
        AppMethodBeat.i(99235);
        if (this.H) {
            b q = D().q();
            if (q != null) {
                f = ((float) this.s.g().width()) * (q.a() + 0.5f);
                f2 = ((float) this.s.g().height()) * (q.b() + 0.5f);
            } else {
                a(runnable);
                AppMethodBeat.o(99235);
                return;
            }
        }
        a(f, f2, runnable, null);
        AppMethodBeat.o(99235);
    }

    public void a(float f, float f2, Runnable runnable, fy fyVar) {
        AppMethodBeat.i(99236);
        if (I()) {
            this.s.f().b(f, f2);
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.o(99236);
            return;
        }
        AppMethodBeat.o(99236);
    }

    public void b(Runnable runnable) {
        AppMethodBeat.i(99237);
        b(runnable, null);
        AppMethodBeat.o(99237);
    }

    public void b(Runnable runnable, fy fyVar) {
        AppMethodBeat.i(99238);
        if (J()) {
            this.s.f().t();
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.o(99238);
            return;
        }
        AppMethodBeat.o(99238);
    }

    public void r() {
        AppMethodBeat.i(99239);
        this.a.j();
        a(0.0d, 0.0d, true);
        AppMethodBeat.o(99239);
    }

    private void a(double d, double d2, boolean z) {
        AppMethodBeat.i(99240);
        final double k = k(d - ((double) o()));
        final double p = d2 - ((double) p());
        if (k == 0.0d && p == 0.0d) {
            AppMethodBeat.o(99240);
            return;
        }
        boolean z2;
        com.tencent.map.lib.d.a("postRotateAndSkew distance:" + k + "," + p);
        final long currentTimeMillis = System.currentTimeMillis();
        final float f = (float) (0.10000000149011612d * k);
        final float f2 = (float) (0.10000000149011612d * p);
        double[] dArr = new double[]{d, d2, 0.0d, 0.0d};
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        final double d3 = d;
        final double d4 = d2;
        c(new fx(102, dArr, z2) {
            public boolean a() {
                int i;
                AppMethodBeat.i(99180);
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                double b = fh.b(currentTimeMillis, 0.0f, f, 5000);
                double b2 = fh.b(currentTimeMillis, 0.0f, f2, 5000);
                double[] dArr = this.b;
                dArr[2] = dArr[2] + Math.abs(b);
                dArr = this.b;
                dArr[3] = dArr[3] + Math.abs(b2);
                int i2 = this.b[2] >= Math.abs(k) ? 1 : 0;
                if (this.b[3] >= Math.abs(p)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i2 != 0) {
                    this.b[0] = d3 - ((double) gk.this.o());
                } else {
                    this.b[0] = b;
                }
                if (i != 0) {
                    this.b[1] = d4 - ((double) gk.this.p());
                } else {
                    this.b[1] = b2;
                }
                if (i2 == 0 || i == 0) {
                    AppMethodBeat.o(99180);
                    return false;
                }
                AppMethodBeat.o(99180);
                return true;
            }
        });
        AppMethodBeat.o(99240);
    }

    private double k(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return d2 - 360.0d;
        }
        if (d2 < -180.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    public void s() {
        AppMethodBeat.i(99241);
        d(false);
        r();
        AppMethodBeat.o(99241);
    }

    public boolean t() {
        AppMethodBeat.i(99242);
        if (((double) Math.abs(p())) > 1.0E-6d || Math.abs(o()) > 1.0f) {
            AppMethodBeat.o(99242);
            return true;
        }
        AppMethodBeat.o(99242);
        return false;
    }

    private boolean I() {
        AppMethodBeat.i(99243);
        if (m() < this.t.m()) {
            AppMethodBeat.o(99243);
            return true;
        }
        AppMethodBeat.o(99243);
        return false;
    }

    private boolean J() {
        AppMethodBeat.i(99244);
        if (m() > this.t.l()) {
            AppMethodBeat.o(99244);
            return true;
        }
        AppMethodBeat.o(99244);
        return false;
    }

    private void d(fx fxVar) {
        AppMethodBeat.i(99245);
        int i;
        int i2;
        switch (fxVar.a) {
            case 2:
                if (!(this.r == null || this.r.get() == null)) {
                    ((ge) this.r.get()).a_();
                    AppMethodBeat.o(99245);
                    return;
                }
            case 3:
                a(fxVar.b[0], fxVar.b[1]);
                AppMethodBeat.o(99245);
                return;
            case 4:
                if (fxVar.b.length > 2) {
                    i = (int) fxVar.b[2];
                } else {
                    i = 1;
                }
                a((int) fxVar.b[0], (int) fxVar.b[1], i);
                AppMethodBeat.o(99245);
                return;
            case 6:
                if (fxVar.f != null) {
                    fxVar.f.run();
                    AppMethodBeat.o(99245);
                    return;
                }
                break;
            case 100:
                g(fxVar.b[0]);
                AppMethodBeat.o(99245);
                return;
            case 101:
                int width = this.s.g().width();
                int height = this.s.g().height();
                i2 = width / 2;
                i = height / 2;
                b q = D().q();
                if (q != null) {
                    i2 = (int) (((float) i2) + (((float) width) * q.a()));
                    i = (int) (((float) i) + (q.b() * ((float) height)));
                }
                double d = ((double) i2) - fxVar.b[1];
                double d2 = ((double) i) - fxVar.b[2];
                double d3 = fxVar.b[3] - ((double) i2);
                double d4 = fxVar.b[4] - ((double) i);
                com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        before   center:" + this.t.p().toString());
                a(d, d2);
                g(fxVar.b[0]);
                com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        after      center:" + this.t.p().toString());
                a(d3, d4);
                com.tencent.map.lib.d.a("Debug ScaleFix finally scale move by:" + d3 + "," + d4 + " curCenter:" + this.t.p().toString());
                AppMethodBeat.o(99245);
                return;
            case 102:
                e(fxVar.b[0]);
                c(fxVar.b[1]);
                AppMethodBeat.o(99245);
                return;
            case 103:
                i = this.s.g().width() / 2;
                i2 = this.s.g().height() / 2;
                a(((double) i) - fxVar.b[1], ((double) i2) - fxVar.b[2]);
                e(fxVar.b[0]);
                a(fxVar.b[3] - ((double) i), fxVar.b[4] - ((double) i2));
                AppMethodBeat.o(99245);
                return;
            case 104:
                H();
                AppMethodBeat.o(99245);
                return;
            case 108:
                h(fxVar.b[0]);
                AppMethodBeat.o(99245);
                return;
            case 109:
                f(fxVar.b[0]);
                AppMethodBeat.o(99245);
                return;
            case 110:
                d(fxVar.b[0]);
                AppMethodBeat.o(99245);
                return;
            case 120:
                h(fxVar.b[0]);
                a((int) fxVar.b[1], (int) fxVar.b[2]);
                AppMethodBeat.o(99245);
                return;
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                if (this.y != null) {
                    this.y.a(fxVar);
                    break;
                }
                break;
        }
        AppMethodBeat.o(99245);
    }

    public void b(int i) {
        AppMethodBeat.i(99246);
        if (this.t.a(i)) {
            d(i);
        }
        AppMethodBeat.o(99246);
    }

    public void a(float f, float f2, boolean z) {
        AppMethodBeat.i(99247);
        this.t.a(f - 0.5f, f2 - 0.5f, z);
        if (z) {
            G();
        }
        AppMethodBeat.o(99247);
    }

    public void a(float f, float f2, int i, boolean z) {
        AppMethodBeat.i(99248);
        if (this.t.a(f - 0.5f, f2 - 0.5f, z)) {
            G();
        }
        AppMethodBeat.o(99248);
    }

    public void b(Rect rect) {
        AppMethodBeat.i(99249);
        if (this.v == null || rect == null) {
            AppMethodBeat.o(99249);
            return;
        }
        this.w = rect;
        if (this.s instanceof gm) {
            ((gm) this.s).a(rect);
        }
        G();
        AppMethodBeat.o(99249);
    }

    public int u() {
        AppMethodBeat.i(99250);
        int b = this.t.b();
        AppMethodBeat.o(99250);
        return b;
    }

    private void K() {
        AppMethodBeat.i(99251);
        for (fq fqVar : this.e) {
            if (fqVar != null) {
                try {
                    fqVar.c_();
                } catch (Exception e) {
                }
            }
        }
        G();
        AppMethodBeat.o(99251);
    }

    private void c(int i) {
        AppMethodBeat.i(99252);
        for (fm fmVar : this.f) {
            if (fmVar != null) {
                try {
                    fmVar.a(i);
                } catch (Exception e) {
                }
            }
        }
        K();
        AppMethodBeat.o(99252);
    }

    public void v() {
        AppMethodBeat.i(99253);
        b(this.w);
        for (d dVar : this.g) {
            if (dVar != null) {
                try {
                    dVar.a();
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(99253);
    }

    private void d(boolean z) {
        AppMethodBeat.i(99254);
        if (this.h == null) {
            AppMethodBeat.o(99254);
            return;
        }
        boolean t = t();
        for (fo foVar : this.h) {
            if (foVar != null) {
                try {
                    foVar.a(t, z);
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(99254);
    }

    public void a(ft ftVar) {
        AppMethodBeat.i(99255);
        if (ftVar == null) {
            AppMethodBeat.o(99255);
            return;
        }
        synchronized (this.i) {
            try {
                if (!this.i.contains(ftVar)) {
                    this.i.add(ftVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99255);
            }
        }
    }

    public void b(ft ftVar) {
        AppMethodBeat.i(99256);
        synchronized (this.i) {
            try {
                this.i.remove(ftVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99256);
            }
        }
    }

    public void a(final c cVar) {
        AppMethodBeat.i(99257);
        if (cVar == c.NO_CHANGED) {
            AppMethodBeat.o(99257);
            return;
        }
        if (this.x != null) {
            this.x.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(99181);
                    for (ft ftVar : gk.this.i) {
                        if (ftVar != null) {
                            ftVar.a(cVar);
                        }
                    }
                    gk.c(gk.this);
                    AppMethodBeat.o(99181);
                }
            });
        }
        AppMethodBeat.o(99257);
    }

    public void w() {
        AppMethodBeat.i(99258);
        for (fs fsVar : this.j) {
            if (fsVar != null) {
                try {
                    fsVar.a();
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(99258);
    }

    public void a(fv fvVar) {
        AppMethodBeat.i(99259);
        if (fvVar == null) {
            AppMethodBeat.o(99259);
            return;
        }
        synchronized (this.k) {
            try {
                if (!this.k.contains(fvVar)) {
                    this.k.add(fvVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99259);
            }
        }
    }

    public void b(fv fvVar) {
        AppMethodBeat.i(99260);
        synchronized (this.k) {
            try {
                this.k.remove(fvVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99260);
            }
        }
    }

    public void x() {
        AppMethodBeat.i(99261);
        for (fv fvVar : this.k) {
            if (fvVar != null) {
                try {
                    fvVar.a();
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.o(99261);
    }

    public void a(fq fqVar) {
        AppMethodBeat.i(99262);
        if (fqVar == null) {
            AppMethodBeat.o(99262);
            return;
        }
        synchronized (this.e) {
            try {
                if (!this.e.contains(fqVar)) {
                    this.e.add(fqVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99262);
            }
        }
    }

    public void b(fq fqVar) {
        AppMethodBeat.i(99263);
        synchronized (this.e) {
            try {
                this.e.remove(fqVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99263);
            }
        }
    }

    public void a(d dVar) {
        AppMethodBeat.i(99264);
        if (dVar == null) {
            AppMethodBeat.o(99264);
            return;
        }
        if (!this.g.contains(dVar)) {
            this.g.add(dVar);
        }
        AppMethodBeat.o(99264);
    }

    public void b(d dVar) {
        AppMethodBeat.i(99265);
        synchronized (this.g) {
            try {
                this.g.remove(dVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99265);
            }
        }
    }

    private void d(int i) {
        AppMethodBeat.i(99266);
        for (gr grVar : this.m) {
            if (grVar != null) {
                try {
                    grVar.a(i);
                } catch (Exception e) {
                }
            }
        }
        G();
        AppMethodBeat.o(99266);
    }

    public void b(Rect rect, Rect rect2) {
        AppMethodBeat.i(99267);
        if (rect == null) {
            AppMethodBeat.o(99267);
            return;
        }
        if (rect.height() > 0 || rect.width() > 0) {
            a(rect, rect2, false);
        }
        c(1);
        AppMethodBeat.o(99267);
    }

    public void a(int i, Runnable runnable, boolean z) {
        AppMethodBeat.i(99268);
        this.s.f().b(i, true);
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(99268);
    }

    public Rect y() {
        AppMethodBeat.i(99269);
        DoublePoint doublePoint = new DoublePoint((double) this.s.g().width(), (double) this.s.g().height());
        GeoPoint a = this.u.a(doublePoint);
        doublePoint.set(0.0d, 0.0d);
        GeoPoint a2 = this.u.a(doublePoint);
        Rect rect = new Rect(Math.min(a2.getLongitudeE6(), a.getLongitudeE6()), Math.min(a2.getLatitudeE6(), a.getLatitudeE6()), Math.max(a2.getLongitudeE6(), a.getLongitudeE6()), Math.max(a2.getLatitudeE6(), a.getLatitudeE6()));
        AppMethodBeat.o(99269);
        return rect;
    }

    public void z() {
        AppMethodBeat.i(99270);
        this.a.i();
        AppMethodBeat.o(99270);
    }

    public void c(fx fxVar) {
        AppMethodBeat.i(99271);
        this.a.a(fxVar);
        AppMethodBeat.o(99271);
    }

    public void A() {
        AppMethodBeat.i(99272);
        this.a.j();
        AppMethodBeat.o(99272);
    }

    public void a(fx fxVar) {
        AppMethodBeat.i(99273);
        if (fxVar != null) {
            d(fxVar);
        }
        AppMethodBeat.o(99273);
    }

    public void a() {
        AppMethodBeat.i(99274);
        x();
        AppMethodBeat.o(99274);
    }

    public boolean B() {
        return this.p;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean C() {
        AppMethodBeat.i(99275);
        boolean k = this.a.k();
        AppMethodBeat.o(99275);
        return k;
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(99276);
        a((double) i, (double) i2);
        AppMethodBeat.o(99276);
    }

    public void a(a aVar) {
        this.y = aVar;
    }

    public gs D() {
        return this.t;
    }

    private void L() {
        AppMethodBeat.i(99277);
        gh f = this.s.f();
        boolean z = t() && this.B;
        f.c(z);
        AppMethodBeat.o(99277);
    }

    public void b(boolean z) {
        AppMethodBeat.i(99278);
        if (z) {
            if (this.G != null) {
                this.G.run();
                this.G = null;
            }
            G();
        }
        AppMethodBeat.o(99278);
    }

    public void c(boolean z) {
        this.H = z;
    }
}
