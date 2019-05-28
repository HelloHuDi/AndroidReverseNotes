package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class i extends Dialog {
    public i(Context context) {
        super(context);
    }

    public i(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        AppMethodBeat.i(106525);
        try {
            super.dismiss();
            AppMethodBeat.o(106525);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDialog", e, "", new Object[0]);
            AppMethodBeat.o(106525);
        }
    }

    public void show() {
        AppMethodBeat.i(106526);
        try {
            super.show();
            AppMethodBeat.o(106526);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMDialog", e, "", new Object[0]);
            AppMethodBeat.o(106526);
        }
    }
}
