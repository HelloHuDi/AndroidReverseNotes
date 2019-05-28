package com.tencent.p177mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44051u;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.b */
public final class C44022b {
    public static Object lock = new Object();
    private static volatile C44022b uVM;
    C40396h uVN = new C40396h(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new C44051u("WepkgDownloaderPool", "WepkgDownloaderThread"));

    static {
        AppMethodBeat.m2504i(63420);
        AppMethodBeat.m2505o(63420);
    }

    public static C44022b dgu() {
        AppMethodBeat.m2504i(63418);
        if (uVM == null) {
            synchronized (lock) {
                try {
                    if (uVM == null) {
                        uVM = new C44022b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63418);
                    }
                }
            }
        }
        C44022b c44022b = uVM;
        AppMethodBeat.m2505o(63418);
        return c44022b;
    }

    private C44022b() {
        AppMethodBeat.m2504i(63419);
        AppMethodBeat.m2505o(63419);
    }
}
