package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;

/* renamed from: a.i.b.a.c.d.a.f.c */
final class C25118c<T> {
    final C0026g BpA;
    final T result;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BpA, r4.BpA) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(120093);
        if (this != obj) {
            if (obj instanceof C25118c) {
                C25118c c25118c = (C25118c) obj;
                if (C25052j.m39373j(this.result, c25118c.result)) {
                }
            }
            AppMethodBeat.m2505o(120093);
            return false;
        }
        AppMethodBeat.m2505o(120093);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(120092);
        Object obj = this.result;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        C0026g c0026g = this.BpA;
        if (c0026g != null) {
            i = c0026g.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(120092);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120091);
        String str = "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.BpA + ")";
        AppMethodBeat.m2505o(120091);
        return str;
    }

    public C25118c(T t, C0026g c0026g) {
        this.result = t;
        this.BpA = c0026g;
    }
}
