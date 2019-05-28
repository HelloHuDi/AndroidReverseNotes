package com.tencent.p177mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p203bg.C17981e;

/* renamed from: com.tencent.mm.plugin.multitalk.model.i */
public final class C34569i {
    private boolean oGP;
    private boolean oGQ;

    /* renamed from: Q */
    public final void mo55140Q(Activity activity) {
        AppMethodBeat.m2504i(54043);
        if (!this.oGP) {
            this.oGP = true;
            C17981e.m28295a(activity, C25738R.string.d31, null);
        }
        AppMethodBeat.m2505o(54043);
    }

    /* renamed from: R */
    public final void mo55141R(Activity activity) {
        AppMethodBeat.m2504i(54044);
        if (!this.oGQ) {
            this.oGQ = true;
            C17981e.m28295a(activity, C25738R.string.f6f, null);
        }
        AppMethodBeat.m2505o(54044);
    }

    public final void reset() {
        this.oGQ = false;
        this.oGP = false;
    }
}
