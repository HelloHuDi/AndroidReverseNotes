package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t.C45687a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.h */
public final class C45613h {
    private static String hVR = "";
    private static String hVS = "";
    private static C19466g hVT = new C19466g();
    private static C45687a hVU = C45687a.NONE;
    private static C45687a hVV = C45687a.NONE;
    private static boolean mEnable = false;

    static {
        AppMethodBeat.m2504i(126390);
        AppMethodBeat.m2505o(126390);
    }

    /* renamed from: s */
    public static void m84194s(C2241c c2241c) {
        AppMethodBeat.m2504i(126386);
        hVR = c2241c.getAppId();
        mEnable = true;
        hVT.mo61032j(c2241c);
        if (hVV == C45687a.NONE || !hVS.equalsIgnoreCase(hVR)) {
            hVV = C45687a.NONE;
        } else {
            hVT.mo34593a(hVV);
        }
        C4990ab.m7416i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + hVR + "; mEnable:" + mEnable);
        AppMethodBeat.m2505o(126386);
    }

    /* renamed from: t */
    public static void m84195t(C2241c c2241c) {
        AppMethodBeat.m2504i(126387);
        if (c2241c.getAppId().equalsIgnoreCase(hVR)) {
            C4990ab.m7416i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + hVR);
            hVR = "";
            mEnable = false;
            hVV = C45687a.NONE;
        }
        AppMethodBeat.m2505o(126387);
    }

    /* renamed from: a */
    public static void m84192a(Configuration configuration, String str) {
        AppMethodBeat.m2504i(126388);
        if (configuration.orientation == 2) {
            if (hVU == C45687a.REVERSE_LANDSCAPE) {
                hVV = C45687a.REVERSE_LANDSCAPE;
            } else {
                hVV = C45687a.LANDSCAPE;
            }
        } else if (configuration.orientation == 1) {
            hVV = C45687a.PORTRAIT;
        } else {
            hVV = C45687a.NONE;
        }
        C4990ab.m7416i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + hVR + "; appid:" + str + "; mOrientation:" + hVV.name());
        if (!hVR.equalsIgnoreCase("") && hVR.equalsIgnoreCase(str) && mEnable) {
            hVT.mo34593a(hVV);
            AppMethodBeat.m2505o(126388);
            return;
        }
        hVS = str;
        AppMethodBeat.m2505o(126388);
    }

    /* renamed from: b */
    public static void m84193b(C45687a c45687a) {
        AppMethodBeat.m2504i(126389);
        hVU = c45687a;
        if (mEnable && hVV == C45687a.LANDSCAPE && (c45687a == C45687a.REVERSE_LANDSCAPE || c45687a == C45687a.LANDSCAPE)) {
            hVT.mo34593a(c45687a);
            C4990ab.m7416i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + hVR + "; mOrientation:" + c45687a.name());
        }
        AppMethodBeat.m2505o(126389);
    }
}
