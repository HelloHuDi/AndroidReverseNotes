package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.e;
import com.tencent.mm.memory.a.b;

final class j implements e {
    private f<String, Bitmap> fEV = new b(5, getClass());

    j() {
        AppMethodBeat.i(78306);
        AppMethodBeat.o(78306);
    }

    public final void f(Object obj, Object obj2) {
        AppMethodBeat.i(78307);
        this.fEV.k((String) obj, (Bitmap) obj2);
        AppMethodBeat.o(78307);
    }

    public final Object get(Object obj) {
        AppMethodBeat.i(78308);
        Object obj2 = this.fEV.get((String) obj);
        AppMethodBeat.o(78308);
        return obj2;
    }

    public final Object remove(Object obj) {
        AppMethodBeat.i(78309);
        this.fEV.remove((String) obj);
        AppMethodBeat.o(78309);
        return null;
    }
}
