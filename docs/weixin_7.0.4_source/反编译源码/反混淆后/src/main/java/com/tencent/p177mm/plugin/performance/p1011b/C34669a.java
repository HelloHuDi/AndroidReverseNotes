package com.tencent.p177mm.plugin.performance.p1011b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p604g.C4969e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p605a.C4944f;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.p604g.p606b.C7299d;
import com.tencent.p177mm.sdk.p604g.p606b.C7301e;
import com.tencent.p177mm.sdk.p604g.p607c.C4960c;
import com.tencent.p177mm.sdk.p604g.p608d.C4967b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.performance.b.a */
public final class C34669a implements C4944f {
    private C7306ak pfT;
    private Runnable pfU = new C128031();
    final AtomicInteger pfV = new AtomicInteger(0);

    /* renamed from: com.tencent.mm.plugin.performance.b.a$1 */
    class C128031 implements C4967b {
        C128031() {
        }

        public final String getKey() {
            return "checkBusyTimeout";
        }

        public final void run() {
            AppMethodBeat.m2504i(111073);
            C7305d.xDG.mo10155d(new HashMap(), new HashMap());
            C7053e.pXa.mo8378a(960, 6, 1, false);
            C7053e.pXa.mo8381e(16347, r0.toString(), Integer.valueOf(C7305d.xDG.cin().getCorePoolSize()), "", Long.valueOf(1800000), Integer.valueOf(2));
            C4990ab.m7421w("MicroMsg.ThreadPool.Profile", "on busy timeout! runningMap:%s", r0);
            C4990ab.m7421w("MicroMsg.ThreadPool.Profile", "on busy timeout! waitingMap:%s", r9);
            AppMethodBeat.m2505o(111073);
        }
    }

    public C34669a() {
        AppMethodBeat.m2504i(111074);
        HandlerThread anN = C4960c.anN("ThreadPoolProfile");
        anN.start();
        this.pfT = new C7306ak(anN.getLooper());
        AppMethodBeat.m2505o(111074);
    }

    /* renamed from: a */
    public final void mo10164a(C4969e c4969e) {
        AppMethodBeat.m2504i(111075);
        C4990ab.m7417i("MicroMsg.ThreadPool.Profile", "[onTaskAdded] %s", c4969e);
        if (this.pfV.incrementAndGet() >= 50) {
            C4990ab.m7421w("MicroMsg.ThreadPool.Profile", "dumpRunningTask: %s", C7305d.xDG.dqb());
            C4946a cin = C7305d.xDG.cin();
            if (cin instanceof C7301e) {
                if (((C7301e) cin).xEB instanceof C7299d) {
                    C4990ab.m7421w("MicroMsg.ThreadPool.Profile", "printWorkerStatus: %s", ((C7299d) ((C7301e) cin).xEB).dqm());
                }
            }
            this.pfV.set(0);
        }
        AppMethodBeat.m2505o(111075);
    }

    /* renamed from: b */
    public final void mo10166b(C4969e c4969e) {
        AppMethodBeat.m2504i(111076);
        C4990ab.m7417i("MicroMsg.ThreadPool.Profile", "[onTaskBeforeExecute] %s", c4969e);
        this.pfV.decrementAndGet();
        AppMethodBeat.m2505o(111076);
    }

    /* renamed from: c */
    public final void mo10167c(C4969e c4969e) {
        AppMethodBeat.m2504i(111077);
        C4990ab.m7417i("MicroMsg.ThreadPool.Profile", "[onTaskAfterExecuted] %s", c4969e);
        AppMethodBeat.m2505o(111077);
    }

    /* renamed from: d */
    public final void mo10168d(C4969e c4969e) {
        AppMethodBeat.m2504i(111078);
        C4990ab.m7417i("MicroMsg.ThreadPool.Profile", "[onTaskRemove] %s", c4969e);
        AppMethodBeat.m2505o(111078);
    }

    /* renamed from: e */
    public final void mo10169e(C4969e c4969e) {
        AppMethodBeat.m2504i(111079);
        C4990ab.m7417i("MicroMsg.ThreadPool.Profile", "[onTaskTimeout] %s", c4969e);
        C7053e.pXa.mo8378a(960, 1, 1, false);
        C7053e.pXa.mo8381e(16347, "", Integer.valueOf(0), c4969e.toString(), Long.valueOf(1800000), Integer.valueOf(1));
        AppMethodBeat.m2505o(111079);
    }

    /* renamed from: jt */
    public final void mo10170jt(long j) {
        AppMethodBeat.m2504i(111081);
        this.pfT.removeCallbacks(this.pfU);
        C4990ab.m7421w("MicroMsg.ThreadPool.Profile", "[onRelax] duration:%s", Long.valueOf(j));
        C7053e.pXa.mo8378a(960, 2, 1, false);
        C7053e.pXa.mo8378a(960, 4, Math.max(1, j), false);
        AppMethodBeat.m2505o(111081);
    }

    /* renamed from: a */
    public final void mo10165a(Object obj, Throwable th) {
        AppMethodBeat.m2504i(111082);
        C4990ab.m7413e("MicroMsg.ThreadPool.Profile", "[onException] %s %s", obj, th);
        C7053e.pXa.mo8378a(960, 5, 1, false);
        AppMethodBeat.m2505o(111082);
    }

    /* renamed from: x */
    public final void mo10171x(String str, long j, long j2) {
        AppMethodBeat.m2504i(111083);
        if (C4990ab.getLogLevel() <= 1) {
            C4990ab.m7411d("MicroMsg.ThreadPool.Profile", "[onLog] %s %s %s", str, Long.valueOf(j), Long.valueOf(j2));
        }
        AppMethodBeat.m2505o(111083);
    }

    /* renamed from: a */
    public final void mo10163a(int i, List<C4969e> list, List<C4969e> list2) {
        AppMethodBeat.m2504i(111080);
        HashMap hashMap = new HashMap();
        for (C4969e c4969e : list2) {
            if (hashMap.containsKey(c4969e.name)) {
                hashMap.put(c4969e.name, Integer.valueOf(((Integer) hashMap.get(c4969e.name)).intValue() + 1));
            } else {
                hashMap.put(c4969e.name, Integer.valueOf(1));
            }
        }
        String hashMap2 = hashMap.toString();
        C4990ab.m7421w("MicroMsg.ThreadPool.Profile", "[onBusy] coreSize:%s waiting:%s running:%s", Integer.valueOf(i), Integer.valueOf(list.size()), hashMap2);
        C7053e.pXa.mo8378a(960, 0, 1, false);
        this.pfT.postDelayed(this.pfU, 1800000);
        AppMethodBeat.m2505o(111080);
    }
}
