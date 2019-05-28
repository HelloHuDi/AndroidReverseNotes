package a.i.b.a.c.j.a.a;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.c.ad;
import a.i.b.a.c.b.c.p;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.i;
import a.i.b.a.c.e.a.o;
import a.i.b.a.c.f.f;
import a.i.b.a.c.g.q;
import a.i.b.a.c.j.a.a.f.a;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class j extends ad implements b {
    private final c AWq;
    private final h AWr;
    private a BHO;
    private final i BHd;
    private final e BHe;
    private final o BIx;

    public final c ejV() {
        return this.AWq;
    }

    public final h ejW() {
        return this.AWr;
    }

    public final e ejX() {
        return this.BHe;
    }

    public /* synthetic */ j(l lVar, g gVar, f fVar, b.a aVar, o oVar, c cVar, h hVar, i iVar, e eVar) {
        this(lVar, null, gVar, fVar, aVar, oVar, cVar, hVar, iVar, eVar, null);
    }

    private j(l lVar, al alVar, g gVar, f fVar, b.a aVar, o oVar, c cVar, h hVar, i iVar, e eVar, am amVar) {
        am amVar2;
        a.f.b.j.p(lVar, "containingDeclaration");
        a.f.b.j.p(gVar, "annotations");
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, "kind");
        a.f.b.j.p(oVar, "proto");
        a.f.b.j.p(cVar, "nameResolver");
        a.f.b.j.p(hVar, "typeTable");
        a.f.b.j.p(iVar, "versionRequirementTable");
        if (amVar == null) {
            amVar2 = am.BeR;
        } else {
            amVar2 = amVar;
        }
        super(lVar, alVar, gVar, fVar, aVar, amVar2);
        AppMethodBeat.i(122418);
        this.BIx = oVar;
        this.AWq = cVar;
        this.AWr = hVar;
        this.BHd = iVar;
        this.BHe = eVar;
        this.BHO = a.COMPATIBLE;
        AppMethodBeat.o(122418);
    }

    public final ad a(ak akVar, ak akVar2, List<? extends ar> list, List<? extends au> list2, w wVar, a.i.b.a.c.b.w wVar2, az azVar, Map<? extends a.i.b.a.c.b.a.a<?>, ?> map, a aVar) {
        AppMethodBeat.i(122416);
        a.f.b.j.p(list, "typeParameters");
        a.f.b.j.p(list2, "unsubstitutedValueParameters");
        a.f.b.j.p(azVar, "visibility");
        a.f.b.j.p(map, "userDataMap");
        a.f.b.j.p(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        ad a = super.a(akVar, akVar2, list, list2, wVar, wVar2, azVar, map);
        this.BHO = aVar;
        a.f.b.j.o(a, "super.initialize(\n      …easeEnvironment\n        }");
        AppMethodBeat.o(122416);
        return a;
    }

    public final p a(l lVar, t tVar, b.a aVar, f fVar, g gVar, am amVar) {
        f fVar2;
        AppMethodBeat.i(122417);
        a.f.b.j.p(lVar, "newOwner");
        a.f.b.j.p(aVar, "kind");
        a.f.b.j.p(gVar, "annotations");
        a.f.b.j.p(amVar, "source");
        al alVar = (al) tVar;
        if (fVar == null) {
            fVar2 = this.BgZ;
            a.f.b.j.o(fVar2, "name");
        } else {
            fVar2 = fVar;
        }
        j jVar = new j(lVar, alVar, gVar, fVar2, aVar, this.BIx, this.AWq, this.AWr, this.BHd, this.BHe, amVar);
        jVar.BHO = this.BHO;
        p pVar = jVar;
        AppMethodBeat.o(122417);
        return pVar;
    }

    public final /* bridge */ /* synthetic */ q ejU() {
        return this.BIx;
    }
}
