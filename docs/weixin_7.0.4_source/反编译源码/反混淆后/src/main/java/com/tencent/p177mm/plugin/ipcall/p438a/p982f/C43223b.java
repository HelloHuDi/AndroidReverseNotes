package com.tencent.p177mm.plugin.ipcall.p438a.p982f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C34373g;

/* renamed from: com.tencent.mm.plugin.ipcall.a.f.b */
public final class C43223b {
    private static C43223b nzn;
    private C34373g nzo;

    public static C43223b bHU() {
        AppMethodBeat.m2504i(21898);
        if (nzn == null) {
            nzn = new C43223b();
        }
        C43223b c43223b = nzn;
        AppMethodBeat.m2505o(21898);
        return c43223b;
    }

    /* renamed from: it */
    public final void mo68730it(boolean z) {
        AppMethodBeat.m2504i(21899);
        C9638aw.m17182Rg().mo14547c(this.nzo);
        this.nzo = null;
        if (z) {
            this.nzo = new C34373g(1);
        } else {
            this.nzo = new C34373g(0);
        }
        C9638aw.m17182Rg().mo14541a(this.nzo, 0);
        AppMethodBeat.m2505o(21899);
    }
}
