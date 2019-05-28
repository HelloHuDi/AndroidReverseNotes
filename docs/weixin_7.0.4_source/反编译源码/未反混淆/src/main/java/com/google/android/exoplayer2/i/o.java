package com.google.android.exoplayer2.i;

import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;

public final class o {
    public final PriorityQueue<Integer> brx;
    public int bry;
    public final Object lock;

    public final void tP() {
        AppMethodBeat.i(95931);
        synchronized (this.lock) {
            try {
                this.brx.remove(Integer.valueOf(0));
                this.bry = this.brx.isEmpty() ? j.INVALID_ID : ((Integer) this.brx.peek()).intValue();
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.o(95931);
            }
        }
    }
}
