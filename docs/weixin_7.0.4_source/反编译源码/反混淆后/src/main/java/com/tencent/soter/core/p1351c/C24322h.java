package com.tencent.soter.core.p1351c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

/* renamed from: com.tencent.soter.core.c.h */
public final class C24322h {
    private static volatile C24324a Avj = new C243231();

    /* renamed from: com.tencent.soter.core.c.h$1 */
    static class C243231 implements C24324a {
        private boolean Avk = false;

        C243231() {
        }

        public final void dQZ() {
            AppMethodBeat.m2504i(73039);
            C44476d.m80483e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.Avk = true;
            AppMethodBeat.m2505o(73039);
        }

        public final boolean dQY() {
            return this.Avk;
        }
    }

    /* renamed from: com.tencent.soter.core.c.h$a */
    public interface C24324a {
        boolean dQY();

        void dQZ();
    }

    static {
        AppMethodBeat.m2504i(73043);
        AppMethodBeat.m2505o(73043);
    }

    /* renamed from: a */
    public static void m37493a(C24324a c24324a) {
        AppMethodBeat.m2504i(73040);
        Assert.assertNotNull(c24324a);
        Avj = c24324a;
        AppMethodBeat.m2505o(73040);
    }

    public static void dQX() {
        AppMethodBeat.m2504i(73041);
        Avj.dQZ();
        AppMethodBeat.m2505o(73041);
    }

    public static boolean dQY() {
        AppMethodBeat.m2504i(73042);
        boolean dQY = Avj.dQY();
        AppMethodBeat.m2505o(73042);
        return dQY;
    }
}
