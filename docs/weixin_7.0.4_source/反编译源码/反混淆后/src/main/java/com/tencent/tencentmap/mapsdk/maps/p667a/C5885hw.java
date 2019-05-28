package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C44680l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C44491df;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hw */
public class C5885hw extends C16273hv {
    /* renamed from: R */
    private boolean f1609R;
    /* renamed from: S */
    private Bitmap f1610S;
    /* renamed from: T */
    private boolean f1611T;
    /* renamed from: U */
    private boolean f1612U;
    /* renamed from: V */
    private boolean f1613V;
    /* renamed from: W */
    private C5886a f1614W;
    /* renamed from: X */
    private boolean f1615X;
    /* renamed from: Y */
    private boolean f1616Y;
    /* renamed from: Z */
    private boolean f1617Z;
    /* renamed from: aa */
    private final byte[] f1618aa;
    /* renamed from: ab */
    private boolean f1619ab;
    /* renamed from: ac */
    private boolean f1620ac;
    /* renamed from: ad */
    private Bitmap f1621ad;
    /* renamed from: ae */
    private Bitmap f1622ae;
    /* renamed from: af */
    private Bitmap f1623af;
    /* renamed from: ag */
    private int f1624ag;
    /* renamed from: ah */
    private int f1625ah;
    /* renamed from: ai */
    private int f1626ai;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hw$a */
    enum C5886a {
        None,
        Appear,
        DisAppear,
        MarkerChanged;

        static {
            AppMethodBeat.m2505o(99623);
        }
    }

    public C5885hw(C31061iz c31061iz) {
        super(c31061iz);
        AppMethodBeat.m2504i(99624);
        this.f1609R = false;
        this.f1610S = null;
        this.f1611T = false;
        this.f1612U = false;
        this.f1613V = true;
        this.f1614W = C5886a.None;
        this.f1615X = false;
        this.f1616Y = true;
        this.f1617Z = false;
        this.f1618aa = new byte[0];
        this.f1619ab = false;
        this.f1620ac = false;
        this.f1624ag = 0;
        this.f1625ah = 0;
        this.f1626ai = 0;
        this.f3403t = true;
        AppMethodBeat.m2505o(99624);
    }

    /* renamed from: a */
    public void mo12480a(C44491df c44491df) {
        AppMethodBeat.m2504i(99625);
        super.mo12480a(c44491df);
        this.f3408y = c44491df;
        AppMethodBeat.m2505o(99625);
    }

