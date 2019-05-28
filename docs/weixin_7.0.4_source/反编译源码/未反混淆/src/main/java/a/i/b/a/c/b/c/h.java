package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.w;
import a.i.b.a.c.i.e.h.b;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class h extends g {
    static final /* synthetic */ boolean $assertionsDisabled = (!h.class.desiredAssertionStatus());
    private d BhA;
    private final w Bhv;
    private final f Bhw;
    private final an Bhx;
    private a.i.b.a.c.i.e.h Bhy;
    private Set<d> Bhz;

    static {
        AppMethodBeat.i(119427);
        AppMethodBeat.o(119427);
    }

    public h(l lVar, a.i.b.a.c.f.f fVar, w wVar, f fVar2, Collection<a.i.b.a.c.l.w> collection, am amVar, i iVar) {
        super(iVar, lVar, fVar, amVar);
        AppMethodBeat.i(119422);
        if ($assertionsDisabled || wVar != w.SEALED) {
            this.Bhv = wVar;
            this.Bhw = fVar2;
            this.Bhx = new e(this, Collections.emptyList(), collection, iVar);
            AppMethodBeat.o(119422);
            return;
        }
        AssertionError assertionError = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
        AppMethodBeat.o(119422);
        throw assertionError;
    }

    public final void a(a.i.b.a.c.i.e.h hVar, Set<d> set, d dVar) {
        this.Bhy = hVar;
        this.Bhz = set;
        this.BhA = dVar;
    }

    public final g dYn() {
        AppMethodBeat.i(119423);
        a aVar = g.BfJ;
        g eai = a.eai();
        AppMethodBeat.o(119423);
        return eai;
    }

    public final an dXY() {
        return this.Bhx;
    }

    public final Collection<d> dYb() {
        return this.Bhz;
    }

    public final a.i.b.a.c.i.e.h dXZ() {
        return this.Bhy;
    }

    public final a.i.b.a.c.i.e.h dXX() {
        return b.BGh;
    }

    public final a.i.b.a.c.b.e dYa() {
        return null;
    }

    public final f dYc() {
        return this.Bhw;
    }

    public final boolean dYg() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final d dYe() {
        return this.BhA;
    }

    public final w dYd() {
        return this.Bhv;
    }

    public final az dYf() {
        return ay.Bfa;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYh() {
        return false;
    }

    public String toString() {
        AppMethodBeat.i(119424);
        String str = "class " + this.BgZ;
        AppMethodBeat.o(119424);
        return str;
    }

    public final List<ar> dYq() {
        AppMethodBeat.i(119425);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(119425);
        return emptyList;
    }

    public final Collection<a.i.b.a.c.b.e> dYp() {
        AppMethodBeat.i(119426);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(119426);
        return emptyList;
    }
}
