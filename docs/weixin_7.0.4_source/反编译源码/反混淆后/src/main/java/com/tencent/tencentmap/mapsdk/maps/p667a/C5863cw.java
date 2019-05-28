package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cw */
public final class C5863cw extends C36491cq {
    /* renamed from: A */
    private String f1545A = "";
    /* renamed from: B */
    private int f1546B;
    /* renamed from: C */
    private long f1547C = 0;
    /* renamed from: D */
    private String f1548D;
    /* renamed from: E */
    private C5864a f1549E = new C5864a();
    /* renamed from: F */
    private boolean f1550F = false;
    /* renamed from: G */
    private C5861cu f1551G;
    /* renamed from: p */
    long f1552p;
    /* renamed from: q */
    boolean f1553q = false;
    /* renamed from: r */
    int f1554r = 0;
    /* renamed from: s */
    boolean f1555s = false;
    /* renamed from: t */
    private HttpURLConnection f1556t;
    /* renamed from: u */
    private DataOutputStream f1557u;
    /* renamed from: v */
    private DataInputStream f1558v;
    /* renamed from: w */
    private C5862cv f1559w;
    /* renamed from: x */
    private String f1560x;
    /* renamed from: y */
    private boolean f1561y;
    /* renamed from: z */
    private boolean f1562z;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cw$a */
    static class C5864a {
        /* renamed from: a */
        long f1563a;
        /* renamed from: b */
        long f1564b;
        /* renamed from: c */
        long f1565c;
        /* renamed from: d */
        long f1566d;
        /* renamed from: e */
        long f1567e;
        /* renamed from: f */
        long f1568f;
        /* renamed from: g */
        long f1569g;
        /* renamed from: h */
        long f1570h;
        /* renamed from: i */
        long f1571i;
        /* renamed from: j */
        long f1572j;
        /* renamed from: k */
        long f1573k;

        private C5864a() {
            this.f1569g = -1;
            this.f1570h = -1;
            this.f1571i = -1;
            this.f1572j = -1;
            this.f1573k = -1;
        }

        /* synthetic */ C5864a(byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(98674);
            String str = "Stat{startToTryConnect=" + this.f1569g + ", connectCost=" + this.f1570h + ", connectToPost=" + this.f1571i + ", postToRsp=" + this.f1572j + ", rspToRead=" + this.f1573k + '}';
            AppMethodBeat.m2505o(98674);
            return str;
        }

