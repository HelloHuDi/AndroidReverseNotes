package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class f implements a {
    public final String name() {
        return "LaunchApp";
    }

    public final void A(Intent intent) {
        AppMethodBeat.i(129945);
        String stringExtra = intent.getStringExtra("username");
        String stringExtra2 = intent.getStringExtra("appId");
        String stringExtra3 = intent.getStringExtra("path");
        int i = bo.getInt(intent.getStringExtra("versionType"), 0);
        int i2 = bo.getInt(intent.getStringExtra("scene"), 1030);
        String stringExtra4 = intent.getStringExtra("sceneNote");
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i2;
        appBrandStatObject.cst = stringExtra4;
        ((e) g.K(e.class)).a(ah.getContext(), stringExtra, stringExtra2, i, 0, stringExtra3, appBrandStatObject);
        AppMethodBeat.o(129945);
    }
}
