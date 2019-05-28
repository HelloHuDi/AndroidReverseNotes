package com.tencent.xweb.x5.sdk;

import android.content.Context;

public interface c {
    boolean getCanReboot();

    String getCrashExtraMessage(Context context);

    int getTbsCoreVersion(Context context);

    int getTbsSDKVersion(Context context);
}
