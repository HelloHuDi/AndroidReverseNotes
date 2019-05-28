package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i, long j) {
        AppMethodBeat.i(19052);
        h hVar = new h();
        hVar.lvi = new c();
        hVar.jBi = new b(bArr);
        hVar.jCt = i;
        this.lqD = hVar;
        this.jJa = j;
        AppMethodBeat.o(19052);
    }

    public final byte[] bot() {
        AppMethodBeat.i(19053);
        Assert.assertNotNull(this.lqD);
        try {
            byte[] toByteArray = this.lqD.toByteArray();
            AppMethodBeat.o(19053);
            return toByteArray;
        } catch (IOException e) {
            ab.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", e.getMessage());
            AppMethodBeat.o(19053);
            return null;
        }
    }
}
