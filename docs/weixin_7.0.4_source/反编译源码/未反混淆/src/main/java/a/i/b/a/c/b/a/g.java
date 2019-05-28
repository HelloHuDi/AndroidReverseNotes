package a.i.b.a.c.b.a;

import a.a.v;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public interface g extends a.f.b.a.a, Iterable<c> {
    public static final a BfJ = a.BfL;

    public static final class a {
        private static final g BfK = new a();
        static final /* synthetic */ a BfL = new a();

        public static final class a implements g {
            a() {
            }

            public final /* synthetic */ c i(a.i.b.a.c.f.b bVar) {
                AppMethodBeat.i(119329);
                j.p(bVar, "fqName");
                AppMethodBeat.o(119329);
                return null;
            }

            public final boolean j(a.i.b.a.c.f.b bVar) {
                AppMethodBeat.i(119331);
                j.p(bVar, "fqName");
                boolean b = b.b(this, bVar);
                AppMethodBeat.o(119331);
                return b;
            }

            public final boolean isEmpty() {
                return true;
            }

            public final String toString() {
                return "EMPTY";
            }

            public final Iterator<c> iterator() {
                AppMethodBeat.i(119330);
                Iterator it = v.AUP.iterator();
                AppMethodBeat.o(119330);
                return it;
            }
        }

        static {
            AppMethodBeat.i(119333);
            AppMethodBeat.o(119333);
        }

        private a() {
        }

        public static g eai() {
            return BfK;
        }

        public static g fS(List<? extends c> list) {
            AppMethodBeat.i(119332);
            j.p(list, "annotations");
            g gVar;
            if (list.isEmpty()) {
                gVar = BfK;
                AppMethodBeat.o(119332);
                return gVar;
            }
            gVar = new h(list);
            AppMethodBeat.o(119332);
            return gVar;
        }
    }

    public static final class b {
        public static c a(g gVar, a.i.b.a.c.f.b bVar) {
            Object obj;
            AppMethodBeat.i(119334);
            j.p(bVar, "fqName");
            for (Object next : gVar) {
                if (j.j(((c) next).dZF(), bVar)) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            c cVar = (c) obj;
            AppMethodBeat.o(119334);
            return cVar;
        }

        public static boolean b(g gVar, a.i.b.a.c.f.b bVar) {
            AppMethodBeat.i(119335);
            j.p(bVar, "fqName");
            if (gVar.i(bVar) != null) {
                AppMethodBeat.o(119335);
                return true;
            }
            AppMethodBeat.o(119335);
            return false;
        }
    }

    c i(a.i.b.a.c.f.b bVar);

    boolean isEmpty();

    boolean j(a.i.b.a.c.f.b bVar);
}
