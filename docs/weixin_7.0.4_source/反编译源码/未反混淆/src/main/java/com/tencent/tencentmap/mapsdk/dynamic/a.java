package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.a.aa;
import com.tencent.tencentmap.mapsdk.a.ab;
import com.tencent.tencentmap.mapsdk.a.i;
import com.tencent.tencentmap.mapsdk.a.j;
import com.tencent.tencentmap.mapsdk.a.k;
import com.tencent.tencentmap.mapsdk.a.l;
import com.tencent.tencentmap.mapsdk.a.x;
import com.tencent.tencentmap.mapsdk.a.y;
import com.tencent.tencentmap.mapsdk.a.z;
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

public class a implements IInitializer {
    private static final String[] a = new String[]{"1.0.2", "1.0.3", "1.0.4"};
    private static volatile a b;
    private static l d;
    private static volatile boolean f;
    private Context c;
    private aa e = aa.a(this.c);
    private boolean g;

    static class a {
        int a;
        String b;
        String c;
        String d;
        String e;
        int f;
        String g;
        String h;
        int i;
        boolean j;
        boolean k;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private a(Context context) {
        AppMethodBeat.i(101258);
        this.c = context;
        j.a(this.c);
        y.a(this.c);
        d = l.a(context);
        AppMethodBeat.o(101258);
    }

