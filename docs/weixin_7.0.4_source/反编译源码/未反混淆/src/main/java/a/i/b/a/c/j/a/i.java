package a.i.b.a.c.j.a;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.aa;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ac;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.b.b;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.y;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.g.g;
import a.i.b.a.c.i.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public final g BGO = new g(this);
    public final j BGP;
    final f BGQ;
    public final b<c, f<?>> BGR;
    final ac BGS;
    private final p BGT;
    final n BGU;
    public final Iterable<b> BGV;
    final h BGW;
    public final a BGX;
    public final a.i.b.a.c.b.b.c BGY;
    public final g BGZ;
    public final a.i.b.a.c.k.i Baf;
    public final aa Bcm;
    public final y Bdv;
    public final m BmV;
    public final a.i.b.a.c.c.a.b Bnc;

    public i(a.i.b.a.c.k.i iVar, y yVar, j jVar, f fVar, b<? extends c, ? extends f<?>> bVar, ac acVar, p pVar, m mVar, a.i.b.a.c.c.a.b bVar2, n nVar, Iterable<? extends b> iterable, aa aaVar, h hVar, a aVar, a.i.b.a.c.b.b.c cVar, g gVar) {
        j.p(iVar, "storageManager");
        j.p(yVar, "moduleDescriptor");
        j.p(jVar, "configuration");
        j.p(fVar, "classDataFinder");
        j.p(bVar, "annotationAndConstantLoader");
        j.p(acVar, "packageFragmentProvider");
        j.p(pVar, "localClassifierTypeSettings");
        j.p(mVar, "errorReporter");
        j.p(bVar2, "lookupTracker");
        j.p(nVar, "flexibleTypeDeserializer");
        j.p(iterable, "fictitiousClassDescriptorFactories");
        j.p(aaVar, "notFoundClasses");
        j.p(hVar, "contractDeserializer");
        j.p(aVar, "additionalClassPartsProvider");
        j.p(cVar, "platformDependentDeclarationFilter");
        j.p(gVar, "extensionRegistryLite");
        AppMethodBeat.i(122265);
        this.Baf = iVar;
        this.Bdv = yVar;
        this.BGP = jVar;
        this.BGQ = fVar;
        this.BGR = bVar;
        this.BGS = acVar;
        this.BGT = pVar;
        this.BmV = mVar;
        this.Bnc = bVar2;
        this.BGU = nVar;
        this.BGV = iterable;
        this.Bcm = aaVar;
        this.BGW = hVar;
        this.BGX = aVar;
        this.BGY = cVar;
        this.BGZ = gVar;
        AppMethodBeat.o(122265);
    }

    public final e i(a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(122263);
        j.p(aVar, "classId");
        e a = g.a(this.BGO, aVar);
        AppMethodBeat.o(122263);
        return a;
    }

    public final k a(ab abVar, a.i.b.a.c.e.a.c cVar, h hVar, a.i.b.a.c.e.a.i iVar, a.i.b.a.c.e.a.a aVar, a.i.b.a.c.j.a.a.e eVar) {
        AppMethodBeat.i(122264);
        j.p(abVar, "descriptor");
        j.p(cVar, "nameResolver");
        j.p(hVar, "typeTable");
        j.p(iVar, "versionRequirementTable");
        j.p(aVar, "metadataVersion");
        k kVar = new k(this, cVar, abVar, hVar, iVar, aVar, eVar, null, v.AUP);
        AppMethodBeat.o(122264);
        return kVar;
    }
}
