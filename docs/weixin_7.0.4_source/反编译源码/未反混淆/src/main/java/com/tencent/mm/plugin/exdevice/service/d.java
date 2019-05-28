package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    public static boolean dI(Context context) {
        AppMethodBeat.i(19576);
        if (l.bL(context)) {
            ab.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
            AppMethodBeat.o(19576);
            return false;
        }
        Intent intent = new Intent(context, ExDeviceService.class);
        intent.setFlags(268435456);
        com.tencent.mm.bp.d.j(intent, "exdevice");
        AppMethodBeat.o(19576);
        return true;
    }
}
