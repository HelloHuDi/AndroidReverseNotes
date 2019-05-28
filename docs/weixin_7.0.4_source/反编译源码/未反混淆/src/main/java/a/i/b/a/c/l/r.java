package a.i.b.a.c.l;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.h.c;
import a.i.b.a.c.h.i;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r extends q implements f {
    public static boolean BJA;
    public static final a BJB = new a();
    private boolean BJz;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(122585);
        AppMethodBeat.o(122585);
    }

    public r(ad adVar, ad adVar2) {
        j.p(adVar, "lowerBound");
        j.p(adVar2, "upperBound");
        super(adVar, adVar2);
        AppMethodBeat.i(122584);
        AppMethodBeat.o(122584);
    }

    public final w R(w wVar) {
        az azVar;
        AppMethodBeat.i(122580);
        j.p(wVar, "replacement");
        az ekn = wVar.ekn();
        if (ekn instanceof q) {
            azVar = ekn;
        } else if (ekn instanceof ad) {
            azVar = x.a((ad) ekn, ((ad) ekn).rL(true));
        } else {
            m mVar = new m();
            AppMethodBeat.o(122580);
            throw mVar;
        }
        w a = ax.a(azVar, ekn);
        AppMethodBeat.o(122580);
        return a;
    }

    public final String a(c cVar, i iVar) {
        AppMethodBeat.i(122582);
        j.p(cVar, "renderer");
        j.p(iVar, "options");
        String str;
        if (iVar.eiS()) {
            str = "(" + cVar.b(this.BJx) + ".." + cVar.b(this.BJy) + ')';
            AppMethodBeat.o(122582);
            return str;
        }
        str = cVar.a(cVar.b(this.BJx), cVar.b(this.BJy), a.i.b.a.c.l.c.a.aL(this));
        AppMethodBeat.o(122582);
        return str;
    }

    public final ad eby() {
        boolean z = true;
        AppMethodBeat.i(122578);
        if (BJA && !this.BJz) {
            boolean z2;
            this.BJz = true;
            if (t.ai(this.BJx)) {
                z2 = false;
            } else {
                z2 = true;
            }
            Throwable assertionError;
            if (!aa.AUz || z2) {
                if (t.ai(this.BJy)) {
                    z = false;
                }
                if (!aa.AUz || z) {
                    int j = j.j(this.BJx, this.BJy) ^ 1;
                    if (aa.AUz && j == 0) {
                        assertionError = new AssertionError("Lower and upper bounds are equal: " + this.BJx + " == " + this.BJy);
                        AppMethodBeat.o(122578);
                        throw assertionError;
                    }
                    z2 = a.i.b.a.c.l.a.c.BKs.c(this.BJx, this.BJy);
                    if (aa.AUz && !z2) {
                        assertionError = new AssertionError("Lower bound " + this.BJx + " of a flexible type must be a subtype of the upper bound " + this.BJy);
                        AppMethodBeat.o(122578);
                        throw assertionError;
                    }
                }
                assertionError = new AssertionError("Upper bound of a flexible type can not be flexible: " + this.BJy);
                AppMethodBeat.o(122578);
                throw assertionError;
            }
            assertionError = new AssertionError("Lower bound of a flexible type can not be flexible: " + this.BJx);
            AppMethodBeat.o(122578);
            throw assertionError;
        }
        ad adVar = this.BJx;
        AppMethodBeat.o(122578);
        return adVar;
    }

    public final boolean ech() {
        AppMethodBeat.i(122579);
        if ((this.BJx.ejw().dYs() instanceof ar) && j.j(this.BJx.ejw(), this.BJy.ejw())) {
            AppMethodBeat.o(122579);
            return true;
        }
        AppMethodBeat.o(122579);
        return false;
    }

    public final az b(g gVar) {
        AppMethodBeat.i(122581);
        j.p(gVar, "newAnnotations");
        az a = x.a(this.BJx.d(gVar), this.BJy.d(gVar));
        AppMethodBeat.o(122581);
        return a;
    }

    public final az rK(boolean z) {
        AppMethodBeat.i(122583);
        az a = x.a(this.BJx.rL(z), this.BJy.rL(z));
        AppMethodBeat.o(122583);
        return a;
    }
}
