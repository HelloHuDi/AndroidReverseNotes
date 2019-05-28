package android.support.v7.widget;

import android.support.v4.f.f;
import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.v;

final class bj {
    final android.support.v4.f.a<v, a> auY = new android.support.v4.f.a();
    final f<v> auZ = new f();

    static class a {
        static android.support.v4.f.k.a<a> avc = new android.support.v4.f.k.b(20);
        c ava;
        c avb;
        int flags;

        private a() {
        }

        static a ly() {
            a aVar = (a) avc.aA();
            return aVar == null ? new a() : aVar;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.ava = null;
            aVar.avb = null;
            avc.release(aVar);
        }

        static void lz() {
            do {
            } while (avc.aA() != null);
        }
    }

    interface b {
        void a(v vVar, c cVar, c cVar2);

        void b(v vVar, c cVar, c cVar2);

        void c(v vVar, c cVar, c cVar2);

        void j(v vVar);
    }

    bj() {
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        this.auY.clear();
        this.auZ.clear();
    }

    /* Access modifiers changed, original: final */
    public final void b(v vVar, c cVar) {
        a aVar = (a) this.auY.get(vVar);
        if (aVar == null) {
            aVar = a.ly();
            this.auY.put(vVar, aVar);
        }
        aVar.ava = cVar;
        aVar.flags |= 4;
    }

    /* Access modifiers changed, original: final */
    public final boolean H(v vVar) {
        a aVar = (a) this.auY.get(vVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    /* Access modifiers changed, original: final */
    public final c d(v vVar, int i) {
        c cVar = null;
        int indexOfKey = this.auY.indexOfKey(vVar);
        if (indexOfKey >= 0) {
            a aVar = (a) this.auY.valueAt(indexOfKey);
            if (!(aVar == null || (aVar.flags & i) == 0)) {
                aVar.flags &= i ^ -1;
                if (i == 4) {
                    cVar = aVar.ava;
                } else if (i == 8) {
                    cVar = aVar.avb;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.flags & 12) == 0) {
                    this.auY.removeAt(indexOfKey);
                    a.a(aVar);
                }
            }
        }
        return cVar;
    }

    /* Access modifiers changed, original: final */
    public final void a(long j, v vVar) {
        this.auZ.put(j, vVar);
    }

    /* Access modifiers changed, original: final */
    public final void c(v vVar, c cVar) {
        a aVar = (a) this.auY.get(vVar);
        if (aVar == null) {
            aVar = a.ly();
            this.auY.put(vVar, aVar);
        }
        aVar.flags |= 2;
        aVar.ava = cVar;
    }

    /* Access modifiers changed, original: final */
    public final boolean I(v vVar) {
        a aVar = (a) this.auY.get(vVar);
        return (aVar == null || (aVar.flags & 4) == 0) ? false : true;
    }

    /* Access modifiers changed, original: final */
    public final v o(long j) {
        return (v) this.auZ.k(j);
    }

    /* Access modifiers changed, original: final */
    public final void d(v vVar, c cVar) {
        a aVar = (a) this.auY.get(vVar);
        if (aVar == null) {
            aVar = a.ly();
            this.auY.put(vVar, aVar);
        }
        aVar.avb = cVar;
        aVar.flags |= 8;
    }

    /* Access modifiers changed, original: final */
    public final void J(v vVar) {
        a aVar = (a) this.auY.get(vVar);
        if (aVar == null) {
            aVar = a.ly();
            this.auY.put(vVar, aVar);
        }
        aVar.flags |= 1;
    }

    /* Access modifiers changed, original: final */
    public final void K(v vVar) {
        a aVar = (a) this.auY.get(vVar);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar) {
        for (int size = this.auY.size() - 1; size >= 0; size--) {
            v vVar = (v) this.auY.keyAt(size);
            a aVar = (a) this.auY.removeAt(size);
            if ((aVar.flags & 3) == 3) {
                bVar.j(vVar);
            } else if ((aVar.flags & 1) != 0) {
                if (aVar.ava == null) {
                    bVar.j(vVar);
                } else {
                    bVar.a(vVar, aVar.ava, aVar.avb);
                }
            } else if ((aVar.flags & 14) == 14) {
                bVar.b(vVar, aVar.ava, aVar.avb);
            } else if ((aVar.flags & 12) == 12) {
                bVar.c(vVar, aVar.ava, aVar.avb);
            } else if ((aVar.flags & 4) != 0) {
                bVar.a(vVar, aVar.ava, null);
            } else if ((aVar.flags & 8) != 0) {
                bVar.b(vVar, aVar.ava, aVar.avb);
            }
            a.a(aVar);
        }
    }

    /* Access modifiers changed, original: final */
    public final void L(v vVar) {
        for (int size = this.auZ.size() - 1; size >= 0; size--) {
            if (vVar == this.auZ.valueAt(size)) {
                this.auZ.removeAt(size);
                break;
            }
        }
        a aVar = (a) this.auY.remove(vVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }
}
