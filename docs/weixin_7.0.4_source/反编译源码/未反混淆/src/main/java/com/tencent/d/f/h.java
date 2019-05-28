package com.tencent.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    private static boolean Auy;
    private static g Auz;

    static {
        AppMethodBeat.i(114620);
        Auy = false;
        Auz = new k();
        Auy = false;
        Auz = new k();
        AppMethodBeat.o(114620);
    }

    public static void w(Throwable th) {
        AppMethodBeat.i(114617);
        db(th);
        AppMethodBeat.o(114617);
    }

    public static void db(Object obj) {
        AppMethodBeat.i(114618);
        if (obj == null || !(obj instanceof Exception)) {
            AppMethodBeat.o(114618);
            return;
        }
        new StringBuilder().append(obj);
        AppMethodBeat.o(114618);
    }

    public static void dc(Object obj) {
        AppMethodBeat.i(114619);
        if (obj == null || !(obj instanceof Exception)) {
            AppMethodBeat.o(114619);
            return;
        }
        new StringBuilder().append(obj);
        AppMethodBeat.o(114619);
    }

    public static void dQG() {
    }

    public static void dQH() {
    }

    public static void dQI() {
    }
}
