package com.google.android.gms.auth.api.accounttransfer;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf extends AbstractClientBuilder<zzx, zzq> {
    zzf() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(76993);
        zzx zzx = new zzx(context, looper, clientSettings, (zzq) obj, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.o(76993);
        return zzx;
    }
}
