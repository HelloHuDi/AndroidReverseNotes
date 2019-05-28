package com.tencent.p177mm.plugin.exdevice.p952b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p392g.C2970a;
import com.tencent.p177mm.plugin.exdevice.p957i.C11649f;
import com.tencent.p177mm.plugin.exdevice.p957i.C45885e;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C38958i.C20546a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.b.a */
public final class C45877a extends C20546a {
    private static C45877a lqw = null;

    /* renamed from: com.tencent.mm.plugin.exdevice.b.a$a */
    static class C45876a implements Runnable {
        private long jJa = -1;
        private byte[] lqA = null;
        private int lqx = -1;
        private int lqy = -1;
        private int lqz;

        public C45876a(int i, long j, int i2, int i3, byte[] bArr) {
            this.jJa = j;
            this.lqx = i2;
            this.lqy = i3;
            this.lqA = bArr;
            this.lqz = i;
        }

        public final void boq() {
            AppMethodBeat.m2504i(19035);
            if (this.jJa == -1 || this.lqx == -1 || this.lqy == -1) {
                C4990ab.m7412e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                AppMethodBeat.m2505o(19035);
                return;
            }
            switch (this.lqy) {
                case 10001:
                    C20548u.bpy().mo54568a(new C45885e(this.lqz, this.jJa, this.lqx, this.lqy, this.lqA));
                    AppMethodBeat.m2505o(19035);
                    return;
                case 10002:
                    C11635k.bow().mo23396b(this.lqz, this.jJa, this.lqx, this.lqy, this.lqA);
                    AppMethodBeat.m2505o(19035);
                    return;
                case 10003:
                    C20548u.bpy().mo54568a(new C11649f(this.lqz, this.jJa, this.lqx, this.lqy, this.lqA));
                    AppMethodBeat.m2505o(19035);
                    return;
                default:
                    C4990ab.m7413e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", Integer.valueOf(this.lqy));
                    AppMethodBeat.m2505o(19035);
                    return;
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(19036);
            boq();
            AppMethodBeat.m2505o(19036);
        }
    }

    private C45877a() {
    }

    public static C45877a bop() {
        AppMethodBeat.m2504i(19037);
        C45877a c45877a;
        if (lqw == null) {
            c45877a = new C45877a();
            lqw = c45877a;
            AppMethodBeat.m2505o(19037);
            return c45877a;
        }
        c45877a = lqw;
        AppMethodBeat.m2505o(19037);
        return c45877a;
    }

    /* renamed from: a */
    public final void mo35821a(int i, long j, int i2, int i3, byte[] bArr) {
        int i4;
        AppMethodBeat.m2504i(19038);
        String str = "MicroMsg.exdevice.DeviceRequestManager";
        String str2 = "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        C4990ab.m7417i(str, str2, objArr);
        if (i == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        C2970a.m5256n(j, i4);
        if (C42992b.m76349aN(bArr) == null) {
            C4990ab.m7412e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            AppMethodBeat.m2505o(19038);
            return;
        }
        C4990ab.m7411d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", C42992b.m76349aN(bArr));
        new C45876a(i, j, i2, i3, bArr).boq();
        AppMethodBeat.m2505o(19038);
    }
}
