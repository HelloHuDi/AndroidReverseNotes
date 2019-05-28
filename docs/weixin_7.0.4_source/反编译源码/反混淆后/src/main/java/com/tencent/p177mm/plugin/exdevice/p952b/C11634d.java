package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.exdevice.b.d */
public abstract class C11634d extends C27828c {
    protected C1331a lqE = null;
    private short lqF = (short) -1;
    private short lqG = (short) -1;

    /* renamed from: aL */
    public abstract C1331a mo23391aL(byte[] bArr);

    public C11634d(long j, int i, int i2, byte[] bArr) {
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        this.jJa = j;
        this.lqF = (short) i2;
        this.lqG = (short) i;
        mo23391aL(bArr);
    }

    public final short bor() {
        return this.lqF;
    }

    public final short bos() {
        return this.lqG;
    }

    public final C1331a bou() {
        return this.lqE;
    }

    public final byte[] bot() {
        try {
            return this.lqD.toByteArray();
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e, "", new Object[0]);
            return null;
        }
    }
}
