package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public enum a {
    MINI_PROGRAM("miniProgram", 1),
    BIZ("officialAccount", 0),
    OPENSDK("OPENSDK", 2);
    
    public final String fon;
    public final int foo;

    static {
        AppMethodBeat.o(1487);
    }

    private a(String str, int i) {
        this.fon = str;
        this.foo = i;
    }

    public static boolean oX(String str) {
        AppMethodBeat.i(1485);
        if (oY(str) != null) {
            AppMethodBeat.o(1485);
            return true;
        }
        AppMethodBeat.o(1485);
        return false;
    }

    public static a oY(String str) {
        AppMethodBeat.i(1486);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1486);
            return null;
        }
        for (a aVar : values()) {
            if (str.equals(aVar.fon)) {
                AppMethodBeat.o(1486);
                return aVar;
            }
        }
        AppMethodBeat.o(1486);
        return null;
    }
}
