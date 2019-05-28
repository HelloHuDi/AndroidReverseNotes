package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p030f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0029b;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44869c;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.f.b */
final class C17189b implements C0026g {
    private final C8174b Bpz;

    public C17189b(C8174b c8174b) {
        C25052j.m39376p(c8174b, "fqNameToMatch");
        AppMethodBeat.m2504i(120089);
        this.Bpz = c8174b;
        AppMethodBeat.m2505o(120089);
    }

    /* renamed from: i */
    public final /* synthetic */ C44869c mo53i(C8174b c8174b) {
        C25117a c25117a;
        AppMethodBeat.m2504i(120087);
        C25052j.m39376p(c8174b, "fqName");
        if (C25052j.m39373j(c8174b, this.Bpz)) {
            c25117a = C25117a.Bpy;
        } else {
            c25117a = null;
        }
        C44869c c44869c = c25117a;
        AppMethodBeat.m2505o(120087);
        return c44869c;
    }

    /* renamed from: j */
    public final boolean mo55j(C8174b c8174b) {
        AppMethodBeat.m2504i(120090);
        C25052j.m39376p(c8174b, "fqName");
        boolean b = C0029b.m33b(this, c8174b);
        AppMethodBeat.m2505o(120090);
        return b;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final Iterator<C44869c> iterator() {
        AppMethodBeat.m2504i(120088);
        Iterator it = C17115v.AUP.iterator();
        AppMethodBeat.m2505o(120088);
        return it;
    }
}
