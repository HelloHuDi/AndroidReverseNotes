package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CancellationTokenSource {
    private final zza zzafj = new zza();

    public CancellationTokenSource() {
        AppMethodBeat.i(57339);
        AppMethodBeat.o(57339);
    }

    public void cancel() {
        AppMethodBeat.i(57340);
        this.zzafj.cancel();
        AppMethodBeat.o(57340);
    }

    public CancellationToken getToken() {
        return this.zzafj;
    }
}
