package com.bumptech.glide.p086c.p090c;

import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p1157g.C17555b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.c.v */
public final class C41195v<Model> implements C37175n<Model, Model> {
    private static final C41195v<?> aEI = new C41195v();

    /* renamed from: com.bumptech.glide.c.c.v$b */
    static class C37177b<Model> implements C0742d<Model> {
        private final Model aEK;

        C37177b(Model model) {
            this.aEK = model;
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super Model> c0743a) {
            AppMethodBeat.m2504i(92141);
            c0743a.mo2189S(this.aEK);
            AppMethodBeat.m2505o(92141);
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        /* renamed from: mg */
        public final Class<Model> mo2187mg() {
            AppMethodBeat.m2504i(92142);
            Class cls = this.aEK.getClass();
            AppMethodBeat.m2505o(92142);
            return cls;
        }

        /* renamed from: mh */
        public final C25405a mo2188mh() {
            return C25405a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.v$a */
    public static class C41196a<Model> implements C31953o<Model, Model> {
        private static final C41196a<?> aEJ = new C41196a();

        static {
            AppMethodBeat.m2504i(92140);
            AppMethodBeat.m2505o(92140);
        }

        /* renamed from: nl */
        public static <T> C41196a<T> m71695nl() {
            return aEJ;
        }

        /* renamed from: a */
        public final C37175n<Model, Model> mo2219a(C8536r c8536r) {
            AppMethodBeat.m2504i(92139);
            C41195v nk = C41195v.m71692nk();
            AppMethodBeat.m2505o(92139);
            return nk;
        }
    }

    static {
        AppMethodBeat.m2504i(92144);
        AppMethodBeat.m2505o(92144);
    }

    /* renamed from: nk */
    public static <T> C41195v<T> m71692nk() {
        return aEI;
    }

    /* renamed from: b */
    public final C37176a<Model> mo2225b(Model model, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92143);
        C37176a c37176a = new C37176a(new C17555b(model), new C37177b(model));
        AppMethodBeat.m2505o(92143);
        return c37176a;
    }

    /* renamed from: X */
    public final boolean mo2224X(Model model) {
        return true;
    }
}
