package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.tencentmap.mapsdk.a.az;
import com.tencent.tencentmap.mapsdk.a.cw;
import com.tencent.tencentmap.mapsdk.a.cx;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class hz extends az implements io {
    private static AtomicInteger a = new AtomicInteger(1);
    protected boolean I = false;
    protected cx J;
    private final String b = String.valueOf(a.incrementAndGet());

    public abstract void d();

    public void z() {
    }

    public boolean r() {
        return false;
    }

    public final String A() {
        return this.b;
    }

    public cx B() {
        return this.J;
    }

    public void a(cw cwVar) {
        if (this.J != null) {
            this.I = this.J.toString().equals(cwVar.toString());
        }
        c();
    }

    public void C() {
        if (this.J != null) {
            this.I = false;
        }
        c();
    }

    public boolean y() {
        return false;
    }
}
