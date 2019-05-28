package com.tencent.p177mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.report.b */
public final class C3734b {
    private int mID = 463;
    private long mInterval = 300000;
    private long pWX;
    private HashMap<Integer, Long> pWY = new HashMap();

    public C3734b() {
        AppMethodBeat.m2504i(115098);
        AppMethodBeat.m2505o(115098);
    }

    /* renamed from: g */
    public final void mo8373g(int i, int i2, long j) {
        AppMethodBeat.m2504i(115099);
        synchronized (this) {
            try {
                m6041U(i, j);
                m6041U(i2, 1);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.pWX > this.mInterval) {
                    for (Entry entry : this.pWY.entrySet()) {
                        C7053e.pXa.mo8378a((long) this.mID, (long) ((Integer) entry.getKey()).intValue(), ((Long) entry.getValue()).longValue(), false);
                    }
                    this.pWX = currentTimeMillis;
                }
            } finally {
                AppMethodBeat.m2505o(115099);
            }
        }
    }

    /* renamed from: U */
    private void m6041U(int i, long j) {
        AppMethodBeat.m2504i(115100);
        Long l = (Long) this.pWY.get(Integer.valueOf(i));
        if (l != null) {
            j += l.longValue();
        }
        this.pWY.put(Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.m2505o(115100);
    }
}
