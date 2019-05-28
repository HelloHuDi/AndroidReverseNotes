package com.tencent.p177mm.plugin.appbrand.p329s;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.s.k */
public final class C42680k {
    /* renamed from: bG */
    public static Boolean m75587bG(Object obj) {
        AppMethodBeat.m2504i(87423);
        Boolean bool;
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
            AppMethodBeat.m2505o(87423);
            return bool;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                bool = Boolean.TRUE;
                AppMethodBeat.m2505o(87423);
                return bool;
            } else if ("false".equalsIgnoreCase(str)) {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(87423);
                return bool;
            }
        }
        AppMethodBeat.m2505o(87423);
        return null;
    }
}
