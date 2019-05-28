package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l extends as {
    public static final a BJl = new a();
    private final as BJj;
    private final as BJk;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(122524);
        AppMethodBeat.o(122524);
    }

    private /* synthetic */ l(as asVar, as asVar2, byte b) {
        this(asVar, asVar2);
    }

    private l(as asVar, as asVar2) {
        this.BJj = asVar;
        this.BJk = asVar2;
    }

    public final ap O(w wVar) {
        AppMethodBeat.i(122519);
        j.p(wVar, "key");
        ap O = this.BJj.O(wVar);
        if (O == null) {
            O = this.BJk.O(wVar);
        }
        AppMethodBeat.o(122519);
        return O;
    }

    public final w a(w wVar, ba baVar) {
        AppMethodBeat.i(122520);
        j.p(wVar, "topLevelType");
        j.p(baVar, "position");
        w a = this.BJk.a(this.BJj.a(wVar, baVar), baVar);
        AppMethodBeat.o(122520);
        return a;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final boolean eki() {
        AppMethodBeat.i(122521);
        if (this.BJj.eki() || this.BJk.eki()) {
            AppMethodBeat.o(122521);
            return true;
        }
        AppMethodBeat.o(122521);
        return false;
    }

    public final boolean ejx() {
        AppMethodBeat.i(122522);
        if (this.BJj.ejx() || this.BJk.ejx()) {
            AppMethodBeat.o(122522);
            return true;
        }
        AppMethodBeat.o(122522);
        return false;
    }

    public final g h(g gVar) {
        AppMethodBeat.i(122523);
        j.p(gVar, "annotations");
        g h = this.BJk.h(this.BJj.h(gVar));
        AppMethodBeat.o(122523);
        return h;
    }

    public static final as a(as asVar, as asVar2) {
        AppMethodBeat.i(122525);
        j.p(asVar, "first");
        j.p(asVar2, "second");
        if (asVar.isEmpty()) {
            AppMethodBeat.o(122525);
            return asVar2;
        } else if (asVar2.isEmpty()) {
            AppMethodBeat.o(122525);
            return asVar;
        } else {
            as lVar = new l(asVar, asVar2, (byte) 0);
            AppMethodBeat.o(122525);
            return lVar;
        }
    }
}
