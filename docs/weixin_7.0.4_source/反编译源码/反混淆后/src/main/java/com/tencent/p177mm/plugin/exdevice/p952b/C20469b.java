package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.exdevice.p1255e.C38931b;
import com.tencent.p177mm.plugin.exdevice.p1255e.C45879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.exdevice.b.b */
public final class C20469b extends C11634d {
    public C20469b(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        AppMethodBeat.m2504i(19039);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j + " seq = " + i + " cmdId = " + i2);
        AppMethodBeat.m2505o(19039);
    }

    /* renamed from: e */
    public final void mo35788e(int i, String str, byte[] bArr) {
        AppMethodBeat.m2504i(19040);
        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i + "errMsg = " + str);
        C38931b c38931b = new C38931b();
        c38931b.lvk = mo45698as(i, str);
        c38931b.luR = C1332b.m2847bI(bArr);
        this.lqD = c38931b;
        this.lqB = (short) 20001;
        AppMethodBeat.m2505o(19040);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aL */
    public final C1331a mo23391aL(byte[] bArr) {
        AppMethodBeat.m2504i(19041);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            AppMethodBeat.m2505o(19041);
            return null;
        }
        C1331a c45879a = new C45879a();
        try {
            c45879a.parseFrom(bArr);
            this.lqE = c45879a;
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + c45879a.luK + " DeviceName = " + c45879a.jBF + " Language = " + c45879a.luQ + " TimeZone = " + c45879a.luP);
            AppMethodBeat.m2505o(19041);
            return c45879a;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", e, "", new Object[0]);
            AppMethodBeat.m2505o(19041);
            return null;
        }
    }
}
