package p000a.p010i.p011b.p012a.p015c.p018b.p775b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;

/* renamed from: a.i.b.a.c.b.b.c */
public interface C25083c {

    /* renamed from: a.i.b.a.c.b.b.c$b */
    public static final class C8064b implements C25083c {
        public static final C8064b BgX = new C8064b();

        static {
            AppMethodBeat.m2504i(119378);
            AppMethodBeat.m2505o(119378);
        }

        private C8064b() {
        }

        /* renamed from: a */
        public final boolean mo17862a(C46865e c46865e, C41397al c41397al) {
            AppMethodBeat.m2504i(119377);
            C25052j.m39376p(c46865e, "classDescriptor");
            C25052j.m39376p(c41397al, "functionDescriptor");
            if (c41397al.dYn().mo55j(C8065d.eaj())) {
                AppMethodBeat.m2505o(119377);
                return false;
            }
            AppMethodBeat.m2505o(119377);
            return true;
        }
    }

    /* renamed from: a.i.b.a.c.b.b.c$a */
    public static final class C25084a implements C25083c {
        public static final C25084a BgW = new C25084a();

        static {
            AppMethodBeat.m2504i(119376);
            AppMethodBeat.m2505o(119376);
        }

        private C25084a() {
        }

        /* renamed from: a */
        public final boolean mo17862a(C46865e c46865e, C41397al c41397al) {
            AppMethodBeat.m2504i(119375);
            C25052j.m39376p(c46865e, "classDescriptor");
            C25052j.m39376p(c41397al, "functionDescriptor");
            AppMethodBeat.m2505o(119375);
            return true;
        }
    }

    /* renamed from: a */
    boolean mo17862a(C46865e c46865e, C41397al c41397al);
}
