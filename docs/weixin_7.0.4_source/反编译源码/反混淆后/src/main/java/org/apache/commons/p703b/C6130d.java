package org.apache.commons.p703b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: org.apache.commons.b.d */
public final class C6130d {
    private static final String BXc = "\"";
    private static final char[] BXd = new char[]{',', '\"', 13, 10};

    public static String awL(String str) {
        AppMethodBeat.m2504i(116956);
        if (str == null) {
            AppMethodBeat.m2505o(116956);
            return null;
        }
        String unescape = C6124b.BWT.unescape(str);
        AppMethodBeat.m2505o(116956);
        return unescape;
    }
}
