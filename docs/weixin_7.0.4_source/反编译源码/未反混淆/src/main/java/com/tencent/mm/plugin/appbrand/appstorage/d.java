package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransferABTest;", "", "()V", "ABTEST_NEED_TRANSFER", "", "ABTEST_PHASES", "ABTEST_SWITCH", "PHASES_FINISH", "", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "isNeedTransfer", "", "isPerformanceReportOn", "phases", "isFinishPhases", "isRollbackPhases", "isTestPhases", "load", "", "onABTestUpdate", "plugin-appbrand-integration_release"})
public final class d {
    private static volatile boolean gXh;
    private static volatile int gXi = 1;
    private static volatile boolean gXj;
    public static final d gXk;

    static {
        AppMethodBeat.i(134488);
        d dVar = new d();
        gXk = dVar;
        dVar.sg();
        AppMethodBeat.o(134488);
    }

    private d() {
    }

    public final synchronized void sg() {
        AppMethodBeat.i(134487);
        ab.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load]");
        c ll = com.tencent.mm.model.c.c.abi().ll("100478");
        c ll2 = com.tencent.mm.model.c.c.abi().ll("100483");
        j.o(ll, "transferTest");
        if (ll.isValid()) {
            gXh = bo.getBoolean((String) ll.dru().get("needTransfer"), false);
            gXi = bo.getInt((String) ll.dru().get("phases"), 1);
        }
        j.o(ll2, "performanceReportSwitchTest");
        if (ll2.isValid()) {
            gXj = bo.getBoolean((String) ll2.dru().get("switch"), false);
        }
        ab.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isNeedTransfer=" + gXh + "  phases=" + gXi);
        ab.i("MicroMsg.AppBrandKVStorageTransferABTest", "[load] isPerformanceReportOn=" + gXj);
        AppMethodBeat.o(134487);
    }

    public final synchronized boolean awH() {
        return gXi == 3;
    }

    public final synchronized boolean awI() {
        return gXi == 2;
    }

    public final synchronized boolean awJ() {
        return gXj;
    }

    public final synchronized boolean awK() {
        return gXh;
    }
}
