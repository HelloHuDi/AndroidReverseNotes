package a.i.b.a.c.d.a.f;

import a.f.b.j;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p {
    final w AYl;
    final d BqG;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.BqG, r4.BqG) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(120194);
        if (this != obj) {
            if (obj instanceof p) {
                p pVar = (p) obj;
                if (j.j(this.AYl, pVar.AYl)) {
                }
            }
            AppMethodBeat.o(120194);
            return false;
        }
        AppMethodBeat.o(120194);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(120193);
        w wVar = this.AYl;
        int hashCode = (wVar != null ? wVar.hashCode() : 0) * 31;
        d dVar = this.BqG;
        if (dVar != null) {
            i = dVar.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(120193);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(120192);
        String str = "TypeAndDefaultQualifiers(type=" + this.AYl + ", defaultQualifiers=" + this.BqG + ")";
        AppMethodBeat.o(120192);
        return str;
    }

    public p(w wVar, d dVar) {
        j.p(wVar, "type");
        AppMethodBeat.i(120191);
        this.AYl = wVar;
        this.BqG = dVar;
        AppMethodBeat.o(120191);
    }
}
