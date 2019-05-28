package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cm */
public final class C16215cm {
    /* renamed from: a */
    private static C16215cm f3186a = new C16215cm();
    /* renamed from: b */
    private Timer f3187b = new Timer("halley_" + C46772bt.m88739c() + "_" + "ConnectionTimer", true);
    /* renamed from: c */
    private Map<Runnable, TimerTask> f3188c = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(98653);
        AppMethodBeat.m2505o(98653);
    }

    /* renamed from: a */
    public static C16215cm m24715a() {
        return f3186a;
    }

    /* renamed from: a */
    private void m24716a(Runnable runnable, boolean z, long j) {
        AppMethodBeat.m2504i(98651);
        synchronized (runnable) {
            try {
                mo29267a(runnable);
                C31032cn c31032cn = new C31032cn(this, runnable);
                if (z) {
                    this.f3187b.schedule(c31032cn, j, j);
                } else {
                    this.f3187b.schedule(c31032cn, j);
                }
                this.f3188c.put(runnable, c31032cn);
            } finally {
                AppMethodBeat.m2505o(98651);
            }
        }
    }

    /* renamed from: a */
    public final void mo29266a(Runnable runnable, long j) {
        AppMethodBeat.m2504i(98649);
        m24716a(runnable, false, j);
        AppMethodBeat.m2505o(98649);
    }

    /* renamed from: a */
    public final boolean mo29267a(Runnable runnable) {
        boolean cancel;
        AppMethodBeat.m2504i(98652);
        synchronized (runnable) {
            try {
                TimerTask timerTask = (TimerTask) this.f3188c.get(runnable);
                if (timerTask != null) {
                    this.f3188c.remove(runnable);
                    cancel = timerTask.cancel();
                } else {
                    AppMethodBeat.m2505o(98652);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98652);
            }
        }
        return cancel;
    }

    /* renamed from: b */
    public final void mo29268b(Runnable runnable, long j) {
        AppMethodBeat.m2504i(98650);
        m24716a(runnable, true, j);
        AppMethodBeat.m2505o(98650);
    }

    private C16215cm() {
        AppMethodBeat.m2504i(98648);
        AppMethodBeat.m2505o(98648);
    }
}
