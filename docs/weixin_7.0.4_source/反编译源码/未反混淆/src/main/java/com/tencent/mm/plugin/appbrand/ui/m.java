package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.f;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.k;

class m extends f {
    private k iJv;

    m(Activity activity, k kVar) {
        super(activity);
        this.iJv = kVar;
    }

    public void awE() {
        AppMethodBeat.i(114422);
        i atv = this.iJv.atv();
        if (atv != null) {
            atv.gNN.gWy.nt(10);
        }
        AppMethodBeat.o(114422);
    }
}
