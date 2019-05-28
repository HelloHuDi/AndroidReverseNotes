package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.d.a.f.p */
final class C36986p {
    final C46867w AYl;
    final C8119d BqG;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BqG, r4.BqG) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(120194);
        if (this != obj) {
            if (obj instanceof C36986p) {
                C36986p c36986p = (C36986p) obj;
                if (C25052j.m39373j(this.AYl, c36986p.AYl)) {
                }
            }
            AppMethodBeat.m2505o(120194);
            return false;
        }
        AppMethodBeat.m2505o(120194);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(120193);
        C46867w c46867w = this.AYl;
        int hashCode = (c46867w != null ? c46867w.hashCode() : 0) * 31;
        C8119d c8119d = this.BqG;
        if (c8119d != null) {
            i = c8119d.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(120193);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120192);
        String str = "TypeAndDefaultQualifiers(type=" + this.AYl + ", defaultQualifiers=" + this.BqG + ")";
        AppMethodBeat.m2505o(120192);
        return str;
    }

    public C36986p(C46867w c46867w, C8119d c8119d) {
        C25052j.m39376p(c46867w, "type");
        AppMethodBeat.m2504i(120191);
        this.AYl = c46867w;
        this.BqG = c8119d;
        AppMethodBeat.m2505o(120191);
    }
}
