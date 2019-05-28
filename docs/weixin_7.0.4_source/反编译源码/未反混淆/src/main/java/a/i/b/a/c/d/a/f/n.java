package a.i.b.a.c.d.a.f;

import a.a.am;
import a.a.t;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class n {
    static final d a(g gVar, e eVar, boolean z, boolean z2) {
        AppMethodBeat.i(120187);
        d dVar;
        if (z2 && gVar == g.NOT_NULL) {
            dVar = new d(gVar, eVar, true, z);
            AppMethodBeat.o(120187);
            return dVar;
        }
        dVar = new d(gVar, eVar, false, z);
        AppMethodBeat.o(120187);
        return dVar;
    }

    /* JADX WARNING: Missing block: B:18:0x003d, code skipped:
            if (r0 == null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final <T> T a(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        AppMethodBeat.i(120188);
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (j.j(t4, t) && j.j(t3, t2)) {
                AppMethodBeat.o(120188);
                return null;
            }
            if (t3 != null) {
                t4 = t3;
            }
            AppMethodBeat.o(120188);
            return t4;
        }
        Set o;
        if (t3 != null) {
            o = t.o(am.b(set, t3));
        }
        o = set;
        T i = t.i((Iterable) o);
        AppMethodBeat.o(120188);
        return i;
    }

    static final g a(Set<? extends g> set, g gVar, boolean z) {
        AppMethodBeat.i(120189);
        g gVar2;
        if (gVar == g.FORCE_FLEXIBILITY) {
            gVar2 = g.FORCE_FLEXIBILITY;
            AppMethodBeat.o(120189);
            return gVar2;
        }
        gVar2 = (g) a(set, g.NOT_NULL, g.NULLABLE, gVar, z);
        AppMethodBeat.o(120189);
        return gVar2;
    }
}
