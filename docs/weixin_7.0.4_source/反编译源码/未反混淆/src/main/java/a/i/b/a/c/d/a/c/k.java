package a.i.b.a.c.d.a.c;

import a.f.b.j;
import a.i.b.a.c.d.a.a.a;
import a.i.b.a.c.d.a.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class k {
    public final h BnC;
    public final Collection<a> BnD;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.BnD, r4.BnD) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(119849);
        if (this != obj) {
            if (obj instanceof k) {
                k kVar = (k) obj;
                if (j.j(this.BnC, kVar.BnC)) {
                }
            }
            AppMethodBeat.o(119849);
            return false;
        }
        AppMethodBeat.o(119849);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(119848);
        h hVar = this.BnC;
        int hashCode = (hVar != null ? hVar.hashCode() : 0) * 31;
        Collection collection = this.BnD;
        if (collection != null) {
            i = collection.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(119848);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(119847);
        String str = "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.BnC + ", qualifierApplicabilityTypes=" + this.BnD + ")";
        AppMethodBeat.o(119847);
        return str;
    }

    public k(h hVar, Collection<? extends a> collection) {
        j.p(hVar, "nullabilityQualifier");
        j.p(collection, "qualifierApplicabilityTypes");
        AppMethodBeat.i(119846);
        this.BnC = hVar;
        this.BnD = collection;
        AppMethodBeat.o(119846);
    }
}
