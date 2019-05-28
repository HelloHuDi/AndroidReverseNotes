package a.i.b.a.c.b.c;

import a.f.a.b;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.c.a;
import a.i.b.a.c.i.d;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ah extends e {
    private final b<w, Void> Bjt = null;
    private final List<w> Bju = new ArrayList(1);
    private boolean initialized = false;

    public static ar a(l lVar, g gVar, ba baVar, f fVar, int i) {
        AppMethodBeat.i(119609);
        ah a = a(lVar, gVar, false, baVar, fVar, i, am.BeR);
        a.L(a.G(lVar).dXN());
        a.setInitialized();
        AppMethodBeat.o(119609);
        return a;
    }

    public static ah a(l lVar, g gVar, boolean z, ba baVar, f fVar, int i, am amVar) {
        AppMethodBeat.i(119610);
        ah a = a(lVar, gVar, z, baVar, fVar, i, amVar, ap.a.BeT);
        AppMethodBeat.o(119610);
        return a;
    }

    private static ah a(l lVar, g gVar, boolean z, ba baVar, f fVar, int i, am amVar, ap apVar) {
        AppMethodBeat.i(119611);
        ah ahVar = new ah(lVar, gVar, z, baVar, fVar, i, amVar, apVar);
        AppMethodBeat.o(119611);
        return ahVar;
    }

    private ah(l lVar, g gVar, boolean z, ba baVar, f fVar, int i, am amVar, ap apVar) {
        super(a.i.b.a.c.k.b.BIH, lVar, gVar, fVar, baVar, z, i, amVar, apVar);
        AppMethodBeat.i(119612);
        AppMethodBeat.o(119612);
    }

    private void eaN() {
        AppMethodBeat.i(119613);
        if (this.initialized) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + eaO());
            AppMethodBeat.o(119613);
            throw illegalStateException;
        }
        AppMethodBeat.o(119613);
    }

    private String eaO() {
        AppMethodBeat.i(119614);
        String str = this.BgZ + " declared in " + d.n(dXW());
        AppMethodBeat.o(119614);
        return str;
    }

    public final void setInitialized() {
        AppMethodBeat.i(119615);
        eaN();
        this.initialized = true;
        AppMethodBeat.o(119615);
    }

    public final void L(w wVar) {
        AppMethodBeat.i(119616);
        eaN();
        M(wVar);
        AppMethodBeat.o(119616);
    }

    private void M(w wVar) {
        AppMethodBeat.i(119617);
        if (y.an(wVar)) {
            AppMethodBeat.o(119617);
            return;
        }
        this.Bju.add(wVar);
        AppMethodBeat.o(119617);
    }

    /* Access modifiers changed, original: protected|final */
    public final void J(w wVar) {
        AppMethodBeat.i(119618);
        if (this.Bjt == null) {
            AppMethodBeat.o(119618);
            return;
        }
        this.Bjt.am(wVar);
        AppMethodBeat.o(119618);
    }

    /* Access modifiers changed, original: protected|final */
    public final List<w> eaq() {
        AppMethodBeat.i(119619);
        if (this.initialized) {
            List list = this.Bju;
            AppMethodBeat.o(119619);
            return list;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Type parameter descriptor is not initialized: " + eaO());
        AppMethodBeat.o(119619);
        throw illegalStateException;
    }
}
