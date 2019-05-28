package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.b.c.u */
public final class C0035u implements C17169t {
    private final List<C31637v> BiL;
    private final Set<C31637v> BiM;
    private final List<C31637v> BiN;

    public C0035u(List<C31637v> list, Set<C31637v> set, List<C31637v> list2) {
        C25052j.m39376p(list, "allDependencies");
        C25052j.m39376p(set, "modulesWhoseInternalsAreVisible");
        C25052j.m39376p(list2, "expectedByDependencies");
        AppMethodBeat.m2504i(119506);
        this.BiL = list;
        this.BiM = set;
        this.BiN = list2;
        AppMethodBeat.m2505o(119506);
    }

    public final List<C31637v> eaz() {
        return this.BiL;
    }

    public final Set<C31637v> eaA() {
        return this.BiM;
    }

    public final List<C31637v> eaB() {
        return this.BiN;
    }
}
