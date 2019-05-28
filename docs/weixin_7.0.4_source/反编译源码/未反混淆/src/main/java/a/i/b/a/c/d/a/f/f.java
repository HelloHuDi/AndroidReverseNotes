package a.i.b.a.c.d.a.f;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ax;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.c.a;
import a.i.b.a.c.l.i;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends i implements a.i.b.a.c.l.f {
    private final ad BpK;

    public f(ad adVar) {
        j.p(adVar, "delegate");
        AppMethodBeat.i(120105);
        this.BpK = adVar;
        AppMethodBeat.o(120105);
    }

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(120101);
        az c = c(gVar);
        AppMethodBeat.o(120101);
        return c;
    }

    public final /* synthetic */ ad d(g gVar) {
        AppMethodBeat.i(120102);
        ad c = c(gVar);
        AppMethodBeat.o(120102);
        return c;
    }

    public final ad eby() {
        return this.BpK;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(120104);
        az rL = rL(z);
        AppMethodBeat.o(120104);
        return rL;
    }

    public final boolean ech() {
        return true;
    }

    public final w R(w wVar) {
        AppMethodBeat.i(120098);
        j.p(wVar, "replacement");
        az ekn = wVar.ekn();
        w a;
        if (!av.aB(ekn) && !a.aE(ekn)) {
            w wVar2 = ekn;
            AppMethodBeat.o(120098);
            return wVar2;
        } else if (ekn instanceof ad) {
            a = a((ad) ekn);
            AppMethodBeat.o(120098);
            return a;
        } else if (ekn instanceof q) {
            a = ax.b(x.a(a(((q) ekn).BJx), a(((q) ekn).BJy)), ax.aG(ekn));
            AppMethodBeat.o(120098);
            return a;
        } else {
            Throwable illegalStateException = new IllegalStateException("Incorrect type: ".concat(String.valueOf(ekn)).toString());
            AppMethodBeat.o(120098);
            throw illegalStateException;
        }
    }

    public final boolean eci() {
        return false;
    }

    private static ad a(ad adVar) {
        AppMethodBeat.i(120099);
        ad rL = adVar.rL(false);
        if (a.aE(adVar)) {
            ad fVar = new f(rL);
            AppMethodBeat.o(120099);
            return fVar;
        }
        AppMethodBeat.o(120099);
        return rL;
    }

    private f c(g gVar) {
        AppMethodBeat.i(120100);
        j.p(gVar, "newAnnotations");
        f fVar = new f(this.BpK.d(gVar));
        AppMethodBeat.o(120100);
        return fVar;
    }

    public final ad rL(boolean z) {
        AppMethodBeat.i(120103);
        ad rL;
        if (z) {
            rL = this.BpK.rL(true);
            AppMethodBeat.o(120103);
            return rL;
        }
        rL = this;
        AppMethodBeat.o(120103);
        return rL;
    }
}
