package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C33076av.C33079c;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell.C38172a;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.c */
public final class C10187c implements C33079c, C38172a {
    /* renamed from: u */
    public final void mo5821u(Map<String, String> map) {
        AppMethodBeat.m2504i(129940);
        if (DebuggerShell.ayT()) {
            String str = (String) map.get(".sysmsg.AppBrandForceKill.AppId");
            int i = C5046bo.getInt((String) map.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(129940);
                return;
            }
            C45694h.m84422bt(str, i);
        }
        AppMethodBeat.m2505o(129940);
    }

    public final String name() {
        return "ForceKillAppNotify";
    }

    /* renamed from: A */
    public final void mo21580A(Intent intent) {
        AppMethodBeat.m2504i(129941);
        C45694h.m84422bt(intent.getStringExtra("appId"), intent.getIntExtra("versionType", 0));
        AppMethodBeat.m2505o(129941);
    }
}
