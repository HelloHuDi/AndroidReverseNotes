package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.e;

public final class i {
    private boolean oGP;
    private boolean oGQ;

    public final void Q(Activity activity) {
        AppMethodBeat.i(54043);
        if (!this.oGP) {
            this.oGP = true;
            e.a(activity, R.string.d31, null);
        }
        AppMethodBeat.o(54043);
    }

    public final void R(Activity activity) {
        AppMethodBeat.i(54044);
        if (!this.oGQ) {
            this.oGQ = true;
            e.a(activity, R.string.f6f, null);
        }
        AppMethodBeat.o(54044);
    }

    public final void reset() {
        this.oGQ = false;
        this.oGP = false;
    }
}
