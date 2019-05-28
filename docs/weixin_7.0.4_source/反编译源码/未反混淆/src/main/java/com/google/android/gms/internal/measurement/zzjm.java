package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjm {
    private long startTime;
    private final Clock zzro;

    public zzjm(Clock clock) {
        AppMethodBeat.i(69396);
        Preconditions.checkNotNull(clock);
        this.zzro = clock;
        AppMethodBeat.o(69396);
    }

    public final void clear() {
        this.startTime = 0;
    }

    public final void start() {
        AppMethodBeat.i(69397);
        this.startTime = this.zzro.elapsedRealtime();
        AppMethodBeat.o(69397);
    }

    public final boolean zzj(long j) {
        AppMethodBeat.i(69398);
        if (this.startTime == 0) {
            AppMethodBeat.o(69398);
            return true;
        } else if (this.zzro.elapsedRealtime() - this.startTime >= 3600000) {
            AppMethodBeat.o(69398);
            return true;
        } else {
            AppMethodBeat.o(69398);
            return false;
        }
    }
}
