package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.res.Configuration;

@Deprecated
public abstract class e {
    protected Application app;

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate();

    public final void b(Application application) {
        this.app = application;
    }

    public void onTerminate() {
    }

    public void onTrimMemory(int i) {
    }
}
