package com.bumptech.glide.c.a;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.d.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class k implements e<InputStream> {
    private final m azw;

    public static final class a implements com.bumptech.glide.c.a.e.a<InputStream> {
        private final b azx;

        public final /* synthetic */ e T(Object obj) {
            AppMethodBeat.i(91725);
            k kVar = new k((InputStream) obj, this.azx);
            AppMethodBeat.o(91725);
            return kVar;
        }

        public a(b bVar) {
            this.azx = bVar;
        }

        public final Class<InputStream> mg() {
            return InputStream.class;
        }
    }

    k(InputStream inputStream, b bVar) {
        AppMethodBeat.i(91726);
        this.azw = new m(inputStream, bVar);
        this.azw.mark(5242880);
        AppMethodBeat.o(91726);
    }

    public final void cleanup() {
        AppMethodBeat.i(91727);
        this.azw.release();
        AppMethodBeat.o(91727);
    }

    public final /* synthetic */ Object mj() {
        AppMethodBeat.i(91728);
        this.azw.reset();
        m mVar = this.azw;
        AppMethodBeat.o(91728);
        return mVar;
    }
}
