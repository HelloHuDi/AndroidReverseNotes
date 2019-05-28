package com.tencent.p177mm.plugin.appbrand.p298j;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.j.a */
public interface C42458a {

    /* renamed from: com.tencent.mm.plugin.appbrand.j.a$d */
    public enum C10278d {
        OK,
        FAIL,
        CANCEL;

        static {
            AppMethodBeat.m2505o(87007);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.j.a$a */
    public interface C42456a {
        /* renamed from: b */
        void mo34550b(C45569d c45569d);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.j.a$b */
    public interface C42457b {
        /* renamed from: a */
        void mo44661a(C10278d c10278d);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.j.a$c */
    public static class C42459c implements C42458a {
        public final boolean aIy() {
            return false;
        }

        /* renamed from: CC */
        public final String mo44653CC(String str) {
            return "__APP__";
        }

        /* renamed from: a */
        public void mo44657a(String str, boolean z, C42457b c42457b, C42456a c42456a) {
            AppMethodBeat.m2504i(87003);
            if (c42457b != null) {
                c42457b.mo44661a(C10278d.OK);
            }
            AppMethodBeat.m2505o(87003);
        }

        /* renamed from: a */
        public final void mo44656a(String str, boolean z, C42457b c42457b) {
            AppMethodBeat.m2504i(87004);
            mo44657a(str, z, c42457b, null);
            AppMethodBeat.m2505o(87004);
        }
    }

    /* renamed from: CC */
    String mo44653CC(String str);

    /* renamed from: a */
    void mo44656a(String str, boolean z, C42457b c42457b);

    /* renamed from: a */
    void mo44657a(String str, boolean z, C42457b c42457b, C42456a c42456a);

    boolean aIy();
}
