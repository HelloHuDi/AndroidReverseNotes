package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T> {
    private c<T> Aix;
    private byte[] eHH = new byte[0];
    private volatile T mInstance;

    public h(c<T> cVar) {
        AppMethodBeat.i(59239);
        this.Aix = cVar;
        AppMethodBeat.o(59239);
    }

    public final T get() {
        AppMethodBeat.i(59240);
        if (this.mInstance == null) {
            synchronized (this.eHH) {
                try {
                    if (this.mInstance == null) {
                        this.mInstance = this.Aix.get();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(59240);
                    }
                }
            }
        }
        Object obj = this.mInstance;
        AppMethodBeat.o(59240);
        return obj;
    }
}
