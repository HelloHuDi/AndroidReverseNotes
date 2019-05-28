package com.tencent.p177mm.compatible.loader;

import android.app.Application;
import android.content.res.Configuration;

@Deprecated
/* renamed from: com.tencent.mm.compatible.loader.e */
public abstract class C1439e {
    protected Application app;

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate();

    /* renamed from: b */
    public final void mo4894b(Application application) {
        this.app = application;
    }

    public void onTerminate() {
    }

    public void onTrimMemory(int i) {
    }
}
