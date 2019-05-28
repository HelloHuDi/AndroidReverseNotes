package a.i.b.a.c.j.a.a;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.as;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.c.af;
import a.i.b.a.c.b.c.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.m;
import a.i.b.a.c.e.a.ab;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.i;
import a.i.b.a.c.f.f;
import a.i.b.a.c.g.q;
import a.i.b.a.c.i.e.h.b;
import a.i.b.a.c.j.a.a.f.a;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.at;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class k extends d implements f {
    private final c AWq;
    private final h AWr;
    private a BHO = a.COMPATIBLE;
    private final i BHd;
    private final e BHe;
    private ad BIA;
    private ad BIB;
    private final ab BIC;
    private Collection<? extends af> BIy;
    private ad BIz;
    private final a.i.b.a.c.k.i Baf;
    private List<? extends ar> BiI;

    public final /* synthetic */ m f(au auVar) {
        aq aqVar;
        AppMethodBeat.i(122424);
        j.p(auVar, "substitutor");
        if (auVar.Bik.isEmpty()) {
            aqVar = this;
        } else {
            a.i.b.a.c.k.i iVar = this.Baf;
            l dXW = dXW();
            j.o(dXW, "containingDeclaration");
            g dYn = dYn();
            j.o(dYn, "annotations");
            f fVar = this.BgZ;
            j.o(fVar, "name");
            k kVar = new k(iVar, dXW, dYn, fVar, this.Bhh, this.BIC, this.AWq, this.AWr, this.BHd, this.BHe);
            List dYq = dYq();
            w b = auVar.b((w) dZP(), ba.INVARIANT);
            j.o(b, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
            ad av = at.av(b);
            b = auVar.b((w) dZQ(), ba.INVARIANT);
            j.o(b, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
            kVar.a(dYq, av, at.av(b), this.BHO);
            aqVar = kVar;
        }
        m mVar = aqVar;
        AppMethodBeat.o(122424);
        return mVar;
    }

    public final a.i.b.a.c.k.i eak() {
        return this.Baf;
    }

    public final c ejV() {
        return this.AWq;
    }

    public final h ejW() {
        return this.AWr;
    }

    public final e ejX() {
        return this.BHe;
    }

    public k(a.i.b.a.c.k.i iVar, l lVar, g gVar, f fVar, az azVar, ab abVar, c cVar, h hVar, i iVar2, e eVar) {
        j.p(iVar, "storageManager");
        j.p(lVar, "containingDeclaration");
        j.p(gVar, "annotations");
        j.p(fVar, "name");
        j.p(azVar, "visibility");
        j.p(abVar, "proto");
        j.p(cVar, "nameResolver");
        j.p(hVar, "typeTable");
        j.p(iVar2, "versionRequirementTable");
        am amVar = am.BeR;
        j.o(amVar, "SourceElement.NO_SOURCE");
        super(lVar, gVar, fVar, amVar, azVar);
        AppMethodBeat.i(122426);
        this.Baf = iVar;
        this.BIC = abVar;
        this.AWq = cVar;
        this.AWr = hVar;
        this.BHd = iVar2;
        this.BHe = eVar;
        AppMethodBeat.o(122426);
    }

    public final ad dZP() {
        AppMethodBeat.i(122419);
        ad adVar = this.BIz;
        if (adVar == null) {
            j.avw("underlyingType");
        }
        AppMethodBeat.o(122419);
        return adVar;
    }

    public final ad dZQ() {
        AppMethodBeat.i(122420);
        ad adVar = this.BIA;
        if (adVar == null) {
            j.avw("expandedType");
        }
        AppMethodBeat.o(122420);
        return adVar;
    }

    /* JADX WARNING: Missing block: B:3:0x003d, code skipped:
            if (r1 == null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(List<? extends ar> list, ad adVar, ad adVar2, a aVar) {
        a.i.b.a.c.i.e.h dXZ;
        AppMethodBeat.i(122421);
        j.p(list, "declaredTypeParameters");
        j.p(adVar, "underlyingType");
        j.p(adVar2, "expandedType");
        j.p(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        j.p(list, "declaredTypeParameters");
        this.Bhf = list;
        this.BIz = adVar;
        this.BIA = adVar2;
        this.BiI = as.a(this);
        a.i.b.a.c.b.h hVar = this;
        e dZR = dZR();
        if (dZR != null) {
            dXZ = dZR.dXZ();
        }
        dXZ = b.BGh;
        ad a = av.a(hVar, dXZ);
        j.o(a, "TypeUtils.makeUnsubstitu…ope ?: MemberScope.Empty)");
        this.BIB = a;
        this.BIy = eal();
        this.BHO = aVar;
        AppMethodBeat.o(122421);
    }

    public final e dZR() {
        AppMethodBeat.i(122422);
        if (y.an(dZQ())) {
            AppMethodBeat.o(122422);
            return null;
        }
        a.i.b.a.c.b.h dYs = dZQ().ejw().dYs();
        if (!(dYs instanceof e)) {
            dYs = null;
        }
        e eVar = (e) dYs;
        AppMethodBeat.o(122422);
        return eVar;
    }

    public final ad dZf() {
        AppMethodBeat.i(122423);
        ad adVar = this.BIB;
        if (adVar == null) {
            j.avw("defaultTypeImpl");
        }
        AppMethodBeat.o(122423);
        return adVar;
    }

    public final List<ar> eao() {
        AppMethodBeat.i(122425);
        List list = this.BiI;
        if (list == null) {
            j.avw("typeConstructorParameters");
        }
        AppMethodBeat.o(122425);
        return list;
    }

    public final /* bridge */ /* synthetic */ q ejU() {
        return this.BIC;
    }
}
