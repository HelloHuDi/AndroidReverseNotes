package com.tencent.p177mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.gdpr.a */
public enum C32791a {
    MINI_PROGRAM("miniProgram", 1),
    BIZ("officialAccount", 0),
    OPENSDK("OPENSDK", 2);
    
    public final String fon;
    public final int foo;

    static {
        AppMethodBeat.m2505o(1487);
    }

    private C32791a(String str, int i) {
        this.fon = str;
        this.foo = i;
    }

    /* renamed from: oX */
    public static boolean m53567oX(String str) {
        AppMethodBeat.m2504i(1485);
        if (C32791a.m53568oY(str) != null) {
            AppMethodBeat.m2505o(1485);
            return true;
        }
        AppMethodBeat.m2505o(1485);
        return false;
    }

    /* renamed from: oY */
    public static C32791a m53568oY(String str) {
        AppMethodBeat.m2504i(1486);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1486);
            return null;
        }
        for (C32791a c32791a : C32791a.values()) {
            if (str.equals(c32791a.fon)) {
                AppMethodBeat.m2505o(1486);
                return c32791a;
            }
        }
        AppMethodBeat.m2505o(1486);
        return null;
    }
}
