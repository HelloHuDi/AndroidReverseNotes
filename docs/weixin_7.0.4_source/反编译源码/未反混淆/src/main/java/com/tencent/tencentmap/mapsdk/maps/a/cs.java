package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class cs extends cq {
    private static boolean q = false;
    private String A;
    private bu B;
    private String C;
    private String D;
    public boolean p = true;
    private boolean r = false;
    private boolean s = false;
    private int t;
    private int u = -1;
    private cw v;
    private cv w;
    private cr x;
    private cp y = cp.a();
    private boolean z;

    public cs(String str, boolean z, Map<String, String> map, byte[] bArr, int i, String str2, boolean z2, int i2, boolean z3, cd cdVar, String str3) {
        AppMethodBeat.i(98663);
        this.b = str;
        this.c = z;
        this.d = map;
        this.e = bArr;
        this.f = i;
        this.g = str2;
        this.r = false;
        this.t = 0;
        this.z = z3;
        this.C = str3;
        AppMethodBeat.o(98663);
    }

    public static cs a(String str, boolean z, Map<String, String> map, byte[] bArr, int i, String str2, boolean z2, cd cdVar) {
        AppMethodBeat.i(98662);
        cs csVar = new cs(str, false, map, bArr, i, str2, false, 0, false, cdVar, "");
        AppMethodBeat.o(98662);
        return csVar;
    }

    public final void a(int i) {
        this.u = i;
    }

    public final void a(String str) {
        this.A = str;
    }

    public final cv a() {
        AppMethodBeat.i(98664);
        if (!q) {
            q = true;
            try {
                if (VERSION.SDK != null && VERSION.SDK_INT < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
            } catch (Exception e) {
            }
        }
        this.w = new cv(0, "", 0);
        cv cvVar;
        try {
            URL url = new URL(this.b);
            String host = url.getHost();
            this.x = new cr(url, this.b);
            List a = this.x.a(this.y, this.z, url.getProtocol().toLowerCase().startsWith("https"));
            int size = a.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = this.f;
            int i2 = 0;
            while (i2 < size) {
                this.o.incrementAndGet();
                this.B = (bu) a.get(i2);
                if (this.B.b() < (byte) 3) {
                    this.s = true;
                }
                this.D = this.x.a(this.B);
                this.v = new cw(host, this.D, this.c, this.d, this.e, i, this.g);
                if (i2 != 0 || this.r) {
                    this.v.s = true;
                }
                if (ce.i() && i2 != 0) {
                    this.v.q = true;
                }
                this.v.r = this.o.get();
                this.w = this.v.a();
                if ((this.v.i || this.w.c >= 500) && ce.h() && this.s) {
                    cp.a(host, this.B, this.w.a);
                }
                i = (int) (((long) this.f) - (SystemClock.elapsedRealtime() - elapsedRealtime));
                Object obj = ((this.w.a == 0 && this.w.c >= 200 && this.w.c < 400) || this.w.a == -20 || this.w.a == -300 || this.w.a == -306 || i2 == size - 1 || i <= 200) ? 1 : null;
                if (obj == null && this.w.a == -4) {
                    int a2 = a.a("direct_nonet_retry_gap", 0, (int) Downloads.MIN_WAIT_FOR_NETWORK, (int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    long j = this.v.p;
                    if (j >= ((long) a2)) {
                        obj = 1;
                    } else {
                        SystemClock.sleep((long) eu.a((int) (((long) a2) - j), 200, a2, 200));
                    }
                }
                if (obj != null) {
                    break;
                }
                a(true);
                i2++;
            }
            cvVar = this.w;
            AppMethodBeat.o(98664);
            return cvVar;
        } catch (MalformedURLException e2) {
            this.w.a = -300;
            cvVar = this.w;
            AppMethodBeat.o(98664);
            return cvVar;
        }
    }

    public final void a(boolean z) {
        int i = 1;
        AppMethodBeat.i(98665);
        if (this.v != null) {
            if (this.i) {
                this.v.i = true;
            }
            HashMap hashMap = new HashMap();
            if (z) {
                hashMap.put("B46", "1");
            } else {
                hashMap.put("B22", this.k);
            }
            if (!eu.a(this.A)) {
                hashMap.put("B15", this.A);
            }
            if (!eu.a(this.C)) {
                hashMap.put("B54", this.C);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("B82", this.g);
            if (this.r) {
                hashMap.put("B52", "1");
                hashMap.put("B58", this.t);
            }
            if (this.l != 0) {
                hashMap2.put("B83", this.l);
            }
            hashMap2.put("B44", this.a);
            if (!(TextUtils.isEmpty(this.a) || this.a.equals(this.D))) {
                hashMap2.put("B49", this.D);
            }
            if (this.B != null) {
                if (!this.B.e()) {
                    hashMap2.put("B10", this.B.d());
                }
                if (this.B.a != -1) {
                    hashMap2.put("B45", this.B.a);
                }
                hashMap2.put("B202", this.B.b());
                hashMap2.put("B204", this.B.b);
                String str = "B203";
                StringBuilder stringBuilder = new StringBuilder();
                if (!this.s) {
                    i = 0;
                }
                hashMap2.put(str, stringBuilder.append(i).toString());
            }
            hashMap2.put("B53", this.o.get());
            if (!TextUtils.isEmpty(this.x.a)) {
                hashMap2.put("B26", this.x.a);
            }
            if (this.j) {
                hashMap2.put("B97", "1");
            }
            if (this.u != -1) {
                hashMap2.put("B211", this.u);
            }
            this.v.a(hashMap, hashMap2);
        }
        AppMethodBeat.o(98665);
    }
}
