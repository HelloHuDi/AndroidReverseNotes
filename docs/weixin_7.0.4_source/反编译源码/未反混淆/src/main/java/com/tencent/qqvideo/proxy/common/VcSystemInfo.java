package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class VcSystemInfo {
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int NETWORK_AP_3G = 2;
    public static final int NETWORK_AP_GPRS = 3;
    public static final int NETWORK_AP_LINE = 4;
    public static final int NETWORK_AP_WIFI = 1;
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_NONE = 0;
    private static final int NETWORK_TYPE_1xRTT = 7;
    private static final int NETWORK_TYPE_CDMA = 4;
    private static final int NETWORK_TYPE_EDGE = 2;
    private static final int NETWORK_TYPE_EHRPD = 14;
    private static final int NETWORK_TYPE_EVDO_0 = 5;
    private static final int NETWORK_TYPE_EVDO_A = 6;
    private static final int NETWORK_TYPE_EVDO_B = 12;
    private static final int NETWORK_TYPE_GPRS = 1;
    private static final int NETWORK_TYPE_HSDPA = 8;
    private static final int NETWORK_TYPE_HSPA = 10;
    private static final int NETWORK_TYPE_HSPAP = 15;
    private static final int NETWORK_TYPE_HSUPA = 9;
    private static final int NETWORK_TYPE_IDEN = 11;
    private static final int NETWORK_TYPE_LTE = 13;
    private static final int NETWORK_TYPE_UMTS = 3;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_6 = 6;
    private static final String TAG = "VcSystemInfo";
    public static final int TYPE_CMNET = 2;
    public static final int TYPE_CMWAP = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OTHER = 4;
    public static final int TYPE_WIFI = 1;
    private static int appVersionCode = 0;
    private static String appVersionName;
    private static String deviceID = "";
    private static String deviceIMEI;
    private static String deviceIMSI;
    private static String deviceMacAddr;
    public static int mCpuArchitecture = 0;
    public static String mCpuHardware = "";
    private static int mDeviceLevel = 0;
    public static String mFeature = "";
    private static int mMCC = 0;
    private static int mMNC = 0;
    public static String mProcessorName = "N/A";
    public static int mScreenHeight;
    public static int mScreenWidth;
    public int mCoreNumber = 1;
    public long mCurrCpuFreq = 0;
    private long mLastCpu;
    private long mLastIdle;
    public long mMaxCpuFreq = 0;
    public int mdispHeight;
    public int mdispWidth;

    public VcSystemInfo() {
        mScreenWidth = 320;
        mScreenHeight = 480;
        this.mdispWidth = 320;
        this.mdispHeight = 240;
        this.mLastCpu = 0;
        this.mLastIdle = 0;
    }

    public static String getDeviceIMEI(Context context) {
        AppMethodBeat.i(124429);
        String str;
        if (!TextUtils.isEmpty(deviceIMEI)) {
            str = deviceIMEI;
            AppMethodBeat.o(124429);
            return str;
        } else if (context == null) {
            str = "";
            AppMethodBeat.o(124429);
            return str;
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                    deviceIMEI = str;
                    if (str == null) {
                        deviceIMEI = "";
                    }
                    str = deviceIMEI;
                    AppMethodBeat.o(124429);
                    return str;
                }
            } catch (Throwable th) {
            }
            str = "";
            AppMethodBeat.o(124429);
            return str;
        }
    }

    public static String getDeviceIMSI(Context context) {
        AppMethodBeat.i(124430);
        String str;
        if (!TextUtils.isEmpty(deviceIMSI)) {
            str = deviceIMSI;
            AppMethodBeat.o(124430);
            return str;
        } else if (context == null) {
            str = "";
            AppMethodBeat.o(124430);
            return str;
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                    deviceIMSI = str;
                    if (str == null) {
                        deviceIMSI = "";
                    }
                    str = deviceIMSI;
                    AppMethodBeat.o(124430);
                    return str;
                }
            } catch (Throwable th) {
            }
            str = "";
            AppMethodBeat.o(124430);
            return str;
        }
    }

    public static String getDeviceID(Context context) {
        AppMethodBeat.i(124431);
        String str;
        if (!TextUtils.isEmpty(deviceID)) {
            str = deviceID;
            AppMethodBeat.o(124431);
            return str;
        } else if (context == null) {
            str = "";
            AppMethodBeat.o(124431);
            return str;
        } else {
            try {
                str = System.getString(context.getContentResolver(), "android_id");
                deviceID = str;
                if (str == null) {
                    deviceID = "";
                }
            } catch (Throwable th) {
                deviceID = "";
            }
            str = deviceID;
            AppMethodBeat.o(124431);
            return str;
        }
    }

    public static String getDeviceMacAddr(Context context) {
        AppMethodBeat.i(124432);
        String str;
        if (!TextUtils.isEmpty(deviceMacAddr)) {
            str = deviceMacAddr;
            AppMethodBeat.o(124432);
            return str;
        } else if (context == null) {
            str = "";
            AppMethodBeat.o(124432);
            return str;
        } else {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        str = connectionInfo.getMacAddress();
                        deviceMacAddr = str;
                        if (str == null) {
                            deviceMacAddr = "";
                        }
                        str = deviceMacAddr;
                        AppMethodBeat.o(124432);
                        return str;
                    }
                }
            } catch (Throwable th) {
            }
            str = "";
            AppMethodBeat.o(124432);
            return str;
        }
    }

    public static String getOsVersion() {
        return VERSION.RELEASE;
    }

    public static int getOsVerIntFromVerStr() {
        AppMethodBeat.i(124433);
        String osVersion = getOsVersion();
        int osVerInt = getOsVerInt();
        if (osVersion.length() >= 3) {
            try {
                int parseInt = Integer.parseInt(osVersion.substring(0, 1));
                int parseInt2 = Integer.parseInt(osVersion.substring(2, 3));
                if (parseInt != 2) {
                    if (parseInt == 4) {
                        switch (parseInt2) {
                            case 0:
                                osVerInt = 14;
                                break;
                            case 1:
                                osVerInt = 16;
                                break;
                            case 2:
                                osVerInt = 17;
                                break;
                            case 3:
                                osVerInt = 18;
                                break;
                            case 4:
                                osVerInt = 19;
                                break;
                        }
                    }
                } else if (parseInt2 == 3) {
                    osVerInt = 9;
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(124433);
        return osVerInt;
    }

    public static int getOsVerInt() {
        switch (VERSION.SDK_INT) {
            case 9:
            case 10:
                return 9;
            case 14:
            case 15:
                return 14;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
            case 20:
                return 19;
            default:
                return 0;
        }
    }

    public static String getRomInfo() {
        return VERSION.INCREMENTAL;
    }

    public static int GetNetAP(Context context) {
        AppMethodBeat.i(124434);
        if (context == null) {
            AppMethodBeat.o(124434);
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(124434);
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(124434);
            return 0;
        }
        if ("wifi".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
            AppMethodBeat.o(124434);
            return 1;
        }
        AppMethodBeat.o(124434);
        return 2;
    }

    public static String getAppName(Context context, String str) {
        AppMethodBeat.i(124435);
        String str2;
        if (context == null) {
            str2 = "";
            AppMethodBeat.o(124435);
            return str2;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            str2 = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
            AppMethodBeat.o(124435);
            return str2;
        } catch (Throwable th) {
            str2 = "";
            AppMethodBeat.o(124435);
            return str2;
        }
    }

    public static String getAppVersionName(Context context) {
        AppMethodBeat.i(124436);
        String str;
        if (TextUtils.isEmpty(appVersionName)) {
            String str2 = "";
            if (context == null) {
                AppMethodBeat.o(124436);
                return str2;
            }
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                appVersionName = str;
                if (str == null) {
                    try {
                        str = "";
                    } catch (Throwable th) {
                        AppMethodBeat.o(124436);
                        return str;
                    }
                }
                AppMethodBeat.o(124436);
                return str;
            } catch (Throwable th2) {
                str = str2;
                AppMethodBeat.o(124436);
                return str;
            }
        }
        str = appVersionName;
        AppMethodBeat.o(124436);
        return str;
    }

    public static int getAppVersionCode(Context context, String str) {
        AppMethodBeat.i(124437);
        if (appVersionCode != 0) {
            int i = appVersionCode;
            AppMethodBeat.o(124437);
            return i;
        } else if (context == null) {
            AppMethodBeat.o(124437);
            return 0;
        } else {
            try {
                int i2 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
                appVersionCode = i2;
                AppMethodBeat.o(124437);
                return i2;
            } catch (Throwable th) {
                AppMethodBeat.o(124437);
                return 0;
            }
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.i(124438);
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(124438);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                AppMethodBeat.o(124438);
                return false;
            } else if (activeNetworkInfo.getState() == State.CONNECTED) {
                AppMethodBeat.o(124438);
                return true;
            } else {
                AppMethodBeat.o(124438);
                return false;
            }
        }
        AppMethodBeat.o(124438);
        return false;
    }

    public static int getNetWorkType(Context context) {
        AppMethodBeat.i(124439);
        if (context == null) {
            AppMethodBeat.o(124439);
            return 0;
        }
        int i;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    switch (activeNetworkInfo.getType()) {
                        case 0:
                            i = 2;
                            try {
                                if (!(activeNetworkInfo.getExtraInfo() == null || "cmnet".equalsIgnoreCase(activeNetworkInfo.getExtraInfo()))) {
                                    i = 3;
                                    break;
                                }
                            } catch (Exception e) {
                                break;
                            }
                        case 1:
                            i = 1;
                            break;
                        default:
                            i = 4;
                            break;
                    }
                    AppMethodBeat.o(124439);
                    return i;
                }
            }
            i = 0;
        } catch (Exception e2) {
            i = 0;
        }
        AppMethodBeat.o(124439);
        return i;
    }

    public static int getWifiNetStrength(Context context) {
        AppMethodBeat.i(124440);
        if (context == null) {
            AppMethodBeat.o(124440);
            return 0;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                AppMethodBeat.o(124440);
                return 0;
            }
            int rssi = connectionInfo.getRssi();
            int calculateSignalLevel;
            if (VERSION.SDK_INT >= 14) {
                calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 101);
                AppMethodBeat.o(124440);
                return calculateSignalLevel;
            } else if (rssi <= -100) {
                AppMethodBeat.o(124440);
                return 0;
            } else if (rssi >= -55) {
                AppMethodBeat.o(124440);
                return 100;
            } else {
                calculateSignalLevel = (int) ((((float) (rssi + 100)) * 100.0f) / 45.0f);
                AppMethodBeat.o(124440);
                return calculateSignalLevel;
            }
        } catch (Throwable th) {
            AppMethodBeat.o(124440);
            return 0;
        }
    }

    public static long getRxBytesFromNetwork(Context context) {
        long j = -1;
        AppMethodBeat.i(124441);
        if (context == null) {
            AppMethodBeat.o(124441);
            return -1;
        }
        try {
            context.getClassLoader().loadClass("android.net.TrafficStats");
            if (-1 == -1) {
                j = TrafficStats.getTotalRxBytes();
            }
            AppMethodBeat.o(124441);
            return j;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.o(124441);
            return 0;
        } catch (Throwable th) {
            AppMethodBeat.o(124441);
            return 0;
        }
    }

    public static long getAppInstallTime(Context context) {
        long j = 0;
        AppMethodBeat.i(124442);
        if (context == null) {
            AppMethodBeat.o(124442);
        } else {
            try {
                j = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000;
                AppMethodBeat.o(124442);
            } catch (NameNotFoundException e) {
                AppMethodBeat.o(124442);
            } catch (Throwable th) {
                AppMethodBeat.o(124442);
            }
        }
        return j;
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(124443);
        int i;
        if (context == null) {
            AppMethodBeat.o(124443);
            return 0;
        } else if (mScreenWidth != 0) {
            i = mScreenWidth;
            AppMethodBeat.o(124443);
            return i;
        } else {
            try {
                mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
            } catch (Throwable th) {
            }
            i = mScreenWidth;
            AppMethodBeat.o(124443);
            return i;
        }
    }

    public static int getScreenHeight(Context context) {
        AppMethodBeat.i(124444);
        int i;
        if (context == null) {
            AppMethodBeat.o(124444);
            return 0;
        } else if (mScreenHeight != 0) {
            i = mScreenHeight;
            AppMethodBeat.o(124444);
            return i;
        } else {
            try {
                mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
            } catch (Throwable th) {
            }
            i = mScreenHeight;
            AppMethodBeat.o(124444);
            return i;
        }
    }

    public static boolean isNetworkTypeMobile(Context context) {
        AppMethodBeat.i(124445);
        if (context == null) {
            AppMethodBeat.o(124445);
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        AppMethodBeat.o(124445);
                        return true;
                    default:
                        AppMethodBeat.o(124445);
                        return false;
                }
            }
        }
        AppMethodBeat.o(124445);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066 A:{SYNTHETIC, Splitter:B:24:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b A:{Catch:{ Throwable -> 0x006f }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A:{SYNTHETIC, Splitter:B:32:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A:{Catch:{ Throwable -> 0x0084 }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A:{SYNTHETIC, Splitter:B:32:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A:{Catch:{ Throwable -> 0x0084 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getMarketId(Context context) {
        Throwable th;
        int i = -1;
        AppMethodBeat.i(124446);
        if (context == null) {
            AppMethodBeat.o(124446);
        } else {
            InputStream open;
            BufferedReader bufferedReader;
            try {
                open = context.getApplicationContext().getAssets().open("channel.ini");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(open));
                    try {
                        String readLine = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(readLine) && readLine.contains("CHANNEL=")) {
                            readLine = readLine.substring(readLine.indexOf("=") + 1);
                            if (!TextUtils.isEmpty(readLine)) {
                                i = Integer.parseInt(readLine.trim());
                            }
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th2) {
                            }
                        }
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th = th3;
                        if (open != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(124446);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th5) {
                            AppMethodBeat.o(124446);
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    AppMethodBeat.o(124446);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                open = null;
                if (open != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(124446);
                throw th;
            }
            AppMethodBeat.o(124446);
        }
        return i;
    }

    public static int getMCC(Context context) {
        AppMethodBeat.i(124447);
        int i;
        if (mMCC != 0) {
            i = mMCC;
            AppMethodBeat.o(124447);
            return i;
        } else if (context == null) {
            AppMethodBeat.o(124447);
            return 0;
        } else {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (configuration != null) {
                    mMCC = configuration.mcc;
                }
                i = mMCC;
                AppMethodBeat.o(124447);
                return i;
            } catch (Throwable th) {
                AppMethodBeat.o(124447);
                return 0;
            }
        }
    }

    public static int getMNC(Context context) {
        AppMethodBeat.i(124448);
        int i;
        if (mMNC != 0) {
            i = mMNC;
            AppMethodBeat.o(124448);
            return i;
        } else if (context == null) {
            AppMethodBeat.o(124448);
            return 0;
        } else {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (configuration != null) {
                    mMNC = configuration.mnc;
                }
                i = mMNC;
                AppMethodBeat.o(124448);
                return i;
            } catch (Throwable th) {
                AppMethodBeat.o(124448);
                return 0;
            }
        }
    }

    public static String PrintStack(Throwable th) {
        AppMethodBeat.i(124449);
        if (th == null) {
            AppMethodBeat.o(124449);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            byteArrayOutputStream.close();
        } catch (IOException e) {
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            AppMethodBeat.o(124449);
        }
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        AppMethodBeat.o(124449);
        return byteArrayOutputStream2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A:{SYNTHETIC, Splitter:B:18:0x002c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String readSystemStat() {
        Throwable th;
        RandomAccessFile randomAccessFile;
        String str = null;
        AppMethodBeat.i(124450);
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile("/proc/stat", "r");
            try {
                str = randomAccessFile2.readLine();
                try {
                    randomAccessFile2.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th4) {
                    }
                }
                AppMethodBeat.o(124450);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = str;
            if (randomAccessFile != null) {
            }
            AppMethodBeat.o(124450);
            throw th;
        }
        AppMethodBeat.o(124450);
        return str;
    }

    public static int getSystemCpuUsage(String str, String str2) {
        AppMethodBeat.i(124451);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(124451);
            return -1;
        }
        float f = -1.0f;
        try {
            String[] split = str.trim().split("\\s+");
            long systemIdleTime = getSystemIdleTime(split);
            long systemUptime = getSystemUptime(split);
            split = str2.trim().split("\\s+");
            long systemIdleTime2 = getSystemIdleTime(split);
            long systemUptime2 = getSystemUptime(split);
            if (systemIdleTime >= 0 && systemUptime >= 0 && systemIdleTime2 >= 0 && systemUptime2 >= 0 && systemUptime2 + systemIdleTime2 > systemUptime + systemIdleTime && systemUptime2 >= systemUptime) {
                f = (((float) (systemUptime2 - systemUptime)) / ((float) ((systemIdleTime2 + systemUptime2) - (systemIdleTime + systemUptime)))) * 100.0f;
            }
        } catch (Throwable th) {
            f = -1.0f;
        }
        int i = (int) f;
        AppMethodBeat.o(124451);
        return i;
    }

    public static long getSystemUptime(String[] strArr) {
        AppMethodBeat.i(124452);
        long j = 0;
        for (int i = 1; i < strArr.length; i++) {
            if (4 != i) {
                try {
                    j += Long.parseLong(strArr[i]);
                } catch (Throwable th) {
                    AppMethodBeat.o(124452);
                    return -1;
                }
            }
        }
        AppMethodBeat.o(124452);
        return j;
    }

    public static long getSystemIdleTime(String[] strArr) {
        AppMethodBeat.i(124453);
        try {
            long parseLong = Long.parseLong(strArr[4]);
            AppMethodBeat.o(124453);
            return parseLong;
        } catch (Throwable th) {
            AppMethodBeat.o(124453);
            return -1;
        }
    }

    public static int getNetworkClass(Context context) {
        AppMethodBeat.i(124454);
        if (context == null) {
            AppMethodBeat.o(124454);
            return 0;
        }
        int networkClass;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        networkClass = getNetworkClass(activeNetworkInfo.getSubtype());
                        break;
                    default:
                        networkClass = 0;
                        break;
                }
                AppMethodBeat.o(124454);
                return networkClass;
            }
        }
        networkClass = 0;
        AppMethodBeat.o(124454);
        return networkClass;
    }

    private static int getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static String getWiFiMacAddress(Context context) {
        String macAddress;
        AppMethodBeat.i(124455);
        String str = "";
        try {
            macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable th) {
            macAddress = str;
        }
        AppMethodBeat.o(124455);
        return macAddress;
    }
}
