package com.bumptech.glide.p086c.p090c.p091a;

import android.net.Uri;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p090c.C31950g;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p090c.C8536r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.c.c.a.b */
public final class C41191b implements C37175n<Uri, InputStream> {
    private static final Set<String> aEL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final C37175n<C31950g, InputStream> aEN;

    /* renamed from: com.bumptech.glide.c.c.a.b$a */
    public static class C0760a implements C31953o<Uri, InputStream> {
        /* renamed from: a */
        public final C37175n<Uri, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92162);
            C41191b c41191b = new C41191b(c8536r.mo18638b(C31950g.class, InputStream.class));
            AppMethodBeat.m2505o(92162);
            return c41191b;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92163);
        boolean contains = aEL.contains(((Uri) obj).getScheme());
        AppMethodBeat.m2505o(92163);
        return contains;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92164);
        C37176a b = this.aEN.mo2225b(new C31950g(((Uri) obj).toString()), i, i2, c31967j);
        AppMethodBeat.m2505o(92164);
        return b;
    }

    static {
        AppMethodBeat.m2504i(92165);
        AppMethodBeat.m2505o(92165);
    }

    public C41191b(C37175n<C31950g, InputStream> c37175n) {
        this.aEN = c37175n;
    }
}
