package com.tencent.magicbrush.p821d;

import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.tencent.magicbrush.d.b */
public class C25714b implements Runnable {
    public final FutureTask<?> bUA;

    public C25714b(Runnable runnable) {
        AppMethodBeat.m2504i(116009);
        this.bUA = new FutureTask(runnable, Integer.valueOf(0));
        AppMethodBeat.m2505o(116009);
    }

    public <T> C25714b(Callable<T> callable) {
        AppMethodBeat.m2504i(116010);
        this.bUA = new FutureTask(callable);
        AppMethodBeat.m2505o(116010);
    }

    public final <T> T get() {
        AppMethodBeat.m2504i(116011);
        try {
            Object obj = this.bUA.get();
            AppMethodBeat.m2505o(116011);
            return obj;
        } catch (InterruptedException e) {
            C17837c.m27913a("MagicBrush.SyncTask", e, "await failed", new Object[0]);
            AppMethodBeat.m2505o(116011);
            return null;
        } catch (ExecutionException e2) {
            C17837c.m27913a("MagicBrush.SyncTask", e2, "execute failed", new Object[0]);
            AppMethodBeat.m2505o(116011);
            return null;
        }
    }

    public void run() {
        AppMethodBeat.m2504i(116012);
        this.bUA.run();
        AppMethodBeat.m2505o(116012);
    }
}
