package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C17296f;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C44914e;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.d.b.f */
public final class C0076f implements C17296f {
    private final C25129m BmS;
    private final C0073e BmT;

    public C0076f(C25129m c25129m, C0073e c0073e) {
        C25052j.m39376p(c25129m, "kotlinClassFinder");
        C25052j.m39376p(c0073e, "deserializedDescriptorResolver");
        AppMethodBeat.m2504i(120262);
        this.BmS = c25129m;
        this.BmT = c0073e;
        AppMethodBeat.m2505o(120262);
    }

    /* renamed from: g */
    public final C44914e mo124g(C8173a c8173a) {
        AppMethodBeat.m2504i(120261);
        C25052j.m39376p(c8173a, "classId");
        C8143n b = this.BmS.mo17820b(c8173a);
        if (b == null) {
            AppMethodBeat.m2505o(120261);
            return null;
        }
        boolean j = C25052j.m39373j(b.dWY(), c8173a);
        if (!C44847aa.AUz || j) {
            C44914e a = this.BmT.mo122a(b);
            AppMethodBeat.m2505o(120261);
            return a;
        }
        Throwable assertionError = new AssertionError("Class with incorrect id found: expected " + c8173a + ", actual " + b.dWY());
        AppMethodBeat.m2505o(120261);
        throw assertionError;
    }
}
