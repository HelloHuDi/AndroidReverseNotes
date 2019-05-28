package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell.C38172a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.f */
public final class C46891f implements C38172a {
    public final String name() {
        return "LaunchApp";
    }

    /* renamed from: A */
    public final void mo21580A(Intent intent) {
        AppMethodBeat.m2504i(129945);
        String stringExtra = intent.getStringExtra("username");
        String stringExtra2 = intent.getStringExtra("appId");
        String stringExtra3 = intent.getStringExtra("path");
        int i = C5046bo.getInt(intent.getStringExtra("versionType"), 0);
        int i2 = C5046bo.getInt(intent.getStringExtra("scene"), 1030);
        String stringExtra4 = intent.getStringExtra("sceneNote");
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i2;
        appBrandStatObject.cst = stringExtra4;
        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(C4996ah.getContext(), stringExtra, stringExtra2, i, 0, stringExtra3, appBrandStatObject);
        AppMethodBeat.m2505o(129945);
    }
}
