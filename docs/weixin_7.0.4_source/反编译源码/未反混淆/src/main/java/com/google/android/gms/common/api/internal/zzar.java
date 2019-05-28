package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzar extends zzbe {
    private final /* synthetic */ zzaj zzic;
    private final /* synthetic */ SignInResponse zzid;

    zzar(zzaq zzaq, zzbc zzbc, zzaj zzaj, SignInResponse signInResponse) {
        this.zzic = zzaj;
        this.zzid = signInResponse;
        super(zzbc);
    }

    public final void zzaq() {
        AppMethodBeat.i(60758);
        zzaj.zza(this.zzic, this.zzid);
        AppMethodBeat.o(60758);
    }
}
