package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzy;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj extends zze<DeviceMetaData> {
    private final /* synthetic */ zzy zzbc;

    zzj(AccountTransferClient accountTransferClient, zzy zzy) {
        this.zzbc = zzy;
        super();
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(zzac zzac) {
        AppMethodBeat.m2504i(76997);
        zzac.zzd(new zzk(this, this), this.zzbc);
        AppMethodBeat.m2505o(76997);
    }
}
