package com.tencent.matrix.resource.p169e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* renamed from: com.tencent.matrix.resource.e.e */
public final class C1129e {
    private final Handler bYm;
    private final long bYn;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.matrix.resource.e.e$a */
    public interface C1128a {

        /* renamed from: com.tencent.matrix.resource.e.e$a$a */
        public enum C1127a {
            DONE,
            RETRY
        }

        /* renamed from: zr */
        C1127a mo4348zr();
    }

    public C1129e(long j, HandlerThread handlerThread) {
        this.bYm = new Handler(handlerThread.getLooper());
        this.bYn = j;
    }

    /* renamed from: zu */
    public final void mo4350zu() {
        this.bYm.removeCallbacksAndMessages(null);
        this.mMainHandler.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public final void mo4349a(final C1128a c1128a, final int i) {
        this.bYm.postDelayed(new Runnable() {
            public final void run() {
                if (c1128a.mo4348zr() == C1127a.RETRY) {
                    C1129e.this.mo4349a(c1128a, i + 1);
                }
            }
        }, this.bYn);
    }
}
