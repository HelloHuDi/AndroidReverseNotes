package com.tencent.p177mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.vending.p642h.C5703d;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.h */
public final class C1728h<_Profile extends C1681g> {
    private static C1728h eKy;
    private C1701d<_Profile> eKA;
    byte[] eKB = new byte[0];
    public volatile boolean eKC = false;
    public long eKD;
    C1732a eKE = new C1732a();
    private C1699c eKz = new C1699c();

    /* renamed from: com.tencent.mm.kernel.h$a */
    static class C1732a extends C6454a<C1675g> implements C1675g {

        /* renamed from: com.tencent.mm.kernel.h$a$1 */
        class C17331 implements C1387a<C1675g> {
            C17331() {
            }

            /* renamed from: ax */
            public final /* synthetic */ void mo4769ax(Object obj) {
                AppMethodBeat.m2504i(123254);
                ((C1675g) obj).mo5176BR();
                AppMethodBeat.m2505o(123254);
            }
        }

        public C1732a() {
            super(C5703d.zYp);
        }

        /* renamed from: BR */
        public final void mo5176BR() {
            AppMethodBeat.m2504i(123256);
            mo14669a(new C17331());
            AppMethodBeat.m2505o(123256);
        }

        /* renamed from: bi */
        public final void mo5177bi(final boolean z) {
            AppMethodBeat.m2504i(123257);
            mo14669a(new C1387a<C1675g>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(123255);
                    ((C1675g) obj).mo5177bi(z);
                    AppMethodBeat.m2505o(123255);
                }
            });
            AppMethodBeat.m2505o(123257);
        }
    }

    private C1728h(_Profile _profile) {
        AppMethodBeat.m2504i(123258);
        this.eKA = new C1701d(_profile);
        AppMethodBeat.m2505o(123258);
    }

    /* renamed from: RL */
    public final C1699c mo5265RL() {
        AppMethodBeat.m2504i(123259);
        Assert.assertNotNull("mCorePlugins not initialized!", this.eKz);
        C1699c c1699c = this.eKz;
        AppMethodBeat.m2505o(123259);
        return c1699c;
    }

    /* renamed from: RM */
    public final C1701d<_Profile> mo5266RM() {
        AppMethodBeat.m2504i(123260);
        Assert.assertNotNull("mCoreProcess not initialized!", this.eKA);
        C1701d c1701d = this.eKA;
        AppMethodBeat.m2505o(123260);
        return c1701d;
    }

    /* renamed from: RT */
    public static <_Profile extends C1681g> C1728h<_Profile> m3566RT() {
        AppMethodBeat.m2504i(123261);
        Assert.assertNotNull("Skeleton not initialized!", eKy);
        C1728h c1728h = eKy;
        AppMethodBeat.m2505o(123261);
        return c1728h;
    }

    /* renamed from: a */
    public final void mo5267a(C1675g c1675g) {
        AppMethodBeat.m2504i(123262);
        Object obj = null;
        synchronized (this.eKB) {
            try {
                if (this.eKC) {
                    obj = 1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123262);
            }
        }
        if (obj != null) {
            c1675g.mo5176BR();
            return;
        }
        this.eKE.mo14670aD(c1675g);
        AppMethodBeat.m2505o(123262);
    }

    /* renamed from: b */
    public final void mo5269b(C1675g c1675g) {
        AppMethodBeat.m2504i(123263);
        this.eKE.remove(c1675g);
        AppMethodBeat.m2505o(123263);
    }

    /* renamed from: c */
    public static synchronized <_Profile extends C1681g> C1728h<_Profile> m3567c(_Profile _profile) {
        C1728h<_Profile> c1728h;
        synchronized (C1728h.class) {
            AppMethodBeat.m2504i(123264);
            if (eKy != null) {
                C1736j.m3587i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                c1728h = eKy;
                AppMethodBeat.m2505o(123264);
            } else {
                C1736j.m3587i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                c1728h = new C1728h(_profile);
                eKy = c1728h;
                AppMethodBeat.m2505o(123264);
            }
        }
        return c1728h;
    }

    /* JADX WARNING: Missing block: B:9:0x0024, code skipped:
            r0 = mo5266RM().mo5224Rn();
            r2 = java.lang.System.currentTimeMillis();
            com.tencent.p177mm.kernel.p238a.C1651a.m3339k("mmskeleton boot startup for process [%s]...", r0.eHT);
            r1 = r0.eJE;
            r1.mo5125RX();
            r4 = com.tencent.p177mm.vending.p641g.C5698f.dMn().mo15898rg(true);
            r0.eMp.eMr = java.lang.System.currentTimeMillis();
            r1.mo5123Bd();
            r0.eMp.eMs = java.lang.System.currentTimeMillis();
            r1.mo5124Be();
            com.tencent.p177mm.kernel.C1736j.m3588jD("installPlugins");
            r0.eMp.eMt = java.lang.System.currentTimeMillis();
            r1.mo5126RY();
            r0.eMp.eMu = java.lang.System.currentTimeMillis();
            r1.mo5128a(r0);
     */
    /* JADX WARNING: Missing block: B:10:0x007b, code skipped:
            if (r10 == null) goto L_0x0080;
     */
    /* JADX WARNING: Missing block: B:11:0x007d, code skipped:
            r4.mo15891b(r10);
     */
    /* JADX WARNING: Missing block: B:12:0x0080, code skipped:
            r0.eMp.eMv = java.lang.System.currentTimeMillis();
            r4.mo15892c(new com.tencent.p177mm.kernel.C1728h.C17291(r9));
            r0.eMp.eMw = java.lang.System.currentTimeMillis();
            r4.mo15892c(new com.tencent.p177mm.kernel.C1728h.C17302(r9));
            r0.eMp.eMx = java.lang.System.currentTimeMillis();
            r4.mo11588a(com.tencent.p177mm.vending.p642h.C5703d.zYp, new com.tencent.p177mm.kernel.C1728h.C17313(r9));
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(123265);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo5268a(C5703d c5703d) {
        AppMethodBeat.m2504i(123265);
        C1736j.m3588jD("startup");
        synchronized (this.eKB) {
            try {
                if (this.eKC) {
                    C1651a.m3339k("warning, mmskeleton has started up already.", new Object[0]);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123265);
            }
        }
    }
}
