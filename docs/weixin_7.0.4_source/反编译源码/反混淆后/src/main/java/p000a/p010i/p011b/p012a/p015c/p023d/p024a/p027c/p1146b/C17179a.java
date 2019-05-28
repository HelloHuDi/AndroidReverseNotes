package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a.C25096l;

/* renamed from: a.i.b.a.c.d.a.c.b.a */
public final class C17179a {
    final C25096l BoW;
    final C25108b BoX;
    final boolean BoY;
    final C36955ar BoZ;

    /* JADX WARNING: Missing block: B:13:0x0035, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r5.BoZ, r6.BoZ) != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(120027);
        if (this != obj) {
            if (obj instanceof C17179a) {
                C17179a c17179a = (C17179a) obj;
                if (C25052j.m39373j(this.BoW, c17179a.BoW) && C25052j.m39373j(this.BoX, c17179a.BoX)) {
                    if (this.BoY == c17179a.BoY) {
                    }
                }
            }
            AppMethodBeat.m2505o(120027);
            return false;
        }
        AppMethodBeat.m2505o(120027);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(120026);
        C25096l c25096l = this.BoW;
        int hashCode = (c25096l != null ? c25096l.hashCode() : 0) * 31;
        C25108b c25108b = this.BoX;
        hashCode = ((c25108b != null ? c25108b.hashCode() : 0) + hashCode) * 31;
        int i2 = this.BoY;
        if (i2 != 0) {
            i2 = 1;
        }
        i2 = (i2 + hashCode) * 31;
        C36955ar c36955ar = this.BoZ;
        if (c36955ar != null) {
            i = c36955ar.hashCode();
        }
        i2 += i;
        AppMethodBeat.m2505o(120026);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120025);
        String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.BoW + ", flexibility=" + this.BoX + ", isForAnnotationParameter=" + this.BoY + ", upperBoundOfTypeParameter=" + this.BoZ + ")";
        AppMethodBeat.m2505o(120025);
        return str;
    }

    private C17179a(C25096l c25096l, C25108b c25108b, boolean z, C36955ar c36955ar) {
        C25052j.m39376p(c25096l, "howThisTypeIsUsed");
        C25052j.m39376p(c25108b, "flexibility");
        AppMethodBeat.m2504i(120023);
        this.BoW = c25096l;
        this.BoX = c25108b;
        this.BoY = z;
        this.BoZ = c36955ar;
        AppMethodBeat.m2505o(120023);
    }

    public /* synthetic */ C17179a(C25096l c25096l, boolean z, C36955ar c36955ar) {
        this(c25096l, C25108b.INFLEXIBLE, z, c36955ar);
        AppMethodBeat.m2504i(120024);
        AppMethodBeat.m2505o(120024);
    }

    /* renamed from: a */
    public final C17179a mo31271a(C25108b c25108b) {
        AppMethodBeat.m2504i(120022);
        C25052j.m39376p(c25108b, "flexibility");
        C25096l c25096l = this.BoW;
        boolean z = this.BoY;
        C36955ar c36955ar = this.BoZ;
        C25052j.m39376p(c25096l, "howThisTypeIsUsed");
        C25052j.m39376p(c25108b, "flexibility");
        C17179a c17179a = new C17179a(c25096l, c25108b, z, c36955ar);
        AppMethodBeat.m2505o(120022);
        return c17179a;
    }
}
