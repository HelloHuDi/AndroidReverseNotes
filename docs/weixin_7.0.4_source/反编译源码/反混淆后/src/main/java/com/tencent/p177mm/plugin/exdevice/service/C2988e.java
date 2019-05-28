package com.tencent.p177mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32535dt;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.service.C45894q.C27868a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.service.e */
public final class C2988e extends C27868a {
    private static C2988e lwH = new C2988e();

    static {
        AppMethodBeat.m2504i(19580);
        AppMethodBeat.m2505o(19580);
    }

    private C2988e() {
    }

    public static C2988e bpo() {
        return lwH;
    }

    /* renamed from: aB */
    public final boolean mo7192aB(final String str, final boolean z) {
        AppMethodBeat.m2504i(19578);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (str == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            AppMethodBeat.m2505o(19578);
            return false;
        } else if (C20548u.bpy().lqX == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            C45891ad.bpd().mo7175T(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(19577);
                    if (C20548u.bpy().lqX != null) {
                        C20548u.bpy().lqX.mo45755a(str, z, C2988e.this);
                    }
                    AppMethodBeat.m2505o(19577);
                }
            });
            AppMethodBeat.m2505o(19578);
            return false;
        } else {
            boolean a = C20548u.bpy().lqX.mo45755a(str, z, (C45894q) this);
            AppMethodBeat.m2505o(19578);
            return a;
        }
    }

    /* renamed from: a */
    public final void mo7191a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        AppMethodBeat.m2504i(19579);
        C4990ab.m7411d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), C42992b.m76349aN(bArr), Double.valueOf(d2), str, Integer.valueOf(i3));
        C32535dt c32535dt = new C32535dt();
        String aN = C42992b.m76349aN(bArr);
        if (aN.length() >= 32) {
            aN = aN.substring(0, 8) + "-" + aN.substring(8, 12) + "-" + aN.substring(12, 16) + "-" + aN.substring(16, 20) + "-" + aN.substring(20);
        }
        c32535dt.cxk.cxi = aN;
        c32535dt.cxk.cxn = d;
        c32535dt.cxk.cxl = i;
        c32535dt.cxk.cxm = i2;
        c32535dt.cxk.cxo = d2;
        c32535dt.cxk.cxp = str;
        c32535dt.cxk.cxq = i3;
        C4879a.xxA.mo10055m(c32535dt);
        AppMethodBeat.m2505o(19579);
    }
}
