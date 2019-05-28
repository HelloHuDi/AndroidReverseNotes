package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.fz.a;

public class fx {
    public static final fx g = new fx(1, null);
    public static final fx h = new fx(2, null, true);
    public static final fx i = new fx(104, null);
    public int a;
    public double[] b;
    public long c;
    public boolean d;
    public boolean e;
    public Runnable f;
    private fy j;

    static {
        AppMethodBeat.i(98949);
        AppMethodBeat.o(98949);
    }

    public fx() {
        this.c = -1;
        this.d = false;
    }

    public fx(int i, double[] dArr) {
        this(i, dArr, false);
    }

    public fx(int i, double[] dArr, boolean z) {
        this.c = -1;
        this.d = false;
        this.a = i;
        this.b = dArr;
        this.e = z;
    }

    public fx(Runnable runnable) {
        this.c = -1;
        this.d = false;
        this.a = 6;
        this.f = runnable;
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean a(a aVar) {
        AppMethodBeat.i(98946);
        if (this.j != null) {
            this.j.a();
        }
        boolean a = a();
        aVar.a(this);
        AppMethodBeat.o(98946);
        return a;
    }

    public void b() {
        AppMethodBeat.i(98947);
        if (this.j != null) {
            this.j.b();
        }
        AppMethodBeat.o(98947);
    }

    public void c() {
        AppMethodBeat.i(98948);
        if (this.j != null) {
            this.j.c();
        }
        AppMethodBeat.o(98948);
    }
}
