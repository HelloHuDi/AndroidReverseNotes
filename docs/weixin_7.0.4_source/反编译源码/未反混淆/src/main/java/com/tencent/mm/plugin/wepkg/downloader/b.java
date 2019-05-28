package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.u;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class b {
    public static Object lock = new Object();
    private static volatile b uVM;
    h uVN = new h(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new u("WepkgDownloaderPool", "WepkgDownloaderThread"));

    static {
        AppMethodBeat.i(63420);
        AppMethodBeat.o(63420);
    }

    public static b dgu() {
        AppMethodBeat.i(63418);
        if (uVM == null) {
            synchronized (lock) {
                try {
                    if (uVM == null) {
                        uVM = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63418);
                    }
                }
            }
        }
        b bVar = uVM;
        AppMethodBeat.o(63418);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(63419);
        AppMethodBeat.o(63419);
    }
}
