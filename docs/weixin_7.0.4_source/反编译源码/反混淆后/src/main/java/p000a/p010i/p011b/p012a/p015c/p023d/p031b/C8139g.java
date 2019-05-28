package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p1146b.C44883g;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C25133aa;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C44915n;
import p000a.p010i.p011b.p012a.p015c.p045l.C17326x;
import p000a.p010i.p011b.p012a.p015c.p045l.C25235p;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.d.b.g */
public final class C8139g implements C44915n {
    public static final C8139g Brt = new C8139g();

    static {
        AppMethodBeat.m2504i(120264);
        AppMethodBeat.m2505o(120264);
    }

    private C8139g() {
    }

    /* renamed from: a */
    public final C46867w mo17935a(C25133aa c25133aa, String str, C8235ad c8235ad, C8235ad c8235ad2) {
        AppMethodBeat.m2504i(120263);
        C25052j.m39376p(c25133aa, "proto");
        C25052j.m39376p(str, "flexibleId");
        C25052j.m39376p(c8235ad, "lowerBound");
        C25052j.m39376p(c8235ad2, "upperBound");
        C46867w c46867w;
        if ((C25052j.m39373j(str, "kotlin.jvm.PlatformType") ^ 1) != 0) {
            C8235ad awn = C25235p.awn("Error java flexible type with id: " + str + ". (" + c8235ad + ".." + c8235ad2 + ')');
            C25052j.m39375o(awn, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
            c46867w = awn;
            AppMethodBeat.m2505o(120263);
            return c46867w;
        } else if (c25133aa.mo42017c(C0092b.BxF)) {
            c46867w = new C44883g(c8235ad, c8235ad2);
            AppMethodBeat.m2505o(120263);
            return c46867w;
        } else {
            c46867w = C17326x.m26839a(c8235ad, c8235ad2);
            AppMethodBeat.m2505o(120263);
            return c46867w;
        }
    }
}
