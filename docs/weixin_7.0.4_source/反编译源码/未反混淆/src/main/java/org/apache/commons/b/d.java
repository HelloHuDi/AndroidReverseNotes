package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static final String BXc = "\"";
    private static final char[] BXd = new char[]{',', '\"', 13, 10};

    public static String awL(String str) {
        AppMethodBeat.i(116956);
        if (str == null) {
            AppMethodBeat.o(116956);
            return null;
        }
        String unescape = b.BWT.unescape(str);
        AppMethodBeat.o(116956);
        return unescape;
    }
}
