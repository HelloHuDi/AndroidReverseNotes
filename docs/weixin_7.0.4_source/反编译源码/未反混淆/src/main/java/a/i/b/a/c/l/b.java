package a.i.b.a.c.l;

import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.y;
import a.i.b.a.c.i.c.a;
import a.i.b.a.c.i.d;
import a.i.b.a.c.k.i;
import java.util.Collection;
import java.util.Collections;

public abstract class b extends c implements an {
    private int aBR = 0;

    /* renamed from: dYt */
    public abstract e dYs();

    public b(i iVar) {
        super(iVar);
    }

    public final int hashCode() {
        int i = this.aBR;
        if (i == 0) {
            e dYt = dYs();
            if (d(dYt)) {
                i = d.n(dYt).hashCode();
            } else {
                i = System.identityHashCode(this);
            }
            this.aBR = i;
        }
        return i;
    }

    public final g dZD() {
        return a.G(dYs());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof an)) {
            return false;
        }
        if (obj.hashCode() != hashCode()) {
            return false;
        }
        if (((an) obj).getParameters().size() != getParameters().size()) {
            return false;
        }
        e dYt = dYs();
        h dYs = ((an) obj).dYs();
        if (!d(dYt) || (dYs != null && !d(dYs))) {
            return false;
        }
        if (!(dYs instanceof e)) {
            return false;
        }
        dYt = dYt;
        e eVar = (e) dYs;
        if (!dYt.dZg().equals(eVar.dZg())) {
            return false;
        }
        l dXW = dYt.dXW();
        l dXW2 = eVar.dXW();
        while (dXW != null && dXW2 != null) {
            if (dXW instanceof y) {
                return dXW2 instanceof y;
            }
            if (dXW2 instanceof y) {
                return false;
            }
            if (dXW instanceof ab) {
                if (!((dXW2 instanceof ab) && ((ab) dXW).dZF().equals(((ab) dXW2).dZF()))) {
                    return false;
                }
            } else if (dXW2 instanceof ab) {
                return false;
            } else {
                if (!dXW.dZg().equals(dXW2.dZg())) {
                    return false;
                }
                dXW = dXW.dXW();
                dXW2 = dXW2.dXW();
            }
        }
        return true;
    }

    private static boolean d(h hVar) {
        return (p.L(hVar) || d.m(hVar)) ? false : true;
    }

    /* Access modifiers changed, original: protected|final */
    public final Collection<w> sb(boolean z) {
        l dXW = dYs().dXW();
        if (!(dXW instanceof e)) {
            return Collections.emptyList();
        }
        a.i.b.a.c.n.h hVar = new a.i.b.a.c.n.h();
        e eVar = (e) dXW;
        hVar.add(eVar.dZf());
        eVar = eVar.dYa();
        if (z && eVar != null) {
            hVar.add(eVar.dZf());
        }
        return hVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final w ear() {
        if (g.e(dYs())) {
            return null;
        }
        return a.G(dYs()).dXM();
    }
}
