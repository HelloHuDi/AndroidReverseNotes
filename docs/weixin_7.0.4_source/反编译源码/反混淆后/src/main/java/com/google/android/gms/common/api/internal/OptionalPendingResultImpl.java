package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final BasePendingResult<R> zzlo;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        AppMethodBeat.m2504i(60650);
        this.zzlo = (BasePendingResult) pendingResult;
        AppMethodBeat.m2505o(60650);
    }

    public final void addStatusListener(StatusListener statusListener) {
        AppMethodBeat.m2504i(60659);
        this.zzlo.addStatusListener(statusListener);
        AppMethodBeat.m2505o(60659);
    }

    public final R await() {
        AppMethodBeat.m2504i(60653);
        Result await = this.zzlo.await();
        AppMethodBeat.m2505o(60653);
        return await;
    }

    public final R await(long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(60654);
        Result await = this.zzlo.await(j, timeUnit);
        AppMethodBeat.m2505o(60654);
        return await;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(60655);
        this.zzlo.cancel();
        AppMethodBeat.m2505o(60655);
    }

    public final R get() {
        AppMethodBeat.m2504i(60652);
        if (isDone()) {
            Result await = await(0, TimeUnit.MILLISECONDS);
            AppMethodBeat.m2505o(60652);
            return await;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        AppMethodBeat.m2505o(60652);
        throw illegalStateException;
    }

    public final boolean isCanceled() {
        AppMethodBeat.m2504i(60656);
        boolean isCanceled = this.zzlo.isCanceled();
        AppMethodBeat.m2505o(60656);
        return isCanceled;
    }

    public final boolean isDone() {
        AppMethodBeat.m2504i(60651);
        boolean isReady = this.zzlo.isReady();
        AppMethodBeat.m2505o(60651);
        return isReady;
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        AppMethodBeat.m2504i(60657);
        this.zzlo.setResultCallback(resultCallback);
        AppMethodBeat.m2505o(60657);
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(60658);
        this.zzlo.setResultCallback(resultCallback, j, timeUnit);
        AppMethodBeat.m2505o(60658);
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        AppMethodBeat.m2504i(60660);
        TransformedResult then = this.zzlo.then(resultTransform);
        AppMethodBeat.m2505o(60660);
        return then;
    }

    public final Integer zzo() {
        AppMethodBeat.m2504i(60661);
        Integer zzo = this.zzlo.zzo();
        AppMethodBeat.m2505o(60661);
        return zzo;
    }
}
