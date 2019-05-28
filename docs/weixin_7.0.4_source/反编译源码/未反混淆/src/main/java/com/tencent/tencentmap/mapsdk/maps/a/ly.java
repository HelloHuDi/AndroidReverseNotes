package com.tencent.tencentmap.mapsdk.maps.a;

public abstract class ly<T> implements lw<T>, lz {
    private final mg a;
    private final ly<?> b;
    private lx c;
    private long d;

    protected ly() {
        this(null, false);
    }

    protected ly(ly<?> lyVar) {
        this(lyVar, true);
    }

    protected ly(ly<?> lyVar, boolean z) {
        this.d = Long.MIN_VALUE;
        this.b = lyVar;
        mg mgVar = (!z || lyVar == null) ? new mg() : lyVar.a;
        this.a = mgVar;
    }

    public final void b() {
        this.a.b();
    }

    public final boolean c() {
        return this.a.a();
    }

    public void d() {
    }

    public void a(lx lxVar) {
        long j;
        Object obj = null;
        synchronized (this) {
            j = this.d;
            this.c = lxVar;
            if (this.b != null && j == Long.MIN_VALUE) {
                obj = 1;
            }
        }
        if (obj != null) {
            this.b.a(this.c);
        } else if (j == Long.MIN_VALUE) {
            this.c.a(Long.MAX_VALUE);
        } else {
            this.c.a(j);
        }
    }
}
