package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

public final class e {
    Context context;
    Runnable hEw = new Runnable() {
        public final void run() {
            AppMethodBeat.i(35280);
            if (e.this.tipDialog != null) {
                e.this.tipDialog.dismiss();
            }
            e.this.aMl();
            AppMethodBeat.o(35280);
        }
    };
    boolean iHj;
    boolean iHk;
    boolean iHl;
    int iHm;
    String text;
    p tipDialog;
    a zKR;

    interface a {
        void z(boolean z, String str);
    }

    public e(Context context) {
        AppMethodBeat.i(35281);
        this.context = context;
        AppMethodBeat.o(35281);
    }

    public final boolean oC() {
        return this.iHj & this.iHk;
    }

    public final void aMl() {
        AppMethodBeat.i(35282);
        if (this.zKR != null) {
            this.zKR.z(this.iHl, this.text);
        }
        AppMethodBeat.o(35282);
    }
}
