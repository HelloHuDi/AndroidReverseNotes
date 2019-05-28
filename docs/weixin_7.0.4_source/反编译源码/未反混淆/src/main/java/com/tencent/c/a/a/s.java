package com.tencent.c.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s {
    static void zX() {
        if (i.cbw != null) {
            h hVar = i.cbw;
        }
    }

    static void zY() {
        if (i.cbw != null) {
            h hVar = i.cbw;
        }
    }

    public static void zZ() {
        if (i.cbw != null) {
            h hVar = i.cbw;
        }
    }

    static boolean co(String str) {
        AppMethodBeat.i(125752);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.o(125752);
            return false;
        }
        AppMethodBeat.o(125752);
        return true;
    }

    static boolean cp(String str) {
        AppMethodBeat.i(125753);
        if (str == null || str.trim().length() < 40) {
            AppMethodBeat.o(125753);
            return false;
        }
        AppMethodBeat.o(125753);
        return true;
    }

    static g a(g gVar, g gVar2) {
        AppMethodBeat.i(125754);
        if (gVar == null || gVar2 == null) {
            if (gVar != null) {
                AppMethodBeat.o(125754);
                return gVar;
            } else if (gVar2 != null) {
                AppMethodBeat.o(125754);
                return gVar2;
            } else {
                AppMethodBeat.o(125754);
                return null;
            }
        } else if (gVar.a(gVar2) >= 0) {
            AppMethodBeat.o(125754);
            return gVar;
        } else {
            AppMethodBeat.o(125754);
            return gVar2;
        }
    }

    static boolean b(g gVar, g gVar2) {
        AppMethodBeat.i(125755);
        if (gVar == null || gVar2 == null) {
            if (gVar == null && gVar2 == null) {
                AppMethodBeat.o(125755);
                return true;
            }
            AppMethodBeat.o(125755);
            return false;
        } else if (gVar.a(gVar2) == 0) {
            AppMethodBeat.o(125755);
            return true;
        } else {
            AppMethodBeat.o(125755);
            return false;
        }
    }

    static boolean q(Context context, String str) {
        boolean z = false;
        AppMethodBeat.i(125756);
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                z = true;
            }
        } catch (Throwable th) {
            zZ();
        }
        AppMethodBeat.o(125756);
        return z;
    }

    static boolean aJ(Context context) {
        AppMethodBeat.i(125757);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"))) {
                AppMethodBeat.o(125757);
                return true;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(125757);
        return false;
    }

    static void a(JSONObject jSONObject, String str, String str2) {
        AppMethodBeat.i(125758);
        if (co(str2)) {
            jSONObject.put(str, str2);
        }
        AppMethodBeat.o(125758);
    }

    static String decode(String str) {
        AppMethodBeat.i(125759);
        if (str == null) {
            AppMethodBeat.o(125759);
            return null;
        } else if (VERSION.SDK_INT < 8) {
            AppMethodBeat.o(125759);
            return str;
        } else {
            try {
                str = new String(l.encrypt(Base64.decode(str.getBytes("UTF-8"), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), "UTF-8").trim().replace("\t", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "");
                AppMethodBeat.o(125759);
                return str;
            } catch (Throwable th) {
                zZ();
                AppMethodBeat.o(125759);
                return str;
            }
        }
    }

    static String encode(String str) {
        AppMethodBeat.i(125760);
        if (str == null) {
            AppMethodBeat.o(125760);
            return null;
        } else if (VERSION.SDK_INT < 8) {
            AppMethodBeat.o(125760);
            return str;
        } else {
            try {
                str = new String(Base64.encode(l.encrypt(str.getBytes("UTF-8"), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), "UTF-8").trim().replace("\t", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "");
                AppMethodBeat.o(125760);
                return str;
            } catch (Throwable th) {
                zZ();
                AppMethodBeat.o(125760);
                return str;
            }
        }
    }

    static String getImei(Context context) {
        String deviceId;
        AppMethodBeat.i(125761);
        try {
            if (q(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    AppMethodBeat.o(125761);
                    return deviceId;
                }
            }
            zX();
        } catch (Throwable th) {
            zY();
        }
        deviceId = "";
        AppMethodBeat.o(125761);
        return deviceId;
    }

    static String aK(Context context) {
        AppMethodBeat.i(125762);
        String str;
        if (q(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    str = "";
                    AppMethodBeat.o(125762);
                    return str;
                }
                str = wifiManager.getConnectionInfo().getMacAddress();
                AppMethodBeat.o(125762);
                return str;
            } catch (Exception e) {
                "get wifi address error".concat(String.valueOf(e));
                zX();
                str = "";
                AppMethodBeat.o(125762);
                return str;
            }
        }
        zX();
        str = "";
        AppMethodBeat.o(125762);
        return str;
    }

    private static WifiInfo getWifiInfo(Context context) {
        AppMethodBeat.i(125763);
        if (q(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                AppMethodBeat.o(125763);
                return connectionInfo;
            }
        }
        AppMethodBeat.o(125763);
        return null;
    }

    static String aL(Context context) {
        AppMethodBeat.i(125764);
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                String bssid = wifiInfo.getBSSID();
                AppMethodBeat.o(125764);
                return bssid;
            }
        } catch (Throwable th) {
            zY();
        }
        AppMethodBeat.o(125764);
        return null;
    }

    static String aM(Context context) {
        AppMethodBeat.i(125765);
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                String ssid = wifiInfo.getSSID();
                AppMethodBeat.o(125765);
                return ssid;
            }
        } catch (Throwable th) {
            zY();
        }
        AppMethodBeat.o(125765);
        return null;
    }

    static JSONArray aN(Context context) {
        AppMethodBeat.i(125766);
        try {
            if (q(context, "android.permission.INTERNET") && q(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new Comparator<ScanResult>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                AppMethodBeat.i(125751);
                                ScanResult scanResult = (ScanResult) obj2;
                                int abs = Math.abs(((ScanResult) obj).level);
                                int abs2 = Math.abs(scanResult.level);
                                if (abs > abs2) {
                                    AppMethodBeat.o(125751);
                                    return 1;
                                } else if (abs == abs2) {
                                    AppMethodBeat.o(125751);
                                    return 0;
                                } else {
                                    AppMethodBeat.o(125751);
                                    return -1;
                                }
                            }
                        });
                        JSONArray jSONArray = new JSONArray();
                        int i = 0;
                        while (i < scanResults.size() && i < 10) {
                            ScanResult scanResult = (ScanResult) scanResults.get(i);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bs", scanResult.BSSID);
                            jSONObject.put("ss", scanResult.SSID);
                            jSONArray.put(jSONObject);
                            i++;
                        }
                        AppMethodBeat.o(125766);
                        return jSONArray;
                    }
                }
                AppMethodBeat.o(125766);
                return null;
            }
            zX();
            AppMethodBeat.o(125766);
            return null;
        } catch (Throwable th) {
            zY();
        }
    }

    static String aO(Context context) {
        String str = null;
        AppMethodBeat.i(125767);
        try {
            if (q(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long availableBlocks = (long) statFs.getAvailableBlocks();
                        str = new StringBuilder(String.valueOf(String.valueOf((((long) statFs.getBlockSize()) * availableBlocks) / 1000000))).append("/").append(String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000)).toString();
                        AppMethodBeat.o(125767);
                    }
                }
                AppMethodBeat.o(125767);
            } else {
                zX();
                AppMethodBeat.o(125767);
            }
        } catch (Throwable th) {
            zZ();
        }
        return str;
    }

    static String Aa() {
        AppMethodBeat.i(125768);
        String stringBuilder;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            stringBuilder = new StringBuilder(String.valueOf(String.valueOf((((long) statFs.getAvailableBlocks()) * blockSize) / 1000000))).append("/").append(String.valueOf((((long) statFs.getBlockCount()) * blockSize) / 1000000)).toString();
            AppMethodBeat.o(125768);
            return stringBuilder;
        } catch (Throwable th) {
            zY();
            stringBuilder = "";
            AppMethodBeat.o(125768);
            return stringBuilder;
        }
    }

    static String aP(Context context) {
        AppMethodBeat.i(125769);
        String extraInfo;
        try {
            if (q(context, "android.permission.INTERNET") && q(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            extraInfo = "WIFI";
                        } else if (typeName.equalsIgnoreCase("MOBILE")) {
                            if (extraInfo == null) {
                                extraInfo = "MOBILE";
                            }
                        } else if (extraInfo == null) {
                            extraInfo = typeName;
                        }
                        AppMethodBeat.o(125769);
                        return extraInfo;
                    }
                }
                extraInfo = null;
                AppMethodBeat.o(125769);
                return extraInfo;
            }
            zX();
            extraInfo = null;
            AppMethodBeat.o(125769);
            return extraInfo;
        } catch (Throwable th) {
            extraInfo = null;
            zY();
        }
    }
}
