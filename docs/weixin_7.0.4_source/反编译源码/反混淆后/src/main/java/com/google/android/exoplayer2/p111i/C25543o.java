package com.google.android.exoplayer2.p111i;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;

/* renamed from: com.google.android.exoplayer2.i.o */
public final class C25543o {
    public final PriorityQueue<Integer> brx;
    public int bry;
    public final Object lock;

    /* renamed from: tP */
    public final void mo42799tP() {
        AppMethodBeat.m2504i(95931);
        synchronized (this.lock) {
            try {
                this.brx.remove(Integer.valueOf(0));
                this.bry = this.brx.isEmpty() ? C8415j.INVALID_ID : ((Integer) this.brx.peek()).intValue();
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.m2505o(95931);
            }
        }
    }
}
