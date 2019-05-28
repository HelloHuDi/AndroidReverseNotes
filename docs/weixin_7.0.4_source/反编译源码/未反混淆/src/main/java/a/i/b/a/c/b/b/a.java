package a.i.b.a.c.b.b;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public interface a {

    public static final class a implements a {
        public static final a BgV = new a();

        static {
            AppMethodBeat.i(119374);
            AppMethodBeat.o(119374);
        }

        private a() {
        }

        public final Collection<w> l(e eVar) {
            AppMethodBeat.i(119370);
            j.p(eVar, "classDescriptor");
            Collection collection = v.AUP;
            AppMethodBeat.o(119370);
            return collection;
        }

        public final Collection<al> a(f fVar, e eVar) {
            AppMethodBeat.i(119371);
            j.p(fVar, "name");
            j.p(eVar, "classDescriptor");
            Collection collection = v.AUP;
            AppMethodBeat.o(119371);
            return collection;
        }

        public final Collection<f> m(e eVar) {
            AppMethodBeat.i(119372);
            j.p(eVar, "classDescriptor");
            Collection collection = v.AUP;
            AppMethodBeat.o(119372);
            return collection;
        }

        public final Collection<d> o(e eVar) {
            AppMethodBeat.i(119373);
            j.p(eVar, "classDescriptor");
            Collection collection = v.AUP;
            AppMethodBeat.o(119373);
            return collection;
        }
    }

    Collection<al> a(f fVar, e eVar);

    Collection<w> l(e eVar);

    Collection<f> m(e eVar);

    Collection<d> o(e eVar);
}
