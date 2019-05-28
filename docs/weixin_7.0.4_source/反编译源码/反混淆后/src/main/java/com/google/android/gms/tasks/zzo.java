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
        AppMethodBeat.m2504i(57403);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(57403);
        throw unsupportedOperationException;
    }

    public final void onCanceled() {
        AppMethodBeat.m2504i(57406);
        this.zzafm.zzdp();
        AppMethodBeat.m2505o(57406);
    }

    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.m2504i(57402);
        this.zzafk.execute(new zzp(this, task));
        AppMethodBeat.m2505o(57402);
    }

    public final void onFailure(Exception exception) {
        AppMethodBeat.m2504i(57405);
        this.zzafm.setException(exception);
        AppMethodBeat.m2505o(57405);
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        AppMethodBeat.m2504i(57404);
        this.zzafm.setResult(tContinuationResult);
        AppMethodBeat.m2505o(57404);
    }
}
