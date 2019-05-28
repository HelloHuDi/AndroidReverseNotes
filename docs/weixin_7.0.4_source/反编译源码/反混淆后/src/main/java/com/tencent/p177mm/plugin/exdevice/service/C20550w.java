package com.tencent.p177mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.service.C38959k.C38960a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.service.w */
public class C20550w extends C38960a {
    /* renamed from: a */
    public void mo7187a(long j, int i, int i2, int i3, long j2) {
        AppMethodBeat.m2504i(19632);
        C4990ab.m7417i("MicroMsg.exdevice.OnStateChangeCallBack", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d, profileType = %d", C42992b.m76358ie(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        AppMethodBeat.m2505o(19632);
    }
}
