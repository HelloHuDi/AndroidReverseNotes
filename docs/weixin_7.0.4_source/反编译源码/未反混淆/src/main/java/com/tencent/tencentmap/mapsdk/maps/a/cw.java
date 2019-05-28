package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public final class cw extends cq {
    private String A = "";
    private int B;
    private long C = 0;
    private String D;
    private a E = new a();
    private boolean F = false;
    private cu G;
    long p;
    boolean q = false;
    int r = 0;
    boolean s = false;
    private HttpURLConnection t;
    private DataOutputStream u;
    private DataInputStream v;
    private cv w;
    private String x;
    private boolean y;
    private boolean z;

    static class a {
        long a;
        long b;
        long c;
        long d;
        long e;
        long f;
        long g;
        long h;
        long i;
        long j;
        long k;

        private a() {
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(98674);
            String str = "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
            AppMethodBeat.o(98674);
            return str;
        }

        public final void a() {
            long j = -1;
            this.g = this.b - this.a;
            this.h = this.c - this.b;
            this.i = this.d - this.c;
            this.j = this.e - this.d;
            this.k = this.f - this.e;
            long j2 = this.g;
            if (j2 < 0) {
                j2 = -1;
            }
            this.g = j2;
            j2 = this.h;
            if (j2 < 0) {
                j2 = -1;
            }
            this.h = j2;
            j2 = this.i;
            if (j2 < 0) {
                j2 = -1;
            }
            this.i = j2;
            j2 = this.j;
            if (j2 < 0) {
                j2 = -1;
            }
            this.j = j2;
            j2 = this.k;
            if (j2 >= 0) {
                j = j2;
            }
            this.k = j;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i) {
        int i2;
        Object obj = null;
        AppMethodBeat.i(98679);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.t.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            i2 = 0;
            do {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        int obj2 = 1;
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                        i2 += read;
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(98679);
                    return;
                } catch (OutOfMemoryError e2) {
                }
            } while (i2 <= i);
            this.w.a = -303;
            this.w.b = "no-content-length";
            if (obj2 != null) {
                this.w.d = byteArrayOutputStream.toByteArray();
                this.E.f = SystemClock.elapsedRealtime();
            }
            byteArrayOutputStream.close();
            AppMethodBeat.o(98679);
            return;
        } catch (OutOfMemoryError e3) {
            i2 = 0;
        } catch (Exception e4) {
            this.w.a = -287;
            this.w.b = "read without content-length error";
            AppMethodBeat.o(98679);
            return;
        }
        this.w.a = -306;
        this.w.b = "no-content-length:".concat(String.valueOf(i2));
        AppMethodBeat.o(98679);
    }

    private void b() {
        AppMethodBeat.i(98677);
        Object obj = null;
        if (this.d != null && this.d.size() > 0) {
            Object obj2;
            Iterator it = this.d.keySet().iterator();
            while (true) {
                obj2 = obj;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                this.t.addRequestProperty(str, (String) this.d.get(str));
                obj = str.toLowerCase().contains("host") ? 1 : obj2;
            }
            obj = obj2;
        }
        if (obj == null) {
            this.t.setRequestProperty("Host", this.x);
        }
        this.t.setRequestProperty("Halley", this.g + "-" + this.r + "-" + System.currentTimeMillis());
        if (this.q) {
            this.t.setRequestProperty("X-Online-Host", this.x);
            this.t.setRequestProperty("x-tx-host", this.x);
        }
        AppMethodBeat.o(98677);
    }

    private boolean c() {
        AppMethodBeat.i(98678);
        if (this.n) {
            this.w.a = -20;
            this.p = SystemClock.elapsedRealtime() - this.p;
            this.E.a();
            AppMethodBeat.o(98678);
            return true;
        }
        AppMethodBeat.o(98678);
        return false;
    }

    private void d() {
        AppMethodBeat.i(98680);
        try {
            if (this.t != null) {
                this.t.disconnect();
            }
            if (this.u != null) {
                this.u.close();
            }
            if (this.v != null) {
                this.v.close();
            }
            AppMethodBeat.o(98680);
        } catch (Throwable th) {
            AppMethodBeat.o(98680);
        }
    }

    public final void a(Map<String, String> map, Map<String, String> map2) {
        AppMethodBeat.i(98681);
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("B59", this.p);
        if (this.y) {
            hashMap.put("B85", "1");
        }
        if (this.c) {
            hashMap.put("B95", "1");
        } else {
            hashMap.put("B96", this.C);
        }
        if (!this.z) {
            hashMap.put("B23", "1");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(map2);
        if (this.m != 0) {
            hashMap2.put("B84", this.m);
        }
        hashMap2.put("B87", this.A);
        hashMap2.put("B88", this.B);
        hashMap2.put("B90", this.E.g);
        hashMap2.put("B91", this.E.h);
        hashMap2.put("B92", this.E.i);
        hashMap2.put("B93", this.E.j);
        hashMap2.put("B94", this.E.k);
        if (!TextUtils.isEmpty(this.h)) {
            hashMap2.put("B47", this.h);
        }
        if (!TextUtils.isEmpty(this.D)) {
            hashMap2.put("B41", this.D);
        }
        int i = this.w.a != 0 ? this.w.a : this.w.c == 200 ? 0 : this.w.c;
        if (!this.s || i == -4) {
            es.b("HLHttpDirect", bt.c(), i, this.w.b, hashMap, hashMap2, this.i);
            AppMethodBeat.o(98681);
            return;
        }
        es.a("HLHttpDirect", bt.c(), i, this.w.b, hashMap, hashMap2, this.i);
        AppMethodBeat.o(98681);
    }

    public final void a(boolean z) {
    }

    public cw(String str, String str2, boolean z, Map<String, String> map, byte[] bArr, int i, String str3) {
        AppMethodBeat.i(98675);
        this.x = str;
        this.b = str2;
        this.c = z;
        this.d = map;
        this.e = bArr;
        int a = ce.g() == 2 ? com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_access_time_out", 1000, 60000, 15000) : com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_access_time_out", 1000, 60000, (int) Downloads.MIN_WAIT_FOR_NETWORK);
        if (i >= a) {
            i = a;
        }
        this.f = eu.a(i, 200, 60000, Downloads.MIN_WAIT_FOR_NETWORK);
        this.g = str3;
        AppMethodBeat.o(98675);
    }

    public final cv a() {
        int i = 1;
        AppMethodBeat.i(98676);
        this.m = System.currentTimeMillis();
        this.p = SystemClock.elapsedRealtime();
        this.E.a = this.p;
        this.w = new cv(0, "", 0);
        try {
            cv cvVar;
            if (c()) {
                cvVar = this.w;
                d();
                this.p = SystemClock.elapsedRealtime() - this.p;
                this.E.a();
                if (!(this.w.a == 0 || !ce.h() || this.w.a == -20)) {
                    if (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.D = eu.c(this.x);
                    }
                }
                AppMethodBeat.o(98676);
                return cvVar;
            }
            HttpURLConnection httpURLConnection;
            URL url = new URL(this.b);
            this.y = url.getProtocol().toLowerCase().startsWith("https");
            this.z = eu.d(url.getHost());
            if (this.y) {
                if (!this.q || ce.k() == null) {
                    HttpsURLConnection httpURLConnection2 = (HttpsURLConnection) url.openConnection();
                } else {
                    httpURLConnection2 = (HttpsURLConnection) url.openConnection(ce.k());
                }
                if (this.z) {
                    this.G = new cu(this.x);
                    httpURLConnection2.setSSLSocketFactory(this.G);
                    httpURLConnection2.setHostnameVerifier(new ct(this.x));
                }
            } else {
                httpURLConnection2 = (!this.q || ce.k() == null) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(ce.k());
            }
            this.t = httpURLConnection2;
            this.t.setRequestMethod(this.c ? "GET" : "POST");
            this.t.setConnectTimeout(this.f);
            this.t.setReadTimeout(this.f);
            this.t.setUseCaches(false);
            this.t.setDoInput(true);
            this.t.setInstanceFollowRedirects(false);
            b();
            if (!(this.c || eu.a(this.e))) {
                this.t.setDoOutput(true);
                this.C = (long) this.e.length;
            }
            this.E.b = SystemClock.elapsedRealtime();
            this.t.connect();
            this.E.c = SystemClock.elapsedRealtime();
            if (c()) {
                cvVar = this.w;
                d();
                this.p = SystemClock.elapsedRealtime() - this.p;
                this.E.a();
                if (!(this.w.a == 0 || !ce.h() || this.w.a == -20)) {
                    if (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.D = eu.c(this.x);
                    }
                }
                AppMethodBeat.o(98676);
                return cvVar;
            }
            if (!(this.c || eu.a(this.e))) {
                this.u = new DataOutputStream(this.t.getOutputStream());
                this.u.write(this.e);
                this.u.flush();
            }
            this.E.d = SystemClock.elapsedRealtime();
            int responseCode = this.t.getResponseCode();
            this.E.e = SystemClock.elapsedRealtime();
            this.w.c = responseCode;
            this.A = this.t.getContentType();
            Map hashMap = new HashMap();
            for (Entry entry : this.t.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    hashMap.put(entry.getKey(), ((List) entry.getValue()).get(0));
                }
            }
            this.w.a(hashMap);
            if (this.w.c >= 200 && this.w.c < 300) {
                this.B = this.t.getContentLength();
                responseCode = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("app_receive_pack_size", (int) SQLiteGlobal.journalSizeLimit, 10485760, 2097152);
                if (this.B < 0) {
                    a(responseCode);
                } else if (this.B == 0) {
                    this.w.d = new byte[0];
                    this.E.f = SystemClock.elapsedRealtime();
                } else if (this.B > responseCode) {
                    this.w.a = -303;
                    this.w.b = this.B;
                } else {
                    try {
                        byte[] bArr = new byte[this.B];
                        this.v = new DataInputStream(this.t.getInputStream());
                        this.v.readFully(bArr);
                        this.w.d = bArr;
                        this.E.f = SystemClock.elapsedRealtime();
                    } catch (OutOfMemoryError e) {
                        this.w.a = -306;
                        this.w.b = this.B;
                    }
                }
            } else if (this.w.c >= 300 && this.w.c < 400) {
                this.h = this.w.a(b.LOCATION);
            }
            d();
            this.p = SystemClock.elapsedRealtime() - this.p;
            this.E.a();
            if (!(this.w.a == 0 || !ce.h() || this.w.a == -20)) {
                if (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                    i = 0;
                }
                if (i != 0) {
                    this.D = eu.c(this.x);
                }
            }
            cvVar = this.w;
            AppMethodBeat.o(98676);
            return cvVar;
        } catch (MalformedURLException e2) {
            this.w.a = -300;
            d();
            this.p = SystemClock.elapsedRealtime() - this.p;
            this.E.a();
            if (!(this.w.a == 0 || !ce.h() || this.w.a == -20)) {
                if (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                    i = 0;
                }
                if (i != 0) {
                    this.D = eu.c(this.x);
                }
            }
        } catch (Throwable th) {
            d();
            this.p = SystemClock.elapsedRealtime() - this.p;
            this.E.a();
            if (!(this.w.a == 0 || !ce.h() || this.w.a == -20)) {
                if (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                    i = 0;
                }
                if (i != 0) {
                    this.D = eu.c(this.x);
                }
            }
            AppMethodBeat.o(98676);
        }
    }
}
