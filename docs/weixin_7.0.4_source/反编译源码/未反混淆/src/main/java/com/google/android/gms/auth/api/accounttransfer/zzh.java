package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzag;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh extends zze<byte[]> {
    private final /* synthetic */ zzag zzba;

    zzh(AccountTransferClient accountTransferClient, zzag zzag) {
        this.zzba = zzag;
        super();
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(zzac zzac) {
        AppMethodBeat.i(76995);
        zzac.zzd(new zzi(this, this), this.zzba);
        AppMethodBeat.o(76995);
    }
}
