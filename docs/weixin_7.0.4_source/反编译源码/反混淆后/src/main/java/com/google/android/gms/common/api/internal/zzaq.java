package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.BaseSignInCallbacks;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzaq extends BaseSignInCallbacks {
    private final WeakReference<zzaj> zzhw;

    zzaq(zzaj zzaj) {
        AppMethodBeat.m2504i(60756);
        this.zzhw = new WeakReference(zzaj);
        AppMethodBeat.m2505o(60756);
    }

    public final void onSignInComplete(SignInResponse signInResponse) {
        AppMethodBeat.m2504i(60757);
        zzaj zzaj = (zzaj) this.zzhw.get();
        if (zzaj == null) {
            AppMethodBeat.m2505o(60757);
            return;
        }
        zzaj.zzhf.zza(new zzar(this, zzaj, zzaj, signInResponse));
        AppMethodBeat.m2505o(60757);
    }
}
