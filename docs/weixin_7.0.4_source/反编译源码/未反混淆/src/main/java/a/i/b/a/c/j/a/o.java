package a.i.b.a.c.j.a;

import a.f.b.j;
import a.i.b.a.c.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o<T extends a> {
    private final T BHg;
    private final T BHh;
    private final a.i.b.a.c.f.a BcB;
    private final String filePath;

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (a.f.b.j.j(r3.BcB, r4.BcB) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(122273);
        if (this != obj) {
            if (obj instanceof o) {
                o oVar = (o) obj;
                if (j.j(this.BHg, oVar.BHg)) {
                    if (j.j(this.BHh, oVar.BHh)) {
                        if (j.j(this.filePath, oVar.filePath)) {
                        }
                    }
                }
            }
            AppMethodBeat.o(122273);
            return false;
        }
        AppMethodBeat.o(122273);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(122272);
        a aVar = this.BHg;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        aVar = this.BHh;
        hashCode = ((aVar != null ? aVar.hashCode() : 0) + hashCode) * 31;
        String str = this.filePath;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        a.i.b.a.c.f.a aVar2 = this.BcB;
        if (aVar2 != null) {
            i = aVar2.hashCode();
        }
        hashCode2 += i;
        AppMethodBeat.o(122272);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.i(122271);
        String str = "IncompatibleVersionErrorData(actualVersion=" + this.BHg + ", expectedVersion=" + this.BHh + ", filePath=" + this.filePath + ", classId=" + this.BcB + ")";
        AppMethodBeat.o(122271);
        return str;
    }

    public o(T t, T t2, String str, a.i.b.a.c.f.a aVar) {
        j.p(t, "actualVersion");
        j.p(t2, "expectedVersion");
        j.p(str, "filePath");
        j.p(aVar, "classId");
        AppMethodBeat.i(122270);
        this.BHg = t;
        this.BHh = t2;
        this.filePath = str;
        this.BcB = aVar;
        AppMethodBeat.o(122270);
    }
}
