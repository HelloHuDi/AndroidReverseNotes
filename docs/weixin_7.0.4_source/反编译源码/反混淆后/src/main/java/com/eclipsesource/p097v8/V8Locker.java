package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.V8Locker */
public class V8Locker {
    private boolean released = false;
    private C45010V8 runtime;
    private Thread thread = null;

    V8Locker(C45010V8 c45010v8) {
        AppMethodBeat.m2504i(75502);
        this.runtime = c45010v8;
        acquire();
        AppMethodBeat.m2505o(75502);
    }

    public Thread getThread() {
        return this.thread;
    }

    public synchronized void acquire() {
        AppMethodBeat.m2504i(75503);
        if (this.thread != null && this.thread != Thread.currentThread()) {
            Error error = new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
            AppMethodBeat.m2505o(75503);
            throw error;
        } else if (this.thread == Thread.currentThread()) {
            AppMethodBeat.m2505o(75503);
        } else {
            this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
            this.thread = Thread.currentThread();
            this.released = false;
            AppMethodBeat.m2505o(75503);
        }
    }

    public synchronized boolean tryAcquire() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(75504);
            if (this.thread != null && this.thread != Thread.currentThread()) {
                AppMethodBeat.m2505o(75504);
            } else if (this.thread == Thread.currentThread()) {
                AppMethodBeat.m2505o(75504);
                z = true;
            } else {
                this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
                this.thread = Thread.currentThread();
                this.released = false;
                AppMethodBeat.m2505o(75504);
                z = true;
            }
        }
        return z;
    }

    public synchronized void release() {
        AppMethodBeat.m2504i(75505);
        if ((this.released && this.thread == null) || this.runtime.isReleased()) {
            AppMethodBeat.m2505o(75505);
        } else {
            checkThread();
            this.runtime.releaseLock(this.runtime.getV8RuntimePtr());
            this.thread = null;
            this.released = true;
            AppMethodBeat.m2505o(75505);
        }
    }

    public void checkThread() {
        AppMethodBeat.m2504i(75506);
        Error error;
        if (this.released && this.thread == null) {
            error = new Error("Invalid V8 thread access: the locker has been released!");
            AppMethodBeat.m2505o(75506);
            throw error;
        } else if (this.thread != Thread.currentThread()) {
            error = new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
            AppMethodBeat.m2505o(75506);
            throw error;
        } else {
            AppMethodBeat.m2505o(75506);
        }
    }

    public boolean hasLock() {
        AppMethodBeat.m2504i(75507);
        if (this.thread == Thread.currentThread()) {
            AppMethodBeat.m2505o(75507);
            return true;
        }
        AppMethodBeat.m2505o(75507);
        return false;
    }
}
