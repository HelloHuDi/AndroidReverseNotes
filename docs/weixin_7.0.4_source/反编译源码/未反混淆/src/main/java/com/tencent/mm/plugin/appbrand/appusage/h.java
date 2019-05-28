package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0002\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"TAG", "", "component1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "component2", "", "plugin-appbrand-integration_release"})
public final class h {
    public static final String a(AppIdentity appIdentity) {
        AppMethodBeat.i(134537);
        j.p(appIdentity, "receiver$0");
        String str = appIdentity.username;
        AppMethodBeat.o(134537);
        return str;
    }

    public static final int b(AppIdentity appIdentity) {
        AppMethodBeat.i(134538);
        j.p(appIdentity, "receiver$0");
        int i = appIdentity.har;
        AppMethodBeat.o(134538);
        return i;
    }
}
