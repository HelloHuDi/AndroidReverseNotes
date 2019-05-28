package a.i.b.a.c.i.d;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.e;
import a.i.b.a.c.c.a.c;
import a.i.b.a.c.d.a.c.g;
import a.i.b.a.c.d.a.e.aa;
import a.i.b.a.c.f.b;
import a.i.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public final g BFd;
    private final a.i.b.a.c.d.a.a.g BmW;

    public a(g gVar, a.i.b.a.c.d.a.a.g gVar2) {
        j.p(gVar, "packageFragmentProvider");
        j.p(gVar2, "javaResolverCache");
        AppMethodBeat.i(122155);
        this.BFd = gVar;
        this.BmW = gVar2;
        AppMethodBeat.o(122155);
    }

    public final e b(a.i.b.a.c.d.a.e.g gVar) {
        AppMethodBeat.i(122154);
        j.p(gVar, "javaClass");
        b dZF = gVar.dZF();
        if (dZF == null || aa.SOURCE != null) {
            a.i.b.a.c.d.a.e.g ebG = gVar.ebG();
            if (ebG != null) {
                h dZk;
                a.i.b.a.c.b.h c;
                e b = b(ebG);
                if (b != null) {
                    dZk = b.dZk();
                } else {
                    dZk = null;
                }
                if (dZk != null) {
                    c = dZk.c(gVar.dZg(), c.FROM_JAVA_LOADER);
                } else {
                    c = null;
                }
                if (!(c instanceof e)) {
                    c = null;
                }
                b = (e) c;
                AppMethodBeat.o(122154);
                return b;
            } else if (dZF == null) {
                AppMethodBeat.o(122154);
                return null;
            } else {
                g gVar2 = this.BFd;
                dZF = dZF.ehG();
                j.o(dZF, "fqName.parent()");
                a.i.b.a.c.d.a.c.a.h hVar = (a.i.b.a.c.d.a.c.a.h) t.fK(gVar2.h(dZF));
                if (hVar != null) {
                    e c2 = hVar.c(gVar);
                    AppMethodBeat.o(122154);
                    return c2;
                }
                AppMethodBeat.o(122154);
                return null;
            }
        }
        AppMethodBeat.o(122154);
        return null;
    }
}
