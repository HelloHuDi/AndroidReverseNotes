package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kh {
    public static final mf<kw<? extends kv>, Double> a = new mf<kw<? extends kv>, Double>() {
        public final Double a(kw<? extends kv> kwVar) {
            AppMethodBeat.i(100224);
            Double valueOf = Double.valueOf((double) kwVar.a().b().a().c(kwVar.b().b().a()));
            AppMethodBeat.o(100224);
            return valueOf;
        }
    };

    static {
        AppMethodBeat.i(100229);
        AppMethodBeat.o(100229);
    }

    public static mf<kv, Double> a(final ky kyVar) {
        AppMethodBeat.i(100228);
        AnonymousClass2 anonymousClass2 = new mf<kv, Double>() {
            public final Double a(kv kvVar) {
                AppMethodBeat.i(100226);
                Double valueOf = Double.valueOf((double) (kvVar.b().a().b(kyVar).g() - kvVar.b().a().g()));
                AppMethodBeat.o(100226);
                return valueOf;
            }
        };
        AppMethodBeat.o(100228);
        return anonymousClass2;
    }
}
