package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p025a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41399au;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;

/* renamed from: a.i.b.a.c.d.a.a.k */
public interface C8091k {
    public static final C8091k Bmr = new C80921();

    /* renamed from: a.i.b.a.c.d.a.a.k$1 */
    static class C80921 implements C8091k {
        C80921() {
        }

        /* renamed from: a */
        public final C8093a mo17917a(C46867w c46867w, List<C41399au> list, List<C36955ar> list2) {
            AppMethodBeat.m2504i(119780);
            C8093a c8093a = new C8093a(c46867w, list, list2, Collections.emptyList());
            AppMethodBeat.m2505o(119780);
            return c8093a;
        }

        public final void ebl() {
            AppMethodBeat.m2504i(119781);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            AppMethodBeat.m2505o(119781);
            throw unsupportedOperationException;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.a.k$a */
    public static class C8093a {
        public final List<C36955ar> BeK;
        public final boolean Bia;
        public final C46867w Bji;
        public final C46867w Bms = null;
        public final List<C41399au> Bmt;
        public final List<String> Bmu;

        public C8093a(C46867w c46867w, List<C41399au> list, List<C36955ar> list2, List<String> list3) {
            this.Bji = c46867w;
            this.Bmt = list;
            this.BeK = list2;
            this.Bmu = list3;
            this.Bia = false;
        }
    }

    /* renamed from: a */
    C8093a mo17917a(C46867w c46867w, List<C41399au> list, List<C36955ar> list2);

    void ebl();
}
