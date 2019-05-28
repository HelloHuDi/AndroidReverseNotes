package com.tencent.mm.plugin.appbrand.page.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.n;
import java.util.concurrent.atomic.AtomicReference;

public class b implements c {
    protected final u ivs;
    protected final AtomicReference<com.tencent.mm.plugin.appbrand.page.b.c.b> ivt = new AtomicReference();

    b(u uVar) {
        AppMethodBeat.i(87370);
        this.ivt.set(com.tencent.mm.plugin.appbrand.page.b.c.b.SHOWN);
        this.ivs = uVar;
        AppMethodBeat.o(87370);
    }

    public final com.tencent.mm.plugin.appbrand.page.b.c.b aBt() {
        AppMethodBeat.i(87371);
        com.tencent.mm.plugin.appbrand.page.b.c.b bVar = (com.tencent.mm.plugin.appbrand.page.b.c.b) this.ivt.get();
        AppMethodBeat.o(87371);
        return bVar;
    }

    public void aBr() {
    }

    public void aBs() {
    }

    public void aAS() {
        AppMethodBeat.i(87372);
        if (this.ivs.mContext instanceof Activity) {
            n.c(((Activity) this.ivs.mContext).getWindow(), false);
        }
        AppMethodBeat.o(87372);
    }

    public void onOrientationChanged(int i) {
    }
}
