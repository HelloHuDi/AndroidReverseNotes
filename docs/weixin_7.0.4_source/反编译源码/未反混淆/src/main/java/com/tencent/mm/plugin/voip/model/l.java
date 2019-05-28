package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantLock;

public final class l {
    private static l sPJ = new l();
    private ReentrantLock cbR = new ReentrantLock();
    private k sPK;

    static {
        AppMethodBeat.i(4435);
        AppMethodBeat.o(4435);
    }

    private l() {
        AppMethodBeat.i(4433);
        AppMethodBeat.o(4433);
    }

    public static k cIW() {
        AppMethodBeat.i(4434);
        if (sPJ.sPK == null) {
            sPJ.cbR.lock();
            try {
                if (sPJ.sPK == null) {
                    sPJ.sPK = new k();
                }
                sPJ.cbR.unlock();
            } catch (Throwable th) {
                sPJ.cbR.unlock();
                AppMethodBeat.o(4434);
            }
        }
        k kVar = sPJ.sPK;
        AppMethodBeat.o(4434);
        return kVar;
    }
}
