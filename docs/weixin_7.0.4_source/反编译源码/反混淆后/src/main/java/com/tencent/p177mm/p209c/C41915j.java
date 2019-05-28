package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.c.j */
public final class C41915j {
    public static int getInt(String str, int i) {
        AppMethodBeat.m2504i(125685);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.m2505o(125685);
                    return i;
                }
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(125685);
            }
        }
        AppMethodBeat.m2505o(125685);
        return i;
    }
}
