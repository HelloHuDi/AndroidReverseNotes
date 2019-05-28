package a.i.b.a.c.j.a;

import a.a.ak;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class g {
    private static final Set<a.i.b.a.c.f.a> BGH = ak.setOf(a.i.b.a.c.f.a.n(a.i.b.a.c.a.g.Bag.Bao.ehI()));
    public static final b BGI = new b();
    private final a.f.a.b<a, e> BGG = this.Brl.Baf.g(new c(this));
    private final i Brl;

    static final class c extends k implements a.f.a.b<a, e> {
        final /* synthetic */ g BGK;

        c(g gVar) {
            this.BGK = gVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122255);
            a aVar = (a) obj;
            j.p(aVar, "key");
            e a = g.a(this.BGK, aVar);
            AppMethodBeat.o(122255);
            return a;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class a {
        final e BGJ;
        final a.i.b.a.c.f.a BcB;

        public a(a.i.b.a.c.f.a aVar, e eVar) {
            j.p(aVar, "classId");
            AppMethodBeat.i(122254);
            this.BcB = aVar;
            this.BGJ = eVar;
            AppMethodBeat.o(122254);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(122252);
            if ((obj instanceof a) && j.j(this.BcB, ((a) obj).BcB)) {
                AppMethodBeat.o(122252);
                return true;
            }
            AppMethodBeat.o(122252);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(122253);
            int hashCode = this.BcB.hashCode();
            AppMethodBeat.o(122253);
            return hashCode;
        }
    }

    public g(i iVar) {
        j.p(iVar, "components");
        AppMethodBeat.i(122258);
        this.Brl = iVar;
        AppMethodBeat.o(122258);
    }

    public final e a(a.i.b.a.c.f.a aVar, e eVar) {
        AppMethodBeat.i(122256);
        j.p(aVar, "classId");
        e eVar2 = (e) this.BGG.am(new a(aVar, eVar));
        AppMethodBeat.o(122256);
        return eVar2;
    }

    static {
        AppMethodBeat.i(122259);
        AppMethodBeat.o(122259);
    }
}
