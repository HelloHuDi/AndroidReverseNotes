package com.bumptech.glide.c.c;

import android.util.Log;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d implements n<File, ByteBuffer> {

    public static class b implements o<File, ByteBuffer> {
        public final n<File, ByteBuffer> a(r rVar) {
            AppMethodBeat.i(92046);
            d dVar = new d();
            AppMethodBeat.o(92046);
            return dVar;
        }
    }

    static final class a implements com.bumptech.glide.c.a.d<ByteBuffer> {
        private final File file;

        a(File file) {
            this.file = file;
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super ByteBuffer> aVar) {
            AppMethodBeat.i(92045);
            try {
                aVar.S(com.bumptech.glide.h.a.p(this.file));
                AppMethodBeat.o(92045);
            } catch (IOException e) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.b(e);
                AppMethodBeat.o(92045);
            }
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        public final Class<ByteBuffer> mg() {
            return ByteBuffer.class;
        }

        public final com.bumptech.glide.c.a mh() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92047);
        File file = (File) obj;
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(file), new a(file));
        AppMethodBeat.o(92047);
        return aVar;
    }
}
