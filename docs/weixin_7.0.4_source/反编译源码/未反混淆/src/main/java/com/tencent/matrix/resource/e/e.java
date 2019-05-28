package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e {
    private final Handler bYm;
    private final long bYn;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    public interface a {

        public enum a {
            DONE,
            RETRY
        }

        a zr();
    }

    public e(long j, HandlerThread handlerThread) {
        this.bYm = new Handler(handlerThread.getLooper());
        this.bYn = j;
    }

    public final void zu() {
        this.bYm.removeCallbacksAndMessages(null);
        this.mMainHandler.removeCallbacksAndMessages(null);
    }

    public final void a(final a aVar, final int i) {
        this.bYm.postDelayed(new Runnable() {
            public final void run() {
                if (aVar.zr() == a.RETRY) {
                    e.this.a(aVar, i + 1);
                }
            }
        }, this.bYn);
    }
}
