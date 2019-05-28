package a.i.b.a.c.a.b;

import a.a.ak;
import a.a.x;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.c.h;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.w;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.f;
import a.i.b.a.c.k.i;
import a.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class d implements a.i.b.a.c.b.b.b {
    public static final a BdA = new a();
    private static final a.i.b.a.c.f.b Bdx = g.AZV;
    private static final f Bdy;
    private static final a.i.b.a.c.f.a Bdz;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    private final a.i.b.a.c.k.f Bdu;
    private final y Bdv;
    private final a.f.a.b<y, l> Bdw;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class b extends a.f.b.k implements a.f.a.a<h> {
        final /* synthetic */ d BdC;
        final /* synthetic */ i BdD;

        b(d dVar, i iVar) {
            this.BdC = dVar;
            this.BdD = iVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119193);
            h hVar = new h((l) this.BdC.Bdw.am(this.BdC.Bdv), d.Bdy, w.ABSTRACT, a.i.b.a.c.b.f.INTERFACE, a.a.k.listOf(this.BdC.Bdv.dZD().dXM()), am.BeR, this.BdD);
            hVar.a(new a(this.BdD, hVar), x.AUR, null);
            AppMethodBeat.o(119193);
            return hVar;
        }
    }

    private final h dYC() {
        AppMethodBeat.i(119195);
        h hVar = (h) a.i.b.a.c.k.h.a(this.Bdu, eQB[0]);
        AppMethodBeat.o(119195);
        return hVar;
    }

    private d(i iVar, y yVar, a.f.a.b<? super y, ? extends l> bVar) {
        j.p(iVar, "storageManager");
        j.p(yVar, "moduleDescriptor");
        j.p(bVar, "computeContainingDeclaration");
        AppMethodBeat.i(119199);
        this.Bdv = yVar;
        this.Bdw = bVar;
        this.Bdu = iVar.i(new b(this, iVar));
        AppMethodBeat.o(119199);
    }

    public /* synthetic */ d(i iVar, y yVar) {
        this(iVar, yVar, AnonymousClass1.BdB);
        AppMethodBeat.i(119200);
        AppMethodBeat.o(119200);
    }

    public final boolean a(a.i.b.a.c.f.b bVar, f fVar) {
        AppMethodBeat.i(119196);
        j.p(bVar, "packageFqName");
        j.p(fVar, "name");
        if (j.j(fVar, Bdy) && j.j(bVar, Bdx)) {
            AppMethodBeat.o(119196);
            return true;
        }
        AppMethodBeat.o(119196);
        return false;
    }

    public final e e(a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(119197);
        j.p(aVar, "classId");
        if (j.j(aVar, Bdz)) {
            e dYC = dYC();
            AppMethodBeat.o(119197);
            return dYC;
        }
        AppMethodBeat.o(119197);
        return null;
    }

    public final Collection<e> d(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(119198);
        j.p(bVar, "packageFqName");
        if (j.j(bVar, Bdx)) {
            Collection of = ak.setOf(dYC());
            AppMethodBeat.o(119198);
            return of;
        }
        Collection<e> collection = x.AUR;
        AppMethodBeat.o(119198);
        return collection;
    }

    static {
        AppMethodBeat.i(119194);
        f ehK = g.Bag.Bao.ehK();
        j.o(ehK, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
        Bdy = ehK;
        a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(g.Bag.Bao.ehI());
        j.o(n, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
        Bdz = n;
        AppMethodBeat.o(119194);
    }
}
