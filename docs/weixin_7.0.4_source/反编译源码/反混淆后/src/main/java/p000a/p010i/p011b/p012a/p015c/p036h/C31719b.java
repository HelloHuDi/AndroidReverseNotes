package p000a.p010i.p011b.p012a.p015c.p036h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.C44845ai;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.C8203d;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;

/* renamed from: a.i.b.a.c.h.b */
public interface C31719b {

    /* renamed from: a.i.b.a.c.h.b$b */
    public static final class C31720b implements C31719b {
        public static final C31720b BBE = new C31720b();

        static {
            AppMethodBeat.m2504i(121702);
            AppMethodBeat.m2505o(121702);
        }

        private C31720b() {
        }

        /* renamed from: a */
        public final String mo51713a(C0036h c0036h, C31724c c31724c) {
            AppMethodBeat.m2504i(121701);
            C25052j.m39376p(c0036h, "classifier");
            C25052j.m39376p(c31724c, "renderer");
            String b;
            if (c0036h instanceof C36955ar) {
                C37022f dZg = ((C36955ar) c0036h).dZg();
                C25052j.m39375o(dZg, "classifier.name");
                b = c31724c.mo13664b(dZg, false);
                AppMethodBeat.m2505o(121701);
                return b;
            }
            ArrayList arrayList = new ArrayList();
            C31642l c31642l = c0036h;
            do {
                arrayList.add(c31642l.dZg());
                c31642l = c31642l.dXW();
            } while (c31642l instanceof C46865e);
            List list = arrayList;
            C25052j.m39376p(list, "receiver$0");
            b = C8198q.m14452fZ(new C44845ai(list));
            AppMethodBeat.m2505o(121701);
            return b;
        }
    }

    /* renamed from: a.i.b.a.c.h.b$a */
    public static final class C31721a implements C31719b {
        public static final C31721a BBD = new C31721a();

        static {
            AppMethodBeat.m2504i(121700);
            AppMethodBeat.m2505o(121700);
        }

        private C31721a() {
        }

        /* renamed from: a */
        public final String mo51713a(C0036h c0036h, C31724c c31724c) {
            AppMethodBeat.m2504i(121699);
            C25052j.m39376p(c0036h, "classifier");
            C25052j.m39376p(c31724c, "renderer");
            String b;
            if (c0036h instanceof C36955ar) {
                C37022f dZg = ((C36955ar) c0036h).dZg();
                C25052j.m39375o(dZg, "classifier.name");
                b = c31724c.mo13664b(dZg, false);
                AppMethodBeat.m2505o(121699);
                return b;
            }
            C8175c n = C8203d.m14486n(c0036h);
            C25052j.m39375o(n, "DescriptorUtils.getFqName(classifier)");
            b = c31724c.mo13666f(n);
            AppMethodBeat.m2505o(121699);
            return b;
        }
    }

    /* renamed from: a.i.b.a.c.h.b$c */
    public static final class C31722c implements C31719b {
        public static final C31722c BBF = new C31722c();

        static {
            AppMethodBeat.m2504i(121706);
            AppMethodBeat.m2505o(121706);
        }

        private C31722c() {
        }

        /* renamed from: a */
        public final String mo51713a(C0036h c0036h, C31724c c31724c) {
            AppMethodBeat.m2504i(121703);
            C25052j.m39376p(c0036h, "classifier");
            C25052j.m39376p(c31724c, "renderer");
            String a = m51346a(c0036h);
            AppMethodBeat.m2505o(121703);
            return a;
        }

        /* renamed from: a */
        private final String m51346a(C0036h c0036h) {
            AppMethodBeat.m2504i(121704);
            C37022f dZg = c0036h.dZg();
            C25052j.m39375o(dZg, "descriptor.name");
            String y = C8198q.m14454y(dZg);
            if (c0036h instanceof C36955ar) {
                AppMethodBeat.m2505o(121704);
                return y;
            }
            C31642l dXW = c0036h.dXW();
            C25052j.m39375o(dXW, "descriptor.containingDeclaration");
            String j = m51347j(dXW);
            if (j == null || (C25052j.m39373j(j, "") ^ 1) == 0) {
                AppMethodBeat.m2505o(121704);
                return y;
            }
            y = j + "." + y;
            AppMethodBeat.m2505o(121704);
            return y;
        }

        /* renamed from: j */
        private final String m51347j(C31642l c31642l) {
            AppMethodBeat.m2504i(121705);
            String a;
            if (c31642l instanceof C46865e) {
                a = m51346a((C0036h) c31642l);
                AppMethodBeat.m2505o(121705);
                return a;
            } else if (c31642l instanceof C36953ab) {
                C8175c c8175c = ((C36953ab) c31642l).dZF().ByQ;
                C25052j.m39375o(c8175c, "descriptor.fqName.toUnsafe()");
                a = C8198q.m14453g(c8175c);
                AppMethodBeat.m2505o(121705);
                return a;
            } else {
                AppMethodBeat.m2505o(121705);
                return null;
            }
        }
    }

    /* renamed from: a */
    String mo51713a(C0036h c0036h, C31724c c31724c);
}
