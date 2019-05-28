package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends CancellationToken {
    private final zzu<Void> zzafh = new zzu();

    zza() {
        AppMethodBeat.m2504i(57376);
        AppMethodBeat.m2505o(57376);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(57379);
        this.zzafh.trySetResult(null);
        AppMethodBeat.m2505o(57379);
    }

    public final boolean isCancellationRequested() {
        AppMethodBeat.m2504i(57377);
        boolean isComplete = this.zzafh.isComplete();
        AppMethodBeat.m2505o(57377);
        return isComplete;
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        AppMethodBeat.m2504i(57378);
        this.zzafh.addOnSuccessListener(new zzb(this, onTokenCanceledListener));
        AppMethodBeat.m2505o(57378);
        return this;
    }
}
