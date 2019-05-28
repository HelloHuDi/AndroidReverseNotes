package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.q.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends a {
    private static e lwH = new e();

    static {
        AppMethodBeat.i(19580);
        AppMethodBeat.o(19580);
    }

    private e() {
    }

    public static e bpo() {
        return lwH;
    }

    public final boolean aB(final String str, final boolean z) {
        AppMethodBeat.i(19578);
        ab.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (str == null) {
            ab.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            AppMethodBeat.o(19578);
            return false;
        } else if (u.bpy().lqX == null) {
            ab.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            ad.bpd().T(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(19577);
                    if (u.bpy().lqX != null) {
                        u.bpy().lqX.a(str, z, e.this);
                    }
                    AppMethodBeat.o(19577);
                }
            });
            AppMethodBeat.o(19578);
            return false;
        } else {
            boolean a = u.bpy().lqX.a(str, z, (q) this);
            AppMethodBeat.o(19578);
            return a;
        }
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        AppMethodBeat.i(19579);
        ab.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), b.aN(bArr), Double.valueOf(d2), str, Integer.valueOf(i3));
        dt dtVar = new dt();
        String aN = b.aN(bArr);
        if (aN.length() >= 32) {
            aN = aN.substring(0, 8) + "-" + aN.substring(8, 12) + "-" + aN.substring(12, 16) + "-" + aN.substring(16, 20) + "-" + aN.substring(20);
        }
        dtVar.cxk.cxi = aN;
        dtVar.cxk.cxn = d;
        dtVar.cxk.cxl = i;
        dtVar.cxk.cxm = i2;
        dtVar.cxk.cxo = d2;
        dtVar.cxk.cxp = str;
        dtVar.cxk.cxq = i3;
        com.tencent.mm.sdk.b.a.xxA.m(dtVar);
        AppMethodBeat.o(19579);
    }
}
