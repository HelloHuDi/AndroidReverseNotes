package com.tencent.p177mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.compatible.util.n */
public final class C41944n {
    public static <T> T checkNotNull(T t) {
        AppMethodBeat.m2504i(93107);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(93107);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(93107);
        return t;
    }
}
