package a.i.b.a.c.j.a.a;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.c.aa;
import a.i.b.a.c.b.c.z;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.r;
import a.i.b.a.c.b.w;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.u;
import a.i.b.a.c.f.f;
import a.i.b.a.c.g.q;
import a.i.b.a.c.j.a.a.f.a;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i extends z implements b {
    public final u AWo;
    public final c AWq;
    public final h AWr;
    private a BHO = a.COMPATIBLE;
    private final a.i.b.a.c.e.a.i BHd;
    public final e BHe;

    public final c ejV() {
        return this.AWq;
    }

    public final h ejW() {
        return this.AWr;
    }

    public final e ejX() {
        return this.BHe;
    }

    public i(l lVar, ah ahVar, g gVar, w wVar, az azVar, boolean z, f fVar, b.a aVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, u uVar, c cVar, h hVar, a.i.b.a.c.e.a.i iVar, e eVar) {
        j.p(lVar, "containingDeclaration");
        j.p(gVar, "annotations");
        j.p(wVar, "modality");
        j.p(azVar, "visibility");
        j.p(fVar, "name");
        j.p(aVar, "kind");
        j.p(uVar, "proto");
        j.p(cVar, "nameResolver");
        j.p(hVar, "typeTable");
        j.p(iVar, "versionRequirementTable");
        super(lVar, ahVar, gVar, wVar, azVar, z, fVar, aVar, am.BeR, z2, z3, z6, false, z4, z5);
        AppMethodBeat.i(122415);
        this.AWo = uVar;
        this.AWq = cVar;
        this.AWr = hVar;
        this.BHd = iVar;
        this.BHe = eVar;
        AppMethodBeat.o(122415);
    }

    public final void a(aa aaVar, aj ajVar, r rVar, r rVar2, a aVar) {
        AppMethodBeat.i(122412);
        j.p(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.a(aaVar, ajVar, rVar, rVar2);
        y yVar = y.AUy;
        this.BHO = aVar;
        AppMethodBeat.o(122412);
    }

    public final z a(l lVar, w wVar, az azVar, ah ahVar, b.a aVar, f fVar) {
        AppMethodBeat.i(122413);
        j.p(lVar, "newOwner");
        j.p(wVar, "newModality");
        j.p(azVar, "newVisibility");
        j.p(aVar, "kind");
        j.p(fVar, "newName");
        z iVar = new i(lVar, ahVar, dYn(), wVar, azVar, this.BjC, fVar, aVar, this.BiY, eab(), dYm(), this.Bja, this.BhV, this.AWo, this.AWq, this.AWr, this.BHd, this.BHe);
        AppMethodBeat.o(122413);
        return iVar;
    }

    public final boolean dYm() {
        AppMethodBeat.i(122414);
        Boolean Ug = a.i.b.a.c.e.a.b.BwS.Ug(this.AWo.BsW);
        j.o(Ug, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
        boolean booleanValue = Ug.booleanValue();
        AppMethodBeat.o(122414);
        return booleanValue;
    }

    public final /* bridge */ /* synthetic */ q ejU() {
        return this.AWo;
    }
}
