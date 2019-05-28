package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41719m;
import com.tencent.map.lib.element.C44680l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31056if.C31057a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31056if.C31058b;
import com.tencent.tencentmap.mapsdk.p666a.C36466cl;
import com.tencent.tencentmap.mapsdk.p666a.C44490de;
import com.tencent.tencentmap.mapsdk.p666a.C44491df;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hv */
public class C16273hv extends C36519hz {
    /* renamed from: S */
    private static AtomicInteger f3370S = new AtomicInteger(0);
    /* renamed from: A */
    protected C31056if f3371A = null;
    /* renamed from: B */
    protected boolean f3372B = false;
    /* renamed from: C */
    protected int f3373C = 0;
    /* renamed from: D */
    protected int f3374D = 0;
    /* renamed from: E */
    protected float f3375E = 0.5f;
    /* renamed from: F */
    protected float f3376F = 0.5f;
    /* renamed from: G */
    public int f3377G = 0;
    /* renamed from: H */
    public int f3378H = 0;
    /* renamed from: R */
    private boolean f3379R = false;
    /* renamed from: T */
    private Runnable f3380T = new C162771();
    /* renamed from: U */
    private Runnable f3381U = new C162752();
    /* renamed from: V */
    private C31057a f3382V = new C162763();
    /* renamed from: W */
    private C31058b f3383W = new C162744();
    /* renamed from: a */
    protected C44680l f3384a;
    /* renamed from: b */
    protected Bitmap f3385b = null;
    /* renamed from: c */
    boolean f3386c = false;
    /* renamed from: d */
    protected byte[] f3387d = new byte[0];
    /* renamed from: e */
    protected float f3388e = 0.0f;
    /* renamed from: f */
    protected boolean f3389f = false;
    /* renamed from: g */
    protected float f3390g = 0.0f;
    /* renamed from: h */
    protected float f3391h = 0.0f;
    /* renamed from: i */
    protected float f3392i = -1.0f;
    /* renamed from: j */
    protected String f3393j = null;
    /* renamed from: k */
    String f3394k = null;
    /* renamed from: l */
    public int f3395l = 0;
    /* renamed from: m */
    public int f3396m = 0;
    /* renamed from: n */
    protected GeoPoint f3397n = null;
    /* renamed from: o */
    protected GeoPoint f3398o = null;
    /* renamed from: p */
    protected GeoPoint f3399p = null;
    /* renamed from: q */
    protected float f3400q = 1.0f;
    /* renamed from: r */
    protected float f3401r = 1.0f;
    /* renamed from: s */
    protected float f3402s = 1.0f;
    /* renamed from: t */
    public boolean f3403t = false;
    /* renamed from: u */
    public boolean f3404u = false;
    /* renamed from: v */
    public boolean f3405v = true;
    /* renamed from: w */
    protected C31061iz f3406w = null;
    /* renamed from: x */
    public C44490de f3407x = null;
    /* renamed from: y */
    public C44491df f3408y = null;
    /* renamed from: z */
    protected C36466cl f3409z = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hv$4 */
    class C162744 implements C31058b {
        C162744() {
        }

        /* renamed from: a */
        public void mo29455a(float f, float f2, float f3, float f4) {
            C16273hv.this.f3388e = f;
            C16273hv.this.f3388e %= 360.0f;
            C16273hv.this.f3388e += 360.0f;
            C16273hv.this.f3388e %= 360.0f;
            C16273hv.this.f3390g = f2;
            C16273hv.this.f3391h = f3;
            C16273hv.this.f3392i = f4;
            C16273hv.this.f3389f = true;
        }

        /* renamed from: a */
        public void mo29453a(float f) {
            AppMethodBeat.m2504i(99602);
            C16273hv.this.f3400q = f;
            if (C16273hv.this.f3384a != null) {
                C16273hv.this.f3384a.mo71707a(C16273hv.this.f3400q);
            }
            AppMethodBeat.m2505o(99602);
        }

        /* renamed from: a */
        public void mo29456a(int i, int i2) {
            AppMethodBeat.m2504i(99603);
            if (C16273hv.this.f3397n != null) {
                C16273hv.this.f3397n.setLatitudeE6(i);
                C16273hv.this.f3397n.setLongitudeE6(i2);
                if (C16273hv.this.f3384a != null) {
                    C16273hv.this.f3384a.mo71710a(C16273hv.this.f3397n);
                }
            }
            AppMethodBeat.m2505o(99603);
        }

        /* renamed from: a */
        public void mo29454a(float f, float f2) {
            AppMethodBeat.m2504i(99604);
            C16273hv.this.f3401r = f;
            C16273hv.this.f3402s = f2;
            if (C16273hv.this.f3384a != null) {
                C16273hv.this.f3384a.mo71716b(C16273hv.this.f3401r, C16273hv.this.f3402s);
            }
            AppMethodBeat.m2505o(99604);
        }

