package com.tencent.tinker.entry;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Keep;

@Keep
public class DefaultApplicationLike extends ApplicationLike {
    private static final String TAG = "Tinker.DefaultAppLike";

    public DefaultApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    public void onCreate() {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
    }

    public void onTerminate() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        new StringBuilder("onConfigurationChanged:").append(configuration.toString());
    }

    public void onBaseContextAttached(Context context) {
    }
}
