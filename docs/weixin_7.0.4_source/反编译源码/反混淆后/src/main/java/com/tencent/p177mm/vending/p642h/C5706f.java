package com.tencent.p177mm.vending.p642h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C5681a;

/* renamed from: com.tencent.mm.vending.h.f */
public final class C5706f {
    private volatile C5703d zYs;
    volatile C5705a zYt;

    /* renamed from: com.tencent.mm.vending.h.f$a */
    public interface C5705a {
        /* renamed from: cT */
        void mo11596cT(Object obj);

        void dMl();

        void interrupt();
    }

    public C5706f(C5703d c5703d, C5705a c5705a) {
        AppMethodBeat.m2504i(126124);
        mo11600c(c5703d);
        this.zYt = c5705a;
        AppMethodBeat.m2505o(126124);
    }

    /* renamed from: c */
    public final synchronized void mo11600c(C5703d c5703d) {
        this.zYs = c5703d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A:{SYNTHETIC, Splitter:B:16:0x003b} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized void mo11599a(final C5681a c5681a, final Object obj, boolean z) {
        C5703d asU;
        AppMethodBeat.m2504i(126125);
        C5703d c5703d = this.zYs;
        if (c5681a instanceof C7368e) {
            C7368e c7368e = (C7368e) c5681a;
            if (!"Vending.ANY".equals(c7368e.mo4644HZ())) {
                asU = C5707g.asU(c7368e.mo4644HZ());
                if (asU != null) {
                    if (this.zYt != null) {
                        this.zYt.interrupt();
                    }
                    AppMethodBeat.m2505o(126125);
                } else {
                    final RuntimeException runtimeException = new RuntimeException("object is not right: ".concat(String.valueOf(obj)));
                    C57041 c57041 = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(126126);
                            if (C5706f.this.zYt != null) {
                                C5706f.this.zYt.dMl();
                            }
                            try {
                                Object call = c5681a.call(obj);
                                if (C5706f.this.zYt != null) {
                                    C5706f.this.zYt.mo11596cT(call);
                                }
                                AppMethodBeat.m2505o(126126);
                            } catch (ClassCastException e) {
                                runtimeException.initCause(e);
                                RuntimeException runtimeException = runtimeException;
                                AppMethodBeat.m2505o(126126);
                                throw runtimeException;
                            }
                        }
                    };
                    if (-1 >= 0) {
                        asU.mo10060l(c57041, -1);
                        AppMethodBeat.m2505o(126125);
                    } else if (z && C5707g.dMq() == asU) {
                        c57041.run();
                        AppMethodBeat.m2505o(126125);
                    } else {
                        asU.mo10061o(c57041);
                        AppMethodBeat.m2505o(126125);
                    }
                }
            }
        }
        asU = c5703d;
        if (asU != null) {
        }
    }
}
