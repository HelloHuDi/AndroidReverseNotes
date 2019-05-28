package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ConcurrentV8 {
    private V8 v8;

    public ConcurrentV8() {
        AppMethodBeat.i(75030);
        this.v8 = null;
        this.v8 = V8.createV8Runtime();
        this.v8.getLocker().release();
        AppMethodBeat.o(75030);
    }

    public final V8 getV8() {
        return this.v8;
    }

    public final synchronized void run(V8Runnable v8Runnable) {
        AppMethodBeat.i(75031);
        try {
            this.v8.getLocker().acquire();
            v8Runnable.run(this.v8);
            if (this.v8 == null || this.v8.getLocker() == null || !this.v8.getLocker().hasLock()) {
                AppMethodBeat.o(75031);
            } else {
                this.v8.getLocker().release();
                AppMethodBeat.o(75031);
            }
        } catch (Throwable th) {
            if (!(this.v8 == null || this.v8.getLocker() == null || !this.v8.getLocker().hasLock())) {
                this.v8.getLocker().release();
            }
            AppMethodBeat.o(75031);
        }
    }

    public final void release() {
        AppMethodBeat.i(75032);
        if (!(this.v8 == null || this.v8.isReleased())) {
            run(new V8Runnable() {
                public void run(V8 v8) {
                    AppMethodBeat.i(75029);
                    if (!(v8 == null || v8.isReleased())) {
                        v8.release();
                    }
                    AppMethodBeat.o(75029);
                }
            });
        }
        AppMethodBeat.o(75032);
    }
}
