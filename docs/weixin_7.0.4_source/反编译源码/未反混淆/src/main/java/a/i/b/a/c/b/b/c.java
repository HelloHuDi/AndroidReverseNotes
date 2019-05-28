package a.i.b.a.c.b.b;

import a.f.b.j;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {

    public static final class b implements c {
        public static final b BgX = new b();

        static {
            AppMethodBeat.i(119378);
            AppMethodBeat.o(119378);
        }

        private b() {
        }

        public final boolean a(e eVar, al alVar) {
            AppMethodBeat.i(119377);
            j.p(eVar, "classDescriptor");
            j.p(alVar, "functionDescriptor");
            if (alVar.dYn().j(d.eaj())) {
                AppMethodBeat.o(119377);
                return false;
            }
            AppMethodBeat.o(119377);
            return true;
        }
    }

    public static final class a implements c {
        public static final a BgW = new a();

        static {
            AppMethodBeat.i(119376);
            AppMethodBeat.o(119376);
        }

        private a() {
        }

        public final boolean a(e eVar, al alVar) {
            AppMethodBeat.i(119375);
            j.p(eVar, "classDescriptor");
            j.p(alVar, "functionDescriptor");
            AppMethodBeat.o(119375);
            return true;
        }
    }

    boolean a(e eVar, al alVar);
}
