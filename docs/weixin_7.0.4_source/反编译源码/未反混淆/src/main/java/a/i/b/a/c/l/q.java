package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.h.c;
import a.i.b.a.c.h.i;
import a.i.b.a.c.i.e.h;
import java.util.List;

public abstract class q extends az implements ak {
    public final ad BJx;
    public final ad BJy;

    public abstract String a(c cVar, i iVar);

    public abstract ad eby();

    public q(ad adVar, ad adVar2) {
        j.p(adVar, "lowerBound");
        j.p(adVar2, "upperBound");
        super();
        this.BJx = adVar;
        this.BJy = adVar2;
    }

    public final w eju() {
        return this.BJx;
    }

    public final w ejv() {
        return this.BJy;
    }

    public final boolean ad(w wVar) {
        j.p(wVar, "type");
        return false;
    }

    public g dYn() {
        return eby().dYn();
    }

    public final an ejw() {
        return eby().ejw();
    }

    public final List<ap> ejt() {
        return eby().ejt();
    }

    public boolean eci() {
        return eby().eci();
    }

    public h dXR() {
        return eby().dXR();
    }

    public String toString() {
        return c.BBN.b(this);
    }
}
