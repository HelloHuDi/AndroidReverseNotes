package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b {
    private static final AtomicReference<b> buH = new AtomicReference();

    static {
        AppMethodBeat.i(10636);
        AppMethodBeat.o(10636);
    }

    private b() {
    }

    public static b uY() {
        AppMethodBeat.i(10635);
        buH.compareAndSet(null, new b());
        b bVar = (b) buH.get();
        AppMethodBeat.o(10635);
        return bVar;
    }

    public static void uZ() {
    }
}
