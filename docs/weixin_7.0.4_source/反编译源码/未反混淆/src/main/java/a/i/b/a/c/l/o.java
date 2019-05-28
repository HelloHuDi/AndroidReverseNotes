package a.i.b.a.c.l;

import a.a.t;
import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class o extends ad {
    private final boolean BEI;
    private final an BJm;
    private final List<ap> BeP;
    private final h BiC;

    public o(an anVar, h hVar, byte b) {
        this(anVar, hVar);
    }

    public final /* synthetic */ az b(g gVar) {
        AppMethodBeat.i(122533);
        az d = d(gVar);
        AppMethodBeat.o(122533);
        return d;
    }

    public /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122535);
        az rL = rL(z);
        AppMethodBeat.o(122535);
        return rL;
    }

    public final an ejw() {
        return this.BJm;
    }

    public final h dXR() {
        return this.BiC;
    }

    public final List<ap> ejt() {
        return this.BeP;
    }

    public final boolean eci() {
        return this.BEI;
    }

    public o(an anVar, h hVar, List<? extends ap> list, boolean z) {
        j.p(anVar, "constructor");
        j.p(hVar, "memberScope");
        j.p(list, "arguments");
        AppMethodBeat.i(122536);
        this.BJm = anVar;
        this.BiC = hVar;
        this.BeP = list;
        this.BEI = z;
        AppMethodBeat.o(122536);
    }

    public final g dYn() {
        AppMethodBeat.i(122530);
        a aVar = g.BfJ;
        g eai = a.eai();
        AppMethodBeat.o(122530);
        return eai;
    }

    public String toString() {
        String str;
        AppMethodBeat.i(122531);
        StringBuilder append = new StringBuilder().append(this.BJm.toString());
        if (this.BeP.isEmpty()) {
            str = "";
        } else {
            str = t.a(this.BeP, ", ", "<", ">", -1, "...", null);
        }
        str = append.append(str).toString();
        AppMethodBeat.o(122531);
        return str;
    }

    public final ad d(g gVar) {
        AppMethodBeat.i(122532);
        j.p(gVar, "newAnnotations");
        ad adVar = this;
        AppMethodBeat.o(122532);
        return adVar;
    }

    public ad rL(boolean z) {
        AppMethodBeat.i(122534);
        ad oVar = new o(this.BJm, this.BiC, this.BeP, z);
        AppMethodBeat.o(122534);
        return oVar;
    }

    private /* synthetic */ o(an anVar, h hVar) {
        this(anVar, hVar, v.AUP, false);
        AppMethodBeat.i(122537);
        AppMethodBeat.o(122537);
    }
}
