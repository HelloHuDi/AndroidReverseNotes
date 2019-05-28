package com.tencent.p177mm.plugin.shake.p511ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.shake.ui.c */
final class C39711c {
    C7564ap che = new C7564ap(new C133011(), false);
    View view;

    /* renamed from: com.tencent.mm.plugin.shake.ui.c$1 */
    class C133011 implements C5015a {
        C133011() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(24707);
            C39711c.this.ckz();
            AppMethodBeat.m2505o(24707);
            return false;
        }
    }

    public C39711c(View view) {
        AppMethodBeat.m2504i(24708);
        this.view = view;
        AppMethodBeat.m2505o(24708);
    }

    public final void ckz() {
        AppMethodBeat.m2504i(24709);
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
        AppMethodBeat.m2505o(24709);
    }
}
