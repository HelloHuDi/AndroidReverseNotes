package com.tencent.matrix.a.b;

import android.os.Handler;
import com.tencent.matrix.d.b;

public final class d {
    Handler mDetectHandler;
    private boolean started = false;

    public final void j(Runnable runnable) {
        this.mDetectHandler.post(runnable);
    }

    public final void start() {
        if (!this.started) {
            this.mDetectHandler = new Handler(b.zL().getLooper());
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
