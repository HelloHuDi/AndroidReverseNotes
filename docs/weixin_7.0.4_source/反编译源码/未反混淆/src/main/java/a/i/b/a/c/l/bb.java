package a.i.b.a.c.l;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.i.e.h;
import a.v;
import java.util.List;

public abstract class bb extends w {
    public abstract w eko();

    public bb() {
        super();
    }

    public boolean ekf() {
        return true;
    }

    public final g dYn() {
        return eko().dYn();
    }

    public final an ejw() {
        return eko().ejw();
    }

    public final List<ap> ejt() {
        return eko().ejt();
    }

    public final boolean eci() {
        return eko().eci();
    }

    public final h dXR() {
        return eko().dXR();
    }

    public final az ekn() {
        w eko = eko();
        while (eko instanceof bb) {
            eko = ((bb) eko).eko();
        }
        if (eko != null) {
            return (az) eko;
        }
        throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }

    public String toString() {
        if (ekf()) {
            return eko().toString();
        }
        return "<Not computed yet>";
    }
}
