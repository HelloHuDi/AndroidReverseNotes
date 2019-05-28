package com.tencent.p177mm.p612ui.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.i */
public class C15532i extends Dialog {
    public C15532i(Context context) {
        super(context);
    }

    public C15532i(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        AppMethodBeat.m2504i(106525);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(106525);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(106525);
        }
    }

    public void show() {
        AppMethodBeat.m2504i(106526);
        try {
            super.show();
            AppMethodBeat.m2505o(106526);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(106526);
        }
    }
}
