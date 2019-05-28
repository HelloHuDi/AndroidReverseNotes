package a.i.b.a.c.d.a;

import a.a.l;
import a.a.t;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.f.f;
import a.i.b.a.c.m.a.a;
import a.k.u;
import a.k.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class s {
    private static f a(f fVar, boolean z) {
        AppMethodBeat.i(119723);
        j.p(fVar, "methodName");
        f a = a(fVar, "set", false, z ? "is" : null, 4);
        AppMethodBeat.o(119723);
        return a;
    }

    private static /* synthetic */ f a(f fVar, String str, boolean z, String str2, int i) {
        AppMethodBeat.i(119725);
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        f a = a(fVar, str, z, str2);
        AppMethodBeat.o(119725);
        return a;
    }

    private static final f a(f fVar, String str, boolean z, String str2) {
        AppMethodBeat.i(119724);
        if (fVar.ByZ) {
            AppMethodBeat.o(119724);
            return null;
        }
        String ehN = fVar.ehN();
        j.o(ehN, "methodName.identifier");
        if (!u.jb(ehN, str)) {
            AppMethodBeat.o(119724);
            return null;
        } else if (ehN.length() == str.length()) {
            AppMethodBeat.o(119724);
            return null;
        } else {
            char charAt = ehN.charAt(str.length());
            if ('a' <= charAt && 'z' >= charAt) {
                AppMethodBeat.o(119724);
                return null;
            } else if (str2 != null) {
                if (!aa.AUz || z) {
                    fVar = f.avX(str2 + v.b(ehN, (CharSequence) str));
                    AppMethodBeat.o(119724);
                    return fVar;
                }
                Throwable assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.o(119724);
                throw assertionError;
            } else if (z) {
                ehN = a.awr(v.b(ehN, (CharSequence) str));
                if (f.avY(ehN)) {
                    fVar = f.avX(ehN);
                    AppMethodBeat.o(119724);
                    return fVar;
                }
                AppMethodBeat.o(119724);
                return null;
            } else {
                AppMethodBeat.o(119724);
                return fVar;
            }
        }
    }

    public static final List<f> j(f fVar) {
        AppMethodBeat.i(119726);
        j.p(fVar, "name");
        String str = fVar.name;
        j.o(str, "name.asString()");
        List<f> k;
        if (o.avH(str)) {
            j.p(fVar, "methodName");
            Object a = a(fVar, "get", false, null, 12);
            if (a == null) {
                a = a(fVar, "is", false, null, 8);
            }
            List dm = l.dm(a);
            AppMethodBeat.o(119726);
            return dm;
        } else if (o.avI(str)) {
            j.p(fVar, "methodName");
            k = t.k(l.listOf(a(fVar, false), a(fVar, true)));
            AppMethodBeat.o(119726);
            return k;
        } else {
            e eVar = e.BkZ;
            k = e.i(fVar);
            AppMethodBeat.o(119726);
            return k;
        }
    }
}
