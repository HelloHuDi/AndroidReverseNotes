package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c {
    public final l iAS;
    private volatile String iAT;
    volatile long iAU = 0;
    private volatile long iAV = 0;
    private final LinkedList<Runnable> iAW = new LinkedList();
    public volatile String mAppId;

    public c(int i) {
        AppMethodBeat.i(114413);
        this.iAS = new l("MicroMsg.AppBrandPageViewStatistics[" + i + "]");
        AppMethodBeat.o(114413);
    }

    public final boolean isLoading() {
        return this.iAU > 0 && this.iAV <= 0;
    }

    public final long aLi() {
        AppMethodBeat.i(114414);
        long max = Math.max(0, this.iAV);
        AppMethodBeat.o(114414);
        return max;
    }

    public final void DB(String str) {
        AppMethodBeat.i(114415);
        this.iAU = bo.anU();
        this.iAT = str;
        AppMethodBeat.o(114415);
    }

    public final void aLj() {
        AppMethodBeat.i(114416);
        this.iAV = bo.anU() - this.iAU;
        AppMethodBeat.o(114416);
    }

    public final long aLk() {
        AppMethodBeat.i(114417);
        long j = this.iAS.iAx;
        long j2 = this.iAU;
        long j3 = this.iAV;
        if (j <= 0) {
            ab.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), this.mAppId, this.iAT);
            if (j2 > 0 && j3 > 0 && j == 0) {
                j = bo.anU() - j2;
                AppMethodBeat.o(114417);
                return j;
            }
        }
        j = Math.max(0, j);
        AppMethodBeat.o(114417);
        return j;
    }

    public final void wW() {
        AppMethodBeat.i(114418);
        this.iAS.aLh();
        if (this.iAS.aLf()) {
            aLl();
            AppMethodBeat.o(114418);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114412);
                c.this.aLl();
                AppMethodBeat.o(114412);
            }
        });
        AppMethodBeat.o(114418);
    }

    public final void wU() {
        AppMethodBeat.i(114419);
        if (this.iAU <= 0) {
            AppMethodBeat.o(114419);
            return;
        }
        this.iAS.aLg();
        this.iAW.clear();
        AppMethodBeat.o(114419);
    }

    /* Access modifiers changed, original: final */
    public final void aLl() {
        AppMethodBeat.i(114421);
        while (!this.iAW.isEmpty()) {
            ((Runnable) this.iAW.pollFirst()).run();
        }
        AppMethodBeat.o(114421);
    }

    public final void M(Runnable runnable) {
        AppMethodBeat.i(114420);
        if (this.iAS.aLf()) {
            runnable.run();
            AppMethodBeat.o(114420);
            return;
        }
        this.iAW.addLast(runnable);
        AppMethodBeat.o(114420);
    }
}
