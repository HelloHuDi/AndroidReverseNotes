package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p050j.C17348n;
import p000a.p050j.C44937h;

/* renamed from: a.i.b.a.c.b.a.k */
public final class C31630k implements C0026g {
    private final List<C0026g> BfS;

    /* renamed from: a.i.b.a.c.b.a.k$a */
    static final class C31628a extends C25053k implements C17126b<C0026g, C44869c> {
        final /* synthetic */ C8174b BfT;

        C31628a(C8174b c8174b) {
            this.BfT = c8174b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119348);
            C0026g c0026g = (C0026g) obj;
            C25052j.m39376p(c0026g, "it");
            C44869c i = c0026g.mo53i(this.BfT);
            AppMethodBeat.m2505o(119348);
            return i;
        }
    }

    /* renamed from: a.i.b.a.c.b.a.k$b */
    static final class C31629b extends C25053k implements C17126b<C0026g, C44937h<? extends C44869c>> {
        public static final C31629b BfU = new C31629b();

        static {
            AppMethodBeat.m2504i(119350);
            AppMethodBeat.m2505o(119350);
        }

        C31629b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119349);
            C0026g c0026g = (C0026g) obj;
            C25052j.m39376p(c0026g, "it");
            C44937h t = C25035t.m39359t(c0026g);
            AppMethodBeat.m2505o(119349);
            return t;
        }
    }

    public C31630k(List<? extends C0026g> list) {
        C25052j.m39376p(list, "delegates");
        AppMethodBeat.m2504i(119355);
        this.BfS = list;
        AppMethodBeat.m2505o(119355);
    }

    public C31630k(C0026g... c0026gArr) {
        C25052j.m39376p(c0026gArr, "delegates");
        this(C36913i.m61684Q(c0026gArr));
        AppMethodBeat.m2504i(119356);
        AppMethodBeat.m2505o(119356);
    }

    public final boolean isEmpty() {
        AppMethodBeat.m2504i(119351);
        Iterable<C0026g> iterable = this.BfS;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (C0026g isEmpty : iterable) {
                if (!isEmpty.isEmpty()) {
                    AppMethodBeat.m2505o(119351);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(119351);
        return true;
    }

    /* renamed from: j */
    public final boolean mo55j(C8174b c8174b) {
        AppMethodBeat.m2504i(119352);
        C25052j.m39376p(c8174b, "fqName");
        for (C0026g j : C25035t.m39359t(this.BfS)) {
            if (j.mo55j(c8174b)) {
                AppMethodBeat.m2505o(119352);
                return true;
            }
        }
        AppMethodBeat.m2505o(119352);
        return false;
    }

    /* renamed from: i */
    public final C44869c mo53i(C8174b c8174b) {
        Object next;
        AppMethodBeat.m2504i(119353);
        C25052j.m39376p(c8174b, "fqName");
        C44937h e = C17348n.m26866e(C25035t.m39359t(this.BfS), new C31628a(c8174b));
        C25052j.m39376p(e, "receiver$0");
        Iterator it = e.iterator();
        if (it.hasNext()) {
            next = it.next();
        } else {
            next = null;
        }
        C44869c c44869c = (C44869c) next;
        AppMethodBeat.m2505o(119353);
        return c44869c;
    }

    public final Iterator<C44869c> iterator() {
        AppMethodBeat.m2504i(119354);
        Iterator it = C17348n.m26861c(C25035t.m39359t(this.BfS), C31629b.BfU).iterator();
        AppMethodBeat.m2505o(119354);
        return it;
    }
}
