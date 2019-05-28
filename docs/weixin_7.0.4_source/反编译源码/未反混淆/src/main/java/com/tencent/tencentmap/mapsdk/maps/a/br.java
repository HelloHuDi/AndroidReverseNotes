package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.hardcoder.i;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class br implements ci {
    protected bp a;
    public String b;
    public String c;
    protected AtomicInteger d = new AtomicInteger(0);
    protected cq e;
    private int f;
    private int g = 5000;
    private long h;
    private int i = 0;

    public br(bp bpVar) {
        this.a = bpVar;
        this.b = bpVar.a;
        this.c = bpVar.a;
        this.f = bpVar.f;
        this.h = SystemClock.elapsedRealtime();
    }

    public abstract cv a(int i);

    public cv a() {
        try {
            cv a;
            this.g = a.a("app_http_proxy_timeout", 0, (int) i.sHCENCODEVIDEOTIMEOUT, 5000);
            if (this.f <= 0) {
                this.f = a.a("app_req_timeout", 1000, 1000000, 15000);
            }
            if (this.a.k > 0 && this.a.k < this.f) {
                this.f = this.a.k;
            }
            int i = this.f;
            while (true) {
                a = a(i);
                int a2 = eu.a((int) (((long) this.f) - (SystemClock.elapsedRealtime() - this.h)), 0, this.f);
                if (a.a != 0 || a.c < 300 || a.c >= 400 || !this.a.e || a2 <= 200) {
                    break;
                }
                String a3 = a.a(b.LOCATION);
                if (TextUtils.isEmpty(a3)) {
                    a.a = -6;
                    break;
                }
                this.c = a3;
                this.i++;
                if (this.i > 5) {
                    a.a = -5;
                    break;
                }
                this.e.a(true);
                i = a2;
            }
            if (this.a.j) {
                a.a = -20;
                a.b = "";
            }
            if (this.a.m) {
                this.e.j = true;
                this.e.i = true;
                this.e.k = (long) this.a.k;
            } else {
                this.e.k = SystemClock.elapsedRealtime() - this.h;
            }
            this.e.a(false);
            return a;
        } catch (Throwable th) {
            return new cv(-1, eu.a(th), 0);
        }
    }
}
