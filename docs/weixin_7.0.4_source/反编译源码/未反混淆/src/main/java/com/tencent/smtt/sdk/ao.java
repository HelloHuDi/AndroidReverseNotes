package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao extends ThreadLocal<Integer> {
    ao() {
    }

    public final Integer a() {
        AppMethodBeat.i(64395);
        Integer valueOf = Integer.valueOf(0);
        AppMethodBeat.o(64395);
        return valueOf;
    }

    public final /* synthetic */ Object initialValue() {
        AppMethodBeat.i(64396);
        Integer a = a();
        AppMethodBeat.o(64396);
        return a;
    }
}
