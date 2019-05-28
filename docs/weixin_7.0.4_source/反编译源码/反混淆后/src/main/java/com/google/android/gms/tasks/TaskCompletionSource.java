package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskCompletionSource<TResult> {
    private final zzu<TResult> zzafh = new zzu();

    public TaskCompletionSource() {
        AppMethodBeat.m2504i(57341);
        AppMethodBeat.m2505o(57341);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        AppMethodBeat.m2504i(57342);
        cancellationToken.onCanceledRequested(new zzs(this));
        AppMethodBeat.m2505o(57342);
    }

    public Task<TResult> getTask() {
        return this.zzafh;
    }

    public void setException(Exception exception) {
        AppMethodBeat.m2504i(57345);
        this.zzafh.setException(exception);
        AppMethodBeat.m2505o(57345);
    }

    public void setResult(TResult tResult) {
        AppMethodBeat.m2504i(57343);
        this.zzafh.setResult(tResult);
        AppMethodBeat.m2505o(57343);
    }

    public boolean trySetException(Exception exception) {
        AppMethodBeat.m2504i(57346);
        boolean trySetException = this.zzafh.trySetException(exception);
        AppMethodBeat.m2505o(57346);
        return trySetException;
    }

    public boolean trySetResult(TResult tResult) {
        AppMethodBeat.m2504i(57344);
        boolean trySetResult = this.zzafh.trySetResult(tResult);
        AppMethodBeat.m2505o(57344);
        return trySetResult;
    }
}
