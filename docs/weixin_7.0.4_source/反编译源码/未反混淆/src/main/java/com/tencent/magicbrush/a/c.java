package com.tencent.magicbrush.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public static class c {
        private static b bSD = new a();

        static {
            AppMethodBeat.i(115871);
            AppMethodBeat.o(115871);
        }

        public static void a(b bVar) {
            bSD = bVar;
        }

        public static void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115865);
            bSD.v(str, str2, objArr);
            AppMethodBeat.o(115865);
        }

        public static void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115866);
            bSD.d(str, str2, objArr);
            AppMethodBeat.o(115866);
        }

        public static void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115867);
            bSD.i(str, str2, objArr);
            AppMethodBeat.o(115867);
        }

        public static void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115868);
            bSD.w(str, str2, objArr);
            AppMethodBeat.o(115868);
        }

        public static void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115869);
            bSD.e(str, str2, objArr);
            AppMethodBeat.o(115869);
        }

        public static void a(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(115870);
            bSD.a(str, th, str2, objArr);
            AppMethodBeat.o(115870);
        }
    }

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115859);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(115859);
                    return;
                }
            }
            AppMethodBeat.o(115859);
        }

        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115860);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(115860);
                    return;
                }
            }
            AppMethodBeat.o(115860);
        }

        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115861);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(115861);
                    return;
                }
            }
            AppMethodBeat.o(115861);
        }

        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115862);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(115862);
                    return;
                }
            }
            AppMethodBeat.o(115862);
        }

        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(115863);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(115863);
                    return;
                }
            }
            AppMethodBeat.o(115863);
        }

        public final void a(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(115864);
            if (th != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            String.format(str2, objArr);
                        }
                    } catch (Exception e) {
                    }
                }
                AppMethodBeat.o(115864);
                return;
            }
            AppMethodBeat.o(115864);
        }
    }

    public interface b {
        void a(String str, Throwable th, String str2, Object... objArr);

        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }
}
