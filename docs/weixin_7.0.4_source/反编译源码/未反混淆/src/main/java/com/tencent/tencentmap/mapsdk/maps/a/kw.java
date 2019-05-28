package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class kw<T extends kv> {
    private final ku<T> a;
    private final ku<T> b;
    private Float c = null;
    private final Float d;

    public kw(List<T> list, List<T> list2) {
        AppMethodBeat.i(100270);
        this.a = new ku(list);
        this.b = new ku(list2);
        this.d = Float.valueOf(this.a.b().a().h() + this.b.b().a().h());
        AppMethodBeat.o(100270);
    }

    public final ku<T> a() {
        return this.a;
    }

    public final ku<T> b() {
        return this.b;
    }

    public final float c() {
        AppMethodBeat.i(100271);
        if (this.c == null) {
            this.c = Float.valueOf(this.a.b().a().g() + this.b.b().a().g());
        }
        float floatValue = this.c.floatValue();
        AppMethodBeat.o(100271);
        return floatValue;
    }
}
