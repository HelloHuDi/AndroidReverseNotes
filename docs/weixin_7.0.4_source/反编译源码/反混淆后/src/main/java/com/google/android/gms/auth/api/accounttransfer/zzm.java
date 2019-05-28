package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends zzf {
    private final /* synthetic */ zzae zzbf;

    zzm(AccountTransferClient accountTransferClient, zzae zzae) {
        this.zzbf = zzae;
        super();
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(zzac zzac) {
        AppMethodBeat.m2504i(77000);
        zzac.zzd(this.zzbi, this.zzbf);
        AppMethodBeat.m2505o(77000);
    }
}