        /* renamed from: a */
        public final void mo12412a() {
            long j = -1;
            this.f1569g = this.f1564b - this.f1563a;
            this.f1570h = this.f1565c - this.f1564b;
            this.f1571i = this.f1566d - this.f1565c;
            this.f1572j = this.f1567e - this.f1566d;
            this.f1573k = this.f1568f - this.f1567e;
            long j2 = this.f1569g;
            if (j2 < 0) {
                j2 = -1;
            }
            this.f1569g = j2;
            j2 = this.f1570h;
            if (j2 < 0) {
                j2 = -1;
            }
            this.f1570h = j2;
            j2 = this.f1571i;
            if (j2 < 0) {
                j2 = -1;
            }
            this.f1571i = j2;
            j2 = this.f1572j;
            if (j2 < 0) {
                j2 = -1;
            }
            this.f1572j = j2;
            j2 = this.f1573k;
            if (j2 >= 0) {
                j = j2;
            }
            this.f1573k = j;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m9023a(int i) {
        int i2;
        Object obj = null;
        AppMethodBeat.m2504i(98679);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f1556t.getInputStream());
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
                    AppMethodBeat.m2505o(98679);
                    return;
                } catch (OutOfMemoryError e2) {
                }
            } while (i2 <= i);
            this.f1559w.f1540a = -303;
            this.f1559w.f1541b = "no-content-length";
            if (obj2 != null) {
                this.f1559w.f1543d = byteArrayOutputStream.toByteArray();
                this.f1549E.f1568f = SystemClock.elapsedRealtime();
            }
            byteArrayOutputStream.close();
            AppMethodBeat.m2505o(98679);
            return;
        } catch (OutOfMemoryError e3) {
            i2 = 0;
        } catch (Exception e4) {
            this.f1559w.f1540a = -287;
            this.f1559w.f1541b = "read without content-length error";
            AppMethodBeat.m2505o(98679);
            return;
        }
        this.f1559w.f1540a = -306;
        this.f1559w.f1541b = "no-content-length:".concat(String.valueOf(i2));
        AppMethodBeat.m2505o(98679);
    }

    /* renamed from: b */
    private void m9024b() {
        AppMethodBeat.m2504i(98677);
        Object obj = null;
        if (this.f15283d != null && this.f15283d.size() > 0) {
            Object obj2;
            Iterator it = this.f15283d.keySet().iterator();
            while (true) {
                obj2 = obj;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                this.f1556t.addRequestProperty(str, (String) this.f15283d.get(str));
                obj = str.toLowerCase().contains("host") ? 1 : obj2;
            }
            obj = obj2;
        }
        if (obj == null) {
            this.f1556t.setRequestProperty("Host", this.f1560x);
        }
        this.f1556t.setRequestProperty("Halley", this.f15286g + "-" + this.f1554r + "-" + System.currentTimeMillis());
        if (this.f1553q) {
            this.f1556t.setRequestProperty("X-Online-Host", this.f1560x);
            this.f1556t.setRequestProperty("x-tx-host", this.f1560x);
        }
        AppMethodBeat.m2505o(98677);
    }

    /* renamed from: c */
    private boolean m9025c() {
        AppMethodBeat.m2504i(98678);
        if (this.f15293n) {
            this.f1559w.f1540a = -20;
            this.f1552p = SystemClock.elapsedRealtime() - this.f1552p;
            this.f1549E.mo12412a();
            AppMethodBeat.m2505o(98678);
            return true;
        }
        AppMethodBeat.m2505o(98678);
        return false;
    }

    /* renamed from: d */
    private void m9026d() {
        AppMethodBeat.m2504i(98680);
        try {
            if (this.f1556t != null) {
                this.f1556t.disconnect();
            }
            if (this.f1557u != null) {
                this.f1557u.close();
            }
            if (this.f1558v != null) {
                this.f1558v.close();
            }
            AppMethodBeat.m2505o(98680);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(98680);
        }
    }

    /* renamed from: a */
    public final void mo12410a(Map<String, String> map, Map<String, String> map2) {
        AppMethodBeat.m2504i(98681);
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("B59", this.f1552p);
        if (this.f1561y) {
            hashMap.put("B85", "1");
        }
        if (this.f15282c) {
            hashMap.put("B95", "1");
        } else {
            hashMap.put("B96", this.f1547C);
        }
        if (!this.f1562z) {
            hashMap.put("B23", "1");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(map2);
        if (this.f15292m != 0) {
            hashMap2.put("B84", this.f15292m);
        }
        hashMap2.put("B87", this.f1545A);
        hashMap2.put("B88", this.f1546B);
        hashMap2.put("B90", this.f1549E.f1569g);
        hashMap2.put("B91", this.f1549E.f1570h);
        hashMap2.put("B92", this.f1549E.f1571i);
        hashMap2.put("B93", this.f1549E.f1572j);
        hashMap2.put("B94", this.f1549E.f1573k);
        if (!TextUtils.isEmpty(this.f15287h)) {
            hashMap2.put("B47", this.f15287h);
        }
        if (!TextUtils.isEmpty(this.f1548D)) {
            hashMap2.put("B41", this.f1548D);
        }
        int i = this.f1559w.f1540a != 0 ? this.f1559w.f1540a : this.f1559w.f1542c == 200 ? 0 : this.f1559w.f1542c;
        if (!this.f1555s || i == -4) {
            C24371es.m37719b("HLHttpDirect", C46772bt.m88739c(), i, this.f1559w.f1541b, hashMap, hashMap2, this.f15288i);
            AppMethodBeat.m2505o(98681);
            return;
        }
        C24371es.m37717a("HLHttpDirect", C46772bt.m88739c(), i, this.f1559w.f1541b, hashMap, hashMap2, this.f15288i);
        AppMethodBeat.m2505o(98681);
    }

    /* renamed from: a */
    public final void mo12411a(boolean z) {
    }

    public C5863cw(String str, String str2, boolean z, Map<String, String> map, byte[] bArr, int i, String str3) {
        AppMethodBeat.m2504i(98675);
        this.f1560x = str;
        this.f15281b = str2;
        this.f15282c = z;
        this.f15283d = map;
        this.f15284e = bArr;
        int a = C31029ce.m49852g() == 2 ? C24362a.m37665a("direct_access_time_out", 1000, 60000, 15000) : C24362a.m37665a("direct_access_time_out", 1000, 60000, (int) Downloads.MIN_WAIT_FOR_NETWORK);
        if (i >= a) {
            i = a;
        }
        this.f15285f = C24373eu.m37731a(i, 200, 60000, Downloads.MIN_WAIT_FOR_NETWORK);
        this.f15286g = str3;
        AppMethodBeat.m2505o(98675);
    }

    /* renamed from: a */
    public final C5862cv mo12409a() {
        int i = 1;
        AppMethodBeat.m2504i(98676);
        this.f15292m = System.currentTimeMillis();
        this.f1552p = SystemClock.elapsedRealtime();
        this.f1549E.f1563a = this.f1552p;
        this.f1559w = new C5862cv(0, "", 0);
        try {
            C5862cv c5862cv;
            if (m9025c()) {
                c5862cv = this.f1559w;
                m9026d();
                this.f1552p = SystemClock.elapsedRealtime() - this.f1552p;
                this.f1549E.mo12412a();
                if (!(this.f1559w.f1540a == 0 || !C31029ce.m49853h() || this.f1559w.f1540a == -20)) {
                    if (C24362a.m37665a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.f1548D = C24373eu.m37744c(this.f1560x);
                    }
                }
                AppMethodBeat.m2505o(98676);
                return c5862cv;
            }
            HttpURLConnection httpURLConnection;
            URL url = new URL(this.f15281b);
            this.f1561y = url.getProtocol().toLowerCase().startsWith("https");
            this.f1562z = C24373eu.m37746d(url.getHost());
            if (this.f1561y) {
                if (!this.f1553q || C31029ce.m49856k() == null) {
                    HttpsURLConnection httpURLConnection2 = (HttpsURLConnection) url.openConnection();
                } else {
                    httpURLConnection2 = (HttpsURLConnection) url.openConnection(C31029ce.m49856k());
                }
                if (this.f1562z) {
                    this.f1551G = new C5861cu(this.f1560x);
                    httpURLConnection2.setSSLSocketFactory(this.f1551G);
                    httpURLConnection2.setHostnameVerifier(new C5860ct(this.f1560x));
                }
            } else {
                httpURLConnection2 = (!this.f1553q || C31029ce.m49856k() == null) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(C31029ce.m49856k());
            }
            this.f1556t = httpURLConnection2;
            this.f1556t.setRequestMethod(this.f15282c ? "GET" : "POST");
            this.f1556t.setConnectTimeout(this.f15285f);
            this.f1556t.setReadTimeout(this.f15285f);
            this.f1556t.setUseCaches(false);
            this.f1556t.setDoInput(true);
            this.f1556t.setInstanceFollowRedirects(false);
            m9024b();
            if (!(this.f15282c || C24373eu.m37739a(this.f15284e))) {
                this.f1556t.setDoOutput(true);
                this.f1547C = (long) this.f15284e.length;
            }
            this.f1549E.f1564b = SystemClock.elapsedRealtime();
            this.f1556t.connect();
            this.f1549E.f1565c = SystemClock.elapsedRealtime();
            if (m9025c()) {
                c5862cv = this.f1559w;
                m9026d();
                this.f1552p = SystemClock.elapsedRealtime() - this.f1552p;
                this.f1549E.mo12412a();
                if (!(this.f1559w.f1540a == 0 || !C31029ce.m49853h() || this.f1559w.f1540a == -20)) {
                    if (C24362a.m37665a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.f1548D = C24373eu.m37744c(this.f1560x);
                    }
                }
                AppMethodBeat.m2505o(98676);
                return c5862cv;
            }
            if (!(this.f15282c || C24373eu.m37739a(this.f15284e))) {
                this.f1557u = new DataOutputStream(this.f1556t.getOutputStream());
                this.f1557u.write(this.f15284e);
                this.f1557u.flush();
            }
            this.f1549E.f1566d = SystemClock.elapsedRealtime();
            int responseCode = this.f1556t.getResponseCode();
            this.f1549E.f1567e = SystemClock.elapsedRealtime();
            this.f1559w.f1542c = responseCode;
            this.f1545A = this.f1556t.getContentType();
            Map hashMap = new HashMap();
            for (Entry entry : this.f1556t.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    hashMap.put(entry.getKey(), ((List) entry.getValue()).get(0));
                }
            }
            this.f1559w.mo12407a(hashMap);
            if (this.f1559w.f1542c >= 200 && this.f1559w.f1542c < 300) {
                this.f1546B = this.f1556t.getContentLength();
                responseCode = C24362a.m37665a("app_receive_pack_size", (int) SQLiteGlobal.journalSizeLimit, 10485760, 2097152);
                if (this.f1546B < 0) {
                    m9023a(responseCode);
                } else if (this.f1546B == 0) {
                    this.f1559w.f1543d = new byte[0];
                    this.f1549E.f1568f = SystemClock.elapsedRealtime();
                } else if (this.f1546B > responseCode) {
                    this.f1559w.f1540a = -303;
                    this.f1559w.f1541b = this.f1546B;
                } else {
                    try {
                        byte[] bArr = new byte[this.f1546B];
                        this.f1558v = new DataInputStream(this.f1556t.getInputStream());
                        this.f1558v.readFully(bArr);
                        this.f1559w.f1543d = bArr;
                        this.f1549E.f1568f = SystemClock.elapsedRealtime();
                    } catch (OutOfMemoryError e) {
                        this.f1559w.f1540a = -306;
                        this.f1559w.f1541b = this.f1546B;
                    }
                }
            } else if (this.f1559w.f1542c >= 300 && this.f1559w.f1542c < 400) {
                this.f15287h = this.f1559w.mo12406a(C8741b.LOCATION);
            }
            m9026d();
            this.f1552p = SystemClock.elapsedRealtime() - this.f1552p;
            this.f1549E.mo12412a();
            if (!(this.f1559w.f1540a == 0 || !C31029ce.m49853h() || this.f1559w.f1540a == -20)) {
                if (C24362a.m37665a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                    i = 0;
                }
                if (i != 0) {
                    this.f1548D = C24373eu.m37744c(this.f1560x);
                }
            }
            c5862cv = this.f1559w;
            AppMethodBeat.m2505o(98676);
            return c5862cv;
        } catch (MalformedURLException e2) {
            this.f1559w.f1540a = -300;
            m9026d();
            this.f1552p = SystemClock.elapsedRealtime() - this.f1552p;
            this.f1549E.mo12412a();
            if (!(this.f1559w.f1540a == 0 || !C31029ce.m49853h() || this.f1559w.f1540a == -20)) {
                if (C24362a.m37665a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                    i = 0;
                }
                if (i != 0) {
                    this.f1548D = C24373eu.m37744c(this.f1560x);
                }
            }
        } catch (Throwable th) {
            m9026d();
            this.f1552p = SystemClock.elapsedRealtime() - this.f1552p;
            this.f1549E.mo12412a();
            if (!(this.f1559w.f1540a == 0 || !C31029ce.m49853h() || this.f1559w.f1540a == -20)) {
                if (C24362a.m37665a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                    i = 0;
                }
                if (i != 0) {
                    this.f1548D = C24373eu.m37744c(this.f1560x);
                }
            }
            AppMethodBeat.m2505o(98676);
        }
    }
}
