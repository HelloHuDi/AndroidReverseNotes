package android.support.p069v7.widget;

import android.support.p057v4.p065f.C0407f;
import android.support.p057v4.p065f.C37122k.C16505b;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.support.p057v4.p065f.C6197a;
import android.support.p069v7.widget.RecyclerView.C31879f.C17479c;
import android.support.p069v7.widget.RecyclerView.C41531v;

/* renamed from: android.support.v7.widget.bj */
final class C44970bj {
    final C6197a<C41531v, C25381a> auY = new C6197a();
    final C0407f<C41531v> auZ = new C0407f();

    /* renamed from: android.support.v7.widget.bj$a */
    static class C25381a {
        static C8387a<C25381a> avc = new C16505b(20);
        C17479c ava;
        C17479c avb;
        int flags;

        private C25381a() {
        }

        /* renamed from: ly */
        static C25381a m40072ly() {
            C25381a c25381a = (C25381a) avc.mo6364aA();
            return c25381a == null ? new C25381a() : c25381a;
        }

        /* renamed from: a */
        static void m40071a(C25381a c25381a) {
            c25381a.flags = 0;
            c25381a.ava = null;
            c25381a.avb = null;
            avc.release(c25381a);
        }

        /* renamed from: lz */
        static void m40073lz() {
            do {
            } while (avc.mo6364aA() != null);
        }
    }

    /* renamed from: android.support.v7.widget.bj$b */
    interface C37144b {
        /* renamed from: a */
        void mo42359a(C41531v c41531v, C17479c c17479c, C17479c c17479c2);

        /* renamed from: b */
        void mo42360b(C41531v c41531v, C17479c c17479c, C17479c c17479c2);

        /* renamed from: c */
        void mo42361c(C41531v c41531v, C17479c c17479c, C17479c c17479c2);

        /* renamed from: j */
        void mo42362j(C41531v c41531v);
    }

    C44970bj() {
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        this.auY.clear();
        this.auZ.clear();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo72246b(C41531v c41531v, C17479c c17479c) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        if (c25381a == null) {
            c25381a = C25381a.m40072ly();
            this.auY.put(c41531v, c25381a);
        }
        c25381a.ava = c17479c;
        c25381a.flags |= 4;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: H */
    public final boolean mo72239H(C41531v c41531v) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        return (c25381a == null || (c25381a.flags & 1) == 0) ? false : true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final C17479c mo72249d(C41531v c41531v, int i) {
        C17479c c17479c = null;
        int indexOfKey = this.auY.indexOfKey(c41531v);
        if (indexOfKey >= 0) {
            C25381a c25381a = (C25381a) this.auY.valueAt(indexOfKey);
            if (!(c25381a == null || (c25381a.flags & i) == 0)) {
                c25381a.flags &= i ^ -1;
                if (i == 4) {
                    c17479c = c25381a.ava;
                } else if (i == 8) {
                    c17479c = c25381a.avb;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c25381a.flags & 12) == 0) {
                    this.auY.removeAt(indexOfKey);
                    C25381a.m40071a(c25381a);
                }
            }
        }
        return c17479c;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo72244a(long j, C41531v c41531v) {
        this.auZ.put(j, c41531v);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo72247c(C41531v c41531v, C17479c c17479c) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        if (c25381a == null) {
            c25381a = C25381a.m40072ly();
            this.auY.put(c41531v, c25381a);
        }
        c25381a.flags |= 2;
        c25381a.ava = c17479c;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: I */
    public final boolean mo72240I(C41531v c41531v) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        return (c25381a == null || (c25381a.flags & 4) == 0) ? false : true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final C41531v mo72251o(long j) {
        return (C41531v) this.auZ.mo742k(j);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo72250d(C41531v c41531v, C17479c c17479c) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        if (c25381a == null) {
            c25381a = C25381a.m40072ly();
            this.auY.put(c41531v, c25381a);
        }
        c25381a.avb = c17479c;
        c25381a.flags |= 8;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: J */
    public final void mo72241J(C41531v c41531v) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        if (c25381a == null) {
            c25381a = C25381a.m40072ly();
            this.auY.put(c41531v, c25381a);
        }
        c25381a.flags |= 1;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: K */
    public final void mo72242K(C41531v c41531v) {
        C25381a c25381a = (C25381a) this.auY.get(c41531v);
        if (c25381a != null) {
            c25381a.flags &= -2;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo72245a(C37144b c37144b) {
        for (int size = this.auY.size() - 1; size >= 0; size--) {
            C41531v c41531v = (C41531v) this.auY.keyAt(size);
            C25381a c25381a = (C25381a) this.auY.removeAt(size);
            if ((c25381a.flags & 3) == 3) {
                c37144b.mo42362j(c41531v);
            } else if ((c25381a.flags & 1) != 0) {
                if (c25381a.ava == null) {
                    c37144b.mo42362j(c41531v);
                } else {
                    c37144b.mo42359a(c41531v, c25381a.ava, c25381a.avb);
                }
            } else if ((c25381a.flags & 14) == 14) {
                c37144b.mo42360b(c41531v, c25381a.ava, c25381a.avb);
            } else if ((c25381a.flags & 12) == 12) {
                c37144b.mo42361c(c41531v, c25381a.ava, c25381a.avb);
            } else if ((c25381a.flags & 4) != 0) {
                c37144b.mo42359a(c41531v, c25381a.ava, null);
            } else if ((c25381a.flags & 8) != 0) {
                c37144b.mo42360b(c41531v, c25381a.ava, c25381a.avb);
            }
            C25381a.m40071a(c25381a);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: L */
    public final void mo72243L(C41531v c41531v) {
        for (int size = this.auZ.size() - 1; size >= 0; size--) {
            if (c41531v == this.auZ.valueAt(size)) {
                this.auZ.removeAt(size);
                break;
            }
        }
        C25381a c25381a = (C25381a) this.auY.remove(c41531v);
        if (c25381a != null) {
            C25381a.m40071a(c25381a);
        }
    }
}
