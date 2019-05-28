package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.n.j */
public final class C37069j {
    private static final Object AYw = new C370701();
    public static volatile boolean BNx = false;

    /* renamed from: a.i.b.a.c.n.j$b */
    public static class C8264b extends RuntimeException {
        public C8264b(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    /* renamed from: a.i.b.a.c.n.j$a */
    static final class C25244a {
        final Throwable xEP;

        /* synthetic */ C25244a(Throwable th, byte b) {
            this(th);
        }

        private C25244a(Throwable th) {
            this.xEP = th;
        }

        public final String toString() {
            AppMethodBeat.m2504i(122974);
            String th = this.xEP.toString();
            AppMethodBeat.m2505o(122974);
            return th;
        }
    }

    /* renamed from: a.i.b.a.c.n.j$1 */
    static class C370701 {
        C370701() {
        }

        public final String toString() {
            return "NULL_VALUE";
        }
    }

    static {
        AppMethodBeat.m2504i(122978);
        AppMethodBeat.m2505o(122978);
    }

    /* renamed from: dW */
    public static <V> Object m62021dW(V v) {
        if (v == null) {
            return AYw;
        }
        return v;
    }

    /* renamed from: s */
    public static Object m62024s(Throwable th) {
        AppMethodBeat.m2504i(122975);
        C25244a c25244a = new C25244a(th, (byte) 0);
        AppMethodBeat.m2505o(122975);
        return c25244a;
    }

    /* renamed from: dX */
    public static <V> V m62022dX(Object obj) {
        AppMethodBeat.m2504i(122976);
        V dY = C37069j.m62023dY(obj);
        if (dY == AYw) {
            AppMethodBeat.m2505o(122976);
            return null;
        }
        AppMethodBeat.m2505o(122976);
        return dY;
    }

    /* renamed from: dY */
    public static <V> V m62023dY(Object obj) {
        AppMethodBeat.m2504i(122977);
        if (obj instanceof C25244a) {
            Throwable th = ((C25244a) obj).xEP;
            if (BNx && C0171c.m295r(th)) {
                C8264b c8264b = new C8264b(th);
                AppMethodBeat.m2505o(122977);
                throw c8264b;
            }
            C25052j.m39376p(th, "e");
            AppMethodBeat.m2505o(122977);
            throw th;
        }
        AppMethodBeat.m2505o(122977);
        return obj;
    }
}
