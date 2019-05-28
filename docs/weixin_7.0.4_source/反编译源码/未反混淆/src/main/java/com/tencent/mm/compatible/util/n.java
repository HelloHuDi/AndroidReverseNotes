package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n {
    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(93107);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(93107);
            throw nullPointerException;
        }
        AppMethodBeat.o(93107);
        return t;
    }
}
