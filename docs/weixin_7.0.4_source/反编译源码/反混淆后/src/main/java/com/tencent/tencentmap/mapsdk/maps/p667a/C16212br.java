package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.br */
public abstract class C16212br implements C44501ci {
    /* renamed from: a */
    protected C16211bp f3168a;
    /* renamed from: b */
    public String f3169b;
    /* renamed from: c */
    public String f3170c;
    /* renamed from: d */
    protected AtomicInteger f3171d = new AtomicInteger(0);
    /* renamed from: e */
    protected C36491cq f3172e;
    /* renamed from: f */
    private int f3173f;
    /* renamed from: g */
    private int f3174g = 5000;
    /* renamed from: h */
    private long f3175h;
    /* renamed from: i */
    private int f3176i = 0;

    public C16212br(C16211bp c16211bp) {
        this.f3168a = c16211bp;
        this.f3169b = c16211bp.f3149a;
        this.f3170c = c16211bp.f3149a;
        this.f3173f = c16211bp.f3154f;
        this.f3175h = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public abstract C5862cv mo29263a(int i);

    /* renamed from: a */
    public C5862cv mo29262a() {
        try {
            C5862cv a;
            this.f3174g = C24362a.m37665a("app_http_proxy_timeout", 0, (int) C1625i.sHCENCODEVIDEOTIMEOUT, 5000);
            if (this.f3173f <= 0) {
                this.f3173f = C24362a.m37665a("app_req_timeout", 1000, 1000000, 15000);
            }
            if (this.f3168a.f3159k > 0 && this.f3168a.f3159k < this.f3173f) {
                this.f3173f = this.f3168a.f3159k;
            }
            int i = this.f3173f;
            while (true) {
                a = mo29263a(i);
                int a2 = C24373eu.m37730a((int) (((long) this.f3173f) - (SystemClock.elapsedRealtime() - this.f3175h)), 0, this.f3173f);
                if (a.f1540a != 0 || a.f1542c < 300 || a.f1542c >= 400 || !this.f3168a.f3153e || a2 <= 200) {
                    break;
                }
                String a3 = a.mo12406a(C8741b.LOCATION);
                if (TextUtils.isEmpty(a3)) {
                    a.f1540a = -6;
                    break;
                }
                this.f3170c = a3;
                this.f3176i++;
                if (this.f3176i > 5) {
                    a.f1540a = -5;
                    break;
                }
                this.f3172e.mo12411a(true);
                i = a2;
            }
            if (this.f3168a.f3158j) {
                a.f1540a = -20;
                a.f1541b = "";
            }
            if (this.f3168a.f3161m) {
                this.f3172e.f15289j = true;
                this.f3172e.f15288i = true;
                this.f3172e.f15290k = (long) this.f3168a.f3159k;
            } else {
                this.f3172e.f15290k = SystemClock.elapsedRealtime() - this.f3175h;
            }
            this.f3172e.mo12411a(false);
            return a;
        } catch (Throwable th) {
            return new C5862cv(-1, C24373eu.m37736a(th), 0);
        }
    }
}
