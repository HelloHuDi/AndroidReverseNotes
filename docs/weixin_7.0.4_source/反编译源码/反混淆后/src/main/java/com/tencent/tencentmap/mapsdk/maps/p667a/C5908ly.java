package com.tencent.tencentmap.mapsdk.maps.p667a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ly */
public abstract class C5908ly<T> implements C36535lw<T>, C24417lz {
    /* renamed from: a */
    private final C44537mg f1671a;
    /* renamed from: b */
    private final C5908ly<?> f1672b;
    /* renamed from: c */
    private C36536lx f1673c;
    /* renamed from: d */
    private long f1674d;

    protected C5908ly() {
        this(null, false);
    }

    protected C5908ly(C5908ly<?> c5908ly) {
        this(c5908ly, true);
    }

    protected C5908ly(C5908ly<?> c5908ly, boolean z) {
        this.f1674d = Long.MIN_VALUE;
        this.f1672b = c5908ly;
        C44537mg c44537mg = (!z || c5908ly == null) ? new C44537mg() : c5908ly.f1671a;
        this.f1671a = c44537mg;
    }

    /* renamed from: b */
    public final void mo12543b() {
        this.f1671a.mo12543b();
    }

    /* renamed from: c */
    public final boolean mo12544c() {
        return this.f1671a.mo70931a();
    }

    /* renamed from: d */
    public void mo12545d() {
    }

    /* renamed from: a */
    public void mo12542a(C36536lx c36536lx) {
        long j;
        Object obj = null;
        synchronized (this) {
            j = this.f1674d;
            this.f1673c = c36536lx;
            if (this.f1672b != null && j == Long.MIN_VALUE) {
                obj = 1;
            }
        }
        if (obj != null) {
            this.f1672b.mo12542a(this.f1673c);
        } else if (j == Long.MIN_VALUE) {
            this.f1673c.mo29561a(Long.MAX_VALUE);
        } else {
            this.f1673c.mo29561a(j);
        }
    }
}
