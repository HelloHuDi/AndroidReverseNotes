package a.i.b.a.c.j.a;

import a.f.b.j;
import a.i.b.a.c.b.l;
import a.i.b.a.c.e.a.a;
import a.i.b.a.c.e.a.ae;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.i;
import a.i.b.a.c.j.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class k {
    public final c AWq;
    public final h AWr;
    private final a BGE;
    public final w BHb;
    public final q BHc = new q(this);
    final i BHd;
    final e BHe;
    public final l Bht;
    public final i Brl;

    public k(i iVar, c cVar, l lVar, h hVar, i iVar2, a aVar, e eVar, w wVar, List<ae> list) {
        j.p(iVar, "components");
        j.p(cVar, "nameResolver");
        j.p(lVar, "containingDeclaration");
        j.p(hVar, "typeTable");
        j.p(iVar2, "versionRequirementTable");
        j.p(aVar, "metadataVersion");
        j.p(list, "typeParameters");
        AppMethodBeat.i(122269);
        this.Brl = iVar;
        this.AWq = cVar;
        this.Bht = lVar;
        this.AWr = hVar;
        this.BHd = iVar2;
        this.BGE = aVar;
        this.BHe = eVar;
        this.BHb = new w(this, wVar, list, "Deserializer for " + this.Bht.dZg(), (byte) 0);
        AppMethodBeat.o(122269);
    }

    public static /* synthetic */ k a(k kVar, l lVar, List list) {
        AppMethodBeat.i(122268);
        k a = kVar.a(lVar, list, kVar.AWq, kVar.AWr, kVar.BHd, kVar.BGE);
        AppMethodBeat.o(122268);
        return a;
    }

    public final k a(l lVar, List<ae> list, c cVar, h hVar, i iVar, a aVar) {
        AppMethodBeat.i(122267);
        j.p(lVar, "descriptor");
        j.p(list, "typeParameterProtos");
        j.p(cVar, "nameResolver");
        j.p(hVar, "typeTable");
        j.p(iVar, "versionRequirementTable");
        j.p(aVar, "metadataVersion");
        i iVar2 = this.Brl;
        j.p(aVar, "version");
        k kVar = new k(iVar2, cVar, lVar, hVar, a.i.b.a.c.e.a.j.a(aVar) ? iVar : this.BHd, aVar, this.BHe, this.BHb, list);
        AppMethodBeat.o(122267);
        return kVar;
    }
}
