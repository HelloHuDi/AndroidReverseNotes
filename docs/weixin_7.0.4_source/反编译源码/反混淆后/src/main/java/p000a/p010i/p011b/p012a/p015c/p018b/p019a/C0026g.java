package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.b.a.g */
public interface C0026g extends C41374a, Iterable<C44869c> {
    public static final C0027a BfJ = C0027a.BfL;

    /* renamed from: a.i.b.a.c.b.a.g$a */
    public static final class C0027a {
        private static final C0026g BfK = new C0028a();
        static final /* synthetic */ C0027a BfL = new C0027a();

        /* renamed from: a.i.b.a.c.b.a.g$a$a */
        public static final class C0028a implements C0026g {
            C0028a() {
            }

            /* renamed from: i */
            public final /* synthetic */ C44869c mo53i(C8174b c8174b) {
                AppMethodBeat.m2504i(119329);
                C25052j.m39376p(c8174b, "fqName");
                AppMethodBeat.m2505o(119329);
                return null;
            }

            /* renamed from: j */
            public final boolean mo55j(C8174b c8174b) {
                AppMethodBeat.m2504i(119331);
                C25052j.m39376p(c8174b, "fqName");
                boolean b = C0029b.m33b(this, c8174b);
                AppMethodBeat.m2505o(119331);
                return b;
            }

            public final boolean isEmpty() {
                return true;
            }

            public final String toString() {
                return "EMPTY";
            }

            public final Iterator<C44869c> iterator() {
                AppMethodBeat.m2504i(119330);
                Iterator it = C17115v.AUP.iterator();
                AppMethodBeat.m2505o(119330);
                return it;
            }
        }

        static {
            AppMethodBeat.m2504i(119333);
            AppMethodBeat.m2505o(119333);
        }

        private C0027a() {
        }

        public static C0026g eai() {
            return BfK;
        }

        /* renamed from: fS */
        public static C0026g m29fS(List<? extends C44869c> list) {
            AppMethodBeat.m2504i(119332);
            C25052j.m39376p(list, "annotations");
            C0026g c0026g;
            if (list.isEmpty()) {
                c0026g = BfK;
                AppMethodBeat.m2505o(119332);
                return c0026g;
            }
            c0026g = new C31627h(list);
            AppMethodBeat.m2505o(119332);
            return c0026g;
        }
    }

    /* renamed from: a.i.b.a.c.b.a.g$b */
    public static final class C0029b {
        /* renamed from: a */
        public static C44869c m32a(C0026g c0026g, C8174b c8174b) {
            Object obj;
            AppMethodBeat.m2504i(119334);
            C25052j.m39376p(c8174b, "fqName");
            for (Object next : c0026g) {
                if (C25052j.m39373j(((C44869c) next).dZF(), c8174b)) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            C44869c c44869c = (C44869c) obj;
            AppMethodBeat.m2505o(119334);
            return c44869c;
        }

        /* renamed from: b */
        public static boolean m33b(C0026g c0026g, C8174b c8174b) {
            AppMethodBeat.m2504i(119335);
            C25052j.m39376p(c8174b, "fqName");
            if (c0026g.mo53i(c8174b) != null) {
                AppMethodBeat.m2505o(119335);
                return true;
            }
            AppMethodBeat.m2505o(119335);
            return false;
        }
    }

    /* renamed from: i */
    C44869c mo53i(C8174b c8174b);

    boolean isEmpty();

    /* renamed from: j */
    boolean mo55j(C8174b c8174b);
}