    public static a a(Context context) {
        AppMethodBeat.i(101259);
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(101259);
                    }
                }
            }
        }
        a aVar = b;
        AppMethodBeat.o(101259);
        return aVar;
    }

    public void downLoadVectorMapResource() {
        AppMethodBeat.i(101260);
        c();
        AppMethodBeat.o(101260);
    }

    public boolean isVectorMapValid() {
        AppMethodBeat.i(101261);
        boolean d = d();
        AppMethodBeat.o(101261);
        return d;
    }

    private void c() {
        AppMethodBeat.i(101262);
        new Thread(new Runnable() {
            public void run() {
                boolean z = true;
                AppMethodBeat.i(101257);
                if (!a.f) {
                    a.f = true;
                    a aVar = a.this;
                    if (a.this.g) {
                        z = false;
                    }
                    aVar.a(z);
                    a.f = false;
                }
                AppMethodBeat.o(101257);
            }
        }).start();
        AppMethodBeat.o(101262);
    }

    private boolean d() {
        AppMethodBeat.i(101263);
        if (!e()) {
            AppMethodBeat.o(101263);
            return false;
        } else if (a()) {
            AppMethodBeat.o(101263);
            return true;
        } else {
            AppMethodBeat.o(101263);
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        AppMethodBeat.i(101264);
        if (!a(new File(d.b() + File.separator + "mapconfig.dat"), this.e.b())) {
            AppMethodBeat.o(101264);
            return false;
        } else if (a(new File(d.b() + File.separator + "poi_icon@2x.png"), this.e.c())) {
            AppMethodBeat.o(101264);
            return true;
        } else {
            AppMethodBeat.o(101264);
            return false;
        }
    }

    private boolean e() {
        boolean z = true;
        AppMethodBeat.i(101265);
        if (!"1.1.2".equals(this.e.d())) {
            this.e.d("1.1.2");
            for (int length = a.length - 1; length > 0; length--) {
                if (b(a[length])) {
                    this.e.a(a);
                    break;
                }
            }
            z = false;
            this.e.a(a);
        }
        AppMethodBeat.o(101265);
        return z;
    }

    private boolean a(File file, String str) {
        boolean z = false;
        AppMethodBeat.i(101266);
        try {
            String a = x.a(file);
            if (a != null) {
                z = a.equals(str);
                AppMethodBeat.o(101266);
            } else {
                AppMethodBeat.o(101266);
            }
        } catch (FileNotFoundException e) {
            AppMethodBeat.o(101266);
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
    private a f() {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Closeable closeable;
        int i = 0;
        AppMethodBeat.i(101267);
        String str = "https://apikey.map.qq.com/sdkapis/v1/getresource?";
        Map treeMap = new TreeMap();
        treeMap.put("ota_ver", i());
        treeMap.put("sdk_ver", "1.1.2");
        treeMap.put("arch", "wx");
        treeMap.put("imei", y.a());
        treeMap.put("system", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("device", y.b());
        treeMap.put("sys_version", y.c());
        treeMap.put("module", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("appname", y.d());
        treeMap.put("package_name", y.e());
        treeMap.put("apikey", y.f());
        Object obj = "";
        NetworkInfo a = z.a(this.c);
        if (a != null) {
            obj = a.getTypeName();
        }
        treeMap.put("env", obj);
        treeMap.put(Param.TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));
        String str2 = str + Uri.encode(a(treeMap), "&=_");
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
                    k.a(closeable3);
                    k.a(closeable2);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Exception e2) {
                    k.a(closeable3);
                    k.a(closeable2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    closeable = closeable2;
                    k.a(closeable3);
                    k.a(closeable);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(101267);
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
                    a a2 = a(new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding));
                    k.a(closeable3);
                    k.a(byteArrayOutputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(101267);
                    return a2;
                } catch (MalformedURLException e3) {
                    closeable2 = byteArrayOutputStream;
                } catch (Exception e4) {
                    closeable2 = byteArrayOutputStream;
                    k.a(closeable3);
                    k.a(closeable2);
                    if (httpURLConnection != null) {
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    closeable = byteArrayOutputStream;
                    k.a(closeable3);
                    k.a(closeable);
                    if (httpURLConnection2 != null) {
                    }
                    AppMethodBeat.o(101267);
                    throw th;
                }
            } catch (MalformedURLException e5) {
                httpURLConnection = httpURLConnection3;
                k.a(closeable3);
                k.a(closeable2);
                if (httpURLConnection == null) {
                }
                i++;
                httpURLConnection3 = httpURLConnection;
            } catch (Exception e6) {
                httpURLConnection = httpURLConnection3;
                k.a(closeable3);
                k.a(closeable2);
                if (httpURLConnection != null) {
                }
                i++;
                httpURLConnection3 = httpURLConnection;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection2 = httpURLConnection3;
                closeable = closeable2;
                k.a(closeable3);
                k.a(closeable);
                if (httpURLConnection2 != null) {
                }
                AppMethodBeat.o(101267);
                throw th;
            }
        }
        AppMethodBeat.o(101267);
        return null;
    }

    private String a(Map<String, String> map) {
        AppMethodBeat.i(101268);
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
            str = x.a(ab.a(Base64.encodeToString(stringBuilder.toString().getBytes(ProtocolPackage.ServerEncoding), 2)));
        } catch (UnsupportedEncodingException e) {
            i.a("Hash params failed with error:" + e.getMessage());
        }
        str = stringBuilder.append("&sig=").append(str).toString();
        AppMethodBeat.o(101268);
        return str;
    }

    private a a(String str) {
        AppMethodBeat.i(101269);
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            try {
                aVar.a = jSONObject.getInt("status");
            } catch (JSONException e) {
            }
            try {
                aVar.b = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            } catch (JSONException e2) {
            }
            try {
                aVar.c = jSONObject.getString("version");
            } catch (JSONException e3) {
            }
            try {
                aVar.d = jSONObject.getString("full_location");
            } catch (JSONException e4) {
            }
            try {
                aVar.e = jSONObject.getString("full_md5");
            } catch (JSONException e5) {
            }
            try {
                aVar.f = jSONObject.getInt("full_size");
            } catch (JSONException e6) {
            }
            try {
                aVar.g = jSONObject.getString("increment_location");
            } catch (JSONException e7) {
            }
            try {
                aVar.h = jSONObject.getString("increment_md5");
            } catch (JSONException e8) {
            }
            try {
                aVar.i = jSONObject.getInt("increment_size");
            } catch (JSONException e9) {
            }
            try {
                if (jSONObject.getString("enforcement").equals("15151515")) {
                    aVar.j = true;
                } else {
                    aVar.j = false;
                }
            } catch (JSONException e10) {
            }
            try {
                if (jSONObject.getInt("ver_consisten") == 1) {
                    aVar.k = true;
                } else {
                    aVar.k = false;
                }
            } catch (JSONException e11) {
            }
            AppMethodBeat.o(101269);
            return aVar;
        } catch (JSONException e12) {
            AppMethodBeat.o(101269);
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(boolean z) {
        AppMethodBeat.i(101270);
        a f = f();
        if (f == null || f.a != 0 || !f.k || (b(f.c) && !z)) {
            AppMethodBeat.o(101270);
            return;
        }
        File a = a(f.g, f.h, f.i);
        if (a == null) {
            a = a(f.d, f.e, f.f);
        }
        if (a == null) {
            AppMethodBeat.o(101270);
            return;
        }
        if (a(a)) {
            this.e.a(f.c);
        }
        a.deleteOnExit();
        g();
        k.a(d.a());
        AppMethodBeat.o(101270);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0103=Splitter:B:16:0x0103, B:23:0x012d=Splitter:B:23:0x012d} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        Closeable outputStream;
        MalformedURLException e;
        HttpURLConnection httpURLConnection;
        IOException e2;
        Throwable th;
        AppMethodBeat.i(101271);
        String str = "https://apikey.map.qq.com/sdkapis/v1/getresource?";
        Map treeMap = new TreeMap();
        treeMap.put("qt", "fb");
        treeMap.put("ota_ver", i());
        treeMap.put("sdk_ver", "1.1.2");
        treeMap.put("arch", "wx");
        treeMap.put("imei", y.a());
        treeMap.put("system", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("device", y.b());
        treeMap.put("sys_version", y.c());
        treeMap.put("module", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("appname", y.d());
        treeMap.put("package_name", y.e());
        treeMap.put("apikey", y.f());
        Object obj = "";
        NetworkInfo a = z.a(this.c);
        if (a != null) {
            obj = a.getTypeName();
        }
        treeMap.put("env", obj);
        treeMap.put(Param.TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));
        treeMap.put("type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        treeMap.put("status", "ok");
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str + Uri.encode(a(treeMap), "&=_")).openConnection();
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
                i.a("feedback failed with error:" + e2.getMessage());
                k.a(null);
                k.a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(101271);
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
                k.a(null);
                k.a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(101271);
                throw th;
            }
            try {
                k.a(outputStream);
                k.a(httpURLConnection2.getInputStream());
                k.a(outputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    AppMethodBeat.o(101271);
                    return;
                }
            } catch (MalformedURLException e5) {
                e = e5;
                httpURLConnection = httpURLConnection2;
                try {
                    i.a("feedback failed with error:" + e.getMessage());
                    k.a(null);
                    k.a(outputStream);
                    if (httpURLConnection != null) {
                    }
                    AppMethodBeat.o(101271);
                } catch (Throwable th3) {
                    th = th3;
                    k.a(null);
                    k.a(outputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(101271);
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                httpURLConnection = httpURLConnection2;
                i.a("feedback failed with error:" + e2.getMessage());
                k.a(null);
                k.a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(101271);
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                k.a(null);
                k.a(outputStream);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(101271);
                throw th;
            }
        } catch (MalformedURLException e7) {
            e = e7;
            outputStream = null;
            httpURLConnection = null;
            i.a("feedback failed with error:" + e.getMessage());
            k.a(null);
            k.a(outputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                AppMethodBeat.o(101271);
                return;
            }
            AppMethodBeat.o(101271);
        } catch (IOException e8) {
            e2 = e8;
            outputStream = null;
            httpURLConnection = null;
            i.a("feedback failed with error:" + e2.getMessage());
            k.a(null);
            k.a(outputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                AppMethodBeat.o(101271);
                return;
            }
            AppMethodBeat.o(101271);
        } catch (Throwable th32) {
            th = th32;
            outputStream = null;
            httpURLConnection = null;
            k.a(null);
            k.a(outputStream);
            if (httpURLConnection != null) {
            }
            AppMethodBeat.o(101271);
            throw th;
        }
        AppMethodBeat.o(101271);
    }

    /* Access modifiers changed, original: protected */
    public boolean a(File file) {
        AppMethodBeat.i(101272);
        k.b(d.b());
        if (k.a(file, d.b())) {
            try {
                this.e.b(x.a(new File(d.b() + "mapconfig.dat")));
                try {
                    this.e.c(x.a(new File(d.b() + "poi_icon@2x.png")));
                    AppMethodBeat.o(101272);
                    return true;
                } catch (FileNotFoundException e) {
                    AppMethodBeat.o(101272);
                    return false;
                }
            } catch (FileNotFoundException e2) {
                AppMethodBeat.o(101272);
                return false;
            }
        }
        AppMethodBeat.o(101272);
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
    private File a(String str, String str2, int i) {
        MalformedURLException e;
        Throwable th;
        IOException e2;
        AppMethodBeat.i(101273);
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || i < 0) {
            AppMethodBeat.o(101273);
            return null;
        }
        k.b(d.a());
        File file = new File(d.a() + File.separator + str.substring(str.lastIndexOf(47) + 1));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e3) {
                i.a("Downloading file can't be create:" + e3.getMessage());
                AppMethodBeat.o(101273);
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
                        k.a(closeable2);
                        k.a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (file.length() == ((long) i)) {
                            AppMethodBeat.o(101273);
                            return null;
                        }
                        try {
                            String a = x.a(file);
                            if (a == null || a.equals(str2)) {
                                AppMethodBeat.o(101273);
                                return file;
                            }
                            AppMethodBeat.o(101273);
                            return null;
                        } catch (FileNotFoundException e4) {
                            i.a("Calculate downloaded file md5 failed:" + e4.getMessage());
                            AppMethodBeat.o(101273);
                            return null;
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                        try {
                            i.a("Downloading vector lib failed with error:" + e.getMessage());
                            k.a(closeable2);
                            k.a(fileOutputStream);
                            if (httpURLConnection2 != null) {
                            }
                            i2++;
                            httpURLConnection = httpURLConnection2;
                            closeable = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            closeable = fileOutputStream;
                            k.a(closeable2);
                            k.a(closeable);
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.o(101273);
                            throw th;
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        i.a("Downloading vector lib failed with error:" + e2.getMessage());
                        k.a(closeable2);
                        k.a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                        }
                        i2++;
                        httpURLConnection = httpURLConnection2;
                        closeable = fileOutputStream;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    fileOutputStream = closeable;
                    i.a("Downloading vector lib failed with error:" + e.getMessage());
                    k.a(closeable2);
                    k.a(fileOutputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    i2++;
                    httpURLConnection = httpURLConnection2;
                    closeable = fileOutputStream;
                } catch (IOException e8) {
                    e2 = e8;
                    fileOutputStream = closeable;
                    i.a("Downloading vector lib failed with error:" + e2.getMessage());
                    k.a(closeable2);
                    k.a(fileOutputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    i2++;
                    httpURLConnection = httpURLConnection2;
                    closeable = fileOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    k.a(closeable2);
                    k.a(closeable);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(101273);
                    throw th;
                }
            } catch (MalformedURLException e9) {
                e = e9;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = closeable;
                i.a("Downloading vector lib failed with error:" + e.getMessage());
                k.a(closeable2);
                k.a(fileOutputStream);
                if (httpURLConnection2 != null) {
                }
                i2++;
                httpURLConnection = httpURLConnection2;
                closeable = fileOutputStream;
            } catch (IOException e10) {
                e2 = e10;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = closeable;
                i.a("Downloading vector lib failed with error:" + e2.getMessage());
                k.a(closeable2);
                k.a(fileOutputStream);
                if (httpURLConnection2 != null) {
                }
                i2++;
                httpURLConnection = httpURLConnection2;
                closeable = fileOutputStream;
            } catch (Throwable th4) {
                th = th4;
                k.a(closeable2);
                k.a(closeable);
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(101273);
                throw th;
            }
        }
        if (file.length() == ((long) i)) {
        }
    }

    private String[] h() {
        AppMethodBeat.i(101274);
        String[] strArr;
        if (this.e.a() == null) {
            this.e.a(a);
            strArr = a;
            AppMethodBeat.o(101274);
            return strArr;
        }
        strArr = this.e.a();
        AppMethodBeat.o(101274);
        return strArr;
    }

    private String i() {
        AppMethodBeat.i(101275);
        String[] h = h();
        String str;
        if (h == null || h.length == 0) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(101275);
            return str;
        }
        str = h[h.length - 1];
        AppMethodBeat.o(101275);
        return str;
    }

    private boolean b(String str) {
        AppMethodBeat.i(101276);
        String[] h = h();
        if (str == null || h == null) {
            AppMethodBeat.o(101276);
            return false;
        }
        for (int length = h.length - 1; length > 0; length--) {
            if (str.equals(h[length])) {
                AppMethodBeat.o(101276);
                return true;
            }
        }
        AppMethodBeat.o(101276);
        return false;
    }
}
