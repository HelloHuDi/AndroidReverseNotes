package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static volatile com.tencent.mm.ci.c<f> vaf;
    private final f vag;

    public c() {
        AppMethodBeat.i(58772);
        if (vaf != null) {
            this.vag = (f) vaf.get();
            AppMethodBeat.o(58772);
            return;
        }
        this.vag = null;
        AppMethodBeat.o(58772);
    }

    public final void ca(Object obj) {
        AppMethodBeat.i(58773);
        if (this.vag != null) {
            this.vag.ca(obj);
        }
        AppMethodBeat.o(58773);
    }

    public final boolean a(tb tbVar, boolean z) {
        AppMethodBeat.i(58774);
        if (g.RK()) {
            long anU = bo.anU();
            byte[] a = aa.a(tbVar.wau);
            ab.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", Long.valueOf(anU), Integer.valueOf(tbVar.wat), Integer.valueOf(bo.cc(a)), Long.valueOf(Thread.currentThread().getId()));
            if (bo.cb(a)) {
                ab.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                AppMethodBeat.o(58774);
                return false;
            }
            try {
                if (this.vag != null) {
                    this.vag.a(tbVar, a, z);
                }
                ab.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", Long.valueOf(anU), Integer.valueOf(tbVar.wat), Long.valueOf(bo.gb(anU)));
                AppMethodBeat.o(58774);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e, "", new Object[0]);
                AppMethodBeat.o(58774);
                return false;
            }
        }
        ab.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        AppMethodBeat.o(58774);
        return false;
    }

    public final void cc(Object obj) {
        AppMethodBeat.i(58775);
        if (this.vag != null) {
            this.vag.cc(obj);
        }
        AppMethodBeat.o(58775);
    }

    public final void cd(Object obj) {
        AppMethodBeat.i(58776);
        if (this.vag != null) {
            this.vag.cd(obj);
        }
        AppMethodBeat.o(58776);
    }
}
