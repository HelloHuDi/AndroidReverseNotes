package a.i.b.a.c.l;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class aj extends ad {
    private final boolean BEI;
    private final an BJO;
    private final an BJm;
    private final h BiC;

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122639);
        az d = d(gVar);
        AppMethodBeat.o(122639);
        return d;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122641);
        az rL = rL(z);
        AppMethodBeat.o(122641);
        return rL;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public final an ejw() {
        return this.BJm;
    }

    public final h dXR() {
        return this.BiC;
    }

    private aj(an anVar, boolean z, an anVar2, h hVar) {
        j.p(anVar, "originalTypeVariable");
        j.p(anVar2, "constructor");
        j.p(hVar, "memberScope");
        AppMethodBeat.i(122643);
        this.BJO = anVar;
        this.BEI = z;
        this.BJm = anVar2;
        this.BiC = hVar;
        AppMethodBeat.o(122643);
    }

    public final g dYn() {
        AppMethodBeat.i(122637);
        a aVar = g.BfJ;
        g eai = a.eai();
        AppMethodBeat.o(122637);
        return eai;
    }

    public final ad d(g gVar) {
        AppMethodBeat.i(122638);
        j.p(gVar, "newAnnotations");
        Throwable illegalStateException = new IllegalStateException("Shouldn't be called on non-fixed type".toString());
        AppMethodBeat.o(122638);
        throw illegalStateException;
    }

    public final String toString() {
        AppMethodBeat.i(122642);
        String str = "NonFixed: " + this.BJO;
        AppMethodBeat.o(122642);
        return str;
    }

    public final List<ap> ejt() {
        return v.AUP;
    }

    public final ad rL(boolean z) {
        AppMethodBeat.i(122640);
        if (z == this.BEI) {
            ad adVar = this;
            AppMethodBeat.o(122640);
            return adVar;
        }
        ad ajVar = new aj(this.BJO, z, this.BJm, this.BiC);
        AppMethodBeat.o(122640);
        return ajVar;
    }
}
