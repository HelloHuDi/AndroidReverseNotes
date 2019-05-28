package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class h<_Profile extends g> {
    private static h eKy;
    private d<_Profile> eKA;
    byte[] eKB = new byte[0];
    public volatile boolean eKC = false;
    public long eKD;
    a eKE = new a();
    private c eKz = new c();

    static class a extends com.tencent.mm.ci.a<com.tencent.mm.kernel.api.g> implements com.tencent.mm.kernel.api.g {
        public a() {
            super(d.zYp);
        }

        public final void BR() {
            AppMethodBeat.i(123256);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.kernel.api.g>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(123254);
                    ((com.tencent.mm.kernel.api.g) obj).BR();
                    AppMethodBeat.o(123254);
                }
            });
            AppMethodBeat.o(123256);
        }

        public final void bi(final boolean z) {
            AppMethodBeat.i(123257);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.kernel.api.g>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(123255);
                    ((com.tencent.mm.kernel.api.g) obj).bi(z);
                    AppMethodBeat.o(123255);
                }
            });
            AppMethodBeat.o(123257);
        }
    }

    private h(_Profile _profile) {
        AppMethodBeat.i(123258);
        this.eKA = new d(_profile);
        AppMethodBeat.o(123258);
    }

    public final c RL() {
        AppMethodBeat.i(123259);
        Assert.assertNotNull("mCorePlugins not initialized!", this.eKz);
        c cVar = this.eKz;
        AppMethodBeat.o(123259);
        return cVar;
    }

    public final d<_Profile> RM() {
        AppMethodBeat.i(123260);
        Assert.assertNotNull("mCoreProcess not initialized!", this.eKA);
        d dVar = this.eKA;
        AppMethodBeat.o(123260);
        return dVar;
    }

    public static <_Profile extends g> h<_Profile> RT() {
        AppMethodBeat.i(123261);
        Assert.assertNotNull("Skeleton not initialized!", eKy);
        h hVar = eKy;
        AppMethodBeat.o(123261);
        return hVar;
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(123262);
        Object obj = null;
        synchronized (this.eKB) {
            try {
                if (this.eKC) {
                    obj = 1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123262);
            }
        }
        if (obj != null) {
            gVar.BR();
            return;
        }
        this.eKE.aD(gVar);
        AppMethodBeat.o(123262);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(123263);
        this.eKE.remove(gVar);
        AppMethodBeat.o(123263);
    }

    public static synchronized <_Profile extends g> h<_Profile> c(_Profile _profile) {
        h<_Profile> hVar;
        synchronized (h.class) {
            AppMethodBeat.i(123264);
            if (eKy != null) {
                j.i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                hVar = eKy;
                AppMethodBeat.o(123264);
            } else {
                j.i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                hVar = new h(_profile);
                eKy = hVar;
                AppMethodBeat.o(123264);
            }
        }
        return hVar;
    }

    /* JADX WARNING: Missing block: B:9:0x0024, code skipped:
            r0 = RM().Rn();
            r2 = java.lang.System.currentTimeMillis();
            com.tencent.mm.kernel.a.a.k("mmskeleton boot startup for process [%s]...", r0.eHT);
            r1 = r0.eJE;
            r1.RX();
            r4 = com.tencent.mm.vending.g.f.dMn().rg(true);
            r0.eMp.eMr = java.lang.System.currentTimeMillis();
            r1.Bd();
            r0.eMp.eMs = java.lang.System.currentTimeMillis();
            r1.Be();
            com.tencent.mm.kernel.j.jD("installPlugins");
            r0.eMp.eMt = java.lang.System.currentTimeMillis();
            r1.RY();
            r0.eMp.eMu = java.lang.System.currentTimeMillis();
            r1.a(r0);
     */
    /* JADX WARNING: Missing block: B:10:0x007b, code skipped:
            if (r10 == null) goto L_0x0080;
     */
    /* JADX WARNING: Missing block: B:11:0x007d, code skipped:
            r4.b(r10);
     */
    /* JADX WARNING: Missing block: B:12:0x0080, code skipped:
            r0.eMp.eMv = java.lang.System.currentTimeMillis();
            r4.c(new com.tencent.mm.kernel.h.AnonymousClass1(r9));
            r0.eMp.eMw = java.lang.System.currentTimeMillis();
            r4.c(new com.tencent.mm.kernel.h.AnonymousClass2(r9));
            r0.eMp.eMx = java.lang.System.currentTimeMillis();
            r4.a(com.tencent.mm.vending.h.d.zYp, new com.tencent.mm.kernel.h.AnonymousClass3(r9));
            com.tencent.matrix.trace.core.AppMethodBeat.o(123265);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(d dVar) {
        AppMethodBeat.i(123265);
        j.jD("startup");
        synchronized (this.eKB) {
            try {
                if (this.eKC) {
                    com.tencent.mm.kernel.a.a.k("warning, mmskeleton has started up already.", new Object[0]);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123265);
            }
        }
    }
}
