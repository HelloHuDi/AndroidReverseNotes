package a.i.b.a.c.i.b;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b extends f<List<? extends f<?>>> {
    private final a.f.a.b<y, w> BEN;

    public b(List<? extends f<?>> list, a.f.a.b<? super y, ? extends w> bVar) {
        j.p(list, "value");
        j.p(bVar, "computeType");
        super(list);
        AppMethodBeat.i(122069);
        this.BEN = bVar;
        AppMethodBeat.o(122069);
    }

    public final w b(y yVar) {
        AppMethodBeat.i(122068);
        j.p(yVar, "module");
        Object am = this.BEN.am(yVar);
        w wVar = (w) am;
        Object obj = (g.n(wVar) || g.o(wVar)) ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Type should be an array, but was " + wVar + ": " + ((List) getValue()));
            AppMethodBeat.o(122068);
            throw assertionError;
        }
        w wVar2 = (w) am;
        AppMethodBeat.o(122068);
        return wVar2;
    }
}
