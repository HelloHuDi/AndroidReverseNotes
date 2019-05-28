package com.tencent.p177mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p230g.p232b.p233a.C18440bo;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10083ay;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.C38115ba;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d.C2058a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.p1535a.C38120a;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C38296al;
import com.tencent.p177mm.plugin.appbrand.launching.C42611l;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19771b;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.al */
public enum C42374al {
    ;

    /* renamed from: j */
    public static void m74967j(final String str, final String str2, final int i) {
        AppMethodBeat.m2504i(129719);
        C7305d.xDG.mo10151b(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(129716);
                C42374al.m74970m(str, str2, i);
                AppMethodBeat.m2505o(129716);
            }
        }, "MicroMsg.AppBrand.RemoveUsageTask");
        AppMethodBeat.m2505o(129719);
    }

    /* renamed from: k */
    public static void m74968k(String str, String str2, int i) {
        AppMethodBeat.m2504i(129720);
        C42374al.m74969l(str, str2, i);
        AppMethodBeat.m2505o(129720);
    }

    /* renamed from: l */
    private static void m74969l(String str, String str2, int i) {
        AppMethodBeat.m2504i(129721);
        C4990ab.m7417i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", str, str2, Integer.valueOf(i));
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129721);
            return;
        }
        CharSequence str22;
        C42340f.auT().mo73333aL(str, i);
        if (TextUtils.isEmpty(str22)) {
            str22 = C26842p.m42740zm(str);
        }
        if (TextUtils.isEmpty(str22)) {
            AppMethodBeat.m2505o(129721);
            return;
        }
        long j;
        C10083ay.awp();
        C45694h.m84422bt(str22, i);
        int ax = C42340f.auV().mo60857ax(str22, i);
        C18440bo c18440bo = new C18440bo();
        c18440bo.dcY = 1;
        C18440bo gk = c18440bo.mo33703gk(str22);
        gk.dda = (long) i;
        gk.ddb = (long) ax;
        if (C19071r.avG()) {
            j = 1;
        } else {
            j = 0;
        }
        gk.dcW = j;
        gk.ajK();
        C42340f.avc().clear(str22);
        C42340f.avd();
        C38115ba.clear(str22);
        if (i == 0) {
            ((C2058a) C42340f.m74878E(C2058a.class)).mo5824pI(str22);
        }
        C4990ab.m7417i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", str, str22, Integer.valueOf(i), Boolean.valueOf(C42340f.auV().mo60851as(str22, 0)), Boolean.valueOf(C42340f.auV().mo60851as(str22, 2)), Boolean.valueOf(C42340f.auV().mo60851as(str22, 1)), Boolean.valueOf(((C26779s) C42340f.m74878E(C26779s.class)).mo44551aF(str, i)));
        if (!(C42340f.auV().mo60851as(str22, 0) || r2 || r3)) {
            if (C42340f.auO().mo21572d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL") != null) {
                String[] strArr = new String[]{C42340f.auO().mo21572d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_smallHeadURL, C42340f.auO().mo21572d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_bigHeadURL, C42340f.auO().mo21572d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_brandIconURL, C42340f.auO().mo21572d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_roundedSquareIconURL};
                for (ax = 0; ax < 4; ax++) {
                    C37926b.abR().mo60690pF(strArr[ax]);
                }
            }
            if (r4) {
                C26842p.m42743zp(str);
            } else {
                C42340f.auO().mo21577zg(str);
            }
        }
        C42340f.m74879xG().mo67875xR(str22);
        C19085f c19085f = C19085f.gXv;
        C19085f.m29670xR(str22);
        C19771b.aMR();
        C42340f.m74880xH().mo53685yW(str22);
        C42340f.auP().mo61134pI(str22);
        String string = C1183p.getString(((C38120a) C1720g.m3528K(C38120a.class)).mo34317ys(str22));
        try {
            C38296al.m64798cg(string, str22).awP();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", str22, e);
        }
        try {
            C38296al.m64799ch(string, str22).awP();
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", str22, e2);
        }
        if (C33097a.m54089kR(i)) {
            ((C42611l) C42340f.m74878E(C42611l.class)).mo68053n(str22, i, "{}");
        }
        AppMethodBeat.m2505o(129721);
    }
}
