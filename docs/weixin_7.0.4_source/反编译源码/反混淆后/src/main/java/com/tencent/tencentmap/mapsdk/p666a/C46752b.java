package com.tencent.tencentmap.mapsdk.p666a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16205ag;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.tencentmap.mapsdk.a.b */
public abstract class C46752b {
    /* renamed from: a */
    public static boolean f18032a = true;
    /* renamed from: b */
    private static C46752b f18033b;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.b$a */
    static class C5836a extends C46752b {
        /* renamed from: b */
        private ScheduledExecutorService f1436b;
        /* renamed from: c */
        private SparseArray<ScheduledFuture<?>> f1437c;

        public C5836a() {
            AppMethodBeat.m2504i(97764);
            this.f1436b = null;
            this.f1437c = null;
            this.f1436b = Executors.newScheduledThreadPool(3);
            this.f1437c = new SparseArray();
            AppMethodBeat.m2505o(97764);
        }

        /* renamed from: a */
        public final synchronized void mo12298a(Runnable runnable) {
            AppMethodBeat.m2504i(97765);
            if (runnable == null) {
                C16205ag.m24687d("task runner should not be null", new Object[0]);
                AppMethodBeat.m2505o(97765);
            } else {
                this.f1436b.execute(runnable);
                AppMethodBeat.m2505o(97765);
            }
        }

        /* renamed from: a */
        public final synchronized void mo12297a(int i, Runnable runnable, long j, long j2) {
            long j3 = 0;
            synchronized (this) {
                AppMethodBeat.m2504i(97766);
                if (runnable == null) {
                    C16205ag.m24687d("task runner should not be null", new Object[0]);
                    AppMethodBeat.m2505o(97766);
                } else {
                    long j4;
                    if (j > 0) {
                        j3 = j;
                    }
                    if (f18032a) {
                        if (j2 <= 10000) {
                            j2 = 10000;
                        }
                        j4 = j2;
                    } else {
                        j4 = j2;
                    }
                    mo12296a(i);
                    ScheduledFuture scheduleAtFixedRate = this.f1436b.scheduleAtFixedRate(runnable, j3, j4, TimeUnit.MILLISECONDS);
                    if (scheduleAtFixedRate != null) {
                        C16205ag.m24685b("add a new future! taskId: %d , periodTime: %d", Integer.valueOf(i), Long.valueOf(j4));
                        this.f1437c.put(i, scheduleAtFixedRate);
                    }
                    AppMethodBeat.m2505o(97766);
                }
            }
        }

        /* renamed from: a */
        public final synchronized void mo12296a(int i) {
            AppMethodBeat.m2504i(97767);
            ScheduledFuture scheduledFuture = (ScheduledFuture) this.f1437c.get(i);
            if (!(scheduledFuture == null || scheduledFuture.isCancelled())) {
                C16205ag.m24685b("cancel a old future!", new Object[0]);
                scheduledFuture.cancel(true);
            }
            this.f1437c.remove(i);
            AppMethodBeat.m2505o(97767);
        }

        /* renamed from: a */
        public final synchronized void mo12299a(Runnable runnable, long j) {
            AppMethodBeat.m2504i(97768);
            if (runnable == null) {
                C16205ag.m24687d("task runner should not be null", new Object[0]);
                AppMethodBeat.m2505o(97768);
            } else {
                if (j <= 0) {
                    j = 0;
                }
                this.f1436b.schedule(runnable, j, TimeUnit.MILLISECONDS);
                AppMethodBeat.m2505o(97768);
            }
        }
    }

    /* renamed from: a */
    public abstract void mo12296a(int i);

    /* renamed from: a */
    public abstract void mo12297a(int i, Runnable runnable, long j, long j2);

    /* renamed from: a */
    public abstract void mo12298a(Runnable runnable);

    /* renamed from: a */
    public abstract void mo12299a(Runnable runnable, long j);

    /* renamed from: a */
    public static synchronized C46752b m88622a() {
        C46752b c46752b;
        synchronized (C46752b.class) {
            if (f18033b == null) {
                f18033b = new C5836a();
            }
            c46752b = f18033b;
        }
        return c46752b;
    }
}
