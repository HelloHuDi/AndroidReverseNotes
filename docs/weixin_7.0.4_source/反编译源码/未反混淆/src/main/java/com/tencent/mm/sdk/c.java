package com.tencent.mm.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bg;

public class c<T> extends bg<T> {
    private final Object mLock = new Object();

    public c(int i) {
        super(i);
        AppMethodBeat.i(51962);
        AppMethodBeat.o(51962);
    }

    public final T aA() {
        T aA;
        AppMethodBeat.i(51963);
        synchronized (this.mLock) {
            try {
                aA = super.aA();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51963);
            }
        }
        return aA;
    }

    public final boolean release(T t) {
        boolean release;
        AppMethodBeat.i(51964);
        synchronized (this.mLock) {
            try {
                release = super.release(t);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(51964);
            }
        }
        return release;
    }
}
