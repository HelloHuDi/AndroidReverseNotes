package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class c implements com.tencent.mm.plugin.appbrand.appcache.av.c, a {
    public final void u(Map<String, String> map) {
        AppMethodBeat.i(129940);
        if (DebuggerShell.ayT()) {
            String str = (String) map.get(".sysmsg.AppBrandForceKill.AppId");
            int i = bo.getInt((String) map.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(129940);
                return;
            }
            h.bt(str, i);
        }
        AppMethodBeat.o(129940);
    }

    public final String name() {
        return "ForceKillAppNotify";
    }

    public final void A(Intent intent) {
        AppMethodBeat.i(129941);
        h.bt(intent.getStringExtra("appId"), intent.getIntExtra("versionType", 0));
        AppMethodBeat.o(129941);
    }
}