    /* renamed from: a */
    public synchronized void mo12481a(boolean z, boolean z2) {
        AppMethodBeat.m2504i(99626);
        mo12486d(true);
        if (z && z2) {
            this.f1609R = false;
        } else {
            this.f1609R = true;
        }
        if (this.f1616Y) {
            if (z) {
                this.f1614W = C5886a.None;
            }
            if (!this.f1617Z) {
                this.f1614W = C5886a.MarkerChanged;
            }
            if (z && this.f3371A != null && this.f3371A.mo50392c()) {
                this.f3371A.mo50391b();
                if (this.f3409z != null) {
                    this.f3409z.mo57691b();
                }
            }
            if (this.f1614W == C5886a.None) {
                this.f1614W = C5886a.DisAppear;
                if (this.f3406w.f14269d != null) {
                    mo29440a(this.f3406w.f14269d);
                    mo29452g();
                    AppMethodBeat.m2505o(99626);
                }
            }
            if (this.f1614W == C5886a.DisAppear) {
                this.f1614W = C5886a.MarkerChanged;
                if (this.f3406w.f14271f != null) {
                    mo29440a(this.f3406w.f14271f);
                    mo29452g();
                    AppMethodBeat.m2505o(99626);
                } else {
                    mo12487e();
                    mo29451f();
                    this.f1615X = true;
                    this.f3406w.mo75386b().mo20154a();
                }
            }
            if (this.f1614W == C5886a.MarkerChanged) {
                this.f1614W = C5886a.Appear;
                if (this.f3406w.f14270e != null) {
                    mo29440a(this.f3406w.f14270e);
                    mo29452g();
                    AppMethodBeat.m2505o(99626);
                }
            }
            AppMethodBeat.m2505o(99626);
        } else {
            mo12487e();
            mo29451f();
            this.f1615X = true;
            this.f3406w.mo75386b().mo20154a();
            AppMethodBeat.m2505o(99626);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: h */
    public void mo12489h() {
        AppMethodBeat.m2504i(99627);
        if (this.f1614W == C5886a.MarkerChanged) {
            mo12487e();
            mo29451f();
            this.f3406w.mo75386b().mo20154a();
        }
        if (this.f1614W != C5886a.Appear) {
            mo12481a(false, false);
            AppMethodBeat.m2505o(99627);
            return;
        }
        this.f1615X = true;
        this.f3406w.mo75386b().mo20154a();
        AppMethodBeat.m2505o(99627);
    }

    /* renamed from: c */
    public void mo12485c(boolean z) {
        this.f1615X = z;
    }

    /* renamed from: e */
    public void mo12487e() {
        AppMethodBeat.m2504i(99628);
        synchronized (this.f3387d) {
            try {
                if (!(this.f1623af == null || this.f1623af.isRecycled())) {
                    this.f3386c = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99628);
            }
        }
    }

    /* renamed from: b */
    public void mo12483b(Bitmap bitmap) {
        AppMethodBeat.m2504i(99629);
        if (bitmap == null) {
            AppMethodBeat.m2505o(99629);
            return;
        }
        synchronized (this.f3387d) {
            try {
                this.f3385b = bitmap;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99629);
            }
        }
        synchronized (this.f1618aa) {
            try {
                if (!this.f1620ac) {
                    mo29439a(bitmap);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(99629);
                }
            }
        }
        synchronized (this.f3387d) {
            try {
                if (this.f1615X) {
                    mo12487e();
                }
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.m2505o(99629);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo12479a(GeoPoint geoPoint) {
        this.f3399p = geoPoint;
    }

    /* renamed from: b */
    public void mo12484b(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99630);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(99630);
            return;
        }
        if (this.f3398o == null) {
            this.f3398o = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            this.f3398o.setLatitudeE6(geoPoint.getLatitudeE6());
            this.f3398o.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        if (this.f3384a != null) {
            this.f3384a.mo71710a(this.f3398o);
        }
        if (this.f1615X) {
            mo29451f();
        }
        AppMethodBeat.m2505o(99630);
    }

    /* renamed from: i */
    public void mo12490i() {
        AppMethodBeat.m2504i(99631);
        if (this.f3385b != null) {
            this.f3385b.recycle();
            this.f3385b = null;
        }
        if (this.f1610S != null) {
            this.f1610S.recycle();
            this.f1610S = null;
        }
        if (this.f1621ad != null) {
            this.f1621ad.recycle();
            this.f1621ad = null;
        }
        if (this.f1622ae != null) {
            this.f1622ae.recycle();
            this.f1622ae = null;
        }
        synchronized (this.f3387d) {
            try {
                if (this.f1623af != null) {
                    this.f1623af.recycle();
                    this.f1623af = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99631);
            }
        }
    }

    /* renamed from: d */
    public void mo12486d(boolean z) {
        AppMethodBeat.m2504i(99632);
        this.f1612U = z;
        this.f3406w.mo75386b().mo20154a();
        AppMethodBeat.m2505o(99632);
    }

    /* renamed from: j */
    public boolean mo12491j() {
        return this.f1612U;
    }

    /* renamed from: a */
    public Rect mo12477a(C24374fw c24374fw) {
        Rect a;
        AppMethodBeat.m2504i(99633);
        synchronized (this.f1618aa) {
            try {
                if (this.f3384a != null) {
                    mo12488e(false);
                    m9105f(false);
                    a = this.f3384a.mo20125a(c24374fw);
                    mo12488e(this.f1620ac);
                    m9105f(this.f1620ac);
                } else {
                    a = new Rect(0, 0, 0, 0);
                    AppMethodBeat.m2505o(99633);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99633);
            }
        }
        return a;
    }

    /* renamed from: k */
    public C44680l mo12492k() {
        return this.f3384a;
    }

    /* renamed from: b */
    public void mo12482b(int i, int i2) {
        AppMethodBeat.m2504i(99634);
        this.f1624ag = i;
        this.f1626ai = i2;
        m9106g(false);
        AppMethodBeat.m2505o(99634);
    }

    /* renamed from: a */
    public void mo12478a(int i) {
        AppMethodBeat.m2504i(99635);
        this.f1625ah = i;
        m9107l();
        AppMethodBeat.m2505o(99635);
    }

    /* renamed from: f */
    private void m9105f(boolean z) {
        AppMethodBeat.m2504i(99636);
        synchronized (this.f3387d) {
            if (z) {
                try {
                    if (this.f1621ad != null) {
                        mo29439a(this.f1621ad);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(99636);
                }
            } else if (this.f3385b != null) {
                mo29439a(this.f3385b);
            }
        }
        AppMethodBeat.m2505o(99636);
    }

    /* renamed from: e */
    public void mo12488e(boolean z) {
        AppMethodBeat.m2504i(99637);
        m9106g(z);
        if (this.f3384a != null) {
            this.f3384a.mo71708a(this.f3375E, this.f3376F);
        }
        AppMethodBeat.m2505o(99637);
    }

    /* renamed from: l */
    private void m9107l() {
        int i = this.f3395l;
        if (i == 0) {
            i = 1;
        }
        this.f3375E = ((((float) this.f1625ah) * 1.0f) / ((float) i)) + 0.5f;
    }

    /* renamed from: g */
    private void m9106g(boolean z) {
        AppMethodBeat.m2504i(99638);
        int i = this.f3396m;
        if (this.f1621ad != null) {
            i = this.f1621ad.getHeight();
        }
        if (i == 0) {
            i = 1;
        }
        if (z) {
            this.f3376F = (-(((float) this.f1626ai) + 5.0f)) / ((float) i);
            AppMethodBeat.m2505o(99638);
            return;
        }
        this.f3376F = ((((float) this.f1624ag) + 5.0f) + ((float) i)) / ((float) i);
        AppMethodBeat.m2505o(99638);
    }
}
