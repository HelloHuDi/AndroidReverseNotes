package a.i.b.a.c.l.a;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.c.a;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class f implements an {
    private final ap BKy;
    List<? extends az> BKz;

    public /* synthetic */ f(ap apVar) {
        this(apVar, null);
    }

    public f(ap apVar, List<? extends az> list) {
        j.p(apVar, "projection");
        AppMethodBeat.i(122731);
        this.BKy = apVar;
        this.BKz = list;
        AppMethodBeat.o(122731);
    }

    public final boolean dYu() {
        return false;
    }

    public final h dYs() {
        return null;
    }

    public final g dZD() {
        AppMethodBeat.i(122729);
        w dZS = this.BKy.dZS();
        j.o(dZS, "projection.type");
        g aL = a.aL(dZS);
        AppMethodBeat.o(122729);
        return aL;
    }

    public final String toString() {
        AppMethodBeat.i(122730);
        String str = "CapturedType(" + this.BKy + ')';
        AppMethodBeat.o(122730);
        return str;
    }

    public final /* bridge */ /* synthetic */ Collection eap() {
        List list = this.BKz;
        if (list == null) {
            list = v.AUP;
        }
        return list;
    }

    public final List<ar> getParameters() {
        return v.AUP;
    }
}
