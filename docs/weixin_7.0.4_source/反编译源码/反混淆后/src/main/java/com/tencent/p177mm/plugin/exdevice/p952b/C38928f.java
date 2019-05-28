package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.exdevice.p1255e.C38933k;
import com.tencent.p177mm.plugin.exdevice.p1255e.C44735l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.exdevice.b.f */
public final class C38928f extends C11634d {
    public C38928f(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        AppMethodBeat.m2504i(19045);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        AppMethodBeat.m2505o(19045);
    }

    /* renamed from: f */
    public final void mo61820f(int i, String str, byte[] bArr) {
        AppMethodBeat.m2504i(19046);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + i + str);
        C44735l c44735l = new C44735l();
        c44735l.lvk = mo45698as(i, str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c44735l.jBi = new C1332b(bArr);
        this.lqD = c44735l;
        this.lqB = (short) 20002;
        AppMethodBeat.m2505o(19046);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aL */
    public final C1331a mo23391aL(byte[] bArr) {
        AppMethodBeat.m2504i(19047);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
            AppMethodBeat.m2505o(19047);
            return null;
        }
        C1331a c38933k = new C38933k();
        try {
            c38933k.parseFrom(bArr);
            this.lqE = c38933k;
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
            AppMethodBeat.m2505o(19047);
            return c38933k;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", e, "", new Object[0]);
            AppMethodBeat.m2505o(19047);
            return null;
        }
    }
}
