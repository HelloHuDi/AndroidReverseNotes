package com.tencent.magicbrush.d;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class b implements Runnable {
    public final FutureTask<?> bUA;

    public b(Runnable runnable) {
        AppMethodBeat.i(116009);
        this.bUA = new FutureTask(runnable, Integer.valueOf(0));
        AppMethodBeat.o(116009);
    }

    public <T> b(Callable<T> callable) {
        AppMethodBeat.i(116010);
        this.bUA = new FutureTask(callable);
        AppMethodBeat.o(116010);
    }

    public final <T> T get() {
        AppMethodBeat.i(116011);
        try {
            Object obj = this.bUA.get();
            AppMethodBeat.o(116011);
            return obj;
        } catch (InterruptedException e) {
            c.a("MagicBrush.SyncTask", e, "await failed", new Object[0]);
            AppMethodBeat.o(116011);
            return null;
        } catch (ExecutionException e2) {
            c.a("MagicBrush.SyncTask", e2, "execute failed", new Object[0]);
            AppMethodBeat.o(116011);
            return null;
        }
    }

    public void run() {
        AppMethodBeat.i(116012);
        this.bUA.run();
        AppMethodBeat.o(116012);
    }
}
