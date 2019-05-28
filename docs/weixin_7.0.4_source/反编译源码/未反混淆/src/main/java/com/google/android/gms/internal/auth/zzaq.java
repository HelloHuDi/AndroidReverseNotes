package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaq extends zzam {
    private final /* synthetic */ zzap zzds;

    zzaq(zzap zzap) {
        this.zzds = zzap;
    }

    public final void zzd(Status status, Credential credential) {
        AppMethodBeat.i(50479);
        this.zzds.setResult(new zzan(status, credential));
        AppMethodBeat.o(50479);
    }

    public final void zze(Status status) {
        AppMethodBeat.i(50480);
        this.zzds.setResult(zzan.zzf(status));
        AppMethodBeat.o(50480);
    }
}
