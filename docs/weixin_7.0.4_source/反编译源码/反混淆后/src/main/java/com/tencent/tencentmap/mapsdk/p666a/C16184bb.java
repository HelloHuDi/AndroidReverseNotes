package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16279ia;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36519hz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44514gg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bb */
public class C16184bb extends C44488cc {
    /* renamed from: a */
    private C31061iz f3074a = null;

    public C16184bb(C44514gg c44514gg) {
        AppMethodBeat.m2504i(100738);
        this.f3074a = (C31061iz) c44514gg.getVectorMapDelegate();
        AppMethodBeat.m2505o(100738);
    }

    /* renamed from: a */
    public void mo29063a() {
        AppMethodBeat.m2504i(100739);
        if (this.f3074a != null) {
            this.f3074a.mo50455b(C16279ia.class);
            this.f3074a = null;
        }
        AppMethodBeat.m2505o(100739);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C31002dj mo29062a(C16192dk c16192dk, C46753ba c46753ba) {
        AppMethodBeat.m2504i(100740);
        if (this.f3074a == null) {
            AppMethodBeat.m2505o(100740);
            return null;
        }
        C36519hz c16279ia = new C16279ia(this.f3074a, c16192dk);
        c16279ia.mo29501a(c16192dk);
        c16279ia.mo29449c();
        if (this.f3074a.mo50454a(c16279ia)) {
            this.f3074a.mo75386b().mo20154a();
            C31002dj c31002dj = new C31002dj(c16192dk, c46753ba, c16279ia.mo57757A());
            AppMethodBeat.m2505o(100740);
            return c31002dj;
        }
        AppMethodBeat.m2505o(100740);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29064a(String str) {
        AppMethodBeat.m2504i(100741);
        if (this.f3074a == null) {
            AppMethodBeat.m2505o(100741);
            return;
        }
        this.f3074a.mo50457b(str, true);
        this.f3074a.mo75386b().mo20154a();
        AppMethodBeat.m2505o(100741);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29066a(String str, int i) {
        AppMethodBeat.m2504i(100742);
        if (this.f3074a == null) {
            AppMethodBeat.m2505o(100742);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50178d(i);
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100742);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100742);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29067a(String str, List<C24343db> list) {
        AppMethodBeat.m2504i(100743);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100743);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else if (b instanceof C16279ia) {
                    C16279ia c16279ia = (C16279ia) b;
                    c16279ia.mo29504a(m24558a((List) list));
                    c16279ia.mo29449c();
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100743);
                } else {
                    AppMethodBeat.m2505o(100743);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100743);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo29072b(String str, int i) {
        AppMethodBeat.m2504i(100744);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100744);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50176c(i);
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100744);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100744);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29065a(String str, float f) {
        AppMethodBeat.m2504i(100745);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100745);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50177d(f);
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100745);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100745);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo29068a(String str, boolean z) {
        AppMethodBeat.m2504i(100746);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100746);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo29442a(z);
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100746);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100746);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo29071b(String str, float f) {
        AppMethodBeat.m2504i(100747);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100747);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50175c(f);
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100747);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100747);
            }
        }
    }

    /* renamed from: a */
    private ArrayList<GeoPoint> m24558a(List<C24343db> list) {
        AppMethodBeat.m2504i(100748);
        if (list == null) {
            AppMethodBeat.m2505o(100748);
            return null;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.m2505o(100748);
            return null;
        }
        ArrayList<GeoPoint> arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            C24343db c24343db = (C24343db) list.get(i);
            if (c24343db != null) {
                GeoPoint a = C36520ic.m60470a(c24343db);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        AppMethodBeat.m2505o(100748);
        return arrayList;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo29070b() {
        AppMethodBeat.m2504i(100749);
        if (this.f3074a != null) {
            this.f3074a.mo50465c(C16279ia.class);
        }
        AppMethodBeat.m2505o(100749);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public List<C41717j> mo29069b(String str) {
        AppMethodBeat.m2504i(100750);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100750);
            return null;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null || !(b instanceof C16279ia)) {
                } else {
                    C16279ia c16279ia = (C16279ia) b;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(c16279ia);
                    AppMethodBeat.m2505o(100750);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100750);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo29073c(String str, int i) {
        AppMethodBeat.m2504i(100751);
        if (this.f3074a == null || this.f3074a.mo75386b() == null) {
            AppMethodBeat.m2505o(100751);
            return;
        }
        synchronized (this.f3074a.f14265b) {
            try {
                C36519hz b = this.f3074a.mo50456b(str);
                if (b == null) {
                } else {
                    b.mo50174a_(i);
                    b.mo29449c();
                    this.f3074a.mo75386b().mo20154a();
                    AppMethodBeat.m2505o(100751);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(100751);
            }
        }
    }
}
