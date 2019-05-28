package com.tencent.p177mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.trafficmonitor.C40012c.C29472a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.trafficmonitor.e */
public class C22442e {
    private static Map<Integer, C40012c> sKi = new ConcurrentHashMap();
    private static C22442e sKj;

    static {
        AppMethodBeat.m2504i(114787);
        AppMethodBeat.m2505o(114787);
    }

    private C22442e() {
        AppMethodBeat.m2504i(114781);
        m34130l(1, 471859200, 300000);
        m34130l(2, 838860800, 600000);
        m34130l(3, 1887436800, 1800000);
        m34130l(4, -1673527296, 3603000);
        AppMethodBeat.m2505o(114781);
    }

    public static C22442e cHE() {
        AppMethodBeat.m2504i(114782);
        if (sKj == null) {
            synchronized (C22442e.class) {
                try {
                    if (sKj == null) {
                        sKj = new C22442e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114782);
                    }
                }
            }
        }
        C22442e c22442e = sKj;
        AppMethodBeat.m2505o(114782);
        return c22442e;
    }

    /* renamed from: l */
    private void m34130l(final int i, long j, long j2) {
        AppMethodBeat.m2504i(114783);
        C29473d c29473d = new C29473d(j);
        C46315b c46315b = new C46315b();
        c46315b.f16189id = i;
        c46315b.interval = j2;
        c46315b.type = 0;
        c46315b.sJZ = c29473d;
        c46315b.sKa = new C29472a() {
        };
        sKi.put(Integer.valueOf(i), c46315b);
        AppMethodBeat.m2505o(114783);
    }

    public static void cHF() {
        AppMethodBeat.m2504i(114784);
        for (C40012c cHB : sKi.values()) {
            cHB.cHB();
        }
        AppMethodBeat.m2505o(114784);
    }

    public static void cHG() {
        AppMethodBeat.m2504i(114785);
        for (C40012c c40012c : sKi.values()) {
            c40012c.currentIndex = 0;
        }
        AppMethodBeat.m2505o(114785);
    }

    public static int cHH() {
        AppMethodBeat.m2504i(114786);
        int i = -1;
        long j = 0;
        Iterator it = sKi.values().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                C40012c c40012c = (C40012c) it.next();
                if (c40012c.interval > j2) {
                    j2 = c40012c.interval;
                    i = c40012c.f16189id;
                }
                j = j2;
            } else {
                AppMethodBeat.m2505o(114786);
                return i;
            }
        }
    }
}
