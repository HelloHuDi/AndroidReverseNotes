package com.tencent.p177mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PrivilegedAction;

/* renamed from: com.tencent.mm.compatible.util.i */
public final class C26053i implements PrivilegedAction {
    private String evI;
    private String evJ;

    public C26053i(String str) {
        this.evI = str;
    }

    public final Object run() {
        AppMethodBeat.m2504i(93097);
        Object property = System.getProperty(this.evI);
        if (property == null) {
            String str = this.evJ;
            AppMethodBeat.m2505o(93097);
            return str;
        }
        AppMethodBeat.m2505o(93097);
        return property;
    }
}
