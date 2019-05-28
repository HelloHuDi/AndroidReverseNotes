package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gg;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.hz;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import java.util.ArrayList;
import java.util.List;

public final class bq extends bu implements cb {
    private iz a = null;

    public bq(gg ggVar) {
        AppMethodBeat.i(100870);
        this.a = (iz) ggVar.getVectorMapDelegate();
        if (this.a == null) {
            AppMethodBeat.o(100870);
            return;
        }
        if (this.a.a(hu.class) == null) {
            this.a.a(hu.class, (cb) this);
        }
        AppMethodBeat.o(100870);
    }

    public final void a() {
        AppMethodBeat.i(100871);
        if (this.a != null) {
            this.a.b(hu.class);
            this.a = null;
        }
        AppMethodBeat.o(100871);
    }

    /* Access modifiers changed, original: final */
    public final cq a(cr crVar, bp bpVar) {
        AppMethodBeat.i(100872);
        if (this.a == null) {
            AppMethodBeat.o(100872);
            return null;
        }
        hz huVar = new hu(this.a);
        huVar.a(crVar);
        huVar.c();
        if (this.a.a(huVar)) {
            this.a.b().a();
            cq cqVar = new cq(crVar, bpVar, huVar.A());
            AppMethodBeat.o(100872);
            return cqVar;
        }
        AppMethodBeat.o(100872);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void a(String str) {
        AppMethodBeat.i(100873);
        if (this.a == null) {
            AppMethodBeat.o(100873);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str, false);
                if (b == null || !(b instanceof hu)) {
                } else {
                    b.d();
                    this.a.b().a();
                    AppMethodBeat.o(100873);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100873);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, db dbVar) {
        AppMethodBeat.i(100874);
        if (this.a == null) {
            AppMethodBeat.o(100874);
        } else if (dbVar == null) {
            AppMethodBeat.o(100874);
        } else {
            synchronized (this.a.b) {
                try {
                    hz b = this.a.b(str);
                    if (b == null) {
                    } else if (b instanceof hu) {
                        ((hu) b).a(ic.a(dbVar));
                        this.a.b().a();
                        AppMethodBeat.o(100874);
                    } else {
                        AppMethodBeat.o(100874);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(100874);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, int i) {
        AppMethodBeat.i(100875);
        if (this.a == null) {
            AppMethodBeat.o(100875);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hu) {
                    ((hu) b).d(i);
                    this.a.b().a();
                    AppMethodBeat.o(100875);
                } else {
                    AppMethodBeat.o(100875);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100875);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, double d) {
        AppMethodBeat.i(100876);
        if (this.a == null) {
            AppMethodBeat.o(100876);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hu) {
                    ((hu) b).a(d);
                    this.a.b().a();
                    AppMethodBeat.o(100876);
                } else {
                    AppMethodBeat.o(100876);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100876);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(String str, int i) {
        AppMethodBeat.i(100877);
        if (this.a == null) {
            AppMethodBeat.o(100877);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hu) {
                    ((hu) b).c(i);
                    this.a.b().a();
                    AppMethodBeat.o(100877);
                } else {
                    AppMethodBeat.o(100877);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100877);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, float f) {
        AppMethodBeat.i(100878);
        if (this.a == null) {
            AppMethodBeat.o(100878);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hu) {
                    ((hu) b).d(f);
                    this.a.b().a();
                    AppMethodBeat.o(100878);
                } else {
                    AppMethodBeat.o(100878);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100878);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, boolean z) {
        AppMethodBeat.i(100879);
        if (this.a == null) {
            AppMethodBeat.o(100879);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof hu) {
                    ((hu) b).a(z);
                    this.a.b().a();
                    AppMethodBeat.o(100879);
                } else {
                    AppMethodBeat.o(100879);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100879);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(String str, float f) {
        AppMethodBeat.i(100880);
        if (this.a == null) {
            AppMethodBeat.o(100880);
            return;
        }
        hz b = this.a.b(str);
        if (b != null) {
            b.c(f);
        }
        this.a.a(str, f);
        this.a.b().a();
        AppMethodBeat.o(100880);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:18:0x002f, code skipped:
            r4.a.b().a();
            com.tencent.matrix.trace.core.AppMethodBeat.o(100881);
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(String str, int i) {
        AppMethodBeat.i(100881);
        if (this.a == null) {
            AppMethodBeat.o(100881);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (!(b instanceof hu)) {
                    AppMethodBeat.o(100881);
                } else if (b != null) {
                    b.a_(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100881);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b() {
        AppMethodBeat.i(100882);
        if (this.a != null) {
            this.a.c(hu.class);
        }
        AppMethodBeat.o(100882);
    }

    public final boolean a(hz hzVar, boolean z, GeoPoint geoPoint) {
        return false;
    }

    /* Access modifiers changed, original: final */
    public final List<j> b(String str) {
        AppMethodBeat.i(100883);
        if (this.a == null) {
            AppMethodBeat.o(100883);
            return null;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null || !(b instanceof hu)) {
                } else {
                    hu huVar = (hu) b;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(huVar);
                    AppMethodBeat.o(100883);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100883);
            }
        }
        return null;
    }
}
