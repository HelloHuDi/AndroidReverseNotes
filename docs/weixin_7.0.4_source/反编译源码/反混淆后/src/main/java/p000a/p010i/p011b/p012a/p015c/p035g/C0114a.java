package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import p000a.p010i.p011b.p012a.p015c.p035g.C8185q.C8186a;

/* renamed from: a.i.b.a.c.g.a */
public abstract class C0114a implements C8185q {
    protected int Bzl = 0;

    /* renamed from: a.i.b.a.c.g.a$a */
    public static abstract class C0115a<BuilderType extends C0115a> implements C8186a {

        /* renamed from: a.i.b.a.c.g.a$a$a */
        static final class C0116a extends FilterInputStream {
            private int limit;

            C0116a(InputStream inputStream, int i) {
                super(inputStream);
                this.limit = i;
            }

            public final int available() {
                AppMethodBeat.m2504i(121407);
                int min = Math.min(super.available(), this.limit);
                AppMethodBeat.m2505o(121407);
                return min;
            }

            public final int read() {
                AppMethodBeat.m2504i(121408);
                if (this.limit <= 0) {
                    AppMethodBeat.m2505o(121408);
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.limit--;
                }
                AppMethodBeat.m2505o(121408);
                return read;
            }

            public final int read(byte[] bArr, int i, int i2) {
                AppMethodBeat.m2504i(121409);
                if (this.limit <= 0) {
                    AppMethodBeat.m2505o(121409);
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, this.limit));
                if (read >= 0) {
                    this.limit -= read;
                }
                AppMethodBeat.m2505o(121409);
                return read;
            }

            public final long skip(long j) {
                AppMethodBeat.m2504i(121410);
                long skip = super.skip(Math.min(j, (long) this.limit));
                if (skip >= 0) {
                    this.limit = (int) (((long) this.limit) - skip);
                }
                AppMethodBeat.m2505o(121410);
                return skip;
            }
        }

        /* renamed from: c */
        public abstract BuilderType mo150d(C31713e c31713e, C31715g c31715g);

        /* renamed from: ecL */
        public abstract BuilderType clone();
    }

    /* renamed from: c */
    public final void mo182c(OutputStream outputStream) {
        int i = 4096;
        int vq = mo144vq();
        int fx = C37024f.m61956fx(vq) + vq;
        if (fx <= 4096) {
            i = fx;
        }
        C37024f e = C37024f.m61953e(outputStream, i);
        e.mo59058fw(vq);
        mo128a(e);
        e.flush();
    }
}
