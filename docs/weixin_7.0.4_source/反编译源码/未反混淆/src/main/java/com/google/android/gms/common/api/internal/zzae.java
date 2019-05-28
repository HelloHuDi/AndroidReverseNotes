package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzae {
    private final zzh<?> zzhc;
    private final TaskCompletionSource<Boolean> zzhd = new TaskCompletionSource();

    public zzae(zzh<?> zzh) {
        AppMethodBeat.i(60693);
        this.zzhc = zzh;
        AppMethodBeat.o(60693);
    }

    public final TaskCompletionSource<Boolean> zzao() {
        return this.zzhd;
    }

    public final zzh<?> zzm() {
        return this.zzhc;
    }
}
