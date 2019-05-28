package a.i.b.a.c.d.a.a;

import a.a.ag;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.e;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.k.f;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class b implements c {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    final a.i.b.a.c.f.b BfP;
    private final am Bfq;
    private final f BlR;
    final a.i.b.a.c.d.a.e.b BlS;

    static final class a extends a.f.b.k implements a.f.a.a<ad> {
        final /* synthetic */ b BlT;
        final /* synthetic */ h BlU;

        a(b bVar, h hVar) {
            this.BlT = bVar;
            this.BlU = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119751);
            e c = this.BlU.Bnv.BcH.dZD().c(this.BlT.BfP);
            j.o(c, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
            ad dZf = c.dZf();
            AppMethodBeat.o(119751);
            return dZf;
        }
    }

    static {
        AppMethodBeat.i(119752);
        AppMethodBeat.o(119752);
    }

    public b(h hVar, a.i.b.a.c.d.a.e.a aVar, a.i.b.a.c.f.b bVar) {
        am a;
        b bVar2;
        j.p(hVar, "c");
        j.p(bVar, "fqName");
        AppMethodBeat.i(119755);
        this.BfP = bVar;
        if (aVar != null) {
            a = hVar.Bnv.BmZ.a(aVar);
            bVar2 = this;
        } else {
            a = am.BeR;
            j.o(a, "SourceElement.NO_SOURCE");
            bVar2 = this;
        }
        bVar2.Bfq = a;
        this.BlR = hVar.Bnv.Baf.i(new a(this, hVar));
        this.BlS = aVar != null ? (a.i.b.a.c.d.a.e.b) a.a.t.f(aVar.ebz()) : null;
        AppMethodBeat.o(119755);
    }

    public final a.i.b.a.c.f.b dZF() {
        return this.BfP;
    }

    public final am dYo() {
        return this.Bfq;
    }

    public Map<a.i.b.a.c.f.f, a.i.b.a.c.i.b.f<?>> eah() {
        AppMethodBeat.i(119754);
        Map emptyMap = ag.emptyMap();
        AppMethodBeat.o(119754);
        return emptyMap;
    }

    public final /* synthetic */ w dZS() {
        AppMethodBeat.i(119753);
        w wVar = (ad) a.i.b.a.c.k.h.a(this.BlR, eQB[0]);
        AppMethodBeat.o(119753);
        return wVar;
    }
}
