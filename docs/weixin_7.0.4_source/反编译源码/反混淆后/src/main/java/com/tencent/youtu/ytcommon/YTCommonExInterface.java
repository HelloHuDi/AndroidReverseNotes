package com.tencent.youtu.ytcommon;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.YTLogger.IFaceLiveLogger;

public class YTCommonExInterface {
    private static final String TAG = "YTUtilityInterface";
    public static final String VERSION = "3.0.1";
    private static int mBusinessCode = 0;
    public static boolean mIsAuthSuccess = false;

    public interface BUSINESS_CODE {
        public static final int YT_COMMON = 0;
        public static final int YT_WX = 1;
    }

    public static int initAuth(Context context, String str, int i, boolean z) {
        AppMethodBeat.m2504i(118048);
        YTLogger.m50246i(TAG, "[YTUtilityInterface.initAuth] ---licence: " + str + " initType: " + i + " isDebug: " + z);
        if (mIsAuthSuccess) {
            AppMethodBeat.m2505o(118048);
            return 0;
        }
        int init = YTAuthJNIInterface.init(context, str, i, z);
        if (init == 0) {
            YTLogger.m50246i(TAG, "initAuth success.");
            mIsAuthSuccess = true;
        } else {
            YTLogger.m50248w(TAG, "initAuth failed. return value: ".concat(String.valueOf(init)));
        }
        AppMethodBeat.m2505o(118048);
        return init;
    }

    public static boolean isAuthSuccess() {
        return mIsAuthSuccess;
    }

    public static float setAppBrightness(Activity activity, int i) {
        AppMethodBeat.m2504i(118049);
        YTLogger.m50246i(TAG, "[YTUtilityInterface.setAppBrightness] brightness: ".concat(String.valueOf(i)));
        Window window = activity.getWindow();
        LayoutParams attributes = window.getAttributes();
        float f = attributes.screenBrightness;
        if (i == -1) {
            attributes.screenBrightness = -1.0f;
        } else {
            if (i <= 0) {
                i = 1;
            }
            attributes.screenBrightness = ((float) i) / 255.0f;
        }
        window.setAttributes(attributes);
        AppMethodBeat.m2505o(118049);
        return f;
    }

    public static int initCamera(Context context, Camera camera, int i) {
        AppMethodBeat.m2504i(118050);
        YTLogger.m50246i(TAG, "[YTUtilityInterface.initCamera] ---cameraId: ".concat(String.valueOf(i)));
        int initCamera = CameraSetting.initCamera(context, camera, i);
        AppMethodBeat.m2505o(118050);
        return initCamera;
    }

    public static void setLogger(IFaceLiveLogger iFaceLiveLogger) {
        AppMethodBeat.m2504i(118051);
        YTLogger.setLog(iFaceLiveLogger);
        AppMethodBeat.m2505o(118051);
    }

    public static void setIsEnabledLog(boolean z) {
        AppMethodBeat.m2504i(118052);
        YTLogger.setIsEnabledLog(z);
        AppMethodBeat.m2505o(118052);
    }

    public static void setIsEnabledNativeLog(boolean z) {
        AppMethodBeat.m2504i(118053);
        YTLogger.setIsEnabledNativeLog(z);
        AppMethodBeat.m2505o(118053);
    }

    public static void setBusinessCode(int i) {
        mBusinessCode = i;
    }

    public static int getBusinessCode() {
        return mBusinessCode;
    }
}
