package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;

public final class e<T> {
    private T cnY;

    public e(T t) {
        this.cnY = t;
    }

    public final synchronized T al(T t) {
        Object obj;
        AppMethodBeat.i(137194);
        obj = this.cnY;
        this.cnY = t;
        b.i("StateRunner", obj.toString() + " -> " + this.cnY.toString());
        AppMethodBeat.o(137194);
        return obj;
    }

    public final synchronized boolean g(T... tArr) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(137195);
            for (int i = 0; i <= 0; i++) {
                if (this.cnY.equals(tArr[0])) {
                    z = true;
                    AppMethodBeat.o(137195);
                    break;
                }
            }
            AppMethodBeat.o(137195);
        }
        return z;
    }

    public final synchronized T get() {
        return this.cnY;
    }
}
