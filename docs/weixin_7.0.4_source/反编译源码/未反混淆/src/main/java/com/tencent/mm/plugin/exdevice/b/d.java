package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bt.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class d extends c {
    protected a lqE = null;
    private short lqF = (short) -1;
    private short lqG = (short) -1;

    public abstract a aL(byte[] bArr);

    public d(long j, int i, int i2, byte[] bArr) {
        ab.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.jJa = j;
        this.lqF = (short) i2;
        this.lqG = (short) i;
        aL(bArr);
    }

    public final short bor() {
        return this.lqF;
    }

    public final short bos() {
        return this.lqG;
    }

    public final a bou() {
        return this.lqE;
    }

    public final byte[] bot() {
        try {
            return this.lqD.toByteArray();
        } catch (IOException e) {
            ab.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
