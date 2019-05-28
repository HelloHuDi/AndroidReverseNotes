package com.tencent.mm.plugin.cdndownloader.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;

public final class a {
    private static volatile al ftB;
    private static final Object iRa = new Object();

    static {
        AppMethodBeat.i(965);
        AppMethodBeat.o(965);
    }

    public static al aNS() {
        AppMethodBeat.i(964);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new al("CDNDownloader#WorkThread");
                        g.a("CDNDownloader#WorkThread", new h(ftB.oAl.getLooper(), "CDNDownloader#WorkThread"));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(964);
                    }
                }
            }
        }
        al alVar = ftB;
        AppMethodBeat.o(964);
        return alVar;
    }
}
