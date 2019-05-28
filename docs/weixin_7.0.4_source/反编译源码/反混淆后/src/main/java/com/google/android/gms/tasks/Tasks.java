package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public final class Tasks {

    interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    static final class zza implements zzb {
        private final CountDownLatch zzfd;

        private zza() {
            AppMethodBeat.m2504i(57350);
            this.zzfd = new CountDownLatch(1);
            AppMethodBeat.m2505o(57350);
        }

        /* synthetic */ zza(zzv zzv) {
            this();
        }

        public final void await() {
            AppMethodBeat.m2504i(57354);
            this.zzfd.await();
            AppMethodBeat.m2505o(57354);
        }

        public final boolean await(long j, TimeUnit timeUnit) {
            AppMethodBeat.m2504i(57355);
            boolean await = this.zzfd.await(j, timeUnit);
            AppMethodBeat.m2505o(57355);
            return await;
        }

        public final void onCanceled() {
            AppMethodBeat.m2504i(57353);
            this.zzfd.countDown();
            AppMethodBeat.m2505o(57353);
        }

        public final void onFailure(Exception exception) {
            AppMethodBeat.m2504i(57352);
            this.zzfd.countDown();
            AppMethodBeat.m2505o(57352);
        }

        public final void onSuccess(Object obj) {
            AppMethodBeat.m2504i(57351);
            this.zzfd.countDown();
            AppMethodBeat.m2505o(57351);
        }
    }

    static final class zzc implements zzb {
        private final Object mLock = new Object();
        private final zzu<Void> zzafh;
        @GuardedBy("mLock")
        private Exception zzagh;
        private final int zzagl;
        @GuardedBy("mLock")
        private int zzagm;
        @GuardedBy("mLock")
        private int zzagn;
        @GuardedBy("mLock")
        private int zzago;
        @GuardedBy("mLock")
        private boolean zzagp;

        public zzc(int i, zzu<Void> zzu) {
            AppMethodBeat.m2504i(57356);
            this.zzagl = i;
            this.zzafh = zzu;
            AppMethodBeat.m2505o(57356);
        }

        @GuardedBy("mLock")
        private final void zzdu() {
            AppMethodBeat.m2504i(57360);
            if ((this.zzagm + this.zzagn) + this.zzago == this.zzagl) {
                if (this.zzagh != null) {
                    zzu zzu = this.zzafh;
                    int i = this.zzagn;
                    zzu.setException(new ExecutionException(i + " out of " + this.zzagl + " underlying tasks failed", this.zzagh));
                    AppMethodBeat.m2505o(57360);
                    return;
                } else if (this.zzagp) {
                    this.zzafh.zzdp();
                    AppMethodBeat.m2505o(57360);
                    return;
                } else {
                    this.zzafh.setResult(null);
                }
            }
            AppMethodBeat.m2505o(57360);
        }

        public final void onCanceled() {
            AppMethodBeat.m2504i(57359);
            synchronized (this.mLock) {
                try {
                    this.zzago++;
                    this.zzagp = true;
                    zzdu();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57359);
                }
            }
        }

        public final void onFailure(Exception exception) {
            AppMethodBeat.m2504i(57357);
            synchronized (this.mLock) {
                try {
                    this.zzagn++;
                    this.zzagh = exception;
                    zzdu();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57357);
                }
            }
        }

        public final void onSuccess(Object obj) {
            AppMethodBeat.m2504i(57358);
            synchronized (this.mLock) {
                try {
                    this.zzagm++;
                    zzdu();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57358);
                }
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(Task<TResult> task) {
        AppMethodBeat.m2504i(57366);
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Object zzb;
        if (task.isComplete()) {
            zzb = zzb(task);
            AppMethodBeat.m2505o(57366);
            return zzb;
        }
        zza zza = new zza();
        zza(task, zza);
        zza.await();
        zzb = zzb(task);
        AppMethodBeat.m2505o(57366);
        return zzb;
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(57367);
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        Object zzb;
        if (task.isComplete()) {
            zzb = zzb(task);
            AppMethodBeat.m2505o(57367);
            return zzb;
        }
        zza zza = new zza();
        zza(task, zza);
        if (zza.await(j, timeUnit)) {
            zzb = zzb(task);
            AppMethodBeat.m2505o(57367);
            return zzb;
        }
        TimeoutException timeoutException = new TimeoutException("Timed out waiting for Task");
        AppMethodBeat.m2505o(57367);
        throw timeoutException;
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        AppMethodBeat.m2504i(57364);
        Task call = call(TaskExecutors.MAIN_THREAD, callable);
        AppMethodBeat.m2505o(57364);
        return call;
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        AppMethodBeat.m2504i(57365);
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu = new zzu();
        executor.execute(new zzv(zzu, callable));
        AppMethodBeat.m2505o(57365);
        return zzu;
    }

    public static <TResult> Task<TResult> forCanceled() {
        AppMethodBeat.m2504i(57363);
        zzu zzu = new zzu();
        zzu.zzdp();
        AppMethodBeat.m2505o(57363);
        return zzu;
    }

    public static <TResult> Task<TResult> forException(Exception exception) {
        AppMethodBeat.m2504i(57362);
        zzu zzu = new zzu();
        zzu.setException(exception);
        AppMethodBeat.m2505o(57362);
        return zzu;
    }

    public static <TResult> Task<TResult> forResult(TResult tResult) {
        AppMethodBeat.m2504i(57361);
        zzu zzu = new zzu();
        zzu.setResult(tResult);
        AppMethodBeat.m2505o(57361);
        return zzu;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        AppMethodBeat.m2504i(57368);
        Task forResult;
        if (collection.isEmpty()) {
            forResult = forResult(null);
            AppMethodBeat.m2505o(57368);
            return forResult;
        }
        for (Task forResult2 : collection) {
            if (forResult2 == null) {
                NullPointerException nullPointerException = new NullPointerException("null tasks are not accepted");
                AppMethodBeat.m2505o(57368);
                throw nullPointerException;
            }
        }
        Task zzu = new zzu();
        zzc zzc = new zzc(collection.size(), zzu);
        for (Task forResult22 : collection) {
            zza(forResult22, zzc);
        }
        AppMethodBeat.m2505o(57368);
        return zzu;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        AppMethodBeat.m2504i(57369);
        Task forResult;
        if (taskArr.length == 0) {
            forResult = forResult(null);
            AppMethodBeat.m2505o(57369);
            return forResult;
        }
        forResult = whenAll(Arrays.asList(taskArr));
        AppMethodBeat.m2505o(57369);
        return forResult;
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        AppMethodBeat.m2504i(57372);
        Task continueWithTask = whenAll((Collection) collection).continueWithTask(new zzx(collection));
        AppMethodBeat.m2505o(57372);
        return continueWithTask;
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        AppMethodBeat.m2504i(57373);
        Task whenAllComplete = whenAllComplete(Arrays.asList(taskArr));
        AppMethodBeat.m2505o(57373);
        return whenAllComplete;
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        AppMethodBeat.m2504i(57370);
        Task continueWith = whenAll((Collection) collection).continueWith(new zzw(collection));
        AppMethodBeat.m2505o(57370);
        return continueWith;
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        AppMethodBeat.m2504i(57371);
        Task whenAllSuccess = whenAllSuccess(Arrays.asList(taskArr));
        AppMethodBeat.m2505o(57371);
        return whenAllSuccess;
    }

    private static void zza(Task<?> task, zzb zzb) {
        AppMethodBeat.m2504i(57375);
        task.addOnSuccessListener(TaskExecutors.zzagd, (OnSuccessListener) zzb);
        task.addOnFailureListener(TaskExecutors.zzagd, (OnFailureListener) zzb);
        task.addOnCanceledListener(TaskExecutors.zzagd, (OnCanceledListener) zzb);
        AppMethodBeat.m2505o(57375);
    }

    private static <TResult> TResult zzb(Task<TResult> task) {
        AppMethodBeat.m2504i(57374);
        if (task.isSuccessful()) {
            Object result = task.getResult();
            AppMethodBeat.m2505o(57374);
            return result;
        } else if (task.isCanceled()) {
            CancellationException cancellationException = new CancellationException("Task is already canceled");
            AppMethodBeat.m2505o(57374);
            throw cancellationException;
        } else {
            ExecutionException executionException = new ExecutionException(task.getException());
            AppMethodBeat.m2505o(57374);
            throw executionException;
        }
    }
}
