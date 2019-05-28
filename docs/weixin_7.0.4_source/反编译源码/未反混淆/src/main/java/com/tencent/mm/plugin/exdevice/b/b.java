package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class b extends d {
    public b(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        AppMethodBeat.i(19039);
        ab.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        AppMethodBeat.o(19039);
    }

    public final void e(int i, String str, byte[] bArr) {
        AppMethodBeat.i(19040);
        ab.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i + "errMsg = " + str);
        com.tencent.mm.plugin.exdevice.e.b bVar = new com.tencent.mm.plugin.exdevice.e.b();
        bVar.lvk = as(i, str);
        bVar.luR = com.tencent.mm.bt.b.bI(bArr);
        this.lqD = bVar;
        this.lqB = (short) 20001;
        AppMethodBeat.o(19040);
    }

    /* Access modifiers changed, original: protected|final */
    public final a aL(byte[] bArr) {
        AppMethodBeat.i(19041);
        if (bArr == null || bArr.length == 0) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            AppMethodBeat.o(19041);
            return null;
        }
        a aVar = new com.tencent.mm.plugin.exdevice.e.a();
        try {
            aVar.parseFrom(bArr);
            this.lqE = aVar;
            ab.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + aVar.luK + " DeviceName = " + aVar.jBF + " Language = " + aVar.luQ + " TimeZone = " + aVar.luP);
            AppMethodBeat.o(19041);
            return aVar;
        } catch (IOException e) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", e, "", new Object[0]);
            AppMethodBeat.o(19041);
            return null;
        }
    }
}
