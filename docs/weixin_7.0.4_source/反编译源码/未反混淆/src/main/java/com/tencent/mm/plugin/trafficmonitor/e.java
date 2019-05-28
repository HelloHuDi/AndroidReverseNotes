package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.trafficmonitor.c.a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static Map<Integer, c> sKi = new ConcurrentHashMap();
    private static e sKj;

    static {
        AppMethodBeat.i(114787);
        AppMethodBeat.o(114787);
    }

    private e() {
        AppMethodBeat.i(114781);
        l(1, 471859200, 300000);
        l(2, 838860800, 600000);
        l(3, 1887436800, 1800000);
        l(4, -1673527296, 3603000);
        AppMethodBeat.o(114781);
    }

    public static e cHE() {
        AppMethodBeat.i(114782);
        if (sKj == null) {
            synchronized (e.class) {
                try {
                    if (sKj == null) {
                        sKj = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114782);
                    }
                }
            }
        }
        e eVar = sKj;
        AppMethodBeat.o(114782);
        return eVar;
    }

    private void l(final int i, long j, long j2) {
        AppMethodBeat.i(114783);
        d dVar = new d(j);
        b bVar = new b();
        bVar.id = i;
        bVar.interval = j2;
        bVar.type = 0;
        bVar.sJZ = dVar;
        bVar.sKa = new a() {
        };
        sKi.put(Integer.valueOf(i), bVar);
        AppMethodBeat.o(114783);
    }

    public static void cHF() {
        AppMethodBeat.i(114784);
        for (c cHB : sKi.values()) {
            cHB.cHB();
        }
        AppMethodBeat.o(114784);
    }

    public static void cHG() {
        AppMethodBeat.i(114785);
        for (c cVar : sKi.values()) {
            cVar.currentIndex = 0;
        }
        AppMethodBeat.o(114785);
    }

    public static int cHH() {
        AppMethodBeat.i(114786);
        int i = -1;
        long j = 0;
        Iterator it = sKi.values().iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.interval > j2) {
                    j2 = cVar.interval;
                    i = cVar.id;
                }
                j = j2;
            } else {
                AppMethodBeat.o(114786);
                return i;
            }
        }
    }
}
