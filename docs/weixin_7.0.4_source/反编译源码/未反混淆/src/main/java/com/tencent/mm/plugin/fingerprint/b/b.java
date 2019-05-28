package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends c<bt> implements f {
    private bt mrt;
    private boolean mru;

    public b() {
        AppMethodBeat.i(41425);
        this.mru = false;
        this.xxI = bt.class.getName().hashCode();
        AppMethodBeat.o(41425);
    }

    private boolean a(bt btVar) {
        AppMethodBeat.i(41426);
        if (g.RK()) {
            this.mru = false;
            if (btVar instanceof bt) {
                this.mrt = btVar;
                ab.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
                g.RQ();
                g.RO().eJo.a(385, (f) this);
                m dVar = new d(btVar.cuS.cuU);
                g.RQ();
                g.RO().eJo.a(dVar, 0);
                AppMethodBeat.o(41426);
                return true;
            }
            AppMethodBeat.o(41426);
            return false;
        }
        ab.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        AppMethodBeat.o(41426);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41427);
        if (mVar instanceof d) {
            com.tencent.mm.g.a.bt.b bVar = new com.tencent.mm.g.a.bt.b();
            ab.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                bVar.retCode = 0;
            } else {
                ab.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                bVar.retCode = i2;
            }
            g.RQ();
            g.RO().eJo.b(385, (f) this);
            this.mrt.cuT = bVar;
            this.mru = true;
            if (this.mrt.callback != null) {
                this.mrt.callback.run();
            }
            if (this.mru) {
                this.mrt = null;
            }
        }
        AppMethodBeat.o(41427);
    }
}
