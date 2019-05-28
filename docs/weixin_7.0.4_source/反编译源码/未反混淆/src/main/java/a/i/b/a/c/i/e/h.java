package a.i.b.a.c.i.e;

import a.a.x;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;

public interface h extends j {
    public static final a BGd = a.BGf;

    public static final class a {
        private static final a.f.a.b<f, Boolean> BGe = a.BGg;
        static final /* synthetic */ a BGf = new a();

        static final class a extends k implements a.f.a.b<f, Boolean> {
            public static final a BGg = new a();

            static {
                AppMethodBeat.i(122196);
                AppMethodBeat.o(122196);
            }

            a() {
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122195);
                j.p((f) obj, "it");
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(122195);
                return bool;
            }
        }

        static {
            AppMethodBeat.i(122197);
            AppMethodBeat.o(122197);
        }

        private a() {
        }

        public static a.f.a.b<f, Boolean> ejN() {
            return BGe;
        }
    }

    public static final class b extends i {
        public static final b BGh = new b();

        static {
            AppMethodBeat.i(122198);
            AppMethodBeat.o(122198);
        }

        private b() {
        }

        public final Set<f> eau() {
            return x.AUR;
        }

        public final Set<f> eav() {
            return x.AUR;
        }
    }

    Collection<ah> a(f fVar, a.i.b.a.c.c.a.a aVar);

    Collection<al> b(f fVar, a.i.b.a.c.c.a.a aVar);

    Set<f> eau();

    Set<f> eav();
}
