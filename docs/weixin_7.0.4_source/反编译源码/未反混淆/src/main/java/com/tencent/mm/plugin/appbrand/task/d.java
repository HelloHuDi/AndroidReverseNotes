package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;

final class d extends j {
    d() {
        super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(g gVar) {
        return gVar != g.WAGAME;
    }

    /* Access modifiers changed, original: final */
    public final void aLJ() {
    }
}
