package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.if.b;

public class ka {
    private final int a;
    private final int b;
    private final int c;
    private DoublePoint d;
    private DoublePoint e;
    private float f = 0.0f;
    private ie g;
    private b h = new b() {
        public void a(float f, float f2) {
        }

        public void a(float f, float f2, float f3, float f4) {
        }

        public void a(int i, int i2) {
        }

        public void a(float f) {
            AppMethodBeat.i(100190);
            ka.this.f = f;
            AppMethodBeat.o(100190);
        }

        public void b(float f) {
        }
    };
    private volatile boolean i = false;
    private boolean j = true;
    private Bitmap k = null;

    public ka(int i, int i2, int i3) {
        AppMethodBeat.i(100191);
        this.a = i;
        this.b = i2;
        this.c = i3;
        AppMethodBeat.o(100191);
    }

    public void a() {
        AppMethodBeat.i(100192);
        if (this.k != null) {
            if (this.g != null) {
                this.g.b();
                this.g = null;
            }
            this.k.recycle();
            this.k = null;
        }
        AppMethodBeat.o(100192);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ka)) {
            return false;
        }
        ka kaVar = (ka) obj;
        if (this.a == kaVar.a && this.b == kaVar.b && this.c == kaVar.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a * 7) + (this.b * 11)) + (this.c * 13);
    }

    public String toString() {
        AppMethodBeat.i(100193);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(this.a);
        stringBuilder.append("-");
        stringBuilder.append(this.b);
        stringBuilder.append("-");
        stringBuilder.append(this.c);
        stringBuilder.append("-");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(100193);
        return stringBuilder2;
    }

    public int b() {
        return this.c;
    }

    public void a(float f) {
        AppMethodBeat.i(100194);
        this.i = true;
        this.f = f;
        this.g = new ie(f, 1.0f);
        this.g.a(this.h);
        this.g.a(250);
        this.g.a(null, null);
        AppMethodBeat.o(100194);
    }

    public void a(Bitmap bitmap) {
        AppMethodBeat.i(100195);
        if (bitmap == null) {
            AppMethodBeat.o(100195);
            return;
        }
        this.k = bitmap;
        a(0.0f);
        AppMethodBeat.o(100195);
    }

    public DoublePoint c() {
        return this.d;
    }

    public void a(DoublePoint doublePoint) {
        this.d = doublePoint;
    }

    public DoublePoint d() {
        return this.e;
    }

    public void b(DoublePoint doublePoint) {
        this.e = doublePoint;
    }
}
