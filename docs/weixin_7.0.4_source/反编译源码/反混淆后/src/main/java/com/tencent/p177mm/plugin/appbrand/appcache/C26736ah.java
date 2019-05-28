package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p911q.C19678c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ah */
public class C26736ah extends C19678c<C42347ag> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C42347ag.fjX, "PushWxaPkgDecryptKeyTable")};

    static {
        AppMethodBeat.m2504i(59453);
        AppMethodBeat.m2505o(59453);
    }

    public C26736ah(C4927e c4927e) {
        super(c4927e, C42347ag.fjX, "PushWxaPkgDecryptKeyTable", C42347ag.diI);
    }

    /* renamed from: ap */
    public final C42347ag mo44523ap(String str, int i) {
        AppMethodBeat.m2504i(59452);
        C42347ag c42347ag = new C42347ag();
        c42347ag.field_appId = str;
        c42347ag.field_appVersion = i;
        if (mo10102b(c42347ag, new String[0])) {
            AppMethodBeat.m2505o(59452);
            return c42347ag;
        }
        AppMethodBeat.m2505o(59452);
        return null;
    }
}
