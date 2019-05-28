package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class zzau implements zzbc {
    private final zzbd zzhf;

    public zzau(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    public final void begin() {
        AppMethodBeat.i(60761);
        for (Client disconnect : this.zzhf.zzil.values()) {
            disconnect.disconnect();
        }
        this.zzhf.zzfq.zzim = Collections.emptySet();
        AppMethodBeat.o(60761);
    }

    public final void connect() {
        AppMethodBeat.i(60764);
        this.zzhf.zzbc();
        AppMethodBeat.o(60764);
    }

    public final boolean disconnect() {
        return true;
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(60762);
        this.zzhf.zzfq.zzgo.add(t);
        AppMethodBeat.o(60762);
        return t;
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(60763);
        IllegalStateException illegalStateException = new IllegalStateException("GoogleApiClient is not connected yet.");
        AppMethodBeat.o(60763);
        throw illegalStateException;
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
