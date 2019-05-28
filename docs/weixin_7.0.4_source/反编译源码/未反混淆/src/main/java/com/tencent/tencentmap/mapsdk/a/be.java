package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class be {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private Bitmap e = null;
    private da f;
    private Options g;

    public be(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public be(int i, int i2, int i3, int i4, da daVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.f = daVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        if (this.a == beVar.a && this.b == beVar.b && this.c == beVar.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a * 7) + (this.b * 11)) + (this.c * 13);
    }

    public String toString() {
        AppMethodBeat.i(100781);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(this.a);
        stringBuilder.append("-");
        stringBuilder.append(this.b);
        stringBuilder.append("-");
        stringBuilder.append(this.c);
        stringBuilder.append("-");
        stringBuilder.append(this.d);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(100781);
        return stringBuilder2;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void a(Bitmap bitmap) {
        this.e = bitmap;
    }

    public da e() {
        return this.f;
    }

    public void a(Options options) {
        this.g = options;
    }

    public Options f() {
        return this.g;
    }
}
