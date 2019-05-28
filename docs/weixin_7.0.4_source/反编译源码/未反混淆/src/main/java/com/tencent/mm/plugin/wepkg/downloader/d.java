package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class d {
    private static Object lock = new Object();
    private static volatile d uVX;
    HashMap<String, c> uVY = new HashMap();

    static {
        AppMethodBeat.i(63430);
        AppMethodBeat.o(63430);
    }

    public static d dgw() {
        AppMethodBeat.i(63426);
        if (uVX == null) {
            synchronized (lock) {
                try {
                    if (uVX == null) {
                        uVX = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63426);
                    }
                }
            }
        }
        d dVar = uVX;
        AppMethodBeat.o(63426);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(63427);
        AppMethodBeat.o(63427);
    }

    public final boolean ahO(String str) {
        AppMethodBeat.i(63428);
        if (this.uVY.containsKey(str)) {
            this.uVY.remove(str);
        }
        AppMethodBeat.o(63428);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(c cVar) {
        AppMethodBeat.i(63429);
        if (this.uVY.containsKey(cVar.uVO.uWo)) {
            cVar.uVU = true;
            try {
                if (cVar.uVQ != null) {
                    cVar.uVQ.disconnect();
                }
                if (cVar.uVP != null) {
                    cVar.uVP.cancel(false);
                }
            } catch (Exception e) {
                ab.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + e.getMessage());
            }
            this.uVY.remove(cVar.uVO.uWo);
            AppMethodBeat.o(63429);
            return true;
        }
        AppMethodBeat.o(63429);
        return false;
    }
}
