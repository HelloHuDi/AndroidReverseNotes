package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.p952b.C38928f;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.i.h */
public final class C11650h extends C38950ae {
    private C38928f lqO;
    private C27838a lxE;

    public C11650h(C38928f c38928f) {
        this.lqO = c38928f;
    }

    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19738);
        this.lxE = new C27838a(this.lqO, c42990d);
        C4990ab.m7417i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", Boolean.valueOf(this.lxE.mo45713b(c27865m)));
        AppMethodBeat.m2505o(19738);
        return this.lxE.mo45713b(c27865m);
    }
}
