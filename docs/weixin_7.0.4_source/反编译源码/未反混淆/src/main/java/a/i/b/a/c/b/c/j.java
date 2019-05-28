package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.b;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.h.c;

public abstract class j extends b implements l {
    protected final f BgZ;

    public j(g gVar, f fVar) {
        super(gVar);
        this.BgZ = fVar;
    }

    public final f dZg() {
        return this.BgZ;
    }

    public l dZd() {
        return this;
    }

    public String toString() {
        return h(this);
    }

    public static String h(l lVar) {
        try {
            return c.BBN.k(lVar) + "[" + lVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(lVar)) + "]";
        } catch (Throwable th) {
            return lVar.getClass().getSimpleName() + " " + lVar.dZg();
        }
    }
}
