package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C31311k;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p281b.C10142f;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.m */
class C42695m extends C10142f {
    private C31311k iJv;

    C42695m(Activity activity, C31311k c31311k) {
        super(activity);
        this.iJv = c31311k;
    }

    public void awE() {
        AppMethodBeat.m2504i(114422);
        C6750i atv = this.iJv.atv();
        if (atv != null) {
            atv.gNN.gWy.mo44560nt(10);
        }
        AppMethodBeat.m2505o(114422);
    }
}
