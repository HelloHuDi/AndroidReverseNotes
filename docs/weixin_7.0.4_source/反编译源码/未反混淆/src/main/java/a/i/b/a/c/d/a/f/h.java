package a.i.b.a.c.d.a.f;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    public final g BpP;
    public final boolean BpQ;

    private static h a(g gVar, boolean z) {
        AppMethodBeat.i(120110);
        j.p(gVar, "qualifier");
        h hVar = new h(gVar, z);
        AppMethodBeat.o(120110);
        return hVar;
    }

    /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if ((r5.BpQ == r6.BpQ) != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(120114);
        if (this != obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (j.j(this.BpP, hVar.BpP)) {
                }
            }
            AppMethodBeat.o(120114);
            return false;
        }
        AppMethodBeat.o(120114);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(120113);
        g gVar = this.BpP;
        int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
        int i = this.BpQ;
        if (i != 0) {
            i = 1;
        }
        i += hashCode;
        AppMethodBeat.o(120113);
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(120112);
        String str = "NullabilityQualifierWithMigrationStatus(qualifier=" + this.BpP + ", isForWarningOnly=" + this.BpQ + ")";
        AppMethodBeat.o(120112);
        return str;
    }

    public h(g gVar, boolean z) {
        j.p(gVar, "qualifier");
        AppMethodBeat.i(120109);
        this.BpP = gVar;
        this.BpQ = z;
        AppMethodBeat.o(120109);
    }

    public /* synthetic */ h(g gVar) {
        this(gVar, false);
    }
}
