package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.element.b;
import com.tencent.map.lib.element.f;
import com.tencent.map.lib.element.g;
import com.tencent.map.lib.element.h;
import com.tencent.map.lib.element.i;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.element.k;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class gl {
    private CopyOnWriteArrayList<j> a = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<j> b = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<j> c = new CopyOnWriteArrayList();
    private fn d;
    private g e;
    private List<f> f;
    private b g;
    private i h;
    private a i;
    private CopyOnWriteArrayList<Integer> j = new CopyOnWriteArrayList();

    public gl(fn fnVar) {
        AppMethodBeat.i(99281);
        this.d = fnVar;
        AppMethodBeat.o(99281);
    }

    public void a(j jVar) {
        AppMethodBeat.i(99282);
        synchronized (this.a) {
            try {
                if (this.a.contains(jVar)) {
                } else {
                    this.a.add(jVar);
                    this.d.a().z();
                    AppMethodBeat.o(99282);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99282);
            }
        }
    }

    public void b(j jVar) {
        AppMethodBeat.i(99283);
        if (jVar == null) {
            AppMethodBeat.o(99283);
            return;
        }
        synchronized (this.a) {
            try {
                if (this.a.remove(jVar)) {
                    this.d.a().z();
                }
                this.c.add(jVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99283);
            }
        }
    }

    public boolean a(gj gjVar, fw fwVar) {
        AppMethodBeat.i(99284);
        a();
        this.b.clear();
        synchronized (this.a) {
            try {
                this.b.addAll(this.a);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99284);
            }
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar instanceof com.tencent.map.lib.element.a) {
                ((com.tencent.map.lib.element.a) jVar).a(gjVar, fwVar);
            } else {
                jVar.b(gjVar, fwVar);
            }
        }
        return true;
    }

    private void a() {
        AppMethodBeat.i(99285);
        synchronized (this.a) {
            try {
                int i;
                int f;
                ArrayList arrayList = new ArrayList();
                int size = this.c.size();
                for (int i2 = 0; i2 < size; i2++) {
                    j jVar = (j) this.c.get(i2);
                    if (jVar instanceof k) {
                        k kVar = (k) jVar;
                        int c = kVar.c();
                        for (i = 0; i < c; i++) {
                            j a = kVar.a(i);
                            if (a instanceof l) {
                                f = ((l) a).f();
                                if (f >= 0) {
                                    arrayList.add(Integer.valueOf(f));
                                }
                            }
                        }
                    } else if (jVar instanceof l) {
                        int f2 = ((l) jVar).f();
                        if (f2 >= 0) {
                            arrayList.add(Integer.valueOf(f2));
                        }
                    }
                }
                i = arrayList.size();
                int[] iArr = new int[i];
                for (f = 0; f < i; f++) {
                    iArr[f] = ((Integer) arrayList.get(f)).intValue();
                }
                this.d.f().a(iArr, i);
                this.c.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99285);
            }
        }
    }

    public boolean a(fw fwVar, float f, float f2) {
        AppMethodBeat.i(99286);
        synchronized (this.a) {
            try {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    j jVar = (j) this.a.get(size);
                    if (jVar == null || !jVar.a(fwVar, f, f2)) {
                        size--;
                    }
                }
                boolean b = b(f, f2);
                AppMethodBeat.o(99286);
                return b;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99286);
            }
        }
        return true;
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(int i, int i2) {
    }

    private boolean b(float f, float f2) {
        AppMethodBeat.i(99287);
        TappedElement a = this.d.f().a(f, f2);
        if (a == null) {
            AppMethodBeat.o(99287);
            return false;
        } else if (a.type == 1 && this.e != null) {
            this.e.a(new h(a.name, d.a(a.pixelX, a.pixelY)));
            AppMethodBeat.o(99287);
            return true;
        } else if (a.type == 6 && this.f != null) {
            for (f fVar : this.f) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            AppMethodBeat.o(99287);
            return true;
        } else if (a.type != 7 || this.g == null) {
            if (this.h != null) {
                this.h.a();
            }
            AppMethodBeat.o(99287);
            return false;
        } else {
            this.g.a(a.itemType, a.nameLen);
            AppMethodBeat.o(99287);
            return true;
        }
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(99288);
        TappedElement a = this.d.f().a(f, f2);
        if (a == null) {
            AppMethodBeat.o(99288);
            return false;
        } else if (a.type == 3) {
            if (this.i != null) {
                this.i.a();
            }
            AppMethodBeat.o(99288);
            return true;
        } else {
            AppMethodBeat.o(99288);
            return false;
        }
    }
}
