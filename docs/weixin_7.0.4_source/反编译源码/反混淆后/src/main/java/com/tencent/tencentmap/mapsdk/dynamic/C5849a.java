package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.p666a.C16176aa;
import com.tencent.tencentmap.mapsdk.p666a.C16177ab;
import com.tencent.tencentmap.mapsdk.p666a.C24350x;
import com.tencent.tencentmap.mapsdk.p666a.C24351y;
import com.tencent.tencentmap.mapsdk.p666a.C36478i;
import com.tencent.tencentmap.mapsdk.p666a.C36479j;
import com.tencent.tencentmap.mapsdk.p666a.C41026l;
import com.tencent.tencentmap.mapsdk.p666a.C44497z;
import com.tencent.tencentmap.mapsdk.p666a.C46764k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.dynamic.a */
public class C5849a implements IInitializer {
    /* renamed from: a */
    private static final String[] f1488a = new String[]{"1.0.2", "1.0.3", "1.0.4"};
    /* renamed from: b */
    private static volatile C5849a f1489b;
    /* renamed from: d */
    private static C41026l f1490d;
    /* renamed from: f */
    private static volatile boolean f1491f;
    /* renamed from: c */
    private Context f1492c;
    /* renamed from: e */
    private C16176aa f1493e = C16176aa.m24541a(this.f1492c);
    /* renamed from: g */
    private boolean f1494g;

    /* renamed from: com.tencent.tencentmap.mapsdk.dynamic.a$1 */
    class C58501 implements Runnable {
        C58501() {
        }

