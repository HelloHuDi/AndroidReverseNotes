package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzo<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zzafk;
    private final zzu<TContinuationResult> zzafm;
    private final SuccessContinuation<TResult, TContinuationResult> zzafy;

    public zzo(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafy = successContinuation;
        this.zzafm = zzu;
    }

    public final void cancel() {
        AppMethodBeat.i(57403);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(57403);
        throw unsupportedOperationException;
    }

    public final void onCanceled() {
        AppMethodBeat.i(57406);
        this.zzafm.zzdp();
        AppMethodBeat.o(57406);
    }

    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(57402);
        this.zzafk.execute(new zzp(this, task));
        AppMethodBeat.o(57402);
    }

    public final void onFailure(Exception exception) {
        AppMethodBeat.i(57405);
        this.zzafm.setException(exception);
        AppMethodBeat.o(57405);
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        AppMethodBeat.i(57404);
        this.zzafm.setResult(tContinuationResult);
        AppMethodBeat.o(57404);
    }
}
