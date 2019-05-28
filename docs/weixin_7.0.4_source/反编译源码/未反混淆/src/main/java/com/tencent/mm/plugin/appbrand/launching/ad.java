package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class ad {
    final String appId;

    ad(String str) {
        this.appId = str;
    }

    /* Access modifiers changed, original: final */
    public final boolean aHv() {
        AppMethodBeat.i(131945);
        if (g.Nu().getInt("WeAppForbiddenSwitch", 0) == 1) {
            ab.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", this.appId);
            Intent putExtra = new Intent().putExtra("rawUrl", v.xf(this.appId)).putExtra("forceHideShare", true);
            Context context = ah.getContext();
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            AppMethodBeat.o(131945);
            return true;
        }
        AppMethodBeat.o(131945);
        return false;
    }
}
