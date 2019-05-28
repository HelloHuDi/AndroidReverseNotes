package com.tencent.p177mm.plugin.appbrand.p321l;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.l.j */
public enum C19538j {
    ;

    /* renamed from: CP */
    public static HashMap<String, String> m30258CP(String str) {
        AppMethodBeat.m2504i(108190);
        Object obj = "";
        Object obj2 = "";
        Object obj3 = "";
        try {
            Uri parse = Uri.parse(str);
            obj = parse.getHost();
            obj2 = parse.getScheme();
            obj3 = String.valueOf(parse.getPort());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: parseUrl error", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("host", obj);
        hashMap.put("scheme", obj2);
        hashMap.put("port", obj3);
        AppMethodBeat.m2505o(108190);
        return hashMap;
    }

    /* renamed from: E */
    private static Map<String, String> m30262E(JSONObject jSONObject) {
        AppMethodBeat.m2504i(108191);
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str != null) {
                        hashMap.put(str.toLowerCase(), optJSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: get header error", new Object[0]);
        }
        AppMethodBeat.m2505o(108191);
        return hashMap;
    }

    /* renamed from: F */
    public static Map<String, String> m30263F(JSONObject jSONObject) {
        AppMethodBeat.m2504i(108192);
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.getString(str));
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: get form error", new Object[0]);
        }
        AppMethodBeat.m2505o(108192);
        return hashMap;
    }

    /* renamed from: c */
    public static boolean m30275c(ArrayList<String> arrayList, String str) {
        AppMethodBeat.m2504i(108193);
        boolean a = C19538j.m30270a(arrayList, str, false);
        AppMethodBeat.m2505o(108193);
        return a;
    }

    /* renamed from: a */
    public static boolean m30270a(ArrayList<String> arrayList, String str, boolean z) {
        AppMethodBeat.m2504i(108194);
        if (C19538j.m30273b(arrayList, str, z)) {
            AppMethodBeat.m2505o(108194);
            return true;
        } else if (C19538j.m30260CR((String) C19538j.m30258CP(str).get("host")) == 2) {
            C4990ab.m7413e("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", str);
            AppMethodBeat.m2505o(108194);
            return true;
        } else {
            AppMethodBeat.m2505o(108194);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m30273b(ArrayList<String> arrayList, String str, boolean z) {
        AppMethodBeat.m2504i(108195);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            AppMethodBeat.m2505o(108195);
            return false;
        } else if (arrayList == null || arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
            AppMethodBeat.m2505o(108195);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandNetworkUtil", "url ".concat(String.valueOf(str)));
            C4990ab.m7416i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
            HashMap CP = C19538j.m30258CP(str);
            String str2 = (String) CP.get("host");
            String str3 = (String) CP.get("scheme");
            String str4 = (String) CP.get("port");
            if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                AppMethodBeat.m2505o(108195);
                return false;
            }
            C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", str2, str3, str4, Boolean.valueOf(z));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str5 = (String) it.next();
                C4990ab.m7416i("MicroMsg.AppBrandNetworkUtil", "configUrl ".concat(String.valueOf(str5)));
                HashMap CP2 = C19538j.m30258CP(str5);
                C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", (String) CP2.get("host"), (String) CP2.get("scheme"), (String) CP2.get("port"));
                if (str2.equalsIgnoreCase((String) CP2.get("host")) && str3.equalsIgnoreCase(r4)) {
                    if (z || str4.equalsIgnoreCase(r5)) {
                        C4990ab.m7416i("MicroMsg.AppBrandNetworkUtil", "match!!");
                        AppMethodBeat.m2505o(108195);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(108195);
            return false;
        }
    }

    /* renamed from: CQ */
    private static boolean m30259CQ(String str) {
        AppMethodBeat.m2504i(108196);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            AppMethodBeat.m2505o(108196);
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
            AppMethodBeat.m2505o(108196);
            return false;
        }
        for (String str2 : split) {
            int i = C5046bo.getInt(str2, -1);
            if (i < 0 || i > 255) {
                C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
                AppMethodBeat.m2505o(108196);
                return false;
            }
        }
        AppMethodBeat.m2505o(108196);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: CR */
    public static int m30260CR(String str) {
        int ipAddress;
        int f;
        Throwable e;
        AppMethodBeat.m2504i(108197);
        if (C19538j.m30259CQ(str)) {
            String[] split = str.split("\\.");
            int A = C37432o.m63090A(new byte[]{(byte) (C5046bo.getInt(split[0], 0) & 255), (byte) (C5046bo.getInt(split[1], 0) & 255), (byte) (C5046bo.getInt(split[2], 0) & 255), (byte) (C5046bo.getInt(split[3], 0) & 255)});
            WifiManager wifiManager = (WifiManager) C4996ah.getContext().getApplicationContext().getSystemService("wifi");
            if (wifiManager.getWifiState() == 3) {
                ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "matchIp oldIpStr:%s, localIp:%s,oldIpInt:%d, localIpInt:%d, netmask:%d", str, str2, Integer.valueOf(A), Integer.valueOf(ipAddress), Integer.valueOf(wifiManager.getDhcpInfo().netmask));
                f = C19538j.m30279f((long) f, A, ipAddress);
                AppMethodBeat.m2505o(108197);
                return f;
            }
            try {
                ipAddress = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
                try {
                    f = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                ipAddress = 13;
            }
            if (f != ipAddress) {
                C4990ab.m7416i("MicroMsg.AppBrandNetworkUtil", "matchip in apmode");
                f = C19538j.m30283pn(A);
                AppMethodBeat.m2505o(108197);
                return f;
            }
            C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "apState:%d", Integer.valueOf(f));
            AppMethodBeat.m2505o(108197);
            return 0;
        }
        C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
        AppMethodBeat.m2505o(108197);
        return 0;
        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: getWifiApState error", new Object[0]);
        f = 0;
        if (f != ipAddress) {
        }
    }

    /* renamed from: pn */
    private static int m30283pn(int i) {
        AppMethodBeat.m2504i(108198);
        try {
            for (NetworkInterface interfaceAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InterfaceAddress interfaceAddress : interfaceAddresses.getInterfaceAddresses()) {
                    if (!interfaceAddress.getAddress().isLoopbackAddress()) {
                        String toUpperCase = interfaceAddress.getAddress().getHostAddress().toUpperCase();
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase)));
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            int A;
                            int i2;
                            if (C19538j.m30259CQ(toUpperCase)) {
                                String[] split = toUpperCase.split("\\.");
                                A = C37432o.m63090A(new byte[]{(byte) (C5046bo.getInt(split[0], 0) & 255), (byte) (C5046bo.getInt(split[1], 0) & 255), (byte) (C5046bo.getInt(split[2], 0) & 255), (byte) (C5046bo.getInt(split[3], 0) & 255)});
                            } else {
                                A = 0;
                            }
                            int networkPrefixLength = -1 << (32 - interfaceAddress.getNetworkPrefixLength());
                            int[] iArr = new int[4];
                            for (i2 = 0; i2 < 4; i2++) {
                                iArr[3 - i2] = (networkPrefixLength >> (i2 * 8)) & 255;
                            }
                            String str = "" + iArr[0];
                            i2 = 1;
                            while (i2 < 4) {
                                i2++;
                                str = str + "." + iArr[i2];
                            }
                            C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "calcMaskByPrefixLength result:%s", str);
                            String[] split2 = str.split("\\.");
                            C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i), Integer.valueOf(A), Long.valueOf((long) C37432o.m63090A(new byte[]{(byte) (C5046bo.getInt(split2[0], 0) & 255), (byte) (C5046bo.getInt(split2[1], 0) & 255), (byte) (C5046bo.getInt(split2[2], 0) & 255), (byte) (C5046bo.getInt(split2[3], 0) & 255)})));
                            i2 = C19538j.m30279f(r2, i, A);
                            AppMethodBeat.m2505o(108198);
                            return i2;
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: matchAddress error", new Object[0]);
        }
        AppMethodBeat.m2505o(108198);
        return 0;
    }

    /* renamed from: f */
    private static int m30279f(long j, int i, int i2) {
        AppMethodBeat.m2504i(108199);
        int A = C37432o.m63090A(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        long[] jArr = new long[4];
        if (j > 0) {
            jArr[0] = j >>> 24;
            jArr[1] = (16777215 & j) >>> 16;
            jArr[2] = (65535 & j) >>> 8;
            jArr[3] = 255 & j;
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < 4) {
            i3 = (int) (((long) i3) + jArr[i4]);
            if (jArr[i4] < 0 || jArr[i4] > 255) {
                i3 = -1;
                break;
            }
            i4++;
        }
        if (i3 <= 0) {
            j = (long) A;
        }
        C4990ab.m7417i("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if ((((long) i) & j) != (((long) i2) & j)) {
            AppMethodBeat.m2505o(108199);
            return 0;
        } else if (i == i2) {
            AppMethodBeat.m2505o(108199);
            return 1;
        } else {
            AppMethodBeat.m2505o(108199);
            return 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static Map<String, String> m30267a(JSONObject jSONObject, C38414a c38414a) {
        AppMethodBeat.m2504i(108200);
        Map<String, String> E = C19538j.m30262E(jSONObject);
        if (c38414a == null) {
            C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "hy: no network config!");
        } else {
            Map<String, String> map;
            ArrayList arrayList;
            String str;
            if (c38414a.mode == 1) {
                if (c38414a.iol != null) {
                    arrayList = c38414a.iol;
                    if (arrayList == null || arrayList.isEmpty()) {
                        C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            str = (String) it.next();
                            if (str != null) {
                                if (((String) E.remove(str.toLowerCase())) != null) {
                                    C4990ab.m7419v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", str.toLowerCase(), (String) E.remove(str.toLowerCase()));
                                }
                            }
                        }
                    }
                    map = E;
                }
                E.remove("referer");
                if (!TextUtils.isEmpty(c38414a.referer)) {
                    E.put("referer", c38414a.referer);
                }
            } else {
                if (c38414a.mode == 2 && c38414a.iom != null) {
                    arrayList = c38414a.iom;
                    if (arrayList == null) {
                        C4990ab.m7412e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
                        map = E;
                    } else {
                        HashMap hashMap = new HashMap();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            str = (String) it2.next();
                            if (str != null) {
                                String toLowerCase = str.toLowerCase();
                                str = (String) E.get(toLowerCase);
                                if (str != null) {
                                    C4990ab.m7419v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", toLowerCase, str);
                                    hashMap.put(toLowerCase, str);
                                }
                            }
                        }
                        Object map2 = hashMap;
                    }
                }
                E.remove("referer");
                if (TextUtils.isEmpty(c38414a.referer)) {
                }
            }
            E = map2;
            E.remove("referer");
            if (TextUtils.isEmpty(c38414a.referer)) {
            }
        }
        AppMethodBeat.m2505o(108200);
        return E;
    }

    /* renamed from: a */
    public static int m30265a(C38414a c38414a, int i) {
        switch (i) {
            case 0:
                return c38414a.iog;
            case 1:
                return c38414a.ioh;
            case 2:
                return c38414a.ioi;
            case 3:
                return c38414a.ioj;
            default:
                return 0;
        }
    }

    /* renamed from: po */
    public static boolean m30284po(int i) {
        return i == 301 || i == 302;
    }

    /* renamed from: c */
    public static String m30274c(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(108201);
        String str;
        if (httpURLConnection == null) {
            str = "";
            AppMethodBeat.m2505o(108201);
            return str;
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            str = "";
            AppMethodBeat.m2505o(108201);
            return str;
        }
        str = httpURLConnection.getHeaderField("Location");
        if (str == null) {
            str = httpURLConnection.getHeaderField(C8741b.LOCATION);
        }
        if (str == null) {
            AppMethodBeat.m2505o(108201);
            return null;
        }
        try {
            str = url.toURI().resolve(str).toString();
            AppMethodBeat.m2505o(108201);
            return str;
        } catch (URISyntaxException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "URISyntaxException: resolve url error", new Object[0]);
            AppMethodBeat.m2505o(108201);
            return str;
        }
    }

    /* renamed from: a */
    public static void m30269a(HttpURLConnection httpURLConnection, final ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(108202);
        if (httpURLConnection == null) {
            AppMethodBeat.m2505o(108202);
            return;
        }
        final HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                AppMethodBeat.m2504i(108186);
                if (defaultHostnameVerifier.verify(str, sSLSession) || C19538j.m30277d(arrayList, str)) {
                    AppMethodBeat.m2505o(108186);
                    return true;
                }
                AppMethodBeat.m2505o(108186);
                return false;
            }
        });
        AppMethodBeat.m2505o(108202);
    }

    /* renamed from: a */
    public static SSLContext m30268a(C38414a c38414a) {
        AppMethodBeat.m2504i(108203);
        if (C19538j.m30271b(c38414a) == null) {
            AppMethodBeat.m2505o(108203);
            return null;
        }
        TrustManager[] trustManagerArr = new TrustManager[]{C19538j.m30271b(c38414a)};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            AppMethodBeat.m2505o(108203);
            return instance;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: SSLContext init error", new Object[0]);
            AppMethodBeat.m2505o(108203);
            return null;
        }
    }

    /* renamed from: b */
    public static C19550n m30271b(C38414a c38414a) {
        AppMethodBeat.m2504i(108204);
        LinkedList linkedList = new LinkedList();
        Iterator it = c38414a.ion.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            if (!(bArr == null || bArr.length == 0)) {
                linkedList.add(new ByteArrayInputStream(bArr));
            }
        }
        if (!linkedList.isEmpty()) {
            C19550n c19550n = new C19550n(c38414a.iop);
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                c19550n.mo34744B((InputStream) it2.next());
            }
            c19550n.init();
            AppMethodBeat.m2505o(108204);
            return c19550n;
        } else if (c38414a.iop == 1 || c38414a.iop == 2) {
            C4990ab.m7416i("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
            C19550n c19550n2 = new C19550n(c38414a.iop);
            c19550n2.init();
            AppMethodBeat.m2505o(108204);
            return c19550n2;
        } else {
            AppMethodBeat.m2505o(108204);
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m30272b(C45524b c45524b) {
        AppMethodBeat.m2504i(108205);
        switch (c45524b) {
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.m2505o(108205);
                return true;
            default:
                AppMethodBeat.m2505o(108205);
                return false;
        }
    }

    /* renamed from: d */
    private static JSONArray m30276d(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(108206);
        JSONArray jSONArray = new JSONArray();
        if (httpURLConnection == null) {
            AppMethodBeat.m2505o(108206);
            return jSONArray;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            AppMethodBeat.m2505o(108206);
            return jSONArray;
        }
        try {
            if (headerFields.containsKey("Set-Cookie")) {
                List<String> list = (List) headerFields.get("Set-Cookie");
                if (list == null || list.isEmpty()) {
                    AppMethodBeat.m2505o(108206);
                    return jSONArray;
                }
                C4990ab.m7411d("MicroMsg.AppBrandNetworkUtil", "getResponseHeaderCookies Set-Cookie:%s", headerFields.toString());
                for (String put : list) {
                    jSONArray.put(put);
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandNetworkUtil", "getResponseHeaderCookies error : %s", Log.getStackTraceString(e));
        }
        AppMethodBeat.m2505o(108206);
        return jSONArray;
    }

    /* renamed from: e */
    public static JSONObject m30278e(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(108207);
        JSONObject jSONObject = new JSONObject();
        if (httpURLConnection == null) {
            AppMethodBeat.m2505o(108207);
            return jSONObject;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            AppMethodBeat.m2505o(108207);
            return jSONObject;
        }
        for (Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(C5046bo.isNullOrNil(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "JSONException: put header error", new Object[0]);
                }
            }
        }
        JSONArray d = C19538j.m30276d(httpURLConnection);
        try {
            if (d.length() > 0) {
                jSONObject.put("cookies", d);
            }
        } catch (JSONException e2) {
            C4990ab.m7413e("MicroMsg.AppBrandNetworkUtil", "put header error : %s", Log.getStackTraceString(e2));
        }
        AppMethodBeat.m2505o(108207);
        return jSONObject;
    }

    /* renamed from: y */
    public static boolean m30285y(C2241c c2241c) {
        AppMethodBeat.m2504i(108208);
        switch (c2241c.asD()) {
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.m2505o(108208);
                return true;
            default:
                AppMethodBeat.m2505o(108208);
                return false;
        }
    }

    /* renamed from: f */
    public static JSONObject m30280f(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(108209);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "JSONException: put header error", new Object[0]);
        }
        if (httpURLConnection == null) {
            AppMethodBeat.m2505o(108209);
            return jSONObject;
        }
        Map requestProperties = httpURLConnection.getRequestProperties();
        if (requestProperties == null) {
            AppMethodBeat.m2505o(108209);
            return jSONObject;
        }
        for (Entry entry : requestProperties.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(C5046bo.isNullOrNil(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (JSONException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "JSONException: put header error", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(108209);
        return jSONObject;
    }

    /* renamed from: gr */
    public static int m30282gr(long j) {
        AppMethodBeat.m2504i(108210);
        int g = C19538j.m30281g(j, -1);
        AppMethodBeat.m2505o(108210);
        return g;
    }

    /* renamed from: g */
    public static int m30281g(long j, int i) {
        if (j <= 0) {
            return Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (i <= 0) {
            i = 3;
        }
        int i2 = (int) (j / ((long) i));
        if (i2 > SQLiteGlobal.journalSizeLimit || i2 < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            return i2 < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT ? WXMediaMessage.DESCRIPTION_LENGTH_LIMIT : SQLiteGlobal.journalSizeLimit;
        } else {
            return i2;
        }
    }

    /* renamed from: CS */
    public static String m30261CS(String str) {
        return str;
    }

    /* renamed from: G */
    public static String m30264G(JSONObject jSONObject) {
        AppMethodBeat.m2504i(108211);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(108211);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                linkedList.add(optJSONArray.optString(i));
            }
        }
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(108211);
            return null;
        }
        String join = TextUtils.join(", ", linkedList);
        AppMethodBeat.m2505o(108211);
        return join;
    }

    /* renamed from: a */
    public static String m30266a(URI uri) {
        AppMethodBeat.m2504i(108212);
        String scheme = uri.getScheme();
        if (C5046bo.isNullOrNil(scheme)) {
            AppMethodBeat.m2505o(108212);
            return null;
        }
        if (scheme.equalsIgnoreCase("wss")) {
            scheme = "https";
        } else if (scheme.equalsIgnoreCase("ws")) {
            scheme = "http";
        }
        StringBuilder stringBuilder = new StringBuilder(scheme);
        stringBuilder.append("://");
        stringBuilder.append(uri.getHost());
        int port = uri.getPort();
        Object obj = (port == -1 || ((scheme.equalsIgnoreCase("http") && port == 80) || (scheme.equalsIgnoreCase("https") && port == JsApiPauseDownloadTask.CTRL_INDEX))) ? 1 : null;
        if (obj == null) {
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append(uri.getPort());
        }
        scheme = stringBuilder.toString();
        AppMethodBeat.m2505o(108212);
        return scheme;
    }
}
