package p000a.p010i.p011b.p012a.p015c.p041j.p042a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.j.a.o */
public final class C0144o<T extends C31698a> {
    private final T BHg;
    private final T BHh;
    private final C8173a BcB;
    private final String filePath;

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BcB, r4.BcB) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(122273);
        if (this != obj) {
            if (obj instanceof C0144o) {
                C0144o c0144o = (C0144o) obj;
                if (C25052j.m39373j(this.BHg, c0144o.BHg)) {
                    if (C25052j.m39373j(this.BHh, c0144o.BHh)) {
                        if (C25052j.m39373j(this.filePath, c0144o.filePath)) {
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(122273);
            return false;
        }
        AppMethodBeat.m2505o(122273);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(122272);
        C31698a c31698a = this.BHg;
        int hashCode = (c31698a != null ? c31698a.hashCode() : 0) * 31;
        c31698a = this.BHh;
        hashCode = ((c31698a != null ? c31698a.hashCode() : 0) + hashCode) * 31;
        String str = this.filePath;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        C8173a c8173a = this.BcB;
        if (c8173a != null) {
            i = c8173a.hashCode();
        }
        hashCode2 += i;
        AppMethodBeat.m2505o(122272);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122271);
        String str = "IncompatibleVersionErrorData(actualVersion=" + this.BHg + ", expectedVersion=" + this.BHh + ", filePath=" + this.filePath + ", classId=" + this.BcB + ")";
        AppMethodBeat.m2505o(122271);
        return str;
    }

    public C0144o(T t, T t2, String str, C8173a c8173a) {
        C25052j.m39376p(t, "actualVersion");
        C25052j.m39376p(t2, "expectedVersion");
        C25052j.m39376p(str, "filePath");
        C25052j.m39376p(c8173a, "classId");
        AppMethodBeat.m2504i(122270);
        this.BHg = t;
        this.BHh = t2;
        this.filePath = str;
        this.BcB = c8173a;
        AppMethodBeat.m2505o(122270);
    }
}
