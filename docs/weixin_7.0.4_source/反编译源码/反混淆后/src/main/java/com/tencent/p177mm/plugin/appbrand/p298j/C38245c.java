package com.tencent.p177mm.plugin.appbrand.p298j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.j.c */
final class C38245c {
    private volatile int count = 2;
    private final LinkedList<Runnable> inL = new LinkedList();

    C38245c() {
        AppMethodBeat.m2504i(102143);
        AppMethodBeat.m2505o(102143);
    }

    /* renamed from: K */
    public final void mo60983K(Runnable runnable) {
        AppMethodBeat.m2504i(102144);
        List list = null;
        synchronized (this) {
            if (runnable != null) {
                try {
                    this.inL.addLast(runnable);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(102144);
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
        AppMethodBeat.m2505o(102144);
    }
}
