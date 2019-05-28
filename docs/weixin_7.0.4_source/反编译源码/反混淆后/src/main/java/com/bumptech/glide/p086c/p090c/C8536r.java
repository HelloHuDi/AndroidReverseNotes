package com.bumptech.glide.p086c.p090c;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.C31976h.C17557c;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.bumptech.glide.c.c.r */
public final class C8536r {
    private static final C37175n<Object, Object> aEA = new C8537a();
    private static final C8539c aEz = new C8539c();
    private final List<C8538b<?, ?>> aEB;
    private final C8539c aEC;
    private final Set<C8538b<?, ?>> aED;
    private final C8387a<List<Throwable>> awV;

    /* renamed from: com.bumptech.glide.c.c.r$a */
    static class C8537a implements C37175n<Object, Object> {
        C8537a() {
        }

        /* renamed from: b */
        public final C37176a<Object> mo2225b(Object obj, int i, int i2, C31967j c31967j) {
            return null;
        }

        /* renamed from: X */
        public final boolean mo2224X(Object obj) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.r$b */
    static class C8538b<Model, Data> {
        final Class<Data> aBd;
        private final Class<Model> aEE;
        final C31953o<? extends Model, ? extends Data> aEF;

        public C8538b(Class<Model> cls, Class<Data> cls2, C31953o<? extends Model, ? extends Data> c31953o) {
            this.aEE = cls;
            this.aBd = cls2;
            this.aEF = c31953o;
        }

        /* renamed from: t */
        public final boolean mo18642t(Class<?> cls) {
            AppMethodBeat.m2504i(92118);
            boolean isAssignableFrom = this.aEE.isAssignableFrom(cls);
            AppMethodBeat.m2505o(92118);
            return isAssignableFrom;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.r$c */
    static class C8539c {
        C8539c() {
        }
    }

    static {
        AppMethodBeat.m2504i(92125);
        AppMethodBeat.m2505o(92125);
    }

    public C8536r(C8387a<List<Throwable>> c8387a) {
        this(c8387a, aEz);
    }

    private C8536r(C8387a<List<Throwable>> c8387a, C8539c c8539c) {
        AppMethodBeat.m2504i(92119);
        this.aEB = new ArrayList();
        this.aED = new HashSet();
        this.awV = c8387a;
        this.aEC = c8539c;
        AppMethodBeat.m2505o(92119);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: s */
    public final synchronized <Model> List<C37175n<Model, ?>> mo18641s(Class<Model> cls) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(92121);
        try {
            arrayList = new ArrayList();
            for (C8538b c8538b : this.aEB) {
                if (!this.aED.contains(c8538b) && c8538b.mo18642t(cls)) {
                    this.aED.add(c8538b);
                    arrayList.add(m15160a(c8538b));
                    this.aED.remove(c8538b);
                }
            }
            AppMethodBeat.m2505o(92121);
        } catch (Throwable th) {
            this.aED.clear();
            AppMethodBeat.m2505o(92121);
        }
        return arrayList;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: r */
    public final synchronized List<Class<?>> mo18640r(Class<?> cls) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(92122);
        arrayList = new ArrayList();
        for (C8538b c8538b : this.aEB) {
            if (!arrayList.contains(c8538b.aBd) && c8538b.mo18642t(cls)) {
                arrayList.add(c8538b.aBd);
            }
        }
        AppMethodBeat.m2505o(92122);
        return arrayList;
    }

    /* renamed from: b */
    public final synchronized <Model, Data> C37175n<Model, Data> mo18638b(Class<Model> cls, Class<Data> cls2) {
        C37175n<Model, Data> c25435q;
        AppMethodBeat.m2504i(92123);
        try {
            ArrayList arrayList = new ArrayList();
            Object obj = null;
            for (C8538b c8538b : this.aEB) {
                if (this.aED.contains(c8538b)) {
                    obj = 1;
                } else {
                    Object obj2;
                    if (c8538b.mo18642t(cls) && c8538b.aBd.isAssignableFrom(cls2)) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        this.aED.add(c8538b);
                        arrayList.add(m15160a(c8538b));
                        this.aED.remove(c8538b);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c25435q = new C25435q(arrayList, this.awV);
                AppMethodBeat.m2505o(92123);
            } else if (arrayList.size() == 1) {
                c25435q = (C37175n) arrayList.get(0);
                AppMethodBeat.m2505o(92123);
            } else if (obj != null) {
                c25435q = aEA;
                AppMethodBeat.m2505o(92123);
            } else {
                C17557c c17557c = new C17557c(cls, cls2);
                AppMethodBeat.m2505o(92123);
                throw c17557c;
            }
        } catch (Throwable th) {
            this.aED.clear();
            AppMethodBeat.m2505o(92123);
        }
        return c25435q;
    }

    /* renamed from: a */
    private <Model, Data> C37175n<Model, Data> m15160a(C8538b<?, ?> c8538b) {
        AppMethodBeat.m2504i(92124);
        C37175n c37175n = (C37175n) C8561i.m15217d(c8538b.aEF.mo2219a(this), "Argument must not be null");
        AppMethodBeat.m2505o(92124);
        return c37175n;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: b */
    public final synchronized <Model, Data> void mo18639b(Class<Model> cls, Class<Data> cls2, C31953o<? extends Model, ? extends Data> c31953o) {
        AppMethodBeat.m2504i(92120);
        this.aEB.add(this.aEB.size(), new C8538b(cls, cls2, c31953o));
        AppMethodBeat.m2505o(92120);
    }
}
