package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C19565am.C19566a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrand404PageUI;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.al */
final class C19563al {
    /* renamed from: a */
    static boolean m30335a(WxaAttributes wxaAttributes, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.m2504i(131991);
        if (1 == wxaAttributes.ayL().bQl) {
            AppBrand404PageUI.m65225a(activityStarterIpcDelegate);
            C19690c.m30494K(wxaAttributes.field_appId, 14, 1);
            AppMethodBeat.m2505o(131991);
            return false;
        }
        AppMethodBeat.m2505o(131991);
        return true;
    }

    /* renamed from: bp */
    private static String m30337bp(String str, int i) {
        AppMethodBeat.m2504i(131992);
        String str2 = null;
        C31281at a = C42340f.auV().mo60842a(str, i, "versionMd5", "pkgPath");
        if (!(a == null || C5046bo.isNullOrNil(a.field_pkgPath) || !C5730e.m8628ct(a.field_pkgPath) || C5046bo.isNullOrNil(a.field_versionMd5) || !a.field_pkgPath.equals(C5730e.atg(a.field_pkgPath)))) {
            str2 = a.field_versionMd5;
        }
        AppMethodBeat.m2505o(131992);
        return str2;
    }

    /* renamed from: an */
    static boolean m30336an(String str, boolean z) {
        AppMethodBeat.m2504i(131993);
        int aAa = new C19565am(str, C19563al.m30337bp(str, 2), C19563al.m30337bp(str, 10001), z).aAa();
        C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", str, Integer.valueOf(aAa), Boolean.valueOf(z));
        C19566a pa = C19566a.m30339pa(aAa);
        if (pa == null) {
            switch (aAa) {
                case -13003:
                    C42608ag.m75435oZ(C25738R.string.f8874hs);
                    C19690c.m30494K(str, 12, 3);
                    AppMethodBeat.m2505o(131993);
                    return false;
                case -13002:
                    C42608ag.m75435oZ(C25738R.string.f8873hr);
                    C19690c.m30494K(str, 13, 3);
                    AppMethodBeat.m2505o(131993);
                    return false;
                default:
                    if (z) {
                        AppMethodBeat.m2505o(131993);
                        return true;
                    }
                    C42608ag.m75434Ck(C4996ah.getResources().getString(C25738R.string.f9009ma, new Object[]{Integer.valueOf(3), Integer.valueOf(aAa)}));
                    AppMethodBeat.m2505o(131993);
                    return false;
            }
        } else if (z) {
            AppMethodBeat.m2505o(131993);
            return true;
        } else {
            switch (pa) {
                case Ok:
                    AppMethodBeat.m2505o(131993);
                    return true;
                case Timeout:
                    C42608ag.m75435oZ(C25738R.string.f8872hq);
                    C19690c.m30494K(str, 13, 3);
                    AppMethodBeat.m2505o(131993);
                    return false;
                default:
                    C42608ag.m75435oZ(C25738R.string.f8871hp);
                    C19690c.m30494K(str, 13, 3);
                    AppMethodBeat.m2505o(131993);
                    return false;
            }
        }
    }
}
