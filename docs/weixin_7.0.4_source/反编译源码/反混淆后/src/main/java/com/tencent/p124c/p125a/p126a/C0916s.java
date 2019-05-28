package com.tencent.p124c.p125a.p126a;

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

/* renamed from: com.tencent.c.a.a.s */
public final class C0916s {

    /* renamed from: com.tencent.c.a.a.s$1 */
    class C09151 implements Comparator<ScanResult> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(125751);
            ScanResult scanResult = (ScanResult) obj2;
            int abs = Math.abs(((ScanResult) obj).level);
            int abs2 = Math.abs(scanResult.level);
            if (abs > abs2) {
                AppMethodBeat.m2505o(125751);
                return 1;
            } else if (abs == abs2) {
                AppMethodBeat.m2505o(125751);
                return 0;
            } else {
                AppMethodBeat.m2505o(125751);
                return -1;
            }
        }

        C09151() {
        }
    }

    /* renamed from: zX */
    static void m2088zX() {
        if (C8756i.cbw != null) {
            C45080h c45080h = C8756i.cbw;
        }
    }

    /* renamed from: zY */
    static void m2089zY() {
        if (C8756i.cbw != null) {
            C45080h c45080h = C8756i.cbw;
        }
    }

    /* renamed from: zZ */
    public static void m2090zZ() {
        if (C8756i.cbw != null) {
            C45080h c45080h = C8756i.cbw;
        }
    }

    /* renamed from: co */
    static boolean m2085co(String str) {
        AppMethodBeat.m2504i(125752);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.m2505o(125752);
            return false;
        }
        AppMethodBeat.m2505o(125752);
        return true;
    }

    /* renamed from: cp */
    static boolean m2086cp(String str) {
        AppMethodBeat.m2504i(125753);
        if (str == null || str.trim().length() < 40) {
            AppMethodBeat.m2505o(125753);
            return false;
        }
        AppMethodBeat.m2505o(125753);
        return true;
    }

    /* renamed from: a */
    static C37314g m2075a(C37314g c37314g, C37314g c37314g2) {
        AppMethodBeat.m2504i(125754);
        if (c37314g == null || c37314g2 == null) {
            if (c37314g != null) {
                AppMethodBeat.m2505o(125754);
                return c37314g;
            } else if (c37314g2 != null) {
                AppMethodBeat.m2505o(125754);
                return c37314g2;
            } else {
                AppMethodBeat.m2505o(125754);
                return null;
            }
        } else if (c37314g.mo60049a(c37314g2) >= 0) {
            AppMethodBeat.m2505o(125754);
            return c37314g;
        } else {
            AppMethodBeat.m2505o(125754);
            return c37314g2;
        }
    }

    /* renamed from: b */
    static boolean m2084b(C37314g c37314g, C37314g c37314g2) {
        AppMethodBeat.m2504i(125755);
        if (c37314g == null || c37314g2 == null) {
            if (c37314g == null && c37314g2 == null) {
                AppMethodBeat.m2505o(125755);
                return true;
            }
            AppMethodBeat.m2505o(125755);
            return false;
        } else if (c37314g.mo60049a(c37314g2) == 0) {
            AppMethodBeat.m2505o(125755);
            return true;
        } else {
            AppMethodBeat.m2505o(125755);
            return false;
        }
    }

    /* renamed from: q */
    static boolean m2087q(Context context, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(125756);
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                z = true;
            }
        } catch (Throwable th) {
            C0916s.m2090zZ();
        }
        AppMethodBeat.m2505o(125756);
        return z;
    }

    /* renamed from: aJ */
    static boolean m2077aJ(Context context) {
        AppMethodBeat.m2504i(125757);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"))) {
                AppMethodBeat.m2505o(125757);
                return true;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(125757);
        return false;
    }

    /* renamed from: a */
    static void m2076a(JSONObject jSONObject, String str, String str2) {
        AppMethodBeat.m2504i(125758);
        if (C0916s.m2085co(str2)) {
            jSONObject.put(str, str2);
        }
        AppMethodBeat.m2505o(125758);
    }

    static String decode(String str) {
        AppMethodBeat.m2504i(125759);
        if (str == null) {
            AppMethodBeat.m2505o(125759);
            return null;
        } else if (VERSION.SDK_INT < 8) {
            AppMethodBeat.m2505o(125759);
            return str;
        } else {
            try {
                str = new String(C8759l.encrypt(Base64.decode(str.getBytes("UTF-8"), 0), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), "UTF-8").trim().replace("\t", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "");
                AppMethodBeat.m2505o(125759);
                return str;
            } catch (Throwable th) {
                C0916s.m2090zZ();
                AppMethodBeat.m2505o(125759);
                return str;
            }
        }
    }

    static String encode(String str) {
        AppMethodBeat.m2504i(125760);
        if (str == null) {
            AppMethodBeat.m2505o(125760);
            return null;
        } else if (VERSION.SDK_INT < 8) {
            AppMethodBeat.m2505o(125760);
            return str;
        } else {
            try {
                str = new String(Base64.encode(C8759l.encrypt(str.getBytes("UTF-8"), Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0)), 0), "UTF-8").trim().replace("\t", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "");
                AppMethodBeat.m2505o(125760);
                return str;
            } catch (Throwable th) {
                C0916s.m2090zZ();
                AppMethodBeat.m2505o(125760);
                return str;
            }
        }
    }

    static String getImei(Context context) {
        String deviceId;
        AppMethodBeat.m2504i(125761);
        try {
            if (C0916s.m2087q(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    AppMethodBeat.m2505o(125761);
                    return deviceId;
                }
            }
            C0916s.m2088zX();
        } catch (Throwable th) {
            C0916s.m2089zY();
        }
        deviceId = "";
        AppMethodBeat.m2505o(125761);
        return deviceId;
    }

    /* renamed from: aK */
    static String m2078aK(Context context) {
        AppMethodBeat.m2504i(125762);
        String str;
        if (C0916s.m2087q(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    str = "";
                    AppMethodBeat.m2505o(125762);
                    return str;
                }
                str = wifiManager.getConnectionInfo().getMacAddress();
                AppMethodBeat.m2505o(125762);
                return str;
            } catch (Exception e) {
                "get wifi address error".concat(String.valueOf(e));
                C0916s.m2088zX();
                str = "";
                AppMethodBeat.m2505o(125762);
                return str;
            }
        }
        C0916s.m2088zX();
        str = "";
        AppMethodBeat.m2505o(125762);
        return str;
    }

    private static WifiInfo getWifiInfo(Context context) {
        AppMethodBeat.m2504i(125763);
        if (C0916s.m2087q(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                AppMethodBeat.m2505o(125763);
                return connectionInfo;
            }
        }
        AppMethodBeat.m2505o(125763);
        return null;
    }

    /* renamed from: aL */
    static String m2079aL(Context context) {
        AppMethodBeat.m2504i(125764);
        try {
            WifiInfo wifiInfo = C0916s.getWifiInfo(context);
            if (wifiInfo != null) {
                String bssid = wifiInfo.getBSSID();
                AppMethodBeat.m2505o(125764);
                return bssid;
            }
        } catch (Throwable th) {
            C0916s.m2089zY();
        }
        AppMethodBeat.m2505o(125764);
        return null;
    }

    /* renamed from: aM */
    static String m2080aM(Context context) {
        AppMethodBeat.m2504i(125765);
        try {
            WifiInfo wifiInfo = C0916s.getWifiInfo(context);
            if (wifiInfo != null) {
                String ssid = wifiInfo.getSSID();
                AppMethodBeat.m2505o(125765);
                return ssid;
            }
        } catch (Throwable th) {
            C0916s.m2089zY();
        }
        AppMethodBeat.m2505o(125765);
        return null;
    }

    /* renamed from: aN */
    static JSONArray m2081aN(Context context) {
        AppMethodBeat.m2504i(125766);
        try {
            if (C0916s.m2087q(context, "android.permission.INTERNET") && C0916s.m2087q(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new C09151());
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
                        AppMethodBeat.m2505o(125766);
                        return jSONArray;
                    }
                }
                AppMethodBeat.m2505o(125766);
                return null;
            }
            C0916s.m2088zX();
            AppMethodBeat.m2505o(125766);
            return null;
        } catch (Throwable th) {
            C0916s.m2089zY();
        }
    }

    /* renamed from: aO */
    static String m2082aO(Context context) {
        String str = null;
        AppMethodBeat.m2504i(125767);
        try {
            if (C0916s.m2087q(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long availableBlocks = (long) statFs.getAvailableBlocks();
                        str = new StringBuilder(String.valueOf(String.valueOf((((long) statFs.getBlockSize()) * availableBlocks) / 1000000))).append("/").append(String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000)).toString();
                        AppMethodBeat.m2505o(125767);
                    }
                }
                AppMethodBeat.m2505o(125767);
            } else {
                C0916s.m2088zX();
                AppMethodBeat.m2505o(125767);
            }
        } catch (Throwable th) {
            C0916s.m2090zZ();
        }
        return str;
    }

    /* renamed from: Aa */
    static String m2074Aa() {
        AppMethodBeat.m2504i(125768);
        String stringBuilder;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            stringBuilder = new StringBuilder(String.valueOf(String.valueOf((((long) statFs.getAvailableBlocks()) * blockSize) / 1000000))).append("/").append(String.valueOf((((long) statFs.getBlockCount()) * blockSize) / 1000000)).toString();
            AppMethodBeat.m2505o(125768);
            return stringBuilder;
        } catch (Throwable th) {
            C0916s.m2089zY();
            stringBuilder = "";
            AppMethodBeat.m2505o(125768);
            return stringBuilder;
        }
    }

    /* renamed from: aP */
    static String m2083aP(Context context) {
        AppMethodBeat.m2504i(125769);
        String extraInfo;
        try {
            if (C0916s.m2087q(context, "android.permission.INTERNET") && C0916s.m2087q(context, "android.permission.ACCESS_NETWORK_STATE")) {
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
                        AppMethodBeat.m2505o(125769);
                        return extraInfo;
                    }
                }
                extraInfo = null;
                AppMethodBeat.m2505o(125769);
                return extraInfo;
            }
            C0916s.m2088zX();
            extraInfo = null;
            AppMethodBeat.m2505o(125769);
            return extraInfo;
        } catch (Throwable th) {
            extraInfo = null;
            C0916s.m2089zY();
        }
    }
}
