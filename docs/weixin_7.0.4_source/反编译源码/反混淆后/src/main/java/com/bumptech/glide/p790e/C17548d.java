package com.bumptech.glide.p790e;

import android.support.p057v4.p065f.C6197a;
import com.bumptech.glide.p095h.C25464h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bumptech.glide.e.d */
public final class C17548d {
    private final AtomicReference<C25464h> aHb = new AtomicReference();
    public final C6197a<C25464h, List<Class<?>>> aHc = new C6197a();

    public C17548d() {
        AppMethodBeat.m2504i(92438);
        AppMethodBeat.m2505o(92438);
    }

    /* renamed from: f */
    public final List<Class<?>> mo31970f(Class<?> cls, Class<?> cls2) {
        Object c25464h;
        List<Class<?>> list;
        AppMethodBeat.m2504i(92439);
        C25464h c25464h2 = (C25464h) this.aHb.getAndSet(null);
        if (c25464h2 == null) {
            c25464h = new C25464h(cls, cls2);
        } else {
            c25464h2.mo42511d(cls, cls2, null);
            C25464h c25464h3 = c25464h2;
        }
        synchronized (this.aHc) {
            try {
                list = (List) this.aHc.get(c25464h3);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(92439);
            }
        }
        this.aHb.set(c25464h3);
        return list;
    }
}
