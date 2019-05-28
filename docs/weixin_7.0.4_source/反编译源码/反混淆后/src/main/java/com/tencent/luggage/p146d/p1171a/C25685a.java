package com.tencent.luggage.p146d.p1171a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.d.a.a */
public interface C25685a {
    public static final C25685a bPT = new C256861();
    public static final C25685a bPU = new C178162();

    /* renamed from: com.tencent.luggage.d.a.a$2 */
    static class C178162 implements C25685a {
        C178162() {
        }

        /* renamed from: a */
        public final void mo32974a(C45121c c45121c) {
            AppMethodBeat.m2504i(90859);
            c45121c.mo52837a(C41704b.REJECT);
            AppMethodBeat.m2505o(90859);
        }

        /* renamed from: a */
        public final void mo32975a(String str, C45121c c45121c) {
            AppMethodBeat.m2504i(90860);
            c45121c.mo52837a(C41704b.REJECT);
            AppMethodBeat.m2505o(90860);
        }
    }

    /* renamed from: com.tencent.luggage.d.a.a$1 */
    static class C256861 implements C25685a {
        C256861() {
        }

        /* renamed from: a */
        public final void mo32974a(C45121c c45121c) {
            AppMethodBeat.m2504i(90857);
            c45121c.mo52837a(C41704b.PASS);
            AppMethodBeat.m2505o(90857);
        }

        /* renamed from: a */
        public final void mo32975a(String str, C45121c c45121c) {
            AppMethodBeat.m2504i(90858);
            c45121c.mo52837a(C41704b.PASS);
            AppMethodBeat.m2505o(90858);
        }
    }

    /* renamed from: a */
    void mo32974a(C45121c c45121c);

    /* renamed from: a */
    void mo32975a(String str, C45121c c45121c);
}
