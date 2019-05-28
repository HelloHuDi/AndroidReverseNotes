package a.i.b.a.c.j.a.a;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.c.f;
import a.i.b.a.c.b.c.p;
import a.i.b.a.c.b.k;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.e.a.e;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.i;
import a.i.b.a.c.g.q;
import a.i.b.a.c.j.a.a.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends f implements b {
    private final a.i.b.a.c.e.a.c AWq;
    private final h AWr;
    private a BHO;
    private final e BHP;
    private final i BHd;
    private final e BHe;

    public final /* bridge */ /* synthetic */ p a(l lVar, t tVar, b.a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(122342);
        p a = a(lVar, tVar, aVar, gVar, amVar);
        AppMethodBeat.o(122342);
        return a;
    }

    public final /* synthetic */ f b(l lVar, t tVar, b.a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(122343);
        f a = a(lVar, tVar, aVar, gVar, amVar);
        AppMethodBeat.o(122343);
        return a;
    }

    public final a.i.b.a.c.e.a.c ejV() {
        return this.AWq;
    }

    public final h ejW() {
        return this.AWr;
    }

    public final e ejX() {
        return this.BHe;
    }

    public /* synthetic */ c(a.i.b.a.c.b.e eVar, g gVar, boolean z, b.a aVar, e eVar2, a.i.b.a.c.e.a.c cVar, h hVar, i iVar, e eVar3) {
        this(eVar, null, gVar, z, aVar, eVar2, cVar, hVar, iVar, eVar3, null);
    }

    private c(a.i.b.a.c.b.e eVar, k kVar, g gVar, boolean z, b.a aVar, e eVar2, a.i.b.a.c.e.a.c cVar, h hVar, i iVar, e eVar3, am amVar) {
        am amVar2;
        j.p(eVar, "containingDeclaration");
        j.p(gVar, "annotations");
        j.p(aVar, "kind");
        j.p(eVar2, "proto");
        j.p(cVar, "nameResolver");
        j.p(hVar, "typeTable");
        j.p(iVar, "versionRequirementTable");
        if (amVar == null) {
            amVar2 = am.BeR;
        } else {
            amVar2 = amVar;
        }
        super(eVar, kVar, gVar, z, aVar, amVar2);
        AppMethodBeat.i(122344);
        this.BHP = eVar2;
        this.AWq = cVar;
        this.AWr = hVar;
        this.BHd = iVar;
        this.BHe = eVar3;
        this.BHO = a.COMPATIBLE;
        AppMethodBeat.o(122344);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(122340);
        j.p(aVar, "<set-?>");
        this.BHO = aVar;
        AppMethodBeat.o(122340);
    }

    private c a(l lVar, t tVar, b.a aVar, g gVar, am amVar) {
        AppMethodBeat.i(122341);
        j.p(lVar, "newOwner");
        j.p(aVar, "kind");
        j.p(gVar, "annotations");
        j.p(amVar, "source");
        c cVar = new c((a.i.b.a.c.b.e) lVar, (k) tVar, gVar, this.hEK, aVar, this.BHP, this.AWq, this.AWr, this.BHd, this.BHe, amVar);
        cVar.a(this.BHO);
        AppMethodBeat.o(122341);
        return cVar;
    }

    public final boolean dYm() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYx() {
        return false;
    }

    public final boolean dZv() {
        return false;
    }

    public final /* bridge */ /* synthetic */ q ejU() {
        return this.BHP;
    }
}
