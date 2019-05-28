package a.i.b.a.c.l;

import a.i.b.a.c.b.a.a;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.a.m;
import java.util.List;

public abstract class w implements a {
    public abstract h dXR();

    public abstract boolean eci();

    public abstract List<ap> ejt();

    public abstract an ejw();

    public abstract az ekn();

    private w() {
    }

    public /* synthetic */ w(byte b) {
        this();
    }

    public final int hashCode() {
        if (y.an(this)) {
            return super.hashCode();
        }
        return (eci() ? 1 : 0) + (((ejw().hashCode() * 31) + ejt().hashCode()) * 31);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return eci() == ((w) obj).eci() && m.BKC.a(ekn(), ((w) obj).ekn());
        } else {
            return false;
        }
    }
}
