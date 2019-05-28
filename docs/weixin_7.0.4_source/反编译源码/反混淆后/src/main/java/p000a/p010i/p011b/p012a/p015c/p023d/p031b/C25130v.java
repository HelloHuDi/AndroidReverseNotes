package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.d.b.v */
public final class C25130v implements C36997u<C31680j> {
    public static final C25130v BrL = new C25130v();

    static {
        AppMethodBeat.m2504i(120325);
        AppMethodBeat.m2505o(120325);
    }

    private C25130v() {
    }

    /* renamed from: t */
    public final /* synthetic */ Object mo41980t(C46865e c46865e) {
        AppMethodBeat.m2504i(120322);
        C25052j.m39376p(c46865e, "classDescriptor");
        AppMethodBeat.m2505o(120322);
        return null;
    }

    /* renamed from: m */
    public final C46867w mo41979m(Collection<? extends C46867w> collection) {
        AppMethodBeat.m2504i(120321);
        C25052j.m39376p(collection, "types");
        Throwable assertionError = new AssertionError("There should be no intersection type in existing descriptors, but found: " + C25035t.m39322a((Iterable) collection, null, null, null, 0, null, null, 63));
        AppMethodBeat.m2505o(120321);
        throw assertionError;
    }

    /* renamed from: u */
    public final String mo41981u(C46865e c46865e) {
        AppMethodBeat.m2504i(120323);
        C25052j.m39376p(c46865e, "classDescriptor");
        AppMethodBeat.m2505o(120323);
        return null;
    }

    /* renamed from: a */
    public final void mo41978a(C46867w c46867w, C46865e c46865e) {
        AppMethodBeat.m2504i(120324);
        C25052j.m39376p(c46867w, "kotlinType");
        C25052j.m39376p(c46865e, "descriptor");
        AppMethodBeat.m2505o(120324);
    }
}
