package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ku<T extends kv> implements kv {
    private final List<T> a;
    private final ky b;

    public ku(List<T> list) {
        AppMethodBeat.i(100269);
        this.a = list;
        this.b = ks.a(list);
        AppMethodBeat.o(100269);
    }

    public List<T> a() {
        return this.a;
    }

    public kt b() {
        return this.b;
    }
}
