package com.bumptech.glide.c.c.a;

import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.m;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a implements n<g, InputStream> {
    public static final i<Integer> aEO = i.c("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    private final m<g, g> aEP;

    public static class a implements o<g, InputStream> {
        private final m<g, g> aEP = new m(500);

        public a() {
            AppMethodBeat.i(92158);
            AppMethodBeat.o(92158);
        }

        public final n<g, InputStream> a(r rVar) {
            AppMethodBeat.i(92159);
            a aVar = new a(this.aEP);
            AppMethodBeat.o(92159);
            return aVar;
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92160);
        g gVar = (g) obj;
        if (this.aEP != null) {
            g gVar2 = (g) this.aEP.Y(gVar);
            if (gVar2 == null) {
                m mVar = this.aEP;
                mVar.aEm.put(com.bumptech.glide.c.c.m.a.Z(gVar), gVar);
            } else {
                gVar = gVar2;
            }
        }
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(gVar, new com.bumptech.glide.c.a.j(gVar, ((Integer) jVar.a(aEO)).intValue()));
        AppMethodBeat.o(92160);
        return aVar;
    }

    static {
        AppMethodBeat.i(92161);
        AppMethodBeat.o(92161);
    }

    public a() {
        this(null);
    }

    public a(m<g, g> mVar) {
        this.aEP = mVar;
    }
}
