package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.sdk.platformtools.ab;

public class w extends a {
    public void a(long j, int i, int i2, int i3, long j2) {
        AppMethodBeat.i(19632);
        ab.i("MicroMsg.exdevice.OnStateChangeCallBack", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d, profileType = %d", b.ie(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.o(19632);
    }
}
