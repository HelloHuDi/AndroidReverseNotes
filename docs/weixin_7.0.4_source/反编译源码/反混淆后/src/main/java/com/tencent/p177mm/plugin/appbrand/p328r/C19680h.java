package com.tencent.p177mm.plugin.appbrand.p328r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.r.h */
public final class C19680h {
    private static final Set<Object> hvE = new HashSet();

    static {
        AppMethodBeat.m2504i(91164);
        AppMethodBeat.m2505o(91164);
    }

    /* renamed from: bB */
    public static <T> T m30479bB(T t) {
        AppMethodBeat.m2504i(91162);
        if (t != null) {
            hvE.add(t);
        }
        AppMethodBeat.m2505o(91162);
        return t;
    }

    /* renamed from: at */
    public static void m30478at(Object obj) {
        AppMethodBeat.m2504i(91163);
        hvE.remove(obj);
        AppMethodBeat.m2505o(91163);
    }
}
