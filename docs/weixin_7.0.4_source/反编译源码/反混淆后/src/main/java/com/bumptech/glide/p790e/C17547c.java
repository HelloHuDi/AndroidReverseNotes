package com.bumptech.glide.p790e;

import android.support.p057v4.p065f.C6197a;
import com.bumptech.glide.p086c.p088b.C25424s;
import com.bumptech.glide.p086c.p088b.C31937h;
import com.bumptech.glide.p086c.p092d.p094f.C41565g;
import com.bumptech.glide.p095h.C25464h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.e.c */
public final class C17547c {
    public static final C25424s<?, ?, ?> aGY = new C25424s(Object.class, Object.class, Object.class, Collections.singletonList(new C31937h(Object.class, Object.class, Object.class, Collections.emptyList(), new C41565g(), null)), null);
    public final C6197a<C25464h, C25424s<?, ?, ?>> aGZ = new C6197a();
    private final AtomicReference<C25464h> aHa = new AtomicReference();

    public C17547c() {
        AppMethodBeat.m2504i(92434);
        AppMethodBeat.m2505o(92434);
    }

    static {
        AppMethodBeat.m2504i(92437);
        AppMethodBeat.m2505o(92437);
    }

    /* renamed from: a */
    public static boolean m27398a(C25424s<?, ?, ?> c25424s) {
        AppMethodBeat.m2504i(92435);
        boolean equals = aGY.equals(c25424s);
        AppMethodBeat.m2505o(92435);
        return equals;
    }

    /* renamed from: c */
    public final <Data, TResource, Transcode> C25424s<Data, TResource, Transcode> mo31969c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        C25464h c25464h;
        C25424s<Data, TResource, Transcode> c25424s;
        AppMethodBeat.m2504i(92436);
        C25464h c25464h2 = (C25464h) this.aHa.getAndSet(null);
        if (c25464h2 == null) {
            c25464h = new C25464h();
        } else {
            c25464h = c25464h2;
        }
        c25464h.mo42511d(cls, cls2, cls3);
        synchronized (this.aGZ) {
            try {
                c25424s = (C25424s) this.aGZ.get(c25464h);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(92436);
            }
        }
        this.aHa.set(c25464h);
        return c25424s;
    }
}
