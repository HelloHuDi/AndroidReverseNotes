package com.bumptech.glide.p086c.p090c;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.c.p */
public final class C31954p {
    private final C8536r aEr;
    private final C25434a aEs;

    /* renamed from: com.bumptech.glide.c.c.p$a */
    static class C25434a {
        final Map<Class<?>, C17537a<?>> aEt = new HashMap();

        /* renamed from: com.bumptech.glide.c.c.p$a$a */
        static class C17537a<Model> {
            final List<C37175n<Model, ?>> aEu;

            public C17537a(List<C37175n<Model, ?>> list) {
                this.aEu = list;
            }
        }

        C25434a() {
            AppMethodBeat.m2504i(92100);
            AppMethodBeat.m2505o(92100);
        }
    }

    public C31954p(C8387a<List<Throwable>> c8387a) {
        this(new C8536r(c8387a));
        AppMethodBeat.m2504i(92101);
        AppMethodBeat.m2505o(92101);
    }

    private C31954p(C8536r c8536r) {
        AppMethodBeat.m2504i(92102);
        this.aEs = new C25434a();
        this.aEr = c8536r;
        AppMethodBeat.m2505o(92102);
    }

    /* renamed from: b */
    public final synchronized <Model, Data> void mo52065b(Class<Model> cls, Class<Data> cls2, C31953o<? extends Model, ? extends Data> c31953o) {
        AppMethodBeat.m2504i(92103);
        this.aEr.mo18639b(cls, cls2, c31953o);
        this.aEs.aEt.clear();
        AppMethodBeat.m2505o(92103);
    }

    /* renamed from: r */
    public final synchronized List<Class<?>> mo52066r(Class<?> cls) {
        List r;
        AppMethodBeat.m2504i(92105);
        r = this.aEr.mo18640r(cls);
        AppMethodBeat.m2505o(92105);
        return r;
    }

    /* renamed from: P */
    public final synchronized <A> List<C37175n<A, ?>> mo52064P(A a) {
        ArrayList arrayList;
        List list;
        List list2;
        AppMethodBeat.m2504i(92104);
        Class cls = a.getClass();
        C17537a c17537a = (C17537a) this.aEs.aEt.get(cls);
        if (c17537a == null) {
            list = null;
        } else {
            list = c17537a.aEu;
        }
        if (list == null) {
            List unmodifiableList = Collections.unmodifiableList(this.aEr.mo18641s(cls));
            if (((C17537a) this.aEs.aEt.put(cls, new C17537a(unmodifiableList))) != null) {
                IllegalStateException illegalStateException = new IllegalStateException("Already cached loaders for model: ".concat(String.valueOf(cls)));
                AppMethodBeat.m2505o(92104);
                throw illegalStateException;
            }
            list2 = unmodifiableList;
        } else {
            list2 = list;
        }
        int size = list2.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            C37175n c37175n = (C37175n) list2.get(i);
            if (c37175n.mo2224X(a)) {
                arrayList.add(c37175n);
            }
        }
        AppMethodBeat.m2505o(92104);
        return arrayList;
    }
}
