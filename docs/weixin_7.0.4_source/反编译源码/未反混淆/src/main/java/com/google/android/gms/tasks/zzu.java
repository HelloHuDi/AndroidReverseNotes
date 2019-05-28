package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzu<TResult> extends Task<TResult> {
    private final Object mLock = new Object();
    private final zzr<TResult> zzage = new zzr();
    @GuardedBy("mLock")
    private boolean zzagf;
    @GuardedBy("mLock")
    private TResult zzagg;
    @GuardedBy("mLock")
    private Exception zzagh;
    private volatile boolean zzfi;

    static class zza extends LifecycleCallback {
        private final List<WeakReference<zzq<?>>> zzagi = new ArrayList();

        private zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            AppMethodBeat.i(57414);
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
            AppMethodBeat.o(57414);
        }

        public static zza zze(Activity activity) {
            AppMethodBeat.i(57413);
            LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
            zza zza = (zza) fragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
            if (zza == null) {
                zza = new zza(fragment);
            }
            AppMethodBeat.o(57413);
            return zza;
        }

        public void onStop() {
            AppMethodBeat.i(57416);
            synchronized (this.zzagi) {
                try {
                    for (WeakReference weakReference : this.zzagi) {
                        zzq zzq = (zzq) weakReference.get();
                        if (zzq != null) {
                            zzq.cancel();
                        }
                    }
                    this.zzagi.clear();
                } finally {
                    AppMethodBeat.o(57416);
                }
            }
        }

        public final <T> void zzb(zzq<T> zzq) {
            AppMethodBeat.i(57415);
            synchronized (this.zzagi) {
                try {
                    this.zzagi.add(new WeakReference(zzq));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57415);
                }
            }
        }
    }

    zzu() {
        AppMethodBeat.i(57417);
        AppMethodBeat.o(57417);
    }

    @GuardedBy("mLock")
    private final void zzdq() {
        AppMethodBeat.i(57443);
        Preconditions.checkState(this.zzagf, "Task is not yet complete");
        AppMethodBeat.o(57443);
    }

    @GuardedBy("mLock")
    private final void zzdr() {
        AppMethodBeat.i(57444);
        Preconditions.checkState(!this.zzagf, "Task is already complete");
        AppMethodBeat.o(57444);
    }

    @GuardedBy("mLock")
    private final void zzds() {
        AppMethodBeat.i(57445);
        if (this.zzfi) {
            CancellationException cancellationException = new CancellationException("Task is already canceled.");
            AppMethodBeat.o(57445);
            throw cancellationException;
        }
        AppMethodBeat.o(57445);
    }

    private final void zzdt() {
        AppMethodBeat.i(57446);
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    this.zzage.zza((Task) this);
                    AppMethodBeat.o(57446);
                    return;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57446);
            }
        }
    }

    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(57434);
        zzq zzg = new zzg(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.zzage.zza(zzg);
        zza.zze(activity).zzb(zzg);
        zzdt();
        AppMethodBeat.o(57434);
        return this;
    }

    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(57432);
        Task addOnCanceledListener = addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        AppMethodBeat.o(57432);
        return addOnCanceledListener;
    }

    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        AppMethodBeat.i(57433);
        this.zzage.zza(new zzg(executor, onCanceledListener));
        zzdt();
        AppMethodBeat.o(57433);
        return this;
    }

    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(57428);
        zzq zzi = new zzi(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzage.zza(zzi);
        zza.zze(activity).zzb(zzi);
        zzdt();
        AppMethodBeat.o(57428);
        return this;
    }

    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(57426);
        Task addOnCompleteListener = addOnCompleteListener(TaskExecutors.MAIN_THREAD, (OnCompleteListener) onCompleteListener);
        AppMethodBeat.o(57426);
        return addOnCompleteListener;
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.i(57427);
        this.zzage.zza(new zzi(executor, onCompleteListener));
        zzdt();
        AppMethodBeat.o(57427);
        return this;
    }

    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        AppMethodBeat.i(57425);
        zzq zzk = new zzk(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzage.zza(zzk);
        zza.zze(activity).zzb(zzk);
        zzdt();
        AppMethodBeat.o(57425);
        return this;
    }

    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        AppMethodBeat.i(57423);
        Task addOnFailureListener = addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        AppMethodBeat.o(57423);
        return addOnFailureListener;
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        AppMethodBeat.i(57424);
        this.zzage.zza(new zzk(executor, onFailureListener));
        zzdt();
        AppMethodBeat.o(57424);
        return this;
    }

    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.i(57422);
        zzq zzm = new zzm(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzage.zza(zzm);
        zza.zze(activity).zzb(zzm);
        zzdt();
        AppMethodBeat.o(57422);
        return this;
    }

    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.i(57420);
        Task addOnSuccessListener = addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener) onSuccessListener);
        AppMethodBeat.o(57420);
        return addOnSuccessListener;
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.i(57421);
        this.zzage.zza(new zzm(executor, onSuccessListener));
        zzdt();
        AppMethodBeat.o(57421);
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        AppMethodBeat.i(57429);
        Task continueWith = continueWith(TaskExecutors.MAIN_THREAD, continuation);
        AppMethodBeat.o(57429);
        return continueWith;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        AppMethodBeat.i(57430);
        zzu zzu = new zzu();
        this.zzage.zza(new zzc(executor, continuation, zzu));
        zzdt();
        AppMethodBeat.o(57430);
        return zzu;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        AppMethodBeat.i(57431);
        Task continueWithTask = continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
        AppMethodBeat.o(57431);
        return continueWithTask;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        AppMethodBeat.i(57435);
        zzu zzu = new zzu();
        this.zzage.zza(new zze(executor, continuation, zzu));
        zzdt();
        AppMethodBeat.o(57435);
        return zzu;
    }

    public final Exception getException() {
        Exception exception;
        synchronized (this.mLock) {
            exception = this.zzagh;
        }
        return exception;
    }

    public final TResult getResult() {
        Object runtimeExecutionException;
        AppMethodBeat.i(57418);
        synchronized (this.mLock) {
            try {
                zzdq();
                zzds();
                if (this.zzagh != null) {
                    runtimeExecutionException = new RuntimeExecutionException(this.zzagh);
                    throw runtimeExecutionException;
                }
                runtimeExecutionException = this.zzagg;
            } finally {
                AppMethodBeat.o(57418);
            }
        }
        AppMethodBeat.o(57418);
        return runtimeExecutionException;
    }

    public final <X extends Throwable> TResult getResult(Class<X> cls) {
        Object obj;
        AppMethodBeat.i(57419);
        synchronized (this.mLock) {
            try {
                zzdq();
                zzds();
                if (cls.isInstance(this.zzagh)) {
                    Throwable th = (Throwable) cls.cast(this.zzagh);
                    throw th;
                } else if (this.zzagh != null) {
                    RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(this.zzagh);
                    AppMethodBeat.o(57419);
                    throw runtimeExecutionException;
                } else {
                    obj = this.zzagg;
                }
            } finally {
                AppMethodBeat.o(57419);
            }
        }
        AppMethodBeat.o(57419);
        return obj;
    }

    public final boolean isCanceled() {
        return this.zzfi;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzagf;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzagf && !this.zzfi && this.zzagh == null;
        }
        return z;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        AppMethodBeat.i(57437);
        Task onSuccessTask = onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
        AppMethodBeat.o(57437);
        return onSuccessTask;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        AppMethodBeat.i(57436);
        zzu zzu = new zzu();
        this.zzage.zza(new zzo(executor, successContinuation, zzu));
        zzdt();
        AppMethodBeat.o(57436);
        return zzu;
    }

    public final void setException(Exception exception) {
        AppMethodBeat.i(57440);
        Preconditions.checkNotNull(exception, "Exception must not be null");
        synchronized (this.mLock) {
            try {
                zzdr();
                this.zzagf = true;
                this.zzagh = exception;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57440);
            }
        }
        this.zzage.zza((Task) this);
    }

    public final void setResult(TResult tResult) {
        AppMethodBeat.i(57438);
        synchronized (this.mLock) {
            try {
                zzdr();
                this.zzagf = true;
                this.zzagg = tResult;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57438);
            }
        }
        this.zzage.zza((Task) this);
    }

    public final boolean trySetException(Exception exception) {
        boolean z = true;
        AppMethodBeat.i(57441);
        Preconditions.checkNotNull(exception, "Exception must not be null");
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    z = false;
                } else {
                    this.zzagf = true;
                    this.zzagh = exception;
                    this.zzage.zza((Task) this);
                    AppMethodBeat.o(57441);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57441);
            }
        }
        return z;
    }

    public final boolean trySetResult(TResult tResult) {
        boolean z = true;
        AppMethodBeat.i(57439);
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    z = false;
                } else {
                    this.zzagf = true;
                    this.zzagg = tResult;
                    this.zzage.zza((Task) this);
                    AppMethodBeat.o(57439);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57439);
            }
        }
        return z;
    }

    public final boolean zzdp() {
        boolean z = true;
        AppMethodBeat.i(57442);
        synchronized (this.mLock) {
            try {
                if (this.zzagf) {
                    z = false;
                } else {
                    this.zzagf = true;
                    this.zzfi = true;
                    this.zzage.zza((Task) this);
                    AppMethodBeat.o(57442);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57442);
            }
        }
        return z;
    }
}
