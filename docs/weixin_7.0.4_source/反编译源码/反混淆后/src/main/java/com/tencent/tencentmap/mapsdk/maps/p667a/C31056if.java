package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.if */
public abstract class C31056if {
    /* renamed from: a */
    protected long f14160a = 1500;
    /* renamed from: b */
    protected long f14161b = 0;
    /* renamed from: c */
    protected C31057a f14162c = null;
    /* renamed from: d */
    protected C31058b f14163d = null;
    /* renamed from: e */
    private boolean f14164e = false;
    /* renamed from: f */
    private boolean f14165f = false;
    /* renamed from: g */
    private boolean f14166g = false;
    /* renamed from: h */
    private Interpolator f14167h = new LinearInterpolator();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.if$a */
    public interface C31057a {
        /* renamed from: a */
        void mo29459a();

        /* renamed from: b */
        void mo29460b();
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.if$b */
    public interface C31058b {
        /* renamed from: a */
        void mo29453a(float f);

        /* renamed from: a */
        void mo29454a(float f, float f2);

        /* renamed from: a */
        void mo29455a(float f, float f2, float f3, float f4);

        /* renamed from: a */
        void mo29456a(int i, int i2);

        /* renamed from: b */
        void mo29457b(float f);
    }

    /* renamed from: a */
    public abstract void mo29509a(float f, Interpolator interpolator);

    /* renamed from: a */
    public void mo50390a(C31057a c31057a) {
        this.f14162c = c31057a;
    }

    /* renamed from: a */
    public void mo29510a(C31058b c31058b) {
        this.f14163d = c31058b;
    }

    /* renamed from: a */
    public void mo50389a(Interpolator interpolator) {
        this.f14167h = interpolator;
    }

    /* renamed from: a */
    public Interpolator mo50387a() {
        return this.f14167h;
    }

    /* renamed from: g */
    private long mo29513g() {
        return SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public void mo50388a(long j) {
        this.f14160a = j;
    }

    /* renamed from: a */
    public boolean mo29512a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.f14160a <= 0) {
            return false;
        }
        this.f14165f = true;
        this.f14161b = mo29513g();
        this.f14164e = true;
        if (this.f14162c == null) {
            return true;
        }
        this.f14162c.mo29460b();
        return true;
    }

    /* renamed from: b */
    public void mo50391b() {
        this.f14164e = false;
    }

    /* renamed from: c */
    public boolean mo50392c() {
        return this.f14164e;
    }

    /* renamed from: d */
    public void mo50393d() {
        if (this.f14164e) {
            float g = ((float) (mo29513g() - this.f14161b)) / ((float) this.f14160a);
            if (g > 1.0f) {
                this.f14164e = false;
                mo29509a(1.0f, this.f14167h);
                if (this.f14162c != null) {
                    this.f14162c.mo29459a();
                }
                this.f14166g = true;
                return;
            }
            mo29509a(g, this.f14167h);
        } else if (!this.f14166g && this.f14162c != null) {
            this.f14162c.mo29459a();
        }
    }

    /* renamed from: e */
    public boolean mo50394e() {
        return this.f14165f;
    }

    /* renamed from: f */
    public boolean mo50395f() {
        return this.f14166g;
    }
}
