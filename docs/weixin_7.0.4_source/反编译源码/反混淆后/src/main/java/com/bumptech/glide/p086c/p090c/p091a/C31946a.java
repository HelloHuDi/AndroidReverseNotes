package com.bumptech.glide.p086c.p090c.p091a;

import com.bumptech.glide.p086c.C17546i;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C44980j;
import com.bumptech.glide.p086c.p090c.C31950g;
import com.bumptech.glide.p086c.p090c.C31951m;
import com.bumptech.glide.p086c.p090c.C31951m.C31952a;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p090c.C8536r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.c.a.a */
public final class C31946a implements C37175n<C31950g, InputStream> {
    public static final C17546i<Integer> aEO = C17546i.m27397c("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    private final C31951m<C31950g, C31950g> aEP;

    /* renamed from: com.bumptech.glide.c.c.a.a$a */
    public static class C31947a implements C31953o<C31950g, InputStream> {
        private final C31951m<C31950g, C31950g> aEP = new C31951m(500);

        public C31947a() {
            AppMethodBeat.m2504i(92158);
            AppMethodBeat.m2505o(92158);
        }

        /* renamed from: a */
        public final C37175n<C31950g, InputStream> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92159);
            C31946a c31946a = new C31946a(this.aEP);
            AppMethodBeat.m2505o(92159);
            return c31946a;
        }
    }

    /* renamed from: X */
    public final /* bridge */ /* synthetic */ boolean mo2224X(Object obj) {
        return true;
    }

    /* renamed from: b */
    public final /* synthetic */ C37176a mo2225b(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92160);
        C31950g c31950g = (C31950g) obj;
        if (this.aEP != null) {
            C31950g c31950g2 = (C31950g) this.aEP.mo52060Y(c31950g);
            if (c31950g2 == null) {
                C31951m c31951m = this.aEP;
                c31951m.aEm.put(C31952a.m51910Z(c31950g), c31950g);
            } else {
                c31950g = c31950g2;
            }
        }
        C37176a c37176a = new C37176a(c31950g, new C44980j(c31950g, ((Integer) c31967j.mo52069a(aEO)).intValue()));
        AppMethodBeat.m2505o(92160);
        return c37176a;
    }

    static {
        AppMethodBeat.m2504i(92161);
        AppMethodBeat.m2505o(92161);
    }

    public C31946a() {
        this(null);
    }

    public C31946a(C31951m<C31950g, C31950g> c31951m) {
        this.aEP = c31951m;
    }
}
