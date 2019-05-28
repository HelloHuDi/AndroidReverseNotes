package a.i.b.a.c.b.a;

import a.a.i;
import a.a.t;
import a.f.b.j;
import a.j.h;
import a.j.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class k implements g {
    private final List<g> BfS;

    static final class a extends a.f.b.k implements a.f.a.b<g, c> {
        final /* synthetic */ a.i.b.a.c.f.b BfT;

        a(a.i.b.a.c.f.b bVar) {
            this.BfT = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119348);
            g gVar = (g) obj;
            j.p(gVar, "it");
            c i = gVar.i(this.BfT);
            AppMethodBeat.o(119348);
            return i;
        }
    }

    static final class b extends a.f.b.k implements a.f.a.b<g, h<? extends c>> {
        public static final b BfU = new b();

        static {
            AppMethodBeat.i(119350);
            AppMethodBeat.o(119350);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119349);
            g gVar = (g) obj;
            j.p(gVar, "it");
            h t = t.t(gVar);
            AppMethodBeat.o(119349);
            return t;
        }
    }

    public k(List<? extends g> list) {
        j.p(list, "delegates");
        AppMethodBeat.i(119355);
        this.BfS = list;
        AppMethodBeat.o(119355);
    }

    public k(g... gVarArr) {
        j.p(gVarArr, "delegates");
        this(i.Q(gVarArr));
        AppMethodBeat.i(119356);
        AppMethodBeat.o(119356);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(119351);
        Iterable<g> iterable = this.BfS;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (g isEmpty : iterable) {
                if (!isEmpty.isEmpty()) {
                    AppMethodBeat.o(119351);
                    return false;
                }
            }
        }
        AppMethodBeat.o(119351);
        return true;
    }

    public final boolean j(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119352);
        j.p(bVar, "fqName");
        for (g j : t.t(this.BfS)) {
            if (j.j(bVar)) {
                AppMethodBeat.o(119352);
                return true;
            }
        }
        AppMethodBeat.o(119352);
        return false;
    }

    public final c i(a.i.b.a.c.f.b bVar) {
        Object next;
        AppMethodBeat.i(119353);
        j.p(bVar, "fqName");
        h e = n.e(t.t(this.BfS), new a(bVar));
        j.p(e, "receiver$0");
        Iterator it = e.iterator();
        if (it.hasNext()) {
            next = it.next();
        } else {
            next = null;
        }
        c cVar = (c) next;
        AppMethodBeat.o(119353);
        return cVar;
    }

    public final Iterator<c> iterator() {
        AppMethodBeat.i(119354);
        Iterator it = n.c(t.t(this.BfS), b.BfU).iterator();
        AppMethodBeat.o(119354);
        return it;
    }
}
