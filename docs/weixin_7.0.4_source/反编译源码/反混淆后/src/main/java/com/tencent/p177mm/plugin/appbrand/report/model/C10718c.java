package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.report.C19695l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.c */
public final class C10718c {
    public final C19695l iAS;
    private volatile String iAT;
    volatile long iAU = 0;
    private volatile long iAV = 0;
    private final LinkedList<Runnable> iAW = new LinkedList();
    public volatile String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.c$1 */
    class C107191 implements Runnable {
        C107191() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114412);
            C10718c.this.aLl();
            AppMethodBeat.m2505o(114412);
        }
    }

    public C10718c(int i) {
        AppMethodBeat.m2504i(114413);
        this.iAS = new C19695l("MicroMsg.AppBrandPageViewStatistics[" + i + "]");
        AppMethodBeat.m2505o(114413);
    }

    public final boolean isLoading() {
        return this.iAU > 0 && this.iAV <= 0;
    }

    public final long aLi() {
        AppMethodBeat.m2504i(114414);
        long max = Math.max(0, this.iAV);
        AppMethodBeat.m2505o(114414);
        return max;
    }

    /* renamed from: DB */
    public final void mo22264DB(String str) {
        AppMethodBeat.m2504i(114415);
        this.iAU = C5046bo.anU();
        this.iAT = str;
        AppMethodBeat.m2505o(114415);
    }

    public final void aLj() {
        AppMethodBeat.m2504i(114416);
        this.iAV = C5046bo.anU() - this.iAU;
        AppMethodBeat.m2505o(114416);
    }

    public final long aLk() {
        AppMethodBeat.m2504i(114417);
        long j = this.iAS.iAx;
        long j2 = this.iAU;
        long j3 = this.iAV;
        if (j <= 0) {
            C4990ab.m7417i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), this.mAppId, this.iAT);
            if (j2 > 0 && j3 > 0 && j == 0) {
                j = C5046bo.anU() - j2;
                AppMethodBeat.m2505o(114417);
                return j;
            }
        }
        j = Math.max(0, j);
        AppMethodBeat.m2505o(114417);
        return j;
    }

    /* renamed from: wW */
    public final void mo22272wW() {
        AppMethodBeat.m2504i(114418);
        this.iAS.aLh();
        if (this.iAS.aLf()) {
            aLl();
            AppMethodBeat.m2505o(114418);
            return;
        }
        C5004al.m7441d(new C107191());
        AppMethodBeat.m2505o(114418);
    }

    /* renamed from: wU */
    public final void mo22271wU() {
        AppMethodBeat.m2504i(114419);
        if (this.iAU <= 0) {
            AppMethodBeat.m2505o(114419);
            return;
        }
        this.iAS.aLg();
        this.iAW.clear();
        AppMethodBeat.m2505o(114419);
    }

    /* Access modifiers changed, original: final */
    public final void aLl() {
        AppMethodBeat.m2504i(114421);
        while (!this.iAW.isEmpty()) {
            ((Runnable) this.iAW.pollFirst()).run();
        }
        AppMethodBeat.m2505o(114421);
    }

    /* renamed from: M */
    public final void mo22265M(Runnable runnable) {
        AppMethodBeat.m2504i(114420);
        if (this.iAS.aLf()) {
            runnable.run();
            AppMethodBeat.m2505o(114420);
            return;
        }
        this.iAW.addLast(runnable);
        AppMethodBeat.m2505o(114420);
    }
}
