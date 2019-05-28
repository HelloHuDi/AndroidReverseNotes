package com.tencent.mm.udp.libmmudp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a ydR = new a() {
        public final void loadLibrary(String str) {
            AppMethodBeat.i(96559);
            System.loadLibrary(str);
            AppMethodBeat.o(96559);
        }
    };

    public interface a {
        void loadLibrary(String str);
    }

    static {
        AppMethodBeat.i(96561);
        AppMethodBeat.o(96561);
    }

    public static void a(a aVar) {
        ydR = aVar;
    }

    public static void yB() {
        AppMethodBeat.i(96560);
        ydR.loadLibrary("mmudp");
        AppMethodBeat.o(96560);
    }
}
