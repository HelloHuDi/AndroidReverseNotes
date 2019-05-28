package com.tencent.p177mm.sdk.platformtools;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.sdk.platformtools.au */
public final class C5024au {
    private final String tCs;
    private byte[] xAA = new byte[0];
    private volatile boolean xAB = false;
    public final boolean xAv;
    private final String xAw;
    public SharedPreferences xAx;
    public final Map<String, Long> xAy;
    public long xAz = 0;

    public C5024au(String str, long j) {
        AppMethodBeat.m2504i(93585);
        this.tCs = str;
        this.xAv = false;
        this.xAw = "prm_" + this.tCs + "_" + j;
        try {
            this.xAx = C5018as.amG(this.xAw);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.PeriodRecorder", th, "exception happened.", new Object[0]);
            this.xAx = C4996ah.getContext().getSharedPreferences(this.xAw, 4);
        }
        this.xAy = new ConcurrentHashMap(20);
        this.xAz = j;
        AppMethodBeat.m2505o(93585);
    }

    public final void dpe() {
        AppMethodBeat.m2504i(93586);
        synchronized (this.xAA) {
            try {
                if (this.xAB) {
                    AppMethodBeat.m2505o(93586);
                    return;
                }
                if (this.xAx instanceof C5018as) {
                    String[] allKeys = ((C5018as) this.xAx).allKeys();
                    if (allKeys == null) {
                        AppMethodBeat.m2505o(93586);
                        return;
                    }
                    for (String str : allKeys) {
                        long j = this.xAx.getLong(str, 0);
                        if (j != 0) {
                            this.xAy.put(str, Long.valueOf(j));
                        }
                    }
                } else {
                    Map all = this.xAx.getAll();
                    if (all == null) {
                        AppMethodBeat.m2505o(93586);
                        return;
                    }
                    for (Entry entry : all.entrySet()) {
                        Object value = entry.getValue();
                        if (value instanceof Long) {
                            this.xAy.put(entry.getKey(), (Long) value);
                        }
                    }
                }
                this.xAB = true;
                AppMethodBeat.m2505o(93586);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(93586);
            }
        }
    }
}
