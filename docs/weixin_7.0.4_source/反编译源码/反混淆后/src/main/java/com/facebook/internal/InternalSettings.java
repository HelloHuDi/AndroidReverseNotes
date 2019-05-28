package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class InternalSettings {
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String mCustomUserAgent;

    public static void setCustomUserAgent(String str) {
        mCustomUserAgent = str;
    }

    public static String getCustomUserAgent() {
        return mCustomUserAgent;
    }

    public static boolean isUnityApp() {
        AppMethodBeat.m2504i(72399);
        if (mCustomUserAgent == null || !mCustomUserAgent.startsWith(UNITY_PREFIX)) {
            AppMethodBeat.m2505o(72399);
            return false;
        }
        AppMethodBeat.m2505o(72399);
        return true;
    }
}
