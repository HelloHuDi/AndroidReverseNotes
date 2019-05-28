package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C0045a.C0046a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f.C41415h;

/* renamed from: a.i.b.a.c.d.a.c.k */
public final class C31668k {
    public final C41415h BnC;
    public final Collection<C0046a> BnD;

    /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.BnD, r4.BnD) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(119849);
        if (this != obj) {
            if (obj instanceof C31668k) {
                C31668k c31668k = (C31668k) obj;
                if (C25052j.m39373j(this.BnC, c31668k.BnC)) {
                }
            }
            AppMethodBeat.m2505o(119849);
            return false;
        }
        AppMethodBeat.m2505o(119849);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(119848);
        C41415h c41415h = this.BnC;
        int hashCode = (c41415h != null ? c41415h.hashCode() : 0) * 31;
        Collection collection = this.BnD;
        if (collection != null) {
            i = collection.hashCode();
        }
        hashCode += i;
        AppMethodBeat.m2505o(119848);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(119847);
        String str = "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.BnC + ", qualifierApplicabilityTypes=" + this.BnD + ")";
        AppMethodBeat.m2505o(119847);
        return str;
    }

    public C31668k(C41415h c41415h, Collection<? extends C0046a> collection) {
        C25052j.m39376p(c41415h, "nullabilityQualifier");
        C25052j.m39376p(collection, "qualifierApplicabilityTypes");
        AppMethodBeat.m2504i(119846);
        this.BnC = c41415h;
        this.BnD = collection;
        AppMethodBeat.m2505o(119846);
    }
}
