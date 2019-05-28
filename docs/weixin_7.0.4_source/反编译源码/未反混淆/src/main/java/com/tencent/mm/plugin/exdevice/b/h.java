package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends j {
    public h(int i, int i2, long j) {
        AppMethodBeat.i(19049);
        n nVar = new n();
        nVar.lvi = new c();
        nVar.lvm = i;
        nVar.lvn = i2;
        this.lqD = nVar;
        this.jJa = j;
        AppMethodBeat.o(19049);
    }

    public final byte[] bot() {
        AppMethodBeat.i(19050);
        byte[] bArr = null;
        try {
            bArr = this.lqD.toByteArray();
        } catch (Exception e) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", e.getMessage());
        }
        AppMethodBeat.o(19050);
        return bArr;
    }

    public final int bov() {
        AppMethodBeat.i(19051);
        n nVar = (n) this.lqD;
        if (nVar == null) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
            AppMethodBeat.o(19051);
            return -1;
        }
        int i = nVar.lvm;
        AppMethodBeat.o(19051);
        return i;
    }
}
