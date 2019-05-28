package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.a.h;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class c extends j implements ak {
    private static final f Bhe = f.avZ("<this>");

    public final /* bridge */ /* synthetic */ a dYU() {
        return this;
    }

    public final /* bridge */ /* synthetic */ l dZd() {
        return this;
    }

    public c(g gVar) {
        super(gVar, Bhe);
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        return nVar.a((ak) this, (Object) d);
    }

    public final ak dYQ() {
        return null;
    }

    public final ak dYR() {
        return null;
    }

    public final List<ar> dYS() {
        return Collections.emptyList();
    }

    public final w dYT() {
        return dZS();
    }

    public final w dZS() {
        return dZO().dZS();
    }

    public final List<au> dYV() {
        return Collections.emptyList();
    }

    public final boolean dYW() {
        return false;
    }

    public final Collection<? extends a> dYX() {
        return Collections.emptySet();
    }

    public final az dYf() {
        return ay.Bfb;
    }

    public final am dYo() {
        return am.BeR;
    }

    public final <V> V a(a.a<V> aVar) {
        return null;
    }

    /* renamed from: e */
    public final ak f(a.i.b.a.c.l.au auVar) {
        if (auVar.Bik.isEmpty()) {
            return this;
        }
        w c;
        if (dXW() instanceof e) {
            c = auVar.c(dZS(), ba.OUT_VARIANCE);
        } else {
            c = auVar.c(dZS(), ba.INVARIANT);
        }
        if (c == null) {
            return null;
        }
        return c != dZS() ? new ac(dXW(), new h(c), dYn()) : this;
    }
}
