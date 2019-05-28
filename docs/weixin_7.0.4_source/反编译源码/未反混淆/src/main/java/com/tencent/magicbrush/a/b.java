package com.tencent.magicbrush.a;

import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static boolean bSB = false;
    private static a bSC = new a() {
        public final void loadLibrary(String str) {
            AppMethodBeat.i(115855);
            c.loadLibrary(str);
            AppMethodBeat.o(115855);
        }
    };

    public interface a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(115858);
        AppMethodBeat.o(115858);
    }

    public static void a(a aVar) {
        bSC = aVar;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(115856);
        bSC.loadLibrary(str);
        AppMethodBeat.o(115856);
    }

    public static void yB() {
        AppMethodBeat.i(115857);
        if (bSB) {
            AppMethodBeat.o(115857);
            return;
        }
        long yz = c.yz();
        bSC.loadLibrary("mmv8");
        long yz2 = c.yz();
        bSC.loadLibrary("magicbrush");
        bSB = true;
        c.c.i("MagicBrush", "load mmv8 cost [%d]ms, load magicbrush cost [%d]ms", Long.valueOf(c.az(yz2)), Long.valueOf(yz2 - yz));
        AppMethodBeat.o(115857);
    }
}
