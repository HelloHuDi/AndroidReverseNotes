package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgg extends zzhh {
    private static final AtomicLong zzalx = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzaln;
    private zzgk zzalo;
    private zzgk zzalp;
    private final PriorityBlockingQueue<zzgj<?>> zzalq = new PriorityBlockingQueue();
    private final BlockingQueue<zzgj<?>> zzalr = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler zzals = new zzgi(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler zzalt = new zzgi(this, "Thread death: Uncaught exception on network thread");
    private final Object zzalu = new Object();
    private final Semaphore zzalv = new Semaphore(2);
    private volatile boolean zzalw;

    static {
        AppMethodBeat.m2504i(69052);
        AppMethodBeat.m2505o(69052);
    }

    zzgg(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.m2504i(69023);
        AppMethodBeat.m2505o(69023);
    }

    public static boolean isMainThread() {
        AppMethodBeat.m2504i(69026);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.m2505o(69026);
            return true;
        }
        AppMethodBeat.m2505o(69026);
        return false;
    }

    private final void zza(zzgj<?> zzgj) {
        AppMethodBeat.m2504i(69032);
        synchronized (this.zzalu) {
            try {
                this.zzalq.add(zzgj);
                if (this.zzalo == null) {
                    this.zzalo = new zzgk(this, "Measurement Worker", this.zzalq);
                    this.zzalo.setUncaughtExceptionHandler(this.zzals);
                    this.zzalo.start();
                } else {
                    this.zzalo.zzjn();
                }
            } finally {
                AppMethodBeat.m2505o(69032);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(69043);
        Context context = super.getContext();
        AppMethodBeat.m2505o(69043);
        return context;
    }

    /* Access modifiers changed, original: final */
    public final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        String valueOf;
        AppMethodBeat.m2504i(69031);
        synchronized (atomicReference) {
            try {
                zzgd().zzc(runnable);
                atomicReference.wait(15000);
            } catch (InterruptedException e) {
                zzfi zzip = zzge().zzip();
                String str2 = "Interrupted waiting for ";
                valueOf = String.valueOf(str);
                zzip.log(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                AppMethodBeat.m2505o(69031);
                return null;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(69031);
                throw th;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzfi zzip2 = zzge().zzip();
            String str3 = "Timed out waiting for ";
            valueOf = String.valueOf(str);
            zzip2.log(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        AppMethodBeat.m2505o(69031);
        return t;
    }

    public final void zzab() {
        AppMethodBeat.m2504i(69024);
        if (Thread.currentThread() != this.zzalo) {
            IllegalStateException illegalStateException = new IllegalStateException("Call expected from worker thread");
            AppMethodBeat.m2505o(69024);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(69024);
    }

    public final <V> Future<V> zzb(Callable<V> callable) {
        AppMethodBeat.m2504i(69028);
        zzch();
        Preconditions.checkNotNull(callable);
        zzgj zzgj = new zzgj(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalo) {
            if (!this.zzalq.isEmpty()) {
                zzge().zzip().log("Callable skipped the worker queue.");
            }
            zzgj.run();
        } else {
            zza(zzgj);
        }
        AppMethodBeat.m2505o(69028);
        return zzgj;
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(69042);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(69042);
        return zzbt;
    }

    public final <V> Future<V> zzc(Callable<V> callable) {
        AppMethodBeat.m2504i(69029);
        zzch();
        Preconditions.checkNotNull(callable);
        zzgj zzgj = new zzgj(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzalo) {
            zzgj.run();
        } else {
            zza(zzgj);
        }
        AppMethodBeat.m2505o(69029);
        return zzgj;
    }

    public final void zzc(Runnable runnable) {
        AppMethodBeat.m2504i(69030);
        zzch();
        Preconditions.checkNotNull(runnable);
        zza(new zzgj(this, runnable, false, "Task exception on worker thread"));
        AppMethodBeat.m2505o(69030);
    }

    public final void zzd(Runnable runnable) {
        AppMethodBeat.m2504i(69033);
        zzch();
        Preconditions.checkNotNull(runnable);
        zzgj zzgj = new zzgj(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzalu) {
            try {
                this.zzalr.add(zzgj);
                if (this.zzalp == null) {
                    this.zzalp = new zzgk(this, "Measurement Network", this.zzalr);
                    this.zzalp.setUncaughtExceptionHandler(this.zzalt);
                    this.zzalp.start();
                } else {
                    this.zzalp.zzjn();
                }
            } finally {
                AppMethodBeat.m2505o(69033);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(69035);
        super.zzfr();
        AppMethodBeat.m2505o(69035);
    }

    public final void zzfs() {
        AppMethodBeat.m2504i(69025);
        if (Thread.currentThread() != this.zzalp) {
            IllegalStateException illegalStateException = new IllegalStateException("Call expected from network thread");
            AppMethodBeat.m2505o(69025);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(69025);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(69036);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(69036);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(69037);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(69037);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(69038);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(69038);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(69039);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(69039);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(69040);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(69040);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(69041);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(69041);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(69044);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(69044);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(69045);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(69045);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(69046);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(69046);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(69047);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(69047);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(69048);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(69048);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(69049);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(69049);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(69050);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(69050);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(69051);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(69051);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    public final boolean zzjk() {
        AppMethodBeat.m2504i(69027);
        if (Thread.currentThread() == this.zzalo) {
            AppMethodBeat.m2505o(69027);
            return true;
        }
        AppMethodBeat.m2505o(69027);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final ExecutorService zzjl() {
        ExecutorService executorService;
        AppMethodBeat.m2504i(69034);
        synchronized (this.zzalu) {
            try {
                if (this.zzaln == null) {
                    this.zzaln = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                }
                executorService = this.zzaln;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69034);
            }
        }
        return executorService;
    }
}
