package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gg;
import com.tencent.tencentmap.mapsdk.maps.a.hz;
import com.tencent.tencentmap.mapsdk.maps.a.ia;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.iz;
import java.util.ArrayList;
import java.util.List;

public class bb extends cc {
    private iz a = null;

    public bb(gg ggVar) {
        AppMethodBeat.i(100738);
        this.a = (iz) ggVar.getVectorMapDelegate();
        AppMethodBeat.o(100738);
    }

    public void a() {
        AppMethodBeat.i(100739);
        if (this.a != null) {
            this.a.b(ia.class);
            this.a = null;
        }
        AppMethodBeat.o(100739);
    }

    /* Access modifiers changed, original: 0000 */
    public dj a(dk dkVar, ba baVar) {
        AppMethodBeat.i(100740);
        if (this.a == null) {
            AppMethodBeat.o(100740);
            return null;
        }
        hz iaVar = new ia(this.a, dkVar);
        iaVar.a(dkVar);
        iaVar.c();
        if (this.a.a(iaVar)) {
            this.a.b().a();
            dj djVar = new dj(dkVar, baVar, iaVar.A());
            AppMethodBeat.o(100740);
            return djVar;
        }
        AppMethodBeat.o(100740);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str) {
        AppMethodBeat.i(100741);
        if (this.a == null) {
            AppMethodBeat.o(100741);
            return;
        }
        this.a.b(str, true);
        this.a.b().a();
        AppMethodBeat.o(100741);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, int i) {
        AppMethodBeat.i(100742);
        if (this.a == null) {
            AppMethodBeat.o(100742);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.d(i);
                    this.a.b().a();
                    AppMethodBeat.o(100742);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100742);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, List<db> list) {
        AppMethodBeat.i(100743);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100743);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else if (b instanceof ia) {
                    ia iaVar = (ia) b;
                    iaVar.a(a((List) list));
                    iaVar.c();
                    this.a.b().a();
                    AppMethodBeat.o(100743);
                } else {
                    AppMethodBeat.o(100743);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100743);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(String str, int i) {
        AppMethodBeat.i(100744);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100744);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.c(i);
                    this.a.b().a();
                    AppMethodBeat.o(100744);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100744);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, float f) {
        AppMethodBeat.i(100745);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100745);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.d(f);
                    this.a.b().a();
                    AppMethodBeat.o(100745);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100745);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String str, boolean z) {
        AppMethodBeat.i(100746);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100746);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.a(z);
                    this.a.b().a();
                    AppMethodBeat.o(100746);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100746);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(String str, float f) {
        AppMethodBeat.i(100747);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100747);
            return;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null) {
                } else {
                    b.c(f);
                    this.a.b().a();
                    AppMethodBeat.o(100747);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100747);
            }
        }
    }

    private ArrayList<GeoPoint> a(List<db> list) {
        AppMethodBeat.i(100748);
        if (list == null) {
            AppMethodBeat.o(100748);
            return null;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.o(100748);
            return null;
        }
        ArrayList<GeoPoint> arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            db dbVar = (db) list.get(i);
            if (dbVar != null) {
                GeoPoint a = ic.a(dbVar);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        AppMethodBeat.o(100748);
        return arrayList;
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        AppMethodBeat.i(100749);
        if (this.a != null) {
            this.a.c(ia.class);
        }
        AppMethodBeat.o(100749);
    }

    /* Access modifiers changed, original: 0000 */
    public List<j> b(String str) {
        AppMethodBeat.i(100750);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100750);
            return null;
        }
        synchronized (this.a.b) {
            try {
                hz b = this.a.b(str);
                if (b == null || !(b instanceof ia)) {
                } else {
                    ia iaVar = (ia) b;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(iaVar);
                    AppMethodBeat.o(100750);
                    return arrayList;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100750);
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void c(String str, int i) {
        AppMethodBeat.i(100751);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100751);
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
                    AppMethodBeat.o(100751);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(100751);
            }
        }
    }
}
