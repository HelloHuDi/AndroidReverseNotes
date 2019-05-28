package a.i.b.a.c.d.a.c;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.a.c.a.n;
import a.i.b.a.c.d.a.e.w;
import a.i.b.a.c.d.a.e.x;
import a.i.b.a.c.k.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i implements m {
    final l Bht;
    final int BnA;
    final h Bnn;
    final Map<w, Integer> Bny;
    private final d<w, n> Bnz = this.Bnn.Bnv.Baf.g(new a(this));

    static final class a extends k implements b<w, n> {
        final /* synthetic */ i BnB;

        a(i iVar) {
            this.BnB = iVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119843);
            w wVar = (w) obj;
            j.p(wVar, "typeParameter");
            Integer num = (Integer) this.BnB.Bny.get(wVar);
            if (num != null) {
                int intValue = num.intValue();
                h hVar = this.BnB.Bnn;
                m mVar = this.BnB;
                j.p(hVar, "receiver$0");
                j.p(mVar, "typeParameterResolver");
                n nVar = new n(new h(hVar.Bnv, mVar, hVar.Bnx), wVar, this.BnB.BnA + intValue, this.BnB.Bht);
                AppMethodBeat.o(119843);
                return nVar;
            }
            AppMethodBeat.o(119843);
            return null;
        }
    }

    public i(h hVar, l lVar, x xVar, int i) {
        j.p(hVar, "c");
        j.p(lVar, "containingDeclaration");
        j.p(xVar, "typeParameterOwner");
        AppMethodBeat.i(119845);
        this.Bnn = hVar;
        this.Bht = lVar;
        this.BnA = i;
        this.Bny = a.i.b.a.c.n.a.x(xVar.dYS());
        AppMethodBeat.o(119845);
    }

    public final ar a(w wVar) {
        AppMethodBeat.i(119844);
        j.p(wVar, "javaTypeParameter");
        n nVar = (n) this.Bnz.am(wVar);
        ar arVar;
        if (nVar != null) {
            arVar = nVar;
            AppMethodBeat.o(119844);
            return arVar;
        }
        arVar = this.Bnn.Bnw.a(wVar);
        AppMethodBeat.o(119844);
        return arVar;
    }
}
