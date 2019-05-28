package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp extends zzq {
    private final /* synthetic */ zzo zzai;

    zzp(zzo zzo) {
        this.zzai = zzo;
    }

    public final void zzd(boolean z) {
        AppMethodBeat.i(77142);
        this.zzai.setResult(new zzt(z ? Status.RESULT_SUCCESS : zzk.zzaf));
        AppMethodBeat.o(77142);
    }
}
