package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public abstract class if {
    protected long a = 1500;
    protected long b = 0;
    protected a c = null;
    protected b d = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private Interpolator h = new LinearInterpolator();

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a(float f);

        void a(float f, float f2);

        void a(float f, float f2, float f3, float f4);

        void a(int i, int i2);

        void b(float f);
    }

    public abstract void a(float f, Interpolator interpolator);

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(Interpolator interpolator) {
        this.h = interpolator;
    }

    public Interpolator a() {
        return this.h;
    }

    private long g() {
        return SystemClock.uptimeMillis();
    }

    public void a(long j) {
        this.a = j;
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.a <= 0) {
            return false;
        }
        this.f = true;
        this.b = g();
        this.e = true;
        if (this.c == null) {
            return true;
        }
        this.c.b();
        return true;
    }

    public void b() {
        this.e = false;
    }

    public boolean c() {
        return this.e;
    }

    public void d() {
        if (this.e) {
            float g = ((float) (g() - this.b)) / ((float) this.a);
            if (g > 1.0f) {
                this.e = false;
                a(1.0f, this.h);
                if (this.c != null) {
                    this.c.a();
                }
                this.g = true;
                return;
            }
            a(g, this.h);
        } else if (!this.g && this.c != null) {
            this.c.a();
        }
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }
}
