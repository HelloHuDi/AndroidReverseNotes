package com.tencent.ttpic.device;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;

public class NotchInScreenUtils {
    public static final int NOTCH_IN_SCREEN_VIVO = 32;
    public static final int ROUNDED_IN_SCREEN_VIVO = 8;

    public static boolean hasNotchInScreen(Context context) {
        AppMethodBeat.m2504i(49929);
        if (hasNotchInScreenHw(context) || hasNotchInScreenAtOppo(context) || hasNotchInScreenAtVivo(context) || hasNotchInScreenAtXM()) {
            AppMethodBeat.m2505o(49929);
            return true;
        }
        AppMethodBeat.m2505o(49929);
        return false;
    }

    public static boolean hasNotchInScreenHw(Context context) {
        boolean booleanValue;
        AppMethodBeat.m2504i(49930);
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            LogUtils.m50206e(e);
            booleanValue = false;
        } catch (NoSuchMethodException e2) {
            LogUtils.m50206e(e2);
            booleanValue = false;
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
            booleanValue = false;
        }
        AppMethodBeat.m2505o(49930);
        return booleanValue;
    }

    public static int getNotchHeightHw(Context context) {
        int[] iArr;
        AppMethodBeat.m2504i(49931);
        int[] iArr2 = new int[]{0, 0};
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            iArr = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException e) {
            LogUtils.m50206e(e);
            iArr = iArr2;
        } catch (NoSuchMethodException e2) {
            LogUtils.m50206e(e2);
            iArr = iArr2;
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
            iArr = iArr2;
        }
        int i = iArr[1];
        AppMethodBeat.m2505o(49931);
        return i;
    }

    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.m2504i(49932);
        int i = 0;
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = context.getResources().getDimensionPixelSize(identifier);
        }
        AppMethodBeat.m2505o(49932);
        return i;
    }

    public static boolean hasNotchInScreenAtOppo(Context context) {
        AppMethodBeat.m2504i(49933);
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        AppMethodBeat.m2505o(49933);
        return hasSystemFeature;
    }

    public static boolean hasNotchInScreenAtVivo(Context context) {
        AppMethodBeat.m2504i(49934);
        try {
            Class loadClass = context.getClassLoader().loadClass("com.util.FtFeature");
            boolean booleanValue = ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
            AppMethodBeat.m2505o(49934);
            return booleanValue;
        } catch (ClassNotFoundException e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49934);
            return false;
        } catch (NoSuchMethodException e2) {
            LogUtils.m50206e(e2);
            AppMethodBeat.m2505o(49934);
            return false;
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
            AppMethodBeat.m2505o(49934);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(49934);
            return false;
        }
    }

    public static boolean hasNotchInScreenAtXM() {
        AppMethodBeat.m2504i(49935);
        String property = System.getProperty("ro.miui.notch");
        if (TextUtils.isEmpty(property)) {
            AppMethodBeat.m2505o(49935);
            return false;
        }
        int parseInt;
        try {
            parseInt = Integer.parseInt(property);
        } catch (NumberFormatException e) {
            LogUtils.m50206e(e);
            parseInt = 0;
        }
        if (parseInt == 1) {
            AppMethodBeat.m2505o(49935);
            return true;
        }
        AppMethodBeat.m2505o(49935);
        return false;
    }
}
