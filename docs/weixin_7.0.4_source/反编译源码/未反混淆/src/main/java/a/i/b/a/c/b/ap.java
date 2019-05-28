package a.i.b.a.c.b;

import a.f.a.b;
import a.f.b.j;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.w;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public interface ap {

    public static final class a implements ap {
        public static final a BeT = new a();

        static {
            AppMethodBeat.i(119294);
            AppMethodBeat.o(119294);
        }

        private a() {
        }

        public final Collection<w> a(an anVar, Collection<? extends w> collection, b<? super an, ? extends Iterable<? extends w>> bVar, b<? super w, y> bVar2) {
            AppMethodBeat.i(119293);
            j.p(anVar, "currentTypeConstructor");
            j.p(collection, "superTypes");
            j.p(bVar, "neighbors");
            j.p(bVar2, "reportLoop");
            AppMethodBeat.o(119293);
            return collection;
        }
    }

    Collection<w> a(an anVar, Collection<? extends w> collection, b<? super an, ? extends Iterable<? extends w>> bVar, b<? super w, y> bVar2);
}
