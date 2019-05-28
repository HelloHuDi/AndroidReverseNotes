package com.tencent.mm.blink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private static b ebe = new b();
    private final Queue<a> ebf = new LinkedList();
    private boolean ebg = false;
    private volatile boolean ebh = false;
    private boolean ebi = true;
    private volatile c ebj = f.dMn();
    private AtomicBoolean ebk = new AtomicBoolean(false);
    private al ebl = new al("pending-stage");

    public enum b {
        Now,
        Timeout,
        FirstScreen;

        static {
            AppMethodBeat.o(57709);
        }
    }

    static class a implements e {
        private d ceu;
        private Runnable mRunnable;

        public a(Runnable runnable, d dVar) {
            this.mRunnable = runnable;
            this.ceu = dVar;
        }

        public final Object call(Object obj) {
            AppMethodBeat.i(57705);
            ab.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", this.mRunnable, this.ceu.getType());
            this.mRunnable.run();
            AppMethodBeat.o(57705);
            return null;
        }

        public final String HZ() {
            AppMethodBeat.i(57706);
            String type;
            if (!(this.ceu instanceof com.tencent.mm.vending.h.c)) {
                type = this.ceu.getType();
                AppMethodBeat.o(57706);
                return type;
            } else if (d.dMq() instanceof com.tencent.mm.vending.h.c) {
                type = d.zYp.c;
                AppMethodBeat.o(57706);
                return type;
            } else {
                type = d.dMq().getType();
                AppMethodBeat.o(57706);
                return type;
            }
        }
    }

    public b() {
        AppMethodBeat.i(57710);
        AppMethodBeat.o(57710);
    }

    static /* synthetic */ void a(b bVar, b bVar2) {
        AppMethodBeat.i(57718);
        bVar.a(bVar2);
        AppMethodBeat.o(57718);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(57717);
        bVar.HX();
        AppMethodBeat.o(57717);
    }

    static {
        AppMethodBeat.i(57719);
        AppMethodBeat.o(57719);
    }

    public static b HQ() {
        return ebe;
    }

    public final synchronized void HR() {
        this.ebg = true;
    }

    public final synchronized void HS() {
        AppMethodBeat.i(57711);
        this.ebi = true;
        if (this.ebg) {
            HW();
        }
        AppMethodBeat.o(57711);
    }

    public final synchronized void HT() {
        this.ebi = false;
    }

    public final synchronized void HU() {
        AppMethodBeat.i(57712);
        if (this.ebg) {
            this.ebg = false;
            HW();
        }
        AppMethodBeat.o(57712);
    }

    public final synchronized void o(Runnable runnable) {
        AppMethodBeat.i(57713);
        d dMq = d.dMq();
        if (!(dMq instanceof com.tencent.mm.vending.h.c)) {
            g.a(dMq.getType(), dMq);
        }
        if (HV()) {
            ab.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement arrange runnable postToMainThread %s", runnable);
            this.ebj.c(new a(runnable, dMq));
            AppMethodBeat.o(57713);
        } else {
            ab.i("MicroMsg.FirstScreenArrangement", "arrange first screen runnable: %s, %s, %s, %s", Boolean.valueOf(this.ebg), Boolean.valueOf(this.ebi), Boolean.valueOf(this.ebh), this.ebf);
            this.ebf.add(new a(runnable, dMq));
            AppMethodBeat.o(57713);
        }
    }

    private synchronized boolean HV() {
        boolean z;
        z = (!this.ebg || this.ebi) && this.ebh;
        return z;
    }

    private void HW() {
        AppMethodBeat.i(57714);
        a(b.FirstScreen);
        HX();
        AppMethodBeat.o(57714);
    }

    /* JADX WARNING: Missing block: B:18:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(57715);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void HX() {
        AppMethodBeat.i(57715);
        if (HV()) {
            while (true) {
                a aVar = (a) this.ebf.poll();
                if (aVar == null) {
                    break;
                }
                ab.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", aVar.mRunnable, aVar.ceu.getType());
                this.ebj.c(aVar);
            }
        } else {
            AppMethodBeat.o(57715);
        }
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(57716);
        if (!this.ebk.compareAndSet(false, true)) {
            AppMethodBeat.o(57716);
        } else if (bVar == b.Now) {
            ab.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
            com.tencent.mm.kernel.a.c.Sa().Sd();
            synchronized (this) {
                try {
                    this.ebh = true;
                    HX();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57716);
                }
            }
        } else {
            h hVar = new h(new com.tencent.mm.ci.d(this.ebl.doN()), "pending-stage");
            synchronized (this) {
                try {
                    this.ebj.b(hVar).c(new com.tencent.mm.vending.c.a<Object, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(57703);
                            Object HY = HY();
                            AppMethodBeat.o(57703);
                            return HY;
                        }

                        private Object HY() {
                            AppMethodBeat.i(57702);
                            ab.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
                            com.tencent.mm.kernel.a.c.Sa().Sd();
                            synchronized (this) {
                                try {
                                    b.this.ebh = true;
                                    b.b(b.this);
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.o(57702);
                                }
                            }
                            return null;
                        }
                    });
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57716);
                }
            }
        }
    }
}
