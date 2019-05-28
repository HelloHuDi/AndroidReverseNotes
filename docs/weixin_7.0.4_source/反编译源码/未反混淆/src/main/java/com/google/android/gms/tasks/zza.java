package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends CancellationToken {
    private final zzu<Void> zzafh = new zzu();

    zza() {
        AppMethodBeat.i(57376);
        AppMethodBeat.o(57376);
    }

    public final void cancel() {
        AppMethodBeat.i(57379);
        this.zzafh.trySetResult(null);
        AppMethodBeat.o(57379);
    }

    public final boolean isCancellationRequested() {
        AppMethodBeat.i(57377);
        boolean isComplete = this.zzafh.isComplete();
        AppMethodBeat.o(57377);
        return isComplete;
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        AppMethodBeat.i(57378);
        this.zzafh.addOnSuccessListener(new zzb(this, onTokenCanceledListener));
        AppMethodBeat.o(57378);
        return this;
    }
}
