package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbo<O extends ApiOptions> extends zzaf {
    private final GoogleApi<O> zzks;

    public zzbo(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zzks = googleApi;
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(60843);
        ApiMethodImpl doRead = this.zzks.doRead((ApiMethodImpl) t);
        AppMethodBeat.o(60843);
        return doRead;
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(60844);
        ApiMethodImpl doWrite = this.zzks.doWrite((ApiMethodImpl) t);
        AppMethodBeat.o(60844);
        return doWrite;
    }

    public final Context getContext() {
        AppMethodBeat.i(60846);
        Context applicationContext = this.zzks.getApplicationContext();
        AppMethodBeat.o(60846);
        return applicationContext;
    }

    public final Looper getLooper() {
        AppMethodBeat.i(60845);
        Looper looper = this.zzks.getLooper();
        AppMethodBeat.o(60845);
        return looper;
    }

    public final void zza(zzch zzch) {
    }

    public final void zzb(zzch zzch) {
    }
}
