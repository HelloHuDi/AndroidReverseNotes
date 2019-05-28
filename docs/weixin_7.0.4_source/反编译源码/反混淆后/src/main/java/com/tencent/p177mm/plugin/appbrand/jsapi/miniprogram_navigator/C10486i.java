package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i */
public final class C10486i {
    /* renamed from: a */
    public static void m18200a(String str, String str2, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(131348);
        if (appBrandStatObject == null) {
            AppMethodBeat.m2505o(131348);
            return;
        }
        final String str3 = appBrandStatObject.hQF;
        if (C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(131348);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final String str4 = str;
        final String str5 = str2;
        final AppBrandStatObject appBrandStatObject2 = appBrandStatObject;
        C33183g.m54274a(str, new C33186c() {
            /* renamed from: a */
            public final void mo6074a(C33184d c33184d) {
                AppMethodBeat.m2504i(131344);
                m18202a(c33184d, str4, str5, str3);
                AppMethodBeat.m2505o(131344);
            }

            public final void onDestroy() {
                AppMethodBeat.m2504i(131345);
                m18202a(C33183g.m54286wV(str4), str4, str5, str3);
                AppMethodBeat.m2505o(131345);
            }

            /* renamed from: a */
            private void m18202a(C33184d c33184d, String str, String str2, String str3) {
                AppMethodBeat.m2504i(131346);
                C10486i.m18199a(c33184d, str, str2, str3, C5046bo.anU() - currentTimeMillis);
                appBrandStatObject2.hQF = null;
                C33183g.m54276b(str, this);
                AppMethodBeat.m2505o(131346);
            }
        });
        AppMethodBeat.m2505o(131348);
    }

    /* renamed from: b */
    public static void m18201b(String str, String str2, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(131349);
        if (appBrandStatObject == null) {
            AppMethodBeat.m2505o(131349);
        } else if (C5046bo.isNullOrNil(appBrandStatObject.hQF)) {
            AppMethodBeat.m2505o(131349);
        } else {
            C10486i.m18198a(4, str, str2, appBrandStatObject.hQF, 0);
            AppMethodBeat.m2505o(131349);
        }
    }

    /* renamed from: a */
    private static void m18198a(int i, String str, String str2, String str3, long j) {
        AppMethodBeat.m2504i(131350);
        long anU = C5046bo.anU();
        String gE = C5023at.m7474gE(C4996ah.getContext());
        String str4 = str3 + "," + str2 + "," + str + "," + anU + "," + j + "," + i + "," + C10486i.aEn() + "," + gE + "," + C5023at.m7475gF(C4996ah.getContext()) + ",,";
        C4990ab.m7419v("MicroMsg.MiniProgramNavigatorAdReportHelper", "closeType:%d stayTime:%d", Integer.valueOf(i), Long.valueOf(j));
        AdReportCgiHelper.m54725a(16004, str4, null);
        AppMethodBeat.m2505o(131350);
    }

    private static int aEn() {
        AppMethodBeat.m2504i(131351);
        switch (C5023at.getNetType(C4996ah.getContext())) {
            case -1:
                AppMethodBeat.m2505o(131351);
                return 255;
            case 0:
                AppMethodBeat.m2505o(131351);
                return 1;
            case 1:
            case 6:
            case 8:
                AppMethodBeat.m2505o(131351);
                return 3;
            case 2:
            case 5:
            case 7:
                AppMethodBeat.m2505o(131351);
                return 2;
            case 3:
            case 4:
                AppMethodBeat.m2505o(131351);
                return 4;
            case 10:
                AppMethodBeat.m2505o(131351);
                return 5;
            default:
                AppMethodBeat.m2505o(131351);
                return 6;
        }
    }
}
