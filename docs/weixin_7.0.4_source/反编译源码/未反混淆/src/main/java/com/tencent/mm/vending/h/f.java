package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    private volatile d zYs;
    volatile a zYt;

    public interface a {
        void cT(Object obj);

        void dMl();

        void interrupt();
    }

    public f(d dVar, a aVar) {
        AppMethodBeat.i(126124);
        c(dVar);
        this.zYt = aVar;
        AppMethodBeat.o(126124);
    }

    public final synchronized void c(d dVar) {
        this.zYs = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A:{SYNTHETIC, Splitter:B:16:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final com.tencent.mm.vending.c.a aVar, final Object obj, boolean z) {
        d asU;
        AppMethodBeat.i(126125);
        d dVar = this.zYs;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (!"Vending.ANY".equals(eVar.HZ())) {
                asU = g.asU(eVar.HZ());
                if (asU != null) {
                    if (this.zYt != null) {
                        this.zYt.interrupt();
                    }
                    AppMethodBeat.o(126125);
                } else {
                    final RuntimeException runtimeException = new RuntimeException("object is not right: ".concat(String.valueOf(obj)));
                    AnonymousClass1 anonymousClass1 = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(126126);
                            if (f.this.zYt != null) {
                                f.this.zYt.dMl();
                            }
                            try {
                                Object call = aVar.call(obj);
                                if (f.this.zYt != null) {
                                    f.this.zYt.cT(call);
                                }
                                AppMethodBeat.o(126126);
                            } catch (ClassCastException e) {
                                runtimeException.initCause(e);
                                RuntimeException runtimeException = runtimeException;
                                AppMethodBeat.o(126126);
                                throw runtimeException;
                            }
                        }
                    };
                    if (-1 >= 0) {
                        asU.l(anonymousClass1, -1);
                        AppMethodBeat.o(126125);
                    } else if (z && g.dMq() == asU) {
                        anonymousClass1.run();
                        AppMethodBeat.o(126125);
                    } else {
                        asU.o(anonymousClass1);
                        AppMethodBeat.o(126125);
                    }
                }
            }
        }
        asU = dVar;
        if (asU != null) {
        }
    }
}
