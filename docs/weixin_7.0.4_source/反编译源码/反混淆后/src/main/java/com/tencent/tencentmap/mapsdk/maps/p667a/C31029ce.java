package com.tencent.tencentmap.mapsdk.maps.p667a;

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
import com.tencent.p177mm.loader.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Deflater;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ce */
public final class C31029ce {
    /* renamed from: a */
    private static volatile boolean f14071a = true;
    /* renamed from: b */
    private static String f14072b = "";
    /* renamed from: c */
    private static String f14073c = "unknown";
    /* renamed from: d */
    private static volatile int f14074d = 0;
    /* renamed from: e */
    private static volatile boolean f14075e = false;
    /* renamed from: f */
    private static volatile int f14076f = -1;
    /* renamed from: g */
    private static Map<String, C24362a> f14077g = new ConcurrentHashMap();
    /* renamed from: h */
    private static BroadcastReceiver f14078h = new C41036cf();
    /* renamed from: i */
    private static String f14079i = "";
    /* renamed from: j */
    private static String f14080j = "cmwap";
    /* renamed from: k */
    private static String f14081k = "3gwap";
    /* renamed from: l */
    private static String f14082l = "uniwap";
    /* renamed from: m */
    private static String f14083m = "ctwap";

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ce$a */
    public interface C24362a {
        /* renamed from: a */
        private static String f4657a;

        /* renamed from: a */
        void mo40549a(int i, String str) {
            AppMethodBeat.m2504i(98617);
            if (i != 0) {
                C41035bw.m71361b();
                C41035bw.m71362c();
                C41035bw.f16448a = str;
            }
            AppMethodBeat.m2505o(98617);
        }

        C24362a() {
        }

        /* renamed from: a */
        static int m37665a(String str, int i, int i2, int i3) {
            int parseInt;
            AppMethodBeat.m2504i(98618);
            try {
                String b = C24362a.m37673b(str, C46772bt.m88739c());
                if (TextUtils.isEmpty(b)) {
                    b = C24362a.m37673b(str, 0);
                }
                parseInt = Integer.parseInt(b);
            } catch (Throwable th) {
                parseInt = i3;
            }
            parseInt = C24373eu.m37731a(parseInt, i, i2, i3);
            AppMethodBeat.m2505o(98618);
            return parseInt;
        }

        /* renamed from: b */
        private static String m37673b(String str, int i) {
            AppMethodBeat.m2504i(98619);
            String str2 = str;
            int i2 = i;
            String a = C46780en.m88752d().mo75364e().mo40563a(str2, i2, C46772bt.m88742f(), C46772bt.f18092a, C44508ds.m80717a().mo70876a(C31029ce.m49847b()), C24370er.m37707a(C31029ce.m49852g()));
            AppMethodBeat.m2505o(98619);
            return a;
        }

        /* renamed from: a */
        static Handler m37667a(String str, int i) {
            AppMethodBeat.m2504i(98620);
            HandlerThread handlerThread = new HandlerThread("halley_" + C46772bt.m88739c() + "_" + str, 10);
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            AppMethodBeat.m2505o(98620);
            return handler;
        }

        /* renamed from: a */
        static String m37668a() {
            return f4657a;
        }

        /* renamed from: a */
        static void m37669a(String str) {
            f4657a = str;
        }

