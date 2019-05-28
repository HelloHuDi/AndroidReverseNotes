package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36519hz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36898hu;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44514gg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bq */
public final class C44485bq extends C16189bu implements C46756cb {
    /* renamed from: a */
    private C31061iz f17348a = null;

    public C44485bq(C44514gg c44514gg) {
        AppMethodBeat.m2504i(100870);
        this.f17348a = (C31061iz) c44514gg.getVectorMapDelegate();
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100870);
            return;
        }
        if (this.f17348a.mo50428a(C36898hu.class) == null) {
            this.f17348a.mo50447a(C36898hu.class, (C46756cb) this);
        }
        AppMethodBeat.m2505o(100870);
    }

    /* renamed from: a */
    public final void mo70700a() {
        AppMethodBeat.m2504i(100871);
        if (this.f17348a != null) {
            this.f17348a.mo50455b(C36898hu.class);
            this.f17348a = null;
        }
        AppMethodBeat.m2505o(100871);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C5843cq mo29106a(C5844cr c5844cr, C41011bp c41011bp) {
        AppMethodBeat.m2504i(100872);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100872);
            return null;
        }
        C36519hz c36898hu = new C36898hu(this.f17348a);
        c36898hu.mo58866a(c5844cr);
        c36898hu.mo29449c();
        if (this.f17348a.mo50454a(c36898hu)) {
            this.f17348a.mo75386b().mo20154a();
            C5843cq c5843cq = new C5843cq(c5844cr, c41011bp, c36898hu.mo57757A());
            AppMethodBeat.m2505o(100872);
            return c5843cq;
        }
        AppMethodBeat.m2505o(100872);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29107a(String str) {
        AppMethodBeat.m2504i(100873);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100873);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50457b(str, false);
                if (b == null || !(b instanceof C36898hu)) {
                } else {
                    b.mo29450d();
                    this.f17348a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100873);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100873);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29111a(String str, C24343db c24343db) {
        AppMethodBeat.m2504i(100874);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100874);
        } else if (c24343db == null) {
            AppMethodBeat.m2505o(100874);
        } else {
            synchronized (this.f17348a.f14265b) {
                try {
                    C36519hz b = this.f17348a.mo50456b(str);
                    if (b == null) {
                    } else if (b instanceof C36898hu) {
                        ((C36898hu) b).mo58865a(C36520ic.m60470a(c24343db));
                        this.f17348a.mo75386b().mo20154a();
                        AppMethodBeat.m2505o(100874);
                    } else {
                        AppMethodBeat.m2505o(100874);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(100874);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29110a(String str, int i) {
        AppMethodBeat.m2504i(100875);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100875);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36898hu) {
                    ((C36898hu) b).mo50178d(i);
                    this.f17348a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100875);
                } else {
                    AppMethodBeat.m2505o(100875);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100875);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29108a(String str, double d) {
        AppMethodBeat.m2504i(100876);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100876);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36898hu) {
                    ((C36898hu) b).mo58864a(d);
                    this.f17348a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100876);
                } else {
                    AppMethodBeat.m2505o(100876);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100876);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29116b(String str, int i) {
        AppMethodBeat.m2504i(100877);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100877);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36898hu) {
                    ((C36898hu) b).mo50176c(i);
                    this.f17348a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100877);
                } else {
                    AppMethodBeat.m2505o(100877);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100877);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29109a(String str, float f) {
        AppMethodBeat.m2504i(100878);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100878);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36898hu) {
                    ((C36898hu) b).mo50177d(f);
                    this.f17348a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100878);
                } else {
                    AppMethodBeat.m2505o(100878);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100878);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo29112a(String str, boolean z) {
        AppMethodBeat.m2504i(100879);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100879);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C36898hu) {
                    ((C36898hu) b).mo29442a(z);
                    this.f17348a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100879);
                } else {
                    AppMethodBeat.m2505o(100879);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100879);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29115b(String str, float f) {
        AppMethodBeat.m2504i(100880);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100880);
            return;
        }
        C36519hz b = this.f17348a.mo50456b(str);
        if (b != null) {
            b.mo50175c(f);
        }
        this.f17348a.mo50448a(str, f);
        this.f17348a.mo75386b().mo20154a();
        AppMethodBeat.m2505o(100880);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:18:0x002f, code skipped:
            r4.f17348a.mo75386b().mo20154a();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(100881);
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final void mo29117c(String str, int i) {
        AppMethodBeat.m2504i(100881);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100881);
            return;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null) {
                } else if (!(b instanceof C36898hu)) {
                    AppMethodBeat.m2505o(100881);
                } else if (b != null) {
                    b.mo50174a_(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100881);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo29114b() {
        AppMethodBeat.m2504i(100882);
        if (this.f17348a != null) {
            this.f17348a.mo50465c(C36898hu.class);
        }
        AppMethodBeat.m2505o(100882);
    }

    /* renamed from: a */
    public final boolean mo29097a(C36519hz c36519hz, boolean z, GeoPoint geoPoint) {
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final List<C41717j> mo29113b(String str) {
        AppMethodBeat.m2504i(100883);
        if (this.f17348a == null) {
            AppMethodBeat.m2505o(100883);
            return null;
        }
        synchronized (this.f17348a.f14265b) {
            try {
                C36519hz b = this.f17348a.mo50456b(str);
                if (b == null || !(b instanceof C36898hu)) {
                } else {
                    C36898hu c36898hu = (C36898hu) b;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(c36898hu);
                    AppMethodBeat.m2505o(100883);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100883);
            }
        }
        return null;
    }
}
