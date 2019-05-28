package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;

public abstract class ev {
    protected long a;
    protected long b;
    protected a c;
    private boolean d;
    private boolean e;
    private Interpolator f;

    public interface a {
        void a();
    }

    public abstract void a(float f, Interpolator interpolator);

    private long c() {
        return SystemClock.uptimeMillis();
    }

    public void a() {
        if (this.d) {
            float c = ((float) (c() - this.b)) / ((float) this.a);
            if (c > 1.0f) {
                this.d = false;
                a(1.0f, this.f);
                if (this.c != null) {
                    this.c.a();
                }
                this.e = true;
                return;
            }
            a(c, this.f);
        } else if (!this.e && this.c != null) {
            this.c.a();
        }
    }

    public boolean b() {
        return this.e;
    }
}
