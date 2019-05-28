package a.i.b.a.c.n;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public final int BNi;
    public final String tTc;

    /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if ((r5.BNi == r6.BNi) != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(122943);
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (j.j(this.tTc, fVar.tTc)) {
                }
            }
            AppMethodBeat.o(122943);
            return false;
        }
        AppMethodBeat.o(122943);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(122942);
        String str = this.tTc;
        int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.BNi;
        AppMethodBeat.o(122942);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(122941);
        String str = "NumberWithRadix(number=" + this.tTc + ", radix=" + this.BNi + ")";
        AppMethodBeat.o(122941);
        return str;
    }

    public f(String str, int i) {
        j.p(str, "number");
        AppMethodBeat.i(122940);
        this.tTc = str;
        this.BNi = i;
        AppMethodBeat.o(122940);
    }
}
