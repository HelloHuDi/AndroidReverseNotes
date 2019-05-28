package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.p.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ae extends ad {
    private final boolean BEI;
    private final an BJm;
    private final List<ap> BeP;
    private final h BiC;

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122619);
        az d = d(gVar);
        AppMethodBeat.o(122619);
        return d;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122621);
        az rL = rL(z);
        AppMethodBeat.o(122621);
        return rL;
    }

    public final an ejw() {
        return this.BJm;
    }

    public final List<ap> ejt() {
        return this.BeP;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public final h dXR() {
        return this.BiC;
    }

    public ae(an anVar, List<? extends ap> list, boolean z, h hVar) {
        j.p(anVar, "constructor");
        j.p(list, "arguments");
        j.p(hVar, "memberScope");
        AppMethodBeat.i(122622);
        this.BJm = anVar;
        this.BeP = list;
        this.BEI = z;
        this.BiC = hVar;
        if (this.BiC instanceof b) {
            Throwable illegalStateException = new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.BiC + 10 + this.BJm);
            AppMethodBeat.o(122622);
            throw illegalStateException;
        }
        AppMethodBeat.o(122622);
    }

    public final g dYn() {
        AppMethodBeat.i(122617);
        a aVar = g.BfJ;
        g eai = a.eai();
        AppMethodBeat.o(122617);
        return eai;
    }

    public final ad d(g gVar) {
        AppMethodBeat.i(122618);
        j.p(gVar, "newAnnotations");
        if (gVar.isEmpty()) {
            ad adVar = this;
            AppMethodBeat.o(122618);
            return adVar;
        }
        ad dVar = new d(this, gVar);
        AppMethodBeat.o(122618);
        return dVar;
    }

    public final ad rL(boolean z) {
        j jVar;
        AppMethodBeat.i(122620);
        if (z == this.BEI) {
            jVar = this;
        } else if (z) {
            jVar = new ab(this);
        } else {
            jVar = new aa(this);
        }
        ad adVar = jVar;
        AppMethodBeat.o(122620);
        return adVar;
    }
}
