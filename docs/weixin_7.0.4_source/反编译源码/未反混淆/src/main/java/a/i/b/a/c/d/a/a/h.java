package a.i.b.a.c.d.a.a;

import a.a.af;
import a.a.ag;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.a.g;
import a.i.b.a.c.f.b;
import a.i.b.a.c.k.f;
import a.i.k;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class h extends b {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final f Bmk;

    static final class a extends a.f.b.k implements a.f.a.a<Map<a.i.b.a.c.f.f, ? extends a.i.b.a.c.i.b.f<?>>> {
        final /* synthetic */ h Bmo;

        a(h hVar) {
            this.Bmo = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object a;
            AppMethodBeat.i(119771);
            d dVar = d.Bmi;
            a.i.b.a.c.i.b.f a2 = d.a(this.Bmo.BlS);
            if (a2 != null) {
                c cVar = c.Bmf;
                a = af.a(u.I(c.ebk(), a2));
            } else {
                a = null;
            }
            if (a == null) {
                a = ag.emptyMap();
            }
            AppMethodBeat.o(119771);
            return a;
        }
    }

    static {
        AppMethodBeat.i(119772);
        AppMethodBeat.o(119772);
    }

    public final Map<a.i.b.a.c.f.f, a.i.b.a.c.i.b.f<?>> eah() {
        AppMethodBeat.i(119773);
        Map map = (Map) a.i.b.a.c.k.h.a(this.Bmk, eQB[0]);
        AppMethodBeat.o(119773);
        return map;
    }

    public h(a.i.b.a.c.d.a.e.a aVar, a.i.b.a.c.d.a.c.h hVar) {
        j.p(aVar, "annotation");
        j.p(hVar, "c");
        b bVar = g.Bag.BaT;
        j.o(bVar, "KotlinBuiltIns.FQ_NAMES.retention");
        super(hVar, aVar, bVar);
        AppMethodBeat.i(119774);
        this.Bmk = hVar.Bnv.Baf.i(new a(this));
        AppMethodBeat.o(119774);
    }
}
