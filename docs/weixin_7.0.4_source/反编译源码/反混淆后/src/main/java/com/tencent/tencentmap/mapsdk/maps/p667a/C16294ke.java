package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ke */
public final class C16294ke {
    /* renamed from: a */
    public static final Comparator<C16303kw<?>> f3461a = C16294ke.m25102a(C31073kh.f14310a);
    /* renamed from: b */
    public static final Comparator<C16303kw<?>> f3462b = new C162931();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ke$1 */
    static class C162931 implements Comparator<C16303kw<?>> {
        C162931() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(100208);
            int a = mo29546a((C16303kw) obj, (C16303kw) obj2);
            AppMethodBeat.m2505o(100208);
            return a;
        }

        /* renamed from: a */
        public final int mo29546a(C16303kw<?> c16303kw, C16303kw<?> c16303kw2) {
            AppMethodBeat.m2504i(100207);
            int compareTo = Float.valueOf(c16303kw.mo29564c()).compareTo(Float.valueOf(c16303kw2.mo29564c()));
            AppMethodBeat.m2505o(100207);
            return compareTo;
        }
    }

    static {
        AppMethodBeat.m2504i(100217);
        AppMethodBeat.m2505o(100217);
    }

    /* renamed from: a */
    public static <T extends C31074kv> Comparator<C31074kv> m25101a(C16304ky c16304ky) {
        AppMethodBeat.m2504i(100213);
        Comparator a = C16294ke.m25102a(C31073kh.m50130a(c16304ky));
        AppMethodBeat.m2505o(100213);
        return a;
    }

    /* renamed from: b */
    public static Comparator<C31074kv> m25104b(final C16304ky c16304ky) {
        AppMethodBeat.m2504i(100214);
        C162962 c162962 = new Comparator<C31074kv>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(100210);
                int a = mo29549a((C31074kv) obj, (C31074kv) obj2);
                AppMethodBeat.m2505o(100210);
                return a;
            }

            /* renamed from: a */
            public final int mo29549a(C31074kv c31074kv, C31074kv c31074kv2) {
                AppMethodBeat.m2504i(100209);
                int compareTo = Float.valueOf(c31074kv.mo29553b().mo29565a().mo29567b(c16304ky).mo29574g()).compareTo(Float.valueOf(c31074kv2.mo29553b().mo29565a().mo29567b(c16304ky).mo29574g()));
                AppMethodBeat.m2505o(100209);
                return compareTo;
            }
        };
        AppMethodBeat.m2505o(100214);
        return c162962;
    }

    /* renamed from: a */
    public static <R, T extends Comparable<T>> Comparator<R> m25102a(final C31081mf<R, T> c31081mf) {
        AppMethodBeat.m2504i(100215);
        C162973 c162973 = new Comparator<R>() {
            public final int compare(R r, R r2) {
                AppMethodBeat.m2504i(100211);
                int compareTo = ((Comparable) c31081mf.mo12522a(r)).compareTo(c31081mf.mo12522a(r2));
                AppMethodBeat.m2505o(100211);
                return compareTo;
            }
        };
        AppMethodBeat.m2505o(100215);
        return c162973;
    }

    /* renamed from: a */
    public static <T> Comparator<T> m25103a(final Comparator<T>... comparatorArr) {
        AppMethodBeat.m2504i(100216);
        C162954 c162954 = new Comparator<T>() {
            public final int compare(T t, T t2) {
                AppMethodBeat.m2504i(100212);
                for (Comparator compare : comparatorArr) {
                    int compare2 = compare.compare(t, t2);
                    if (compare2 != 0) {
                        AppMethodBeat.m2505o(100212);
                        return compare2;
                    }
                }
                AppMethodBeat.m2505o(100212);
                return 0;
            }
        };
        AppMethodBeat.m2505o(100216);
        return c162954;
    }
}
