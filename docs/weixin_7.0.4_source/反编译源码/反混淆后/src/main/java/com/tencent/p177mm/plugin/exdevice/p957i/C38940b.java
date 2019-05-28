package com.tencent.p177mm.plugin.exdevice.p957i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p952b.C27828c;
import com.tencent.p177mm.plugin.exdevice.p952b.C46906h;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.p956h.C27836a;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.i.b */
public final class C38940b extends C27838a implements C42990d {
    private final C42990d lxx;

    public C38940b(C27828c c27828c, C42990d c42990d) {
        super(c27828c, c42990d);
        AppMethodBeat.m2504i(19729);
        mo45712a(this);
        this.lxx = c42990d;
        AppMethodBeat.m2505o(19729);
    }

    /* renamed from: a */
    public final void mo54567a(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(19730);
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (2 == ((C46906h) this.lxu).bov()) {
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            C11648b Ku = C45891ad.boW().mo45700Ku(this.lxu.jJa);
            if (Ku != null) {
                switch (Ku.field_closeStrategy) {
                    case 1:
                        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", Integer.valueOf(Ku.field_closeStrategy), Long.valueOf(this.lxu.jJa));
                        if (C20548u.bpy().lqX != null) {
                            C20548u.bpy().lqX.mo45761hZ(this.lxu.jJa);
                            break;
                        }
                        break;
                    case 2:
                        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", Integer.valueOf(Ku.field_closeStrategy), Long.valueOf(this.lxu.jJa));
                        if (!C27836a.m44243D("shut_down_device", this.lxu.jJa)) {
                            C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        C4990ab.m7413e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", Integer.valueOf(Ku.field_closeStrategy));
                        break;
                }
            }
            C4990ab.m7413e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", Long.valueOf(this.lxu.jJa));
            if (this.lxx != null) {
                this.lxx.mo54567a(j, i, i2, str);
            }
            AppMethodBeat.m2505o(19730);
            return;
        }
        if (this.lxx != null) {
            this.lxx.mo54567a(j, i, i2, str);
        }
        AppMethodBeat.m2505o(19730);
    }
}
