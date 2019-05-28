package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class i {
    public static void a(String str, String str2, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(131348);
        if (appBrandStatObject == null) {
            AppMethodBeat.o(131348);
            return;
        }
        final String str3 = appBrandStatObject.hQF;
        if (bo.isNullOrNil(str3)) {
            AppMethodBeat.o(131348);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final String str4 = str;
        final String str5 = str2;
        final AppBrandStatObject appBrandStatObject2 = appBrandStatObject;
        g.a(str, new c() {
            public final void a(d dVar) {
                AppMethodBeat.i(131344);
                a(dVar, str4, str5, str3);
                AppMethodBeat.o(131344);
            }

            public final void onDestroy() {
                AppMethodBeat.i(131345);
                a(g.wV(str4), str4, str5, str3);
                AppMethodBeat.o(131345);
            }

            private void a(d dVar, String str, String str2, String str3) {
                AppMethodBeat.i(131346);
                i.a(dVar, str, str2, str3, bo.anU() - currentTimeMillis);
                appBrandStatObject2.hQF = null;
                g.b(str, this);
                AppMethodBeat.o(131346);
            }
        });
        AppMethodBeat.o(131348);
    }

    public static void b(String str, String str2, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(131349);
        if (appBrandStatObject == null) {
            AppMethodBeat.o(131349);
        } else if (bo.isNullOrNil(appBrandStatObject.hQF)) {
            AppMethodBeat.o(131349);
        } else {
            a(4, str, str2, appBrandStatObject.hQF, 0);
            AppMethodBeat.o(131349);
        }
    }

    private static void a(int i, String str, String str2, String str3, long j) {
        AppMethodBeat.i(131350);
        long anU = bo.anU();
        String gE = at.gE(ah.getContext());
        String str4 = str3 + "," + str2 + "," + str + "," + anU + "," + j + "," + i + "," + aEn() + "," + gE + "," + at.gF(ah.getContext()) + ",,";
        ab.v("MicroMsg.MiniProgramNavigatorAdReportHelper", "closeType:%d stayTime:%d", Integer.valueOf(i), Long.valueOf(j));
        AdReportCgiHelper.a(16004, str4, null);
        AppMethodBeat.o(131350);
    }

    private static int aEn() {
        AppMethodBeat.i(131351);
        switch (at.getNetType(ah.getContext())) {
            case -1:
                AppMethodBeat.o(131351);
                return 255;
            case 0:
                AppMethodBeat.o(131351);
                return 1;
            case 1:
            case 6:
            case 8:
                AppMethodBeat.o(131351);
                return 3;
            case 2:
            case 5:
            case 7:
                AppMethodBeat.o(131351);
                return 2;
            case 3:
            case 4:
                AppMethodBeat.o(131351);
                return 4;
            case 10:
                AppMethodBeat.o(131351);
                return 5;
            default:
                AppMethodBeat.o(131351);
                return 6;
        }
    }
}
