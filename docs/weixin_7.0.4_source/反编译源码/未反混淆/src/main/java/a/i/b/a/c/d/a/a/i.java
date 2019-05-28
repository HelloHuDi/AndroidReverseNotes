package a.i.b.a.c.d.a.a;

import a.a.af;
import a.a.ag;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.a.g;
import a.i.b.a.c.d.a.e.b;
import a.i.b.a.c.d.a.e.e;
import a.i.b.a.c.d.a.e.m;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.h;
import a.i.k;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i extends b {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final f Bmk;

    static final class a extends a.f.b.k implements a.f.a.a<Map<a.i.b.a.c.f.f, ? extends a.i.b.a.c.i.b.f<?>>> {
        final /* synthetic */ i Bmp;

        a(i iVar) {
            this.Bmp = iVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object fW;
            AppMethodBeat.i(119775);
            b bVar = this.Bmp.BlS;
            d dVar;
            if (bVar instanceof e) {
                dVar = d.Bmi;
                fW = d.fW(((e) this.Bmp.BlS).ebD());
            } else if (bVar instanceof m) {
                dVar = d.Bmi;
                fW = d.fW(a.a.k.listOf(this.Bmp.BlS));
            } else {
                fW = null;
            }
            if (fW != null) {
                c cVar = c.Bmf;
                fW = af.a(u.I(c.ebj(), fW));
            } else {
                fW = null;
            }
            if (fW == null) {
                fW = ag.emptyMap();
            }
            AppMethodBeat.o(119775);
            return fW;
        }
    }

    static {
        AppMethodBeat.i(119776);
        AppMethodBeat.o(119776);
    }

    public final Map<a.i.b.a.c.f.f, a.i.b.a.c.i.b.f<?>> eah() {
        AppMethodBeat.i(119777);
        Map map = (Map) h.a(this.Bmk, eQB[0]);
        AppMethodBeat.o(119777);
        return map;
    }

    public i(a.i.b.a.c.d.a.e.a aVar, a.i.b.a.c.d.a.c.h hVar) {
        j.p(aVar, "annotation");
        j.p(hVar, "c");
        a.i.b.a.c.f.b bVar = g.Bag.BaQ;
        j.o(bVar, "KotlinBuiltIns.FQ_NAMES.target");
        super(hVar, aVar, bVar);
        AppMethodBeat.i(119778);
        this.Bmk = hVar.Bnv.Baf.i(new a(this));
        AppMethodBeat.o(119778);
    }
}
