package p000a.p010i.p011b.p012a.p1149d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.d.b */
public final class C17333b<K, V> {
    private static final C17333b<Object, Object> BNB = new C17333b(C37071d.ekG(), 0);
    private final C37071d<C25245a<C31789e<K, V>>> BNC;
    private final int size;

    static {
        AppMethodBeat.m2504i(122993);
        AppMethodBeat.m2505o(122993);
    }

    public static <K, V> C17333b<K, V> ekF() {
        return BNB;
    }

    private C17333b(C37071d<C25245a<C31789e<K, V>>> c37071d, int i) {
        this.BNC = c37071d;
        this.size = i;
    }

    /* renamed from: K */
    public final C17333b<K, V> mo31403K(K k, V v) {
        AppMethodBeat.m2504i(122990);
        C25245a UV = mo31404UV(k.hashCode());
        int i = UV.size;
        int a = C17333b.m26845a(UV, k);
        if (a != -1) {
            UV = UV.mo42087UT(a);
        }
        UV = UV.mo42088dZ(new C31789e(k, v));
        C17333b c17333b = new C17333b(this.BNC.mo59103t(k.hashCode(), UV), UV.size + (this.size - i));
        AppMethodBeat.m2505o(122990);
        return c17333b;
    }

    /* renamed from: UV */
    public final C25245a<C31789e<K, V>> mo31404UV(int i) {
        AppMethodBeat.m2504i(122991);
        C25245a<C31789e<K, V>> c25245a = (C25245a) this.BNC.get(i);
        if (c25245a == null) {
            C25245a ekE = C25245a.ekE();
            AppMethodBeat.m2505o(122991);
            return ekE;
        }
        AppMethodBeat.m2505o(122991);
        return c25245a;
    }

    /* renamed from: a */
    private static <K, V> int m26845a(C25245a<C31789e<K, V>> c25245a, Object obj) {
        AppMethodBeat.m2504i(122992);
        int i = 0;
        C25245a c25245a2;
        while (c25245a2 != null && c25245a2.size > 0) {
            if (((C31789e) c25245a2.first).aCx.equals(obj)) {
                AppMethodBeat.m2505o(122992);
                return i;
            }
            c25245a2 = c25245a2.BNz;
            i++;
        }
        AppMethodBeat.m2505o(122992);
        return -1;
    }
}
