package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;

public interface u extends b {
    void a(Activity activity, AppBrandInitConfig appBrandInitConfig);

    void a(i iVar, i iVar2);

    void a(i iVar, i iVar2, Runnable runnable);

    void k(Activity activity);
}
