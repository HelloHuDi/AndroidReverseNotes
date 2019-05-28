package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.b.d.a;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public enum al {
    ;

    public static void j(final String str, final String str2, final int i) {
        AppMethodBeat.i(129719);
        d.xDG.b(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129716);
                al.m(str, str2, i);
                AppMethodBeat.o(129716);
            }
        }, "MicroMsg.AppBrand.RemoveUsageTask");
        AppMethodBeat.o(129719);
    }

    public static void k(String str, String str2, int i) {
        AppMethodBeat.i(129720);
        l(str, str2, i);
        AppMethodBeat.o(129720);
    }

    private static void l(String str, String str2, int i) {
        AppMethodBeat.i(129721);
        ab.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", str, str2, Integer.valueOf(i));
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129721);
            return;
        }
        CharSequence str22;
        f.auT().aL(str, i);
        if (TextUtils.isEmpty(str22)) {
            str22 = p.zm(str);
        }
        if (TextUtils.isEmpty(str22)) {
            AppMethodBeat.o(129721);
            return;
        }
        long j;
        ay.awp();
        h.bt(str22, i);
        int ax = f.auV().ax(str22, i);
        com.tencent.mm.g.b.a.bo boVar = new com.tencent.mm.g.b.a.bo();
        boVar.dcY = 1;
        com.tencent.mm.g.b.a.bo gk = boVar.gk(str22);
        gk.dda = (long) i;
        gk.ddb = (long) ax;
        if (r.avG()) {
            j = 1;
        } else {
            j = 0;
        }
        gk.dcW = j;
        gk.ajK();
        f.avc().clear(str22);
        f.avd();
        ba.clear(str22);
        if (i == 0) {
            ((a) f.E(a.class)).pI(str22);
        }
        ab.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", str, str22, Integer.valueOf(i), Boolean.valueOf(f.auV().as(str22, 0)), Boolean.valueOf(f.auV().as(str22, 2)), Boolean.valueOf(f.auV().as(str22, 1)), Boolean.valueOf(((s) f.E(s.class)).aF(str, i)));
        if (!(f.auV().as(str22, 0) || r2 || r3)) {
            if (f.auO().d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL") != null) {
                String[] strArr = new String[]{f.auO().d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_smallHeadURL, f.auO().d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_bigHeadURL, f.auO().d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_brandIconURL, f.auO().d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL").field_roundedSquareIconURL};
                for (ax = 0; ax < 4; ax++) {
                    b.abR().pF(strArr[ax]);
                }
            }
            if (r4) {
                p.zp(str);
            } else {
                f.auO().zg(str);
            }
        }
        f.xG().xR(str22);
        com.tencent.mm.plugin.appbrand.appstorage.f fVar = com.tencent.mm.plugin.appbrand.appstorage.f.gXv;
        com.tencent.mm.plugin.appbrand.appstorage.f.xR(str22);
        AppBrandStickyBannerLogic.b.aMR();
        f.xH().yW(str22);
        f.auP().pI(str22);
        String string = com.tencent.mm.a.p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.K(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).ys(str22));
        try {
            com.tencent.mm.plugin.appbrand.jsapi.file.al.cg(string, str22).awP();
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", str22, e);
        }
        try {
            com.tencent.mm.plugin.appbrand.jsapi.file.al.ch(string, str22).awP();
        } catch (Exception e2) {
            ab.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", str22, e2);
        }
        if (j.a.kR(i)) {
            ((l) f.E(l.class)).n(str22, i, "{}");
        }
        AppMethodBeat.o(129721);
    }
}
