package com.bumptech.glide.p086c.p090c;

import android.net.Uri;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.c.c.x */
public final class C44993x<Data> implements C37175n<Uri, Data> {
    private static final Set<String> aEL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    private final C37175n<C31950g, Data> aEN;

    /* renamed from: com.bumptech.glide.c.c.x$a */
    public static class C0768a implements C31953o<Uri, InputStream> {
        /* renamed from: a */
        public final C37175n<Uri, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92154);
            C44993x c44993x = new C44993x(c8536r.mo18638b(C31950g.class, InputStream.class));
            AppMethodBeat.m2505o(92154);
            return c44993x;
        }
    }

    /* renamed from: X */
    public final /* synthetic */ boolean mo2224X(Object obj) {
        AppMethodBeat.m2504i(92155);
        boolean contains = aEL.contains(((Uri) obj).getScheme());
        AppMethodBeat.m2505o(92155);
        return contains;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92156);
        C37176a b = this.aEN.mo2225b(new C31950g(((Uri) obj).toString()), i, i2, c31967j);
        AppMethodBeat.m2505o(92156);
        return b;
    }

    static {
        AppMethodBeat.m2504i(92157);
        AppMethodBeat.m2505o(92157);
    }

    public C44993x(C37175n<C31950g, Data> c37175n) {
        this.aEN = c37175n;
    }
}
