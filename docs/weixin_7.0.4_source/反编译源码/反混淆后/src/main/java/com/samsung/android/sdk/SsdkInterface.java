package com.samsung.android.sdk;

import android.content.Context;

public interface SsdkInterface {
    int getVersionCode();

    String getVersionName();

    void initialize(Context context);

    boolean isFeatureEnabled(int i);
}
