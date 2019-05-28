package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30988a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.im */
public class C46793im extends C31045fx {
    /* renamed from: A */
    float f18188A = 0.0f;
    /* renamed from: B */
    private final Runnable f18189B = new C365211();
    /* renamed from: C */
    private final Runnable f18190C = new C467922();
    /* renamed from: D */
    private C16283a f18191D = null;
    /* renamed from: E */
    private boolean f18192E = false;
    /* renamed from: F */
    private Interpolator f18193F = new LinearInterpolator();
    /* renamed from: G */
    private C30988a f18194G = null;
    /* renamed from: H */
    private boolean f18195H = false;
    /* renamed from: I */
    private boolean f18196I = false;
    /* renamed from: J */
    private boolean f18197J = false;
    /* renamed from: K */
    private int f18198K = 0;
    /* renamed from: L */
    private int f18199L = 0;
    /* renamed from: M */
    private int f18200M = 0;
    /* renamed from: N */
    private int f18201N = 0;
    /* renamed from: O */
    private int f18202O = 0;
    /* renamed from: P */
    private int f18203P = 0;
    /* renamed from: Q */
    private boolean f18204Q = false;
    /* renamed from: R */
    private boolean f18205R = false;
    /* renamed from: S */
    private boolean f18206S = false;
    /* renamed from: T */
    private boolean f18207T = false;
    /* renamed from: U */
    private float f18208U = 0.0f;
    /* renamed from: V */
    private float f18209V = 0.0f;
    /* renamed from: W */
    private double f18210W = 0.0d;
    /* renamed from: X */
    private double f18211X = 0.0d;
    /* renamed from: Y */
    private double f18212Y = 0.0d;
    /* renamed from: Z */
    private double f18213Z = 0.0d;
    /* renamed from: aa */
    private double f18214aa = 1.0d;
    /* renamed from: ab */
    private boolean f18215ab = false;
    /* renamed from: ac */
    private int f18216ac = 0;
    /* renamed from: ad */
    private int f18217ad = 0;
    /* renamed from: ae */
    private boolean f18218ae = false;
    /* renamed from: af */
    private boolean f18219af = false;
    /* renamed from: ag */
    private boolean f18220ag = false;
    /* renamed from: j */
    protected long f18221j = 500;
    /* renamed from: k */
    protected long f18222k = 0;
    /* renamed from: l */
    int f18223l = 0;
    /* renamed from: m */
    int f18224m = 0;
    /* renamed from: n */
    int f18225n = 0;
    /* renamed from: o */
    int f18226o = 0;
    /* renamed from: p */
    int f18227p = 0;
    /* renamed from: q */
    int f18228q = 0;
    /* renamed from: r */
    int f18229r = 0;
    /* renamed from: s */
    int f18230s = 0;
    /* renamed from: t */
    float f18231t = 0.0f;
    /* renamed from: u */
    float f18232u = 0.0f;
    /* renamed from: v */
    float f18233v = 0.0f;
    /* renamed from: w */
    float f18234w = 0.0f;
    /* renamed from: x */
    float f18235x = 0.0f;
    /* renamed from: y */
    float f18236y = 0.0f;
    /* renamed from: z */
    float f18237z = 0.0f;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.im$a */
    public interface C16283a {
        /* renamed from: a */
        float mo29514a();

        /* renamed from: a */
        void mo29515a(Runnable runnable);

        /* renamed from: b */
        int mo29516b();

        /* renamed from: c */
        GeoPoint mo29517c();

        /* renamed from: d */
        float mo29518d();

        /* renamed from: e */
        float mo29519e();

        /* renamed from: f */
        GeoPoint mo29520f();

        /* renamed from: g */
        boolean mo29521g();
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.im$1 */
    class C365211 implements Runnable {
        C365211() {
        }

