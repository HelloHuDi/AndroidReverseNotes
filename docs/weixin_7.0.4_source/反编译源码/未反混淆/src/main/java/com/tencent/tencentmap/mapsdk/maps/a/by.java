package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class by implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ int b;
    private /* synthetic */ int c;
    private /* synthetic */ String d;
    private /* synthetic */ Map e;
    private /* synthetic */ Map f;
    private /* synthetic */ boolean g;
    private /* synthetic */ int h;

    by(String str, int i, int i2, String str2, Map map, Map map2, boolean z, int i3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = map;
        this.f = map2;
        this.g = z;
        this.h = i3;
    }

    public final void run() {
        AppMethodBeat.i(98603);
        bx.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        AppMethodBeat.o(98603);
    }
}
