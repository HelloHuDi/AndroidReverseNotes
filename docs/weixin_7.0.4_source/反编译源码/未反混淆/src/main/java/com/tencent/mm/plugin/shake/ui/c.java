package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c {
    ap che = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(24707);
            c.this.ckz();
            AppMethodBeat.o(24707);
            return false;
        }
    }, false);
    View view;

    public c(View view) {
        AppMethodBeat.i(24708);
        this.view = view;
        AppMethodBeat.o(24708);
    }

    public final void ckz() {
        AppMethodBeat.i(24709);
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
        AppMethodBeat.o(24709);
    }
}
