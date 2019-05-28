package com.tencent.liteav.basic.datareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;

public class TXCDRApi {
    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static final int NETWORK_TYPE_2G = 4;
    static final int NETWORK_TYPE_3G = 3;
    static final int NETWORK_TYPE_4G = 2;
    static final int NETWORK_TYPE_UNKNOWN = 255;
    static final int NETWORK_TYPE_WIFI = 1;
    static boolean initRpt = false;
    private static String mAppName = "";
    private static String mDevId = "";
    private static String mDevType = "";
    private static String mDevUUID = "";
    private static String mMacAddr = "";
    private static String mNetType = "";
    private static String mSysVersion = "";

    public static native int nativeGetStatusReportInterval();

    private static native void nativeInitDataReport();

    private static native void nativeInitEventInternal(String str, int i, int i2, TXCDRExtInfo tXCDRExtInfo);

    private static native void nativeReportDAUInterval(int i, int i2, String str);

    public static native void nativeReportEvent(String str, int i);

    public static native void nativeReportEvent40003(String str, int i, int i2, String str2, String str3);

    public static native void nativeSetCommonValue(String str, String str2);

    private static native void nativeSetEventValueInterval(String str, int i, String str2, String str3);

    private static native void nativeUninitDataReport();

    static {
        AppMethodBeat.i(66308);
        b.e();
        nativeInitDataReport();
        AppMethodBeat.o(66308);
    }

    public static void InitEvent(Context context, String str, int i, int i2, TXCDRExtInfo tXCDRExtInfo) {
        AppMethodBeat.i(66286);
        setCommonInfo(context);
        if (str == null) {
            AppMethodBeat.o(66286);
            return;
        }
        nativeInitEventInternal(str, i, i2, tXCDRExtInfo);
        AppMethodBeat.o(66286);
    }

    public static void txSetEventValue(String str, int i, String str2, String str3) {
        AppMethodBeat.i(66287);
        nativeSetEventValueInterval(str, i, str2, str3);
        AppMethodBeat.o(66287);
    }

    public static void txSetEventIntValue(String str, int i, String str2, long j) {
        AppMethodBeat.i(66288);
        nativeSetEventValueInterval(str, i, str2, String.valueOf(j));
        AppMethodBeat.o(66288);
    }

    public static void txReportDAU(Context context, int i) {
        AppMethodBeat.i(66289);
        if (context != null) {
            setCommonInfo(context);
        }
        nativeReportDAUInterval(i, 0, "");
        AppMethodBeat.o(66289);
    }

    public static void txReportDAU(Context context, int i, int i2, String str) {
        AppMethodBeat.i(66290);
        if (context != null) {
            setCommonInfo(context);
        }
        nativeReportDAUInterval(i, i2, str);
        AppMethodBeat.o(66290);
    }

    public static void reportEvent40003(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.i(66291);
        nativeReportEvent40003(str, i, i2, str2, str3);
        AppMethodBeat.o(66291);
    }

    public static int getStatusReportInterval() {
        AppMethodBeat.i(66292);
        int nativeGetStatusReportInterval = nativeGetStatusReportInterval();
        AppMethodBeat.o(66292);
        return nativeGetStatusReportInterval;
    }

    public static void setCommonInfo(Context context) {
        AppMethodBeat.i(66293);
        mDevType = Build.MODEL;
        mNetType = Integer.toString(getNetworkType(context));
        if (mDevId.isEmpty()) {
            mDevId = getSimulateIDFA(context);
        }
        if (mDevUUID.isEmpty()) {
            mDevUUID = getDevUUID(context, mDevId);
        }
        String packageName = getPackageName(context);
        mAppName = getApplicationNameByPackageName(context, packageName) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + packageName;
        mSysVersion = String.valueOf(VERSION.SDK_INT);
        mMacAddr = getOrigMacAddr(context);
        txSetCommonInfo();
        AppMethodBeat.o(66293);
    }

    public static void txSetCommonInfo() {
        AppMethodBeat.i(66294);
        if (mDevType != null) {
            nativeSetCommonValue(a.f, mDevType);
        }
        if (mNetType != null) {
            nativeSetCommonValue(a.g, mNetType);
        }
        if (mDevId != null) {
            nativeSetCommonValue(a.h, mDevId);
        }
        if (mDevUUID != null) {
            nativeSetCommonValue(a.i, mDevUUID);
        }
        if (mAppName != null) {
            nativeSetCommonValue(a.j, mAppName);
        }
        if (mSysVersion != null) {
            nativeSetCommonValue(a.l, mSysVersion);
        }
        if (mMacAddr != null) {
            nativeSetCommonValue(a.m, mMacAddr);
        }
        AppMethodBeat.o(66294);
    }

    public static void txSetAppVersion(String str) {
        AppMethodBeat.i(66295);
        if (str != null) {
            nativeSetCommonValue(a.k, str);
        }
        AppMethodBeat.o(66295);
    }

    public static String txCreateToken() {
        AppMethodBeat.i(66296);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.o(66296);
        return uuid;
    }

