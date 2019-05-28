package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    l gmG = new l();
    e gmH = new e();

    public d() {
        AppMethodBeat.i(40684);
        AppMethodBeat.o(40684);
    }

    public final void onCreate() {
        AppMethodBeat.i(40685);
        super.onCreate();
        ab.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        f aop = this.gmG.aop();
        g.RQ();
        g.RO().eJo.a(1624, aop);
        g.RQ();
        g.RO().eJo.a(1655, aop);
        aop = this.gmH.aok();
        ab.i("MicroMsg.AAOperationData", "init");
        g.RQ();
        g.RO().eJo.a(1698, aop);
        AppMethodBeat.o(40685);
    }

    public final void onDestroy() {
        AppMethodBeat.i(40686);
        super.onDestroy();
        ab.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        f aop = this.gmG.aop();
        g.RQ();
        g.RO().eJo.b(1624, aop);
        g.RQ();
        g.RO().eJo.b(1655, aop);
        aop = this.gmH.aok();
        ab.i("MicroMsg.AAOperationData", "uninit");
        g.RQ();
        g.RO().eJo.b(1698, aop);
        AppMethodBeat.o(40686);
    }
}
