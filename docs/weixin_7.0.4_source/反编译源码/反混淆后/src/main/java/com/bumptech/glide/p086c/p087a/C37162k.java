package com.bumptech.glide.p086c.p087a;

import com.bumptech.glide.p086c.p087a.C8511e.C8512a;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p086c.p092d.p093a.C25444m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.a.k */
public final class C37162k implements C8511e<InputStream> {
    private final C25444m azw;

    /* renamed from: com.bumptech.glide.c.a.k$a */
    public static final class C37161a implements C8512a<InputStream> {
        private final C8515b azx;

        /* renamed from: T */
        public final /* synthetic */ C8511e mo2195T(Object obj) {
            AppMethodBeat.m2504i(91725);
            C37162k c37162k = new C37162k((InputStream) obj, this.azx);
            AppMethodBeat.m2505o(91725);
            return c37162k;
        }

        public C37161a(C8515b c8515b) {
            this.azx = c8515b;
        }

        /* renamed from: mg */
        public final Class<InputStream> mo2196mg() {
            return InputStream.class;
        }
    }

    C37162k(InputStream inputStream, C8515b c8515b) {
        AppMethodBeat.m2504i(91726);
        this.azw = new C25444m(inputStream, c8515b);
        this.azw.mark(5242880);
        AppMethodBeat.m2505o(91726);
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(91727);
        this.azw.release();
        AppMethodBeat.m2505o(91727);
    }

    /* renamed from: mj */
    public final /* synthetic */ Object mo2194mj() {
        AppMethodBeat.m2504i(91728);
        this.azw.reset();
        C25444m c25444m = this.azw;
        AppMethodBeat.m2505o(91728);
        return c25444m;
    }
}
