package com.tencent.tencentmap.mapsdk.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ag;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class b {
    public static boolean a = true;
    private static b b;

    static class a extends b {
        private ScheduledExecutorService b;
        private SparseArray<ScheduledFuture<?>> c;

        public a() {
            AppMethodBeat.i(97764);
            this.b = null;
            this.c = null;
            this.b = Executors.newScheduledThreadPool(3);
            this.c = new SparseArray();
            AppMethodBeat.o(97764);
        }

        public final synchronized void a(Runnable runnable) {
            AppMethodBeat.i(97765);
            if (runnable == null) {
                ag.d("task runner should not be null", new Object[0]);
                AppMethodBeat.o(97765);
            } else {
                this.b.execute(runnable);
                AppMethodBeat.o(97765);
            }
        }

        public final synchronized void a(int i, Runnable runnable, long j, long j2) {
            long j3 = 0;
            synchronized (this) {
                AppMethodBeat.i(97766);
                if (runnable == null) {
                    ag.d("task runner should not be null", new Object[0]);
                    AppMethodBeat.o(97766);
                } else {
                    long j4;
                    if (j > 0) {
                        j3 = j;
                    }
                    if (a) {
                        if (j2 <= 10000) {
                            j2 = 10000;
                        }
                        j4 = j2;
                    } else {
                        j4 = j2;
                    }
                    a(i);
                    ScheduledFuture scheduleAtFixedRate = this.b.scheduleAtFixedRate(runnable, j3, j4, TimeUnit.MILLISECONDS);
                    if (scheduleAtFixedRate != null) {
                        ag.b("add a new future! taskId: %d , periodTime: %d", Integer.valueOf(i), Long.valueOf(j4));
                        this.c.put(i, scheduleAtFixedRate);
                    }
                    AppMethodBeat.o(97766);
                }
            }
        }

        public final synchronized void a(int i) {
            AppMethodBeat.i(97767);
            ScheduledFuture scheduledFuture = (ScheduledFuture) this.c.get(i);
            if (!(scheduledFuture == null || scheduledFuture.isCancelled())) {
                ag.b("cancel a old future!", new Object[0]);
                scheduledFuture.cancel(true);
            }
            this.c.remove(i);
            AppMethodBeat.o(97767);
        }

        public final synchronized void a(Runnable runnable, long j) {
            AppMethodBeat.i(97768);
            if (runnable == null) {
                ag.d("task runner should not be null", new Object[0]);
                AppMethodBeat.o(97768);
            } else {
                if (j <= 0) {
                    j = 0;
                }
                this.b.schedule(runnable, j, TimeUnit.MILLISECONDS);
                AppMethodBeat.o(97768);
            }
        }
    }

    public abstract void a(int i);

    public abstract void a(int i, Runnable runnable, long j, long j2);

    public abstract void a(Runnable runnable);

    public abstract void a(Runnable runnable, long j);

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new a();
            }
            bVar = b;
        }
        return bVar;
    }
}
