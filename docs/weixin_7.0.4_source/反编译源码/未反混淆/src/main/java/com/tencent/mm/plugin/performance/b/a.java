package com.tencent.mm.plugin.performance.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.g.a.f;
import com.tencent.mm.sdk.g.c.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.g.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a implements f {
    private ak pfT;
    private Runnable pfU = new b() {
        public final String getKey() {
            return "checkBusyTimeout";
        }

        public final void run() {
            AppMethodBeat.i(111073);
            d.xDG.d(new HashMap(), new HashMap());
            e.pXa.a(960, 6, 1, false);
            e.pXa.e(16347, r0.toString(), Integer.valueOf(d.xDG.cin().getCorePoolSize()), "", Long.valueOf(1800000), Integer.valueOf(2));
            ab.w("MicroMsg.ThreadPool.Profile", "on busy timeout! runningMap:%s", r0);
            ab.w("MicroMsg.ThreadPool.Profile", "on busy timeout! waitingMap:%s", r9);
            AppMethodBeat.o(111073);
        }
    };
    final AtomicInteger pfV = new AtomicInteger(0);

    public a() {
        AppMethodBeat.i(111074);
        HandlerThread anN = c.anN("ThreadPoolProfile");
        anN.start();
        this.pfT = new ak(anN.getLooper());
        AppMethodBeat.o(111074);
    }

    public final void a(com.tencent.mm.sdk.g.e eVar) {
        AppMethodBeat.i(111075);
        ab.i("MicroMsg.ThreadPool.Profile", "[onTaskAdded] %s", eVar);
        if (this.pfV.incrementAndGet() >= 50) {
            ab.w("MicroMsg.ThreadPool.Profile", "dumpRunningTask: %s", d.xDG.dqb());
            com.tencent.mm.sdk.g.b.a cin = d.xDG.cin();
            if (cin instanceof com.tencent.mm.sdk.g.b.e) {
                if (((com.tencent.mm.sdk.g.b.e) cin).xEB instanceof com.tencent.mm.sdk.g.b.d) {
                    ab.w("MicroMsg.ThreadPool.Profile", "printWorkerStatus: %s", ((com.tencent.mm.sdk.g.b.d) ((com.tencent.mm.sdk.g.b.e) cin).xEB).dqm());
                }
            }
            this.pfV.set(0);
        }
        AppMethodBeat.o(111075);
    }

    public final void b(com.tencent.mm.sdk.g.e eVar) {
        AppMethodBeat.i(111076);
        ab.i("MicroMsg.ThreadPool.Profile", "[onTaskBeforeExecute] %s", eVar);
        this.pfV.decrementAndGet();
        AppMethodBeat.o(111076);
    }

    public final void c(com.tencent.mm.sdk.g.e eVar) {
        AppMethodBeat.i(111077);
        ab.i("MicroMsg.ThreadPool.Profile", "[onTaskAfterExecuted] %s", eVar);
        AppMethodBeat.o(111077);
    }

    public final void d(com.tencent.mm.sdk.g.e eVar) {
        AppMethodBeat.i(111078);
        ab.i("MicroMsg.ThreadPool.Profile", "[onTaskRemove] %s", eVar);
        AppMethodBeat.o(111078);
    }

    public final void e(com.tencent.mm.sdk.g.e eVar) {
        AppMethodBeat.i(111079);
        ab.i("MicroMsg.ThreadPool.Profile", "[onTaskTimeout] %s", eVar);
        e.pXa.a(960, 1, 1, false);
        e.pXa.e(16347, "", Integer.valueOf(0), eVar.toString(), Long.valueOf(1800000), Integer.valueOf(1));
        AppMethodBeat.o(111079);
    }

    public final void jt(long j) {
        AppMethodBeat.i(111081);
        this.pfT.removeCallbacks(this.pfU);
        ab.w("MicroMsg.ThreadPool.Profile", "[onRelax] duration:%s", Long.valueOf(j));
        e.pXa.a(960, 2, 1, false);
        e.pXa.a(960, 4, Math.max(1, j), false);
        AppMethodBeat.o(111081);
    }

    public final void a(Object obj, Throwable th) {
        AppMethodBeat.i(111082);
        ab.e("MicroMsg.ThreadPool.Profile", "[onException] %s %s", obj, th);
        e.pXa.a(960, 5, 1, false);
        AppMethodBeat.o(111082);
    }

    public final void x(String str, long j, long j2) {
        AppMethodBeat.i(111083);
        if (ab.getLogLevel() <= 1) {
            ab.d("MicroMsg.ThreadPool.Profile", "[onLog] %s %s %s", str, Long.valueOf(j), Long.valueOf(j2));
        }
        AppMethodBeat.o(111083);
    }

    public final void a(int i, List<com.tencent.mm.sdk.g.e> list, List<com.tencent.mm.sdk.g.e> list2) {
        AppMethodBeat.i(111080);
        HashMap hashMap = new HashMap();
        for (com.tencent.mm.sdk.g.e eVar : list2) {
            if (hashMap.containsKey(eVar.name)) {
                hashMap.put(eVar.name, Integer.valueOf(((Integer) hashMap.get(eVar.name)).intValue() + 1));
            } else {
                hashMap.put(eVar.name, Integer.valueOf(1));
            }
        }
        String hashMap2 = hashMap.toString();
        ab.w("MicroMsg.ThreadPool.Profile", "[onBusy] coreSize:%s waiting:%s running:%s", Integer.valueOf(i), Integer.valueOf(list.size()), hashMap2);
        e.pXa.a(960, 0, 1, false);
        this.pfT.postDelayed(this.pfU, 1800000);
        AppMethodBeat.o(111080);
    }
}
