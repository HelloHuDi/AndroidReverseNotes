package p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0029b;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p044k.C17310h;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p044k.C41441f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.j.a.a.a */
public class C25187a implements C0026g {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C25187a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final C41441f BHN;

    static {
        AppMethodBeat.m2504i(122333);
        AppMethodBeat.m2505o(122333);
    }

    private final List<C44869c> ejT() {
        AppMethodBeat.m2504i(122334);
        List list = (List) C17310h.m26799a(this.BHN, eQB[0]);
        AppMethodBeat.m2505o(122334);
        return list;
    }

    public C25187a(C25212i c25212i, C31214a<? extends List<? extends C44869c>> c31214a) {
        C25052j.m39376p(c25212i, "storageManager");
        C25052j.m39376p(c31214a, "compute");
        AppMethodBeat.m2504i(122337);
        this.BHN = c25212i.mo31373i(c31214a);
        AppMethodBeat.m2505o(122337);
    }

    /* renamed from: i */
    public final C44869c mo53i(C8174b c8174b) {
        AppMethodBeat.m2504i(122338);
        C25052j.m39376p(c8174b, "fqName");
        C44869c a = C0029b.m32a(this, c8174b);
        AppMethodBeat.m2505o(122338);
        return a;
    }

    /* renamed from: j */
    public final boolean mo55j(C8174b c8174b) {
        AppMethodBeat.m2504i(122339);
        C25052j.m39376p(c8174b, "fqName");
        boolean b = C0029b.m33b(this, c8174b);
        AppMethodBeat.m2505o(122339);
        return b;
    }

    public boolean isEmpty() {
        AppMethodBeat.m2504i(122335);
        boolean isEmpty = ejT().isEmpty();
        AppMethodBeat.m2505o(122335);
        return isEmpty;
    }

    public Iterator<C44869c> iterator() {
        AppMethodBeat.m2504i(122336);
        Iterator it = ejT().iterator();
        AppMethodBeat.m2505o(122336);
        return it;
    }
}
