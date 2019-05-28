package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cs */
public final class C16216cs extends C36491cq {
    /* renamed from: q */
    private static boolean f3189q = false;
    /* renamed from: A */
    private String f3190A;
    /* renamed from: B */
    private C41034bu f3191B;
    /* renamed from: C */
    private String f3192C;
    /* renamed from: D */
    private String f3193D;
    /* renamed from: p */
    public boolean f3194p = true;
    /* renamed from: r */
    private boolean f3195r = false;
    /* renamed from: s */
    private boolean f3196s = false;
    /* renamed from: t */
    private int f3197t;
    /* renamed from: u */
    private int f3198u = -1;
    /* renamed from: v */
    private C5863cw f3199v;
    /* renamed from: w */
    private C5862cv f3200w;
    /* renamed from: x */
    private C41039cr f3201x;
    /* renamed from: y */
    private C46775cp f3202y = C46775cp.m88748a();
    /* renamed from: z */
    private boolean f3203z;

    public C16216cs(String str, boolean z, Map<String, String> map, byte[] bArr, int i, String str2, boolean z2, int i2, boolean z3, C24361cd c24361cd, String str3) {
        AppMethodBeat.m2504i(98663);
        this.f15281b = str;
        this.f15282c = z;
        this.f15283d = map;
        this.f15284e = bArr;
        this.f15285f = i;
        this.f15286g = str2;
        this.f3195r = false;
        this.f3197t = 0;
        this.f3203z = z3;
        this.f3192C = str3;
        AppMethodBeat.m2505o(98663);
    }

    /* renamed from: a */
    public static C16216cs m24720a(String str, boolean z, Map<String, String> map, byte[] bArr, int i, String str2, boolean z2, C24361cd c24361cd) {
        AppMethodBeat.m2504i(98662);
        C16216cs c16216cs = new C16216cs(str, false, map, bArr, i, str2, false, 0, false, c24361cd, "");
        AppMethodBeat.m2505o(98662);
        return c16216cs;
    }

    /* renamed from: a */
    public final void mo29269a(int i) {
        this.f3198u = i;
    }

    /* renamed from: a */
    public final void mo29270a(String str) {
        this.f3190A = str;
    }

    /* renamed from: a */
    public final C5862cv mo12409a() {
        AppMethodBeat.m2504i(98664);
        if (!f3189q) {
            f3189q = true;
            try {
                if (VERSION.SDK != null && VERSION.SDK_INT < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
            } catch (Exception e) {
            }
        }
        this.f3200w = new C5862cv(0, "", 0);
        C5862cv c5862cv;
        try {
            URL url = new URL(this.f15281b);
            String host = url.getHost();
            this.f3201x = new C41039cr(url, this.f15281b);
            List a = this.f3201x.mo65129a(this.f3202y, this.f3203z, url.getProtocol().toLowerCase().startsWith("https"));
            int size = a.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = this.f15285f;
            int i2 = 0;
            while (i2 < size) {
                this.f15294o.incrementAndGet();
                this.f3191B = (C41034bu) a.get(i2);
                if (this.f3191B.mo65120b() < (byte) 3) {
                    this.f3196s = true;
                }
                this.f3193D = this.f3201x.mo65128a(this.f3191B);
                this.f3199v = new C5863cw(host, this.f3193D, this.f15282c, this.f15283d, this.f15284e, i, this.f15286g);
                if (i2 != 0 || this.f3195r) {
                    this.f3199v.f1555s = true;
                }
                if (C31029ce.m49854i() && i2 != 0) {
                    this.f3199v.f1553q = true;
                }
                this.f3199v.f1554r = this.f15294o.get();
                this.f3200w = this.f3199v.mo12409a();
                if ((this.f3199v.f15288i || this.f3200w.f1542c >= 500) && C31029ce.m49853h() && this.f3196s) {
                    C46775cp.m88749a(host, this.f3191B, this.f3200w.f1540a);
                }
                i = (int) (((long) this.f15285f) - (SystemClock.elapsedRealtime() - elapsedRealtime));
                Object obj = ((this.f3200w.f1540a == 0 && this.f3200w.f1542c >= 200 && this.f3200w.f1542c < 400) || this.f3200w.f1540a == -20 || this.f3200w.f1540a == -300 || this.f3200w.f1540a == -306 || i2 == size - 1 || i <= 200) ? 1 : null;
                if (obj == null && this.f3200w.f1540a == -4) {
                    int a2 = C24362a.m37665a("direct_nonet_retry_gap", 0, (int) Downloads.MIN_WAIT_FOR_NETWORK, (int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    long j = this.f3199v.f1552p;
                    if (j >= ((long) a2)) {
                        obj = 1;
                    } else {
                        SystemClock.sleep((long) C24373eu.m37731a((int) (((long) a2) - j), 200, a2, 200));
                    }
                }
                if (obj != null) {
                    break;
                }
                mo12411a(true);
                i2++;
            }
            c5862cv = this.f3200w;
            AppMethodBeat.m2505o(98664);
            return c5862cv;
        } catch (MalformedURLException e2) {
            this.f3200w.f1540a = -300;
            c5862cv = this.f3200w;
            AppMethodBeat.m2505o(98664);
            return c5862cv;
        }
    }

    /* renamed from: a */
    public final void mo12411a(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(98665);
        if (this.f3199v != null) {
            if (this.f15288i) {
                this.f3199v.f15288i = true;
            }
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("B46", "1");
            } else {
                hashMap.put("B22", this.f15290k);
            }
            if (!C24373eu.m37738a(this.f3190A)) {
                hashMap.put("B15", this.f3190A);
            }
            if (!C24373eu.m37738a(this.f3192C)) {
                hashMap.put("B54", this.f3192C);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("B82", this.f15286g);
            if (this.f3195r) {
                hashMap.put("B52", "1");
                hashMap.put("B58", this.f3197t);
            }
            if (this.f15291l != 0) {
                hashMap2.put("B83", this.f15291l);
            }
            hashMap2.put("B44", this.f15280a);
            if (!(TextUtils.isEmpty(this.f15280a) || this.f15280a.equals(this.f3193D))) {
                hashMap2.put("B49", this.f3193D);
            }
            if (this.f3191B != null) {
                if (!this.f3191B.mo65123e()) {
                    hashMap2.put("B10", this.f3191B.mo65122d());
                }
                if (this.f3191B.f16441a != -1) {
                    hashMap2.put("B45", this.f3191B.f16441a);
                }
                hashMap2.put("B202", this.f3191B.mo65120b());
                hashMap2.put("B204", this.f3191B.f16442b);
                String str = "B203";
                StringBuilder stringBuilder = new StringBuilder();
                if (!this.f3196s) {
                    i = 0;
                }
                hashMap2.put(str, stringBuilder.append(i).toString());
            }
            hashMap2.put("B53", this.f15294o.get());
            if (!TextUtils.isEmpty(this.f3201x.f16454a)) {
                hashMap2.put("B26", this.f3201x.f16454a);
            }
            if (this.f15289j) {
                hashMap2.put("B97", "1");
            }
            if (this.f3198u != -1) {
                hashMap2.put("B211", this.f3198u);
            }
            this.f3199v.mo12410a(hashMap, hashMap2);
        }
        AppMethodBeat.m2505o(98665);
    }
}
