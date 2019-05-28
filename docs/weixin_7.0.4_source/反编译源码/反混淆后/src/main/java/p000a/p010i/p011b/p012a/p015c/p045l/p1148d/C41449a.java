package p000a.p010i.p011b.p012a.p015c.p045l.p1148d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.l.d.a */
public final class C41449a<T> {
    final T BLm;
    public final T BLn;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BLn, r4.BLn) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(122829);
        if (this != obj) {
            if (obj instanceof C41449a) {
                C41449a c41449a = (C41449a) obj;
                if (C25052j.m39373j(this.BLm, c41449a.BLm)) {
                }
            }
            AppMethodBeat.m2505o(122829);
            return false;
        }
        AppMethodBeat.m2505o(122829);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(122828);
        Object obj = this.BLm;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.BLn;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(122828);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122827);
        String str = "ApproximationBounds(lower=" + this.BLm + ", upper=" + this.BLn + ")";
        AppMethodBeat.m2505o(122827);
        return str;
    }

    public C41449a(T t, T t2) {
        this.BLm = t;
        this.BLn = t2;
    }
}
