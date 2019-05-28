package com.tencent.magicbrush.p1173a;

import com.tencent.magicbrush.C37414c;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.a.b */
public final class C45128b {
    private static boolean bSB = false;
    private static C37410a bSC = new C178361();

    /* renamed from: com.tencent.magicbrush.a.b$1 */
    static class C178361 implements C37410a {
        C178361() {
        }

        public final void loadLibrary(String str) {
            AppMethodBeat.m2504i(115855);
            C37414c.loadLibrary(str);
            AppMethodBeat.m2505o(115855);
        }
    }

    /* renamed from: com.tencent.magicbrush.a.b$a */
    public interface C37410a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.m2504i(115858);
        AppMethodBeat.m2505o(115858);
    }

    /* renamed from: a */
    public static void m82947a(C37410a c37410a) {
        bSC = c37410a;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.m2504i(115856);
        bSC.loadLibrary(str);
        AppMethodBeat.m2505o(115856);
    }

    /* renamed from: yB */
    public static void m82948yB() {
        AppMethodBeat.m2504i(115857);
        if (bSB) {
            AppMethodBeat.m2505o(115857);
            return;
        }
        long yz = C37414c.m63043yz();
        bSC.loadLibrary("mmv8");
        long yz2 = C37414c.m63043yz();
        bSC.loadLibrary("magicbrush");
        bSB = true;
        C17837c.m27916i("MagicBrush", "load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", Long.valueOf(C37414c.m63041az(yz2)), Long.valueOf(yz2 - yz));
        AppMethodBeat.m2505o(115857);
    }
}
