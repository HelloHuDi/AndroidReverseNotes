package com.tencent.mm.plugin.appbrand.l;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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

public enum j {
    ;

    public static HashMap<String, String> CP(String str) {
        AppMethodBeat.i(108190);
        Object obj = "";
        Object obj2 = "";
        Object obj3 = "";
        try {
            Uri parse = Uri.parse(str);
            obj = parse.getHost();
            obj2 = parse.getScheme();
            obj3 = String.valueOf(parse.getPort());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: parseUrl error", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("host", obj);
        hashMap.put("scheme", obj2);
        hashMap.put("port", obj3);
        AppMethodBeat.o(108190);
        return hashMap;
    }

    private static Map<String, String> E(JSONObject jSONObject) {
        AppMethodBeat.i(108191);
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
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: get header error", new Object[0]);
        }
        AppMethodBeat.o(108191);
        return hashMap;
    }

    public static Map<String, String> F(JSONObject jSONObject) {
        AppMethodBeat.i(108192);
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
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: get form error", new Object[0]);
        }
        AppMethodBeat.o(108192);
        return hashMap;
    }

    public static boolean c(ArrayList<String> arrayList, String str) {
        AppMethodBeat.i(108193);
        boolean a = a(arrayList, str, false);
        AppMethodBeat.o(108193);
        return a;
    }

    public static boolean a(ArrayList<String> arrayList, String str, boolean z) {
        AppMethodBeat.i(108194);
        if (b(arrayList, str, z)) {
            AppMethodBeat.o(108194);
            return true;
        } else if (CR((String) CP(str).get("host")) == 2) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", str);
            AppMethodBeat.o(108194);
            return true;
        } else {
            AppMethodBeat.o(108194);
            return false;
        }
    }

    public static boolean b(ArrayList<String> arrayList, String str, boolean z) {
        AppMethodBeat.i(108195);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            AppMethodBeat.o(108195);
            return false;
        } else if (arrayList == null || arrayList.size() == 0) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
            AppMethodBeat.o(108195);
            return false;
        } else {
            ab.i("MicroMsg.AppBrandNetworkUtil", "url ".concat(String.valueOf(str)));
            ab.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
            HashMap CP = CP(str);
            String str2 = (String) CP.get("host");
            String str3 = (String) CP.get("scheme");
            String str4 = (String) CP.get("port");
            if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
                AppMethodBeat.o(108195);
                return false;
            }
            ab.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", str2, str3, str4, Boolean.valueOf(z));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str5 = (String) it.next();
                ab.i("MicroMsg.AppBrandNetworkUtil", "configUrl ".concat(String.valueOf(str5)));
                HashMap CP2 = CP(str5);
                ab.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", (String) CP2.get("host"), (String) CP2.get("scheme"), (String) CP2.get("port"));
                if (str2.equalsIgnoreCase((String) CP2.get("host")) && str3.equalsIgnoreCase(r4)) {
                    if (z || str4.equalsIgnoreCase(r5)) {
                        ab.i("MicroMsg.AppBrandNetworkUtil", "match!!");
                        AppMethodBeat.o(108195);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(108195);
            return false;
        }
    }

    private static boolean CQ(String str) {
        AppMethodBeat.i(108196);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            AppMethodBeat.o(108196);
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
            AppMethodBeat.o(108196);
            return false;
        }
        for (String str2 : split) {
            int i = bo.getInt(str2, -1);
            if (i < 0 || i > 255) {
                ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
                AppMethodBeat.o(108196);
                return false;
            }
        }
        AppMethodBeat.o(108196);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int CR(String str) {
        int ipAddress;
        int f;
        Throwable e;
        AppMethodBeat.i(108197);
        if (CQ(str)) {
            String[] split = str.split("\\.");
            int A = o.A(new byte[]{(byte) (bo.getInt(split[0], 0) & 255), (byte) (bo.getInt(split[1], 0) & 255), (byte) (bo.getInt(split[2], 0) & 255), (byte) (bo.getInt(split[3], 0) & 255)});
            WifiManager wifiManager = (WifiManager) ah.getContext().getApplicationContext().getSystemService("wifi");
            if (wifiManager.getWifiState() == 3) {
                ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                ab.i("MicroMsg.AppBrandNetworkUtil", "matchIp oldIpStr:%s, localIp:%s,oldIpInt:%d, localIpInt:%d, netmask:%d", str, str2, Integer.valueOf(A), Integer.valueOf(ipAddress), Integer.valueOf(wifiManager.getDhcpInfo().netmask));
                f = f((long) f, A, ipAddress);
                AppMethodBeat.o(108197);
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
                ab.i("MicroMsg.AppBrandNetworkUtil", "matchip in apmode");
                f = pn(A);
                AppMethodBeat.o(108197);
                return f;
            }
            ab.i("MicroMsg.AppBrandNetworkUtil", "apState:%d", Integer.valueOf(f));
            AppMethodBeat.o(108197);
            return 0;
        }
        ab.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
        AppMethodBeat.o(108197);
        return 0;
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: getWifiApState error", new Object[0]);
        f = 0;
        if (f != ipAddress) {
        }
    }

    private static int pn(int i) {
        AppMethodBeat.i(108198);
        try {
            for (NetworkInterface interfaceAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InterfaceAddress interfaceAddress : interfaceAddresses.getInterfaceAddresses()) {
                    if (!interfaceAddress.getAddress().isLoopbackAddress()) {
                        String toUpperCase = interfaceAddress.getAddress().getHostAddress().toUpperCase();
                        ab.i("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase)));
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            int A;
                            int i2;
                            if (CQ(toUpperCase)) {
                                String[] split = toUpperCase.split("\\.");
                                A = o.A(new byte[]{(byte) (bo.getInt(split[0], 0) & 255), (byte) (bo.getInt(split[1], 0) & 255), (byte) (bo.getInt(split[2], 0) & 255), (byte) (bo.getInt(split[3], 0) & 255)});
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
                            ab.i("MicroMsg.AppBrandNetworkUtil", "calcMaskByPrefixLength result:%s", str);
                            String[] split2 = str.split("\\.");
                            ab.i("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i), Integer.valueOf(A), Long.valueOf((long) o.A(new byte[]{(byte) (bo.getInt(split2[0], 0) & 255), (byte) (bo.getInt(split2[1], 0) & 255), (byte) (bo.getInt(split2[2], 0) & 255), (byte) (bo.getInt(split2[3], 0) & 255)})));
                            i2 = f(r2, i, A);
                            AppMethodBeat.o(108198);
                            return i2;
                        }
                    }
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: matchAddress error", new Object[0]);
        }
        AppMethodBeat.o(108198);
        return 0;
    }

    private static int f(long j, int i, int i2) {
        AppMethodBeat.i(108199);
        int A = o.A(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
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
        ab.i("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if ((((long) i) & j) != (((long) i2) & j)) {
            AppMethodBeat.o(108199);
            return 0;
        } else if (i == i2) {
            AppMethodBeat.o(108199);
            return 1;
        } else {
            AppMethodBeat.o(108199);
            return 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Map<String, String> a(JSONObject jSONObject, a aVar) {
        AppMethodBeat.i(108200);
        Map<String, String> E = E(jSONObject);
        if (aVar == null) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "hy: no network config!");
        } else {
            Map<String, String> map;
            ArrayList arrayList;
            String str;
            if (aVar.mode == 1) {
                if (aVar.iol != null) {
                    arrayList = aVar.iol;
                    if (arrayList == null || arrayList.isEmpty()) {
                        ab.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
                    } else {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            str = (String) it.next();
                            if (str != null) {
                                if (((String) E.remove(str.toLowerCase())) != null) {
                                    ab.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", str.toLowerCase(), (String) E.remove(str.toLowerCase()));
                                }
                            }
                        }
                    }
                    map = E;
                }
                E.remove("referer");
                if (!TextUtils.isEmpty(aVar.referer)) {
                    E.put("referer", aVar.referer);
                }
            } else {
                if (aVar.mode == 2 && aVar.iom != null) {
                    arrayList = aVar.iom;
                    if (arrayList == null) {
                        ab.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
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
                                    ab.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", toLowerCase, str);
                                    hashMap.put(toLowerCase, str);
                                }
                            }
                        }
                        Object map2 = hashMap;
                    }
                }
                E.remove("referer");
                if (TextUtils.isEmpty(aVar.referer)) {
                }
            }
            E = map2;
            E.remove("referer");
            if (TextUtils.isEmpty(aVar.referer)) {
            }
        }
        AppMethodBeat.o(108200);
        return E;
    }

    public static int a(a aVar, int i) {
        switch (i) {
            case 0:
                return aVar.iog;
            case 1:
                return aVar.ioh;
            case 2:
                return aVar.ioi;
            case 3:
                return aVar.ioj;
            default:
                return 0;
        }
    }

    public static boolean po(int i) {
        return i == 301 || i == 302;
    }

    public static String c(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(108201);
        String str;
        if (httpURLConnection == null) {
            str = "";
            AppMethodBeat.o(108201);
            return str;
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            str = "";
            AppMethodBeat.o(108201);
            return str;
        }
        str = httpURLConnection.getHeaderField("Location");
        if (str == null) {
            str = httpURLConnection.getHeaderField(b.LOCATION);
        }
        if (str == null) {
            AppMethodBeat.o(108201);
            return null;
        }
        try {
            str = url.toURI().resolve(str).toString();
            AppMethodBeat.o(108201);
            return str;
        } catch (URISyntaxException e) {
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "URISyntaxException: resolve url error", new Object[0]);
            AppMethodBeat.o(108201);
            return str;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, final ArrayList<String> arrayList) {
        AppMethodBeat.i(108202);
        if (httpURLConnection == null) {
            AppMethodBeat.o(108202);
            return;
        }
        final HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                AppMethodBeat.i(108186);
                if (defaultHostnameVerifier.verify(str, sSLSession) || j.d(arrayList, str)) {
                    AppMethodBeat.o(108186);
                    return true;
                }
                AppMethodBeat.o(108186);
                return false;
            }
        });
        AppMethodBeat.o(108202);
    }

    public static SSLContext a(a aVar) {
        AppMethodBeat.i(108203);
        if (b(aVar) == null) {
            AppMethodBeat.o(108203);
            return null;
        }
        TrustManager[] trustManagerArr = new TrustManager[]{b(aVar)};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            AppMethodBeat.o(108203);
            return instance;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "Exception: SSLContext init error", new Object[0]);
            AppMethodBeat.o(108203);
            return null;
        }
    }

    public static n b(a aVar) {
        AppMethodBeat.i(108204);
        LinkedList linkedList = new LinkedList();
        Iterator it = aVar.ion.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            if (!(bArr == null || bArr.length == 0)) {
                linkedList.add(new ByteArrayInputStream(bArr));
            }
        }
        if (!linkedList.isEmpty()) {
            n nVar = new n(aVar.iop);
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                nVar.B((InputStream) it2.next());
            }
            nVar.init();
            AppMethodBeat.o(108204);
            return nVar;
        } else if (aVar.iop == 1 || aVar.iop == 2) {
            ab.i("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
            n nVar2 = new n(aVar.iop);
            nVar2.init();
            AppMethodBeat.o(108204);
            return nVar2;
        } else {
            AppMethodBeat.o(108204);
            return null;
        }
    }

    public static boolean b(com.tencent.mm.plugin.appbrand.b.b bVar) {
        AppMethodBeat.i(108205);
        switch (bVar) {
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.o(108205);
                return true;
            default:
                AppMethodBeat.o(108205);
                return false;
        }
    }

    private static JSONArray d(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(108206);
        JSONArray jSONArray = new JSONArray();
        if (httpURLConnection == null) {
            AppMethodBeat.o(108206);
            return jSONArray;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            AppMethodBeat.o(108206);
            return jSONArray;
        }
        try {
            if (headerFields.containsKey("Set-Cookie")) {
                List<String> list = (List) headerFields.get("Set-Cookie");
                if (list == null || list.isEmpty()) {
                    AppMethodBeat.o(108206);
                    return jSONArray;
                }
                ab.d("MicroMsg.AppBrandNetworkUtil", "getResponseHeaderCookies Set-Cookie:%s", headerFields.toString());
                for (String put : list) {
                    jSONArray.put(put);
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "getResponseHeaderCookies error : %s", Log.getStackTraceString(e));
        }
        AppMethodBeat.o(108206);
        return jSONArray;
    }

    public static JSONObject e(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(108207);
        JSONObject jSONObject = new JSONObject();
        if (httpURLConnection == null) {
            AppMethodBeat.o(108207);
            return jSONObject;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            AppMethodBeat.o(108207);
            return jSONObject;
        }
        for (Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bo.isNullOrNil(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "JSONException: put header error", new Object[0]);
                }
            }
        }
        JSONArray d = d(httpURLConnection);
        try {
            if (d.length() > 0) {
                jSONObject.put("cookies", d);
            }
        } catch (JSONException e2) {
            ab.e("MicroMsg.AppBrandNetworkUtil", "put header error : %s", Log.getStackTraceString(e2));
        }
        AppMethodBeat.o(108207);
        return jSONObject;
    }

    public static boolean y(c cVar) {
        AppMethodBeat.i(108208);
        switch (cVar.asD()) {
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.o(108208);
                return true;
            default:
                AppMethodBeat.o(108208);
                return false;
        }
    }

    public static JSONObject f(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(108209);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e, "JSONException: put header error", new Object[0]);
        }
        if (httpURLConnection == null) {
            AppMethodBeat.o(108209);
            return jSONObject;
        }
        Map requestProperties = httpURLConnection.getRequestProperties();
        if (requestProperties == null) {
            AppMethodBeat.o(108209);
            return jSONObject;
        }
        for (Entry entry : requestProperties.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bo.isNullOrNil(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (JSONException e2) {
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "JSONException: put header error", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(108209);
        return jSONObject;
    }

    public static int gr(long j) {
        AppMethodBeat.i(108210);
        int g = g(j, -1);
        AppMethodBeat.o(108210);
        return g;
    }

    public static int g(long j, int i) {
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

    public static String CS(String str) {
        return str;
    }

    public static String G(JSONObject jSONObject) {
        AppMethodBeat.i(108211);
        if (jSONObject == null) {
            AppMethodBeat.o(108211);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                linkedList.add(optJSONArray.optString(i));
            }
        }
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(108211);
            return null;
        }
        String join = TextUtils.join(", ", linkedList);
        AppMethodBeat.o(108211);
        return join;
    }

    public static String a(URI uri) {
        AppMethodBeat.i(108212);
        String scheme = uri.getScheme();
        if (bo.isNullOrNil(scheme)) {
            AppMethodBeat.o(108212);
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
        AppMethodBeat.o(108212);
        return scheme;
    }
}
