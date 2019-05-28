package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0029b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.a.h */
public final class C31627h implements C0026g {
    private final List<C44869c> BfM;

    public C31627h(List<? extends C44869c> list) {
        C25052j.m39376p(list, "annotations");
        AppMethodBeat.m2504i(119339);
        this.BfM = list;
        AppMethodBeat.m2505o(119339);
    }

    /* renamed from: i */
    public final C44869c mo53i(C8174b c8174b) {
        AppMethodBeat.m2504i(119340);
        C25052j.m39376p(c8174b, "fqName");
        C44869c a = C0029b.m32a(this, c8174b);
        AppMethodBeat.m2505o(119340);
        return a;
    }

    /* renamed from: j */
    public final boolean mo55j(C8174b c8174b) {
        AppMethodBeat.m2504i(119341);
        C25052j.m39376p(c8174b, "fqName");
        boolean b = C0029b.m33b(this, c8174b);
        AppMethodBeat.m2505o(119341);
        return b;
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(119336);
        boolean isEmpty = this.BfM.isEmpty();
        AppMethodBeat.m2505o(119336);
        return isEmpty;
    }

    public final Iterator<C44869c> iterator() {
        AppMethodBeat.m2504i(119337);
        Iterator it = this.BfM.iterator();
        AppMethodBeat.m2505o(119337);
        return it;
    }

    public final String toString() {
        AppMethodBeat.m2504i(119338);
        String obj = this.BfM.toString();
        AppMethodBeat.m2505o(119338);
        return obj;
    }
}
