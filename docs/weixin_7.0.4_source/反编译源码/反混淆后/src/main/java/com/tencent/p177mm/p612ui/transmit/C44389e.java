package com.tencent.p177mm.p612ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C44275p;

/* renamed from: com.tencent.mm.ui.transmit.e */
public final class C44389e {
    Context context;
    Runnable hEw = new C443881();
    boolean iHj;
    boolean iHk;
    boolean iHl;
    int iHm;
    String text;
    C44275p tipDialog;
    C30773a zKR;

    /* renamed from: com.tencent.mm.ui.transmit.e$a */
    interface C30773a {
        /* renamed from: z */
        void mo41880z(boolean z, String str);
    }

    /* renamed from: com.tencent.mm.ui.transmit.e$1 */
    class C443881 implements Runnable {
        C443881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35280);
            if (C44389e.this.tipDialog != null) {
                C44389e.this.tipDialog.dismiss();
            }
            C44389e.this.aMl();
            AppMethodBeat.m2505o(35280);
        }
    }

    public C44389e(Context context) {
        AppMethodBeat.m2504i(35281);
        this.context = context;
        AppMethodBeat.m2505o(35281);
    }

    /* renamed from: oC */
    public final boolean mo70260oC() {
        return this.iHj & this.iHk;
    }

    public final void aMl() {
        AppMethodBeat.m2504i(35282);
        if (this.zKR != null) {
            this.zKR.mo41880z(this.iHl, this.text);
        }
        AppMethodBeat.m2505o(35282);
    }
}
