package com.tencent.p177mm.plugin.appbrand.task;

import com.tencent.p177mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandPluginUI;

/* renamed from: com.tencent.mm.plugin.appbrand.task.d */
final class C10743d extends C45695j {
    C10743d() {
        super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo6386a(C38519g c38519g) {
        return c38519g != C38519g.WAGAME;
    }

    /* Access modifiers changed, original: final */
    public final void aLJ() {
    }
}
