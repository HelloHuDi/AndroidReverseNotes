package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.p952b.C38929g;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.i.i */
public final class C11651i extends C38950ae {
    private C27838a lxD;
    private C38929g lxF;

    public C11651i(int i) {
        AppMethodBeat.m2504i(19739);
        this.lxF = new C38929g(i);
        AppMethodBeat.m2505o(19739);
    }

    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19740);
        if (C20548u.bpx().mo45725hX(this.lxF.jJa)) {
            this.lxD = new C27838a(this.lxF, c42990d);
            boolean b = this.lxD.mo45713b(c27865m);
            AppMethodBeat.m2505o(19740);
            return b;
        }
        C4990ab.m7421w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", Long.valueOf(this.lxF.jJa));
        AppMethodBeat.m2505o(19740);
        return true;
    }
}
