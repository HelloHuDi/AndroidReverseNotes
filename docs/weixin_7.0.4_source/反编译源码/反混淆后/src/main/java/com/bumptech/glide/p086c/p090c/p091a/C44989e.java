package com.bumptech.glide.p086c.p090c.p091a;

import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p090c.C31950g;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p090c.C8536r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.bumptech.glide.c.c.a.e */
public final class C44989e implements C37175n<URL, InputStream> {
    private final C37175n<C31950g, InputStream> aEQ;

    /* renamed from: com.bumptech.glide.c.c.a.e$a */
    public static class C41551a implements C31953o<URL, InputStream> {
        /* renamed from: a */
        public final C37175n<URL, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92174);
            C44989e c44989e = new C44989e(c8536r.mo18638b(C31950g.class, InputStream.class));
            AppMethodBeat.m2505o(92174);
            return c44989e;
        }
    }

    /* renamed from: X */
    public final /* bridge */ /* synthetic */ boolean mo2224X(Object obj) {
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92175);
        C37176a b = this.aEQ.mo2225b(new C31950g((URL) obj), i, i2, c31967j);
        AppMethodBeat.m2505o(92175);
        return b;
    }

    public C44989e(C37175n<C31950g, InputStream> c37175n) {
        this.aEQ = c37175n;
    }
}
