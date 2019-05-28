package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.facebook.share.internal.ShareConstants;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class g {
    private String a = "";
    private String b = "";
    private int c = 0;
    private String d = "";
    private Handler e;

    public interface a {
        void a(int i, String str, Vector<e> vector);
    }

    static /* synthetic */ long a(g gVar) {
        AppMethodBeat.i(67542);
        long e = gVar.e();
        AppMethodBeat.o(67542);
        return e;
    }

    static /* synthetic */ boolean a(g gVar, boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(67541);
        boolean a = gVar.a(z, str, str2, str3);
        AppMethodBeat.o(67541);
        return a;
    }

    public g(Context context) {
        AppMethodBeat.i(67535);
        if (context != null) {
            this.e = new Handler(context.getMainLooper());
        }
        AppMethodBeat.o(67535);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int a(String str, int i, a aVar) {
        AppMethodBeat.i(67536);
        this.a = "";
        this.b = "";
        this.c = 0;
        this.d = "";
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(67536);
            return -1;
        }
        final String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(str);
        if (streamIDByStreamUrl == null || streamIDByStreamUrl.isEmpty()) {
            AppMethodBeat.o(67536);
            return -2;
        }
        boolean z;
        final String a = a("bizid", str);
        final String a2 = a("txSecret", str);
        final String a3 = a("txTime", str);
        if (e() <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (a(z, a, a3, a2)) {
            final a aVar2 = aVar;
            a(streamIDByStreamUrl, a, a2, a3, i, new a() {
                public void a(int i, String str, Vector<e> vector) {
                    AppMethodBeat.i(67572);
                    g.this.a = streamIDByStreamUrl;
                    g.this.b = a;
                    g.this.c = i;
                    g.this.d = str;
                    if (vector == null || vector.isEmpty()) {
                        if (aVar2 != null) {
                            aVar2.a(i, str, null);
                        }
                        AppMethodBeat.o(67572);
                        return;
                    }
                    e eVar;
                    Vector vector2 = new Vector();
                    Iterator it = vector.iterator();
                    while (it.hasNext()) {
                        eVar = (e) it.next();
                        String str2 = eVar.a;
                        if (str2.indexOf("?") != -1) {
                            str2 = str2.substring(0, str2.indexOf("?"));
                        }
                        vector2.add(new e(str2 + "?txSecret=" + a2 + "&txTime=" + a3 + "&bizid=" + a, eVar.b));
                    }
                    if (aVar2 != null) {
                        Iterator it2 = vector2.iterator();
                        while (it2.hasNext()) {
                            eVar = (e) it2.next();
                            TXCLog.e("TXRTMPAccUrlFetcher", "accurl = " + eVar.a + " quic = " + eVar.b);
                        }
                        aVar2.a(i, str, vector2);
                    }
                    AppMethodBeat.o(67572);
                }
            });
            AppMethodBeat.o(67536);
            return 0;
        }
        AppMethodBeat.o(67536);
        return -3;
    }

    private boolean a(boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(67537);
        if (z) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
                AppMethodBeat.o(67537);
                return false;
            }
            AppMethodBeat.o(67537);
            return true;
        } else if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(67537);
            return false;
        } else {
            AppMethodBeat.o(67537);
            return true;
        }
    }

    private long e() {
        AppMethodBeat.i(67538);
        long a = b.a().a("Network", "AccRetryCountWithoutSecret");
        AppMethodBeat.o(67538);
        return a;
    }

    private void a(String str, String str2, String str3, String str4, int i, a aVar) {
        AppMethodBeat.i(67539);
        final String str5 = str2;
        final String str6 = str4;
        final String str7 = str3;
        final String str8 = str;
        final int i2 = i;
        final a aVar2 = aVar;
        new Thread("getRTMPAccUrl") {
            /* JADX WARNING: Removed duplicated region for block: B:11:0x003f A:{SYNTHETIC, Splitter:B:11:0x003f} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                int i;
                int i2;
                AppMethodBeat.i(67595);
                int i3 = -1;
                String str = "";
                if (str5 == null || str5.isEmpty()) {
                    i = 0;
                } else {
                    i = Integer.valueOf(str5).intValue();
                }
                int i4 = 5;
                if (!g.a(g.this, true, str5, str6, str7)) {
                    i4 = (int) g.a(g.this);
                    if (i4 <= 0) {
                        i2 = 1;
                        while (i2 > 0) {
                            String str2;
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("bizid", i);
                                jSONObject.put("stream_id", str8);
                                jSONObject.put("txSecret", str7);
                                jSONObject.put("txTime", str6);
                                jSONObject.put("type", 1);
                                String jSONObject2 = jSONObject.toString();
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://livepull.myqcloud.com/getpulladdr").openConnection();
                                httpsURLConnection.setDoOutput(true);
                                httpsURLConnection.setDoInput(true);
                                httpsURLConnection.setUseCaches(false);
                                httpsURLConnection.setConnectTimeout(5000);
                                httpsURLConnection.setReadTimeout(5000);
                                httpsURLConnection.setRequestMethod("POST");
                                httpsURLConnection.setRequestProperty("Charsert", "UTF-8");
                                httpsURLConnection.setRequestProperty("Content-Type", "text/plain;");
                                httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(jSONObject2.length()));
                                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: sendHttpRequest[ " + jSONObject2 + "] retryIndex = " + i2);
                                new DataOutputStream(httpsURLConnection.getOutputStream()).write(jSONObject2.getBytes());
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                                str2 = "";
                                while (true) {
                                    jSONObject2 = bufferedReader.readLine();
                                    if (jSONObject2 == null) {
                                        break;
                                    }
                                    str2 = str2 + jSONObject2;
                                }
                                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: receive response, strResponse = ".concat(String.valueOf(str2)));
                                jSONObject = (JSONObject) new JSONTokener(str2).nextValue();
                                if (jSONObject.has(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                                    i3 = jSONObject.getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                                }
                                if (i3 != 0) {
                                    if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                                        str = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                    }
                                    TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: errorCode = " + i3 + " errorMessage = " + str);
                                }
                                if (jSONObject.has("pull_addr")) {
                                    final Vector vector = new Vector();
                                    final Vector vector2 = new Vector();
                                    JSONArray jSONArray = jSONObject.getJSONArray("pull_addr");
                                    if (jSONArray == null || jSONArray.length() == 0) {
                                        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
                                    } else {
                                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                            jSONObject = (JSONObject) jSONArray.get(i5);
                                            if (jSONObject != null) {
                                                String string = jSONObject.getString("rtmp_url");
                                                boolean z = jSONObject.getInt("proto") == 1;
                                                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: streamUrl = " + string + " Q channel = " + z);
                                                String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(string);
                                                if (streamIDByStreamUrl != null && streamIDByStreamUrl.equalsIgnoreCase(str8)) {
                                                    if (z) {
                                                        vector.add(new e(string, z));
                                                    } else {
                                                        vector2.add(new e(string, z));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                        if (vector2.size() > 0) {
                                            g.this.e.post(new Runnable() {
                                                public void run() {
                                                    AppMethodBeat.i(67544);
                                                    if (aVar2 != null) {
                                                        aVar2.a(0, "Success", vector2);
                                                    }
                                                    AppMethodBeat.o(67544);
                                                }
                                            });
                                            AppMethodBeat.o(67595);
                                            return;
                                        }
                                    } else if (i2 != 2) {
                                        Iterator it = vector2.iterator();
                                        while (it.hasNext()) {
                                            vector.add((e) it.next());
                                        }
                                        if (vector.size() > 0) {
                                            g.this.e.post(new Runnable() {
                                                public void run() {
                                                    AppMethodBeat.i(67581);
                                                    if (aVar2 != null) {
                                                        aVar2.a(0, "Success", vector);
                                                    }
                                                    AppMethodBeat.o(67581);
                                                }
                                            });
                                            AppMethodBeat.o(67595);
                                            return;
                                        }
                                    } else if (vector.size() > 0) {
                                        g.this.e.post(new Runnable() {
                                            public void run() {
                                                AppMethodBeat.i(67582);
                                                if (aVar2 != null) {
                                                    aVar2.a(0, "Success", vector);
                                                }
                                                AppMethodBeat.o(67582);
                                            }
                                        });
                                        AppMethodBeat.o(67595);
                                        return;
                                    }
                                }
                            } catch (Exception e) {
                                str2 = str;
                                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception");
                                str = str2;
                            }
                            try {
                                AnonymousClass2.sleep(1000, 0);
                            } catch (Exception e2) {
                                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception sleep");
                            }
                            i2--;
                        }
                        g.this.e.post(new Runnable() {
                            public void run() {
                                AppMethodBeat.i(67479);
                                if (aVar2 != null) {
                                    aVar2.a(i3, str, null);
                                }
                                AppMethodBeat.o(67479);
                            }
                        });
                        AppMethodBeat.o(67595);
                    }
                }
                i2 = i4;
                while (i2 > 0) {
                }
                g.this.e.post(/* anonymous class already generated */);
                AppMethodBeat.o(67595);
            }
        }.start();
        AppMethodBeat.o(67539);
    }

    private String a(String str, String str2) {
        AppMethodBeat.i(67540);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.o(67540);
            return null;
        }
        String str3;
        String toLowerCase = str.toLowerCase();
        for (String str32 : str2.split("[?&]")) {
            if (str32.indexOf("=") != -1) {
                String[] split = str32.split("[=]");
                if (split.length == 2) {
                    String str4 = split[0];
                    str32 = split[1];
                    if (str4 != null && str4.toLowerCase().equalsIgnoreCase(toLowerCase)) {
                        AppMethodBeat.o(67540);
                        return str32;
                    }
                }
                continue;
            }
        }
        str32 = "";
        AppMethodBeat.o(67540);
        return str32;
    }
}