        /* renamed from: a */
        static boolean m37671a(String str, boolean z, Map<String, String> map, boolean z2, boolean z3) {
            AppMethodBeat.m2504i(98621);
            if (map != null) {
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            try {
                C24363dg.m37678d().mo40551a(str, z, map, false, true);
            } catch (Throwable th) {
            }
            AppMethodBeat.m2505o(98621);
            return true;
        }

        /* renamed from: a */
        static int m37666a(String str, int i, int i2, Map<String, String> map) {
            int i3 = 100;
            int i4 = 1;
            AppMethodBeat.m2504i(98622);
            if (i == 2) {
                i4 = C24362a.m37674c(str, i2);
                AppMethodBeat.m2505o(98622);
                return i4;
            }
            String str2;
            int i5;
            if ("HLHttpDirect".equals(str) && map != null) {
                if ("event".equals((String) map.get("B15"))) {
                    i4 = C24362a.m37674c(str, i2);
                    AppMethodBeat.m2505o(98622);
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
                if (i2 == 0 && map != null && C24371es.m37718a(str, i, map)) {
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
                i5 = C24362a.m37665a("report_all_events", -1, 1, 0);
                if (i5 != 1) {
                    i4 = i5 == -1 ? 0 : C24362a.m37665a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i3);
                }
                AppMethodBeat.m2505o(98622);
                return i4;
            }
            AppMethodBeat.m2505o(98622);
            return i6;
        }

        /* renamed from: a */
        static boolean m37670a(int i) {
            boolean z = false;
            AppMethodBeat.m2504i(98623);
            if (i > 0 && i <= BaseClientBuilder.API_PRIORITY_OTHER && new Random().nextInt(i) == 0) {
                z = true;
            }
            AppMethodBeat.m2505o(98623);
            return z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        private static int m37674c(String str, int i) {
            AppMethodBeat.m2504i(98624);
            if (str.equals("HLDisconnEvent")) {
                AppMethodBeat.m2505o(98624);
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
                            i2 = C24362a.m37665a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i2);
                            AppMethodBeat.m2505o(98624);
                            return i2;
                        }
                    }
                    i2 = 100;
                    i2 = C24362a.m37665a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i2);
                    AppMethodBeat.m2505o(98624);
                    return i2;
                }
            }
            str2 = "self_report_succ_denominator_value";
            if (i != 0) {
            }
            i2 = 100;
            i2 = C24362a.m37665a(str2, 0, (int) BaseClientBuilder.API_PRIORITY_OTHER, i2);
            AppMethodBeat.m2505o(98624);
            return i2;
        }

        /* renamed from: a */
        static byte[] m37672a(byte[] bArr) {
            AppMethodBeat.m2504i(98625);
            if (bArr == null || bArr.length == 0) {
                AppMethodBeat.m2505o(98625);
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
            AppMethodBeat.m2505o(98625);
            return bArr;
        }
    }

    static {
        AppMethodBeat.m2504i(98632);
        AppMethodBeat.m2505o(98632);
    }

    /* renamed from: a */
    public static void m49845a() {
        AppMethodBeat.m2504i(98627);
        try {
            C31029ce.m49850e();
            C46772bt.m88735a().registerReceiver(f14078h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            AppMethodBeat.m2505o(98627);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(98627);
        }
    }

    /* renamed from: a */
    public static void m49846a(String str, C24362a c24362a) {
        AppMethodBeat.m2504i(98626);
        synchronized (f14077g) {
            try {
                f14077g.put(str, c24362a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98626);
            }
        }
    }

    /* renamed from: b */
    public static String m49847b() {
        return f14073c;
    }

    /* renamed from: c */
    public static String m49848c() {
        String str = "";
        switch (f14074d) {
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

    /* renamed from: d */
    public static String m49849d() {
        switch (f14074d) {
            case 1:
                return "wifi";
            case 2:
            case 3:
            case 4:
                return f14072b;
            default:
                return BuildConfig.COMMAND;
        }
    }

    /* renamed from: f */
    public static String m49851f() {
        String str = "unknown";
        if (f14076f == -1) {
            return str;
        }
        switch (f14076f) {
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

    /* renamed from: g */
    public static int m49852g() {
        return f14074d;
    }

    /* renamed from: h */
    public static boolean m49853h() {
        return f14071a;
    }

    /* renamed from: i */
    public static boolean m49854i() {
        return f14075e;
    }

    /* renamed from: l */
    public static boolean m49857l() {
        AppMethodBeat.m2504i(98631);
        try {
            PowerManager powerManager = (PowerManager) C46772bt.m88735a().getSystemService("power");
            if (VERSION.SDK_INT >= 23 && powerManager != null) {
                boolean booleanValue = ((Boolean) PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
                AppMethodBeat.m2505o(98631);
                return booleanValue;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(98631);
        return false;
    }

    /* renamed from: e */
    public static synchronized void m49850e() {
        synchronized (C31029ce.class) {
            int i;
            try {
                AppMethodBeat.m2504i(98628);
                i = f14074d;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) C46772bt.m88735a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    f14071a = true;
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        f14074d = 1;
                        f14076f = 0;
                        f14075e = false;
                        WifiInfo connectionInfo = ((WifiManager) C46772bt.m88735a().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                        f14073c = "ssid_" + connectionInfo.getSSID() + connectionInfo.getBSSID();
                    } else {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo != null) {
                            f14072b = extraInfo.trim().toLowerCase();
                            if (type == 0) {
                                f14073c = "apn_" + f14072b;
                                int subtype = activeNetworkInfo.getSubtype();
                                f14076f = subtype;
                                if (subtype == 1 || subtype == 2 || subtype == 4) {
                                    f14074d = 2;
                                } else if (subtype == 13 || subtype == 19) {
                                    f14074d = 4;
                                } else {
                                    f14074d = 3;
                                }
                                boolean contains = f14072b.contains("wap");
                                f14075e = contains;
                                if (contains) {
                                    if (f14072b.contains(f14081k)) {
                                        f14079i = "10.0.0.172";
                                    } else if (f14072b.contains(f14080j)) {
                                        f14079i = "10.0.0.172";
                                    } else if (f14072b.contains(f14082l)) {
                                        f14079i = "10.0.0.172";
                                    } else if (f14072b.contains(f14083m)) {
                                        f14079i = "10.0.0.200";
                                    } else {
                                        f14079i = "";
                                    }
                                }
                            } else {
                                f14072b = "unknown";
                                f14074d = 0;
                                f14076f = -1;
                                f14073c = "unknown";
                                f14075e = false;
                            }
                        } else {
                            f14072b = "unknown";
                            f14074d = 0;
                            f14076f = -1;
                            f14073c = "unknown";
                            f14075e = false;
                        }
                    }
                } else {
                    f14072b = "unknown";
                    f14074d = 0;
                    f14076f = -1;
                    f14073c = "unknown";
                    f14075e = false;
                    f14071a = false;
                }
                if (i != f14074d) {
                    synchronized (f14077g) {
                        for (C24362a c24362a : f14077g.values()) {
                            if (c24362a != null) {
                                c24362a.mo40549a(f14074d, f14073c);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(98628);
                }
            } catch (Throwable th) {
                throw th;
            }
            AppMethodBeat.m2505o(98628);
        }
    }

    /* renamed from: j */
    public static Integer m49855j() {
        int i;
        Integer valueOf;
        AppMethodBeat.m2504i(98629);
        C31029ce.m49850e();
        if (f14074d == 2 || f14074d == 3 || f14074d == 4) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            String simOperator;
            Context a = C46772bt.m88735a();
            String str = f14072b;
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
        AppMethodBeat.m2505o(98629);
        return valueOf;
    }

    /* renamed from: k */
    public static Proxy m49856k() {
        AppMethodBeat.m2504i(98630);
        if (!f14075e || TextUtils.isEmpty(f14079i)) {
            AppMethodBeat.m2505o(98630);
            return null;
        }
        Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(f14079i, 80));
        AppMethodBeat.m2505o(98630);
        return proxy;
    }
}
