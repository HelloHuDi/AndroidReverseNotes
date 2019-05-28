package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class b extends a {
    private boolean iFB = false;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(132890);
        if (context instanceof Activity) {
            this.iFB = n.b(((Activity) context).getWindow());
        }
        AppMethodBeat.o(132890);
    }

    public final c aMb() {
        AppMethodBeat.i(132891);
        c aMb = super.aMb();
        n.a(aMb.getWindow(), this.iFB);
        AppMethodBeat.o(132891);
        return aMb;
    }
}
