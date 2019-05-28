package com.tencent.xweb.p685x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.xweb.p1115c.C44578g;

/* renamed from: com.tencent.xweb.x5.j */
public final class C16407j implements C44578g {
    public final void deleteOrigin(String str) {
        AppMethodBeat.m2504i(84882);
        WebStorage.getInstance().deleteOrigin(str);
        AppMethodBeat.m2505o(84882);
    }
}
