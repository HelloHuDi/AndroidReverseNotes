package com.tencent.mm.sdk.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.c;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class d {

    static class a implements com.tencent.mm.sdk.g.b.a {
        int cml;
        String name;
        List<al> xEL = new ArrayList();
        AtomicInteger xEM = new AtomicInteger(0);

        public a(String str, int i) {
            AppMethodBeat.i(52693);
            this.cml = i;
            this.name = str;
            reset();
            AppMethodBeat.o(52693);
        }

        public final boolean remove(Runnable runnable) {
            AppMethodBeat.i(52694);
            for (al doN : this.xEL) {
                doN.doN().removeCallbacks(runnable);
            }
            AppMethodBeat.o(52694);
            return true;
        }

        public final void shutdown() {
            AppMethodBeat.i(52695);
            for (al alVar : this.xEL) {
                alVar.oAl.quit();
            }
            AppMethodBeat.o(52695);
        }

        public final void reset() {
            AppMethodBeat.i(52696);
            this.xEL.clear();
            for (int i = 0; i < this.cml; i++) {
                this.xEL.add(new al(this.name + i));
            }
            AppMethodBeat.o(52696);
        }

        public final void p(Runnable runnable, long j) {
            AppMethodBeat.i(52697);
            ((al) this.xEL.get(this.xEM.get())).m(runnable, j);
            dqr();
            AppMethodBeat.o(52697);
        }

        public final int getCorePoolSize() {
            return this.cml;
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(52698);
            ((al) this.xEL.get(this.xEM.get())).aa(runnable);
            dqr();
            AppMethodBeat.o(52698);
        }

        private void dqr() {
            AppMethodBeat.i(52699);
            if (this.xEM.incrementAndGet() >= this.cml) {
                this.xEM.set(0);
            }
            AppMethodBeat.o(52699);
        }
    }

    public static com.tencent.mm.sdk.g.b.a a(String str, BlockingQueue<Runnable> blockingQueue) {
        AppMethodBeat.i(52700);
        if (com.tencent.mm.sdk.g.d.xDC) {
            a aVar = new a(str, 6);
            AppMethodBeat.o(52700);
            return aVar;
        }
        com.tencent.mm.sdk.g.b.a cVar = new c(str, blockingQueue);
        AppMethodBeat.o(52700);
        return cVar;
    }

    public static com.tencent.mm.sdk.g.b.a anP(String str) {
        AppMethodBeat.i(52701);
        if (com.tencent.mm.sdk.g.d.xDC) {
            a aVar = new a(str, 1);
            AppMethodBeat.o(52701);
            return aVar;
        }
        com.tencent.mm.sdk.g.b.a cVar = new c(str, 1, 1, new LinkedBlockingQueue());
        AppMethodBeat.o(52701);
        return cVar;
    }
}
