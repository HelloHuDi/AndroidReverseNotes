package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36519hz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36901ib;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44514gg;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24327o;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bd */
public final class C16186bd extends C44489cd implements C46756cb {
    /* renamed from: a */
    private C31061iz f3076a = null;
    /* renamed from: b */
    private C24327o f3077b = null;

    public C16186bd(C44514gg c44514gg) {
        AppMethodBeat.m2504i(100765);
        this.f3076a = (C31061iz) c44514gg.getVectorMapDelegate();
        if (this.f3076a != null && this.f3076a.mo50428a(C36901ib.class) == null) {
            this.f3076a.mo50447a(C36901ib.class, (C46756cb) this);
        }
        AppMethodBeat.m2505o(100765);
    }

    /* renamed from: a */
    public final void mo29089a() {
        AppMethodBeat.m2504i(100766);
        if (this.f3076a != null) {
            this.f3076a.mo50455b(C36901ib.class);
            this.f3076a = null;
        }
        AppMethodBeat.m2505o(100766);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C31003dl mo29088a(C31004dm c31004dm, C16185bc c16185bc) {
        AppMethodBeat.m2504i(100767);
        if (this.f3076a == null) {
            AppMethodBeat.m2505o(100767);
            return null;
        }
        C36519hz c36901ib = new C36901ib(this.f3076a);
        c36901ib.mo58910a(c31004dm);
        c36901ib.mo29449c();
        if (this.f3076a.mo50454a(c36901ib)) {
            this.f3076a.mo75386b().mo20154a();
            C31003dl c31003dl = new C31003dl(c31004dm, c16185bc, c36901ib.mo57757A());
            c36901ib.mo58909a(c31003dl);
            AppMethodBeat.m2505o(100767);
            return c31003dl;
        }
        AppMethodBeat.m2505o(100767);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29090a(String str) {
        AppMethodBeat.m2504i(100768);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100768);
            return;
        }
        this.f3076a.mo50457b(str, true);
        this.f3076a.mo75386b().mo20154a();
        AppMethodBeat.m2505o(100768);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29092a(String str, int i) {
        AppMethodBeat.m2504i(100769);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100769);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50176c(i);
                    b.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100769);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100769);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29095a(String str, List<C24343db> list) {
        AppMethodBeat.m2504i(100770);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100770);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36901ib) {
                    C36901ib c36901ib = (C36901ib) b;
                    try {
                        c36901ib.mo58912a((List) list);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    c36901ib.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100770);
                } else {
                    AppMethodBeat.m2505o(100770);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100770);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29096a(String str, boolean z) {
        AppMethodBeat.m2504i(100771);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100771);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo29442a(z);
                    b.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100771);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100771);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29091a(String str, float f) {
        AppMethodBeat.m2504i(100772);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100772);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36901ib) {
                    C36901ib c36901ib = (C36901ib) b;
                    c36901ib.mo50177d(f);
                    c36901ib.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100772);
                } else {
                    AppMethodBeat.m2505o(100772);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100772);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29100b(String str, float f) {
        AppMethodBeat.m2504i(100773);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100773);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36901ib) {
                    C36901ib c36901ib = (C36901ib) b;
                    c36901ib.mo50175c(f);
                    c36901ib.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100773);
                } else {
                    AppMethodBeat.m2505o(100773);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100773);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29099b() {
        AppMethodBeat.m2504i(100774);
        if (this.f3076a != null) {
            this.f3076a.mo50465c(C36901ib.class);
        }
        AppMethodBeat.m2505o(100774);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29094a(String str, C41018cm c41018cm) {
        AppMethodBeat.m2504i(100775);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100775);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36901ib) {
                    C36901ib c36901ib = (C36901ib) b;
                    c36901ib.mo58908a(c41018cm);
                    c36901ib.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100775);
                } else {
                    AppMethodBeat.m2505o(100775);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100775);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29093a(String str, int i, C24343db c24343db) {
        AppMethodBeat.m2504i(100776);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100776);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36901ib) {
                    ((C36901ib) b).mo58905a(i, c24343db);
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100776);
                } else {
                    AppMethodBeat.m2505o(100776);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100776);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29102b(String str, boolean z) {
        AppMethodBeat.m2504i(100777);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100777);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36901ib) {
                    ((C36901ib) b).mo58920d(z);
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100777);
                } else {
                    AppMethodBeat.m2505o(100777);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100777);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo29097a(C36519hz c36519hz, boolean z, GeoPoint geoPoint) {
        AppMethodBeat.m2504i(100778);
        C36901ib c36901ib = (C36901ib) c36519hz;
        boolean j = c36901ib.mo58926h().mo50233j();
        if (this.f3077b == null || !j) {
            AppMethodBeat.m2505o(100778);
            return false;
        }
        this.f3077b.mo40414a(c36901ib.mo58926h(), C36520ic.m60471a(geoPoint));
        AppMethodBeat.m2505o(100778);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final List<C41717j> mo29098b(String str) {
        AppMethodBeat.m2504i(100779);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100779);
            return null;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null || !(b instanceof C36901ib)) {
                } else {
                    C36901ib c36901ib = (C36901ib) b;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(c36901ib.mo58929j());
                    AppMethodBeat.m2505o(100779);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100779);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29101b(String str, int i) {
        AppMethodBeat.m2504i(100780);
        if (this.f3076a == null || this.f3076a.mo75386b() == null) {
            AppMethodBeat.m2505o(100780);
            return;
        }
        synchronized (this.f3076a.f14265b) {
            try {
                C36519hz b = this.f3076a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50174a_(i);
                    b.mo29449c();
                    this.f3076a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100780);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100780);
            }
        }
    }
}
