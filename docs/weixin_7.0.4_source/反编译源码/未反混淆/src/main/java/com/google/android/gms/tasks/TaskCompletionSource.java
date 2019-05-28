package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskCompletionSource<TResult> {
    private final zzu<TResult> zzafh = new zzu();

    public TaskCompletionSource() {
        AppMethodBeat.i(57341);
        AppMethodBeat.o(57341);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        AppMethodBeat.i(57342);
        cancellationToken.onCanceledRequested(new zzs(this));
        AppMethodBeat.o(57342);
    }

    public Task<TResult> getTask() {
        return this.zzafh;
    }

    public void setException(Exception exception) {
        AppMethodBeat.i(57345);
        this.zzafh.setException(exception);
        AppMethodBeat.o(57345);
    }

    public void setResult(TResult tResult) {
        AppMethodBeat.i(57343);
        this.zzafh.setResult(tResult);
        AppMethodBeat.o(57343);
    }

    public boolean trySetException(Exception exception) {
        AppMethodBeat.i(57346);
        boolean trySetException = this.zzafh.trySetException(exception);
        AppMethodBeat.o(57346);
        return trySetException;
    }

    public boolean trySetResult(TResult tResult) {
        AppMethodBeat.i(57344);
        boolean trySetResult = this.zzafh.trySetResult(tResult);
        AppMethodBeat.o(57344);
        return trySetResult;
    }
}
