package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcl implements zzcn {
    private final /* synthetic */ zzck zzmq;

    zzcl(zzck zzck) {
        this.zzmq = zzck;
    }

    public final void zzc(BasePendingResult<?> basePendingResult) {
        AppMethodBeat.i(60896);
        this.zzmq.zzmo.remove(basePendingResult);
        AppMethodBeat.o(60896);
    }
}
