package a.i.b.a.c.i.e;

import a.f.a.b;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public interface j {

    public static final class a {
        public static /* synthetic */ Collection a(j jVar, d dVar, b bVar, int i) {
            AppMethodBeat.i(122199);
            if ((i & 1) != 0) {
                dVar = d.BFL;
            }
            if ((i & 2) != 0) {
                a.i.b.a.c.i.e.h.a aVar = h.BGd;
                bVar = a.i.b.a.c.i.e.h.a.ejN();
            }
            Collection a = jVar.a(dVar, bVar);
            AppMethodBeat.o(122199);
            return a;
        }
    }

    Collection<l> a(d dVar, b<? super f, Boolean> bVar);

    Collection<t> b(f fVar, a.i.b.a.c.c.a.a aVar);

    h c(f fVar, a.i.b.a.c.c.a.a aVar);
}
