package com.bumptech.glide.p790e;

import com.bumptech.glide.p086c.C37189d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.e.a */
public final class C41567a {
    private final List<C41568a<?>> aGX = new ArrayList();

    /* renamed from: com.bumptech.glide.e.a$a */
    static final class C41568a<T> {
        final C37189d<T> aAc;
        final Class<T> aBd;

        C41568a(Class<T> cls, C37189d<T> c37189d) {
            this.aBd = cls;
            this.aAc = c37189d;
        }
    }

    public C41567a() {
        AppMethodBeat.m2504i(92429);
        AppMethodBeat.m2505o(92429);
    }

    /* renamed from: u */
    public final synchronized <T> C37189d<T> mo66581u(Class<T> cls) {
        C37189d<T> c37189d;
        AppMethodBeat.m2504i(92430);
        for (C41568a c41568a : this.aGX) {
            if (c41568a.aBd.isAssignableFrom(cls)) {
                c37189d = c41568a.aAc;
                AppMethodBeat.m2505o(92430);
                break;
            }
        }
        c37189d = null;
        AppMethodBeat.m2505o(92430);
        return c37189d;
    }

    /* renamed from: b */
    public final synchronized <T> void mo66580b(Class<T> cls, C37189d<T> c37189d) {
        AppMethodBeat.m2504i(92431);
        this.aGX.add(new C41568a(cls, c37189d));
        AppMethodBeat.m2505o(92431);
    }
}
