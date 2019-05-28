package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.e */
public final class C27178e extends ContextWrapper implements C19583g {
    public C27178e(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        super(appBrandLaunchProxyUI);
    }

    public final boolean aHO() {
        return true;
    }

    public final void onResume() {
    }

    public final void onPause() {
    }

    public final void onDestroy() {
    }

    /* renamed from: E */
    public final void mo34794E(Intent intent) {
        AppMethodBeat.m2504i(132074);
        C42696n.m75615a(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow());
        C42696n.m75616a(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow(), true);
        C42613d Cn = C42613d.m75451Cn(intent.getStringExtra("extra_entry_token"));
        if (Cn == null) {
            ((AppBrandLaunchProxyUI) super.getBaseContext()).finish();
            AppMethodBeat.m2505o(132074);
            return;
        }
        Cn.setBaseContext((AppBrandLaunchProxyUI) super.getBaseContext());
        AppMethodBeat.m2505o(132074);
    }

    public final /* bridge */ /* synthetic */ Context getBaseContext() {
        AppMethodBeat.m2504i(132075);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.m2505o(132075);
        return appBrandLaunchProxyUI;
    }
}
