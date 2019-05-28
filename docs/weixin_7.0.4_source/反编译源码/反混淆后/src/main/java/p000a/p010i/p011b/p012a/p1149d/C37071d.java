package p000a.p010i.p011b.p012a.p1149d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.d.d */
final class C37071d<V> {
    private static final C37071d<Object> BNG = new C37071d(C25247c.BND);
    private final C25247c<V> BNH;

    static {
        AppMethodBeat.m2504i(123003);
        AppMethodBeat.m2505o(123003);
    }

    public static <V> C37071d<V> ekG() {
        return BNG;
    }

    private C37071d(C25247c<V> c25247c) {
        this.BNH = c25247c;
    }

    /* renamed from: a */
    private C37071d<V> m62025a(C25247c<V> c25247c) {
        AppMethodBeat.m2504i(123000);
        if (c25247c == this.BNH) {
            AppMethodBeat.m2505o(123000);
            return this;
        }
        C37071d<V> thisR = new C37071d(c25247c);
        AppMethodBeat.m2505o(123000);
        return thisR;
    }

    public final V get(int i) {
        AppMethodBeat.m2504i(123001);
        Object obj = this.BNH.get((long) i);
        AppMethodBeat.m2505o(123001);
        return obj;
    }

    /* renamed from: t */
    public final C37071d<V> mo59103t(int i, V v) {
        AppMethodBeat.m2504i(123002);
        C37071d a = m62025a(this.BNH.mo42093b((long) i, v));
        AppMethodBeat.m2505o(123002);
        return a;
    }
}
