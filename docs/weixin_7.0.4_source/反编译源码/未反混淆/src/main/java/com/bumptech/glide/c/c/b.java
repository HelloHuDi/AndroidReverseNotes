package com.bumptech.glide.c.c;

import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b<Data> implements n<byte[], Data> {
    private final b<Data> aDO;

    public interface b<Data> {
        Data h(byte[] bArr);

        Class<Data> mg();
    }

    public static class a implements o<byte[], ByteBuffer> {
        public final n<byte[], ByteBuffer> a(r rVar) {
            AppMethodBeat.i(92037);
            b bVar = new b(new b<ByteBuffer>() {
                public final Class<ByteBuffer> mg() {
                    return ByteBuffer.class;
                }

                public final /* synthetic */ Object h(byte[] bArr) {
                    AppMethodBeat.i(92036);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    AppMethodBeat.o(92036);
                    return wrap;
                }
            });
            AppMethodBeat.o(92037);
            return bVar;
        }
    }

    public static class d implements o<byte[], InputStream> {
        public final n<byte[], InputStream> a(r rVar) {
            AppMethodBeat.i(92041);
            b bVar = new b(new b<InputStream>() {
                public final Class<InputStream> mg() {
                    return InputStream.class;
                }

                public final /* synthetic */ Object h(byte[] bArr) {
                    AppMethodBeat.i(92040);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    AppMethodBeat.o(92040);
                    return byteArrayInputStream;
                }
            });
            AppMethodBeat.o(92041);
            return bVar;
        }
    }

    static class c<Data> implements com.bumptech.glide.c.a.d<Data> {
        private final b<Data> aDO;
        private final byte[] aDQ;

        c(byte[] bArr, b<Data> bVar) {
            this.aDQ = bArr;
            this.aDO = bVar;
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super Data> aVar) {
            AppMethodBeat.i(92038);
            aVar.S(this.aDO.h(this.aDQ));
            AppMethodBeat.o(92038);
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        public final Class<Data> mg() {
            AppMethodBeat.i(92039);
            Class mg = this.aDO.mg();
            AppMethodBeat.o(92039);
            return mg;
        }

        public final com.bumptech.glide.c.a mh() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    public final /* bridge */ /* synthetic */ boolean X(Object obj) {
        return true;
    }

    public final /* synthetic */ com.bumptech.glide.c.c.n.a b(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92042);
        byte[] bArr = (byte[]) obj;
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(bArr), new c(bArr, this.aDO));
        AppMethodBeat.o(92042);
        return aVar;
    }

    public b(b<Data> bVar) {
        this.aDO = bVar;
    }
}
