package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class k {
    static int hVZ;
    private j hVu;
    final List<ah> hWa;
    Runnable hWb;

    static class a {
        static k hWd = new k();

        static {
            AppMethodBeat.i(126399);
            AppMethodBeat.o(126399);
        }
    }

    /* synthetic */ k(byte b) {
        this();
    }

    private k() {
        AppMethodBeat.i(126400);
        this.hWa = new LinkedList();
        hVZ = i.hVW.aEO();
        this.hWb = new Runnable() {
            /* JADX WARNING: Missing block: B:9:0x002f, code skipped:
            r0.aCj();
            com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", r0.getName(), java.lang.Integer.valueOf(r2));
            r1 = r7.hWc.hWa;
     */
            /* JADX WARNING: Missing block: B:10:0x004f, code skipped:
            monitor-enter(r1);
     */
            /* JADX WARNING: Missing block: B:12:?, code skipped:
            r0 = r7.hWc.hWa.isEmpty();
     */
            /* JADX WARNING: Missing block: B:13:0x0058, code skipped:
            monitor-exit(r1);
     */
            /* JADX WARNING: Missing block: B:14:0x0059, code skipped:
            if (r0 != false) goto L_0x0065;
     */
            /* JADX WARNING: Missing block: B:15:0x005b, code skipped:
            com.tencent.mm.plugin.appbrand.r.m.aNS().m(r7, (long) com.tencent.mm.plugin.appbrand.jsapi.p.k.hVZ);
     */
            /* JADX WARNING: Missing block: B:16:0x0065, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(126397);
     */
            /* JADX WARNING: Missing block: B:24:0x0071, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(126397);
     */
            /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(126397);
                synchronized (k.this.hWa) {
                    try {
                        if (k.this.hWa.isEmpty()) {
                        } else {
                            ah ahVar = (ah) k.this.hWa.remove(0);
                            int size = k.this.hWa.size();
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(126397);
                    }
                }
            }
        };
        this.hVu = new j((long) hVZ, new com.tencent.mm.plugin.appbrand.s.j.a() {
            public final boolean j(Object... objArr) {
                AppMethodBeat.i(126398);
                synchronized (k.this.hWa) {
                    try {
                        if (!k.this.hWa.isEmpty()) {
                            k.this.hWb.run();
                            AppMethodBeat.o(126398);
                            return true;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(126398);
                    }
                }
                return false;
            }
        });
        AppMethodBeat.o(126400);
    }

    public final boolean a(ah ahVar, c cVar) {
        AppMethodBeat.i(126401);
        if (ahVar == null) {
            AppMethodBeat.o(126401);
            return false;
        } else if (i.hVW.a(cVar, ahVar)) {
            boolean isEmpty;
            synchronized (this.hWa) {
                try {
                    isEmpty = this.hWa.isEmpty();
                    if (this.hWa.isEmpty()) {
                        this.hWa.add(ahVar);
                    } else if (((ah) this.hWa.get(0)).equals(ahVar)) {
                        this.hWa.add(0, ahVar);
                        this.hWa.remove(1);
                    } else {
                        this.hWa.remove(ahVar);
                        this.hWa.add(ahVar);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(126401);
                }
            }
            if (isEmpty && !this.hVu.l(new Object[0])) {
                ab.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", ahVar.getName());
                m.aNS().m(this.hWb, (long) hVZ);
            }
            AppMethodBeat.o(126401);
            return true;
        } else {
            AppMethodBeat.o(126401);
            return false;
        }
    }
}
