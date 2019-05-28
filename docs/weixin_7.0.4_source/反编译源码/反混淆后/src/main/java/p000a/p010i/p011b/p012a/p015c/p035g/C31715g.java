package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8180f;

/* renamed from: a.i.b.a.c.g.g */
public final class C31715g {
    private static final C31715g BzB = new C31715g((byte) 0);
    private static volatile boolean Bzz = false;
    final Map<C0119a, C8180f<?, ?>> BzA;

    /* renamed from: a.i.b.a.c.g.g$a */
    static final class C0119a {
        private final int number;
        private final Object object;

        C0119a(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(121491);
            int identityHashCode = (System.identityHashCode(this.object) * CdnLogic.kBizGeneric) + this.number;
            AppMethodBeat.m2505o(121491);
            return identityHashCode;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C0119a)) {
                return false;
            }
            C0119a c0119a = (C0119a) obj;
            if (this.object == c0119a.object && this.number == c0119a.number) {
                return true;
            }
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(121496);
        AppMethodBeat.m2505o(121496);
    }

    public static C31715g eie() {
        AppMethodBeat.m2504i(121492);
        C31715g c31715g = new C31715g();
        AppMethodBeat.m2505o(121492);
        return c31715g;
    }

    public static C31715g eif() {
        return BzB;
    }

    /* renamed from: a */
    public final void mo51696a(C8180f<?, ?> c8180f) {
        AppMethodBeat.m2504i(121493);
        this.BzA.put(new C0119a(c8180f.BzS, c8180f.BzU.number), c8180f);
        AppMethodBeat.m2505o(121493);
    }

    C31715g() {
        AppMethodBeat.m2504i(121494);
        this.BzA = new HashMap();
        AppMethodBeat.m2505o(121494);
    }

    private C31715g(byte b) {
        AppMethodBeat.m2504i(121495);
        this.BzA = Collections.emptyMap();
        AppMethodBeat.m2505o(121495);
    }
}
