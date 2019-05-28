package a.i.b.a.c.j.a;

import a.f.b.j;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.w;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.a.ae;
import a.i.b.a.c.e.a.ao;
import a.i.b.a.c.e.a.c.b;
import a.i.b.a.c.e.a.q;
import a.i.b.a.c.e.a.r;
import a.i.b.a.c.l.ba;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t {
    public static final t BHx = new t();

    static {
        AppMethodBeat.i(122305);
        AppMethodBeat.o(122305);
    }

    private t() {
    }

    public static a a(q qVar) {
        a aVar;
        AppMethodBeat.i(122299);
        if (qVar != null) {
            switch (u.eQZ[qVar.ordinal()]) {
                case 1:
                    aVar = a.DECLARATION;
                    AppMethodBeat.o(122299);
                    return aVar;
                case 2:
                    aVar = a.FAKE_OVERRIDE;
                    AppMethodBeat.o(122299);
                    return aVar;
                case 3:
                    aVar = a.DELEGATION;
                    AppMethodBeat.o(122299);
                    return aVar;
                case 4:
                    aVar = a.SYNTHESIZED;
                    AppMethodBeat.o(122299);
                    return aVar;
            }
        }
        aVar = a.DECLARATION;
        AppMethodBeat.o(122299);
        return aVar;
    }

    public static w a(r rVar) {
        w wVar;
        AppMethodBeat.i(122300);
        if (rVar != null) {
            switch (u.pEv[rVar.ordinal()]) {
                case 1:
                    wVar = w.FINAL;
                    AppMethodBeat.o(122300);
                    return wVar;
                case 2:
                    wVar = w.OPEN;
                    AppMethodBeat.o(122300);
                    return wVar;
                case 3:
                    wVar = w.ABSTRACT;
                    AppMethodBeat.o(122300);
                    return wVar;
                case 4:
                    wVar = w.SEALED;
                    AppMethodBeat.o(122300);
                    return wVar;
            }
        }
        wVar = w.FINAL;
        AppMethodBeat.o(122300);
        return wVar;
    }

    public static az a(ao aoVar) {
        Object obj;
        AppMethodBeat.i(122301);
        if (aoVar != null) {
            switch (u.BCf[aoVar.ordinal()]) {
                case 1:
                    obj = ay.BeZ;
                    break;
                case 2:
                    obj = ay.BeW;
                    break;
                case 3:
                    obj = ay.BeX;
                    break;
                case 4:
                    obj = ay.BeY;
                    break;
                case 5:
                    obj = ay.Bfa;
                    break;
                case 6:
                    obj = ay.Bfb;
                    break;
            }
        }
        obj = ay.BeW;
        j.o(obj, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
        AppMethodBeat.o(122301);
        return obj;
    }

    public static f a(b bVar) {
        f fVar;
        AppMethodBeat.i(122302);
        if (bVar != null) {
            switch (u.BHy[bVar.ordinal()]) {
                case 1:
                    fVar = f.CLASS;
                    AppMethodBeat.o(122302);
                    return fVar;
                case 2:
                    fVar = f.INTERFACE;
                    AppMethodBeat.o(122302);
                    return fVar;
                case 3:
                    fVar = f.ENUM_CLASS;
                    AppMethodBeat.o(122302);
                    return fVar;
                case 4:
                    fVar = f.ENUM_ENTRY;
                    AppMethodBeat.o(122302);
                    return fVar;
                case 5:
                    fVar = f.ANNOTATION_CLASS;
                    AppMethodBeat.o(122302);
                    return fVar;
                case 6:
                case 7:
                    fVar = f.OBJECT;
                    AppMethodBeat.o(122302);
                    return fVar;
            }
        }
        fVar = f.CLASS;
        AppMethodBeat.o(122302);
        return fVar;
    }

    public static ba b(ae.b bVar) {
        AppMethodBeat.i(122303);
        j.p(bVar, "variance");
        ba baVar;
        switch (u.BHA[bVar.ordinal()]) {
            case 1:
                baVar = ba.IN_VARIANCE;
                AppMethodBeat.o(122303);
                return baVar;
            case 2:
                baVar = ba.OUT_VARIANCE;
                AppMethodBeat.o(122303);
                return baVar;
            case 3:
                baVar = ba.INVARIANT;
                AppMethodBeat.o(122303);
                return baVar;
            default:
                m mVar = new m();
                AppMethodBeat.o(122303);
                throw mVar;
        }
    }

    public static ba b(aa.a.b bVar) {
        AppMethodBeat.i(122304);
        j.p(bVar, "projection");
        ba baVar;
        switch (u.BHB[bVar.ordinal()]) {
            case 1:
                baVar = ba.IN_VARIANCE;
                AppMethodBeat.o(122304);
                return baVar;
            case 2:
                baVar = ba.OUT_VARIANCE;
                AppMethodBeat.o(122304);
                return baVar;
            case 3:
                baVar = ba.INVARIANT;
                AppMethodBeat.o(122304);
                return baVar;
            case 4:
                Throwable illegalArgumentException = new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: ".concat(String.valueOf(bVar)));
                AppMethodBeat.o(122304);
                throw illegalArgumentException;
            default:
                m mVar = new m();
                AppMethodBeat.o(122304);
                throw mVar;
        }
    }
}
