package p000a.p010i.p011b.p012a.p015c.p045l;

/* renamed from: a.i.b.a.c.l.aq */
public abstract class C44641aq implements C41446ap {
    public String toString() {
        if (ekp()) {
            return "*";
        }
        if (ekq() == C0163ba.INVARIANT) {
            return dZS().toString();
        }
        return ekq() + " " + dZS();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C41446ap)) {
            return false;
        }
        C41446ap c41446ap = (C41446ap) obj;
        if (ekp() != c41446ap.ekp()) {
            return false;
        }
        if (ekq() != c41446ap.ekq()) {
            return false;
        }
        if (dZS().equals(c41446ap.dZS())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (ekp() ? 17 : dZS().hashCode()) + (ekq().hashCode() * 31);
    }
}
