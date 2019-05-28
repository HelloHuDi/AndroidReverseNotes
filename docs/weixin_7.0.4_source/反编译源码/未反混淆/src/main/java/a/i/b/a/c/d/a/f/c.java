package a.i.b.a.c.d.a.f;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c<T> {
    final g BpA;
    final T result;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.BpA, r4.BpA) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(120093);
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (j.j(this.result, cVar.result)) {
                }
            }
            AppMethodBeat.o(120093);
            return false;
        }
        AppMethodBeat.o(120093);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(120092);
        Object obj = this.result;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        g gVar = this.BpA;
        if (gVar != null) {
            i = gVar.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(120092);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(120091);
        String str = "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.BpA + ")";
        AppMethodBeat.o(120091);
        return str;
    }

    public c(T t, g gVar) {
        this.result = t;
        this.BpA = gVar;
    }
}