    private static String byteArrayToHexString(byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(66297);
        char[] cArr = new char[(bArr.length << 1)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < bArr.length) {
                i = i2 + 1;
                cArr[i2] = DIGITS_LOWER[(bArr[i3] & 240) >>> 4];
                i2 = i + 1;
                cArr[i] = DIGITS_LOWER[bArr[i3] & 15];
                i = i3 + 1;
            } else {
                String str = new String(cArr);
                AppMethodBeat.o(66297);
                return str;
            }
        }
    }

    public static String string2Md5(String str) {
        AppMethodBeat.i(66298);
        String str2 = "";
        if (str == null) {
            AppMethodBeat.o(66298);
        } else {
            try {
                str2 = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
            } catch (Exception e) {
            }
            if (str2 == null) {
                str2 = "";
            }
            AppMethodBeat.o(66298);
        }
        return str2;
    }

    public static String doRead(Context context) {
        Object deviceId;
        String deviceId2;
        AppMethodBeat.i(66299);
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId2 = telephonyManager.getDeviceId();
            } else {
                deviceId2 = str;
            }
            if (deviceId2 == null) {
                try {
                    deviceId2 = "";
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            deviceId2 = str;
        }
        TXCLog.d("rtmpsdk", "deviceinfo:".concat(String.valueOf(deviceId2)));
        deviceId2 = string2Md5(deviceId2);
        AppMethodBeat.o(66299);
        return deviceId2;
    }

    public static String getOrigAndroidID(Context context) {
        AppMethodBeat.i(66300);
        String str = "";
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
        }
        str = string2Md5(str);
        AppMethodBeat.o(66300);
        return str;
    }

    public static String getOrigMacAddr(Context context) {
        String macAddress;
        AppMethodBeat.i(66301);
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            if (connectionInfo != null) {
                macAddress = connectionInfo.getMacAddress();
            } else {
                macAddress = null;
            }
            if (macAddress != null) {
                try {
                    macAddress = string2Md5(macAddress.replaceAll(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "").toUpperCase());
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            macAddress = "";
        }
        if (macAddress == null) {
            macAddress = "";
        }
        AppMethodBeat.o(66301);
        return macAddress;
    }

    public static String getSimulateIDFA(Context context) {
        AppMethodBeat.i(66302);
        String str = doRead(context) + ";" + getOrigMacAddr(context) + ";" + getOrigAndroidID(context);
        AppMethodBeat.o(66302);
        return str;
    }

    public static String getDevUUID(Context context, String str) {
        File file;
        AppMethodBeat.i(66303);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.liteav.dev_uuid", 0);
        String string = sharedPreferences.getString("com.tencent.liteav.key_dev_uuid", "");
        Object obj = "";
        try {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/spuid");
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                int available = fileInputStream.available();
                if (available > 0) {
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr);
                    obj = new String(bArr, "UTF-8");
                }
                fileInputStream.close();
            }
        } catch (Exception e) {
        }
        String str2 = "";
        if (!string.isEmpty()) {
            str2 = string;
        }
        if (!obj.isEmpty()) {
            str2 = obj;
        }
        if (str2.isEmpty()) {
            str2 = string2Md5(str + UUID.randomUUID().toString());
        }
        if (obj.isEmpty()) {
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp");
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/spuid");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
                obj = str2;
            } catch (Exception e2) {
                String str3 = str2;
            }
        }
        if (!string.equals(obj)) {
            Editor edit = sharedPreferences.edit();
            edit.putString("key_user_id", str2);
            edit.commit();
        }
        AppMethodBeat.o(66303);
        return str2;
    }

    public static int getNetworkType(Context context) {
        AppMethodBeat.i(66304);
        if (context == null) {
            AppMethodBeat.o(66304);
            return 255;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(66304);
            return 255;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(66304);
            return 1;
        } else if (activeNetworkInfo.getType() == 0) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    AppMethodBeat.o(66304);
                    return 4;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    AppMethodBeat.o(66304);
                    return 3;
                case 13:
                    AppMethodBeat.o(66304);
                    return 2;
                default:
                    AppMethodBeat.o(66304);
                    return 2;
            }
        } else {
            AppMethodBeat.o(66304);
            return 255;
        }
    }

    private static String getPackageName(Context context) {
        AppMethodBeat.i(66305);
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
        }
        AppMethodBeat.o(66305);
        return str;
    }

    public static String getApplicationNameByPackageName(Context context, String str) {
        String charSequence;
        AppMethodBeat.i(66306);
        PackageManager packageManager = context.getPackageManager();
        try {
            charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (Exception e) {
            charSequence = "";
        }
        AppMethodBeat.o(66306);
        return charSequence;
    }

    public static void initCrashReport(Context context) {
        AppMethodBeat.i(66307);
        try {
            synchronized (TXCDRApi.class) {
                if (!(initRpt || context == null)) {
                    String sDKVersionStr = TXCCommonUtil.getSDKVersionStr();
                    if (sDKVersionStr != null) {
                        Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
                        edit.putString("8e50744bf0", sDKVersionStr);
                        edit.commit();
                        initRpt = true;
                    }
                }
            }
            AppMethodBeat.o(66307);
        } catch (Exception e) {
            AppMethodBeat.o(66307);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.o(66307);
            }
        }
    }
}
