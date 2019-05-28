package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.a.l */
public final class C31631l implements C0026g {
    private final C0026g BfV;
    private final C17126b<C8174b, Boolean> BfW;

    public C31631l(C0026g c0026g, C17126b<? super C8174b, Boolean> c17126b) {
        C25052j.m39376p(c0026g, "delegate");
        C25052j.m39376p(c17126b, "fqNameFilter");
        AppMethodBeat.m2504i(119362);
        this.BfV = c0026g;
        this.BfW = c17126b;
        AppMethodBeat.m2505o(119362);
    }

    /* renamed from: j */
    public final boolean mo55j(C8174b c8174b) {
        AppMethodBeat.m2504i(119357);
        C25052j.m39376p(c8174b, "fqName");
        if (((Boolean) this.BfW.mo50am(c8174b)).booleanValue()) {
            boolean j = this.BfV.mo55j(c8174b);
            AppMethodBeat.m2505o(119357);
            return j;
        }
        AppMethodBeat.m2505o(119357);
        return false;
    }

    /* renamed from: i */
    public final C44869c mo53i(C8174b c8174b) {
        AppMethodBeat.m2504i(119358);
        C25052j.m39376p(c8174b, "fqName");
        if (((Boolean) this.BfW.mo50am(c8174b)).booleanValue()) {
            C44869c i = this.BfV.mo53i(c8174b);
            AppMethodBeat.m2505o(119358);
            return i;
        }
        AppMethodBeat.m2505o(119358);
        return null;
    }

    public final Iterator<C44869c> iterator() {
        AppMethodBeat.m2504i(119359);
        Collection arrayList = new ArrayList();
        for (Object next : this.BfV) {
            if (m51149c((C44869c) next)) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        AppMethodBeat.m2505o(119359);
        return it;
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(119360);
        Iterable<C44869c> iterable = this.BfV;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C44869c c : iterable) {
                if (m51149c(c)) {
                    AppMethodBeat.m2505o(119360);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(119360);
        return false;
    }

    /* renamed from: c */
    private final boolean m51149c(C44869c c44869c) {
        AppMethodBeat.m2504i(119361);
        C8174b dZF = c44869c.dZF();
        if (dZF == null || !((Boolean) this.BfW.mo50am(dZF)).booleanValue()) {
            AppMethodBeat.m2505o(119361);
            return false;
        }
        AppMethodBeat.m2505o(119361);
        return true;
    }
}
