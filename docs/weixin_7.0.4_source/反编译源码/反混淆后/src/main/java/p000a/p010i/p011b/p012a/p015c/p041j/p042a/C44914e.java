package p000a.p010i.p011b.p012a.p015c.p041j.p042a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;

/* renamed from: a.i.b.a.c.j.a.e */
public final class C44914e {
    final C31702c AWq;
    final C37000c BGD;
    final C31698a BGE;
    final C41398am BGF;

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BGF, r4.BGF) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(122251);
        if (this != obj) {
            if (obj instanceof C44914e) {
                C44914e c44914e = (C44914e) obj;
                if (C25052j.m39373j(this.AWq, c44914e.AWq)) {
                    if (C25052j.m39373j(this.BGD, c44914e.BGD)) {
                        if (C25052j.m39373j(this.BGE, c44914e.BGE)) {
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(122251);
            return false;
        }
        AppMethodBeat.m2505o(122251);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(122250);
        C31702c c31702c = this.AWq;
        int hashCode = (c31702c != null ? c31702c.hashCode() : 0) * 31;
        C37000c c37000c = this.BGD;
        hashCode = ((c37000c != null ? c37000c.hashCode() : 0) + hashCode) * 31;
        C31698a c31698a = this.BGE;
        int hashCode2 = ((c31698a != null ? c31698a.hashCode() : 0) + hashCode) * 31;
        C41398am c41398am = this.BGF;
        if (c41398am != null) {
            i = c41398am.hashCode();
        }
        hashCode2 += i;
        AppMethodBeat.m2505o(122250);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(122249);
        String str = "ClassData(nameResolver=" + this.AWq + ", classProto=" + this.BGD + ", metadataVersion=" + this.BGE + ", sourceElement=" + this.BGF + ")";
        AppMethodBeat.m2505o(122249);
        return str;
    }

    public C44914e(C31702c c31702c, C37000c c37000c, C31698a c31698a, C41398am c41398am) {
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c37000c, "classProto");
        C25052j.m39376p(c31698a, "metadataVersion");
        C25052j.m39376p(c41398am, "sourceElement");
        AppMethodBeat.m2504i(122248);
        this.AWq = c31702c;
        this.BGD = c37000c;
        this.BGE = c31698a;
        this.BGF = c41398am;
        AppMethodBeat.m2505o(122248);
    }
}
