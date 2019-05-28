package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn extends zzq {
    private final /* synthetic */ zzm zzah;

    zzn(zzm zzm) {
        this.zzah = zzm;
    }

    public final void zzf(Account account) {
        AppMethodBeat.m2504i(77139);
        this.zzah.setResult(new zzr(account != null ? Status.RESULT_SUCCESS : zzk.zzaf, account));
        AppMethodBeat.m2505o(77139);
    }
}
