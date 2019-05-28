package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.l;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.i.e.h.b;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class w extends g {
    static final /* synthetic */ boolean $assertionsDisabled = (!w.class.desiredAssertionStatus());
    private final i Baf;
    private List<ar> BeK;
    private final boolean BeM;
    public az BhQ;
    private a.i.b.a.c.b.w Bhv;
    private final f Bhw;
    private an Bhx;
    private final Collection<a.i.b.a.c.l.w> BiV = new ArrayList();

    static {
        AppMethodBeat.i(119535);
        AppMethodBeat.o(119535);
    }

    public w(l lVar, f fVar, a.i.b.a.c.f.f fVar2, am amVar, i iVar) {
        super(iVar, lVar, fVar2, amVar);
        AppMethodBeat.i(119527);
        this.Baf = iVar;
        if ($assertionsDisabled || fVar != f.OBJECT) {
            this.Bhw = fVar;
            this.BeM = false;
            AppMethodBeat.o(119527);
            return;
        }
        AssertionError assertionError = new AssertionError("Fix isCompanionObject()");
        AppMethodBeat.o(119527);
        throw assertionError;
    }

    public final e dYa() {
        return null;
    }

    public final g dYn() {
        AppMethodBeat.i(119528);
        a aVar = g.BfJ;
        g eai = a.eai();
        AppMethodBeat.o(119528);
        return eai;
    }

    public final void b(a.i.b.a.c.b.w wVar) {
        AppMethodBeat.i(119529);
        if ($assertionsDisabled || wVar != a.i.b.a.c.b.w.SEALED) {
            this.Bhv = wVar;
            AppMethodBeat.o(119529);
            return;
        }
        AssertionError assertionError = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
        AppMethodBeat.o(119529);
        throw assertionError;
    }

    public final a.i.b.a.c.b.w dYd() {
        return this.Bhv;
    }

    public final f dYc() {
        return this.Bhw;
    }

    public final az dYf() {
        return this.BhQ;
    }

    public final boolean dYh() {
        return this.BeM;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
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

    public final an dXY() {
        return this.Bhx;
    }

    public final d dYe() {
        return null;
    }

    public final void fV(List<ar> list) {
        AppMethodBeat.i(119530);
        if (this.BeK != null) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameters are already set for " + this.BgZ);
            AppMethodBeat.o(119530);
            throw illegalStateException;
        }
        this.BeK = new ArrayList(list);
        AppMethodBeat.o(119530);
    }

    public final List<ar> dYq() {
        return this.BeK;
    }

    public final void eaF() {
        AppMethodBeat.i(119531);
        if ($assertionsDisabled || this.Bhx == null) {
            this.Bhx = new a.i.b.a.c.l.e(this, this.BeK, this.BiV, this.Baf);
            for (d dVar : Collections.emptySet()) {
                ((f) dVar).BhN = dZf();
            }
            AppMethodBeat.o(119531);
            return;
        }
        AssertionError assertionError = new AssertionError(this.Bhx);
        AppMethodBeat.o(119531);
        throw assertionError;
    }

    public final h dXZ() {
        return b.BGh;
    }

    public final h dXX() {
        return b.BGh;
    }

    public final Collection<e> dYp() {
        AppMethodBeat.i(119532);
        List emptyList = Collections.emptyList();
        AppMethodBeat.o(119532);
        return emptyList;
    }

    public String toString() {
        AppMethodBeat.i(119533);
        String h = j.h(this);
        AppMethodBeat.o(119533);
        return h;
    }

    public final /* synthetic */ Collection dYb() {
        AppMethodBeat.i(119534);
        Set emptySet = Collections.emptySet();
        AppMethodBeat.o(119534);
        return emptySet;
    }
}
