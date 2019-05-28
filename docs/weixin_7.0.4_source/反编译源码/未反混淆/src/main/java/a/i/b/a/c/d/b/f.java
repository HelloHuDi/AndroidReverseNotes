package a.i.b.a.c.d.b;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.f.a;
import a.i.b.a.c.j.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f implements a.i.b.a.c.j.a.f {
    private final m BmS;
    private final e BmT;

    public f(m mVar, e eVar) {
        j.p(mVar, "kotlinClassFinder");
        j.p(eVar, "deserializedDescriptorResolver");
        AppMethodBeat.i(120262);
        this.BmS = mVar;
        this.BmT = eVar;
        AppMethodBeat.o(120262);
    }

    public final e g(a aVar) {
        AppMethodBeat.i(120261);
        j.p(aVar, "classId");
        n b = this.BmS.b(aVar);
        if (b == null) {
            AppMethodBeat.o(120261);
            return null;
        }
        boolean j = j.j(b.dWY(), aVar);
        if (!aa.AUz || j) {
            e a = this.BmT.a(b);
            AppMethodBeat.o(120261);
            return a;
        }
        Throwable assertionError = new AssertionError("Class with incorrect id found: expected " + aVar + ", actual " + b.dWY());
        AppMethodBeat.o(120261);
        throw assertionError;
    }
}
