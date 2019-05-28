package com.tencent.p177mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ad */
final class C10581ad {
    final String appId;

    C10581ad(String str) {
        this.appId = str;
    }

    /* Access modifiers changed, original: final */
    public final boolean aHv() {
        AppMethodBeat.m2504i(131945);
        if (C26373g.m41964Nu().getInt("WeAppForbiddenSwitch", 0) == 1) {
            C4990ab.m7417i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", this.appId);
            Intent putExtra = new Intent().putExtra("rawUrl", C42700v.m75634xf(this.appId)).putExtra("forceHideShare", true);
            Context context = C4996ah.getContext();
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            AppMethodBeat.m2505o(131945);
            return true;
        }
        AppMethodBeat.m2505o(131945);
        return false;
    }
}
