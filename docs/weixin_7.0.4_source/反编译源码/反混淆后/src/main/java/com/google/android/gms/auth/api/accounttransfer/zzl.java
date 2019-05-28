package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzak;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl extends zzf {
    private final /* synthetic */ zzak zzbe;

    zzl(AccountTransferClient accountTransferClient, zzak zzak) {
        this.zzbe = zzak;
        super();
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(zzac zzac) {
        AppMethodBeat.m2504i(76999);
        zzac.zzd(this.zzbi, this.zzbe);
        AppMethodBeat.m2505o(76999);
    }
}