        /* renamed from: b */
        public void mo29457b(float f) {
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hv$2 */
    class C162752 implements Runnable {
        C162752() {
        }

        public void run() {
            AppMethodBeat.m2504i(99599);
            C16273hv.this.f3388e = 0.0f;
            if (C16273hv.this.f3409z != null) {
                C16273hv.this.f3409z.mo57691b();
            }
            AppMethodBeat.m2505o(99599);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hv$3 */
    class C162763 implements C31057a {
        C162763() {
        }

        /* renamed from: a */
        public void mo29459a() {
            AppMethodBeat.m2504i(99600);
            C16273hv.this.mo12489h();
            C16273hv.this.f3406w.f14195I.post(C16273hv.this.f3381U);
            AppMethodBeat.m2505o(99600);
        }

        /* renamed from: b */
        public void mo29460b() {
            AppMethodBeat.m2504i(99601);
            C16273hv.this.f3406w.f14195I.post(C16273hv.this.f3380T);
            AppMethodBeat.m2505o(99601);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hv$1 */
    class C162771 implements Runnable {
        C162771() {
        }

        public void run() {
            AppMethodBeat.m2504i(99598);
            if (C16273hv.this.f3409z != null) {
                C16273hv.this.f3409z.mo57690a();
            }
            AppMethodBeat.m2505o(99598);
        }
    }

    static {
        AppMethodBeat.m2504i(99620);
        AppMethodBeat.m2505o(99620);
    }

    public C16273hv(C31061iz c31061iz) {
        AppMethodBeat.m2504i(99605);
        this.f3406w = c31061iz;
        mo12490i();
        AppMethodBeat.m2505o(99605);
    }

    /* renamed from: a */
    public void mo12480a(C44491df c44491df) {
        AppMethodBeat.m2504i(99606);
        if (c44491df == null) {
            AppMethodBeat.m2505o(99606);
            return;
        }
        this.f3408y = c44491df;
        mo29442a(c44491df.mo70791i());
        mo29437a(c44491df.mo70797o());
        mo29446b(c44491df.mo70793k());
        mo50174a_(c44491df.mo70806x());
        m24962c(c44491df);
        AppMethodBeat.m2505o(99606);
    }

    /* renamed from: b */
    public void mo29447b(boolean z) {
        this.f3372B = z;
    }

    /* renamed from: a */
    public void mo29438a(int i, int i2) {
        AppMethodBeat.m2504i(99607);
        this.f3373C = i;
        this.f3374D = i2;
        if (this.f3384a != null) {
            mo29447b(true);
            this.f3384a.mo71710a(new GeoPoint(this.f3374D, this.f3373C));
        }
        AppMethodBeat.m2505o(99607);
    }

    /* renamed from: a */
    public void mo29437a(float f) {
        this.f3388e = f;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29439a(Bitmap bitmap) {
        AppMethodBeat.m2504i(99608);
        synchronized (this.f3387d) {
            try {
                this.f3393j = (bitmap.hashCode() + f3370S.getAndIncrement());
                if (this.f3384a != null) {
                    this.f3384a.mo71712a(this.f3393j, bitmap);
                }
                this.f3395l = bitmap.getWidth();
                this.f3396m = bitmap.getHeight();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99608);
            }
        }
    }

    /* renamed from: b */
    public void mo12483b(Bitmap bitmap) {
        AppMethodBeat.m2504i(99609);
        if (bitmap == null) {
            AppMethodBeat.m2505o(99609);
            return;
        }
        mo29439a(bitmap);
        mo12487e();
        AppMethodBeat.m2505o(99609);
    }

    /* renamed from: e */
    public void mo12487e() {
        AppMethodBeat.m2504i(99610);
        synchronized (this.f3387d) {
            try {
                if (!(this.f3385b == null || this.f3385b.isRecycled())) {
                    this.f3386c = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99610);
            }
        }
    }

    /* renamed from: f */
    public void mo29451f() {
        if (this.f3398o != null) {
            this.f3379R = true;
        }
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
        AppMethodBeat.m2504i(99611);
        if (mo29443a()) {
            m24961b(this.f3408y);
            mo29448b(gl10);
            C16263gj z = this.f3406w.mo75386b().mo20250z();
            if (!(z == null || this.f3384a == null)) {
                this.f3384a.mo20132b(z, this.f3406w.mo75386b().mo20244t());
            }
            AppMethodBeat.m2505o(99611);
            return;
        }
        AppMethodBeat.m2505o(99611);
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        boolean z = false;
        AppMethodBeat.m2504i(99612);
        if (!this.f3405v || this.f3384a == null) {
            AppMethodBeat.m2505o(99612);
        } else {
            if (this.f3384a != null) {
                z = this.f3384a.mo20130a(this.f3406w.mo75386b().mo20244t(), f, f2);
                Rect b = this.f3384a.mo71715b(this.f3406w.mo75386b().mo20244t());
                if (!z || b == null) {
                    this.f3377G = -1;
                    this.f3378H = -1;
                } else {
                    this.f3377G = ((int) f) - b.left;
                    this.f3378H = ((int) f2) - b.top;
                }
            }
            AppMethodBeat.m2505o(99612);
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        return this.f13965O;
    }

    /* renamed from: a */
    public void mo29442a(boolean z) {
        this.f13965O = z;
    }

    /* renamed from: b */
    public void mo29445b() {
    }

    /* renamed from: c */
    public void mo29449c() {
    }

    /* renamed from: d */
    public void mo29450d() {
        this.f3406w = null;
        this.f3397n = null;
    }

    /* renamed from: a */
    public void mo29440a(C31056if c31056if) {
        AppMethodBeat.m2504i(99613);
        this.f3371A = c31056if;
        if (this.f3371A != null) {
            this.f3371A.mo50390a(this.f3382V);
            this.f3371A.mo29510a(this.f3383W);
        }
        AppMethodBeat.m2505o(99613);
    }

    /* renamed from: g */
    public boolean mo29452g() {
        AppMethodBeat.m2504i(99614);
        if (this.f3371A == null) {
            AppMethodBeat.m2505o(99614);
            return false;
        }
        boolean a = this.f3371A.mo29512a(this.f3397n, this.f3399p);
        AppMethodBeat.m2505o(99614);
        return a;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo29448b(GL10 gl10) {
        AppMethodBeat.m2504i(99615);
        if (this.f3371A != null) {
            this.f3371A.mo50393d();
            if (this.f3371A.mo50392c()) {
                this.f3406w.mo75386b().mo20154a();
            }
            AppMethodBeat.m2505o(99615);
            return true;
        }
        AppMethodBeat.m2505o(99615);
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: h */
    public void mo12489h() {
    }

    /* renamed from: b */
    public void mo29446b(float f) {
        this.f3400q = f;
    }

    /* renamed from: i */
    private void mo12490i() {
        AppMethodBeat.m2504i(99616);
        C41719m c41719m = new C41719m();
        if (this.f3384a == null) {
            this.f3384a = new C44680l(c41719m);
            AppMethodBeat.m2505o(99616);
            return;
        }
        this.f3384a.mo71711a(c41719m);
        AppMethodBeat.m2505o(99616);
    }

    /* renamed from: b */
    private void m24961b(C44491df c44491df) {
        AppMethodBeat.m2504i(99617);
        if (c44491df == null || this.f3384a != null) {
            AppMethodBeat.m2505o(99617);
            return;
        }
        C41719m d = m24963d(c44491df);
        if (d == null) {
            AppMethodBeat.m2505o(99617);
            return;
        }
        this.f3384a = new C44680l(d);
        AppMethodBeat.m2505o(99617);
    }

    /* renamed from: c */
    private void m24962c(C44491df c44491df) {
        AppMethodBeat.m2504i(99618);
        if (c44491df == null) {
            AppMethodBeat.m2505o(99618);
            return;
        }
        C41719m d = m24963d(c44491df);
        if (d == null) {
            AppMethodBeat.m2505o(99618);
        } else if (this.f3384a == null) {
            this.f3384a = new C44680l(d);
            AppMethodBeat.m2505o(99618);
        } else {
            this.f3384a.mo71711a(d);
            AppMethodBeat.m2505o(99618);
        }
    }

    /* renamed from: d */
    private C41719m m24963d(C44491df c44491df) {
        AppMethodBeat.m2504i(99619);
        if (c44491df == null) {
            AppMethodBeat.m2505o(99619);
            return null;
        }
        int s = c44491df.mo70801s();
        C41719m a = new C41719m().mo67431a(c44491df.mo70793k()).mo67432a(this.f3375E - ((((float) s) * 1.0f) / ((float) this.f3395l)), this.f3376F - ((((float) c44491df.mo70802t()) * 1.0f) / ((float) this.f3396m))).mo67434a(c44491df.mo70801s(), c44491df.mo70802t()).mo67439b(false).mo67438b((int) c44491df.mo70794l()).mo67441c(c44491df.mo70806x()).mo67444d(this.f3372B).mo67437a(true);
        AppMethodBeat.m2505o(99619);
        return a;
    }
}
