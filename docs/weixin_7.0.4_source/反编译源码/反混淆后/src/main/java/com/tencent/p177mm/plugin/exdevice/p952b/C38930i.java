package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.exdevice.p1255e.C20471h;
import com.tencent.p177mm.plugin.exdevice.p1255e.C42985c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.b.i */
public final class C38930i extends C45878j {
    public C38930i(byte[] bArr, int i, long j) {
        AppMethodBeat.m2504i(19052);
        C20471h c20471h = new C20471h();
        c20471h.lvi = new C42985c();
        c20471h.jBi = new C1332b(bArr);
        c20471h.jCt = i;
        this.lqD = c20471h;
        this.jJa = j;
        AppMethodBeat.m2505o(19052);
    }

    public final byte[] bot() {
        AppMethodBeat.m2504i(19053);
        Assert.assertNotNull(this.lqD);
        try {
            byte[] toByteArray = this.lqD.toByteArray();
            AppMethodBeat.m2505o(19053);
            return toByteArray;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", e.getMessage());
            AppMethodBeat.m2505o(19053);
            return null;
        }
    }
}
