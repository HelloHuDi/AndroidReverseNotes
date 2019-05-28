package com.tencent.p177mm.plugin.appbrand.p297h;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.appbrand.h.y */
public final class C42454y {
    /* renamed from: oV */
    public static boolean m75197oV(int i) {
        boolean z;
        AppMethodBeat.m2504i(73186);
        int aGZ = C42454y.aGZ();
        if (C42454y.aGY() != 2 || i < aGZ) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", Integer.valueOf(aGZ), Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.m2505o(73186);
        return z;
    }

    private static int aGY() {
        AppMethodBeat.m2504i(73187);
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100377");
        if (ll == null) {
            C4990ab.m7416i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
            AppMethodBeat.m2505o(73187);
            return 0;
        } else if (ll.isValid()) {
            C4990ab.m7417i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", Integer.valueOf(C5046bo.getInt((String) ll.dru().get("JsRuntime"), 0)));
            AppMethodBeat.m2505o(73187);
            return C5046bo.getInt((String) ll.dru().get("JsRuntime"), 0);
        } else {
            C4990ab.m7416i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
            AppMethodBeat.m2505o(73187);
            return 0;
        }
    }

    private static int aGZ() {
        AppMethodBeat.m2504i(73188);
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100377");
        int i = (ll == null || !ll.isValid()) ? BaseClientBuilder.API_PRIORITY_OTHER : C5046bo.getInt((String) ll.dru().get("isolateContextLibVersion"), BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.m2505o(73188);
        return i;
    }
}
