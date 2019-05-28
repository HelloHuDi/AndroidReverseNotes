package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.b.a.i */
public final class C36952i {
    /* renamed from: a */
    public static final C0026g m61732a(C0026g c0026g, C0026g c0026g2) {
        AppMethodBeat.m2504i(119342);
        C25052j.m39376p(c0026g, "first");
        C25052j.m39376p(c0026g2, "second");
        if (c0026g.isEmpty()) {
            AppMethodBeat.m2505o(119342);
            return c0026g2;
        } else if (c0026g2.isEmpty()) {
            AppMethodBeat.m2505o(119342);
            return c0026g;
        } else {
            C0026g c31630k = new C31630k(c0026g, c0026g2);
            AppMethodBeat.m2505o(119342);
            return c31630k;
        }
    }
}
