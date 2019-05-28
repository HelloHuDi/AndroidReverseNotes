package a.i.b.a.c.b.a;

import a.f;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.e;
import a.i.b.a.c.f.b;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j implements c {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(j.class), "type", "getType()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    private final f BfN = i.a(a.k.PUBLICATION, new a(this));
    private final g BfO;
    final b BfP;
    private final Map<a.i.b.a.c.f.f, a.i.b.a.c.i.b.f<?>> BfQ;

    static final class a extends a.f.b.k implements a.f.a.a<ad> {
        final /* synthetic */ j BfR;

        a(j jVar) {
            this.BfR = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119343);
            e c = this.BfR.BfO.c(this.BfR.BfP);
            a.f.b.j.o(c, "builtIns.getBuiltInClassByFqName(fqName)");
            ad dZf = c.dZf();
            AppMethodBeat.o(119343);
            return dZf;
        }
    }

    static {
        AppMethodBeat.i(119344);
        AppMethodBeat.o(119344);
    }

    public final w dZS() {
        AppMethodBeat.i(119345);
        w wVar = (w) this.BfN.getValue();
        AppMethodBeat.o(119345);
        return wVar;
    }

    public j(g gVar, b bVar, Map<a.i.b.a.c.f.f, ? extends a.i.b.a.c.i.b.f<?>> map) {
        a.f.b.j.p(gVar, "builtIns");
        a.f.b.j.p(bVar, "fqName");
        a.f.b.j.p(map, "allValueArguments");
        AppMethodBeat.i(119347);
        this.BfO = gVar;
        this.BfP = bVar;
        this.BfQ = map;
        AppMethodBeat.o(119347);
    }

    public final b dZF() {
        return this.BfP;
    }

    public final Map<a.i.b.a.c.f.f, a.i.b.a.c.i.b.f<?>> eah() {
        return this.BfQ;
    }

    public final am dYo() {
        AppMethodBeat.i(119346);
        am amVar = am.BeR;
        a.f.b.j.o(amVar, "SourceElement.NO_SOURCE");
        AppMethodBeat.o(119346);
        return amVar;
    }
}
