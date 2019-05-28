package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.facebook.share.internal.ShareConstants;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
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

/* renamed from: com.tencent.liteav.network.g */
public class C17796g {
    /* renamed from: a */
    private String f4230a = "";
    /* renamed from: b */
    private String f4231b = "";
    /* renamed from: c */
    private int f4232c = 0;
    /* renamed from: d */
    private String f4233d = "";
    /* renamed from: e */
    private Handler f4234e;

    /* renamed from: com.tencent.liteav.network.g$a */
    public interface C17797a {
        /* renamed from: a */
        void mo3896a(int i, String str, Vector<C17794e> vector);
    }

    /* renamed from: a */
    static /* synthetic */ long m27827a(C17796g c17796g) {
        AppMethodBeat.m2504i(67542);
        long e = c17796g.m27836e();
        AppMethodBeat.m2505o(67542);
        return e;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m27831a(C17796g c17796g, boolean z, String str, String str2, String str3) {
        AppMethodBeat.m2504i(67541);
        boolean a = c17796g.m27832a(z, str, str2, str3);
        AppMethodBeat.m2505o(67541);
        return a;
    }

    public C17796g(Context context) {
        AppMethodBeat.m2504i(67535);
        if (context != null) {
            this.f4234e = new Handler(context.getMainLooper());
        }
        AppMethodBeat.m2505o(67535);
    }

    /* renamed from: a */
    public String mo32945a() {
        return this.f4230a;
    }

    /* renamed from: b */
    public String mo32946b() {
        return this.f4231b;
    }

    /* renamed from: c */
    public int mo32947c() {
        return this.f4232c;
    }

    /* renamed from: d */
    public String mo32948d() {
        return this.f4233d;
    }

    /* renamed from: a */
    public int mo32944a(String str, int i, C17797a c17797a) {
        AppMethodBeat.m2504i(67536);
        this.f4230a = "";
        this.f4231b = "";
        this.f4232c = 0;
        this.f4233d = "";
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(67536);
            return -1;
        }
        final String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(str);
        if (streamIDByStreamUrl == null || streamIDByStreamUrl.isEmpty()) {
            AppMethodBeat.m2505o(67536);
            return -2;
        }
        boolean z;
        final String a = m27829a("bizid", str);
        final String a2 = m27829a("txSecret", str);
        final String a3 = m27829a("txTime", str);
        if (m27836e() <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (m27832a(z, a, a3, a2)) {
            final C17797a c17797a2 = c17797a;
            m27830a(streamIDByStreamUrl, a, a2, a3, i, new C17797a() {
                /* renamed from: a */
                public void mo3896a(int i, String str, Vector<C17794e> vector) {
                    AppMethodBeat.m2504i(67572);
                    C17796g.this.f4230a = streamIDByStreamUrl;
                    C17796g.this.f4231b = a;
                    C17796g.this.f4232c = i;
                    C17796g.this.f4233d = str;
                    if (vector == null || vector.isEmpty()) {
                        if (c17797a2 != null) {
                            c17797a2.mo3896a(i, str, null);
                        }
                        AppMethodBeat.m2505o(67572);
                        return;
                    }
                    C17794e c17794e;
                    Vector vector2 = new Vector();
                    Iterator it = vector.iterator();
                    while (it.hasNext()) {
                        c17794e = (C17794e) it.next();
                        String str2 = c17794e.f4226a;
                        if (str2.indexOf("?") != -1) {
                            str2 = str2.substring(0, str2.indexOf("?"));
                        }
                        vector2.add(new C17794e(str2 + "?txSecret=" + a2 + "&txTime=" + a3 + "&bizid=" + a, c17794e.f4227b));
                    }
                    if (c17797a2 != null) {
                        Iterator it2 = vector2.iterator();
                        while (it2.hasNext()) {
                            c17794e = (C17794e) it2.next();
                            TXCLog.m15676e("TXRTMPAccUrlFetcher", "accurl = " + c17794e.f4226a + " quic = " + c17794e.f4227b);
                        }
                        c17797a2.mo3896a(i, str, vector2);
                    }
                    AppMethodBeat.m2505o(67572);
                }
            });
            AppMethodBeat.m2505o(67536);
            return 0;
        }
        AppMethodBeat.m2505o(67536);
        return -3;
    }

    /* renamed from: a */
    private boolean m27832a(boolean z, String str, String str2, String str3) {
        AppMethodBeat.m2504i(67537);
        if (z) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
                AppMethodBeat.m2505o(67537);
                return false;
            }
            AppMethodBeat.m2505o(67537);
            return true;
        } else if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.m2505o(67537);
            return false;
        } else {
            AppMethodBeat.m2505o(67537);
            return true;
        }
    }

    /* renamed from: e */
    private long m27836e() {
        AppMethodBeat.m2504i(67538);
        long a = C45104b.m82752a().mo72874a("Network", "AccRetryCountWithoutSecret");
        AppMethodBeat.m2505o(67538);
        return a;
    }

    /* renamed from: a */
    private void m27830a(String str, String str2, String str3, String str4, int i, C17797a c17797a) {
        AppMethodBeat.m2504i(67539);
        final String str5 = str2;
        final String str6 = str4;
        final String str7 = str3;
        final String str8 = str;
        final int i2 = i;
        final C17797a c17797a2 = c17797a;
        new Thread("getRTMPAccUrl") {
            /* JADX WARNING: Removed duplicated region for block: B:11:0x003f A:{SYNTHETIC, Splitter:B:11:0x003f} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                int i;
                int i2;
                AppMethodBeat.m2504i(67595);
                int i3 = -1;
                String str = "";
                if (str5 == null || str5.isEmpty()) {
                    i = 0;
                } else {
                    i = Integer.valueOf(str5).intValue();
                }
                int i4 = 5;
                if (!C17796g.m27831a(C17796g.this, true, str5, str6, str7)) {
                    i4 = (int) C17796g.m27827a(C17796g.this);
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
                                TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: sendHttpRequest[ " + jSONObject2 + "] retryIndex = " + i2);
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
                                TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: receive response, strResponse = ".concat(String.valueOf(str2)));
                                jSONObject = (JSONObject) new JSONTokener(str2).nextValue();
                                if (jSONObject.has(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                                    i3 = jSONObject.getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                                }
                                if (i3 != 0) {
                                    if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                                        str = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                    }
                                    TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: errorCode = " + i3 + " errorMessage = " + str);
                                }
                                if (jSONObject.has("pull_addr")) {
                                    final Vector vector = new Vector();
                                    final Vector vector2 = new Vector();
                                    JSONArray jSONArray = jSONObject.getJSONArray("pull_addr");
                                    if (jSONArray == null || jSONArray.length() == 0) {
                                        TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
                                    } else {
                                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                            jSONObject = (JSONObject) jSONArray.get(i5);
                                            if (jSONObject != null) {
                                                String string = jSONObject.getString("rtmp_url");
                                                boolean z = jSONObject.getInt("proto") == 1;
                                                TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: streamUrl = " + string + " Q channel = " + z);
                                                String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(string);
                                                if (streamIDByStreamUrl != null && streamIDByStreamUrl.equalsIgnoreCase(str8)) {
                                                    if (z) {
                                                        vector.add(new C17794e(string, z));
                                                    } else {
                                                        vector2.add(new C17794e(string, z));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                        if (vector2.size() > 0) {
                                            C17796g.this.f4234e.post(new Runnable() {
                                                public void run() {
                                                    AppMethodBeat.m2504i(67544);
                                                    if (c17797a2 != null) {
                                                        c17797a2.mo3896a(0, "Success", vector2);
                                                    }
                                                    AppMethodBeat.m2505o(67544);
                                                }
                                            });
                                            AppMethodBeat.m2505o(67595);
                                            return;
                                        }
                                    } else if (i2 != 2) {
                                        Iterator it = vector2.iterator();
                                        while (it.hasNext()) {
                                            vector.add((C17794e) it.next());
                                        }
                                        if (vector.size() > 0) {
                                            C17796g.this.f4234e.post(new Runnable() {
                                                public void run() {
                                                    AppMethodBeat.m2504i(67581);
                                                    if (c17797a2 != null) {
                                                        c17797a2.mo3896a(0, "Success", vector);
                                                    }
                                                    AppMethodBeat.m2505o(67581);
                                                }
                                            });
                                            AppMethodBeat.m2505o(67595);
                                            return;
                                        }
                                    } else if (vector.size() > 0) {
                                        C17796g.this.f4234e.post(new Runnable() {
                                            public void run() {
                                                AppMethodBeat.m2504i(67582);
                                                if (c17797a2 != null) {
                                                    c17797a2.mo3896a(0, "Success", vector);
                                                }
                                                AppMethodBeat.m2505o(67582);
                                            }
                                        });
                                        AppMethodBeat.m2505o(67595);
                                        return;
                                    }
                                }
                            } catch (Exception e) {
                                str2 = str;
                                TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception");
                                str = str2;
                            }
                            try {
                                C177982.sleep(1000, 0);
                            } catch (Exception e2) {
                                TXCLog.m15676e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception sleep");
                            }
                            i2--;
                        }
                        C17796g.this.f4234e.post(new Runnable() {
                            public void run() {
                                AppMethodBeat.m2504i(67479);
                                if (c17797a2 != null) {
                                    c17797a2.mo3896a(i3, str, null);
                                }
                                AppMethodBeat.m2505o(67479);
                            }
                        });
                        AppMethodBeat.m2505o(67595);
                    }
                }
                i2 = i4;
                while (i2 > 0) {
                }
                C17796g.this.f4234e.post(/* anonymous class already generated */);
                AppMethodBeat.m2505o(67595);
            }
        }.start();
        AppMethodBeat.m2505o(67539);
    }

    /* renamed from: a */
    private String m27829a(String str, String str2) {
        AppMethodBeat.m2504i(67540);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.m2505o(67540);
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
                        AppMethodBeat.m2505o(67540);
                        return str32;
                    }
                }
                continue;
            }
        }
        str32 = "";
        AppMethodBeat.m2505o(67540);
        return str32;
    }
}
