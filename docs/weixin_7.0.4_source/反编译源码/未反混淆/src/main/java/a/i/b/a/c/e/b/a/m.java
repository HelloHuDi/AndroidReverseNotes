package a.i.b.a.c.e.b.a;

import a.a.am;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public final class m {
    private final LinkedHashMap<String, String> ByK = new LinkedHashMap();
    final Set<String> ByL = new LinkedHashSet();
    private final String ByM;

    public m(String str) {
        j.p(str, "packageFqName");
        AppMethodBeat.i(121347);
        this.ByM = str;
        AppMethodBeat.o(121347);
    }

    public final Set<String> ehA() {
        AppMethodBeat.i(121342);
        Set keySet = this.ByK.keySet();
        j.o(keySet, "packageParts.keys");
        AppMethodBeat.o(121342);
        return keySet;
    }

    public final void iY(String str, String str2) {
        AppMethodBeat.i(121343);
        j.p(str, "partInternalName");
        this.ByK.put(str, str2);
        AppMethodBeat.o(121343);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(121344);
        if ((obj instanceof m) && j.j(((m) obj).ByM, this.ByM) && j.j(((m) obj).ByK, this.ByK) && j.j(((m) obj).ByL, this.ByL)) {
            AppMethodBeat.o(121344);
            return true;
        }
        AppMethodBeat.o(121344);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(121345);
        int hashCode = (((this.ByM.hashCode() * 31) + this.ByK.hashCode()) * 31) + this.ByL.hashCode();
        AppMethodBeat.o(121345);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(121346);
        String obj = am.a(ehA(), this.ByL).toString();
        AppMethodBeat.o(121346);
        return obj;
    }
}
