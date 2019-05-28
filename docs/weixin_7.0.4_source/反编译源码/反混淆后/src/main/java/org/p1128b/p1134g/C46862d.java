package org.p1128b.p1134g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

/* renamed from: org.b.g.d */
public final class C46862d {
    private static final Pattern BZq = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    static {
        AppMethodBeat.m2504i(77307);
        AppMethodBeat.m2505o(77307);
    }

    /* renamed from: r */
    public static void m89100r(Object obj, String str) {
        AppMethodBeat.m2504i(77308);
        C46862d.m89098A(obj != null, str);
        AppMethodBeat.m2505o(77308);
    }

    /* renamed from: jn */
    public static void m89099jn(String str, String str2) {
        AppMethodBeat.m2504i(77309);
        boolean z = (str == null || str.trim().equals("")) ? false : true;
        C46862d.m89098A(z, str2);
        AppMethodBeat.m2505o(77309);
    }

    /* renamed from: A */
    private static void m89098A(boolean z, String str) {
        AppMethodBeat.m2504i(77310);
        if (str == null || str.trim().length() <= 0) {
            str = "Received an invalid parameter";
        }
        if (z) {
            AppMethodBeat.m2505o(77310);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        AppMethodBeat.m2505o(77310);
        throw illegalArgumentException;
    }
}
