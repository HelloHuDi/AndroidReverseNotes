package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzv;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn extends zzv {
    private final /* synthetic */ zzf zzbj;

    zzn(zzf zzf) {
        this.zzbj = zzf;
    }

    public final void onFailure(Status status) {
        AppMethodBeat.i(77002);
        this.zzbj.zzd(status);
        AppMethodBeat.o(77002);
    }

    public final void zzi() {
        AppMethodBeat.i(77001);
        this.zzbj.setResult(null);
        AppMethodBeat.o(77001);
    }
}
