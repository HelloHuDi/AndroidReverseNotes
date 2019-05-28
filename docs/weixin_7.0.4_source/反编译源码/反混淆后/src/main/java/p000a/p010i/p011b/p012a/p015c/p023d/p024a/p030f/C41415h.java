package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.d.a.f.h */
public final class C41415h {
    public final C41414g BpP;
    public final boolean BpQ;

    /* renamed from: a */
    private static C41415h m72231a(C41414g c41414g, boolean z) {
        AppMethodBeat.m2504i(120110);
        C25052j.m39376p(c41414g, "qualifier");
        C41415h c41415h = new C41415h(c41414g, z);
        AppMethodBeat.m2505o(120110);
        return c41415h;
    }

    /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if ((r5.BpQ == r6.BpQ) != false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(120114);
        if (this != obj) {
            if (obj instanceof C41415h) {
                C41415h c41415h = (C41415h) obj;
                if (C25052j.m39373j(this.BpP, c41415h.BpP)) {
                }
            }
            AppMethodBeat.m2505o(120114);
            return false;
        }
        AppMethodBeat.m2505o(120114);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(120113);
        C41414g c41414g = this.BpP;
        int hashCode = (c41414g != null ? c41414g.hashCode() : 0) * 31;
        int i = this.BpQ;
        if (i != 0) {
            i = 1;
        }
        i += hashCode;
        AppMethodBeat.m2505o(120113);
        return i;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120112);
        String str = "NullabilityQualifierWithMigrationStatus(qualifier=" + this.BpP + ", isForWarningOnly=" + this.BpQ + ")";
        AppMethodBeat.m2505o(120112);
        return str;
    }

    public C41415h(C41414g c41414g, boolean z) {
        C25052j.m39376p(c41414g, "qualifier");
        AppMethodBeat.m2504i(120109);
        this.BpP = c41414g;
        this.BpQ = z;
        AppMethodBeat.m2505o(120109);
    }

    public /* synthetic */ C41415h(C41414g c41414g) {
        this(c41414g, false);
    }
}
