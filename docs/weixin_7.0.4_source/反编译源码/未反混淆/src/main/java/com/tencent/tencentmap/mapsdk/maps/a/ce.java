package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Deflater;

public final class ce {
    private static volatile boolean a = true;
    private static String b = "";
    private static String c = "unknown";
    private static volatile int d = 0;
    private static volatile boolean e = false;
    private static volatile int f = -1;
    private static Map<String, a> g = new ConcurrentHashMap();
    private static BroadcastReceiver h = new cf();
    private static String i = "";
    private static String j = "cmwap";
    private static String k = "3gwap";
    private static String l = "uniwap";
    private static String m = "ctwap";

    public interface a {
        private static String a;

        void a(int i, String str) {
            AppMethodBeat.i(98617);
            if (i != 0) {
                bw.b();
                bw.c();
                bw.a = str;
            }
            AppMethodBeat.o(98617);
        }

        a() {
        }

        static int a(String str, int i, int i2, int i3) {
            int parseInt;
            AppMethodBeat.i(98618);
            try {
                String b = b(str, bt.c());
                if (TextUtils.isEmpty(b)) {
                    b = b(str, 0);
                }
                parseInt = Integer.parseInt(b);
            } catch (Throwable th) {
                parseInt = i3;
            }
            parseInt = eu.a(parseInt, i, i2, i3);
            AppMethodBeat.o(98618);
            return parseInt;
        }

        private static String b(String str, int i) {
            AppMethodBeat.i(98619);
            String str2 = str;
            int i2 = i;
            String a = en.d().e().a(str2, i2, bt.f(), bt.a, ds.a().a(ce.b()), er.a(ce.g()));
            AppMethodBeat.o(98619);
            return a;
        }

        static Handler a(String str, int i) {
            AppMethodBeat.i(98620);
            HandlerThread handlerThread = new HandlerThread("halley_" + bt.c() + "_" + str, 10);
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            AppMethodBeat.o(98620);
            return handler;
        }

        static String a() {
            return a;
        }

        static void a(String str) {
            a = str;
        }

