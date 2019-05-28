package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.exdevice.p392g.C2970a;
import com.tencent.p177mm.plugin.exdevice.p952b.C27828c;
import com.tencent.p177mm.plugin.exdevice.service.C11661p;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.i.a */
public class C27838a implements C45884c {
    private long lwo = -1;
    protected C27828c lxu = null;
    protected C42990d lxv = null;
    private C38941m lxw = null;

    public C27838a(C27828c c27828c, C42990d c42990d) {
        this.lxu = c27828c;
        this.lxv = c42990d;
    }

    /* renamed from: a */
    public final void mo45712a(C42990d c42990d) {
        this.lxv = c42990d;
    }

    /* renamed from: b */
    public final boolean mo45713b(C27865m c27865m) {
        AppMethodBeat.m2504i(19727);
        if (c27865m == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            AppMethodBeat.m2505o(19727);
            return false;
        } else if (this.lxw != null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            AppMethodBeat.m2505o(19727);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", Short.valueOf(this.lxu.bor()), Short.valueOf(this.lxu.lqB), Long.valueOf(this.lxu.jJa));
            C11661p c38941m = new C38941m(this.lxu, this);
            long a = c27865m.mo45751a(c38941m);
            if (-1 == a) {
                C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                AppMethodBeat.m2505o(19727);
                return false;
            }
            this.lxw = c38941m;
            this.lwo = a;
            C38941m c38941m2 = this.lxw;
            Assert.assertNotNull(c38941m2.lxR);
            C45887l c45887l = c38941m2.lxR;
            c45887l.lxK = false;
            c45887l.lxL = false;
            C9638aw.m17180RS().doN().postDelayed(c45887l.lxM, 15000);
            AppMethodBeat.m2505o(19727);
            return true;
        }
    }

    /* renamed from: a */
    public final void mo45711a(long j, int i, int i2, String str, C11661p c11661p) {
        AppMethodBeat.m2504i(19728);
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.lxu.jJa), Short.valueOf(this.lxu.bor()), Short.valueOf(this.lxu.lqB));
        C2970a.m5256n(this.lxu.jJa, i == 0 ? 1 : 0);
        if (c11661p == null || c11661p == this.lxw) {
            if (-1 == i && -2 == i2) {
                C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i3 = this.lxu.lqC != null ? this.lxu.lqC.luT : 0;
            if (-5 == i3 || -3 == i3 || -4 == i3) {
                C4990ab.m7421w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", Integer.valueOf(this.lxu.lqC.luT), Long.valueOf(this.lxu.jJa));
                Object obj = (C20548u.bpy().lqX == null || !C20548u.bpy().lqX.mo45761hZ(this.lxu.jJa)) ? null : 1;
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.lxv != null) {
                this.lxv.mo54567a(j, i, i2, str);
            }
            this.lxw = null;
            AppMethodBeat.m2505o(19728);
            return;
        }
        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
        AppMethodBeat.m2505o(19728);
    }
}
