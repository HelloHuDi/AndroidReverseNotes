package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;
import p000a.p001a.C44629x;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C8085a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.i.e.h */
public interface C31746h extends C25177j {
    public static final C17286a BGd = C17286a.BGf;

    /* renamed from: a.i.b.a.c.i.e.h$a */
    public static final class C17286a {
        private static final C17126b<C37022f, Boolean> BGe = C17287a.BGg;
        static final /* synthetic */ C17286a BGf = new C17286a();

        /* renamed from: a.i.b.a.c.i.e.h$a$a */
        static final class C17287a extends C25053k implements C17126b<C37022f, Boolean> {
            public static final C17287a BGg = new C17287a();

            static {
                AppMethodBeat.m2504i(122196);
                AppMethodBeat.m2505o(122196);
            }

            C17287a() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122195);
                C25052j.m39376p((C37022f) obj, "it");
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.m2505o(122195);
                return bool;
            }
        }

        static {
            AppMethodBeat.m2504i(122197);
            AppMethodBeat.m2505o(122197);
        }

        private C17286a() {
        }

        public static C17126b<C37022f, Boolean> ejN() {
            return BGe;
        }
    }

    /* renamed from: a.i.b.a.c.i.e.h$b */
    public static final class C17288b extends C37037i {
        public static final C17288b BGh = new C17288b();

        static {
            AppMethodBeat.m2504i(122198);
            AppMethodBeat.m2505o(122198);
        }

        private C17288b() {
        }

        public final Set<C37022f> eau() {
            return C44629x.AUR;
        }

        public final Set<C37022f> eav() {
            return C44629x.AUR;
        }
    }

    /* renamed from: a */
    Collection<C31220ah> mo219a(C37022f c37022f, C8085a c8085a);

    /* renamed from: b */
    Collection<C41397al> mo221b(C37022f c37022f, C8085a c8085a);

    Set<C37022f> eau();

    Set<C37022f> eav();
}
