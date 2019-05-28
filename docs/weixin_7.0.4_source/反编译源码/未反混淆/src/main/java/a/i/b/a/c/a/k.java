package a.i.b.a.c.a;

import a.a.t;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.c.ah;
import a.i.b.a.c.b.c.m;
import a.i.b.a.c.b.c.w;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.y;
import a.i.b.a.c.f.b;
import a.i.b.a.c.i.d;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class k {
    private static final w Bct;
    private static final w Bcu;

    public static final w dXU() {
        return Bct;
    }

    static {
        AppMethodBeat.i(119114);
        y ekj = p.ekj();
        j.o(ekj, "ErrorUtils.getErrorModule()");
        b bVar = d.BDT;
        j.o(bVar, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
        w wVar = new w(new m(ekj, bVar), f.INTERFACE, d.BDV.ByQ.ehK(), am.BeR, a.i.b.a.c.k.b.BIH);
        wVar.b(a.i.b.a.c.b.w.ABSTRACT);
        wVar.BhQ = ay.Bfa;
        l lVar = wVar;
        a aVar = g.BfJ;
        wVar.fV(a.a.k.listOf(ah.a(lVar, a.eai(), ba.IN_VARIANCE, a.i.b.a.c.f.f.avX("T"), 0)));
        wVar.eaF();
        Bct = wVar;
        ekj = p.ekj();
        j.o(ekj, "ErrorUtils.getErrorModule()");
        bVar = d.BDS;
        j.o(bVar, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        wVar = new w(new m(ekj, bVar), f.INTERFACE, d.BDW.ByQ.ehK(), am.BeR, a.i.b.a.c.k.b.BIH);
        wVar.b(a.i.b.a.c.b.w.ABSTRACT);
        wVar.BhQ = ay.Bfa;
        lVar = wVar;
        aVar = g.BfJ;
        wVar.fV(a.a.k.listOf(ah.a(lVar, a.eai(), ba.IN_VARIANCE, a.i.b.a.c.f.f.avX("T"), 0)));
        wVar.eaF();
        Bcu = wVar;
        AppMethodBeat.o(119114);
    }

    public static final w dXV() {
        return Bcu;
    }

    public static final ad F(a.i.b.a.c.l.w wVar) {
        AppMethodBeat.i(119112);
        j.p(wVar, "suspendFunType");
        boolean e = f.e(wVar);
        if (!aa.AUz || e) {
            g aL = a.i.b.a.c.l.c.a.aL(wVar);
            g dYn = wVar.dYn();
            a.i.b.a.c.l.w h = f.h(wVar);
            Iterable<ap> j = f.j(wVar);
            Collection arrayList = new ArrayList(a.a.m.d(j));
            for (ap dZS : j) {
                arrayList.add(dZS.dZS());
            }
            arrayList = (List) arrayList;
            a aVar = g.BfJ;
            g eai = a.eai();
            an dXY = Bct.dXY();
            j.o(dXY, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
            List a = t.a(arrayList, (Object) x.c(eai, dXY, a.a.k.listOf(a.i.b.a.c.l.c.a.aM(f.i(wVar))), false));
            ad dXN = a.i.b.a.c.l.c.a.aL(wVar).dXN();
            j.o(dXN, "suspendFunType.builtIns.nullableAnyType");
            dXN = f.a(aL, dYn, h, a, dXN).rL(wVar.eci());
            AppMethodBeat.o(119112);
            return dXN;
        }
        Throwable assertionError = new AssertionError("This type should be suspend function type: ".concat(String.valueOf(wVar)));
        AppMethodBeat.o(119112);
        throw assertionError;
    }

    public static final boolean a(b bVar, boolean z) {
        AppMethodBeat.i(119113);
        boolean j;
        if (z) {
            j = j.j(bVar, d.BDW);
            AppMethodBeat.o(119113);
            return j;
        }
        j = j.j(bVar, d.BDV);
        AppMethodBeat.o(119113);
        return j;
    }
}
