package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

final class c {
    private volatile int count = 2;
    private final LinkedList<Runnable> inL = new LinkedList();

    c() {
        AppMethodBeat.i(102143);
        AppMethodBeat.o(102143);
    }

    public final void K(Runnable runnable) {
        AppMethodBeat.i(102144);
        List list = null;
        synchronized (this) {
            if (runnable != null) {
                try {
                    this.inL.addLast(runnable);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(102144);
                    }
                }
            }
            int i = this.count - 1;
            this.count = i;
            if (i <= 0 && this.inL.size() > 0) {
                list = new LinkedList();
                list.addAll(this.inL);
                this.inL.clear();
            }
        }
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
        }
        AppMethodBeat.o(102144);
    }
}
