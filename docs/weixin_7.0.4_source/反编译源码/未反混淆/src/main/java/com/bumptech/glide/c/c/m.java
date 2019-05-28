package com.bumptech.glide.c.c;

import com.bumptech.glide.h.f;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

public final class m<A, B> {
    public final f<a<A>, B> aEm;

    public static final class a<A> {
        private static final Queue<a<?>> aEo = j.dn(0);
        private A axb;
        private int height;
        private int width;

        static {
            AppMethodBeat.i(92095);
            AppMethodBeat.o(92095);
        }

        public static <A> a<A> Z(A a) {
            a aVar;
            AppMethodBeat.i(92091);
            synchronized (aEo) {
                try {
                    aVar = (a) aEo.poll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(92091);
                    }
                }
            }
            if (aVar == null) {
                aVar = new a();
            }
            aVar.axb = a;
            aVar.width = 0;
            aVar.height = 0;
            AppMethodBeat.o(92091);
            return aVar;
        }

        private a() {
        }

        public final void release() {
            AppMethodBeat.i(92092);
            synchronized (aEo) {
                try {
                    aEo.offer(this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(92092);
                }
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92093);
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.width == aVar.width && this.height == aVar.height && this.axb.equals(aVar.axb)) {
                    AppMethodBeat.o(92093);
                    return true;
                }
                AppMethodBeat.o(92093);
                return false;
            }
            AppMethodBeat.o(92093);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(92094);
            int hashCode = (((this.height * 31) + this.width) * 31) + this.axb.hashCode();
            AppMethodBeat.o(92094);
            return hashCode;
        }
    }

    public m() {
        this(250);
    }

    public m(long j) {
        AppMethodBeat.i(92096);
        this.aEm = new f<a<A>, B>(j) {
            public final /* synthetic */ void g(Object obj, Object obj2) {
                AppMethodBeat.i(92090);
                ((a) obj).release();
                AppMethodBeat.o(92090);
            }
        };
        AppMethodBeat.o(92096);
    }

    public final B Y(A a) {
        AppMethodBeat.i(92097);
        a Z = a.Z(a);
        Object obj = this.aEm.get(Z);
        Z.release();
        AppMethodBeat.o(92097);
        return obj;
    }
}
