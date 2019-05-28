package com.bumptech.glide.p086c.p087a;

import com.bumptech.glide.p086c.p087a.C8511e.C8512a;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.a.f */
public final class C0744f {
    private static final C8512a<?> azl = new C07461();
    private final Map<Class<?>, C8512a<?>> azk = new HashMap();

    /* renamed from: com.bumptech.glide.c.a.f$a */
    static final class C0745a implements C8511e<Object> {
        private final Object data;

        C0745a(Object obj) {
            this.data = obj;
        }

        /* renamed from: mj */
        public final Object mo2194mj() {
            return this.data;
        }

        public final void cleanup() {
        }
    }

    /* renamed from: com.bumptech.glide.c.a.f$1 */
    class C07461 implements C8512a<Object> {
        C07461() {
        }

        /* renamed from: T */
        public final C8511e<Object> mo2195T(Object obj) {
            AppMethodBeat.m2504i(91704);
            C0745a c0745a = new C0745a(obj);
            AppMethodBeat.m2505o(91704);
            return c0745a;
        }

        /* renamed from: mg */
        public final Class<Object> mo2196mg() {
            AppMethodBeat.m2504i(91705);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implemented");
            AppMethodBeat.m2505o(91705);
            throw unsupportedOperationException;
        }
    }

    public C0744f() {
        AppMethodBeat.m2504i(91706);
        AppMethodBeat.m2505o(91706);
    }

    static {
        AppMethodBeat.m2504i(91709);
        AppMethodBeat.m2505o(91709);
    }

    /* renamed from: b */
    public final synchronized void mo2192b(C8512a<?> c8512a) {
        AppMethodBeat.m2504i(91707);
        this.azk.put(c8512a.mo2196mg(), c8512a);
        AppMethodBeat.m2505o(91707);
    }

    /* renamed from: T */
    public final synchronized <T> C8511e<T> mo2191T(T t) {
        C8511e T;
        AppMethodBeat.m2504i(91708);
        C8561i.m15217d(t, "Argument must not be null");
        C8512a c8512a = (C8512a) this.azk.get(t.getClass());
        if (c8512a == null) {
            for (C8512a c8512a2 : this.azk.values()) {
                if (c8512a2.mo2196mg().isAssignableFrom(t.getClass())) {
                    c8512a = c8512a2;
                    break;
                }
            }
        }
        if (c8512a == null) {
            c8512a = azl;
        }
        T = c8512a.mo2195T(t);
        AppMethodBeat.m2505o(91708);
        return T;
    }
}
