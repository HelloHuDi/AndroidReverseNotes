package com.tencent.ttpic.util;

import android.content.Context;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;

public class VideoGlobalContext {
    private static Context sContext;

    public static void setContext(Context context) {
        sContext = context;
        GamePlaySDK.context = context;
    }

    public static Context getContext() {
        return sContext;
    }
}
