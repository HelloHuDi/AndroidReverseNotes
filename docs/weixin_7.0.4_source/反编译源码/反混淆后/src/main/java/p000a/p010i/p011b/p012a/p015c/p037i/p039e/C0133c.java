package p000a.p010i.p011b.p012a.p015c.p037i.p039e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C0136d.C0137a;

/* renamed from: a.i.b.a.c.i.e.c */
public abstract class C0133c {

    /* renamed from: a.i.b.a.c.i.e.c$b */
    public static final class C0134b extends C0133c {
        public static final C0134b BFx = new C0134b();

        static {
            AppMethodBeat.m2504i(122177);
            AppMethodBeat.m2505o(122177);
        }

        private C0134b() {
        }

        public final int ejB() {
            return 0;
        }
    }

    /* renamed from: a.i.b.a.c.i.e.c$a */
    public static final class C0135a extends C0133c {
        private static final int BFv;
        public static final C0135a BFw = new C0135a();

        static {
            AppMethodBeat.m2504i(122176);
            C0137a c0137a = C0136d.BFX;
            int ejJ = C0136d.BFH;
            C0137a c0137a2 = C0136d.BFX;
            int ejH = C0136d.BFF;
            C0137a c0137a3 = C0136d.BFX;
            BFv = ejJ & ((ejH | C0136d.BFG) ^ -1);
            AppMethodBeat.m2505o(122176);
        }

        private C0135a() {
        }

        public final int ejB() {
            return BFv;
        }
    }

    public abstract int ejB();

    public String toString() {
        return getClass().getSimpleName();
    }
}
