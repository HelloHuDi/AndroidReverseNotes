package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0002\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"TAG", "", "component1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "component2", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.h */
public final class C38130h {
    /* renamed from: a */
    public static final String m64523a(AppIdentity appIdentity) {
        AppMethodBeat.m2504i(134537);
        C25052j.m39376p(appIdentity, "receiver$0");
        String str = appIdentity.username;
        AppMethodBeat.m2505o(134537);
        return str;
    }

    /* renamed from: b */
    public static final int m64524b(AppIdentity appIdentity) {
        AppMethodBeat.m2504i(134538);
        C25052j.m39376p(appIdentity, "receiver$0");
        int i = appIdentity.har;
        AppMethodBeat.m2505o(134538);
        return i;
    }
}
