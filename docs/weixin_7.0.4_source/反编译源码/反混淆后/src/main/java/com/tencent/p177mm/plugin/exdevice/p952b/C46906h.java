package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1255e.C20472n;
import com.tencent.p177mm.plugin.exdevice.p1255e.C42985c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.b.h */
public final class C46906h extends C45878j {
    public C46906h(int i, int i2, long j) {
        AppMethodBeat.m2504i(19049);
        C20472n c20472n = new C20472n();
        c20472n.lvi = new C42985c();
        c20472n.lvm = i;
        c20472n.lvn = i2;
        this.lqD = c20472n;
        this.jJa = j;
        AppMethodBeat.m2505o(19049);
    }

    public final byte[] bot() {
        AppMethodBeat.m2504i(19050);
        byte[] bArr = null;
        try {
            bArr = this.lqD.toByteArray();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", e.getMessage());
        }
        AppMethodBeat.m2505o(19050);
        return bArr;
    }

    public final int bov() {
        AppMethodBeat.m2504i(19051);
        C20472n c20472n = (C20472n) this.lqD;
        if (c20472n == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
            AppMethodBeat.m2505o(19051);
            return -1;
        }
        int i = c20472n.lvm;
        AppMethodBeat.m2505o(19051);
        return i;
    }
}
