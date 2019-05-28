package a.i.b.a.c.d.a.a;

import a.a.ag;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.d.a.c.a.e;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.e.a;
import a.i.b.a.c.d.a.e.d;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.u;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;

public final class c {
    private static final b BlV = new b(Target.class.getCanonicalName());
    private static final b BlW = new b(Retention.class.getCanonicalName());
    private static final b BlX = new b(Deprecated.class.getCanonicalName());
    private static final b BlY = new b(Documented.class.getCanonicalName());
    private static final b BlZ = new b("java.lang.annotation.Repeatable");
    private static final f Bma;
    private static final f Bmb;
    private static final f Bmc;
    private static final Map<b, b> Bmd = ag.a(u.I(g.Bag.BaQ, BlV), u.I(g.Bag.BaT, BlW), u.I(g.Bag.BaU, BlZ), u.I(g.Bag.BaV, BlY));
    private static final Map<b, b> Bme = ag.a(u.I(BlV, g.Bag.BaQ), u.I(BlW, g.Bag.BaT), u.I(BlX, g.Bag.BaK), u.I(BlZ, g.Bag.BaU), u.I(BlY, g.Bag.BaV));
    public static final c Bmf = new c();

    static {
        AppMethodBeat.i(119758);
        f avX = f.avX(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        j.o(avX, "Name.identifier(\"message\")");
        Bma = avX;
        avX = f.avX("allowedTargets");
        j.o(avX, "Name.identifier(\"allowedTargets\")");
        Bmb = avX;
        avX = f.avX("value");
        j.o(avX, "Name.identifier(\"value\")");
        Bmc = avX;
        AppMethodBeat.o(119758);
    }

    private c() {
    }

    public static f ebi() {
        return Bma;
    }

    public static f ebj() {
        return Bmb;
    }

    public static f ebk() {
        return Bmc;
    }

    public static a.i.b.a.c.b.a.c a(a aVar, h hVar) {
        AppMethodBeat.i(119756);
        j.p(aVar, "annotation");
        j.p(hVar, "c");
        a.i.b.a.c.f.a dWY = aVar.dWY();
        a.i.b.a.c.b.a.c iVar;
        b bVar;
        if (j.j(dWY, a.i.b.a.c.f.a.n(BlV))) {
            iVar = new i(aVar, hVar);
            AppMethodBeat.o(119756);
            return iVar;
        } else if (j.j(dWY, a.i.b.a.c.f.a.n(BlW))) {
            iVar = new h(aVar, hVar);
            AppMethodBeat.o(119756);
            return iVar;
        } else if (j.j(dWY, a.i.b.a.c.f.a.n(BlZ))) {
            bVar = g.Bag.BaU;
            j.o(bVar, "KotlinBuiltIns.FQ_NAMES.repeatable");
            iVar = new b(hVar, aVar, bVar);
            AppMethodBeat.o(119756);
            return iVar;
        } else if (j.j(dWY, a.i.b.a.c.f.a.n(BlY))) {
            bVar = g.Bag.BaV;
            j.o(bVar, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
            iVar = new b(hVar, aVar, bVar);
            AppMethodBeat.o(119756);
            return iVar;
        } else if (j.j(dWY, a.i.b.a.c.f.a.n(BlX))) {
            AppMethodBeat.o(119756);
            return null;
        } else {
            iVar = new e(hVar, aVar);
            AppMethodBeat.o(119756);
            return iVar;
        }
    }

    public static a.i.b.a.c.b.a.c a(b bVar, d dVar, h hVar) {
        a.i.b.a.c.b.a.c eVar;
        AppMethodBeat.i(119757);
        j.p(bVar, "kotlinName");
        j.p(dVar, "annotationOwner");
        j.p(hVar, "c");
        if (j.j(bVar, g.Bag.BaK)) {
            a m = dVar.m(BlX);
            if (m != null) {
                eVar = new e(m, hVar);
                AppMethodBeat.o(119757);
                return eVar;
            }
        }
        b bVar2 = (b) Bmd.get(bVar);
        if (bVar2 != null) {
            a m2 = dVar.m(bVar2);
            if (m2 != null) {
                eVar = a(m2, hVar);
                AppMethodBeat.o(119757);
                return eVar;
            }
            AppMethodBeat.o(119757);
            return null;
        }
        AppMethodBeat.o(119757);
        return null;
    }
}
