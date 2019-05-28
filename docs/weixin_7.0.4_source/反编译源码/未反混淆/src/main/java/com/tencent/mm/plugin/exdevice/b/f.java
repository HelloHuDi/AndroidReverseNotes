package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class f extends d {
    public f(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        AppMethodBeat.i(19045);
        ab.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        AppMethodBeat.o(19045);
    }

    public final void f(int i, String str, byte[] bArr) {
        AppMethodBeat.i(19046);
        ab.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + i + str);
        l lVar = new l();
        lVar.lvk = as(i, str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        lVar.jBi = new b(bArr);
        this.lqD = lVar;
        this.lqB = (short) 20002;
        AppMethodBeat.o(19046);
    }

    /* Access modifiers changed, original: protected|final */
    public final a aL(byte[] bArr) {
        AppMethodBeat.i(19047);
        if (bArr == null || bArr.length == 0) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
            AppMethodBeat.o(19047);
            return null;
        }
        a kVar = new k();
        try {
            kVar.parseFrom(bArr);
            this.lqE = kVar;
            ab.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
            AppMethodBeat.o(19047);
            return kVar;
        } catch (IOException e) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", e, "", new Object[0]);
            AppMethodBeat.o(19047);
            return null;
        }
    }
}
