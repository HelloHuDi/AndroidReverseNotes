package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Thread extends Thread {
    private V8 runtime;
    private final V8Runnable target;

    public V8Thread(V8Runnable v8Runnable) {
        this.target = v8Runnable;
    }

    public void run() {
        AppMethodBeat.i(75159);
        this.runtime = V8.createV8Runtime();
        try {
            this.target.run(this.runtime);
            synchronized (this) {
                try {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.release();
                        this.runtime = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(75159);
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                if (this.runtime.getLocker().hasLock()) {
                    this.runtime.release();
                    this.runtime = null;
                }
            }
        } finally {
            while (true) {
            }
            AppMethodBeat.o(75159);
        }
    }
}
