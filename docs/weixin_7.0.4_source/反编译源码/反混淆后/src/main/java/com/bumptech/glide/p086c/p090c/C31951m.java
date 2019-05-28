package com.bumptech.glide.p086c.p090c;

import com.bumptech.glide.p095h.C0780f;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

/* renamed from: com.bumptech.glide.c.c.m */
public final class C31951m<A, B> {
    public final C0780f<C31952a<A>, B> aEm;

    /* renamed from: com.bumptech.glide.c.c.m$a */
    public static final class C31952a<A> {
        private static final Queue<C31952a<?>> aEo = C45002j.m82420dn(0);
        private A axb;
        private int height;
        private int width;

        static {
            AppMethodBeat.m2504i(92095);
            AppMethodBeat.m2505o(92095);
        }

        /* renamed from: Z */
        public static <A> C31952a<A> m51910Z(A a) {
            C31952a c31952a;
            AppMethodBeat.m2504i(92091);
            synchronized (aEo) {
                try {
                    c31952a = (C31952a) aEo.poll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92091);
                    }
                }
            }
            if (c31952a == null) {
                c31952a = new C31952a();
            }
            c31952a.axb = a;
            c31952a.width = 0;
            c31952a.height = 0;
            AppMethodBeat.m2505o(92091);
            return c31952a;
        }

        private C31952a() {
        }

        public final void release() {
            AppMethodBeat.m2504i(92092);
            synchronized (aEo) {
                try {
                    aEo.offer(this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(92092);
                }
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(92093);
            if (obj instanceof C31952a) {
                C31952a c31952a = (C31952a) obj;
                if (this.width == c31952a.width && this.height == c31952a.height && this.axb.equals(c31952a.axb)) {
                    AppMethodBeat.m2505o(92093);
                    return true;
                }
                AppMethodBeat.m2505o(92093);
                return false;
            }
            AppMethodBeat.m2505o(92093);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(92094);
            int hashCode = (((this.height * 31) + this.width) * 31) + this.axb.hashCode();
            AppMethodBeat.m2505o(92094);
            return hashCode;
        }
    }

    public C31951m() {
        this(250);
    }

    public C31951m(long j) {
        AppMethodBeat.m2504i(92096);
        this.aEm = new C0780f<C31952a<A>, B>(j) {
            /* renamed from: g */
            public final /* synthetic */ void mo2246g(Object obj, Object obj2) {
                AppMethodBeat.m2504i(92090);
                ((C31952a) obj).release();
                AppMethodBeat.m2505o(92090);
            }
        };
        AppMethodBeat.m2505o(92096);
    }

    /* renamed from: Y */
    public final B mo52060Y(A a) {
        AppMethodBeat.m2504i(92097);
        C31952a Z = C31952a.m51910Z(a);
        Object obj = this.aEm.get(Z);
        Z.release();
        AppMethodBeat.m2505o(92097);
        return obj;
    }
}
