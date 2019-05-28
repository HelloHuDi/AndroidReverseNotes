package com.tencent.p177mm.sdk.p604g;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.g.a */
public final class C4945a {
    static final ThreadLocal<String> xDy = new ThreadLocal();

    static {
        AppMethodBeat.m2504i(52522);
        AppMethodBeat.m2505o(52522);
    }

    protected static void setTag(String str) {
        AppMethodBeat.m2504i(52520);
        xDy.set(str);
        AppMethodBeat.m2505o(52520);
    }

    public static String getTag() {
        AppMethodBeat.m2504i(52521);
        String str = (String) xDy.get();
        AppMethodBeat.m2505o(52521);
        return str;
    }
}
