package a.i.b.a.c.h;

import a.a.ai;
import a.f.b.j;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public interface b {

    public static final class b implements b {
        public static final b BBE = new b();

        static {
            AppMethodBeat.i(121702);
            AppMethodBeat.o(121702);
        }

        private b() {
        }

        public final String a(h hVar, c cVar) {
            AppMethodBeat.i(121701);
            j.p(hVar, "classifier");
            j.p(cVar, "renderer");
            String b;
            if (hVar instanceof ar) {
                f dZg = ((ar) hVar).dZg();
                j.o(dZg, "classifier.name");
                b = cVar.b(dZg, false);
                AppMethodBeat.o(121701);
                return b;
            }
            ArrayList arrayList = new ArrayList();
            l lVar = hVar;
            do {
                arrayList.add(lVar.dZg());
                lVar = lVar.dXW();
            } while (lVar instanceof e);
            List list = arrayList;
            j.p(list, "receiver$0");
            b = q.fZ(new ai(list));
            AppMethodBeat.o(121701);
            return b;
        }
    }

    public static final class a implements b {
        public static final a BBD = new a();

        static {
            AppMethodBeat.i(121700);
            AppMethodBeat.o(121700);
        }

        private a() {
        }

        public final String a(h hVar, c cVar) {
            AppMethodBeat.i(121699);
            j.p(hVar, "classifier");
            j.p(cVar, "renderer");
            String b;
            if (hVar instanceof ar) {
                f dZg = ((ar) hVar).dZg();
                j.o(dZg, "classifier.name");
                b = cVar.b(dZg, false);
                AppMethodBeat.o(121699);
                return b;
            }
            a.i.b.a.c.f.c n = d.n(hVar);
            j.o(n, "DescriptorUtils.getFqName(classifier)");
            b = cVar.f(n);
            AppMethodBeat.o(121699);
            return b;
        }
    }

    public static final class c implements b {
        public static final c BBF = new c();

        static {
            AppMethodBeat.i(121706);
            AppMethodBeat.o(121706);
        }

        private c() {
        }

        public final String a(h hVar, c cVar) {
            AppMethodBeat.i(121703);
            j.p(hVar, "classifier");
            j.p(cVar, "renderer");
            String a = a(hVar);
            AppMethodBeat.o(121703);
            return a;
        }

        private final String a(h hVar) {
            AppMethodBeat.i(121704);
            f dZg = hVar.dZg();
            j.o(dZg, "descriptor.name");
            String y = q.y(dZg);
            if (hVar instanceof ar) {
                AppMethodBeat.o(121704);
                return y;
            }
            l dXW = hVar.dXW();
            j.o(dXW, "descriptor.containingDeclaration");
            String j = j(dXW);
            if (j == null || (j.j(j, "") ^ 1) == 0) {
                AppMethodBeat.o(121704);
                return y;
            }
            y = j + "." + y;
            AppMethodBeat.o(121704);
            return y;
        }

        private final String j(l lVar) {
            AppMethodBeat.i(121705);
            String a;
            if (lVar instanceof e) {
                a = a((h) lVar);
                AppMethodBeat.o(121705);
                return a;
            } else if (lVar instanceof ab) {
                a.i.b.a.c.f.c cVar = ((ab) lVar).dZF().ByQ;
                j.o(cVar, "descriptor.fqName.toUnsafe()");
                a = q.g(cVar);
                AppMethodBeat.o(121705);
                return a;
            } else {
                AppMethodBeat.o(121705);
                return null;
            }
        }
    }

    String a(h hVar, c cVar);
}
