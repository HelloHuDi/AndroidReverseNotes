package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.df;

public class hw extends hv {
    private boolean R;
    private Bitmap S;
    private boolean T;
    private boolean U;
    private boolean V;
    private a W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private final byte[] aa;
    private boolean ab;
    private boolean ac;
    private Bitmap ad;
    private Bitmap ae;
    private Bitmap af;
    private int ag;
    private int ah;
    private int ai;

    enum a {
        None,
        Appear,
        DisAppear,
        MarkerChanged;

        static {
            AppMethodBeat.o(99623);
        }
    }

    public hw(iz izVar) {
        super(izVar);
        AppMethodBeat.i(99624);
        this.R = false;
        this.S = null;
        this.T = false;
        this.U = false;
        this.V = true;
        this.W = a.None;
        this.X = false;
        this.Y = true;
        this.Z = false;
        this.aa = new byte[0];
        this.ab = false;
        this.ac = false;
        this.ag = 0;
        this.ah = 0;
        this.ai = 0;
        this.t = true;
        AppMethodBeat.o(99624);
    }

    public void a(df dfVar) {
        AppMethodBeat.i(99625);
        super.a(dfVar);
        this.y = dfVar;
        AppMethodBeat.o(99625);
    }

    public synchronized void a(boolean z, boolean z2) {
        AppMethodBeat.i(99626);
        d(true);
        if (z && z2) {
            this.R = false;
        } else {
            this.R = true;
        }
        if (this.Y) {
            if (z) {
                this.W = a.None;
            }
            if (!this.Z) {
                this.W = a.MarkerChanged;
            }
            if (z && this.A != null && this.A.c()) {
                this.A.b();
                if (this.z != null) {
                    this.z.b();
                }
            }
            if (this.W == a.None) {
                this.W = a.DisAppear;
                if (this.w.d != null) {
                    a(this.w.d);
                    g();
                    AppMethodBeat.o(99626);
                }
            }
            if (this.W == a.DisAppear) {
                this.W = a.MarkerChanged;
                if (this.w.f != null) {
                    a(this.w.f);
                    g();
                    AppMethodBeat.o(99626);
                } else {
                    e();
                    f();
                    this.X = true;
                    this.w.b().a();
                }
            }
            if (this.W == a.MarkerChanged) {
                this.W = a.Appear;
                if (this.w.e != null) {
                    a(this.w.e);
                    g();
                    AppMethodBeat.o(99626);
                }
            }
            AppMethodBeat.o(99626);
        } else {
            e();
            f();
            this.X = true;
            this.w.b().a();
            AppMethodBeat.o(99626);
        }
    }

    /* Access modifiers changed, original: protected */
    public void h() {
        AppMethodBeat.i(99627);
        if (this.W == a.MarkerChanged) {
            e();
            f();
            this.w.b().a();
        }
        if (this.W != a.Appear) {
            a(false, false);
            AppMethodBeat.o(99627);
            return;
        }
        this.X = true;
        this.w.b().a();
        AppMethodBeat.o(99627);
    }

    public void c(boolean z) {
        this.X = z;
    }

    public void e() {
        AppMethodBeat.i(99628);
        synchronized (this.d) {
            try {
                if (!(this.af == null || this.af.isRecycled())) {
                    this.c = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99628);
            }
        }
    }

    public void b(Bitmap bitmap) {
        AppMethodBeat.i(99629);
        if (bitmap == null) {
            AppMethodBeat.o(99629);
            return;
        }
        synchronized (this.d) {
            try {
                this.b = bitmap;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99629);
            }
        }
        synchronized (this.aa) {
            try {
                if (!this.ac) {
                    a(bitmap);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(99629);
                }
            }
        }
        synchronized (this.d) {
            try {
                if (this.X) {
                    e();
                }
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.o(99629);
                }
            }
        }
    }

    public void a(GeoPoint geoPoint) {
        this.p = geoPoint;
    }

    public void b(GeoPoint geoPoint) {
        AppMethodBeat.i(99630);
        if (geoPoint == null) {
            AppMethodBeat.o(99630);
            return;
        }
        if (this.o == null) {
            this.o = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            this.o.setLatitudeE6(geoPoint.getLatitudeE6());
            this.o.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        if (this.a != null) {
            this.a.a(this.o);
        }
        if (this.X) {
            f();
        }
        AppMethodBeat.o(99630);
    }

    public void i() {
        AppMethodBeat.i(99631);
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
        if (this.S != null) {
            this.S.recycle();
            this.S = null;
        }
        if (this.ad != null) {
            this.ad.recycle();
            this.ad = null;
        }
        if (this.ae != null) {
            this.ae.recycle();
            this.ae = null;
        }
        synchronized (this.d) {
            try {
                if (this.af != null) {
                    this.af.recycle();
                    this.af = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99631);
            }
        }
    }

    public void d(boolean z) {
        AppMethodBeat.i(99632);
        this.U = z;
        this.w.b().a();
        AppMethodBeat.o(99632);
    }

    public boolean j() {
        return this.U;
    }

    public Rect a(fw fwVar) {
        Rect a;
        AppMethodBeat.i(99633);
        synchronized (this.aa) {
            try {
                if (this.a != null) {
                    e(false);
                    f(false);
                    a = this.a.a(fwVar);
                    e(this.ac);
                    f(this.ac);
                } else {
                    a = new Rect(0, 0, 0, 0);
                    AppMethodBeat.o(99633);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99633);
            }
        }
        return a;
    }

    public l k() {
        return this.a;
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(99634);
        this.ag = i;
        this.ai = i2;
        g(false);
        AppMethodBeat.o(99634);
    }

    public void a(int i) {
        AppMethodBeat.i(99635);
        this.ah = i;
        l();
        AppMethodBeat.o(99635);
    }

    private void f(boolean z) {
        AppMethodBeat.i(99636);
        synchronized (this.d) {
            if (z) {
                try {
                    if (this.ad != null) {
                        a(this.ad);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(99636);
                }
            } else if (this.b != null) {
                a(this.b);
            }
        }
        AppMethodBeat.o(99636);
    }

    public void e(boolean z) {
        AppMethodBeat.i(99637);
        g(z);
        if (this.a != null) {
            this.a.a(this.E, this.F);
        }
        AppMethodBeat.o(99637);
    }

    private void l() {
        int i = this.l;
        if (i == 0) {
            i = 1;
        }
        this.E = ((((float) this.ah) * 1.0f) / ((float) i)) + 0.5f;
    }

    private void g(boolean z) {
        AppMethodBeat.i(99638);
        int i = this.m;
        if (this.ad != null) {
            i = this.ad.getHeight();
        }
        if (i == 0) {
            i = 1;
        }
        if (z) {
            this.F = (-(((float) this.ai) + 5.0f)) / ((float) i);
            AppMethodBeat.o(99638);
            return;
        }
        this.F = ((((float) this.ag) + 5.0f) + ((float) i)) / ((float) i);
        AppMethodBeat.o(99638);
    }
}
