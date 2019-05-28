package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zze<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zzafk;
    private final Continuation<TResult, Task<TContinuationResult>> zzafl;
    private final zzu<TContinuationResult> zzafm;

    public zze(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafl = continuation;
        this.zzafm = zzu;
    }

    public final void cancel() {
        AppMethodBeat.i(57388);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(57388);
        throw unsupportedOperationException;
    }

    public final void onCanceled() {
        AppMethodBeat.i(57387);
        this.zzafm.zzdp();
        AppMethodBeat.o(57387);
    }

    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(57384);
        this.zzafk.execute(new zzf(this, task));
        AppMethodBeat.o(57384);
    }

    public final void onFailure(Exception exception) {
        AppMethodBeat.i(57386);
        this.zzafm.setException(exception);
        AppMethodBeat.o(57386);
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        AppMethodBeat.i(57385);
        this.zzafm.setResult(tContinuationResult);
        AppMethodBeat.o(57385);
    }
}
