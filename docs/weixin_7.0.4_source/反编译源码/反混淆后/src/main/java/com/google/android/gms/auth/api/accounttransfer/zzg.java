package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzai;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg extends zzf {
    private final /* synthetic */ zzai zzaz;

    zzg(AccountTransferClient accountTransferClient, zzai zzai) {
        this.zzaz = zzai;
        super();
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(zzac zzac) {
        AppMethodBeat.m2504i(76994);
        zzac.zzd(this.zzbi, this.zzaz);
        AppMethodBeat.m2505o(76994);
    }
}
