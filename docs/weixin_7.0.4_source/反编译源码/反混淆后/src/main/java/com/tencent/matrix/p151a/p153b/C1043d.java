package com.tencent.matrix.p151a.p153b;

import android.os.Handler;
import com.tencent.matrix.p157d.C1068b;

/* renamed from: com.tencent.matrix.a.b.d */
public final class C1043d {
    Handler mDetectHandler;
    private boolean started = false;

    /* renamed from: j */
    public final void mo4176j(Runnable runnable) {
        this.mDetectHandler.post(runnable);
    }

    public final void start() {
        if (!this.started) {
            this.mDetectHandler = new Handler(C1068b.m2358zL().getLooper());
            this.started = true;
        }
    }

    public final void quit() {
        if (this.started) {
            this.mDetectHandler.removeCallbacksAndMessages(null);
            this.started = false;
        }
    }
}
