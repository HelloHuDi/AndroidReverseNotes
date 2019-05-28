package com.tencent.map.lib.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SystemUtil {
    public static final int SMALL_SCREEN_THRESHOLD = 400;

    public static float getDensity(Context context) {
        AppMethodBeat.m2504i(98228);
        if (context == null) {
            AppMethodBeat.m2505o(98228);
            return 1.0f;
        }
        float f = context.getResources().getDisplayMetrics().density;
        AppMethodBeat.m2505o(98228);
        return f;
    }

    public static int getWindowWidth(Context context) {
        AppMethodBeat.m2504i(98229);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.m2505o(98229);
        return i;
    }

    public static int getWindowHeight(Context context) {
        AppMethodBeat.m2504i(98230);
        int i = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.m2505o(98230);
        return i;
    }

    public static int getOpenglesVersion(Context context) {
        AppMethodBeat.m2504i(98231);
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            int i = deviceConfigurationInfo.reqGlEsVersion;
            AppMethodBeat.m2505o(98231);
            return i;
        }
        AppMethodBeat.m2505o(98231);
        return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
    }
}