        public void run() {
            AppMethodBeat.m2504i(99852);
            if (C46793im.this.f18194G == null) {
                AppMethodBeat.m2505o(99852);
                return;
            }
            C46793im.this.f18194G.mo50166a();
            AppMethodBeat.m2505o(99852);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.im$2 */
    class C467922 implements Runnable {
        C467922() {
        }

        public void run() {
            AppMethodBeat.m2504i(99853);
            if (C46793im.this.f18194G == null) {
                AppMethodBeat.m2505o(99853);
                return;
            }
            C46793im.this.f18194G.mo50167b();
            AppMethodBeat.m2505o(99853);
        }
    }

    public C46793im(int i) {
        super(i, null);
        AppMethodBeat.m2504i(99854);
        AppMethodBeat.m2505o(99854);
    }

    /* renamed from: a */
    public void mo75481a(C16283a c16283a) {
        this.f18191D = c16283a;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo29421a() {
        float f;
        AppMethodBeat.m2504i(99855);
        if (!this.f18192E) {
            this.f18192E = true;
            if (this.f18197J) {
                this.f18201N = 0;
                this.f18203P = 0;
            }
            if (this.f18204Q || this.f18205R || this.f18206S) {
                this.f18211X = 1.0d / Math.pow(2.0d, (double) (20.0f - this.f18191D.mo29514a()));
            }
            if (this.f18204Q) {
                int i = this.f18191D.mo29521g() ? 22 : 20;
                if (this.f18191D != null) {
                    i = Math.min(this.f18191D.mo29516b(), i);
                }
                if (this.f18208U >= ((float) i)) {
                    this.f18208U = (float) i;
                }
                if (this.f18191D != null) {
                    if (((double) Math.abs(this.f18208U - this.f18191D.mo29514a())) < 0.001d) {
                        this.f18207T = true;
                    }
                }
                this.f18210W = 1.0d / Math.pow(2.0d, (double) (20.0f - this.f18208U));
            } else if (this.f18205R) {
                if (((double) Math.abs(this.f18209V)) < 0.001d) {
                    this.f18207T = true;
                }
                this.f18210W = 1.0d / Math.pow(2.0d, (double) (20.0f - (this.f18191D.mo29514a() + this.f18209V)));
            }
            if (this.f18218ae && this.f18191D != null) {
                GeoPoint f2;
                if (this.f18195H) {
                    f2 = this.f18191D.mo29520f();
                } else {
                    f2 = this.f18191D.mo29517c();
                }
                if (f2 != null) {
                    this.f18225n = f2.getLatitudeE6();
                    this.f18226o = f2.getLongitudeE6();
                    this.f18227p = this.f18223l - this.f18225n;
                    this.f18228q = this.f18224m - this.f18226o;
                }
            }
            if (this.f18219af) {
                if (this.f18191D != null) {
                    this.f18232u = this.f18191D.mo29518d();
                }
                this.f18233v = this.f18231t - this.f18232u;
                if (this.f18233v > 180.0f) {
                    this.f18233v -= 360.0f;
                } else if (this.f18233v < -180.0f) {
                    this.f18233v += 360.0f;
                }
            }
            if (this.f18220ag && this.f18191D != null) {
                this.f18236y = this.f18191D.mo29519e();
                this.f18237z = this.f18235x - this.f18236y;
            }
            this.f18222k = mo75487d();
        }
        if (this.f18196I) {
            f = 1.0f;
        } else {
            f = ((float) (mo75487d() - this.f18222k)) / ((float) this.f18221j);
            if (f > 1.0f) {
                f = 1.0f;
            }
        }
        float interpolation = this.f18193F.getInterpolation(f);
        this.f18196I = true;
        if (this.f18197J) {
            this.f18200M = (int) (((float) this.f18198K) * interpolation);
            this.f18202O = (int) (((float) this.f18199L) * interpolation);
            int i2 = this.f18200M - this.f18201N;
            int i3 = this.f18202O - this.f18203P;
            this.f18201N = this.f18200M;
            this.f18203P = this.f18202O;
            this.f18200M = i2;
            this.f18202O = i3;
            if (Math.abs(this.f18198K) > 0 || Math.abs(this.f18199L) > 0) {
                this.f18196I = false;
            }
        }
        if (this.f18204Q || this.f18205R || this.f18206S) {
            this.f18212Y = this.f18211X + ((this.f18210W - this.f18211X) * ((double) interpolation));
            if (!this.f18207T) {
                this.f18196I = false;
            }
        }
        if (this.f18218ae) {
            this.f18229r = this.f18225n + ((int) (((float) this.f18227p) * interpolation));
            this.f18230s = this.f18226o + ((int) (((float) this.f18228q) * interpolation));
            if (Math.abs(this.f18227p) > 1 || Math.abs(this.f18228q) > 1) {
                this.f18196I = false;
            }
        }
        if (this.f18219af) {
            this.f18234w = this.f18232u + (this.f18233v * interpolation);
            if (Math.abs(this.f18233v) > 1.0f) {
                this.f18196I = false;
            }
        }
        if (this.f18220ag) {
            this.f18188A = (interpolation * this.f18237z) + this.f18236y;
            if (Math.abs(this.f18237z) > 1.0f) {
                this.f18196I = false;
            }
        }
        if (f >= 1.0f) {
            if (!(this.f18194G == null || this.f18191D == null)) {
                this.f18191D.mo29515a(this.f18189B);
            }
            AppMethodBeat.m2505o(99855);
            return true;
        }
        AppMethodBeat.m2505o(99855);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public long mo75487d() {
        AppMethodBeat.m2504i(99856);
        long uptimeMillis = SystemClock.uptimeMillis();
        AppMethodBeat.m2505o(99856);
        return uptimeMillis;
    }

    /* renamed from: a */
    public void mo75478a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.f18197J = false;
        }
        this.f18198K = i;
        this.f18199L = i2;
        this.f18197J = true;
    }

    /* renamed from: e */
    public boolean mo75489e() {
        return this.f18197J;
    }

    /* renamed from: f */
    public int mo75490f() {
        return this.f18200M;
    }

    /* renamed from: g */
    public int mo75491g() {
        return this.f18202O;
    }

    /* renamed from: a */
    public void mo75477a(float f) {
        if (f > 0.0f) {
            this.f18208U = f;
            this.f18204Q = true;
        }
    }

    /* renamed from: b */
    public void mo75483b(float f) {
        if (f != 0.0f) {
            this.f18209V = f;
            this.f18205R = true;
        }
    }

    /* renamed from: h */
    public boolean mo75492h() {
        return this.f18205R || this.f18204Q || this.f18206S;
    }

    /* renamed from: i */
    public float mo75493i() {
        return (float) this.f18212Y;
    }

    /* renamed from: b */
    public void mo75484b(int i, int i2) {
        this.f18216ac = i;
        this.f18217ad = i2;
        this.f18215ab = true;
    }

    /* renamed from: j */
    public boolean mo75494j() {
        return this.f18215ab;
    }

    /* renamed from: k */
    public int mo75495k() {
        return this.f18216ac;
    }

    /* renamed from: l */
    public int mo75496l() {
        return this.f18217ad;
    }

    /* renamed from: c */
    public void mo75486c(int i, int i2) {
        this.f18223l = i;
        this.f18224m = i2;
        this.f18218ae = true;
    }

    /* renamed from: m */
    public boolean mo75497m() {
        return this.f18218ae;
    }

    /* renamed from: n */
    public int mo75498n() {
        return this.f18229r;
    }

    /* renamed from: o */
    public int mo75499o() {
        return this.f18230s;
    }

    /* renamed from: c */
    public void mo75485c(float f) {
        AppMethodBeat.m2504i(99857);
        this.f18231t = m88926e(f);
        this.f18219af = true;
        AppMethodBeat.m2505o(99857);
    }

    /* renamed from: p */
    public float mo75500p() {
        return this.f18234w;
    }

    /* renamed from: q */
    public boolean mo75501q() {
        return this.f18219af;
    }

    /* renamed from: d */
    public void mo75488d(float f) {
        AppMethodBeat.m2504i(99858);
        this.f18235x = m88927f(f);
        this.f18220ag = true;
        AppMethodBeat.m2505o(99858);
    }

    /* renamed from: r */
    public boolean mo75502r() {
        return this.f18220ag;
    }

    /* renamed from: s */
    public float mo75503s() {
        return this.f18188A;
    }

    /* renamed from: e */
    private float m88926e(float f) {
        return ((f % 360.0f) + 360.0f) % 360.0f;
    }

    /* renamed from: f */
    private float m88927f(float f) {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        if (f2 > 45.0f) {
            return 45.0f;
        }
        return f2;
    }

    /* renamed from: a */
    public void mo75480a(C30988a c30988a) {
        this.f18194G = c30988a;
    }

    /* renamed from: b */
    public void mo29422b() {
        AppMethodBeat.m2504i(99859);
        super.mo29422b();
        this.f18196I = true;
        if (!(this.f18194G == null || this.f18191D == null)) {
            this.f18191D.mo29515a(this.f18190C);
        }
        AppMethodBeat.m2505o(99859);
    }

    /* renamed from: a */
    public void mo75479a(long j) {
        this.f18221j = j;
    }

    /* renamed from: a */
    public void mo75482a(boolean z) {
        this.f18195H = z;
    }

    /* renamed from: t */
    public boolean mo75504t() {
        return this.f18195H;
    }
}
