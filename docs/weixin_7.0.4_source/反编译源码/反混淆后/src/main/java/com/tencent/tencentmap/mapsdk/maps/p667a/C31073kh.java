package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kh */
public final class C31073kh {
    /* renamed from: a */
    public static final C31081mf<C16303kw<? extends C31074kv>, Double> f14310a = new C162991();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kh$1 */
    static class C162991 implements C31081mf<C16303kw<? extends C31074kv>, Double> {
        C162991() {
        }

        /* renamed from: a */
        public final Double mo29557a(C16303kw<? extends C31074kv> c16303kw) {
            AppMethodBeat.m2504i(100224);
            Double valueOf = Double.valueOf((double) c16303kw.mo29562a().mo29553b().mo29565a().mo29569c(c16303kw.mo29563b().mo29553b().mo29565a()));
            AppMethodBeat.m2505o(100224);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.m2504i(100229);
        AppMethodBeat.m2505o(100229);
    }

    /* renamed from: a */
    public static C31081mf<C31074kv, Double> m50130a(final C16304ky c16304ky) {
        AppMethodBeat.m2504i(100228);
        C163002 c163002 = new C31081mf<C31074kv, Double>() {
            /* renamed from: a */
            public final Double mo29558a(C31074kv c31074kv) {
                AppMethodBeat.m2504i(100226);
                Double valueOf = Double.valueOf((double) (c31074kv.mo29553b().mo29565a().mo29567b(c16304ky).mo29574g() - c31074kv.mo29553b().mo29565a().mo29574g()));
                AppMethodBeat.m2505o(100226);
                return valueOf;
            }
        };
        AppMethodBeat.m2505o(100228);
        return c163002;
    }
}
