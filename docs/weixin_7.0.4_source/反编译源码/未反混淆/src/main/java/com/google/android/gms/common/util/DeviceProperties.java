package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DeviceProperties {
    public static final String FEATURE_AUTO = "android.hardware.type.automotive";
    public static final String FEATURE_CHROME_OS = "org.chromium.arc";
    public static final String FEATURE_EMBEDDED = "android.hardware.type.embedded";
    public static final String FEATURE_IOT = "android.hardware.type.iot";
    public static final String FEATURE_LATCHSKY = "cn.google.services";
    public static final String FEATURE_PIXEL = "com.google.android.feature.PIXEL_EXPERIENCE";
    public static final String FEATURE_SIDEWINDER = "cn.google";
    public static final String FEATURE_TV_1 = "com.google.android.tv";
    public static final String FEATURE_TV_2 = "android.hardware.type.television";
    public static final String FEATURE_TV_3 = "android.software.leanback";
    private static Boolean zzzl;
    private static Boolean zzzm;
    private static Boolean zzzn;
    private static Boolean zzzo;
    private static Boolean zzzp;
    private static Boolean zzzq;
    private static Boolean zzzr;
    private static Boolean zzzs;
    private static Boolean zzzt;
    private static Boolean zzzu;
    private static Boolean zzzv;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        boolean z;
        AppMethodBeat.i(90174);
        if (zzzt == null) {
            z = PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature(FEATURE_AUTO);
            zzzt = Boolean.valueOf(z);
        }
        z = zzzt.booleanValue();
        AppMethodBeat.o(90174);
        return z;
    }

    public static boolean isChromeOsDevice(Context context) {
        AppMethodBeat.i(90178);
        if (zzzs == null) {
            zzzs = Boolean.valueOf(context.getPackageManager().hasSystemFeature(FEATURE_CHROME_OS));
        }
        boolean booleanValue = zzzs.booleanValue();
        AppMethodBeat.o(90178);
        return booleanValue;
    }

    public static boolean isIoT(Context context) {
        boolean z;
        AppMethodBeat.i(90173);
        if (zzzr == null) {
            z = context.getPackageManager().hasSystemFeature(FEATURE_IOT) || context.getPackageManager().hasSystemFeature(FEATURE_EMBEDDED);
            zzzr = Boolean.valueOf(z);
        }
        z = zzzr.booleanValue();
        AppMethodBeat.o(90173);
        return z;
    }

    public static boolean isLatchsky(Context context) {
        boolean z;
        AppMethodBeat.i(90172);
        if (zzzp == null) {
            z = PlatformVersion.isAtLeastM() && context.getPackageManager().hasSystemFeature(FEATURE_LATCHSKY);
            zzzp = Boolean.valueOf(z);
        }
        z = zzzp.booleanValue();
        AppMethodBeat.o(90172);
        return z;
    }

    public static boolean isLowRamOrPreKitKat(Context context) {
        AppMethodBeat.i(90177);
        if (VERSION.SDK_INT < 19) {
            AppMethodBeat.o(90177);
            return true;
        }
        if (zzzq == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                zzzq = Boolean.valueOf(activityManager.isLowRamDevice());
            }
        }
        boolean equal = Objects.equal(zzzq, Boolean.TRUE);
        AppMethodBeat.o(90177);
        return equal;
    }

    public static boolean isPixelDevice(Context context) {
        AppMethodBeat.i(90179);
        if (zzzv == null) {
            zzzv = Boolean.valueOf(context.getPackageManager().hasSystemFeature(FEATURE_PIXEL));
        }
        boolean booleanValue = zzzv.booleanValue();
        AppMethodBeat.o(90179);
        return booleanValue;
    }

    @TargetApi(21)
    public static boolean isSidewinder(Context context) {
        boolean z;
        AppMethodBeat.i(90171);
        if (zzzo == null) {
            z = PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google");
            zzzo = Boolean.valueOf(z);
        }
        z = zzzo.booleanValue();
        AppMethodBeat.o(90171);
        return z;
    }

    /* JADX WARNING: Missing block: B:18:0x0041, code skipped:
            if (zzzm.booleanValue() != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTablet(Resources resources) {
        boolean z = false;
        AppMethodBeat.i(90168);
        if (resources == null) {
            AppMethodBeat.o(90168);
            return false;
        }
        if (zzzl == null) {
            if (!((resources.getConfiguration().screenLayout & 15) > 3)) {
                if (zzzm == null) {
                    Configuration configuration = resources.getConfiguration();
                    boolean z2 = (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
                    zzzm = Boolean.valueOf(z2);
                }
            }
            z = true;
            zzzl = Boolean.valueOf(z);
        }
        z = zzzl.booleanValue();
        AppMethodBeat.o(90168);
        return z;
    }

    public static boolean isTv(Context context) {
        boolean z;
        AppMethodBeat.i(90175);
        if (zzzu == null) {
            PackageManager packageManager = context.getPackageManager();
            z = packageManager.hasSystemFeature(FEATURE_TV_1) || packageManager.hasSystemFeature(FEATURE_TV_2) || packageManager.hasSystemFeature(FEATURE_TV_3);
            zzzu = Boolean.valueOf(z);
        }
        z = zzzu.booleanValue();
        AppMethodBeat.o(90175);
        return z;
    }

    public static boolean isUserBuild() {
        AppMethodBeat.i(90176);
        boolean z;
        if (GooglePlayServicesUtilLight.sIsTestMode) {
            z = GooglePlayServicesUtilLight.sTestIsUserBuild;
            AppMethodBeat.o(90176);
            return z;
        }
        z = "user".equals(Build.TYPE);
        AppMethodBeat.o(90176);
        return z;
    }

    @TargetApi(20)
    public static boolean isWearable(Context context) {
        boolean z;
        AppMethodBeat.i(90169);
        if (zzzn == null) {
            z = PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            zzzn = Boolean.valueOf(z);
        }
        z = zzzn.booleanValue();
        AppMethodBeat.o(90169);
        return z;
    }

    @TargetApi(24)
    public static boolean isWearableWithoutPlayStore(Context context) {
        AppMethodBeat.i(90170);
        if ((!PlatformVersion.isAtLeastN() || isSidewinder(context)) && isWearable(context)) {
            AppMethodBeat.o(90170);
            return true;
        }
        AppMethodBeat.o(90170);
        return false;
    }

    @VisibleForTesting
    public static void resetForTest() {
        zzzm = null;
        zzzl = null;
        zzzn = null;
        zzzo = null;
        zzzp = null;
        zzzq = null;
        zzzr = null;
        zzzs = null;
        zzzt = null;
        zzzu = null;
        zzzv = null;
    }

    @VisibleForTesting
    public static void setIsAutoForTest(boolean z) {
        AppMethodBeat.i(90184);
        zzzt = Boolean.valueOf(z);
        AppMethodBeat.o(90184);
    }

    @VisibleForTesting
    public static void setIsIoTForTest(boolean z) {
        AppMethodBeat.i(90183);
        zzzr = Boolean.valueOf(z);
        AppMethodBeat.o(90183);
    }

    @VisibleForTesting
    public static void setIsLatchskyForTest(boolean z) {
        AppMethodBeat.i(90182);
        zzzp = Boolean.valueOf(z);
        AppMethodBeat.o(90182);
    }

    @VisibleForTesting
    public static void setIsLowRamForTest(boolean z) {
        AppMethodBeat.i(90186);
        zzzq = Boolean.valueOf(z);
        AppMethodBeat.o(90186);
    }

    @VisibleForTesting
    public static void setIsPixelForTest(boolean z) {
        AppMethodBeat.i(90187);
        zzzv = Boolean.valueOf(z);
        AppMethodBeat.o(90187);
    }

    @VisibleForTesting
    public static void setIsSideWinderForTest(boolean z) {
        AppMethodBeat.i(90181);
        zzzo = Boolean.valueOf(z);
        AppMethodBeat.o(90181);
    }

    @VisibleForTesting
    public static void setIsTvForTest(boolean z) {
        AppMethodBeat.i(90185);
        zzzu = Boolean.valueOf(z);
        AppMethodBeat.o(90185);
    }

    @VisibleForTesting
    public static void setIsWearableForTest(boolean z) {
        AppMethodBeat.i(90180);
        zzzn = Boolean.valueOf(z);
        AppMethodBeat.o(90180);
    }
}
