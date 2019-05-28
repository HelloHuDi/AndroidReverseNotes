package a.i.b.a.c.d.a.b;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.c.f;
import a.i.b.a.c.b.c.p;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends f implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
    private Boolean Bmy = null;
    private Boolean Bmz = null;

    static {
        AppMethodBeat.i(119794);
        AppMethodBeat.o(119794);
    }

    public final /* synthetic */ p a(l lVar, t tVar, a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(119792);
        c c = c(lVar, tVar, aVar, fVar, gVar, amVar);
        AppMethodBeat.o(119792);
        return c;
    }

    public final /* synthetic */ f b(l lVar, t tVar, a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(119791);
        c c = c(lVar, tVar, aVar, fVar, gVar, amVar);
        AppMethodBeat.o(119791);
        return c;
    }

    private c(e eVar, c cVar, g gVar, boolean z, a aVar, am amVar) {
        super(eVar, cVar, gVar, z, aVar, amVar);
    }

    public static c a(e eVar, g gVar, boolean z, am amVar) {
        AppMethodBeat.i(119785);
        c cVar = new c(eVar, null, gVar, z, a.DECLARATION, amVar);
        AppMethodBeat.o(119785);
        return cVar;
    }

    public final boolean eaw() {
        AppMethodBeat.i(119786);
        if ($assertionsDisabled || this.Bmy != null) {
            boolean booleanValue = this.Bmy.booleanValue();
            AppMethodBeat.o(119786);
            return booleanValue;
        }
        AssertionError assertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(119786);
        throw assertionError;
    }

    public final void rH(boolean z) {
        AppMethodBeat.i(119787);
        this.Bmy = Boolean.valueOf(z);
        AppMethodBeat.o(119787);
    }

    public final boolean dYW() {
        AppMethodBeat.i(119788);
        if ($assertionsDisabled || this.Bmz != null) {
            boolean booleanValue = this.Bmz.booleanValue();
            AppMethodBeat.o(119788);
            return booleanValue;
        }
        AssertionError assertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(119788);
        throw assertionError;
    }

    public final void rI(boolean z) {
        AppMethodBeat.i(119789);
        this.Bmz = Boolean.valueOf(z);
        AppMethodBeat.o(119789);
    }

    private c c(l lVar, t tVar, a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(119790);
        if (aVar != a.DECLARATION && aVar != a.SYNTHESIZED) {
            IllegalStateException illegalStateException = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + lVar + "\nkind: " + aVar);
            AppMethodBeat.o(119790);
            throw illegalStateException;
        } else if ($assertionsDisabled || fVar == null) {
            c cVar = new c((e) lVar, (c) tVar, gVar, this.hEK, aVar, amVar);
            cVar.rH(eaw());
            cVar.rI(dYW());
            AppMethodBeat.o(119790);
            return cVar;
        } else {
            AssertionError assertionError = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.o(119790);
            throw assertionError;
        }
    }
}
