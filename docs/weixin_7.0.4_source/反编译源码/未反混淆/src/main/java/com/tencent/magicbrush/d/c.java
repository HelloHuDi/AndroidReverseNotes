package com.tencent.magicbrush.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class c {

    static class a {
        private static final Handler sMainHandler = new Handler(Looper.getMainLooper());

        static {
            AppMethodBeat.i(116013);
            AppMethodBeat.o(116013);
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(116014);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.o(116014);
            return;
        }
        a.sMainHandler.post(runnable);
        AppMethodBeat.o(116014);
    }

    public static <T> T b(Callable<T> callable) {
        AppMethodBeat.i(116015);
        b bVar = new b((Callable) callable);
        runOnUiThread(bVar);
        Object obj = bVar.get();
        AppMethodBeat.o(116015);
        return obj;
    }
}
