package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk extends zzd {
    private final /* synthetic */ zzj zzex;

    zzk(zzj zzj) {
        this.zzex = zzj;
    }

    public final void zzd(GoogleSignInAccount googleSignInAccount, Status status) {
        AppMethodBeat.i(50446);
        if (googleSignInAccount != null) {
            zzq.zze(this.zzex.val$context).zzd(this.zzex.zzew, googleSignInAccount);
        }
        this.zzex.setResult(new GoogleSignInResult(googleSignInAccount, status));
        AppMethodBeat.o(50446);
    }
}
