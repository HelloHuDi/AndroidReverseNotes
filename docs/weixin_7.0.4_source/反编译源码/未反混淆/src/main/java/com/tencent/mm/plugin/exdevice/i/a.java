package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public class a implements c {
    private long lwo = -1;
    protected c lxu = null;
    protected d lxv = null;
    private m lxw = null;

    public a(c cVar, d dVar) {
        this.lxu = cVar;
        this.lxv = dVar;
    }

    public final void a(d dVar) {
        this.lxv = dVar;
    }

    public final boolean b(m mVar) {
        AppMethodBeat.i(19727);
        if (mVar == null) {
            ab.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            AppMethodBeat.o(19727);
            return false;
        } else if (this.lxw != null) {
            ab.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            AppMethodBeat.o(19727);
            return false;
        } else {
            ab.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", Short.valueOf(this.lxu.bor()), Short.valueOf(this.lxu.lqB), Long.valueOf(this.lxu.jJa));
            p mVar2 = new m(this.lxu, this);
            long a = mVar.a(mVar2);
            if (-1 == a) {
                ab.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                AppMethodBeat.o(19727);
                return false;
            }
            this.lxw = mVar2;
            this.lwo = a;
            m mVar3 = this.lxw;
            Assert.assertNotNull(mVar3.lxR);
            l lVar = mVar3.lxR;
            lVar.lxK = false;
            lVar.lxL = false;
            aw.RS().doN().postDelayed(lVar.lxM, 15000);
            AppMethodBeat.o(19727);
            return true;
        }
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        AppMethodBeat.i(19728);
        ab.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.lxu.jJa), Short.valueOf(this.lxu.bor()), Short.valueOf(this.lxu.lqB));
        com.tencent.mm.plugin.exdevice.g.a.n(this.lxu.jJa, i == 0 ? 1 : 0);
        if (pVar == null || pVar == this.lxw) {
            if (-1 == i && -2 == i2) {
                ab.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i3 = this.lxu.lqC != null ? this.lxu.lqC.luT : 0;
            if (-5 == i3 || -3 == i3 || -4 == i3) {
                ab.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", Integer.valueOf(this.lxu.lqC.luT), Long.valueOf(this.lxu.jJa));
                Object obj = (u.bpy().lqX == null || !u.bpy().lqX.hZ(this.lxu.jJa)) ? null : 1;
                if (obj == null) {
                    ab.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.lxv != null) {
                this.lxv.a(j, i, i2, str);
            }
            this.lxw = null;
            AppMethodBeat.o(19728);
            return;
        }
        ab.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
        AppMethodBeat.o(19728);
    }
}
