package a.i.b.a.c.l;

public abstract class aq implements ap {
    public String toString() {
        if (ekp()) {
            return "*";
        }
        if (ekq() == ba.INVARIANT) {
            return dZS().toString();
        }
        return ekq() + " " + dZS();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ap)) {
            return false;
        }
        ap apVar = (ap) obj;
        if (ekp() != apVar.ekp()) {
            return false;
        }
        if (ekq() != apVar.ekq()) {
            return false;
        }
        if (dZS().equals(apVar.dZS())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (ekp() ? 17 : dZS().hashCode()) + (ekq().hashCode() * 31);
    }
}
