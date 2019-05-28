package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C38950ae;
import com.tencent.p177mm.plugin.exdevice.p952b.C27828c;
import com.tencent.p177mm.plugin.exdevice.p952b.C38930i;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.i.g */
public final class C27839g extends C38950ae {
    private C27828c lxC;
    private C27838a lxD;

    public C27839g(byte[] bArr, int i, long j) {
        AppMethodBeat.m2504i(19736);
        this.lxC = new C38930i(bArr, i, j);
        AppMethodBeat.m2505o(19736);
    }

    /* renamed from: a */
    public final boolean mo23404a(C27865m c27865m, C42990d c42990d) {
        AppMethodBeat.m2504i(19737);
        if (C20548u.bpx().mo45725hX(this.lxC.jJa)) {
            this.lxD = new C27838a(this.lxC, c42990d);
            boolean b = this.lxD.mo45713b(c27865m);
            AppMethodBeat.m2505o(19737);
            return b;
        }
        C4990ab.m7421w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", Long.valueOf(this.lxC.jJa));
        AppMethodBeat.m2505o(19737);
        return true;
    }
}
