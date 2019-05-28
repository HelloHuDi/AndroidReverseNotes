package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.n.f */
public final class C8263f {
    public final int BNi;
    public final String tTc;

    /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if ((r5.BNi == r6.BNi) != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(122943);
        if (this != obj) {
            if (obj instanceof C8263f) {
                C8263f c8263f = (C8263f) obj;
                if (C25052j.m39373j(this.tTc, c8263f.tTc)) {
                }
            }
            AppMethodBeat.m2505o(122943);
            return false;
        }
        AppMethodBeat.m2505o(122943);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(122942);
        String str = this.tTc;
        int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.BNi;
        AppMethodBeat.m2505o(122942);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122941);
        String str = "NumberWithRadix(number=" + this.tTc + ", radix=" + this.BNi + ")";
        AppMethodBeat.m2505o(122941);
        return str;
    }

    public C8263f(String str, int i) {
        C25052j.m39376p(str, "number");
        AppMethodBeat.m2504i(122940);
        this.tTc = str;
        this.BNi = i;
        AppMethodBeat.m2505o(122940);
    }
}
