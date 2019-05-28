package com.tencent.p177mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.service.d */
public final class C11656d {
    /* renamed from: dI */
    public static boolean m19470dI(Context context) {
        AppMethodBeat.m2504i(19576);
        if (C1737l.m3591bL(context)) {
            C4990ab.m7416i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
            AppMethodBeat.m2505o(19576);
            return false;
        }
        Intent intent = new Intent(context, ExDeviceService.class);
        intent.setFlags(268435456);
        C25985d.m41477j(intent, "exdevice");
        AppMethodBeat.m2505o(19576);
        return true;
    }
}
