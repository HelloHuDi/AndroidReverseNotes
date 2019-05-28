package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C31824m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0108c;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17259f;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17259f.C17260b;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17259f.C17261a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;

/* renamed from: a.i.b.a.c.d.b.q */
public final class C8149q {
    public static final C8150a BrI = new C8150a();
    final String signature;

    /* renamed from: a.i.b.a.c.d.b.q$a */
    public static final class C8150a {
        private C8150a() {
        }

        public /* synthetic */ C8150a(byte b) {
            this();
        }

        /* renamed from: iT */
        public static C8149q m14357iT(String str, String str2) {
            AppMethodBeat.m2504i(120292);
            C25052j.m39376p(str, "name");
            C25052j.m39376p(str2, "desc");
            C8149q c8149q = new C8149q(str + str2, (byte) 0);
            AppMethodBeat.m2505o(120292);
            return c8149q;
        }

        /* renamed from: iU */
        public static C8149q m14358iU(String str, String str2) {
            AppMethodBeat.m2504i(120293);
            C25052j.m39376p(str, "name");
            C25052j.m39376p(str2, "desc");
            C8149q c8149q = new C8149q(str + "#" + str2, (byte) 0);
            AppMethodBeat.m2505o(120293);
            return c8149q;
        }

        /* renamed from: a */
        public static C8149q m14356a(C17259f c17259f) {
            AppMethodBeat.m2504i(120294);
            C25052j.m39376p(c17259f, "signature");
            C8149q iT;
            if (c17259f instanceof C17260b) {
                iT = C8150a.m14357iT(c17259f.getName(), c17259f.ehx());
                AppMethodBeat.m2505o(120294);
                return iT;
            } else if (c17259f instanceof C17261a) {
                iT = C8150a.m14358iU(c17259f.getName(), c17259f.ehx());
                AppMethodBeat.m2505o(120294);
                return iT;
            } else {
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(120294);
                throw c31824m;
            }
        }

        /* renamed from: a */
        public static C8149q m14354a(C8149q c8149q, int i) {
            AppMethodBeat.m2504i(120295);
            C25052j.m39376p(c8149q, "signature");
            C8149q c8149q2 = new C8149q(c8149q.signature + "@" + i, (byte) 0);
            AppMethodBeat.m2505o(120295);
            return c8149q2;
        }

        /* renamed from: a */
        public static C8149q m14355a(C31702c c31702c, C0108c c0108c) {
            AppMethodBeat.m2504i(120291);
            C25052j.m39376p(c31702c, "nameResolver");
            C25052j.m39376p(c0108c, "signature");
            C8149q iT = C8150a.m14357iT(c31702c.getString(c0108c.Buf), c31702c.getString(c0108c.BxN));
            AppMethodBeat.m2505o(120291);
            return iT;
        }
    }

    static {
        AppMethodBeat.m2504i(120296);
        AppMethodBeat.m2505o(120296);
    }

    /* JADX WARNING: Missing block: B:5:0x0016, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.signature, ((p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8149q) r4).signature) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(120299);
        if (this != obj) {
            if (obj instanceof C8149q) {
            }
            AppMethodBeat.m2505o(120299);
            return false;
        }
        AppMethodBeat.m2505o(120299);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(120298);
        String str = this.signature;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.m2505o(120298);
            return hashCode;
        }
        AppMethodBeat.m2505o(120298);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120297);
        String str = "MemberSignature(signature=" + this.signature + ")";
        AppMethodBeat.m2505o(120297);
        return str;
    }

    private C8149q(String str) {
        this.signature = str;
    }

    public /* synthetic */ C8149q(String str, byte b) {
        this(str);
    }
}
