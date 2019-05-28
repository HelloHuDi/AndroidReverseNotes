package a.i.b.a.c.m;

import a.f.b.j;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.t;
import a.i.b.a.c.m.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

final class h implements b {
    public static final h BLG = new h();
    private static final String description = description;

    static {
        AppMethodBeat.i(122874);
        AppMethodBeat.o(122874);
    }

    private h() {
    }

    public final String i(t tVar) {
        AppMethodBeat.i(122875);
        j.p(tVar, "functionDescriptor");
        String a = a.a(this, tVar);
        AppMethodBeat.o(122875);
        return a;
    }

    public final String getDescription() {
        return description;
    }

    public final boolean h(t tVar) {
        AppMethodBeat.i(122873);
        j.p(tVar, "functionDescriptor");
        List dYV = tVar.dYV();
        j.o(dYV, "functionDescriptor.valueParameters");
        Iterable<au> iterable = dYV;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (au auVar : iterable) {
                Object obj;
                j.o(auVar, "it");
                if (a.i.b.a.c.i.c.a.b(auVar) || auVar.dZV() != null) {
                    obj = null;
                    continue;
                } else {
                    obj = 1;
                    continue;
                }
                if (obj == null) {
                    AppMethodBeat.o(122873);
                    return false;
                }
            }
        }
        AppMethodBeat.o(122873);
        return true;
    }
}
