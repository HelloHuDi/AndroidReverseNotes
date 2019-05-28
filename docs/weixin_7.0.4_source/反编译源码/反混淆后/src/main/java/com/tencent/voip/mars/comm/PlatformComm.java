package com.tencent.voip.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm {
    static final int EMobile = 2;
    static final int ENoNet = -1;
    static final int EOtherNet = 3;
    static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    static final int NETTYPE_2G = 3;
    static final int NETTYPE_3G = 4;
    static final int NETTYPE_4G = 5;
    static final int NETTYPE_NON = -1;
    static final int NETTYPE_NOT_WIFI = 0;
    static final int NETTYPE_UNKNOWN = 6;
    static final int NETTYPE_WAP = 2;
    static final int NETTYPE_WIFI = 1;
    private static final String TAG = "PlatformComm";
    public static Context context = null;
    public static Handler handler = null;

    public static class Assert {
        public static void assertTrue(String str, boolean z) {
        }

        public static void assertTrue(boolean z) {
        }
    }

    public static class C2Java {
        private static String exception2String(Exception exception) {
            AppMethodBeat.m2504i(92727);
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            AppMethodBeat.m2505o(92727);
            return stringWriter2;
        }

        public static int getNetInfo() {
            AppMethodBeat.m2504i(92728);
            ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.m2505o(92728);
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(92728);
                return -1;
            }
            try {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        AppMethodBeat.m2505o(92728);
                        return 2;
                    case 1:
                        AppMethodBeat.m2505o(92728);
                        return 1;
                    default:
                        AppMethodBeat.m2505o(92728);
                        return 3;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(92728);
                return 3;
            }
        }

        public static int getProxyInfo(StringBuffer stringBuffer) {
            return -1;
        }

        public static int getStatisticsNetType() {
            boolean z = false;
            AppMethodBeat.m2504i(92729);
            if (PlatformComm.context == null) {
                Assert.assertTrue(z);
                AppMethodBeat.m2505o(92729);
                return z;
            }
            try {
                int netType = NetStatusUtil.getNetType(PlatformComm.context);
                if (netType == -1) {
                    AppMethodBeat.m2505o(92729);
                    return true;
                } else if (NetStatusUtil.is2G(PlatformComm.context)) {
                    AppMethodBeat.m2505o(92729);
                    return true;
                } else if (NetStatusUtil.is3G(PlatformComm.context)) {
                    AppMethodBeat.m2505o(92729);
                    return true;
                } else if (NetStatusUtil.is4G(PlatformComm.context)) {
                    AppMethodBeat.m2505o(92729);
                    return true;
                } else if (NetStatusUtil.isWifi(netType)) {
                    AppMethodBeat.m2505o(92729);
                    return true;
                } else if (NetStatusUtil.isWap(netType)) {
                    AppMethodBeat.m2505o(92729);
                    return true;
                } else {
                    AppMethodBeat.m2505o(92729);
                    return true;
                }
            } catch (Exception e) {
                exception2String(e);
                Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[z] + ", " + e.getStackTrace()[1], z);
                AppMethodBeat.m2505o(92729);
                return true;
            }
        }

        public static boolean startAlarm(int i, int i2) {
            boolean z = false;
            AppMethodBeat.m2504i(92730);
            if (PlatformComm.context == null) {
                Assert.assertTrue(z);
                AppMethodBeat.m2505o(92730);
            } else {
                try {
                    z = Alarm.start((long) i, i2, PlatformComm.context);
                    AppMethodBeat.m2505o(92730);
                } catch (Exception e) {
                    exception2String(e);
                    Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[z] + ", " + e.getStackTrace()[1], z);
                    AppMethodBeat.m2505o(92730);
                }
            }
            return z;
        }

        public static boolean stopAlarm(int i) {
            boolean z = false;
            AppMethodBeat.m2504i(92731);
            if (PlatformComm.context == null) {
                Assert.assertTrue(z);
                AppMethodBeat.m2505o(92731);
            } else {
                try {
                    z = Alarm.stop((long) i, PlatformComm.context);
                    AppMethodBeat.m2505o(92731);
                } catch (Exception e) {
                    exception2String(e);
                    Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[z] + ", " + e.getStackTrace()[1], z);
                    AppMethodBeat.m2505o(92731);
                }
            }
            return z;
        }

        public static WifiInfo getCurWifiInfo() {
            AppMethodBeat.m2504i(92732);
            try {
                if (PlatformComm.context == null) {
                    AppMethodBeat.m2505o(92732);
                    return null;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    AppMethodBeat.m2505o(92732);
                    return null;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                    AppMethodBeat.m2505o(92732);
                    return null;
                }
                WifiManager wifiManager = (WifiManager) PlatformComm.context.getSystemService("wifi");
                if (wifiManager == null) {
                    AppMethodBeat.m2505o(92732);
                    return null;
                }
                android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    AppMethodBeat.m2505o(92732);
                    return null;
                }
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.ssid = connectionInfo.getSSID();
                wifiInfo.bssid = connectionInfo.getBSSID();
                AppMethodBeat.m2505o(92732);
                return wifiInfo;
            } catch (Exception e) {
                AppMethodBeat.m2505o(92732);
                return null;
            }
        }

        public static SIMInfo getCurSIMInfo() {
            AppMethodBeat.m2504i(92733);
            try {
                if (PlatformComm.context == null) {
                    AppMethodBeat.m2505o(92733);
                    return null;
                }
                int iSPCode = NetStatusUtil.getISPCode(PlatformComm.context);
                if (iSPCode == 0) {
                    AppMethodBeat.m2505o(92733);
                    return null;
                }
                SIMInfo sIMInfo = new SIMInfo();
                sIMInfo.ispCode = String.valueOf(iSPCode);
                sIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
                AppMethodBeat.m2505o(92733);
                return sIMInfo;
            } catch (Exception e) {
                AppMethodBeat.m2505o(92733);
                return null;
            }
        }

        public static APNInfo getAPNInfo() {
            AppMethodBeat.m2504i(92734);
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
                APNInfo aPNInfo = new APNInfo();
                if (activeNetworkInfo != null) {
                    aPNInfo.netType = activeNetworkInfo.getType();
                    aPNInfo.subNetType = activeNetworkInfo.getSubtype();
                    if (1 != activeNetworkInfo.getType()) {
                        aPNInfo.extraInfo = activeNetworkInfo.getExtraInfo() == null ? "" : activeNetworkInfo.getExtraInfo();
                    } else {
                        aPNInfo.extraInfo = getCurWifiInfo().ssid;
                    }
                    AppMethodBeat.m2505o(92734);
                    return aPNInfo;
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(92734);
            return null;
        }

        public static int getCurRadioAccessNetworkInfo() {
            AppMethodBeat.m2504i(92735);
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                AppMethodBeat.m2505o(92735);
                return 0;
            }
            try {
                int networkType = ((TelephonyManager) PlatformComm.context.getSystemService("phone")).getNetworkType();
                AppMethodBeat.m2505o(92735);
                return networkType;
            } catch (Exception e) {
                Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
                AppMethodBeat.m2505o(92735);
                return 0;
            }
        }

        public static long getSignal(boolean z) {
            long j = 0;
            AppMethodBeat.m2504i(92736);
            try {
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    AppMethodBeat.m2505o(92736);
                } else if (z) {
                    j = NetworkSignalUtil.getWifiSignalStrength();
                    AppMethodBeat.m2505o(92736);
                } else {
                    j = NetworkSignalUtil.getGSMSignalStrength();
                    AppMethodBeat.m2505o(92736);
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(92736);
            }
            return j;
        }

        public static boolean isNetworkConnected() {
            boolean z = false;
            AppMethodBeat.m2504i(92737);
            if (PlatformComm.context == null) {
                Assert.assertTrue(z);
                AppMethodBeat.m2505o(92737);
            } else {
                try {
                    z = NetStatusUtil.isNetworkConnected(PlatformComm.context);
                    AppMethodBeat.m2505o(92737);
                } catch (Exception e) {
                    exception2String(e);
                    Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[z] + ", " + e.getStackTrace()[1], z);
                    AppMethodBeat.m2505o(92737);
                }
            }
            return z;
        }

        public static WakerLock wakeupLock_new() {
            AppMethodBeat.m2504i(92738);
            if (PlatformComm.context == null) {
                Assert.assertTrue(false);
                AppMethodBeat.m2505o(92738);
                return null;
            }
            try {
                WakerLock wakerLock = new WakerLock(PlatformComm.context);
                AppMethodBeat.m2505o(92738);
                return wakerLock;
            } catch (Exception e) {
                exception2String(e);
                Assert.assertTrue(e.getClass().getSimpleName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + e.getStackTrace()[0] + ", " + e.getStackTrace()[1], false);
                AppMethodBeat.m2505o(92738);
                return null;
            }
        }
    }

    static class WifiInfo {
        public String bssid;
        public String ssid;

        WifiInfo() {
        }
    }

    static class SIMInfo {
        public String ispCode;
        public String ispName;

        SIMInfo() {
        }
    }

    static class APNInfo {
        public String extraInfo;
        public int netType;
        public int subNetType;

        APNInfo() {
        }
    }

    public static void init(Context context, Handler handler) {
        AppMethodBeat.m2504i(92744);
        context = context;
        handler = handler;
        NetworkSignalUtil.InitNetworkSignalUtil(context);
        AppMethodBeat.m2505o(92744);
    }
}
