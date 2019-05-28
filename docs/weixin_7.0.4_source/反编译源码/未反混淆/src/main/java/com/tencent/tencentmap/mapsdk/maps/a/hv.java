package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.element.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cl;
import com.tencent.tencentmap.mapsdk.a.de;
import com.tencent.tencentmap.mapsdk.a.df;
import com.tencent.tencentmap.mapsdk.maps.a.if.a;
import com.tencent.tencentmap.mapsdk.maps.a.if.b;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public class hv extends hz {
    private static AtomicInteger S = new AtomicInteger(0);
    protected if A = null;
    protected boolean B = false;
    protected int C = 0;
    protected int D = 0;
    protected float E = 0.5f;
    protected float F = 0.5f;
    public int G = 0;
    public int H = 0;
    private boolean R = false;
    private Runnable T = new Runnable() {
        public void run() {
            AppMethodBeat.i(99598);
            if (hv.this.z != null) {
                hv.this.z.a();
            }
            AppMethodBeat.o(99598);
        }
    };
    private Runnable U = new Runnable() {
        public void run() {
            AppMethodBeat.i(99599);
            hv.this.e = 0.0f;
            if (hv.this.z != null) {
                hv.this.z.b();
            }
            AppMethodBeat.o(99599);
        }
    };
    private a V = new a() {
        public void a() {
            AppMethodBeat.i(99600);
            hv.this.h();
            hv.this.w.I.post(hv.this.U);
            AppMethodBeat.o(99600);
        }

        public void b() {
            AppMethodBeat.i(99601);
            hv.this.w.I.post(hv.this.T);
            AppMethodBeat.o(99601);
        }
    };
    private b W = new b() {
        public void a(float f, float f2, float f3, float f4) {
            hv.this.e = f;
            hv.this.e %= 360.0f;
            hv.this.e += 360.0f;
            hv.this.e %= 360.0f;
            hv.this.g = f2;
            hv.this.h = f3;
            hv.this.i = f4;
            hv.this.f = true;
        }

        public void a(float f) {
            AppMethodBeat.i(99602);
            hv.this.q = f;
            if (hv.this.a != null) {
                hv.this.a.a(hv.this.q);
            }
            AppMethodBeat.o(99602);
        }

        public void a(int i, int i2) {
            AppMethodBeat.i(99603);
            if (hv.this.n != null) {
                hv.this.n.setLatitudeE6(i);
                hv.this.n.setLongitudeE6(i2);
                if (hv.this.a != null) {
                    hv.this.a.a(hv.this.n);
                }
            }
            AppMethodBeat.o(99603);
        }

        public void a(float f, float f2) {
            AppMethodBeat.i(99604);
            hv.this.r = f;
            hv.this.s = f2;
            if (hv.this.a != null) {
                hv.this.a.b(hv.this.r, hv.this.s);
            }
            AppMethodBeat.o(99604);
        }

        public void b(float f) {
        }
    };
    protected l a;
    protected Bitmap b = null;
    boolean c = false;
    protected byte[] d = new byte[0];
    protected float e = 0.0f;
    protected boolean f = false;
    protected float g = 0.0f;
    protected float h = 0.0f;
    protected float i = -1.0f;
    protected String j = null;
    String k = null;
    public int l = 0;
    public int m = 0;
    protected GeoPoint n = null;
    protected GeoPoint o = null;
    protected GeoPoint p = null;
    protected float q = 1.0f;
    protected float r = 1.0f;
    protected float s = 1.0f;
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;
    protected iz w = null;
    public de x = null;
    public df y = null;
    protected cl z = null;

    static {
        AppMethodBeat.i(99620);
        AppMethodBeat.o(99620);
    }

    public hv(iz izVar) {
        AppMethodBeat.i(99605);
        this.w = izVar;
        i();
        AppMethodBeat.o(99605);
    }

    public void a(df dfVar) {
        AppMethodBeat.i(99606);
        if (dfVar == null) {
            AppMethodBeat.o(99606);
            return;
        }
        this.y = dfVar;
        a(dfVar.i());
        a(dfVar.o());
        b(dfVar.k());
        a_(dfVar.x());
        c(dfVar);
        AppMethodBeat.o(99606);
    }

    public void b(boolean z) {
        this.B = z;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(99607);
        this.C = i;
        this.D = i2;
        if (this.a != null) {
            b(true);
            this.a.a(new GeoPoint(this.D, this.C));
        }
        AppMethodBeat.o(99607);
    }

    public void a(float f) {
        this.e = f;
    }

    /* Access modifiers changed, original: protected */
    public void a(Bitmap bitmap) {
        AppMethodBeat.i(99608);
        synchronized (this.d) {
            try {
                this.j = (bitmap.hashCode() + S.getAndIncrement());
                if (this.a != null) {
                    this.a.a(this.j, bitmap);
                }
                this.l = bitmap.getWidth();
                this.m = bitmap.getHeight();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99608);
            }
        }
    }

    public void b(Bitmap bitmap) {
        AppMethodBeat.i(99609);
        if (bitmap == null) {
            AppMethodBeat.o(99609);
            return;
        }
        a(bitmap);
        e();
        AppMethodBeat.o(99609);
    }

    public void e() {
        AppMethodBeat.i(99610);
        synchronized (this.d) {
            try {
                if (!(this.b == null || this.b.isRecycled())) {
                    this.c = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99610);
            }
        }
    }

    public void f() {
        if (this.o != null) {
            this.R = true;
        }
    }

    public void a(GL10 gl10) {
        AppMethodBeat.i(99611);
        if (a()) {
            b(this.y);
            b(gl10);
            gj z = this.w.b().z();
            if (!(z == null || this.a == null)) {
                this.a.b(z, this.w.b().t());
            }
            AppMethodBeat.o(99611);
            return;
        }
        AppMethodBeat.o(99611);
    }

    public boolean a(float f, float f2) {
        boolean z = false;
        AppMethodBeat.i(99612);
        if (!this.v || this.a == null) {
            AppMethodBeat.o(99612);
        } else {
            if (this.a != null) {
                z = this.a.a(this.w.b().t(), f, f2);
                Rect b = this.a.b(this.w.b().t());
                if (!z || b == null) {
                    this.G = -1;
                    this.H = -1;
                } else {
                    this.G = ((int) f) - b.left;
                    this.H = ((int) f2) - b.top;
                }
            }
            AppMethodBeat.o(99612);
        }
        return z;
    }

    public boolean a() {
        return this.O;
    }

    public void a(boolean z) {
        this.O = z;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        this.w = null;
        this.n = null;
    }

    public void a(if ifVar) {
        AppMethodBeat.i(99613);
        this.A = ifVar;
        if (this.A != null) {
            this.A.a(this.V);
            this.A.a(this.W);
        }
        AppMethodBeat.o(99613);
    }

    public boolean g() {
        AppMethodBeat.i(99614);
        if (this.A == null) {
            AppMethodBeat.o(99614);
            return false;
        }
        boolean a = this.A.a(this.n, this.p);
        AppMethodBeat.o(99614);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public boolean b(GL10 gl10) {
        AppMethodBeat.i(99615);
        if (this.A != null) {
            this.A.d();
            if (this.A.c()) {
                this.w.b().a();
            }
            AppMethodBeat.o(99615);
            return true;
        }
        AppMethodBeat.o(99615);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void h() {
    }

    public void b(float f) {
        this.q = f;
    }

    private void i() {
        AppMethodBeat.i(99616);
        m mVar = new m();
        if (this.a == null) {
            this.a = new l(mVar);
            AppMethodBeat.o(99616);
            return;
        }
        this.a.a(mVar);
        AppMethodBeat.o(99616);
    }

    private void b(df dfVar) {
        AppMethodBeat.i(99617);
        if (dfVar == null || this.a != null) {
            AppMethodBeat.o(99617);
            return;
        }
        m d = d(dfVar);
        if (d == null) {
            AppMethodBeat.o(99617);
            return;
        }
        this.a = new l(d);
        AppMethodBeat.o(99617);
    }

    private void c(df dfVar) {
        AppMethodBeat.i(99618);
        if (dfVar == null) {
            AppMethodBeat.o(99618);
            return;
        }
        m d = d(dfVar);
        if (d == null) {
            AppMethodBeat.o(99618);
        } else if (this.a == null) {
            this.a = new l(d);
            AppMethodBeat.o(99618);
        } else {
            this.a.a(d);
            AppMethodBeat.o(99618);
        }
    }

    private m d(df dfVar) {
        AppMethodBeat.i(99619);
        if (dfVar == null) {
            AppMethodBeat.o(99619);
            return null;
        }
        int s = dfVar.s();
        m a = new m().a(dfVar.k()).a(this.E - ((((float) s) * 1.0f) / ((float) this.l)), this.F - ((((float) dfVar.t()) * 1.0f) / ((float) this.m))).a(dfVar.s(), dfVar.t()).b(false).b((int) dfVar.l()).c(dfVar.x()).d(this.B).a(true);
        AppMethodBeat.o(99619);
        return a;
    }
}
