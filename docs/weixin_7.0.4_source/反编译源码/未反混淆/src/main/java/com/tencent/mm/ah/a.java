package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;

public final class a {
    f<String, Bitmap> fra;

    public a(int i) {
        AppMethodBeat.i(77829);
        this.fra = new c(i);
        AppMethodBeat.o(77829);
    }

    public final void d(String str, Bitmap bitmap) {
        AppMethodBeat.i(77830);
        if (this.fra != null) {
            this.fra.k(str, bitmap);
            AppMethodBeat.o(77830);
            return;
        }
        com.tencent.mm.cache.e.a.a("avatar_cache", str, bitmap);
        AppMethodBeat.o(77830);
    }
}
