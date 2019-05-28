package a.i.b.a.c.d.a.c.a;

import a.a.v;
import a.a.x;
import a.f.b.j;
import a.i.b.a.c.d.a.e.n;
import a.i.b.a.c.d.a.e.q;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;

public interface b {

    public static final class a implements b {
        public static final a BnM = new a();

        static {
            AppMethodBeat.i(119861);
            AppMethodBeat.o(119861);
        }

        private a() {
        }

        public final /* synthetic */ Collection k(f fVar) {
            AppMethodBeat.i(119859);
            j.p(fVar, "name");
            Collection collection = v.AUP;
            AppMethodBeat.o(119859);
            return collection;
        }

        public final n l(f fVar) {
            AppMethodBeat.i(119860);
            j.p(fVar, "name");
            AppMethodBeat.o(119860);
            return null;
        }

        public final Set<f> ebn() {
            return x.AUR;
        }

        public final Set<f> ebo() {
            return x.AUR;
        }
    }

    Set<f> ebn();

    Set<f> ebo();

    Collection<q> k(f fVar);

    n l(f fVar);
}
