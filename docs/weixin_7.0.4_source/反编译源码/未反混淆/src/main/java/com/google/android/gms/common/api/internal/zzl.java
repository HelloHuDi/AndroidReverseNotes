package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl {
    private final int zzet;
    private final ConnectionResult zzeu;

    zzl(ConnectionResult connectionResult, int i) {
        AppMethodBeat.i(60939);
        Preconditions.checkNotNull(connectionResult);
        this.zzeu = connectionResult;
        this.zzet = i;
        AppMethodBeat.o(60939);
    }

    /* Access modifiers changed, original: final */
    public final ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    /* Access modifiers changed, original: final */
    public final int zzu() {
        return this.zzet;
    }
}
