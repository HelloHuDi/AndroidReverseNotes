package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.p952b.C46906h;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.i.j */
public final class C27840j extends C38950ae {
    private C27838a lxG;
    private C46906h lxH;

    public C27840j(int i, int i2, long j) {
        AppMethodBeat.m2504i(19741);
        this.lxH = new C46906h(i, i2, j);
        AppMethodBeat.m2505o(19741);
    }

    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19742);
        if (C20548u.bpx().mo45725hX(this.lxH.jJa)) {
            this.lxG = new C38940b(this.lxH, c42990d);
            boolean b = this.lxG.mo45713b(c27865m);
            AppMethodBeat.m2505o(19742);
            return b;
        }
        C4990ab.m7421w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", Long.valueOf(this.lxH.jJa));
        AppMethodBeat.m2505o(19742);
        return true;
    }
}
