package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PrivilegedAction;

public final class i implements PrivilegedAction {
    private String evI;
    private String evJ;

    public i(String str) {
        this.evI = str;
    }

    public final Object run() {
        AppMethodBeat.i(93097);
        Object property = System.getProperty(this.evI);
        if (property == null) {
            String str = this.evJ;
            AppMethodBeat.o(93097);
            return str;
        }
        AppMethodBeat.o(93097);
        return property;
    }
}
