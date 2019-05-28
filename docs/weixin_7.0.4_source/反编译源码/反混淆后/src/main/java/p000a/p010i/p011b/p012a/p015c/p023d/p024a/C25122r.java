package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.r */
final class C25122r {
    final C37022f BgZ;
    final String signature;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.signature, r4.signature) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(119722);
        if (this != obj) {
            if (obj instanceof C25122r) {
                C25122r c25122r = (C25122r) obj;
                if (C25052j.m39373j(this.BgZ, c25122r.BgZ)) {
                }
            }
            AppMethodBeat.m2505o(119722);
            return false;
        }
        AppMethodBeat.m2505o(119722);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(119721);
        C37022f c37022f = this.BgZ;
        int hashCode = (c37022f != null ? c37022f.hashCode() : 0) * 31;
        String str = this.signature;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(119721);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(119720);
        String str = "NameAndSignature(name=" + this.BgZ + ", signature=" + this.signature + ")";
        AppMethodBeat.m2505o(119720);
        return str;
    }

    public C25122r(C37022f c37022f, String str) {
        C25052j.m39376p(c37022f, "name");
        C25052j.m39376p(str, "signature");
        AppMethodBeat.m2504i(119719);
        this.BgZ = c37022f;
        this.signature = str;
        AppMethodBeat.m2505o(119719);
    }
}
