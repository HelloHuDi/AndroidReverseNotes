package com.tencent.mm.plugin.game.commlib.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;

public final class a {
    private static volatile al ftB;
    private static final Object iRa = new Object();

    static {
        AppMethodBeat.i(59425);
        AppMethodBeat.o(59425);
    }

    public static void aNR() {
        AppMethodBeat.i(59424);
        if (ftB == null) {
            AppMethodBeat.o(59424);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    g.asT("GameCommLib#WorkThread");
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59424);
            }
        }
    }
}
