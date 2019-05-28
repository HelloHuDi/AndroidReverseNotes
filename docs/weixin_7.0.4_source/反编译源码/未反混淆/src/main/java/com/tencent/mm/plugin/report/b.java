package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map.Entry;

public final class b {
    private int mID = 463;
    private long mInterval = 300000;
    private long pWX;
    private HashMap<Integer, Long> pWY = new HashMap();

    public b() {
        AppMethodBeat.i(115098);
        AppMethodBeat.o(115098);
    }

    public final void g(int i, int i2, long j) {
        AppMethodBeat.i(115099);
        synchronized (this) {
            try {
                U(i, j);
                U(i2, 1);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.pWX > this.mInterval) {
                    for (Entry entry : this.pWY.entrySet()) {
                        e.pXa.a((long) this.mID, (long) ((Integer) entry.getKey()).intValue(), ((Long) entry.getValue()).longValue(), false);
                    }
                    this.pWX = currentTimeMillis;
                }
            } finally {
                AppMethodBeat.o(115099);
            }
        }
    }

    private void U(int i, long j) {
        AppMethodBeat.i(115100);
        Long l = (Long) this.pWY.get(Integer.valueOf(i));
        if (l != null) {
            j += l.longValue();
        }
        this.pWY.put(Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.o(115100);
    }
}
