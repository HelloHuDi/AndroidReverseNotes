package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzbh;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg extends AbstractClientBuilder<zzbh, zzh> {
    zzg() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(77053);
        zzbh zzbh = new zzbh(context, looper, clientSettings, (zzh) obj, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.o(77053);
        return zzbh;
    }
}
