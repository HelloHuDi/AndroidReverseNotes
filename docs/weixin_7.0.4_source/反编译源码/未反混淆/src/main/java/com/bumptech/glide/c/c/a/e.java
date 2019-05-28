package com.bumptech.glide.c.c.a;

import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.URL;

public final class e implements n<URL, InputStream> {
    private final n<g, InputStream> aEQ;

    public static class a implements o<URL, InputStream> {
        public final n<URL, InputStream> a(r rVar) {
            AppMethodBeat.i(92174);
            e eVar = new e(rVar.b(g.class, InputStream.class));
            AppMethodBeat.o(92174);
            return eVar;
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92175);
        com.bumptech.glide.c.c.n.a b = this.aEQ.b(new g((URL) obj), i, i2, jVar);
        AppMethodBeat.o(92175);
        return b;
    }

    public e(n<g, InputStream> nVar) {
        this.aEQ = nVar;
    }
}
