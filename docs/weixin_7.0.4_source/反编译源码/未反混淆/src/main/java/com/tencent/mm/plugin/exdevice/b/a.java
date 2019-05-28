package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.i.f;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.plugin.exdevice.service.i.a {
    private static a lqw = null;

    static class a implements Runnable {
        private long jJa = -1;
        private byte[] lqA = null;
        private int lqx = -1;
        private int lqy = -1;
        private int lqz;

        public a(int i, long j, int i2, int i3, byte[] bArr) {
            this.jJa = j;
            this.lqx = i2;
            this.lqy = i3;
            this.lqA = bArr;
            this.lqz = i;
        }

        public final void boq() {
            AppMethodBeat.i(19035);
            if (this.jJa == -1 || this.lqx == -1 || this.lqy == -1) {
                ab.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                AppMethodBeat.o(19035);
                return;
            }
            switch (this.lqy) {
                case 10001:
                    u.bpy().a(new e(this.lqz, this.jJa, this.lqx, this.lqy, this.lqA));
                    AppMethodBeat.o(19035);
                    return;
                case 10002:
                    k.bow().b(this.lqz, this.jJa, this.lqx, this.lqy, this.lqA);
                    AppMethodBeat.o(19035);
                    return;
                case 10003:
                    u.bpy().a(new f(this.lqz, this.jJa, this.lqx, this.lqy, this.lqA));
                    AppMethodBeat.o(19035);
                    return;
                default:
                    ab.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", Integer.valueOf(this.lqy));
                    AppMethodBeat.o(19035);
                    return;
            }
        }

        public final void run() {
            AppMethodBeat.i(19036);
            boq();
            AppMethodBeat.o(19036);
        }
    }

    private a() {
    }

    public static a bop() {
        AppMethodBeat.i(19037);
        a aVar;
        if (lqw == null) {
            aVar = new a();
            lqw = aVar;
            AppMethodBeat.o(19037);
            return aVar;
        }
        aVar = lqw;
        AppMethodBeat.o(19037);
        return aVar;
    }

    public final void a(int i, long j, int i2, int i3, byte[] bArr) {
        int i4;
        AppMethodBeat.i(19038);
        String str = "MicroMsg.exdevice.DeviceRequestManager";
        String str2 = "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        ab.i(str, str2, objArr);
        if (i == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        com.tencent.mm.plugin.exdevice.g.a.n(j, i4);
        if (b.aN(bArr) == null) {
            ab.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            AppMethodBeat.o(19038);
            return;
        }
        ab.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", b.aN(bArr));
        new a(i, j, i2, i3, bArr).boq();
        AppMethodBeat.o(19038);
    }
}
