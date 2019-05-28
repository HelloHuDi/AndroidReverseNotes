package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class d {
    private static final Pattern BZq = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    static {
        AppMethodBeat.i(77307);
        AppMethodBeat.o(77307);
    }

    public static void r(Object obj, String str) {
        AppMethodBeat.i(77308);
        A(obj != null, str);
        AppMethodBeat.o(77308);
    }

    public static void jn(String str, String str2) {
        AppMethodBeat.i(77309);
        boolean z = (str == null || str.trim().equals("")) ? false : true;
        A(z, str2);
        AppMethodBeat.o(77309);
    }

    private static void A(boolean z, String str) {
        AppMethodBeat.i(77310);
        if (str == null || str.trim().length() <= 0) {
            str = "Received an invalid parameter";
        }
        if (z) {
            AppMethodBeat.o(77310);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        AppMethodBeat.o(77310);
        throw illegalArgumentException;
    }
}
