package com.tencent.mm.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    static final ThreadLocal<String> xDy = new ThreadLocal();

    static {
        AppMethodBeat.i(52522);
        AppMethodBeat.o(52522);
    }

    protected static void setTag(String str) {
        AppMethodBeat.i(52520);
        xDy.set(str);
        AppMethodBeat.o(52520);
    }

    public static String getTag() {
        AppMethodBeat.i(52521);
        String str = (String) xDy.get();
        AppMethodBeat.o(52521);
        return str;
    }
}
