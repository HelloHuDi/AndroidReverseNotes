package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.j;
import com.google.android.gms.common.internal.Constants;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.g;
import com.tencent.tencentmap.mapsdk.a.aj.h;
import com.tencent.tencentmap.mapsdk.a.aj.i;
import com.tencent.tencentmap.mapsdk.a.aj.k;
import com.tencent.tencentmap.mapsdk.a.aj.l;
import com.tencent.tencentmap.mapsdk.maps.a.fl;
import com.tencent.tencentmap.mapsdk.maps.a.fv;
import com.tencent.tencentmap.mapsdk.maps.a.fx;
import com.tencent.tencentmap.mapsdk.maps.a.gg;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.im;
import com.tencent.tencentmap.mapsdk.maps.a.iw;
import com.tencent.tencentmap.mapsdk.maps.a.ix;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import com.tencent.tencentmap.mapsdk.maps.a.ja;
import com.tencent.tencentmap.mapsdk.maps.a.jj;
import com.tencent.tencentmap.mapsdk.maps.a.jk;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ar implements as, bw, ce, cg {
    private gg a = null;
    private iz b = null;
    private Context c = null;
    private String d = null;
    private bi e = null;
    private jk f = null;
    private q g = null;
    private jj h = null;
    private final GeoPoint i = null;
    private final GeoPoint j = null;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private byte[] o = new byte[0];
    private int p = 0;
    private boolean q = false;
    private float r = 1.0f;
    private boolean s = false;
    private final c t = new c(false);
    private final c u = new c(true);
    private com.tencent.tencentmap.mapsdk.maps.a.gk.a v = new com.tencent.tencentmap.mapsdk.maps.a.gk.a() {
        public void a(fx fxVar) {
            AppMethodBeat.i(100582);
            if (fxVar.a != Downloads.MIN_WAIT_FOR_NETWORK) {
                AppMethodBeat.o(100582);
            } else if (fxVar instanceof im) {
                im imVar = (im) fxVar;
                if (imVar.j()) {
                    ar.this.b.b().c((ar.this.b.T / 2) - imVar.k(), (ar.this.b.U / 2) - imVar.l());
                }
                if (imVar.e()) {
                    ar.this.b.b().c(imVar.f(), imVar.g());
                }
                if (imVar.h()) {
                    ar.this.b.b().b((double) imVar.i());
                }
                if (imVar.m()) {
                    int n = imVar.n();
                    int o = imVar.o();
                    ar.this.b.b().a(n, o);
                    if (imVar.t()) {
                        ar.this.b.c(n, o);
                    }
                }
                if (imVar.q()) {
                    ar.this.b.b().b(imVar.p());
                }
                if (imVar.r()) {
                    ar.this.b.b().a(imVar.s());
                }
                if (imVar.j()) {
                    ar.this.b.b().c(imVar.k() - (ar.this.b.T / 2), imVar.l() - (ar.this.b.U / 2));
                }
                AppMethodBeat.o(100582);
            } else {
                AppMethodBeat.o(100582);
            }
        }
    };
    private com.tencent.tencentmap.mapsdk.maps.a.im.a w = new com.tencent.tencentmap.mapsdk.maps.a.im.a() {
        public int b() {
            AppMethodBeat.i(100583);
            if (ar.this.b == null) {
                AppMethodBeat.o(100583);
                return 0;
            }
            int c = ar.this.b.b().c();
            AppMethodBeat.o(100583);
            return c;
        }

        public GeoPoint c() {
            AppMethodBeat.i(100584);
            if (ar.this.b == null) {
                AppMethodBeat.o(100584);
                return null;
            }
            GeoPoint f = ar.this.b.b().f();
            AppMethodBeat.o(100584);
            return f;
        }

        public float d() {
            AppMethodBeat.i(100585);
            if (ar.this.b == null) {
                AppMethodBeat.o(100585);
                return 0.0f;
            }
            float q = ar.this.b.b().q();
            AppMethodBeat.o(100585);
            return q;
        }

        public float e() {
            AppMethodBeat.i(100586);
            if (ar.this.b == null) {
                AppMethodBeat.o(100586);
                return 0.0f;
            }
            float r = ar.this.b.b().r();
            AppMethodBeat.o(100586);
            return r;
        }

        public float a() {
            AppMethodBeat.i(100587);
            if (ar.this.b == null) {
                AppMethodBeat.o(100587);
                return 0.0f;
            }
            float s = ar.this.s();
            AppMethodBeat.o(100587);
            return s;
        }

        public GeoPoint f() {
            AppMethodBeat.i(100588);
            if (ar.this.b == null) {
                AppMethodBeat.o(100588);
                return null;
            }
            GeoPoint F = ar.this.b.F();
            AppMethodBeat.o(100588);
            return F;
        }

        public boolean g() {
            AppMethodBeat.i(100589);
            if (ar.this.b == null) {
                AppMethodBeat.o(100589);
                return false;
            }
            boolean a = ar.this.b.E().a();
            AppMethodBeat.o(100589);
            return a;
        }

        public void a(Runnable runnable) {
            AppMethodBeat.i(100590);
            if (runnable == null) {
                AppMethodBeat.o(100590);
            } else if (ar.this.b == null || ar.this.b.I == null) {
                AppMethodBeat.o(100590);
            } else {
                ar.this.b.I.postDelayed(runnable, 100);
                AppMethodBeat.o(100590);
            }
        }
    };
    private fv x = new fv() {
        boolean a = false;
        Handler b = new Handler(Looper.getMainLooper());

        {
            AppMethodBeat.i(100594);
            AppMethodBeat.o(100594);
        }

        public void a() {
            AppMethodBeat.i(100595);
            if (!this.a) {
                this.a = true;
            }
            this.b.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(100593);
                    if (ar.this.b == null) {
                        AppMethodBeat.o(100593);
                        return;
                    }
                    ar.this.b.a(ar.this.b.b().j());
                    ar.this.b.K().h();
                    if (ar.this.b.q != null) {
                        ar.this.b.q.a();
                        ar.this.b.q = null;
                    }
                    AppMethodBeat.o(100593);
                }
            });
            AppMethodBeat.o(100595);
        }
    };

    static class a {
        static gg a(int i, Context context, ak akVar) {
            AppMethodBeat.i(100596);
            gg jaVar;
            switch (i) {
                case 0:
                    jaVar = new ja(context, akVar);
                    AppMethodBeat.o(100596);
                    return jaVar;
                case 1:
                    jaVar = new ix(context, akVar);
                    AppMethodBeat.o(100596);
                    return jaVar;
                case 2:
                    jaVar = new iw(context, akVar);
                    AppMethodBeat.o(100596);
                    return jaVar;
                default:
                    ja jaVar2 = new ja(context, akVar);
                    AppMethodBeat.o(100596);
                    return jaVar2;
            }
        }
    }

    public interface b {
        void a();
    }

    class c implements b {
        private boolean b = false;

        public c(boolean z) {
            this.b = z;
        }

        public void a() {
            AppMethodBeat.i(100597);
            if (ar.this.b.T == 0 || ar.this.b.U == 0) {
                AppMethodBeat.o(100597);
                return;
            }
            ar.this.b.a(null);
            if (ar.this.b.M == null || ar.this.b.N == null) {
                AppMethodBeat.o(100597);
                return;
            }
            float a;
            GeoPoint geoPoint = new GeoPoint();
            if (ar.this.b.P == 0 && ar.this.b.Q == 0 && ar.this.b.R == 0 && ar.this.b.S == 0) {
                a = ar.this.a(0, 0, 0, 0, ar.this.b.M, ar.this.b.N, geoPoint);
            } else {
                a = ar.this.a(ar.this.b.P, ar.this.b.Q, ar.this.b.R, ar.this.b.S, ar.this.b.M, ar.this.b.N, geoPoint);
            }
            com.tencent.tencentmap.mapsdk.a.aj.a aVar = ar.this.b.w;
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            if (this.b) {
                fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
                imVar.c(0.0f);
                imVar.d(0.0f);
                imVar.c(latitudeE6, longitudeE6);
                imVar.a(a);
                imVar.a(ar.this.w);
                imVar.a(aVar);
                ar.this.b.b().a(imVar);
            } else {
                ar.this.b.b().b(0.0f);
                ar.this.b.b().a(0.0f);
                ar.this.b.b().a(latitudeE6, longitudeE6);
                ar.a(ar.this, a, false, 0, null);
            }
            ar.this.b.M = null;
            ar.this.b.N = null;
            ar.this.b.P = 0;
            ar.this.b.Q = 0;
            ar.this.b.R = 0;
            ar.this.b.S = 0;
            ar.this.b.w = null;
            AppMethodBeat.o(100597);
        }
    }

    public final bi a() {
        return this.e;
    }

    public final q b() {
        return this.g;
    }

    public final jj c() {
        return this.h;
    }

    public ar(int i, ac acVar, ak akVar) {
        AppMethodBeat.i(100598);
        this.c = acVar.getContext().getApplicationContext();
        this.r = SystemUtil.getDensity(this.c);
        if (this.a == null) {
            this.a = a.a(i, this.c, akVar);
            this.b = (iz) this.a.getVectorMapDelegate();
            this.b.a(this.c, akVar);
        }
        if (ic.t == null) {
            ic.t = new aq(10);
        }
        this.b.a((as) this);
        this.b.b().a(this.v);
        this.b.b().a(this.x);
        this.b.b().e(0, 0);
        a(false, false);
        if (!(akVar == null || StringUtil.isEmpty(akVar.h()))) {
            this.d = akVar.h();
        }
        this.g = new q(this.c, this.d);
        this.h = new jj(this.c, this.b.b(), this.d);
        if (this.e == null) {
            this.e = new bi(acVar, this.a);
        }
        AppMethodBeat.o(100598);
    }

    public final void a(com.tencent.tencentmap.mapsdk.a.bi.a aVar) {
        AppMethodBeat.i(100599);
        this.e.a(aVar);
        AppMethodBeat.o(100599);
    }

    public final void a(com.tencent.tencentmap.mapsdk.maps.a.lh.a aVar, ak akVar) {
        AppMethodBeat.i(100600);
        this.e.a(aVar, akVar);
        AppMethodBeat.o(100600);
    }

    public final void d() {
        AppMethodBeat.i(100601);
        if (this.b != null) {
            this.b.b().b(this.x);
            this.b.A();
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        if (ic.t != null) {
            ic.t.a();
        }
        AppMethodBeat.o(100601);
    }

    public final db a(Point point) {
        AppMethodBeat.i(100602);
        if (point == null) {
            AppMethodBeat.o(100602);
            return null;
        }
        db a = ic.a(this.b.b().t().a(new DoublePoint((double) point.x, (double) point.y)));
        AppMethodBeat.o(100602);
        return a;
    }

    public final Point a(db dbVar) {
        AppMethodBeat.i(100603);
        if (this.b == null) {
            AppMethodBeat.o(100603);
            return null;
        }
        DoublePoint b = this.b.b().t().b(ic.a(dbVar));
        if (b == null) {
            AppMethodBeat.o(100603);
            return null;
        }
        Point point = new Point();
        point.x = (int) Math.round(b.x);
        point.y = (int) Math.round(b.y);
        AppMethodBeat.o(100603);
        return point;
    }

    public final double a(double d) {
        AppMethodBeat.i(100604);
        double a = this.b.b().t().a(d);
        AppMethodBeat.o(100604);
        return a;
    }

    public final do e() {
        AppMethodBeat.i(100605);
        Point point = new Point(0, this.b.U);
        Point point2 = new Point(this.b.T, this.b.U);
        Point point3 = new Point(0, 0);
        Point point4 = new Point(this.b.T, 0);
        db a = a(point);
        db a2 = a(point2);
        db a3 = a(point3);
        db a4 = a(point4);
        do doVar = new do(a, a2, a3, a4, dc.a().a(a).a(a2).a(a3).a(a4).a());
        AppMethodBeat.o(100605);
        return doVar;
    }

    public final gg f() {
        return this.a;
    }

    private void a(boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100606);
        if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.b(1.0f);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100606);
            return;
        }
        this.b.b().b(this.b.b().h() + 1);
        AppMethodBeat.o(100606);
    }

    private void b(boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100607);
        if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.b(-1.0f);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100607);
            return;
        }
        this.b.b().b(this.b.b().h() - 1);
        AppMethodBeat.o(100607);
    }

    private void a(float f, float f2, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100608);
        if (this.b == null) {
            AppMethodBeat.o(100608);
        } else if (f == 0.0f && f2 == 0.0f) {
            AppMethodBeat.o(100608);
        } else if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.a((int) f, (int) f2);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100608);
        } else {
            this.b.b().c((int) f, (int) f2);
            AppMethodBeat.o(100608);
        }
    }

    private void a(float f, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100609);
        if (this.b == null) {
            AppMethodBeat.o(100609);
        } else if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.a(f);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100609);
        } else {
            this.b.b().a((double) ((float) (1.0d / Math.pow(2.0d, (double) (((float) this.b.b().d()) - Math.min(f, (float) Math.min(this.b.b().c(), this.b.E().a() ? 22 : 20)))))));
            AppMethodBeat.o(100609);
        }
    }

    private void b(float f, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100610);
        if (this.b == null) {
            AppMethodBeat.o(100610);
        } else if (f == 0.0f) {
            AppMethodBeat.o(100610);
        } else if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.b(f);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100610);
        } else {
            float pow;
            if (f < 0.0f) {
                pow = (float) (1.0d / Math.pow(2.0d, (double) Math.abs(f)));
            } else {
                pow = (float) (1.0d / Math.pow(0.5d, (double) Math.abs(f)));
            }
            this.b.b().a((double) (pow * this.b.b().i()));
            AppMethodBeat.o(100610);
        }
    }

    private void a(float f, float f2, float f3, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100611);
        if (this.b == null) {
            AppMethodBeat.o(100611);
        } else if (f == 0.0f) {
            AppMethodBeat.o(100611);
        } else if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.b((int) f2, (int) f3);
            imVar.b(f);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100611);
        } else {
            float pow;
            if (f < 0.0f) {
                pow = (float) (1.0d / Math.pow(2.0d, (double) Math.abs(f)));
            } else {
                pow = (float) (1.0d / Math.pow(0.5d, (double) Math.abs(f)));
            }
            this.b.b().a((double) pow, (double) f2, (double) f3, (double) f2, (double) f3, null);
            AppMethodBeat.o(100611);
        }
    }

    private void a(cp cpVar, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100612);
        if (this.b == null) {
            AppMethodBeat.o(100612);
        } else if (cpVar == null) {
            AppMethodBeat.o(100612);
        } else {
            GeoPoint a = ic.a(cpVar.a);
            float f = cpVar.b;
            int d = this.b.b().d();
            int b = this.b.b().b();
            if (f < ((float) b)) {
                f = (float) b;
            }
            if (f > ((float) d)) {
                f = (float) d;
            }
            if (z) {
                fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
                if (a != null) {
                    imVar.c(a.getLatitudeE6(), a.getLongitudeE6());
                }
                imVar.a(f);
                imVar.c(cpVar.d);
                if (cpVar.c >= 0.0f) {
                    imVar.d(cpVar.c);
                }
                imVar.a(this.w);
                imVar.a(j);
                imVar.a(aVar);
                this.b.b().a(imVar);
                AppMethodBeat.o(100612);
                return;
            }
            double pow = 1.0d / Math.pow(2.0d, (double) (((float) d) - f));
            if (a != null) {
                this.b.b().a(a.getLatitudeE6(), a.getLongitudeE6());
            }
            this.b.b().c((float) pow);
            this.b.b().b(cpVar.d);
            if (cpVar.c >= 0.0f) {
                this.b.b().a(cpVar.c);
            }
            AppMethodBeat.o(100612);
        }
    }

    private void a(double d, double d2, float f, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100613);
        if (this.b == null) {
            AppMethodBeat.o(100613);
            return;
        }
        float f2;
        int i = (int) (1000000.0d * d);
        int i2 = (int) (1000000.0d * d2);
        int d3 = this.b.b().d();
        int b = this.b.b().b();
        if (f < ((float) b)) {
            f2 = (float) b;
        } else {
            f2 = f;
        }
        if (f2 > ((float) d3)) {
            f2 = (float) d3;
        }
        double pow = 1.0d / Math.pow(2.0d, (double) (((float) d3) - f2));
        if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.c(i, i2);
            imVar.a(f2);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100613);
            return;
        }
        this.b.b().a(i, i2);
        this.b.b().c((float) pow);
        AppMethodBeat.o(100613);
    }

    private void a(double d, double d2, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100614);
        if (this.b == null) {
            AppMethodBeat.o(100614);
            return;
        }
        int i = (int) (d * 1000000.0d);
        int i2 = (int) (1000000.0d * d2);
        if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.c(i, i2);
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100614);
            return;
        }
        this.b.b().a(i, i2);
        AppMethodBeat.o(100614);
    }

    private int a(dc dcVar, int i, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100615);
        int windowWidth;
        int windowHeight;
        if (dcVar == null) {
            AppMethodBeat.o(100615);
            return -1;
        } else if (dcVar.b == null || dcVar.a == null) {
            AppMethodBeat.o(100615);
            return -1;
        } else if (this.b.T == 0 || this.b.U == 0) {
            this.b.M = dcVar.a;
            this.b.N = dcVar.b;
            this.b.O = i;
            this.b.w = aVar;
            if (z) {
                this.b.a(this.u);
            } else {
                this.b.a(this.t);
            }
            windowWidth = SystemUtil.getWindowWidth(this.c);
            windowHeight = SystemUtil.getWindowHeight(this.c);
            if (((i * 2) + this.k) + this.m > windowWidth || ((i * 2) + this.l) + this.n > windowHeight) {
                AppMethodBeat.o(100615);
                return -1;
            }
            AppMethodBeat.o(100615);
            return 0;
        } else {
            this.b.a(null);
            GeoPoint geoPoint = new GeoPoint();
            float a = a(i, i, i, i, dcVar.a, dcVar.b, geoPoint);
            if (a < 0.0f) {
                windowWidth = (int) a;
                AppMethodBeat.o(100615);
                return windowWidth;
            }
            windowWidth = geoPoint.getLatitudeE6();
            windowHeight = geoPoint.getLongitudeE6();
            if (z) {
                fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
                imVar.c(0.0f);
                imVar.d(0.0f);
                imVar.c(windowWidth, windowHeight);
                imVar.a(a);
                imVar.a(this.w);
                imVar.a(aVar);
                imVar.a(j);
                this.b.b().a(imVar);
            } else {
                this.b.b().a(windowWidth, windowHeight);
                a(a, false, j, null);
                this.b.b().b(0.0f);
                this.b.b().a(0.0f);
            }
            AppMethodBeat.o(100615);
            return 0;
        }
    }

    private void b(float f, float f2, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100616);
        if (z) {
            fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
            imVar.c(f);
            if (f2 >= 0.0f) {
                imVar.d(f2);
            }
            imVar.a(this.w);
            imVar.a(aVar);
            imVar.a(j);
            this.b.b().a(imVar);
            AppMethodBeat.o(100616);
            return;
        }
        this.b.b().b(f);
        if (f2 >= 0.0f) {
            this.b.b().a(f2);
        }
        AppMethodBeat.o(100616);
    }

    private int a(dc dcVar, int i, int i2, int i3, int i4, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100617);
        int windowWidth;
        int windowHeight;
        if (dcVar == null) {
            AppMethodBeat.o(100617);
            return -1;
        } else if (dcVar.b == null || dcVar.a == null) {
            AppMethodBeat.o(100617);
            return -1;
        } else if (this.b.T == 0 || this.b.U == 0) {
            this.b.M = dcVar.a;
            this.b.N = dcVar.b;
            this.b.P = i;
            this.b.Q = i2;
            this.b.R = i3;
            this.b.S = i4;
            this.b.w = aVar;
            if (z) {
                this.b.a(this.u);
            } else {
                this.b.a(this.t);
            }
            windowWidth = SystemUtil.getWindowWidth(this.c);
            windowHeight = SystemUtil.getWindowHeight(this.c);
            if (((i + i2) + this.k) + this.m > windowWidth || ((i3 + i4) + this.l) + this.n > windowHeight) {
                AppMethodBeat.o(100617);
                return -1;
            }
            AppMethodBeat.o(100617);
            return 0;
        } else {
            this.b.a(null);
            GeoPoint geoPoint = new GeoPoint();
            float a = a(i, i2, i3, i4, dcVar.a, dcVar.b, geoPoint);
            if (a < 0.0f) {
                windowWidth = (int) a;
                AppMethodBeat.o(100617);
                return windowWidth;
            }
            windowWidth = geoPoint.getLatitudeE6();
            windowHeight = geoPoint.getLongitudeE6();
            if (z) {
                fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
                imVar.c(0.0f);
                imVar.d(0.0f);
                imVar.c(windowWidth, windowHeight);
                imVar.a(a);
                imVar.a(this.w);
                imVar.a(aVar);
                imVar.a(j);
                this.b.b().a(imVar);
            } else {
                this.b.b().a(windowWidth, windowHeight);
                a(a, false, j, null);
                this.b.b().b(0.0f);
                this.b.b().a(0.0f);
            }
            AppMethodBeat.o(100617);
            return 0;
        }
    }

    private int a(List<bx> list, int i, int i2, int i3, int i4, boolean z, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100618);
        fl flVar = (fl) this.b.b().u();
        if (flVar == null) {
            AppMethodBeat.o(100618);
            return j.INVALID_ID;
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.o(100618);
            return -1;
        } else {
            List arrayList = new ArrayList();
            for (bx bxVar : list) {
                if (!(bxVar == null || bxVar.a() == null)) {
                    arrayList.addAll(bxVar.a());
                }
            }
            if (this.b.T == 0 || this.b.U == 0) {
                int windowWidth = SystemUtil.getWindowWidth(this.c);
                int windowHeight = SystemUtil.getWindowHeight(this.c);
                if (i + i2 > windowWidth || i3 + i4 > windowHeight) {
                    AppMethodBeat.o(100618);
                    return -1;
                }
                AppMethodBeat.o(100618);
                return 0;
            } else if (i + i2 > this.b.T || i3 + i4 > this.b.U) {
                AppMethodBeat.o(100618);
                return -1;
            } else {
                final boolean z2 = z;
                final com.tencent.tencentmap.mapsdk.a.aj.a aVar2 = aVar;
                final long j2 = j;
                flVar.a(arrayList, new Rect(i, i3, i2, i4), new com.tencent.tencentmap.mapsdk.maps.a.fl.a() {
                    public void a(final float f, final GeoPoint geoPoint, double d) {
                        AppMethodBeat.i(100592);
                        if (ar.this.b == null) {
                            AppMethodBeat.o(100592);
                            return;
                        }
                        ar.this.b.I.post(new Runnable() {
                            public void run() {
                                double d = 0.0d;
                                AppMethodBeat.i(100591);
                                if (ar.this.b == null) {
                                    AppMethodBeat.o(100591);
                                } else if (z2) {
                                    double h = (((double) ((int) ar.this.h())) - (Math.log((double) (1.0f / f)) / Math.log(2.0d))) - 2.0d;
                                    if (h >= 0.0d) {
                                        d = h;
                                    }
                                    fx imVar = new im(Downloads.MIN_WAIT_FOR_NETWORK);
                                    imVar.c(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
                                    imVar.a((float) d);
                                    imVar.a(ar.this.w);
                                    imVar.a(aVar2);
                                    imVar.a(j2);
                                    ar.this.b.b().a(imVar);
                                    AppMethodBeat.o(100591);
                                } else {
                                    ar.this.b.b().b(geoPoint);
                                    ar.this.b.b().c(f);
                                    AppMethodBeat.o(100591);
                                }
                            }
                        });
                        AppMethodBeat.o(100592);
                    }
                });
                AppMethodBeat.o(100618);
                return 0;
            }
        }
    }

    public final cp g() {
        AppMethodBeat.i(100619);
        db a = ic.a(this.b.b().f());
        float q = this.b.b().q();
        if (q < 0.0f) {
            q = (q % 360.0f) + 360.0f;
        }
        cp a2 = cp.a().a(s()).a(a).c(q).b(this.b.b().r()).a();
        AppMethodBeat.o(100619);
        return a2;
    }

    public final float h() {
        AppMethodBeat.i(100620);
        float c = (float) this.b.b().c();
        AppMethodBeat.o(100620);
        return c;
    }

    public final float i() {
        AppMethodBeat.i(100621);
        float b = (float) this.b.b().b();
        AppMethodBeat.o(100621);
        return b;
    }

    public final int a(ad adVar) {
        AppMethodBeat.i(100622);
        if (adVar == null) {
            AppMethodBeat.o(100622);
            return -1;
        }
        ao a = adVar.a();
        if (a == null) {
            AppMethodBeat.o(100622);
            return -1;
        }
        int a2;
        switch (a.o) {
            case 0:
                a(false, 0, null);
                break;
            case 1:
                b(false, 0, null);
                break;
            case 2:
                a(a.p, a.q, false, 0, null);
                break;
            case 3:
                a(a.r, false, 0, null);
                break;
            case 4:
                b(a.s, false, 0, null);
                break;
            case 5:
                a(a.t, (float) a.u.x, (float) a.u.y, false, 0, null);
                break;
            case 6:
                a(a.v, false, 0, null);
                break;
            case 7:
                a(a.w.a, a.w.b, false, 0, null);
                break;
            case 8:
                a(a.x.a, a.x.b, a.y, false, 0, null);
                break;
            case 9:
                a2 = a(a.z, a.A, false, 0, null);
                AppMethodBeat.o(100622);
                return a2;
            case 10:
                a2 = a(a.B, a.E, a.E, a.E, a.E, false, 0, null);
                AppMethodBeat.o(100622);
                return a2;
            case 11:
                a2 = a(a.B, a.F, a.G, a.H, a.I, false, 0, null);
                AppMethodBeat.o(100622);
                return a2;
            case 12:
                b(a.J, a.K, false, 0, null);
                break;
            case 13:
                a2 = a(a.L, a.F, a.G, a.H, a.I, false, 0, null);
                AppMethodBeat.o(100622);
                return a2;
        }
        AppMethodBeat.o(100622);
        return 0;
    }

    public final int a(ad adVar, long j, com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        AppMethodBeat.i(100623);
        if (adVar == null) {
            AppMethodBeat.o(100623);
            return -1;
        }
        ao a = adVar.a();
        if (a == null) {
            AppMethodBeat.o(100623);
            return -1;
        }
        long j2 = j < 0 ? 0 : j;
        int a2;
        switch (a.o) {
            case 0:
                a(true, j2, aVar);
                break;
            case 1:
                b(true, j2, aVar);
                break;
            case 2:
                a(a.p, a.q, true, j2, aVar);
                break;
            case 3:
                a(a.r, true, j2, aVar);
                break;
            case 4:
                b(a.s, true, j2, aVar);
                break;
            case 5:
                a(a.t, (float) a.u.x, (float) a.u.y, true, j2, aVar);
                break;
            case 6:
                a(a.v, true, j2, aVar);
                break;
            case 7:
                a(a.w.a, a.w.b, true, j2, aVar);
                break;
            case 8:
                a(a.x.a, a.x.b, a.y, true, j2, aVar);
                break;
            case 9:
                a2 = a(a.z, a.A, true, j2, aVar);
                AppMethodBeat.o(100623);
                return a2;
            case 10:
                a2 = a(a.B, a.E, a.E, a.E, a.E, true, j2, aVar);
                AppMethodBeat.o(100623);
                return a2;
            case 11:
                a2 = a(a.B, a.F, a.G, a.H, a.I, true, j2, aVar);
                AppMethodBeat.o(100623);
                return a2;
            case 12:
                b(a.J, a.K, true, j2, aVar);
                break;
            case 13:
                a2 = a(a.L, a.F, a.G, a.H, a.I, true, j2, aVar);
                AppMethodBeat.o(100623);
                return a2;
        }
        AppMethodBeat.o(100623);
        return 0;
    }

    public final void j() {
        AppMethodBeat.i(100624);
        this.b.b().v();
        AppMethodBeat.o(100624);
    }

    public final void a(int i) {
        AppMethodBeat.i(100625);
        if (this.q) {
            AppMethodBeat.o(100625);
            return;
        }
        if (this.g != null) {
            i = this.g.a(i);
        }
        this.p = i;
        this.b.b().a(i);
        ic.a(true);
        AppMethodBeat.o(100625);
    }

    public final void a(boolean z) {
        AppMethodBeat.i(100626);
        f b = this.b.b();
        if (z) {
            b.a(true);
            AppMethodBeat.o(100626);
            return;
        }
        b.a(false);
        AppMethodBeat.o(100626);
    }

    public final void b(boolean z) {
        AppMethodBeat.i(100627);
        this.q = z;
        if (z) {
            this.b.b().a(11);
            AppMethodBeat.o(100627);
            return;
        }
        this.b.b().a(this.p);
        AppMethodBeat.o(100627);
    }

    public final boolean k() {
        AppMethodBeat.i(100628);
        boolean g = this.b.b().g();
        AppMethodBeat.o(100628);
        return g;
    }

    public final iz l() {
        return this.b;
    }

    public final Context m() {
        return this.c;
    }

    public final void n() {
    }

    public final void o() {
        AppMethodBeat.i(100629);
        this.a.e();
        if (this.e != null) {
            this.e.f();
        }
        AppMethodBeat.o(100629);
    }

    public final void p() {
        AppMethodBeat.i(100630);
        this.a.f();
        AppMethodBeat.o(100630);
    }

    public final void q() {
        AppMethodBeat.i(100631);
        this.a.g();
        if (this.f != null) {
            this.f.b();
            this.f = null;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        AppMethodBeat.o(100631);
    }

    public final void a(h hVar) {
        this.b.m = hVar;
    }

    public final void a(aj.j jVar) {
        this.b.p = jVar;
    }

    public final void a(com.tencent.tencentmap.mapsdk.a.aj.c cVar) {
        AppMethodBeat.i(100632);
        this.b.a(cVar);
        AppMethodBeat.o(100632);
    }

    public final void a(int i, int i2) {
        AppMethodBeat.i(100633);
        if (i == 0 || i2 == 0) {
            AppMethodBeat.o(100633);
            return;
        }
        if (this.e != null) {
            this.e.a(i, i2);
        }
        AppMethodBeat.o(100633);
    }

    public final void a(Handler handler, Config config) {
        AppMethodBeat.i(100634);
        this.b.a(handler, config);
        AppMethodBeat.o(100634);
    }

    public final void a(dn dnVar) {
        AppMethodBeat.i(100635);
        if (this.b == null) {
            AppMethodBeat.o(100635);
            return;
        }
        this.b.a(dnVar);
        AppMethodBeat.o(100635);
    }

    public final void b(dn dnVar) {
        AppMethodBeat.i(100636);
        if (this.b == null) {
            AppMethodBeat.o(100636);
            return;
        }
        this.b.b(dnVar);
        AppMethodBeat.o(100636);
    }

    public final String r() {
        return "4.2.2";
    }

    public final DoublePoint a(GeoPoint geoPoint, DoublePoint doublePoint) {
        AppMethodBeat.i(100637);
        double d = (double) (2.68435456E8f * this.r);
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        d /= 6.283185307179586d;
        double min = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        d3 = (d3 * (((double) geoPoint.getLongitudeE6()) / 1000000.0d)) + d2;
        d = ((d * Math.log((1.0d + min) / (1.0d - min))) * 0.5d) + d2;
        if (doublePoint == null) {
            doublePoint = new DoublePoint();
        }
        doublePoint.set(d3, d);
        AppMethodBeat.o(100637);
        return doublePoint;
    }

    public final float a(int i, int i2, int i3, int i4, db dbVar, db dbVar2, GeoPoint geoPoint) {
        AppMethodBeat.i(100638);
        int i5 = this.b.T;
        int i6 = this.b.U;
        if (i5 == 0 || i6 == 0 || dbVar == null || dbVar2 == null) {
            AppMethodBeat.o(100638);
            return -2.0f;
        } else if (((i + i2) + this.k) + this.m > i5 || ((i3 + i4) + this.l) + this.n > i6) {
            AppMethodBeat.o(100638);
            return -1.0f;
        } else {
            double pow;
            GeoPoint a = ic.a(dbVar);
            GeoPoint a2 = ic.a(dbVar2);
            int d = this.b.b().d();
            DoublePoint a3 = a(a, null);
            DoublePoint a4 = a(a2, null);
            double d2 = a4.x - a3.x;
            if (d2 < 0.0d) {
                d2 = Math.abs(d2);
            }
            double d3 = a4.y - a3.y;
            if (d3 < 0.0d) {
                d3 = Math.abs(d3);
            }
            int i7 = (((i5 - i) - i2) - this.k) - this.m;
            int i8 = (((i6 - i3) - i4) - this.l) - this.n;
            if (i7 <= 0) {
                i7 = 1;
            }
            if (i8 <= 0) {
                i8 = 1;
            }
            d2 = Math.max(d2 / ((double) i7), d3 / ((double) i8));
            float log = (float) (((double) d) - (Math.log(d2) / Math.log(2.0d)));
            float h = h();
            float i9 = i();
            if (h < log) {
                d2 = Math.pow(2.0d, (double) (((float) d) - h));
            } else {
                h = log;
            }
            if (i9 > h) {
                pow = Math.pow(2.0d, (double) (((float) d) - i9));
            } else {
                pow = d2;
                i9 = h;
            }
            if (geoPoint != null) {
                d3 = (((double) (i2 - i)) * pow) / 2.0d;
                d2 = (((double) (i3 - i4)) * pow) / 2.0d;
                DoublePoint a5 = a(ic.a(new db((dbVar.a + dbVar2.a) / 2.0d, (dbVar.b + dbVar2.b) / 2.0d)), null);
                a5.x = d3 + a5.x;
                a5.y = d2 + a5.y;
                double d4 = a5.x;
                double d5 = a5.y;
                if (this.s) {
                    double d6;
                    int i10 = this.k - this.m;
                    int i11 = this.l - this.n;
                    h = (((float) (this.k - this.m)) / (2.0f * ((float) i5))) + 0.5f;
                    if (((double) h) < 0.25d) {
                        i10 = (int) (-0.5d * ((double) i5));
                    } else if (((double) h) > 0.75d) {
                        i10 = (int) (0.5d * ((double) i5));
                    }
                    h = (((float) (this.l - this.n)) / (2.0f * ((float) i6))) + 0.5f;
                    if (((double) h) < 0.25d) {
                        i11 = (int) (-0.5d * ((double) i6));
                    } else if (((double) h) > 0.75d) {
                        i11 = (int) (0.5d * ((double) i6));
                    }
                    double d7 = (((double) i10) * pow) / 2.0d;
                    double d8 = (((double) i11) * pow) / 2.0d;
                    com.tencent.tencentmap.mapsdk.maps.a.gs.b q = this.b.b().A().q();
                    if (q == null) {
                        d2 = 0.0d;
                        d6 = 0.0d;
                    } else {
                        d2 = (double) q.a();
                        d6 = (double) q.b();
                    }
                    d3 = (d4 - d7) + ((d2 * ((double) i5)) * pow);
                    d2 = (d5 - d8) - ((d6 * ((double) i6)) * pow);
                } else {
                    d2 = d5;
                    d3 = d4;
                }
                a = a(new DoublePoint(d3, d2), null);
                geoPoint.setLatitudeE6(a.getLatitudeE6());
                geoPoint.setLongitudeE6(a.getLongitudeE6());
            }
            AppMethodBeat.o(100638);
            return i9;
        }
    }

    private GeoPoint a(DoublePoint doublePoint, GeoPoint geoPoint) {
        AppMethodBeat.i(100639);
        double d = (double) (2.68435456E8f * this.r);
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        d3 = (doublePoint.x - d2) / d3;
        d = (Math.asin(1.0d - (2.0d / (Math.pow(2.718281828459045d, ((doublePoint.y - d2) / 0.5d) / (d / 6.283185307179586d)) + 1.0d))) * 180.0d) / 3.141592653589793d;
        if (geoPoint == null) {
            geoPoint = new GeoPoint(0, 0);
        }
        geoPoint.setLatitudeE6((int) (d * 1000000.0d));
        geoPoint.setLongitudeE6((int) (1000000.0d * d3));
        AppMethodBeat.o(100639);
        return geoPoint;
    }

    public final float s() {
        AppMethodBeat.i(100640);
        float j = this.b.b().j();
        AppMethodBeat.o(100640);
        return j;
    }

    public final void a(float f, float f2, boolean z) {
        AppMethodBeat.i(100641);
        if (this.b == null) {
            AppMethodBeat.o(100641);
            return;
        }
        this.s = true;
        this.b.b().a(f, f2, 0, z);
        AppMethodBeat.o(100641);
    }

    public final void c(boolean z) {
        AppMethodBeat.i(100642);
        this.a.setZOrderMediaOverlay(z);
        AppMethodBeat.o(100642);
    }

    public final void t() {
    }

    public final void u() {
    }

    public final void a(boolean z, boolean z2) {
        AppMethodBeat.i(100643);
        this.b.b().c(z2);
        this.b.b().b(z);
        AppMethodBeat.o(100643);
    }

    public final void a(i iVar) {
        this.b.q = iVar;
    }

    public final void a(l lVar) {
        this.b.s = lVar;
    }

    public final void a(g gVar) {
        this.b.t = gVar;
    }

    public final void a(aj.f fVar) {
        AppMethodBeat.i(100644);
        this.b.a(fVar);
        AppMethodBeat.o(100644);
    }

    public final void d(boolean z) {
        AppMethodBeat.i(100645);
        if (this.h == null) {
            AppMethodBeat.o(100645);
            return;
        }
        this.h.a(z);
        AppMethodBeat.o(100645);
    }

    public final void b(int i) {
        AppMethodBeat.i(100646);
        if (this.b == null) {
            AppMethodBeat.o(100646);
            return;
        }
        f b = this.b.b();
        if (b == null) {
            AppMethodBeat.o(100646);
            return;
        }
        b.f(i);
        AppMethodBeat.o(100646);
    }

    public final int v() {
        AppMethodBeat.i(100647);
        if (this.b == null) {
            AppMethodBeat.o(100647);
            return -1;
        }
        f b = this.b.b();
        if (b == null) {
            AppMethodBeat.o(100647);
            return -1;
        }
        int x = b.x();
        AppMethodBeat.o(100647);
        return x;
    }

    public final String[] w() {
        AppMethodBeat.i(100648);
        if (this.b == null) {
            AppMethodBeat.o(100648);
            return null;
        }
        f b = this.b.b();
        if (b == null) {
            AppMethodBeat.o(100648);
            return null;
        }
        String[] y = b.y();
        AppMethodBeat.o(100648);
        return y;
    }

    public final String b(db dbVar) {
        AppMethodBeat.i(100649);
        if (this.b == null || dbVar == null) {
            AppMethodBeat.o(100649);
            return null;
        }
        f b = this.b.b();
        if (b == null) {
            AppMethodBeat.o(100649);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        String c = b.c(geoPoint);
        dbVar.a = (((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d;
        dbVar.b = (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d;
        AppMethodBeat.o(100649);
        return c;
    }

    public final cw c(db dbVar) {
        AppMethodBeat.i(100650);
        GeoPoint geoPoint = new GeoPoint();
        com.tencent.map.lib.element.c d = l().b().d(geoPoint);
        if (d == null || d.a == null || d.b == null || d.d == null || d.d.length == 0 || d.c >= d.d.length || d.c == -1) {
            AppMethodBeat.o(100650);
            return null;
        }
        if (dbVar != null) {
            dbVar.a = (((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d;
            dbVar.b = (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d;
        }
        ArrayList arrayList = new ArrayList();
        for (String cyVar : d.d) {
            arrayList.add(new cy(cyVar));
        }
        cw cwVar = new cw(d.a, d.b, arrayList, d.c);
        AppMethodBeat.o(100650);
        return cwVar;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(100651);
        this.b.a(kVar);
        AppMethodBeat.o(100651);
    }

    public final void e(boolean z) {
        AppMethodBeat.i(100652);
        if (this.b == null) {
            AppMethodBeat.o(100652);
        } else if (z) {
            this.b.L();
            AppMethodBeat.o(100652);
        } else {
            this.b.M();
            AppMethodBeat.o(100652);
        }
    }

    public final boolean x() {
        AppMethodBeat.i(100653);
        if (this.b == null) {
            AppMethodBeat.o(100653);
            return false;
        }
        boolean N = this.b.N();
        AppMethodBeat.o(100653);
        return N;
    }

    public final boolean y() {
        AppMethodBeat.i(100654);
        if (this.b == null) {
            AppMethodBeat.o(100654);
            return false;
        }
        boolean O = this.b.O();
        AppMethodBeat.o(100654);
        return O;
    }

    public final void a(da daVar) {
        AppMethodBeat.i(100655);
        if (this.b == null || this.b.o() == null) {
            AppMethodBeat.o(100655);
            return;
        }
        this.b.o().a(daVar);
        AppMethodBeat.o(100655);
    }

    public final String z() {
        String str = null;
        AppMethodBeat.i(100656);
        if (this.c == null || this.b == null) {
            AppMethodBeat.o(100656);
        } else {
            try {
                s a;
                JSONObject jSONObject = new JSONObject();
                if (StringUtil.isEmpty(this.d)) {
                    a = w.a(this.c);
                } else {
                    a = u.a(this.c, this.d);
                }
                jSONObject.put("cfgVer", a.b());
                int windowWidth = SystemUtil.getWindowWidth(this.c);
                jSONObject.put("resolution", "{" + windowWidth + "," + SystemUtil.getWindowHeight(this.c) + "}");
                jSONObject.put(Constants.PARAM_DENSITY, (double) this.r);
                jSONObject.put("renderStatus", this.b.b().J());
                jSONObject.put("renderError", this.b.b().K());
                jSONObject.put("sdkver", "4.2.2.1");
                str = jSONObject.toString();
                AppMethodBeat.o(100656);
            } catch (JSONException e) {
                AppMethodBeat.o(100656);
            }
        }
        return str;
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(100657);
        if (this.b == null || this.b.b() == null) {
            AppMethodBeat.o(100657);
            return;
        }
        f b = this.b.b();
        if (b != null) {
            b.a(str, str2);
        }
        AppMethodBeat.o(100657);
    }

    public final void f(boolean z) {
        if (this.b != null) {
            this.b.V = z;
        }
    }
}
