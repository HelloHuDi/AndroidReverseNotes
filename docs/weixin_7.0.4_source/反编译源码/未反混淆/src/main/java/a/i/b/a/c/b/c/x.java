package a.i.b.a.c.b.c;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.b;
import a.v;

public abstract class x extends k implements ab {
    public final b BfP;

    public final b dZF() {
        return this.BfP;
    }

    public x(y yVar, b bVar) {
        j.p(yVar, "module");
        j.p(bVar, "fqName");
        l lVar = yVar;
        a aVar = g.BfJ;
        super(lVar, a.eai(), bVar.ByQ.ehL(), am.BeR);
        this.BfP = bVar;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        j.p(nVar, "visitor");
        return nVar.a((ab) this, (Object) d);
    }

    /* renamed from: dZE */
    public final y dXW() {
        l dXW = super.dXW();
        if (dXW != null) {
            return (y) dXW;
        }
        throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }

    public am dYo() {
        am amVar = am.BeR;
        j.o(amVar, "SourceElement.NO_SOURCE");
        return amVar;
    }

    public String toString() {
        return "package " + this.BfP;
    }
}
