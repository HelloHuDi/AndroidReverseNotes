package a.i.b.a.c.d.a;

import a.f.b.j;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r {
    final f BgZ;
    final String signature;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.signature, r4.signature) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(119722);
        if (this != obj) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                if (j.j(this.BgZ, rVar.BgZ)) {
                }
            }
            AppMethodBeat.o(119722);
            return false;
        }
        AppMethodBeat.o(119722);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(119721);
        f fVar = this.BgZ;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
        String str = this.signature;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(119721);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(119720);
        String str = "NameAndSignature(name=" + this.BgZ + ", signature=" + this.signature + ")";
        AppMethodBeat.o(119720);
        return str;
    }

    public r(f fVar, String str) {
        j.p(fVar, "name");
        j.p(str, "signature");
        AppMethodBeat.i(119719);
        this.BgZ = fVar;
        this.signature = str;
        AppMethodBeat.o(119719);
    }
}
