package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public static Boolean bG(Object obj) {
        AppMethodBeat.i(87423);
        Boolean bool;
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
            AppMethodBeat.o(87423);
            return bool;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                bool = Boolean.TRUE;
                AppMethodBeat.o(87423);
                return bool;
            } else if ("false".equalsIgnoreCase(str)) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(87423);
                return bool;
            }
        }
        AppMethodBeat.o(87423);
        return null;
    }
}
