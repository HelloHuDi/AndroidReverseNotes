package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e {
    private static volatile e Avh = null;
    public String Avi = b.Avf;

    public static e dQW() {
        AppMethodBeat.i(73032);
        e eVar;
        if (Avh == null) {
            synchronized (e.class) {
                try {
                    if (Avh == null) {
                        Avh = new e();
                    }
                    eVar = Avh;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(73032);
                }
            }
            return eVar;
        }
        eVar = Avh;
        AppMethodBeat.o(73032);
        return eVar;
    }
}