        public void run() {
            boolean z = true;
            AppMethodBeat.m2504i(101257);
            if (!C5849a.f1491f) {
                C5849a.f1491f = true;
                C5849a c5849a = C5849a.this;
                if (C5849a.this.f1494g) {
                    z = false;
                }
                c5849a.mo12379a(z);
                C5849a.f1491f = false;
            }
            AppMethodBeat.m2505o(101257);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.dynamic.a$a */
    static class C5851a {
        /* renamed from: a */
        int f1496a;
        /* renamed from: b */
        String f1497b;
        /* renamed from: c */
        String f1498c;
        /* renamed from: d */
        String f1499d;
        /* renamed from: e */
        String f1500e;
        /* renamed from: f */
        int f1501f;
        /* renamed from: g */
        String f1502g;
        /* renamed from: h */
        String f1503h;
        /* renamed from: i */
        int f1504i;
        /* renamed from: j */
        boolean f1505j;
        /* renamed from: k */
        boolean f1506k;

        private C5851a() {
        }

        /* synthetic */ C5851a(C58501 c58501) {
            this();
        }
    }

    private C5849a(Context context) {
        AppMethodBeat.m2504i(101258);
        this.f1492c = context;
        C36479j.m60319a(this.f1492c);
        C24351y.m37628a(this.f1492c);
        f1490d = C41026l.m71300a(context);
        AppMethodBeat.m2505o(101258);
    }

    /* renamed from: a */
    public static C5849a m8982a(Context context) {
        AppMethodBeat.m2504i(101259);
        if (f1489b == null) {
            synchronized (C5849a.class) {
                try {
                    if (f1489b == null) {
                        f1489b = new C5849a(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(101259);
                    }
                }
            }
        }
        C5849a c5849a = f1489b;
        AppMethodBeat.m2505o(101259);
        return c5849a;
    }

    public void downLoadVectorMapResource() {
        AppMethodBeat.m2504i(101260);
        m8990c();
        AppMethodBeat.m2505o(101260);
    }

    public boolean isVectorMapValid() {
        AppMethodBeat.m2504i(101261);
        boolean d = m8991d();
        AppMethodBeat.m2505o(101261);
        return d;
    }

    /* renamed from: c */
    private void m8990c() {
        AppMethodBeat.m2504i(101262);
        new Thread(new C58501()).start();
        AppMethodBeat.m2505o(101262);
    }

    /* renamed from: d */
    private boolean m8991d() {
        AppMethodBeat.m2504i(101263);
        if (!m8992e()) {
            AppMethodBeat.m2505o(101263);
            return false;
        } else if (mo12380a()) {
            AppMethodBeat.m2505o(101263);
            return true;
        } else {
            AppMethodBeat.m2505o(101263);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo12380a() {
        AppMethodBeat.m2504i(101264);
        if (!m8986a(new File(f1490d.mo65079b() + File.separator + "mapconfig.dat"), this.f1493e.mo29048b())) {
            AppMethodBeat.m2505o(101264);
            return false;
        } else if (m8986a(new File(f1490d.mo65079b() + File.separator + "poi_icon@2x.png"), this.f1493e.mo29050c())) {
            AppMethodBeat.m2505o(101264);
            return true;
        } else {
            AppMethodBeat.m2505o(101264);
            return false;
        }
    }

    /* renamed from: e */
    private boolean m8992e() {
        boolean z = true;
        AppMethodBeat.m2504i(101265);
        if (!"1.1.2".equals(this.f1493e.mo29052d())) {
            this.f1493e.mo29053d("1.1.2");
            for (int length = f1488a.length - 1; length > 0; length--) {
                if (m8988b(f1488a[length])) {
                    this.f1493e.mo29046a(f1488a);
                    break;
                }
            }
            z = false;
            this.f1493e.mo29046a(f1488a);
        }
        AppMethodBeat.m2505o(101265);
        return z;
    }

    /* renamed from: a */
    private boolean m8986a(File file, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(101266);
        try {
            String a = C24350x.m37624a(file);
            if (a != null) {
                z = a.equals(str);
                AppMethodBeat.m2505o(101266);
            } else {
                AppMethodBeat.m2505o(101266);
            }
        } catch (FileNotFoundException e) {
            AppMethodBeat.m2505o(101266);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f9 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    private C5851a m8993f() {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Closeable closeable;
        int i = 0;
        AppMethodBeat.m2504i(101267);
        String str = "https://apikey.map.qq.com/sdkapis/v1/getresource?";
        Map treeMap = new TreeMap();
        treeMap.put("ota_ver", m8996i());
        treeMap.put("sdk_ver", "1.1.2");
        treeMap.put("arch", "wx");
        treeMap.put("imei", C24351y.m37626a());
        treeMap.put("system", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("device", C24351y.m37629b());
        treeMap.put("sys_version", C24351y.m37631c());
        treeMap.put("module", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("appname", C24351y.m37633d());
        treeMap.put("package_name", C24351y.m37635e());
        treeMap.put("apikey", C24351y.m37637f());
        Object obj = "";
        NetworkInfo a = C44497z.m80698a(this.f1492c);
        if (a != null) {
            obj = a.getTypeName();
        }
        treeMap.put("env", obj);
        treeMap.put(Param.TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));
        String str2 = str + Uri.encode(m8984a(treeMap), "&=_");
        HttpURLConnection httpURLConnection3 = null;
        Closeable closeable2 = null;
        Closeable closeable3 = null;
        while (i < 3) {
            try {
                Closeable byteArrayOutputStream;
                httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (MalformedURLException e) {
                    C46764k.m88658a(closeable3);
                    C46764k.m88658a(closeable2);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Exception e2) {
                    C46764k.m88658a(closeable3);
                    C46764k.m88658a(closeable2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    closeable = closeable2;
                    C46764k.m88658a(closeable3);
                    C46764k.m88658a(closeable);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(101267);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    closeable3 = httpURLConnection.getInputStream();
                    while (true) {
                        int read = closeable3.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayOutputStream.flush();
                    }
                    C5851a a2 = m8981a(new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding));
                    C46764k.m88658a(closeable3);
                    C46764k.m88658a(byteArrayOutputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(101267);
                    return a2;
                } catch (MalformedURLException e3) {
                    closeable2 = byteArrayOutputStream;
                } catch (Exception e4) {
                    closeable2 = byteArrayOutputStream;
                    C46764k.m88658a(closeable3);
                    C46764k.m88658a(closeable2);
                    if (httpURLConnection != null) {
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    closeable = byteArrayOutputStream;
                    C46764k.m88658a(closeable3);
                    C46764k.m88658a(closeable);
                    if (httpURLConnection2 != null) {
                    }
                    AppMethodBeat.m2505o(101267);
                    throw th;
                }
            } catch (MalformedURLException e5) {
                httpURLConnection = httpURLConnection3;
                C46764k.m88658a(closeable3);
                C46764k.m88658a(closeable2);
                if (httpURLConnection == null) {
                }
                i++;
                httpURLConnection3 = httpURLConnection;
            } catch (Exception e6) {
                httpURLConnection = httpURLConnection3;
                C46764k.m88658a(closeable3);
                C46764k.m88658a(closeable2);
                if (httpURLConnection != null) {
                }
                i++;
                httpURLConnection3 = httpURLConnection;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection2 = httpURLConnection3;
                closeable = closeable2;
                C46764k.m88658a(closeable3);
                C46764k.m88658a(closeable);
                if (httpURLConnection2 != null) {
                }
                AppMethodBeat.m2505o(101267);
                throw th;
            }
        }
        AppMethodBeat.m2505o(101267);
        return null;
    }

    /* renamed from: a */
    private String m8984a(Map<String, String> map) {
        AppMethodBeat.m2504i(101268);
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArr = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length - 1) {
                break;
            }
            stringBuilder.append(strArr[i2]).append("=").append((String) map.get(strArr[i2])).append("&");
            i = i2 + 1;
        }
        stringBuilder.append(strArr[strArr.length - 1]).append("=").append((String) map.get(strArr[strArr.length - 1]));
        String str = null;
        try {
            str = C24350x.m37625a(C16177ab.m24551a(Base64.encodeToString(stringBuilder.toString().getBytes(ProtocolPackage.ServerEncoding), 2)));
        } catch (UnsupportedEncodingException e) {
            C36478i.m60315a("Hash params failed with error:" + e.getMessage());
        }
        str = stringBuilder.append("&sig=").append(str).toString();
        AppMethodBeat.m2505o(101268);
        return str;
    }

    /* renamed from: a */
    private C5851a m8981a(String str) {
        AppMethodBeat.m2504i(101269);
        try {
            JSONObject jSONObject = new JSONObject(str);
            C5851a c5851a = new C5851a();
            try {
                c5851a.f1496a = jSONObject.getInt("status");
            } catch (JSONException e) {
            }
            try {
                c5851a.f1497b = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            } catch (JSONException e2) {
            }
            try {
                c5851a.f1498c = jSONObject.getString("version");
            } catch (JSONException e3) {
            }
            try {
                c5851a.f1499d = jSONObject.getString("full_location");
            } catch (JSONException e4) {
            }
            try {
                c5851a.f1500e = jSONObject.getString("full_md5");
            } catch (JSONException e5) {
            }
            try {
                c5851a.f1501f = jSONObject.getInt("full_size");
            } catch (JSONException e6) {
            }
            try {
                c5851a.f1502g = jSONObject.getString("increment_location");
            } catch (JSONException e7) {
            }
            try {
                c5851a.f1503h = jSONObject.getString("increment_md5");
            } catch (JSONException e8) {
            }
            try {
                c5851a.f1504i = jSONObject.getInt("increment_size");
            } catch (JSONException e9) {
            }
            try {
                if (jSONObject.getString("enforcement").equals("15151515")) {
                    c5851a.f1505j = true;
                } else {
                    c5851a.f1505j = false;
                }
            } catch (JSONException e10) {
            }
            try {
                if (jSONObject.getInt("ver_consisten") == 1) {
                    c5851a.f1506k = true;
                } else {
                    c5851a.f1506k = false;
                }
            } catch (JSONException e11) {
            }
            AppMethodBeat.m2505o(101269);
            return c5851a;
        } catch (JSONException e12) {
            AppMethodBeat.m2505o(101269);
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo12379a(boolean z) {
        AppMethodBeat.m2504i(101270);
        C5851a f = m8993f();
        if (f == null || f.f1496a != 0 || !f.f1506k || (m8988b(f.f1498c) && !z)) {
            AppMethodBeat.m2505o(101270);
            return;
        }
        File a = m8983a(f.f1502g, f.f1503h, f.f1504i);
        if (a == null) {
            a = m8983a(f.f1499d, f.f1500e, f.f1501f);
        }
        if (a == null) {
            AppMethodBeat.m2505o(101270);
            return;
        }
        if (mo12381a(a)) {
            this.f1493e.mo29045a(f.f1498c);
        }
        a.deleteOnExit();
        m8994g();
        C46764k.m88660a(f1490d.mo65078a());
        AppMethodBeat.m2505o(101270);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0103=Splitter:B:16:0x0103, B:23:0x012d=Splitter:B:23:0x012d} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    private void m8994g() {
        Closeable outputStream;
        MalformedURLException e;
        HttpURLConnection httpURLConnection;
        IOException e2;
        Throwable th;
        AppMethodBeat.m2504i(101271);
        String str = "https://apikey.map.qq.com/sdkapis/v1/getresource?";
        Map treeMap = new TreeMap();
        treeMap.put("qt", "fb");
        treeMap.put("ota_ver", m8996i());
        treeMap.put("sdk_ver", "1.1.2");
        treeMap.put("arch", "wx");
        treeMap.put("imei", C24351y.m37626a());
        treeMap.put("system", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("device", C24351y.m37629b());
        treeMap.put("sys_version", C24351y.m37631c());
        treeMap.put("module", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("appname", C24351y.m37633d());
        treeMap.put("package_name", C24351y.m37635e());
        treeMap.put("apikey", C24351y.m37637f());
        Object obj = "";
        NetworkInfo a = C44497z.m80698a(this.f1492c);
        if (a != null) {
            obj = a.getTypeName();
        }
        treeMap.put("env", obj);
        treeMap.put(Param.TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));
        treeMap.put("type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("status", "ok");
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str + Uri.encode(m8984a(treeMap), "&=_")).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                outputStream = httpURLConnection2.getOutputStream();
            } catch (MalformedURLException e3) {
                e = e3;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
            } catch (IOException e4) {
                e2 = e4;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
                C36478i.m60315a("feedback failed with error:" + e2.getMessage());
                C46764k.m88658a(null);
                C46764k.m88658a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(101271);
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
                C46764k.m88658a(null);
                C46764k.m88658a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(101271);
                throw th;
            }
            try {
                C46764k.m88658a(outputStream);
                C46764k.m88658a(httpURLConnection2.getInputStream());
                C46764k.m88658a(outputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    AppMethodBeat.m2505o(101271);
                    return;
                }
            } catch (MalformedURLException e5) {
                e = e5;
                httpURLConnection = httpURLConnection2;
                try {
                    C36478i.m60315a("feedback failed with error:" + e.getMessage());
                    C46764k.m88658a(null);
                    C46764k.m88658a(outputStream);
                    if (httpURLConnection != null) {
                    }
                    AppMethodBeat.m2505o(101271);
                } catch (Throwable th3) {
                    th = th3;
                    C46764k.m88658a(null);
                    C46764k.m88658a(outputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(101271);
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                httpURLConnection = httpURLConnection2;
                C36478i.m60315a("feedback failed with error:" + e2.getMessage());
                C46764k.m88658a(null);
                C46764k.m88658a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(101271);
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                C46764k.m88658a(null);
                C46764k.m88658a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(101271);
                throw th;
            }
        } catch (MalformedURLException e7) {
            e = e7;
            outputStream = null;
            httpURLConnection = null;
            C36478i.m60315a("feedback failed with error:" + e.getMessage());
            C46764k.m88658a(null);
            C46764k.m88658a(outputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                AppMethodBeat.m2505o(101271);
                return;
            }
            AppMethodBeat.m2505o(101271);
        } catch (IOException e8) {
            e2 = e8;
            outputStream = null;
            httpURLConnection = null;
            C36478i.m60315a("feedback failed with error:" + e2.getMessage());
            C46764k.m88658a(null);
            C46764k.m88658a(outputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                AppMethodBeat.m2505o(101271);
                return;
            }
            AppMethodBeat.m2505o(101271);
        } catch (Throwable th32) {
            th = th32;
            outputStream = null;
            httpURLConnection = null;
            C46764k.m88658a(null);
            C46764k.m88658a(outputStream);
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(101271);
            throw th;
        }
        AppMethodBeat.m2505o(101271);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo12381a(File file) {
        AppMethodBeat.m2504i(101272);
        C46764k.m88661b(f1490d.mo65079b());
        if (C46764k.m88659a(file, f1490d.mo65079b())) {
            try {
                this.f1493e.mo29049b(C24350x.m37624a(new File(f1490d.mo65079b() + "mapconfig.dat")));
                try {
                    this.f1493e.mo29051c(C24350x.m37624a(new File(f1490d.mo65079b() + "poi_icon@2x.png")));
                    AppMethodBeat.m2505o(101272);
                    return true;
                } catch (FileNotFoundException e) {
                    AppMethodBeat.m2505o(101272);
                    return false;
                }
            } catch (FileNotFoundException e2) {
                AppMethodBeat.m2505o(101272);
                return false;
            }
        }
        AppMethodBeat.m2505o(101272);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0128 A:{SYNTHETIC, Splitter:B:55:0x0128} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b4 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b4 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b4 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b4 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private File m8983a(String str, String str2, int i) {
        MalformedURLException e;
        Throwable th;
        IOException e2;
        AppMethodBeat.m2504i(101273);
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || i < 0) {
            AppMethodBeat.m2505o(101273);
            return null;
        }
        C46764k.m88661b(f1490d.mo65078a());
        File file = new File(f1490d.mo65078a() + File.separator + str.substring(str.lastIndexOf(47) + 1));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e3) {
                C36478i.m60315a("Downloading file can't be create:" + e3.getMessage());
                AppMethodBeat.m2505o(101273);
                return null;
            }
        }
        int i2 = 0;
        HttpURLConnection httpURLConnection = null;
        Closeable closeable = null;
        Closeable closeable2 = null;
        while (i2 < 3) {
            HttpURLConnection httpURLConnection2;
            Closeable fileOutputStream;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    closeable2 = httpURLConnection2.getInputStream();
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = closeable2.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        C46764k.m88658a(closeable2);
                        C46764k.m88658a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (file.length() == ((long) i)) {
                            AppMethodBeat.m2505o(101273);
                            return null;
                        }
                        try {
                            String a = C24350x.m37624a(file);
                            if (a == null || a.equals(str2)) {
                                AppMethodBeat.m2505o(101273);
                                return file;
                            }
                            AppMethodBeat.m2505o(101273);
                            return null;
                        } catch (FileNotFoundException e4) {
                            C36478i.m60315a("Calculate downloaded file md5 failed:" + e4.getMessage());
                            AppMethodBeat.m2505o(101273);
                            return null;
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                        try {
                            C36478i.m60315a("Downloading vector lib failed with error:" + e.getMessage());
                            C46764k.m88658a(closeable2);
                            C46764k.m88658a(fileOutputStream);
                            if (httpURLConnection2 != null) {
                            }
                            i2++;
                            httpURLConnection = httpURLConnection2;
                            closeable = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            closeable = fileOutputStream;
                            C46764k.m88658a(closeable2);
                            C46764k.m88658a(closeable);
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.m2505o(101273);
                            throw th;
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        C36478i.m60315a("Downloading vector lib failed with error:" + e2.getMessage());
                        C46764k.m88658a(closeable2);
                        C46764k.m88658a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                        }
                        i2++;
                        httpURLConnection = httpURLConnection2;
                        closeable = fileOutputStream;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    fileOutputStream = closeable;
                    C36478i.m60315a("Downloading vector lib failed with error:" + e.getMessage());
                    C46764k.m88658a(closeable2);
                    C46764k.m88658a(fileOutputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    i2++;
                    httpURLConnection = httpURLConnection2;
                    closeable = fileOutputStream;
                } catch (IOException e8) {
                    e2 = e8;
                    fileOutputStream = closeable;
                    C36478i.m60315a("Downloading vector lib failed with error:" + e2.getMessage());
                    C46764k.m88658a(closeable2);
                    C46764k.m88658a(fileOutputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    i2++;
                    httpURLConnection = httpURLConnection2;
                    closeable = fileOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    C46764k.m88658a(closeable2);
                    C46764k.m88658a(closeable);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(101273);
                    throw th;
                }
            } catch (MalformedURLException e9) {
                e = e9;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = closeable;
                C36478i.m60315a("Downloading vector lib failed with error:" + e.getMessage());
                C46764k.m88658a(closeable2);
                C46764k.m88658a(fileOutputStream);
                if (httpURLConnection2 != null) {
                }
                i2++;
                httpURLConnection = httpURLConnection2;
                closeable = fileOutputStream;
            } catch (IOException e10) {
                e2 = e10;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = closeable;
                C36478i.m60315a("Downloading vector lib failed with error:" + e2.getMessage());
                C46764k.m88658a(closeable2);
                C46764k.m88658a(fileOutputStream);
                if (httpURLConnection2 != null) {
                }
                i2++;
                httpURLConnection = httpURLConnection2;
                closeable = fileOutputStream;
            } catch (Throwable th4) {
                th = th4;
                C46764k.m88658a(closeable2);
                C46764k.m88658a(closeable);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(101273);
                throw th;
            }
        }
        if (file.length() == ((long) i)) {
        }
    }

    /* renamed from: h */
    private String[] m8995h() {
        AppMethodBeat.m2504i(101274);
        String[] strArr;
        if (this.f1493e.mo29047a() == null) {
            this.f1493e.mo29046a(f1488a);
            strArr = f1488a;
            AppMethodBeat.m2505o(101274);
            return strArr;
        }
        strArr = this.f1493e.mo29047a();
        AppMethodBeat.m2505o(101274);
        return strArr;
    }

    /* renamed from: i */
    private String m8996i() {
        AppMethodBeat.m2504i(101275);
        String[] h = m8995h();
        String str;
        if (h == null || h.length == 0) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(101275);
            return str;
        }
        str = h[h.length - 1];
        AppMethodBeat.m2505o(101275);
        return str;
    }

    /* renamed from: b */
    private boolean m8988b(String str) {
        AppMethodBeat.m2504i(101276);
        String[] h = m8995h();
        if (str == null || h == null) {
            AppMethodBeat.m2505o(101276);
            return false;
        }
        for (int length = h.length - 1; length > 0; length--) {
            if (str.equals(h[length])) {
                AppMethodBeat.m2505o(101276);
                return true;
            }
        }
        AppMethodBeat.m2505o(101276);
        return false;
    }
}
