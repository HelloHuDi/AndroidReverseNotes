package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.am.a;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class al {
    static boolean a(WxaAttributes wxaAttributes, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(131991);
        if (1 == wxaAttributes.ayL().bQl) {
            AppBrand404PageUI.a(activityStarterIpcDelegate);
            c.K(wxaAttributes.field_appId, 14, 1);
            AppMethodBeat.o(131991);
            return false;
        }
        AppMethodBeat.o(131991);
        return true;
    }

    private static String bp(String str, int i) {
        AppMethodBeat.i(131992);
        String str2 = null;
        at a = f.auV().a(str, i, "versionMd5", "pkgPath");
        if (!(a == null || bo.isNullOrNil(a.field_pkgPath) || !e.ct(a.field_pkgPath) || bo.isNullOrNil(a.field_versionMd5) || !a.field_pkgPath.equals(e.atg(a.field_pkgPath)))) {
            str2 = a.field_versionMd5;
        }
        AppMethodBeat.o(131992);
        return str2;
    }

    static boolean an(String str, boolean z) {
        AppMethodBeat.i(131993);
        int aAa = new am(str, bp(str, 2), bp(str, 10001), z).aAa();
        ab.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", str, Integer.valueOf(aAa), Boolean.valueOf(z));
        a pa = a.pa(aAa);
        if (pa == null) {
            switch (aAa) {
                case -13003:
                    ag.oZ(R.string.hs);
                    c.K(str, 12, 3);
                    AppMethodBeat.o(131993);
                    return false;
                case -13002:
                    ag.oZ(R.string.hr);
                    c.K(str, 13, 3);
                    AppMethodBeat.o(131993);
                    return false;
                default:
                    if (z) {
                        AppMethodBeat.o(131993);
                        return true;
                    }
                    ag.Ck(ah.getResources().getString(R.string.ma, new Object[]{Integer.valueOf(3), Integer.valueOf(aAa)}));
                    AppMethodBeat.o(131993);
                    return false;
            }
        } else if (z) {
            AppMethodBeat.o(131993);
            return true;
        } else {
            switch (pa) {
                case Ok:
                    AppMethodBeat.o(131993);
                    return true;
                case Timeout:
                    ag.oZ(R.string.hq);
                    c.K(str, 13, 3);
                    AppMethodBeat.o(131993);
                    return false;
                default:
                    ag.oZ(R.string.hp);
                    c.K(str, 13, 3);
                    AppMethodBeat.o(131993);
                    return false;
            }
        }
    }
}
