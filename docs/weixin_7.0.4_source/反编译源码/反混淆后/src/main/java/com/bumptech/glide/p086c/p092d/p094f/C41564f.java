package com.bumptech.glide.p086c.p092d.p094f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.d.f.f */
public final class C41564f {
    private final List<C0775a<?, ?>> aGs = new ArrayList();

    /* renamed from: com.bumptech.glide.c.d.f.f$a */
    static final class C0775a<Z, R> {
        final C8553e<Z, R> aBf;
        private final Class<Z> aGt;
        private final Class<R> aGu;

        C0775a(Class<Z> cls, Class<R> cls2, C8553e<Z, R> c8553e) {
            this.aGt = cls;
            this.aGu = cls2;
            this.aBf = c8553e;
        }

        /* renamed from: e */
        public final boolean mo2238e(Class<?> cls, Class<?> cls2) {
            AppMethodBeat.m2504i(92365);
            if (this.aGt.isAssignableFrom(cls) && cls2.isAssignableFrom(this.aGu)) {
                AppMethodBeat.m2505o(92365);
                return true;
            }
            AppMethodBeat.m2505o(92365);
            return false;
        }
    }

    public C41564f() {
        AppMethodBeat.m2504i(92366);
        AppMethodBeat.m2505o(92366);
    }

    /* renamed from: b */
    public final synchronized <Z, R> void mo66577b(Class<Z> cls, Class<R> cls2, C8553e<Z, R> c8553e) {
        AppMethodBeat.m2504i(92367);
        this.aGs.add(new C0775a(cls, cls2, c8553e));
        AppMethodBeat.m2505o(92367);
    }

    /* renamed from: c */
    public final synchronized <Z, R> C8553e<Z, R> mo66578c(Class<Z> cls, Class<R> cls2) {
        C8553e<Z, R> nH;
        AppMethodBeat.m2504i(92368);
        if (cls2.isAssignableFrom(cls)) {
            nH = C41565g.m72762nH();
            AppMethodBeat.m2505o(92368);
        } else {
            for (C0775a c0775a : this.aGs) {
                if (c0775a.mo2238e(cls, cls2)) {
                    nH = c0775a.aBf;
                    AppMethodBeat.m2505o(92368);
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
            AppMethodBeat.m2505o(92368);
            throw illegalArgumentException;
        }
        return nH;
    }

    /* renamed from: d */
    public final synchronized <Z, R> List<Class<R>> mo66579d(Class<Z> cls, Class<R> cls2) {
        List<Class<R>> list;
        AppMethodBeat.m2504i(92369);
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            AppMethodBeat.m2505o(92369);
            list = arrayList;
        } else {
            for (C0775a e : this.aGs) {
                if (e.mo2238e(cls, cls2)) {
                    arrayList.add(cls2);
                }
            }
            AppMethodBeat.m2505o(92369);
            Object list2 = arrayList;
        }
        return list2;
    }
}
