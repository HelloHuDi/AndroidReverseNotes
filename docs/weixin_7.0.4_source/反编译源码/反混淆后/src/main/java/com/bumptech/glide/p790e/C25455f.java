package com.bumptech.glide.p790e;

import com.bumptech.glide.p086c.C31969l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.e.f */
public final class C25455f {
    private final List<C8557a<?>> aGX = new ArrayList();

    /* renamed from: com.bumptech.glide.e.f$a */
    static final class C8557a<T> {
        final C31969l<T> aAN;
        final Class<T> aAf;

        C8557a(Class<T> cls, C31969l<T> c31969l) {
            this.aAf = cls;
            this.aAN = c31969l;
        }
    }

    public C25455f() {
        AppMethodBeat.m2504i(92447);
        AppMethodBeat.m2505o(92447);
    }

    /* renamed from: b */
    public final synchronized <Z> void mo42494b(Class<Z> cls, C31969l<Z> c31969l) {
        AppMethodBeat.m2504i(92448);
        this.aGX.add(new C8557a(cls, c31969l));
        AppMethodBeat.m2505o(92448);
    }

    /* renamed from: v */
    public final synchronized <Z> C31969l<Z> mo42495v(Class<Z> cls) {
        C31969l<Z> c31969l;
        AppMethodBeat.m2504i(92449);
        int size = this.aGX.size();
        for (int i = 0; i < size; i++) {
            C8557a c8557a = (C8557a) this.aGX.get(i);
            if (c8557a.aAf.isAssignableFrom(cls)) {
                c31969l = c8557a.aAN;
                AppMethodBeat.m2505o(92449);
                break;
            }
        }
        c31969l = null;
        AppMethodBeat.m2505o(92449);
        return c31969l;
    }
}
