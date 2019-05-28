package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class im extends fx {
    float A = 0.0f;
    private final Runnable B = new Runnable() {
        public void run() {
            AppMethodBeat.i(99852);
            if (im.this.G == null) {
                AppMethodBeat.o(99852);
                return;
            }
            im.this.G.a();
            AppMethodBeat.o(99852);
        }
    };
    private final Runnable C = new Runnable() {
        public void run() {
            AppMethodBeat.i(99853);
            if (im.this.G == null) {
                AppMethodBeat.o(99853);
                return;
            }
            im.this.G.b();
            AppMethodBeat.o(99853);
        }
    };
    private a D = null;
    private boolean E = false;
    private Interpolator F = new LinearInterpolator();
    private com.tencent.tencentmap.mapsdk.a.aj.a G = null;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private float U = 0.0f;
    private float V = 0.0f;
    private double W = 0.0d;
    private double X = 0.0d;
    private double Y = 0.0d;
    private double Z = 0.0d;
    private double aa = 1.0d;
    private boolean ab = false;
    private int ac = 0;
    private int ad = 0;
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = false;
    protected long j = 500;
    protected long k = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    int o = 0;
    int p = 0;
    int q = 0;
    int r = 0;
    int s = 0;
    float t = 0.0f;
    float u = 0.0f;
    float v = 0.0f;
    float w = 0.0f;
    float x = 0.0f;
    float y = 0.0f;
    float z = 0.0f;

    public interface a {
        float a();

        void a(Runnable runnable);

        int b();

        GeoPoint c();

        float d();

        float e();

        GeoPoint f();

        boolean g();
    }

    public im(int i) {
        super(i, null);
        AppMethodBeat.i(99854);
        AppMethodBeat.o(99854);
    }

    public void a(a aVar) {
        this.D = aVar;
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        float f;
        AppMethodBeat.i(99855);
        if (!this.E) {
            this.E = true;
            if (this.J) {
                this.N = 0;
                this.P = 0;
            }
            if (this.Q || this.R || this.S) {
                this.X = 1.0d / Math.pow(2.0d, (double) (20.0f - this.D.a()));
            }
            if (this.Q) {
                int i = this.D.g() ? 22 : 20;
                if (this.D != null) {
                    i = Math.min(this.D.b(), i);
                }
                if (this.U >= ((float) i)) {
                    this.U = (float) i;
                }
                if (this.D != null) {
                    if (((double) Math.abs(this.U - this.D.a())) < 0.001d) {
                        this.T = true;
                    }
                }
                this.W = 1.0d / Math.pow(2.0d, (double) (20.0f - this.U));
            } else if (this.R) {
                if (((double) Math.abs(this.V)) < 0.001d) {
                    this.T = true;
                }
                this.W = 1.0d / Math.pow(2.0d, (double) (20.0f - (this.D.a() + this.V)));
            }
            if (this.ae && this.D != null) {
                GeoPoint f2;
                if (this.H) {
                    f2 = this.D.f();
                } else {
                    f2 = this.D.c();
                }
                if (f2 != null) {
                    this.n = f2.getLatitudeE6();
                    this.o = f2.getLongitudeE6();
                    this.p = this.l - this.n;
                    this.q = this.m - this.o;
                }
            }
            if (this.af) {
                if (this.D != null) {
                    this.u = this.D.d();
                }
                this.v = this.t - this.u;
                if (this.v > 180.0f) {
                    this.v -= 360.0f;
                } else if (this.v < -180.0f) {
                    this.v += 360.0f;
                }
            }
            if (this.ag && this.D != null) {
                this.y = this.D.e();
                this.z = this.x - this.y;
            }
            this.k = d();
        }
        if (this.I) {
            f = 1.0f;
        } else {
            f = ((float) (d() - this.k)) / ((float) this.j);
            if (f > 1.0f) {
                f = 1.0f;
            }
        }
        float interpolation = this.F.getInterpolation(f);
        this.I = true;
        if (this.J) {
            this.M = (int) (((float) this.K) * interpolation);
            this.O = (int) (((float) this.L) * interpolation);
            int i2 = this.M - this.N;
            int i3 = this.O - this.P;
            this.N = this.M;
            this.P = this.O;
            this.M = i2;
            this.O = i3;
            if (Math.abs(this.K) > 0 || Math.abs(this.L) > 0) {
                this.I = false;
            }
        }
        if (this.Q || this.R || this.S) {
            this.Y = this.X + ((this.W - this.X) * ((double) interpolation));
            if (!this.T) {
                this.I = false;
            }
        }
        if (this.ae) {
            this.r = this.n + ((int) (((float) this.p) * interpolation));
            this.s = this.o + ((int) (((float) this.q) * interpolation));
            if (Math.abs(this.p) > 1 || Math.abs(this.q) > 1) {
                this.I = false;
            }
        }
        if (this.af) {
            this.w = this.u + (this.v * interpolation);
            if (Math.abs(this.v) > 1.0f) {
                this.I = false;
            }
        }
        if (this.ag) {
            this.A = (interpolation * this.z) + this.y;
            if (Math.abs(this.z) > 1.0f) {
                this.I = false;
            }
        }
        if (f >= 1.0f) {
            if (!(this.G == null || this.D == null)) {
                this.D.a(this.B);
            }
            AppMethodBeat.o(99855);
            return true;
        }
        AppMethodBeat.o(99855);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public long d() {
        AppMethodBeat.i(99856);
        long uptimeMillis = SystemClock.uptimeMillis();
        AppMethodBeat.o(99856);
        return uptimeMillis;
    }

    public void a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.J = false;
        }
        this.K = i;
        this.L = i2;
        this.J = true;
    }

    public boolean e() {
        return this.J;
    }

    public int f() {
        return this.M;
    }

    public int g() {
        return this.O;
    }

    public void a(float f) {
        if (f > 0.0f) {
            this.U = f;
            this.Q = true;
        }
    }

    public void b(float f) {
        if (f != 0.0f) {
            this.V = f;
            this.R = true;
        }
    }

    public boolean h() {
        return this.R || this.Q || this.S;
    }

    public float i() {
        return (float) this.Y;
    }

    public void b(int i, int i2) {
        this.ac = i;
        this.ad = i2;
        this.ab = true;
    }

    public boolean j() {
        return this.ab;
    }

    public int k() {
        return this.ac;
    }

    public int l() {
        return this.ad;
    }

    public void c(int i, int i2) {
        this.l = i;
        this.m = i2;
        this.ae = true;
    }

    public boolean m() {
        return this.ae;
    }

    public int n() {
        return this.r;
    }

    public int o() {
        return this.s;
    }

    public void c(float f) {
        AppMethodBeat.i(99857);
        this.t = e(f);
        this.af = true;
        AppMethodBeat.o(99857);
    }

    public float p() {
        return this.w;
    }

    public boolean q() {
        return this.af;
    }

    public void d(float f) {
        AppMethodBeat.i(99858);
        this.x = f(f);
        this.ag = true;
        AppMethodBeat.o(99858);
    }

    public boolean r() {
        return this.ag;
    }

    public float s() {
        return this.A;
    }

    private float e(float f) {
        return ((f % 360.0f) + 360.0f) % 360.0f;
    }

    private float f(float f) {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        if (f2 > 45.0f) {
            return 45.0f;
        }
        return f2;
    }

    public void a(com.tencent.tencentmap.mapsdk.a.aj.a aVar) {
        this.G = aVar;
    }

    public void b() {
        AppMethodBeat.i(99859);
        super.b();
        this.I = true;
        if (!(this.G == null || this.D == null)) {
            this.D.a(this.C);
        }
        AppMethodBeat.o(99859);
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(boolean z) {
        this.H = z;
    }

    public boolean t() {
        return this.H;
    }
}
