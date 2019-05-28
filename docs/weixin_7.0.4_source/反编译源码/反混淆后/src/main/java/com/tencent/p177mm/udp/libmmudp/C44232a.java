package com.tencent.p177mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.udp.libmmudp.a */
public final class C44232a {
    private static C15451a ydR = new C360061();

    /* renamed from: com.tencent.mm.udp.libmmudp.a$a */
    public interface C15451a {
        void loadLibrary(String str);
    }

    /* renamed from: com.tencent.mm.udp.libmmudp.a$1 */
    static class C360061 implements C15451a {
        C360061() {
        }

        public final void loadLibrary(String str) {
            AppMethodBeat.m2504i(96559);
            System.loadLibrary(str);
            AppMethodBeat.m2505o(96559);
        }
    }

    static {
        AppMethodBeat.m2504i(96561);
        AppMethodBeat.m2505o(96561);
    }

    /* renamed from: a */
    public static void m79827a(C15451a c15451a) {
        ydR = c15451a;
    }

    /* renamed from: yB */
    public static void m79828yB() {
        AppMethodBeat.m2504i(96560);
        ydR.loadLibrary("mmudp");
        AppMethodBeat.m2505o(96560);
    }
}