        static boolean a(String str, boolean z, Map<String, String> map, boolean z2, boolean z3) {
            AppMethodBeat.i(98621);
            if (map != null) {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            try {
                dg.d().a(str, z, map, false, true);
            } catch (Throwable th) {
            }
            AppMethodBeat.o(98621);
            return true;
        }

        static int a(String str, int i, int i2, Map<String, String> map) {
            int i3 = 100;
            int i4 = 1;
            AppMethodBeat.i(98622);
            if (i == 2) {
                i4 = c(str, i2);
                AppMethodBeat.o(98622);
                return i4;
            }
            String str2;
            int i5;
            if ("HLHttpDirect".equals(str) && map != null) {
                if ("event".equals((String) map.get("B15"))) {
                    i4 = c(str, i2);
                    AppMethodBeat.o(98622);
                    return i4;
                }
            }
            int i6 = -1;
            String str3 = "";
            if ("HLConnEvent".equals(str)) {
                if (i2 == 0) {
                    str2 = "report_conn_succ_denominator_value";
                } else {
                    if (i2 == -4 || i2 == -3 || i2 == -288) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    if (i5 != 0) {
                        str2 = "report_conn_nonet_fail_denominator_value";
                    } else {
                        str2 = "report_conn_other_fail_denominator_value";
                    }
                }
                if (i2 == 0) {
                    i5 = 100;
                } else {
                    if (i2 == -4 || i2 == -3 || i2 == -288) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    if (i5 != 0) {
                        i5 = 100;
                    } else {
                        i5 = 1;
                    }
                }
                i3 = i5;
            } else if ("HLSecurityEvent".equals(str)) {
                str3 = i2 == 0 ? "report_security_req_succ_denominator_value" : "report_security_req_fail_denominator_value";
                if (i2 != 0) {
                    i3 = 1;
                }
                str2 = str3;
            } else if ("HLDisconnEvent".equals(str)) {
                i3 = 2;
                str2 = "report_disconn_denominator_value";
            } else if ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str)) {
                if (i2 == 0 && map != null && es.a(str, i, map)) {
                    map.put("B28", "1");
                    str2 = "report_req_ssl_first_denominator_value";
                } else {
                    if (i2 == 0) {
                        str3 = "report_req_succ_denominator_value";
                    } else {
                        if (i2 == -4 || i2 == -3 || i2 == -288) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                        str3 = i5 != 0 ? "report_req_nonet_fail_denominator_value" : "report_req_other_fail_denominator_value";
                    }
                    if (i2 != 0) {
                        int i7;
                        if (i2 == -4 || i2 == -3 || i2 == -288) {
                            i7 = 1;
                        } else {
                            i7 = 0;
                        }
                        if (i7 == 0) {
                            i3 = 1;
                        }
                    }
                    str2 = str3;
                }
            } else if ("HLPushEvent".equals(str)) {
                i3 = 10;
                str2 = "report_push_denominator_value";
            } else if ("B_DLSDK_Result".equals(str)) {
                i3 = 1;
                str2 = "report_mass_download_denominator_value";
            } else if ("HLDownTiny".equals(str)) {
                i3 = 10;
                str2 = "report_ease_download_denominator_value";
            } else if ("HLHeartBeat".equals(str)) {
                str2 = i2 == 0 ? "report_heartbeat_succ_denominator_value" : "report_heartbeat_fail_denominator_value";
                i3 = i2 == 0 ? 10 : 5;
            } else if ("HLReportEvent".equals(str)) {
                i3 = 1;
                str2 = i2 == 0 ? "platform_report_quality_succ_denominator_value" : "platform_report_quality_fail_denominator_value";
            } else if ("HLMsgClickEvent".equals(str) || "HLMsgProcessEvent".equals(str) || "HLMsgDispatchEvent".equals(str)) {
                i3 = 1;
                str2 = i2 == 0 ? "report_msg_push_succ_denominator_value" : "report_msg_push_fail_denominator_value";
            } else {
                i3 = 0;
                str2 = str3;
                i6 = 0;
            }
            if (i6 == -1) {
                i5 = a("report_all_events", -1, 1, 0);
                if (i5 != 1) {
                    i4 = i5 == -1 ? 0 : a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i3);
                }
                AppMethodBeat.o(98622);
                return i4;
            }
            AppMethodBeat.o(98622);
            return i6;
        }

        static boolean a(int i) {
            boolean z = false;
            AppMethodBeat.i(98623);
            if (i > 0 && i <= BaseClientBuilder.API_PRIORITY_OTHER && new Random().nextInt(i) == 0) {
                z = true;
            }
            AppMethodBeat.o(98623);
            return z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int c(String str, int i) {
            AppMethodBeat.i(98624);
            if (str.equals("HLDisconnEvent")) {
                AppMethodBeat.o(98624);
                return -2;
            }
            int i2;
            String str2;
            if (i != 0) {
                if (i == -4 || i == -3 || i == -288) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    str2 = "self_report_fail_denominator_value";
                    if (i != 0) {
                        if (i == -4 || i == -3 || i == -288) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            i2 = 2;
                            i2 = a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i2);
                            AppMethodBeat.o(98624);
                            return i2;
                        }
                    }
                    i2 = 100;
                    i2 = a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i2);
                    AppMethodBeat.o(98624);
                    return i2;
                }
            }
            str2 = "self_report_succ_denominator_value";
            if (i != 0) {
            }
            i2 = 100;
            i2 = a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i2);
            AppMethodBeat.o(98624);
            return i2;
        }

        static byte[] a(byte[] bArr) {
            AppMethodBeat.i(98625);
            if (bArr == null || bArr.length == 0) {
                AppMethodBeat.o(98625);
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[256];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.finish();
            deflater.end();
            bArr = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(98625);
            return bArr;
        }
    }

    static {
        AppMethodBeat.i(98632);
        AppMethodBeat.o(98632);
    }

    public static void a() {
        AppMethodBeat.i(98627);
        try {
            e();
            bt.a().registerReceiver(h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            AppMethodBeat.o(98627);
        } catch (Throwable th) {
            AppMethodBeat.o(98627);
        }
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(98626);
        synchronized (g) {
            try {
                g.put(str, aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98626);
            }
        }
    }

    public static String b() {
        return c;
    }

    public static String c() {
        String str = "";
        switch (d) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return str;
        }
    }

    public static String d() {
        switch (d) {
            case 1:
                return "wifi";
            case 2:
            case 3:
            case 4:
                return b;
            default:
                return BuildConfig.COMMAND;
        }
    }

    public static String f() {
        String str = "unknown";
        if (f == -1) {
            return str;
        }
        switch (f) {
            case 0:
                return "wifi";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return str;
        }
    }

    public static int g() {
        return d;
    }

    public static boolean h() {
        return a;
    }

    public static boolean i() {
        return e;
    }

    public static boolean l() {
        AppMethodBeat.i(98631);
        try {
            PowerManager powerManager = (PowerManager) bt.a().getSystemService("power");
            if (VERSION.SDK_INT >= 23 && powerManager != null) {
                boolean booleanValue = ((Boolean) PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
                AppMethodBeat.o(98631);
                return booleanValue;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(98631);
        return false;
    }

    public static synchronized void e() {
        synchronized (ce.class) {
            int i;
            try {
                AppMethodBeat.i(98628);
                i = d;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) bt.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    a = true;
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        d = 1;
                        f = 0;
                        e = false;
                        WifiInfo connectionInfo = ((WifiManager) bt.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                        c = "ssid_" + connectionInfo.getSSID() + connectionInfo.getBSSID();
                    } else {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo != null) {
                            b = extraInfo.trim().toLowerCase();
                            if (type == 0) {
                                c = "apn_" + b;
                                int subtype = activeNetworkInfo.getSubtype();
                                f = subtype;
                                if (subtype == 1 || subtype == 2 || subtype == 4) {
                                    d = 2;
                                } else if (subtype == 13 || subtype == 19) {
                                    d = 4;
                                } else {
                                    d = 3;
                                }
                                boolean contains = b.contains("wap");
                                e = contains;
                                if (contains) {
                                    if (b.contains(k)) {
                                        i = "10.0.0.172";
                                    } else if (b.contains(j)) {
                                        i = "10.0.0.172";
                                    } else if (b.contains(l)) {
                                        i = "10.0.0.172";
                                    } else if (b.contains(m)) {
                                        i = "10.0.0.200";
                                    } else {
                                        i = "";
                                    }
                                }
                            } else {
                                b = "unknown";
                                d = 0;
                                f = -1;
                                c = "unknown";
                                e = false;
                            }
                        } else {
                            b = "unknown";
                            d = 0;
                            f = -1;
                            c = "unknown";
                            e = false;
                        }
                    }
                } else {
                    b = "unknown";
                    d = 0;
                    f = -1;
                    c = "unknown";
                    e = false;
                    a = false;
                }
                if (i != d) {
                    synchronized (g) {
                        for (a aVar : g.values()) {
                            if (aVar != null) {
                                aVar.a(d, c);
                            }
                        }
                    }
                    AppMethodBeat.o(98628);
                }
            } catch (Throwable th) {
                throw th;
            }
            AppMethodBeat.o(98628);
        }
    }

    public static Integer j() {
        int i;
        Integer valueOf;
        AppMethodBeat.i(98629);
        e();
        if (d == 2 || d == 3 || d == 4) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            String simOperator;
            Context a = bt.a();
            String str = b;
            TelephonyManager telephonyManager = (TelephonyManager) a.getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                simOperator = telephonyManager.getSimOperator();
                if (simOperator.length() > 0) {
                    if (simOperator.equals("46000") || simOperator.equals("46002")) {
                        valueOf = Integer.valueOf(1);
                        i = valueOf.intValue();
                    } else {
                        if (simOperator.equals("46001")) {
                            valueOf = Integer.valueOf(2);
                        } else if (simOperator.equals("46003")) {
                            valueOf = Integer.valueOf(3);
                        }
                        i = valueOf.intValue();
                    }
                }
            }
            if (str != null) {
                simOperator = str.toLowerCase();
                if (simOperator.contains("cmnet") || simOperator.contains("cmwap")) {
                    valueOf = Integer.valueOf(1);
                    i = valueOf.intValue();
                } else if (simOperator.contains("uninet") || simOperator.contains("uniwap") || simOperator.contains("3gnet") || simOperator.contains("3gwap")) {
                    valueOf = Integer.valueOf(2);
                    i = valueOf.intValue();
                } else if (simOperator.contains("ctnet") || simOperator.contains("ctwap")) {
                    valueOf = Integer.valueOf(3);
                    i = valueOf.intValue();
                }
            }
            valueOf = Integer.valueOf(0);
            i = valueOf.intValue();
        } else {
            i = 0;
        }
        valueOf = Integer.valueOf(i);
        AppMethodBeat.o(98629);
        return valueOf;
    }

    public static Proxy k() {
        AppMethodBeat.i(98630);
        if (!e || TextUtils.isEmpty(i)) {
            AppMethodBeat.o(98630);
            return null;
        }
        Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(i, 80));
        AppMethodBeat.o(98630);
        return proxy;
    }
}
