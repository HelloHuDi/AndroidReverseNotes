package com.tencent.ttpic.device;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.ApiHelper;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceInstance.SOC_CLASS;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceUtils {
    public static final int COLLAGE_MATERIAL_READ_MAX_SIDE = 720;
    public static final int COLLAGE_READ_LOW_MAX_SIDE = 640;
    public static final int COLLAGE_READ_MAX_SIDE = 720;
    public static final long HIGH_END_CPU_COUNT = 4;
    public static final long HIGH_END_MEMORY_SIZE = 256;
    public static final long HIGH_END_SCREEN_SIZE = 1900800;
    public static final int LAZY_HEIGHT = 854;
    public static final int LAZY_WIDTH = 640;
    public static final int[] LONG_COLLAGE_SAVE_MAX_SIDE = new int[]{640, 560, 480, 400, 320};
    public static final long LOW_END_CPU_COUNT = 1;
    public static final long LOW_END_MEMORY_SIZE = 64;
    public static final long LOW_END_SCREEN_SIZE = 307200;
    private static final int MIN_OPENGL_ES_VERSION = 131072;
    public static final int MIN_STORAGE_SIZE = 52428800;
    public static final int MOBILE_NETWORK_2G = 1;
    public static final int MOBILE_NETWORK_3G = 2;
    public static final int MOBILE_NETWORK_4G = 3;
    public static final int MOBILE_NETWORK_DISCONNECT = 5;
    public static final int MOBILE_NETWORK_UNKNOWN = 4;
    public static final int NET_2G = 2;
    public static final int NET_3G = 3;
    public static final int NET_4G = 4;
    public static final int NET_NONE = 0;
    public static final int NET_OTHER = 5;
    public static final int NET_WIFI = 1;
    public static final int[] STORY_COLLAGE_SAVE_MAX_SHORT_SIDE = new int[]{VideoFilterUtil.IMAGE_HEIGHT, 720, 640, 560, 480, 400, 320};
    private static final String TAG = DeviceUtils.class.getSimpleName();
    public static final int TOPIC_FEED_PUBLISH_MAX_SHORT_SIDE = 640;
    private static boolean mIsAllUnusable = false;
    private static boolean mIsOpenGlEsValid = true;
    private static int sCpuCount = 0;
    private static long sMaxCpuFreq = 0;
    private static int sTotalMemory = 0;

    public static class MEMORY_CLASS {
        public static final int IN_B = 0;
        public static final int IN_KB = 1;
        public static final int IN_MB = 2;
    }

    /* renamed from: com.tencent.ttpic.device.DeviceUtils$1CpuFilter */
    class C365621CpuFilter implements FileFilter {
        C365621CpuFilter() {
        }

        public boolean accept(File file) {
            AppMethodBeat.m2504i(49868);
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                AppMethodBeat.m2505o(49868);
                return true;
            }
            AppMethodBeat.m2505o(49868);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(49928);
        AppMethodBeat.m2505o(49928);
    }

    public static boolean isVeryLowEndDevice() {
        boolean z = false;
        AppMethodBeat.m2504i(49869);
        LogUtils.m50207i(TAG, "[isVeryLowEndDevice] + BEGIN");
        SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.m50207i(TAG, "[isVeryLowEndDevice] socClass = ".concat(String.valueOf(deviceSocClass)));
        if (deviceSocClass != SOC_CLASS.NULL && deviceSocClass == SOC_CLASS.V_LOW) {
            z = true;
        }
        LogUtils.m50207i(TAG, "[isVeryLowEndDevice] + END, isVeryLowDevice = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49869);
        return z;
    }

    public static boolean isSmoothHidden(Context context) {
        AppMethodBeat.m2504i(49870);
        if (isLowEndDevice(context) || isVeryLowEndDevice()) {
            AppMethodBeat.m2505o(49870);
            return true;
        }
        AppMethodBeat.m2505o(49870);
        return false;
    }

    public static boolean isLowEndDevice(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(49871);
        LogUtils.m50207i(TAG, "[isLowEndDevice] + BEGIN");
        SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.m50207i(TAG, "[isLowEndDevice] socClass = ".concat(String.valueOf(deviceSocClass)));
        if (deviceSocClass == SOC_CLASS.NULL) {
            boolean z2;
            boolean z3;
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            boolean z4 = ((long) (screenWidth * screenHeight)) <= LOW_END_SCREEN_SIZE;
            LogUtils.m50199d(TAG, "[isLowEndDevice] isLowEndDisplay = " + z4 + ", widthPixels = " + screenWidth + ", heightPixels = " + screenHeight);
            long heapMaxSizeInMb = getHeapMaxSizeInMb(context);
            if (heapMaxSizeInMb <= 64) {
                z2 = true;
            } else {
                z2 = false;
            }
            LogUtils.m50199d(TAG, "[isLowEndDevice] isLowMemory = " + z2 + ", deviceHeapSize(Mb) = " + heapMaxSizeInMb);
            int numCores = getNumCores();
            if (((long) numCores) <= 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            LogUtils.m50199d(TAG, "[isLowEndDevice] isLowCpuCount = " + z3 + ", cpuCount = " + numCores);
            if (!(z4 || z2 || z3)) {
                z = false;
            }
        } else if (deviceSocClass != SOC_CLASS.LOW) {
            z = false;
        }
        LogUtils.m50207i(TAG, "[isLowEndDevice] + END, isLowEndDevice = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49871);
        return z;
    }

    public static boolean isHighEndDevice(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(49872);
        LogUtils.m50207i(TAG, "[isHighEndDevice] + BEGIN");
        SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.m50207i(TAG, "[isHighEndDevice] socClass = ".concat(String.valueOf(deviceSocClass)));
        if (deviceSocClass == SOC_CLASS.NULL) {
            boolean z2;
            boolean z3;
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            boolean z4 = ((long) (screenWidth * screenHeight)) >= HIGH_END_SCREEN_SIZE;
            LogUtils.m50199d(TAG, "[isHighEndDevice] isHighDisplay = " + z4 + ", widthPixels = " + screenWidth + ", heightPixels = " + screenHeight);
            long heapMaxSizeInMb = getHeapMaxSizeInMb(context);
            if (heapMaxSizeInMb >= 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            LogUtils.m50199d(TAG, "[isHighEndDevice] isHighMemory = " + z2 + ", deviceHeapSize(Mb) = " + heapMaxSizeInMb);
            int numCores = getNumCores();
            if (((long) numCores) >= 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            LogUtils.m50199d(TAG, "[isHighEndDevice] isHighCpuCount = " + z3 + ", cpuCount = " + numCores);
            if (!(z4 && z2 && z3)) {
                z = false;
            }
        } else if (deviceSocClass != SOC_CLASS.HIGH) {
            z = false;
        }
        LogUtils.m50207i(TAG, "[isHighEndDevice] + END, isHighEndDevice = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49872);
        return z;
    }

    public static boolean isMiddleEndDevice(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(49873);
        LogUtils.m50207i(TAG, "[isMiddleEndDevice] + BEGIN");
        SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.m50207i(TAG, "[isMiddleEndDevice] socClass = ".concat(String.valueOf(deviceSocClass)));
        if (deviceSocClass != SOC_CLASS.NULL) {
            if (deviceSocClass != SOC_CLASS.NORMAL) {
                z = false;
            }
        } else if (isLowEndDevice(context) || isHighEndDevice(context)) {
            z = false;
        }
        LogUtils.m50207i(TAG, "[isMiddleEndDevice] + END, isMiddleEndDevice = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49873);
        return z;
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.m2504i(49874);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.m2505o(49874);
        return i;
    }

    public static int getScreenHeight(Context context) {
        AppMethodBeat.m2504i(49875);
        int i = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.m2505o(49875);
        return i;
    }

    public static float getScreenRatio(Context context) {
        AppMethodBeat.m2504i(49876);
        int screenWidth = getScreenWidth(context);
        int screenHeight = getScreenHeight(context);
        int max = Math.max(screenWidth, screenHeight);
        screenWidth = Math.min(screenWidth, screenHeight);
        if (NotchInScreenUtils.hasNotchInScreenHw(context)) {
            max -= NotchInScreenUtils.getNotchHeightHw(context);
        }
        float f = (((float) screenWidth) * 1.0f) / ((float) max);
        AppMethodBeat.m2505o(49876);
        return f;
    }

    public static long getHeapMaxSizeInMb(Context context) {
        long memoryClass;
        AppMethodBeat.m2504i(49877);
        long runtimeMaxMemory = getRuntimeMaxMemory(2);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            LogUtils.m50210v(TAG, "getHeapMaxSizeInMb(), heap size(Mb) = " + activityManager.getMemoryClass());
            memoryClass = (long) activityManager.getMemoryClass();
        } catch (Exception e) {
            LogUtils.m50206e(e);
            memoryClass = runtimeMaxMemory;
        }
        AppMethodBeat.m2505o(49877);
        return memoryClass;
    }

    public static long getHeapMaxSizeInKb(Context context) {
        long memoryClass;
        AppMethodBeat.m2504i(49878);
        long runtimeMaxMemory = getRuntimeMaxMemory(1);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            LogUtils.m50210v(TAG, "getHeapMaxSizeInKb(), heap size(Mb) = " + activityManager.getMemoryClass());
            memoryClass = (long) (activityManager.getMemoryClass() * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } catch (Exception e) {
            LogUtils.m50206e(e);
            memoryClass = runtimeMaxMemory;
        }
        AppMethodBeat.m2505o(49878);
        return memoryClass;
    }

    public static long getLargeHeapMaxSizeInKb(Context context) {
        long largeMemoryClass;
        AppMethodBeat.m2504i(49879);
        long runtimeMaxMemory = getRuntimeMaxMemory(1);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            LogUtils.m50210v(TAG, "getLargeHeapMaxSizeInKb(), heap size(Mb) = " + activityManager.getLargeMemoryClass());
            largeMemoryClass = (long) (activityManager.getLargeMemoryClass() * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } catch (Exception e) {
            LogUtils.m50206e(e);
            largeMemoryClass = runtimeMaxMemory;
        }
        AppMethodBeat.m2505o(49879);
        return largeMemoryClass;
    }

    public static long getHeapRemainSizeInKb(Context context) {
        AppMethodBeat.m2504i(49880);
        long heapMaxSizeInKb = getHeapMaxSizeInKb(context) - getHeapAllocatedSizeInKb();
        LogUtils.m50210v(TAG, "getHeapRemainSizeInKb(), remainSize = " + (((float) heapMaxSizeInKb) / 1024.0f) + "(Mb), " + heapMaxSizeInKb + "(Kb)");
        AppMethodBeat.m2505o(49880);
        return heapMaxSizeInKb;
    }

    public static long getLargeHeapRemainSizeInKb(Context context) {
        AppMethodBeat.m2504i(49881);
        long largeHeapMaxSizeInKb = getLargeHeapMaxSizeInKb(context) - getHeapAllocatedSizeInKb();
        LogUtils.m50210v(TAG, "getLargeHeapRemainSizeInKb(), remainSize = " + (((float) largeHeapMaxSizeInKb) / 1024.0f) + "(Mb), " + largeHeapMaxSizeInKb + "(Kb)");
        AppMethodBeat.m2505o(49881);
        return largeHeapMaxSizeInKb;
    }

    public static long getHeapAllocatedSizeInKb() {
        AppMethodBeat.m2504i(49882);
        long runtimeTotalMemory = getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
        LogUtils.m50210v(TAG, "getHeapAllocatedSizeInKb(), heapAllocated = " + (((float) runtimeTotalMemory) / 1024.0f) + "(Mb), " + runtimeTotalMemory + "(Kb)");
        AppMethodBeat.m2505o(49882);
        return runtimeTotalMemory;
    }

    public static float getHeapAllocatedPercent(Context context) {
        AppMethodBeat.m2504i(49883);
        LogUtils.m50212v(TAG, "getHeapAllocatedPercent(), percent = %f", Float.valueOf((((float) getHeapAllocatedSizeInKb()) * 1.0f) / ((float) getHeapMaxSizeInKb(context))));
        AppMethodBeat.m2505o(49883);
        return (((float) getHeapAllocatedSizeInKb()) * 1.0f) / ((float) getHeapMaxSizeInKb(context));
    }

    private static long getRuntimeMaxMemory(int i) {
        AppMethodBeat.m2504i(49884);
        long maxMemory = Runtime.getRuntime().maxMemory();
        switch (i) {
            case 0:
                maxMemory = Runtime.getRuntime().maxMemory();
                break;
            case 1:
                maxMemory = Runtime.getRuntime().maxMemory() / 1024;
                break;
            case 2:
                maxMemory = (Runtime.getRuntime().maxMemory() / 1024) / 1024;
                break;
        }
        LogUtils.m50210v(TAG, "[getRuntimeMaxMemory] maxMemory = " + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + "(Mb), " + (Runtime.getRuntime().maxMemory() / 1024) + "(Kb)");
        AppMethodBeat.m2505o(49884);
        return maxMemory;
    }

    public static long getRuntimeRemainSize(int i) {
        AppMethodBeat.m2504i(49885);
        long maxMemory = Runtime.getRuntime().maxMemory() - (getHeapAllocatedSizeInKb() * 1024);
        switch (i) {
            case 1:
                maxMemory /= 1024;
                break;
            case 2:
                maxMemory /= 1048576;
                break;
        }
        LogUtils.m50210v(TAG, "[getRuntimeRemainSize] remainMemory = " + maxMemory + " " + i);
        AppMethodBeat.m2505o(49885);
        return maxMemory;
    }

    private static long getRuntimeTotalMemory(int i) {
        long totalMemory;
        AppMethodBeat.m2504i(49886);
        switch (i) {
            case 0:
                totalMemory = Runtime.getRuntime().totalMemory();
                break;
            case 1:
                totalMemory = Runtime.getRuntime().totalMemory() / 1024;
                break;
            case 2:
                totalMemory = (Runtime.getRuntime().totalMemory() / 1024) / 1024;
                break;
            default:
                totalMemory = Runtime.getRuntime().totalMemory();
                break;
        }
        LogUtils.m50210v(TAG, "[getRuntimeTotalMemory] totalMemory = " + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + "(Mb), " + (Runtime.getRuntime().totalMemory() / 1024) + "(Kb)");
        AppMethodBeat.m2505o(49886);
        return totalMemory;
    }

    private static long getRuntimeFreeMemory(int i) {
        long freeMemory;
        AppMethodBeat.m2504i(49887);
        switch (i) {
            case 0:
                freeMemory = Runtime.getRuntime().freeMemory();
                break;
            case 1:
                freeMemory = Runtime.getRuntime().freeMemory() / 1024;
                break;
            case 2:
                freeMemory = (Runtime.getRuntime().freeMemory() / 1024) / 1024;
                break;
            default:
                freeMemory = Runtime.getRuntime().freeMemory();
                break;
        }
        LogUtils.m50210v(TAG, "[getRuntimeFreeMemory] freeMemory = " + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + "(Mb), " + (Runtime.getRuntime().freeMemory() / 1024) + "(Kb)");
        AppMethodBeat.m2505o(49887);
        return freeMemory;
    }

    public static int getNumCores() {
        AppMethodBeat.m2504i(49888);
        int i;
        if (sCpuCount > 0) {
            i = sCpuCount;
            AppMethodBeat.m2505o(49888);
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C365621CpuFilter());
            if (listFiles != null) {
                sCpuCount = listFiles.length;
            } else {
                sCpuCount = 1;
            }
        } catch (Throwable th) {
            LogUtils.m50206e(th);
            sCpuCount = 1;
        }
        LogUtils.m50210v("DeviceUtils", "sCpuCount:" + sCpuCount);
        i = sCpuCount;
        AppMethodBeat.m2505o(49888);
        return i;
    }

    public static long getMaxCpuFreq() {
        AppMethodBeat.m2504i(49889);
        long j;
        if (sMaxCpuFreq > 0) {
            j = sMaxCpuFreq;
            AppMethodBeat.m2505o(49889);
            return j;
        }
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            LogUtils.m50206e(e);
            str = "";
        }
        str = str.trim();
        if (str == null || str.length() == 0) {
            sMaxCpuFreq = 1;
        } else {
            try {
                sMaxCpuFreq = Long.parseLong(str);
            } catch (NumberFormatException e2) {
                sMaxCpuFreq = 1;
            }
        }
        LogUtils.m50210v("DeviceUtils", "sMaxCpuFreq:" + sMaxCpuFreq);
        j = sMaxCpuFreq;
        AppMethodBeat.m2505o(49889);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A:{SYNTHETIC, Splitter:B:17:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A:{SYNTHETIC, Splitter:B:23:0x0041} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A:{SYNTHETIC, Splitter:B:29:0x004c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getCpuName() {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        AppMethodBeat.m2504i(49890);
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"));
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    str = readLine.split(":\\s+", 2)[1];
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.m2505o(49890);
                    return str;
                }
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.m2505o(49890);
                return str;
            } catch (FileNotFoundException e3) {
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(49890);
                return str;
            } catch (IOException e4) {
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(49890);
                return str;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(49890);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(49890);
            return str;
        } catch (IOException e7) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e8) {
                }
            }
            AppMethodBeat.m2505o(49890);
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e9) {
                }
            }
            AppMethodBeat.m2505o(49890);
            throw th;
        }
    }

    public static String getImei(Context context) {
        String deviceId;
        AppMethodBeat.m2504i(49891);
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                LogUtils.m50207i(TAG, "[getImei] IMEI: ".concat(String.valueOf(deviceId)));
                AppMethodBeat.m2505o(49891);
                return deviceId;
            }
        } catch (Throwable th) {
            LogUtils.m50206e(th);
        }
        deviceId = "";
        AppMethodBeat.m2505o(49891);
        return deviceId;
    }

    @TargetApi(18)
    public static long getTotalSize(StatFs statFs) {
        long totalBytes;
        AppMethodBeat.m2504i(49892);
        if (ApiHelper.hasJellyBeanMR2()) {
            totalBytes = statFs.getTotalBytes();
        } else {
            totalBytes = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        }
        AppMethodBeat.m2505o(49892);
        return totalBytes;
    }

    @TargetApi(18)
    public static long getAvailableSize(StatFs statFs) {
        long availableBytes;
        AppMethodBeat.m2504i(49893);
        if (ApiHelper.hasJellyBeanMR2()) {
            availableBytes = statFs.getAvailableBytes();
        } else {
            availableBytes = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        }
        AppMethodBeat.m2505o(49893);
        return availableBytes;
    }

    public static boolean isExternalStorageAvailable() {
        AppMethodBeat.m2504i(49894);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                AppMethodBeat.m2505o(49894);
                return true;
            }
            AppMethodBeat.m2505o(49894);
            return false;
        } catch (Exception e) {
            AppMethodBeat.m2505o(49894);
            return false;
        }
    }

    public static boolean isExternalStorageSpaceEnough(long j) {
        AppMethodBeat.m2504i(49895);
        try {
            if (getAvailableSize(new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath())) > j) {
                AppMethodBeat.m2505o(49895);
                return true;
            }
            AppMethodBeat.m2505o(49895);
            return false;
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(49895);
            return false;
        }
    }

    public static File getExternalFilesDir(Context context) {
        AppMethodBeat.m2504i(49896);
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files/"));
        }
        AppMethodBeat.m2505o(49896);
        return externalFilesDir;
    }

    public static File getExternalFilesDir(Context context, String str) {
        AppMethodBeat.m2504i(49897);
        String str2 = null;
        if (isExternalStorageAvailable() && isExternalStorageSpaceEnough(52428800)) {
            str2 = getExternalFilesDir(context).getPath();
        }
        File file = new File(str2 + File.separator + str);
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(49897);
        return file;
    }

    public static int getVersionCode(Context context) {
        AppMethodBeat.m2504i(49898);
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
            AppMethodBeat.m2505o(49898);
            return i;
        } catch (Exception e) {
            AppMethodBeat.m2505o(49898);
            return -1;
        }
    }

    public static int getVersionNameCode(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(49899);
        String[] split = getVersionName(context).split("\\.");
        String str = "";
        if (split.length >= 3) {
            str = split[i] + split[1] + split[2];
        }
        try {
            i = Integer.parseInt(str);
            AppMethodBeat.m2505o(49899);
        } catch (Throwable th) {
            LogUtils.m50206e(th);
            AppMethodBeat.m2505o(49899);
        }
        return i;
    }

    public static String getVersionName(Context context) {
        AppMethodBeat.m2504i(49900);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            AppMethodBeat.m2505o(49900);
            return str;
        } catch (Exception e) {
            AppMethodBeat.m2505o(49900);
            return null;
        }
    }

    public static String getBuildVersionName(Context context) {
        AppMethodBeat.m2504i(49901);
        String versionName = getVersionName(context);
        if (TextUtils.isEmpty(versionName)) {
            versionName = "";
            AppMethodBeat.m2505o(49901);
            return versionName;
        }
        versionName = versionName.substring(versionName.lastIndexOf(".") + 1);
        AppMethodBeat.m2505o(49901);
        return versionName;
    }

    public static String getOSVersion() {
        return VERSION.RELEASE;
    }

    public static String getMachineInfo() {
        AppMethodBeat.m2504i(49902);
        String deviceName = DeviceInstance.getInstance().getDeviceName();
        AppMethodBeat.m2505o(49902);
        return deviceName;
    }

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.m2504i(49903);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(49903);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            AppMethodBeat.m2505o(49903);
            return false;
        }
        AppMethodBeat.m2505o(49903);
        return true;
    }

    public static boolean isValid(Context context) {
        AppMethodBeat.m2504i(49904);
        mIsOpenGlEsValid = getOpenGlEsVersion(context) >= 131072;
        mIsAllUnusable = false;
        if (mIsOpenGlEsValid) {
            AppMethodBeat.m2505o(49904);
            return true;
        }
        AppMethodBeat.m2505o(49904);
        return false;
    }

    public static int getOpenGlEsVersion(Context context) {
        AppMethodBeat.m2504i(49905);
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            int i = deviceConfigurationInfo.reqGlEsVersion;
            AppMethodBeat.m2505o(49905);
            return i;
        }
        AppMethodBeat.m2505o(49905);
        return 65536;
    }

    public static int getScreenHeightWithNavigationBar(Activity activity) {
        AppMethodBeat.m2504i(49906);
        int screenHeight = getScreenHeight(activity) + getNavigationBarHeight(activity);
        AppMethodBeat.m2505o(49906);
        return screenHeight;
    }

    public static int getNavigationBarHeight(Activity activity) {
        AppMethodBeat.m2504i(49907);
        if (isNavigationBarShow(activity)) {
            Resources resources = activity.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
            AppMethodBeat.m2505o(49907);
            return dimensionPixelSize;
        }
        AppMethodBeat.m2505o(49907);
        return 0;
    }

    public static boolean isNavigationBarShow(Activity activity) {
        AppMethodBeat.m2504i(49908);
        if (VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y != point.y) {
                AppMethodBeat.m2505o(49908);
                return true;
            }
            AppMethodBeat.m2505o(49908);
            return false;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            AppMethodBeat.m2505o(49908);
            return false;
        }
        AppMethodBeat.m2505o(49908);
        return true;
    }

    public static String getScreenSize(Context context) {
        AppMethodBeat.m2504i(49909);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        AppMethodBeat.m2505o(49909);
        return str;
    }

    public static boolean veryLargeScreen(Context context) {
        AppMethodBeat.m2504i(49910);
        if (getScreenHeight(context) * getScreenWidth(context) >= 2073600) {
            AppMethodBeat.m2505o(49910);
            return true;
        }
        AppMethodBeat.m2505o(49910);
        return false;
    }

    public static String getLocalIpAddress() {
        String trim;
        AppMethodBeat.m2504i(49911);
        try {
            if (NetworkInterface.getNetworkInterfaces() != null) {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    if (networkInterfaces != null) {
                        NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                        if (networkInterface != null) {
                            Enumeration inetAddresses = networkInterface.getInetAddresses();
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                                try {
                                    if (!(inetAddress.isLoopbackAddress() || !(inetAddress instanceof Inet4Address) || Inet4Address.getByName(inetAddress.getHostAddress()) == null || inetAddress.getHostAddress().equals(BuildConfig.COMMAND) || inetAddress.getHostAddress() == null)) {
                                        trim = inetAddress.getHostAddress().trim();
                                        AppMethodBeat.m2505o(49911);
                                        return trim;
                                    }
                                } catch (UnknownHostException e) {
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (SocketException e2) {
            LogUtils.m50206e(e2);
        }
        trim = "";
        AppMethodBeat.m2505o(49911);
        return trim;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getLocalRealIpAddress() {
        String str;
        CharSequence charSequence;
        String charSequence2;
        AppMethodBeat.m2504i(49912);
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            Object obj = null;
            CharSequence charSequence3 = null;
            str = null;
            while (networkInterfaces != null) {
                try {
                    if (!networkInterfaces.hasMoreElements() || obj != null) {
                        break;
                    }
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) == -1) {
                            charSequence3 = inetAddress.getHostAddress();
                            obj = 1;
                            break;
                        } else if (inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) == -1) {
                            str = inetAddress.getHostAddress();
                        }
                    }
                } catch (SocketException e) {
                    charSequence2 = charSequence3;
                    if (TextUtils.isEmpty(charSequence2)) {
                        AppMethodBeat.m2505o(49912);
                        return charSequence2;
                    }
                    charSequence2 = getExternalLocalIpAddress();
                    if (TextUtils.isEmpty(charSequence2)) {
                        AppMethodBeat.m2505o(49912);
                        return str;
                    }
                    AppMethodBeat.m2505o(49912);
                    return charSequence2;
                } catch (Throwable th) {
                    charSequence2 = charSequence3;
                    if (TextUtils.isEmpty(charSequence2)) {
                        AppMethodBeat.m2505o(49912);
                        return charSequence2;
                    }
                    charSequence2 = getExternalLocalIpAddress();
                    if (TextUtils.isEmpty(charSequence2)) {
                        AppMethodBeat.m2505o(49912);
                        return str;
                    }
                    AppMethodBeat.m2505o(49912);
                    return charSequence2;
                }
            }
            if (TextUtils.isEmpty(charSequence3)) {
                charSequence2 = getExternalLocalIpAddress();
                if (TextUtils.isEmpty(charSequence2)) {
                    AppMethodBeat.m2505o(49912);
                    return str;
                }
                AppMethodBeat.m2505o(49912);
                return charSequence2;
            }
            AppMethodBeat.m2505o(49912);
            return charSequence3;
        } catch (SocketException e2) {
            charSequence2 = null;
            str = null;
            if (TextUtils.isEmpty(charSequence2)) {
            }
        } catch (Throwable th2) {
            charSequence2 = null;
            str = null;
            if (TextUtils.isEmpty(charSequence2)) {
            }
        }
    }

    public static boolean isMobileNetwork(Context context) {
        AppMethodBeat.m2504i(49913);
        if (context == null) {
            AppMethodBeat.m2505o(49913);
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(49913);
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            AppMethodBeat.m2505o(49913);
            return true;
        }
        AppMethodBeat.m2505o(49913);
        return false;
    }

    public static boolean isWifiNetwork(Context context) {
        AppMethodBeat.m2504i(49914);
        if (context == null) {
            AppMethodBeat.m2505o(49914);
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(49914);
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            AppMethodBeat.m2505o(49914);
            return true;
        }
        AppMethodBeat.m2505o(49914);
        return false;
    }

    public static int getNetworkType(Context context) {
        AppMethodBeat.m2504i(49915);
        int i = 5;
        try {
            if (isNetworkAvailable(context)) {
                if (!isWifiNetwork(context)) {
                    switch (getMobileNetworkType(context)) {
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 3;
                            break;
                        case 3:
                            i = 4;
                            break;
                    }
                }
                i = 1;
            } else {
                i = 0;
            }
        } catch (Exception e) {
            LogUtils.m50206e(e);
        }
        AppMethodBeat.m2505o(49915);
        return i;
    }

    public static int getMobileNetworkType(Context context) {
        AppMethodBeat.m2504i(49916);
        if (context == null) {
            AppMethodBeat.m2505o(49916);
            return 4;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(49916);
            return 4;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                    AppMethodBeat.m2505o(49916);
                    return 1;
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 15:
                    AppMethodBeat.m2505o(49916);
                    return 2;
                case 13:
                    AppMethodBeat.m2505o(49916);
                    return 3;
                default:
                    AppMethodBeat.m2505o(49916);
                    return 4;
            }
        }
        AppMethodBeat.m2505o(49916);
        return 5;
    }

    public static String getNetworkTypeName(Context context) {
        AppMethodBeat.m2504i(49917);
        String str;
        switch (getNetworkType(context)) {
            case 0:
                str = "none";
                AppMethodBeat.m2505o(49917);
                return str;
            case 1:
                str = "wifi";
                AppMethodBeat.m2505o(49917);
                return str;
            case 2:
                str = "2G";
                AppMethodBeat.m2505o(49917);
                return str;
            case 3:
                str = "3G";
                AppMethodBeat.m2505o(49917);
                return str;
            case 4:
                str = "4G";
                AppMethodBeat.m2505o(49917);
                return str;
            default:
                str = "unknow";
                AppMethodBeat.m2505o(49917);
                return str;
        }
    }

    public static String getExternalLocalIpAddress() {
        AppMethodBeat.m2504i(49918);
        String fetchExternalIpProviderHTML = fetchExternalIpProviderHTML("http://checkip.dyndns.org/");
        if (fetchExternalIpProviderHTML == null) {
            AppMethodBeat.m2505o(49918);
            return null;
        }
        fetchExternalIpProviderHTML = parse(fetchExternalIpProviderHTML);
        AppMethodBeat.m2505o(49918);
        return fetchExternalIpProviderHTML;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A:{SYNTHETIC, Splitter:B:23:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A:{Catch:{ Exception -> 0x0095 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{SYNTHETIC, Splitter:B:31:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A:{Catch:{ Exception -> 0x0073 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b A:{SYNTHETIC, Splitter:B:39:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0080 A:{Catch:{ Exception -> 0x0087 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A:{SYNTHETIC, Splitter:B:23:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A:{Catch:{ Exception -> 0x0095 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{SYNTHETIC, Splitter:B:31:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f A:{Catch:{ Exception -> 0x0073 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b A:{SYNTHETIC, Splitter:B:39:0x007b} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0080 A:{Catch:{ Exception -> 0x0087 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String fetchExternalIpProviderHTML(String str) {
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        AppMethodBeat.m2504i(49919);
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                HttpURLConnection.setFollowRedirects(true);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
                inputStream2 = httpURLConnection2.getInputStream();
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    int i = 0;
                    while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        int read = inputStream2.read(bArr, i, 1024 - i);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    }
                    String str2 = new String(bArr, "UTF-8");
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(49919);
                    return str2;
                } catch (MalformedURLException e2) {
                    inputStream = inputStream2;
                    if (inputStream != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    AppMethodBeat.m2505o(49919);
                    return null;
                } catch (IOException e3) {
                    if (inputStream2 != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    AppMethodBeat.m2505o(49919);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (inputStream2 != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    AppMethodBeat.m2505o(49919);
                    throw th;
                }
            } catch (MalformedURLException e4) {
                inputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                        AppMethodBeat.m2505o(49919);
                        return null;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                AppMethodBeat.m2505o(49919);
                return null;
            } catch (IOException e6) {
                inputStream2 = null;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                        AppMethodBeat.m2505o(49919);
                        return null;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                AppMethodBeat.m2505o(49919);
                return null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                inputStream2 = null;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e8) {
                        AppMethodBeat.m2505o(49919);
                        throw th;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                AppMethodBeat.m2505o(49919);
                throw th;
            }
        } catch (MalformedURLException e9) {
            httpURLConnection2 = null;
            inputStream = null;
            if (inputStream != null) {
            }
            if (httpURLConnection2 != null) {
            }
            AppMethodBeat.m2505o(49919);
            return null;
        } catch (IOException e10) {
            httpURLConnection2 = null;
            inputStream2 = null;
            if (inputStream2 != null) {
            }
            if (httpURLConnection2 != null) {
            }
            AppMethodBeat.m2505o(49919);
            return null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream2 = null;
            if (inputStream2 != null) {
            }
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(49919);
            throw th;
        }
    }

    private static String parse(String str) {
        AppMethodBeat.m2504i(49920);
        Matcher matcher = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", 2).matcher(str);
        if (matcher.find()) {
            String group = matcher.group(0);
            AppMethodBeat.m2505o(49920);
            return group;
        }
        AppMethodBeat.m2505o(49920);
        return null;
    }

    public static boolean canWriteFile(String str) {
        AppMethodBeat.m2504i(49921);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(49921);
            return false;
        }
        if (!str.endsWith(File.separator)) {
            str = str.substring(0, str.lastIndexOf(File.separator));
        }
        File file = new File(str + File.separator + "test_temp.txt");
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            file.delete();
            AppMethodBeat.m2505o(49921);
            return true;
        } catch (Exception e) {
            file.delete();
            AppMethodBeat.m2505o(49921);
            return false;
        }
    }

    public static float getWindowScreenBrightness(Window window) {
        AppMethodBeat.m2504i(49922);
        float f = window.getAttributes().screenBrightness;
        AppMethodBeat.m2505o(49922);
        return f;
    }

    public static void setWindowScreenBrightness(Window window, float f) {
        AppMethodBeat.m2504i(49923);
        LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
        AppMethodBeat.m2505o(49923);
    }

    public static int getSystemScreenBrightness(ContentResolver contentResolver) {
        AppMethodBeat.m2504i(49924);
        int i = 0;
        try {
            i = System.getInt(contentResolver, "screen_brightness");
        } catch (Exception e) {
            LogUtils.m50206e(e);
        }
        AppMethodBeat.m2505o(49924);
        return i;
    }

    public static int getSystemScreenMode(ContentResolver contentResolver) {
        AppMethodBeat.m2504i(49925);
        int i = -1;
        try {
            i = System.getInt(contentResolver, "screen_brightness_mode");
        } catch (Exception e) {
            LogUtils.m50206e(e);
        }
        AppMethodBeat.m2505o(49925);
        return i;
    }

    public static void setSystemScreenMode(ContentResolver contentResolver, int i) {
        AppMethodBeat.m2504i(49926);
        try {
            System.putInt(contentResolver, "screen_brightness_mode", i);
            contentResolver.notifyChange(System.getUriFor("screen_brightness_mode"), null);
            AppMethodBeat.m2505o(49926);
        } catch (Exception e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49926);
        }
    }

    public static void setSystemScreenBrightness(ContentResolver contentResolver, int i) {
        AppMethodBeat.m2504i(49927);
        try {
            System.putInt(contentResolver, "screen_brightness", i);
            AppMethodBeat.m2505o(49927);
        } catch (Exception e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49927);
        }
    }
}
