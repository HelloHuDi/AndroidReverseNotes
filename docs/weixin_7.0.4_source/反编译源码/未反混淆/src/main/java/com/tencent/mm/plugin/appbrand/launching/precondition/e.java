package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.n;

public final class e extends ContextWrapper implements g {
    public e(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
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

    public final void E(Intent intent) {
        AppMethodBeat.i(132074);
        n.a(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow());
        n.a(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow(), true);
        d Cn = d.Cn(intent.getStringExtra("extra_entry_token"));
        if (Cn == null) {
            ((AppBrandLaunchProxyUI) super.getBaseContext()).finish();
            AppMethodBeat.o(132074);
            return;
        }
        Cn.setBaseContext((AppBrandLaunchProxyUI) super.getBaseContext());
        AppMethodBeat.o(132074);
    }

    public final /* bridge */ /* synthetic */ Context getBaseContext() {
        AppMethodBeat.i(132075);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.o(132075);
        return appBrandLaunchProxyUI;
    }
}
