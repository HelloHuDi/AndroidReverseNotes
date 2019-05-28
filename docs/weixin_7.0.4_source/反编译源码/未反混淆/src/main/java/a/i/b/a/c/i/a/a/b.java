package a.i.b.a.c.i.a.a;

import a.a.k;
import a.a.v;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.i.b.a.c.l.a.f;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class b implements an {
    public final ap BEG;
    public f BEJ;

    public b(ap apVar) {
        j.p(apVar, "typeProjection");
        AppMethodBeat.i(122059);
        this.BEG = apVar;
        Object obj = this.BEG.ekq() != ba.INVARIANT ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Only nontrivial projections can be captured, not: " + this.BEG);
            AppMethodBeat.o(122059);
            throw assertionError;
        }
        AppMethodBeat.o(122059);
    }

    public final /* bridge */ /* synthetic */ h dYs() {
        return null;
    }

    public final Collection<w> eap() {
        Object dZS;
        AppMethodBeat.i(122056);
        if (this.BEG.ekq() == ba.OUT_VARIANCE) {
            dZS = this.BEG.dZS();
        } else {
            w dZS2 = dZD().dXN();
        }
        j.o(dZS2, "if (typeProjection.proje… builtIns.nullableAnyType");
        Collection listOf = k.listOf(dZS2);
        AppMethodBeat.o(122056);
        return listOf;
    }

    public final boolean dYu() {
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(122057);
        String str = "CapturedTypeConstructor(" + this.BEG + ')';
        AppMethodBeat.o(122057);
        return str;
    }

    public final g dZD() {
        AppMethodBeat.i(122058);
        g dZD = this.BEG.dZS().ejw().dZD();
        j.o(dZD, "typeProjection.type.constructor.builtIns");
        AppMethodBeat.o(122058);
        return dZD;
    }

    public final List<ar> getParameters() {
        return v.AUP;
    }
}
