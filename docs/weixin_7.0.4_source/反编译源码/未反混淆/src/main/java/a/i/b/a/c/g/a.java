package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class a implements q {
    protected int Bzl = 0;

    public static abstract class a<BuilderType extends a> implements a.i.b.a.c.g.q.a {

        static final class a extends FilterInputStream {
            private int limit;

            a(InputStream inputStream, int i) {
                super(inputStream);
                this.limit = i;
            }

            public final int available() {
                AppMethodBeat.i(121407);
                int min = Math.min(super.available(), this.limit);
                AppMethodBeat.o(121407);
                return min;
            }

            public final int read() {
                AppMethodBeat.i(121408);
                if (this.limit <= 0) {
                    AppMethodBeat.o(121408);
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.limit--;
                }
                AppMethodBeat.o(121408);
                return read;
            }

            public final int read(byte[] bArr, int i, int i2) {
                AppMethodBeat.i(121409);
                if (this.limit <= 0) {
                    AppMethodBeat.o(121409);
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, this.limit));
                if (read >= 0) {
                    this.limit -= read;
                }
                AppMethodBeat.o(121409);
                return read;
            }

            public final long skip(long j) {
                AppMethodBeat.i(121410);
                long skip = super.skip(Math.min(j, (long) this.limit));
                if (skip >= 0) {
                    this.limit = (int) (((long) this.limit) - skip);
                }
                AppMethodBeat.o(121410);
                return skip;
            }
        }

        /* renamed from: c */
        public abstract BuilderType d(e eVar, g gVar);

        /* renamed from: ecL */
        public abstract BuilderType clone();
    }

    public final void c(OutputStream outputStream) {
        int i = 4096;
        int vq = vq();
        int fx = f.fx(vq) + vq;
        if (fx <= 4096) {
            i = fx;
        }
        f e = f.e(outputStream, i);
        e.fw(vq);
        a(e);
        e.flush();
    }
}
