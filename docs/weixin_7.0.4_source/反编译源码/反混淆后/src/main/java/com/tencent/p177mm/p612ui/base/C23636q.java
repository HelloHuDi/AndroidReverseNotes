package com.tencent.p177mm.p612ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.q */
public class C23636q extends ProgressDialog {
    public C23636q(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        AppMethodBeat.m2504i(106763);
        try {
            super.dismiss();
            AppMethodBeat.m2505o(106763);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + e.getMessage());
            AppMethodBeat.m2505o(106763);
        }
    }
}
