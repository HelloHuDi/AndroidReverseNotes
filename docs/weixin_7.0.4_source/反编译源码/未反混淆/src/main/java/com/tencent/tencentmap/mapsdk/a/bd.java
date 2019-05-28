package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.o;
import com.tencent.tencentmap.mapsdk.maps.a.gg;
import com.tencent.tencentmap.mapsdk.maps.a.hz;
import com.tencent.tencentmap.mapsdk.maps.a.ib;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import java.util.ArrayList;
import java.util.List;

public final class bd extends cd implements cb {
    private iz a = null;
    private o b = null;

    public bd(gg ggVar) {
        AppMethodBeat.i(100765);
        this.a = (iz) ggVar.getVectorMapDelegate();
        if (this.a != null && this.a.a(ib.class) == null) {
            this.a.a(ib.class, (cb) this);
        }
        AppMethodBeat.o(100765);
    }

    public final void a() {
        AppMethodBeat.i(100766);
        if (this.a != null) {
            this.a.b(ib.class);
            this.a = null;
        }
        AppMethodBeat.o(100766);
    }

    /* Access modifiers changed, original: final */
    public final dl a(dm dmVar, bc bcVar) {
        AppMethodBeat.i(100767);
        if (this.a == null) {
            AppMethodBeat.o(100767);
            return null;
        }
        hz ibVar = new ib(this.a);
        ibVar.a(dmVar);
        ibVar.c();
        if (this.a.a(ibVar)) {
            this.a.b().a();
            dl dlVar = new dl(dmVar, bcVar, ibVar.A());
            ibVar.a(dlVar);
            AppMethodBeat.o(100767);
            return dlVar;
        }
        AppMethodBeat.o(100767);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void a(String str) {
        AppMethodBeat.i(100768);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100768);
            return;
        }
        this.a.b(str, true);
        this.a.b().a();
        AppMethodBeat.o(100768);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, int i) {
        AppMethodBeat.i(100769);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100769);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.c(i);
                    b.c();
                    this.a.b().a();
                    AppMethodBeat.o(100769);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100769);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, List<db> list) {
        AppMethodBeat.i(100770);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100770);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ib) {
                    ib ibVar = (ib) b;
                    try {
                        ibVar.a((List) list);
                    } catch (IndexOutOfBoundsException e) {
                    }
                    ibVar.c();
                    this.a.b().a();
                    AppMethodBeat.o(100770);
                } else {
                    AppMethodBeat.o(100770);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100770);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, boolean z) {
        AppMethodBeat.i(100771);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100771);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.a(z);
                    b.c();
                    this.a.b().a();
                    AppMethodBeat.o(100771);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100771);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, float f) {
        AppMethodBeat.i(100772);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100772);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ib) {
                    ib ibVar = (ib) b;
                    ibVar.d(f);
                    ibVar.c();
                    this.a.b().a();
                    AppMethodBeat.o(100772);
                } else {
                    AppMethodBeat.o(100772);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100772);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(String str, float f) {
        AppMethodBeat.i(100773);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100773);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ib) {
                    ib ibVar = (ib) b;
                    ibVar.c(f);
                    ibVar.c();
                    this.a.b().a();
                    AppMethodBeat.o(100773);
                } else {
                    AppMethodBeat.o(100773);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100773);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b() {
        AppMethodBeat.i(100774);
        if (this.a != null) {
            this.a.c(ib.class);
        }
        AppMethodBeat.o(100774);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, cm cmVar) {
        AppMethodBeat.i(100775);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100775);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ib) {
                    ib ibVar = (ib) b;
                    ibVar.a(cmVar);
                    ibVar.c();
                    this.a.b().a();
                    AppMethodBeat.o(100775);
                } else {
                    AppMethodBeat.o(100775);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100775);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, int i, db dbVar) {
        AppMethodBeat.i(100776);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100776);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ib) {
                    ((ib) b).a(i, dbVar);
                    this.a.b().a();
                    AppMethodBeat.o(100776);
                } else {
                    AppMethodBeat.o(100776);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100776);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(String str, boolean z) {
        AppMethodBeat.i(100777);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100777);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ib) {
                    ((ib) b).d(z);
                    this.a.b().a();
                    AppMethodBeat.o(100777);
                } else {
                    AppMethodBeat.o(100777);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100777);
            }
        }
    }

    public final boolean a(hz hzVar, boolean z, GeoPoint geoPoint) {
        AppMethodBeat.i(100778);
        ib ibVar = (ib) hzVar;
        boolean j = ibVar.h().j();
        if (this.b == null || !j) {
            AppMethodBeat.o(100778);
            return false;
        }
        this.b.a(ibVar.h(), ic.a(geoPoint));
        AppMethodBeat.o(100778);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final List<j> b(String str) {
        AppMethodBeat.i(100779);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100779);
            return null;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null || !(b instanceof ib)) {
                } else {
                    ib ibVar = (ib) b;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(ibVar.j());
                    AppMethodBeat.o(100779);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100779);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void b(String str, int i) {
        AppMethodBeat.i(100780);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100780);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.a_(i);
                    b.c();
                    this.a.b().a();
                    AppMethodBeat.o(100780);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100780);
            }
        }
    }
}
