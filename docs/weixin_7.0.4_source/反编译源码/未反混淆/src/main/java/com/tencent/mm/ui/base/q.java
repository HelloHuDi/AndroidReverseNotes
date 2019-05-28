package com.tencent.mm.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class q extends ProgressDialog {
    public q(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        AppMethodBeat.i(106763);
        try {
            super.dismiss();
            AppMethodBeat.o(106763);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.o(106763);
        }
    }
}
