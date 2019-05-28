package com.eclipsesource.p097v8.utils;

import com.eclipsesource.p097v8.C45010V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.v8.utils.ConcurrentV8 */
public final class ConcurrentV8 {
    /* renamed from: v8 */
    private C45010V8 f2427v8;

    /* renamed from: com.eclipsesource.v8.utils.ConcurrentV8$1 */
    class C85721 implements V8Runnable {
        C85721() {
        }

        public void run(C45010V8 c45010v8) {
            AppMethodBeat.m2504i(75029);
            if (!(c45010v8 == null || c45010v8.isReleased())) {
                c45010v8.release();
            }
            AppMethodBeat.m2505o(75029);
        }
    }

    public ConcurrentV8() {
        AppMethodBeat.m2504i(75030);
        this.f2427v8 = null;
        this.f2427v8 = C45010V8.createV8Runtime();
        this.f2427v8.getLocker().release();
        AppMethodBeat.m2505o(75030);
    }

    public final C45010V8 getV8() {
        return this.f2427v8;
    }

    public final synchronized void run(V8Runnable v8Runnable) {
        AppMethodBeat.m2504i(75031);
        try {
            this.f2427v8.getLocker().acquire();
            v8Runnable.run(this.f2427v8);
            if (this.f2427v8 == null || this.f2427v8.getLocker() == null || !this.f2427v8.getLocker().hasLock()) {
                AppMethodBeat.m2505o(75031);
            } else {
                this.f2427v8.getLocker().release();
                AppMethodBeat.m2505o(75031);
            }
        } catch (Throwable th) {
            if (!(this.f2427v8 == null || this.f2427v8.getLocker() == null || !this.f2427v8.getLocker().hasLock())) {
                this.f2427v8.getLocker().release();
            }
            AppMethodBeat.m2505o(75031);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(75032);
        if (!(this.f2427v8 == null || this.f2427v8.isReleased())) {
            run(new C85721());
        }
        AppMethodBeat.m2505o(75032);
    }
}
