package p000a.p010i.p011b.p012a.p015c.p045l;

import java.util.Collection;
import java.util.Collections;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p048n.C37067h;

/* renamed from: a.i.b.a.c.l.b */
public abstract class C44923b extends C37055c implements C17313an {
    private int aBR = 0;

    /* renamed from: dYt */
    public abstract C46865e dYs();

    public C44923b(C25212i c25212i) {
        super(c25212i);
    }

    public final int hashCode() {
        int i = this.aBR;
        if (i == 0) {
            C46865e dYt = dYs();
            if (C44923b.m82158d(dYt)) {
                i = C8203d.m14486n(dYt).hashCode();
            } else {
                i = System.identityHashCode(this);
            }
            this.aBR = i;
        }
        return i;
    }

    public final C31619g dZD() {
        return C41434a.m72275G(dYs());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17313an)) {
            return false;
        }
        if (obj.hashCode() != hashCode()) {
            return false;
        }
        if (((C17313an) obj).getParameters().size() != getParameters().size()) {
            return false;
        }
        C46865e dYt = dYs();
        C0036h dYs = ((C17313an) obj).dYs();
        if (!C44923b.m82158d(dYt) || (dYs != null && !C44923b.m82158d(dYs))) {
            return false;
        }
        if (!(dYs instanceof C46865e)) {
            return false;
        }
        dYt = dYt;
        C46865e c46865e = (C46865e) dYs;
        if (!dYt.dZg().equals(c46865e.dZg())) {
            return false;
        }
        C31642l dXW = dYt.dXW();
        C31642l dXW2 = c46865e.dXW();
        while (dXW != null && dXW2 != null) {
            if (dXW instanceof C25093y) {
                return dXW2 instanceof C25093y;
            }
            if (dXW2 instanceof C25093y) {
                return false;
            }
            if (dXW instanceof C36953ab) {
                if (!((dXW2 instanceof C36953ab) && ((C36953ab) dXW).dZF().equals(((C36953ab) dXW2).dZF()))) {
                    return false;
                }
            } else if (dXW2 instanceof C36953ab) {
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

    /* renamed from: d */
    private static boolean m82158d(C0036h c0036h) {
        return (C25235p.m39792L(c0036h) || C8203d.m14485m(c0036h)) ? false : true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sb */
    public final Collection<C46867w> mo59083sb(boolean z) {
        C31642l dXW = dYs().dXW();
        if (!(dXW instanceof C46865e)) {
            return Collections.emptyList();
        }
        C37067h c37067h = new C37067h();
        C46865e c46865e = (C46865e) dXW;
        c37067h.add(c46865e.dZf());
        c46865e = c46865e.dYa();
        if (z && c46865e != null) {
            c37067h.add(c46865e.dZf());
        }
        return c37067h;
    }

    /* Access modifiers changed, original: protected|final */
    public final C46867w ear() {
        if (C31619g.m51119e(dYs())) {
            return null;
        }
        return C41434a.m72275G(dYs()).dXM();
    }
}
