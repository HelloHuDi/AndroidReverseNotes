package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;
import p000a.p001a.C17115v;
import p000a.p001a.C44629x;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44887q;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8117n;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.c.a.b */
public interface C41406b {

    /* renamed from: a.i.b.a.c.d.a.c.a.b$a */
    public static final class C36973a implements C41406b {
        public static final C36973a BnM = new C36973a();

        static {
            AppMethodBeat.m2504i(119861);
            AppMethodBeat.m2505o(119861);
        }

        private C36973a() {
        }

        /* renamed from: k */
        public final /* synthetic */ Collection mo58977k(C37022f c37022f) {
            AppMethodBeat.m2504i(119859);
            C25052j.m39376p(c37022f, "name");
            Collection collection = C17115v.AUP;
            AppMethodBeat.m2505o(119859);
            return collection;
        }

        /* renamed from: l */
        public final C8117n mo58978l(C37022f c37022f) {
            AppMethodBeat.m2504i(119860);
            C25052j.m39376p(c37022f, "name");
            AppMethodBeat.m2505o(119860);
            return null;
        }

        public final Set<C37022f> ebn() {
            return C44629x.AUR;
        }

        public final Set<C37022f> ebo() {
            return C44629x.AUR;
        }
    }

    Set<C37022f> ebn();

    Set<C37022f> ebo();

    /* renamed from: k */
    Collection<C44887q> mo58977k(C37022f c37022f);

    /* renamed from: l */
    C8117n mo58978l(C37022f c37022f);
}
