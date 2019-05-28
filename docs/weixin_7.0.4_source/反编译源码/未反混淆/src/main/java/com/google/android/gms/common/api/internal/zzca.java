package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzca implements Runnable {
    private final /* synthetic */ SignInResponse zzid;
    private final /* synthetic */ zzby zzlx;

    zzca(zzby zzby, SignInResponse signInResponse) {
        this.zzlx = zzby;
        this.zzid = signInResponse;
    }

    public final void run() {
        AppMethodBeat.i(60874);
        zzby.zza(this.zzlx, this.zzid);
        AppMethodBeat.o(60874);
    }
}
