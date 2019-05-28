package com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1028a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p518k.C3877c.C3878a;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.sns.ui.a.a.b */
public final class C13619b {
    public boolean hasInit = false;
    public C13618a rEQ = new C13618a();
    public C3878a rER = null;
    public int rzl = 0;

    public C13619b() {
        AppMethodBeat.m2504i(39948);
        AppMethodBeat.m2505o(39948);
    }

    /* renamed from: b */
    private void m21858b(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(39949);
        C13618a c13618a = this.rEQ;
        if (c13618a.ryk != null) {
            C5698f.m8558b(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).mo15892c(c13618a.ryk.rNp);
        }
        AppMethodBeat.m2505o(39949);
    }

    /* renamed from: c */
    private void m21859c(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(39950);
        C13618a c13618a = this.rEQ;
        if (c13618a.ryk != null) {
            C5698f.m8558b(str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).mo15892c(c13618a.ryk.rNq);
        }
        AppMethodBeat.m2505o(39950);
    }

    /* renamed from: d */
    public final void mo25823d(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(39951);
        if (this.hasInit) {
            if (this.rzl == 0) {
                m21858b(str, z, z2, i);
            }
            AppMethodBeat.m2505o(39951);
            return;
        }
        AppMethodBeat.m2505o(39951);
    }

    /* renamed from: e */
    public final void mo25824e(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(39952);
        if (this.hasInit) {
            if (this.rzl == 0) {
                m21859c(str, z, z2, i);
            }
            AppMethodBeat.m2505o(39952);
            return;
        }
        AppMethodBeat.m2505o(39952);
    }
}
