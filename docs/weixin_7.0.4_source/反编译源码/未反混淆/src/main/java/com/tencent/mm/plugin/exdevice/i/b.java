package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a implements d {
    private final d lxx;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        AppMethodBeat.i(19729);
        a(this);
        this.lxx = dVar;
        AppMethodBeat.o(19729);
    }

    public final void a(long j, int i, int i2, String str) {
        AppMethodBeat.i(19730);
        ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (2 == ((h) this.lxu).bov()) {
            ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.h.b Ku = ad.boW().Ku(this.lxu.jJa);
            if (Ku != null) {
                switch (Ku.field_closeStrategy) {
                    case 1:
                        ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", Integer.valueOf(Ku.field_closeStrategy), Long.valueOf(this.lxu.jJa));
                        if (u.bpy().lqX != null) {
                            u.bpy().lqX.hZ(this.lxu.jJa);
                            break;
                        }
                        break;
                    case 2:
                        ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", Integer.valueOf(Ku.field_closeStrategy), Long.valueOf(this.lxu.jJa));
                        if (!a.D("shut_down_device", this.lxu.jJa)) {
                            ab.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        ab.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", Integer.valueOf(Ku.field_closeStrategy));
                        break;
                }
            }
            ab.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", Long.valueOf(this.lxu.jJa));
            if (this.lxx != null) {
                this.lxx.a(j, i, i2, str);
            }
            AppMethodBeat.o(19730);
            return;
        }
        if (this.lxx != null) {
            this.lxx.a(j, i, i2, str);
        }
        AppMethodBeat.o(19730);
    }
}
