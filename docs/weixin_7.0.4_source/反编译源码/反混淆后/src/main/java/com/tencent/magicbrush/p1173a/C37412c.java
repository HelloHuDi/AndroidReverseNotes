package com.tencent.magicbrush.p1173a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.a.c */
public final class C37412c {

    /* renamed from: com.tencent.magicbrush.a.c$c */
    public static class C17837c {
        private static C37413b bSD = new C37411a();

        static {
            AppMethodBeat.m2504i(115871);
            AppMethodBeat.m2505o(115871);
        }

        /* renamed from: a */
        public static void m27912a(C37413b c37413b) {
            bSD = c37413b;
        }

        /* renamed from: v */
        public static void m27917v(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115865);
            bSD.mo5985v(str, str2, objArr);
            AppMethodBeat.m2505o(115865);
        }

        /* renamed from: d */
        public static void m27914d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115866);
            bSD.mo5982d(str, str2, objArr);
            AppMethodBeat.m2505o(115866);
        }

        /* renamed from: i */
        public static void m27916i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115867);
            bSD.mo5984i(str, str2, objArr);
            AppMethodBeat.m2505o(115867);
        }

        /* renamed from: w */
        public static void m27918w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115868);
            bSD.mo5986w(str, str2, objArr);
            AppMethodBeat.m2505o(115868);
        }

        /* renamed from: e */
        public static void m27915e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115869);
            bSD.mo5983e(str, str2, objArr);
            AppMethodBeat.m2505o(115869);
        }

        /* renamed from: a */
        public static void m27913a(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115870);
            bSD.mo5981a(str, th, str2, objArr);
            AppMethodBeat.m2505o(115870);
        }
    }

    /* renamed from: com.tencent.magicbrush.a.c$a */
    static class C37411a implements C37413b {
        private C37411a() {
        }

        /* synthetic */ C37411a(byte b) {
            this();
        }

        /* renamed from: v */
        public final void mo5985v(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115859);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.m2505o(115859);
                    return;
                }
            }
            AppMethodBeat.m2505o(115859);
        }

        /* renamed from: d */
        public final void mo5982d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115860);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.m2505o(115860);
                    return;
                }
            }
            AppMethodBeat.m2505o(115860);
        }

        /* renamed from: i */
        public final void mo5984i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115861);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.m2505o(115861);
                    return;
                }
            }
            AppMethodBeat.m2505o(115861);
        }

        /* renamed from: w */
        public final void mo5986w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115862);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.m2505o(115862);
                    return;
                }
            }
            AppMethodBeat.m2505o(115862);
        }

        /* renamed from: e */
        public final void mo5983e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115863);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.m2505o(115863);
                    return;
                }
            }
            AppMethodBeat.m2505o(115863);
        }

        /* renamed from: a */
        public final void mo5981a(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(115864);
            if (th != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            String.format(str2, objArr);
                        }
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.m2505o(115864);
                return;
            }
            AppMethodBeat.m2505o(115864);
        }
    }

    /* renamed from: com.tencent.magicbrush.a.c$b */
    public interface C37413b {
        /* renamed from: a */
        void mo5981a(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: d */
        void mo5982d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo5983e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo5984i(String str, String str2, Object... objArr);

        /* renamed from: v */
        void mo5985v(String str, String str2, Object... objArr);

        /* renamed from: w */
        void mo5986w(String str, String str2, Object... objArr);
    }
}
