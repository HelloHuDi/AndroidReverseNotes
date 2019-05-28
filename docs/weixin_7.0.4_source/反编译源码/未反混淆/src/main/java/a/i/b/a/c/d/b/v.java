package a.i.b.a.c.d.b;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.e;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class v implements u<j> {
    public static final v BrL = new v();

    static {
        AppMethodBeat.i(120325);
        AppMethodBeat.o(120325);
    }

    private v() {
    }

    public final /* synthetic */ Object t(e eVar) {
        AppMethodBeat.i(120322);
        j.p(eVar, "classDescriptor");
        AppMethodBeat.o(120322);
        return null;
    }

    public final w m(Collection<? extends w> collection) {
        AppMethodBeat.i(120321);
        j.p(collection, "types");
        Throwable assertionError = new AssertionError("There should be no intersection type in existing descriptors, but found: " + t.a((Iterable) collection, null, null, null, 0, null, null, 63));
        AppMethodBeat.o(120321);
        throw assertionError;
    }

    public final String u(e eVar) {
        AppMethodBeat.i(120323);
        j.p(eVar, "classDescriptor");
        AppMethodBeat.o(120323);
        return null;
    }

    public final void a(w wVar, e eVar) {
        AppMethodBeat.i(120324);
        j.p(wVar, "kotlinType");
        j.p(eVar, "descriptor");
        AppMethodBeat.o(120324);
    }
}
