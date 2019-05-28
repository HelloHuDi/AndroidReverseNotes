package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h {
    private static volatile a Avj = new a() {
        private boolean Avk = false;

        public final void dQZ() {
            AppMethodBeat.i(73039);
            d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.Avk = true;
            AppMethodBeat.o(73039);
        }

        public final boolean dQY() {
            return this.Avk;
        }
    };

    public interface a {
        boolean dQY();

        void dQZ();
    }

    static {
        AppMethodBeat.i(73043);
        AppMethodBeat.o(73043);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(73040);
        Assert.assertNotNull(aVar);
        Avj = aVar;
        AppMethodBeat.o(73040);
    }

    public static void dQX() {
        AppMethodBeat.i(73041);
        Avj.dQZ();
        AppMethodBeat.o(73041);
    }

    public static boolean dQY() {
        AppMethodBeat.i(73042);
        boolean dQY = Avj.dQY();
        AppMethodBeat.o(73042);
        return dQY;
    }
}
